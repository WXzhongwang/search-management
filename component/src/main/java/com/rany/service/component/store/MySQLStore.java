package com.rany.service.component.store;

import com.rany.service.common.constants.Constants;
import com.rany.service.common.constants.TableColumnNameConstant;
import com.rany.service.common.exception.ErrorCodeEnum;
import com.rany.service.common.exception.SearchManagementException;
import com.rany.service.component.IMetaStorage;
import com.rany.service.component.meta.dto.ClusterMetaData;
import com.rany.service.component.meta.dto.IndexMetaData;
import com.rany.service.component.meta.dto.IndexTemplateMetaData;
import com.rany.service.component.meta.dto.ProjectMetaData;
import com.rany.service.platform.DataTypeUtils;
import com.rany.service.platform.meta.AutoIndexRollingPolicy;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * MySQLStore
 *
 * @author zhongshengwang
 * @description MySQLStore mysql
 * @date 2022/4/2 11:39 下午
 * @email 18668485565@163.com
 */

public class MySQLStore implements IMetaStorage {

    private final JdbcTemplate jdbcTemplate;
    private final String clusterMetaTableName;
    private final String projectMetaTableName;
    private final String indexMetaTableName;
    private final String indexTemplateTableName;

    public MySQLStore(JdbcTemplate jdbcTemplate, String metaStoreEnv) {
        this.jdbcTemplate = jdbcTemplate;
        clusterMetaTableName = metaStoreEnv + Constants.Table.CLUSTER_TABLE_NAME_SUFFIX;
        projectMetaTableName = metaStoreEnv + Constants.Table.PROJECT_TABLE_NAME_SUFFIX;
        indexTemplateTableName = metaStoreEnv + Constants.Table.INDEX_TEMPLATE_TABLE_NAME_SUFFIX;
        indexMetaTableName = metaStoreEnv + Constants.Table.INDEX_TABLE_NAME_SUFFIX;
    }

    @Override
    public String getMetaStoreAddress() {
        return Objects.requireNonNull(jdbcTemplate.getDataSource()).toString();
    }

    @Override
    public void checkHealth() {
        String command = String.format("select * from %s", clusterMetaTableName);
        try {
            jdbcTemplate.execute(command);
        } catch (DataAccessException e) {
            throw new SearchManagementException(ErrorCodeEnum.MYSQL_INTERNAL_ERROR.getCode(), e.getMessage());
        }
    }

    @Override
    public void setupTables() {
        {
            // cluster table
            try {
                String command = String.format(
                        "CREATE TABLE IF NOT EXISTS %s ( \n" +
                                "%s VARCHAR(256) PRIMARY KEY NOT NULL, \n" +
                                "%s VARCHAR(64) NOT NULL, \n" +
                                "%s VARCHAR(64) NOT NULL, \n" +
                                "%s VARCHAR(1024), \n" +
                                "%s VARCHAR(1024) NOT NULL, \n" +
                                "%s VARCHAR(1024) NOT NULL, \n" +
                                "%s DATETIME NOT NULL, \n" +
                                "%s DATETIME NOT NULL \n" +
                                ")",
                        clusterMetaTableName,
                        TableColumnNameConstant.Cluster.CLUSTER_META_TABLE_PK_NAME,
                        TableColumnNameConstant.Cluster.COLUMN_CLUSTER_STATUS,
                        TableColumnNameConstant.Cluster.COLUMN_CLUSTER_TYPE,
                        TableColumnNameConstant.Cluster.COLUMN_DESCRIPTION,
                        TableColumnNameConstant.Cluster.COLUMN_INTERNAL_ENDPOINT,
                        TableColumnNameConstant.Cluster.COLUMN_SERVICE_ENDPOINT,
                        TableColumnNameConstant.Cluster.COLUMN_CREATE_TIME,
                        TableColumnNameConstant.Cluster.COLUMN_LAST_UPDATE_TIME);
                jdbcTemplate.execute(command);
            } catch (Exception e) {
                System.out.println(String.format("Fail to create meta tables with message: %s.", e.getMessage()));
            }
        }
        {
            // project
            try {
                String command = String.format(
                        "CREATE TABLE IF NOT EXISTS %s ( \n" +
                                "%s VARCHAR(256) PRIMARY KEY NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(1024), \n" +
                                "%s text, \n" +
                                "%s DATETIME NOT NULL, \n" +
                                "%s DATETIME NOT NULL \n" +
                                ")",
                        projectMetaTableName,
                        TableColumnNameConstant.Project.PROJECT_META_TABLE_PK_NAME,
                        TableColumnNameConstant.Project.PROJECT_META_TABLE_CLUSTER_NAME,
                        TableColumnNameConstant.Project.COLUMN_DESCRIPTION,
                        TableColumnNameConstant.Project.COLUMN_SETTING,
                        TableColumnNameConstant.Project.COLUMN_CREATE_TIME,
                        TableColumnNameConstant.Project.COLUMN_LAST_UPDATE_TIME);
                jdbcTemplate.execute(command);
            } catch (Exception e) {
                System.out.println(String.format("Fail to create meta tables with message: %s.", e.getMessage()));
            }
        }
        {
            // index template
            try {
                String command = String.format(
                        "CREATE TABLE IF NOT EXISTS %s ( \n" +
                                "%s VARCHAR(256) PRIMARY KEY NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(64) NOT NULL, \n" +
                                "%s INT NOT NULL, \n" +
                                "%s TEXT(65536), \n" +
                                "%s TEXT(65536), \n" +
                                "%s DATETIME NOT NULL, \n" +
                                "%s DATETIME NOT NULL \n" +
                                ")",
                        indexTemplateTableName,
                        TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PK_NAME,
                        TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PROJECT_NAME,
                        TableColumnNameConstant.IndexTemplate.COLUMN_ALIAS,
                        TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_NAME_PREFIX,
                        TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_POLICY,
                        TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_WINDOW,
                        TableColumnNameConstant.IndexTemplate.COLUMN_MAPPINGS,
                        TableColumnNameConstant.IndexTemplate.COLUMN_SETTINGS,
                        TableColumnNameConstant.IndexTemplate.COLUMN_CREATE_TIME,
                        TableColumnNameConstant.IndexTemplate.COLUMN_LAST_UPDATE_TIME);
                jdbcTemplate.execute(command);
            } catch (Exception e) {
                System.out.println(String.format("Fail to create meta tables with message: %s.", e.getMessage()));
            }
        }

        {
            // index
            try {
                String command = String.format(
                        "CREATE TABLE IF NOT EXISTS %s ( \n" +
                                "%s VARCHAR(256) PRIMARY KEY NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s BOOLEAN NOT NULL, \n" +
                                "%s VARCHAR(256) NOT NULL, \n" +
                                "%s DATETIME NOT NULL, \n" +
                                "%s DATETIME NOT NULL \n" +
                                ")",
                        indexMetaTableName,
                        TableColumnNameConstant.Index.INDEX_META_TABLE_PK_NAME,
                        TableColumnNameConstant.Index.INDEX_META_TABLE_NAME,
                        TableColumnNameConstant.Index.INDEX_META_TABLE_PROJECT_NAME,
                        TableColumnNameConstant.Index.INDEX_META_TABLE_TEMPLATE_NAME,
                        TableColumnNameConstant.Index.COLUMN_INDEX_LEGACY_FLAG,
                        TableColumnNameConstant.Index.COLUMN_INDEX_TAGS,
                        TableColumnNameConstant.Index.COLUMN_CREATE_TIME,
                        TableColumnNameConstant.Index.COLUMN_LAST_UPDATE_TIME);
                jdbcTemplate.execute(command);
            } catch (Exception e) {
                System.out.println(String.format("Fail to create meta tables with message: %s.", e.getMessage()));
            }
        }
    }

    @Override
    public List<ClusterMetaData> loadAllMeta() {
        List<ClusterMetaData> clusterMetas = loadClusterMetas();
        // 集群
        for (ClusterMetaData clusterMeta : clusterMetas) {
            List<ProjectMetaData> projectMetaList = loadProjectMeta(clusterMeta.clusterName);
            // 项目
            for (ProjectMetaData projectMetaData : projectMetaList) {
                List<IndexTemplateMetaData> indexTemplateMetas = loadIndexTemplateMeta(projectMetaData.projectName);
                // 模板
                for (IndexTemplateMetaData templateMeta : indexTemplateMetas) {
                    List<IndexMetaData> indexMetaList = loadIndexMeta(projectMetaData.projectName, templateMeta.templateName);
                    for (IndexMetaData indexMeta : indexMetaList) {
                        templateMeta.indexMetas.put(indexMeta.name, indexMeta);
                    }
                    projectMetaData.indexTemplateMetaData.put(templateMeta.templateName, templateMeta);
                }
                clusterMeta.projectMetaMap.put(projectMetaData.projectName, projectMetaData);
            }
        }
        return clusterMetas;
    }

    @Override
    public void insertIndex(IndexMetaData indexMetaData) {
        String command = String.format(
                "insert into %s (%s, %s, %s, %s, %s, %s, %s, %s) values (?, ?, ?, ?, ?, ?, ?, ?)",
                indexMetaTableName,
                TableColumnNameConstant.Index.INDEX_META_TABLE_PK_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_PROJECT_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_TEMPLATE_NAME,
                TableColumnNameConstant.Index.COLUMN_INDEX_LEGACY_FLAG,
                TableColumnNameConstant.Index.COLUMN_INDEX_TAGS,
                TableColumnNameConstant.Index.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Index.COLUMN_LAST_UPDATE_TIME);

        try {
            jdbcTemplate.update(
                    command,
                    indexMetaData.fullName,
                    indexMetaData.name,
                    indexMetaData.projectName,
                    indexMetaData.templateName,
                    indexMetaData.legacy,
                    StringUtils.isEmpty(indexMetaData.tags) ? "" : indexMetaData.tags,
                    indexMetaData.gmtCreate,
                    indexMetaData.gmtModified);
        } catch (Exception exception) {
            System.out.println(exception.getStackTrace());
        }
    }

    public void deleteIndex(String projectName, String templateName, String indexName) {
        String command = String.format("delete from %s where %s=\"%s\" and %s=\"%s\" and %s=\"%s\"", indexMetaTableName,
                TableColumnNameConstant.Index.INDEX_META_TABLE_PK_NAME,
                indexName,
                TableColumnNameConstant.Index.INDEX_META_TABLE_PROJECT_NAME,
                projectName,
                TableColumnNameConstant.Index.INDEX_META_TABLE_TEMPLATE_NAME,
                templateName);
        jdbcTemplate.execute(command);
    }

    @Override
    public void updateIndex(IndexMetaData indexMetaData) {
        LocalDateTime localDateTime = indexMetaData.gmtModified.toLocalDateTime();
        String updateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String command = String.format("update %s set ", indexMetaTableName);
        command += String.format(" %s=\"%s\" ", TableColumnNameConstant.Index.COLUMN_LAST_UPDATE_TIME, updateTime);
        if (StringUtils.isNotEmpty(indexMetaData.tags)) {
            command += String.format(" ,%s=? ", TableColumnNameConstant.Index.COLUMN_INDEX_TAGS);
        }
        command += String.format(" where %s=\"%s\"",
                TableColumnNameConstant.Index.INDEX_META_TABLE_PK_NAME,
                indexMetaData.projectName + "." + indexMetaData.templateName + "." + indexMetaData.name);
        jdbcTemplate.update(
                command,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        if (StringUtils.isNotEmpty(indexMetaData.tags)) {
                            preparedStatement.setString(1, indexMetaData.tags);
                        }
                    }
                }
        );
    }

    @Override
    public void insertCluster(ClusterMetaData clusterMetaData) {
        String command = String.format(
                "insert into %s (%s, %s, %s, %s, %s, %s, %s, %s) values (?, ?, ?, ?, ?, ?, ?, ?)",
                clusterMetaTableName,
                TableColumnNameConstant.Cluster.CLUSTER_META_TABLE_PK_NAME,
                TableColumnNameConstant.Cluster.COLUMN_CLUSTER_STATUS,
                TableColumnNameConstant.Cluster.COLUMN_CLUSTER_TYPE,
                TableColumnNameConstant.Cluster.COLUMN_DESCRIPTION,
                TableColumnNameConstant.Cluster.COLUMN_INTERNAL_ENDPOINT,
                TableColumnNameConstant.Cluster.COLUMN_SERVICE_ENDPOINT,
                TableColumnNameConstant.Cluster.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Cluster.COLUMN_LAST_UPDATE_TIME
        );
        jdbcTemplate.update(
                command,
                clusterMetaData.clusterName,
                clusterMetaData.clusterStatus.name(),
                clusterMetaData.clusterType.name(),
                clusterMetaData.clusterDesc,
                clusterMetaData.clusterInternalAddress,
                clusterMetaData.clusterAddress,
                clusterMetaData.gmtCreate,
                clusterMetaData.gmtModified);
    }

    @Override
    public void updateCluster(ClusterMetaData clusterMetaData) {
        LocalDateTime localDateTime = clusterMetaData.gmtModified.toLocalDateTime();
        String updateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String command = String.format("update %s set ", clusterMetaTableName);
        command += String.format(" %s='%s' ", TableColumnNameConstant.Cluster.COLUMN_LAST_UPDATE_TIME, updateTime);
        if (clusterMetaData.clusterStatus != null) {
            command += String.format(" ,%s=? ", TableColumnNameConstant.Cluster.COLUMN_CLUSTER_STATUS);
        }
        if (clusterMetaData.clusterDesc != null) {
            command += String.format(" ,%s=? ", TableColumnNameConstant.Cluster.COLUMN_DESCRIPTION);
        }
        if (clusterMetaData.clusterInternalAddress != null) {
            command += String.format(" ,%s=? ", TableColumnNameConstant.Cluster.COLUMN_INTERNAL_ENDPOINT);
        }
        command += String.format(" where %s=\"%s\"", TableColumnNameConstant.Cluster.CLUSTER_META_TABLE_PK_NAME, clusterMetaData.clusterName);
        jdbcTemplate.update(
                command,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        int parameterIndex = 1;
                        if (clusterMetaData.clusterStatus != null) {
                            preparedStatement.setString(parameterIndex++, clusterMetaData.clusterStatus.name());
                        }
                        if (clusterMetaData.clusterDesc != null) {
                            preparedStatement.setString(parameterIndex++, clusterMetaData.clusterDesc);
                        }
                        if (clusterMetaData.clusterInternalAddress != null) {
                            preparedStatement.setString(parameterIndex++, clusterMetaData.clusterInternalAddress);
                        }
                    }
                }
        );
    }

    @Override
    public void deleteCluster(String clusterName) {
        String command = String.format("delete from %s where %s=\"%s\"",
                clusterMetaTableName,
                TableColumnNameConstant.Cluster.CLUSTER_META_TABLE_PK_NAME,
                clusterName);
        jdbcTemplate.execute(command);
    }

    @Override
    public void insertProject(ProjectMetaData projectMetaData) {
        String command = String.format(
                "insert into %s (%s, %s, %s, %s, %s, %s) values (?, ?, ?, ?, ?, ?)",
                projectMetaTableName,
                TableColumnNameConstant.Project.PROJECT_META_TABLE_PK_NAME,
                TableColumnNameConstant.Project.PROJECT_META_TABLE_CLUSTER_NAME,
                TableColumnNameConstant.Project.COLUMN_DESCRIPTION,
                TableColumnNameConstant.Project.COLUMN_SETTING,
                TableColumnNameConstant.Project.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Project.COLUMN_LAST_UPDATE_TIME);
        jdbcTemplate.update(
                command,
                projectMetaData.projectName,
                projectMetaData.clusterName,
                projectMetaData.projectDesc,
                projectMetaData.projectSetting,
                projectMetaData.gmtCreate,
                projectMetaData.gmtModified);
    }

    @Override
    public void updateProject(ProjectMetaData projectMetaData) {
        LocalDateTime localDateTime = projectMetaData.gmtModified.toLocalDateTime();
        String updateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String command = String.format("update %s set ", projectMetaTableName);
        command += String.format(" %s='%s' ", TableColumnNameConstant.Project.COLUMN_LAST_UPDATE_TIME, updateTime);
        if (projectMetaData.projectDesc != null) {
            command += String.format(" ,%s=? ", TableColumnNameConstant.Project.COLUMN_DESCRIPTION);
        }
        if (projectMetaData.projectSetting != null) {
            command += String.format(" ,%s=? ", TableColumnNameConstant.Project.COLUMN_SETTING);
        }
        command += String.format(" where %s=\"%s\"", TableColumnNameConstant.Project.PROJECT_META_TABLE_PK_NAME,
                projectMetaData.projectName);
        jdbcTemplate.update(
                command,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        int parameterIndex = 1;
                        if (projectMetaData.projectDesc != null) {
                            preparedStatement.setString(parameterIndex++, projectMetaData.projectDesc);
                        }
                        if (projectMetaData.projectSetting != null) {
                            preparedStatement.setString(parameterIndex++, projectMetaData.projectSetting);
                        }
                    }
                }
        );
    }


    @Override
    public void deleteProject(String clusterName, String projectName) {
        String command = String.format("delete from %s where %s=\"%s\"",
                projectMetaTableName,
                TableColumnNameConstant.Project.PROJECT_META_TABLE_PK_NAME,
                projectName);
        jdbcTemplate.update(command);
    }

    @Override
    public void insertIndexTemplate(IndexTemplateMetaData indexTemplateMetaData) {
        StringBuilder aliasListString = new StringBuilder();
        for (int i = 0; i < indexTemplateMetaData.aliasList.size(); ++i) {
            if (i != 0) {
                aliasListString.append("@");
            }
            aliasListString.append(indexTemplateMetaData.aliasList.get(i));
        }
        String command = String.format(
                "insert into %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                indexTemplateTableName,
                TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PK_NAME,
                TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PROJECT_NAME,
                TableColumnNameConstant.IndexTemplate.COLUMN_MAPPINGS,
                TableColumnNameConstant.IndexTemplate.COLUMN_SETTINGS,
                TableColumnNameConstant.IndexTemplate.COLUMN_ALIAS,
                TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_POLICY,
                TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_WINDOW,
                TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_NAME_PREFIX,
                TableColumnNameConstant.IndexTemplate.COLUMN_CREATE_TIME,
                TableColumnNameConstant.IndexTemplate.COLUMN_LAST_UPDATE_TIME);
        jdbcTemplate.update(
                command,
                indexTemplateMetaData.templateName,
                indexTemplateMetaData.projectName,
                indexTemplateMetaData.mappings,
                indexTemplateMetaData.settings,
                aliasListString.toString(),
                indexTemplateMetaData.autoIndexRollingPolicy.toString(),
                indexTemplateMetaData.autoIndexRollingWindow,
                indexTemplateMetaData.autoIndexNamePrefix,
                indexTemplateMetaData.gmtCreate,
                indexTemplateMetaData.gmtModified);
    }

    @Override
    public void updateIndexTemplate(IndexTemplateMetaData indexTemplateMetaData) {
        LocalDateTime localDateTime = indexTemplateMetaData.gmtModified.toLocalDateTime();
        String updateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String command = String.format("update %s set ", indexTemplateTableName);
        command += String.format(" %s='%s' ", TableColumnNameConstant.IndexTemplate.COLUMN_LAST_UPDATE_TIME, updateTime);
        if (indexTemplateMetaData.mappings != null) {
            command += String.format(" ,%s=?", TableColumnNameConstant.IndexTemplate.COLUMN_MAPPINGS);
        }
        if (indexTemplateMetaData.settings != null) {
            command += String.format(" ,%s=?", TableColumnNameConstant.IndexTemplate.COLUMN_SETTINGS);
        }
        if (indexTemplateMetaData.aliasList != null) {
            command += String.format(" ,%s=?", TableColumnNameConstant.IndexTemplate.COLUMN_ALIAS);
        }
        if (indexTemplateMetaData.autoIndexRollingPolicy != null) {
            command += String.format(" ,%s=?", TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_POLICY);
        }
        if (indexTemplateMetaData.autoIndexRollingWindow != null) {
            command += String.format(" ,%s=?", TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_WINDOW);
        }
        command += String.format(" where %s=\"%s\"", TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PK_NAME,
                indexTemplateMetaData.templateName);

        jdbcTemplate.update(
                command,
                new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement) throws SQLException {
                        int parameterIndex = 1;
                        if (indexTemplateMetaData.mappings != null) {
                            preparedStatement.setString(parameterIndex++, indexTemplateMetaData.mappings);
                        }
                        if (indexTemplateMetaData.settings != null) {
                            preparedStatement.setString(parameterIndex++, indexTemplateMetaData.settings);
                        }
                        if (indexTemplateMetaData.aliasList != null) {
                            StringBuffer aliasListString = new StringBuffer();
                            for (int i = 0; i < indexTemplateMetaData.aliasList.size(); ++i) {
                                if (i != 0) {
                                    aliasListString.append("@");
                                }
                                aliasListString.append(indexTemplateMetaData.aliasList.get(i));
                            }
                            preparedStatement.setString(parameterIndex++, aliasListString.toString());
                        }
                        if (indexTemplateMetaData.autoIndexRollingPolicy != null) {
                            preparedStatement.setString(parameterIndex++, indexTemplateMetaData.autoIndexRollingPolicy.toString());
                        }
                        if (indexTemplateMetaData.autoIndexRollingWindow != null) {
                            preparedStatement.setString(parameterIndex++, indexTemplateMetaData.autoIndexRollingWindow.toString());
                        }
                    }
                }
        );
    }


    @Override
    public void deleteIndexTemplate(String projectName, String templateName) {
        String command = String.format("delete from %s where %s=\"%s\"",
                indexTemplateTableName, TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PK_NAME,
                templateName);
        jdbcTemplate.update(command);
    }

    private List<ClusterMetaData> loadClusterMetas() {
        List<ClusterMetaData> result = new ArrayList<>();
        String command = String.format("select %s,%s,%s,%s,%s,%s,%s,%s from %s",
                TableColumnNameConstant.Cluster.CLUSTER_META_TABLE_PK_NAME,
                TableColumnNameConstant.Cluster.COLUMN_DESCRIPTION,
                TableColumnNameConstant.Cluster.COLUMN_CLUSTER_TYPE,
                TableColumnNameConstant.Cluster.COLUMN_CLUSTER_STATUS,
                TableColumnNameConstant.Cluster.COLUMN_INTERNAL_ENDPOINT,
                TableColumnNameConstant.Cluster.COLUMN_SERVICE_ENDPOINT,
                TableColumnNameConstant.Cluster.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Cluster.COLUMN_LAST_UPDATE_TIME,
                clusterMetaTableName);
        jdbcTemplate.query(command, resultSet -> {
            ClusterMetaData clusterMeta = new ClusterMetaData();
            clusterMeta.clusterName = resultSet.getString(1);
            clusterMeta.clusterDesc = resultSet.getString(2);
            clusterMeta.clusterType = DataTypeUtils.convertClusterType(resultSet.getString(3));
            clusterMeta.clusterStatus = DataTypeUtils.convertClusterStatus(resultSet.getString(4));
            clusterMeta.clusterInternalAddress = resultSet.getString(5);
            clusterMeta.clusterAddress = resultSet.getString(6);
            clusterMeta.gmtCreate = resultSet.getTimestamp(7);
            clusterMeta.gmtModified = resultSet.getTimestamp(8);


            clusterMeta.projectMetaMap = new HashMap<>();
            clusterMeta.esVersion = Constants.UNKNOWN;
            clusterMeta.clusterHealth = Constants.UNKNOWN;
            clusterMeta.nodeMetaList = new ArrayList<>();
            result.add(clusterMeta);
        });
        return result;
    }

    private List<ProjectMetaData> loadProjectMeta(String clusterName) {
        List<ProjectMetaData> result = new ArrayList<>();
        String command = String.format("select %s,%s,%s,%s,%s,%s from %s where %s = '%s'",
                TableColumnNameConstant.Project.PROJECT_META_TABLE_PK_NAME,
                TableColumnNameConstant.Project.PROJECT_META_TABLE_CLUSTER_NAME,
                TableColumnNameConstant.Project.COLUMN_DESCRIPTION,
                TableColumnNameConstant.Project.COLUMN_SETTING,
                TableColumnNameConstant.Project.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Project.COLUMN_LAST_UPDATE_TIME,
                projectMetaTableName,
                TableColumnNameConstant.Project.PROJECT_META_TABLE_CLUSTER_NAME,
                clusterName
        );
        jdbcTemplate.query(command, resultSet -> {
            ProjectMetaData projectMeta = new ProjectMetaData();
            projectMeta.projectName = resultSet.getString(1);
            projectMeta.clusterName = clusterName;
            projectMeta.projectDesc = resultSet.getString(3);
            projectMeta.projectSetting = resultSet.getString(4);
            projectMeta.gmtCreate = resultSet.getTimestamp(5);
            projectMeta.gmtModified = resultSet.getTimestamp(6);
            projectMeta.indexTemplateMetaData = new HashMap<>(7);
            result.add(projectMeta);
        });
        return result;
    }

    private List<IndexTemplateMetaData> loadIndexTemplateMeta(String projectName) {
        List<IndexTemplateMetaData> result = new ArrayList<>();
        String command = String.format("select %s,%s,%s,%s,%s,%s,%s,%s,%s,%s from %s where %s = '%s'",
                TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PK_NAME,
                TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PROJECT_NAME,
                TableColumnNameConstant.IndexTemplate.COLUMN_ALIAS,
                TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_NAME_PREFIX,
                TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_POLICY,
                TableColumnNameConstant.IndexTemplate.COLUMN_AUTO_INDEX_WINDOW,
                TableColumnNameConstant.IndexTemplate.COLUMN_MAPPINGS,
                TableColumnNameConstant.IndexTemplate.COLUMN_SETTINGS,
                TableColumnNameConstant.IndexTemplate.COLUMN_CREATE_TIME,
                TableColumnNameConstant.IndexTemplate.COLUMN_LAST_UPDATE_TIME,
                indexTemplateTableName,
                TableColumnNameConstant.IndexTemplate.INDEX_TEMPLATE_TABLE_PROJECT_NAME,
                projectName
        );
        jdbcTemplate.query(command, resultSet -> {
            IndexTemplateMetaData indexTemplateMetaData = new IndexTemplateMetaData();
            indexTemplateMetaData.templateName = resultSet.getString(1);
            indexTemplateMetaData.projectName = resultSet.getString(2);
            indexTemplateMetaData.aliasList = new ArrayList<>();
            String aliasListString = resultSet.getString(3);
            if (!aliasListString.isEmpty()) {
                String[] aliases = aliasListString.split("@");
                indexTemplateMetaData.aliasList.addAll(Arrays.asList(aliases));
            }
            indexTemplateMetaData.autoIndexNamePrefix = resultSet.getString(4);
            indexTemplateMetaData.autoIndexRollingPolicy = EnumUtils.getEnum(AutoIndexRollingPolicy.class, resultSet.getString(5));
            indexTemplateMetaData.autoIndexRollingWindow = resultSet.getInt(6);

            indexTemplateMetaData.mappings = resultSet.getString(7);
            indexTemplateMetaData.settings = resultSet.getString(8);

            indexTemplateMetaData.gmtCreate = resultSet.getTimestamp(9);
            indexTemplateMetaData.gmtModified = resultSet.getTimestamp(10);
            indexTemplateMetaData.indexMetas = new HashMap<>(8);
            result.add(indexTemplateMetaData);
        });
        return result;
    }

    private List<IndexMetaData> loadIndexMeta(String projectName, String templateName) {
        List<IndexMetaData> result = new ArrayList<>();
        String command = String.format("select %s,%s,%s,%s,%s,%s,%s,%s from %s where %s = '%s' and %s = '%s'",
                TableColumnNameConstant.Index.INDEX_META_TABLE_PK_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_PROJECT_NAME,
                TableColumnNameConstant.Index.INDEX_META_TABLE_TEMPLATE_NAME,
                TableColumnNameConstant.Index.COLUMN_INDEX_LEGACY_FLAG,
                TableColumnNameConstant.Index.COLUMN_INDEX_TAGS,
                TableColumnNameConstant.Index.COLUMN_CREATE_TIME,
                TableColumnNameConstant.Index.COLUMN_LAST_UPDATE_TIME,
                indexMetaTableName,
                TableColumnNameConstant.Index.INDEX_META_TABLE_PROJECT_NAME,
                projectName,
                TableColumnNameConstant.Index.INDEX_META_TABLE_TEMPLATE_NAME,
                templateName
        );
        jdbcTemplate.query(command, resultSet -> {
            IndexMetaData indexMeta = new IndexMetaData();
            indexMeta.fullName = resultSet.getString(1);
            indexMeta.name = resultSet.getString(2);
            indexMeta.projectName = resultSet.getString(3);
            indexMeta.templateName = resultSet.getString(4);
            indexMeta.legacy = resultSet.getBoolean(5);
            indexMeta.tags = resultSet.getString(6);
            indexMeta.gmtCreate = resultSet.getTimestamp(7);
            indexMeta.gmtModified = resultSet.getTimestamp(8);
            indexMeta.setting = "{}";   // give default values;
            indexMeta.mapping = "{}";   // give default values;
            if (indexMeta.legacy) {
                indexMeta.name = indexMeta.fullName;
            }
            indexMeta.aliases = new ArrayList<>();
            indexMeta.health = "";

            indexMeta.primaryShards = 0;
            indexMeta.replicaShards = 0;
            indexMeta.docs = 0;
            indexMeta.totalData = 0;
            
            result.add(indexMeta);
        });
        return result;
    }
}
