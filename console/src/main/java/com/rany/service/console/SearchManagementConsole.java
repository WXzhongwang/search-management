package com.rany.service.console;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import com.rany.service.client.AdminClient;
import com.rany.service.client.rpc.request.*;
import com.rany.service.platform.meta.*;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.rany.service.console.CommandConstants.*;

/**
 * TODO
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2023/8/22 21:47
 * @email 18668485565163.com
 */
public class SearchManagementConsole {
    private final AdminClient client;
    private final Completer completer;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java SearchManagementConsole ipAddress port\n");
            System.out.println("\t\tFor example: java SearchManagementConsole localhost 8080");
            System.exit(-1);
        }
        String serverAddrString = args[0];
        Set<String> serverHosts = new HashSet<>();
        if (serverAddrString.contains(":")) {
            serverHosts = Sets.newHashSet(serverAddrString.split(":"));
        } else {
            serverHosts.add(serverAddrString);
        }
        int serverPort = Integer.parseInt(args[1]);
        SearchManagementConsole console = new SearchManagementConsole(serverHosts, serverPort);
        LineReader reader = null;
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            reader = LineReaderBuilder.builder().terminal(terminal).completer(console.completer).build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                String line = null;
                try {
                    line = reader.readLine("[" + serverAddrString + ":" + serverPort + "] > ");
                } catch (Exception e) {
                }
                if (line == null) {
                    continue;
                }
                String parameterString = null;
                if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("quit")) {
                    System.exit(0);
                } else if (line.equalsIgnoreCase("help")) {
                    console.showHelp();
                } else {
                    if (line.contains(ADD_CLUSTER_CMD)) {
                        parameterString = line.substring(ADD_CLUSTER_CMD.length()).trim();
                        console.addCluster(parameterString);
                    } else if (line.contains(GET_CLUSTER_CMD)) {
                        parameterString = line.substring(GET_CLUSTER_CMD.length()).trim();
                        console.getCluster(parameterString);
                    } else if (line.contains(UPDATE_CLUSTER_CMD)) {
                        parameterString = line.substring(UPDATE_CLUSTER_CMD.length()).trim();
                        console.updateCluster(parameterString);
                    } else if (line.contains(LIST_CLUSTER_DETAILS_CMD)) {
                        console.listClusterDetails();
                    } else if (line.contains(LIST_CLUSTER_CMD)) {
                        console.listCluster();
                    } else if (line.contains(CREATE_PROJECT_CMD)) {
                        parameterString = line.substring(CREATE_PROJECT_CMD.length()).trim();
                        console.createProject(parameterString);
                    } else if (line.contains(GET_PROJECT_CMD)) {
                        parameterString = line.substring(GET_PROJECT_CMD.length()).trim();
                        console.getProject(parameterString);
                    } else if (line.contains(UPDATE_PROJECT_CMD)) {
                        parameterString = line.substring(UPDATE_PROJECT_CMD.length()).trim();
                        console.updateProject(parameterString);
                    } else if (line.contains(DELETE_PROJECT_CMD)) {
                        parameterString = line.substring(DELETE_PROJECT_CMD.length()).trim();
                        System.out.print("Do you really want to delete the project? Please confirm [Yes/No]: ");
                        line = reader.readLine();
                        if (line.equalsIgnoreCase("Yes")) {
                            console.deleteProject(parameterString);
                        }
                    } else if (line.contains(LIST_PROJECT_DETAILS_CMD)) {
                        parameterString = line.substring(LIST_PROJECT_DETAILS_CMD.length()).trim();
                        console.listProjectDetails(parameterString);
                    } else if (line.contains(LIST_PROJECT_CMD)) {
                        parameterString = line.substring(LIST_PROJECT_CMD.length()).trim();
                        console.listProject(parameterString);
                    } else if (line.contains(CREATE_INDEX_TEMPLATE_CMD)) {
                        parameterString = line.substring(CREATE_INDEX_TEMPLATE_CMD.length()).trim();
                        console.createIndexGroup(parameterString);
                    } else if (line.contains(GET_INDEX_TEMPLATE_CMD)) {
                        parameterString = line.substring(GET_INDEX_TEMPLATE_CMD.length()).trim();
                        console.getIndexGroup(parameterString);
                    } else if (line.contains(UPDATE_INDEX_TEMPLATE_MAPPINGS_CMD)) {
                        parameterString = line.substring(UPDATE_INDEX_TEMPLATE_MAPPINGS_CMD.length()).trim();
                        console.updateIndexGroupMappings(parameterString);
                    } else if (line.contains(UPDATE_INDEX_TEMPLATE_SETTINGS_CMD)) {
                        parameterString = line.substring(UPDATE_INDEX_TEMPLATE_SETTINGS_CMD.length()).trim();
                        console.updateIndexGroupSettings(parameterString);
                    } else if (line.contains(UPDATE_INDEX_TEMPLATE_CMD)) {
                        parameterString = line.substring(UPDATE_INDEX_TEMPLATE_CMD.length()).trim();
                        console.updateIndexGroup(parameterString);
                    } else if (line.contains(DELETE_INDEX_TEMPLATE_CMD)) {
                        parameterString = line.substring(DELETE_INDEX_TEMPLATE_CMD.length()).trim();
                        System.out.print("Do you really want to delete the index group? Please confirm [Yes/No]: ");
                        line = reader.readLine();
                        if (line.equalsIgnoreCase("Yes")) {
                            console.deleteIndexGroup(parameterString);
                        }
                    } else if (line.contains(LIST_INDEX_TEMPLATE_DETAILS_CMD)) {
                        parameterString = line.substring(LIST_INDEX_TEMPLATE_DETAILS_CMD.length()).trim();
                        console.listIndexGroupDetails(parameterString);
                    } else if (line.contains(LIST_INDEX_TEMPLATE_CMD)) {
                        parameterString = line.substring(LIST_INDEX_TEMPLATE_CMD.length()).trim();
                        console.listIndexGroup(parameterString);
                    } else if (line.contains(CREATE_INDEX_CMD)) {
                        parameterString = line.substring(CREATE_INDEX_CMD.length()).trim();
                        console.createIndex(parameterString);
                    } else if (line.contains(ATTACH_ES_INDEX_CMD)) {
                        parameterString = line.substring(ATTACH_ES_INDEX_CMD.length()).trim();
                        console.attachESIndex(parameterString);
                    } else if (line.contains(DETACH_ES_INDEX_CMD)) {
                        parameterString = line.substring(DETACH_ES_INDEX_CMD.length()).trim();
                        console.detachESIndex(parameterString);
                    } else if (line.contains(GET_INDEX_CMD)) {
                        parameterString = line.substring(GET_INDEX_CMD.length()).trim();
                        console.getIndex(parameterString);
                    } else if (line.contains(REFRESH_INDEX_CMD)) {
                        parameterString = line.substring(REFRESH_INDEX_CMD.length()).trim();
                        console.refreshIndex(parameterString);
                    } else if (line.contains(UPDATE_INDEX_MAPPINGS_CMD)) {
                        parameterString = line.substring(UPDATE_INDEX_MAPPINGS_CMD.length()).trim();
                        console.updateIndexMappings(parameterString);
                    } else if (line.contains(UPDATE_INDEX_SETTINGS_CMD)) {
                        parameterString = line.substring(UPDATE_INDEX_SETTINGS_CMD.length()).trim();
                        console.updateIndexSettings(parameterString);
                    } else if (line.contains(UPDATE_INDEX_CMD)) {
                        parameterString = line.substring(UPDATE_INDEX_CMD.length()).trim();
                        console.updateIndex(parameterString);
                    } else if (line.contains(DELETE_INDEX_CMD)) {
                        parameterString = line.substring(DELETE_INDEX_CMD.length()).trim();
                        System.out.print("Do you really want to delete the index? Please confirm [Yes/No]: ");
                        line = reader.readLine();
                        if (line.equalsIgnoreCase("Yes")) {
                            console.deleteIndex(parameterString);
                        }
                    } else if (line.contains(LIST_INDEX_DETAILS_CMD)) {
                        parameterString = line.substring(LIST_INDEX_DETAILS_CMD.length()).trim();
                        console.listIndexDetails(parameterString);
                    } else if (line.contains(LIST_INDEX_NAME)) {
                        parameterString = line.substring(LIST_INDEX_NAME.length()).trim();
                        console.listIndexNames(parameterString);
                    } else if (line.contains(LIST_INDEX_CMD)) {
                        parameterString = line.substring(LIST_INDEX_CMD.length()).trim();
                        console.listIndex(parameterString);
                    } else if (line.contains(SET_SERVICE_NORMAL)) {
                        console.setNormal();
                    } else if (line.contains(SET_SERVICE_READONLY)) {
                        console.setReadOnly();
                    } else if (line.contains(SET_SERVICE_SUSPEND)) {
                        console.setSuspend();
                    } else if (line.contains(GET_SERVICE_MODE)) {
                        console.getServiceMode();
                    } else if (line.contains(SUSPEND_BACKGROUND_EXECUTORS)) {
                        console.suspendBackgroundExecutors();
                    } else if (line.contains(RESUME_BACKGROUND_EXECUTORS)) {
                        console.resumeBackgroundExecutors();
                    } else if (line.contains(GET_BACKGROUND_EXECUTORS_STATUS)) {
                        console.getBackgroundExecutorsStatus();
                    } else {
                        System.err.println("Input command is invalid!");
                        console.showHelp();
                    }
                }
                System.out.println("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public SearchManagementConsole(Set<String> serverHosts, int serverPort) {
        client = new AdminClient(serverHosts, serverPort);
        try {
            client.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.completer = new StringsCompleter(
                ADD_CLUSTER_CMD,
                GET_CLUSTER_CMD,
                UPDATE_CLUSTER_CMD,
                LIST_CLUSTER_CMD,
                LIST_CLUSTER_DETAILS_CMD,
                CREATE_PROJECT_CMD,
                GET_PROJECT_CMD,
                UPDATE_PROJECT_CMD,
                LIST_PROJECT_CMD,
                LIST_PROJECT_DETAILS_CMD,
                DELETE_PROJECT_CMD,
                CREATE_INDEX_TEMPLATE_CMD,
                GET_INDEX_TEMPLATE_CMD,
                UPDATE_INDEX_TEMPLATE_CMD,
                UPDATE_INDEX_TEMPLATE_MAPPINGS_CMD,
                UPDATE_INDEX_TEMPLATE_SETTINGS_CMD,
                DELETE_INDEX_TEMPLATE_CMD,
                LIST_INDEX_TEMPLATE_CMD,
                LIST_INDEX_TEMPLATE_DETAILS_CMD,
                CREATE_INDEX_CMD,
                ATTACH_ES_INDEX_CMD,
                DETACH_ES_INDEX_CMD,
                GET_INDEX_CMD,
                UPDATE_INDEX_CMD,
                REFRESH_INDEX_CMD,
                UPDATE_INDEX_MAPPINGS_CMD,
                UPDATE_INDEX_SETTINGS_CMD,
                DELETE_INDEX_CMD,
                LIST_INDEX_CMD,
                LIST_INDEX_DETAILS_CMD,
                LIST_INDEX_NAME,
                SET_SERVICE_READONLY,
                SET_SERVICE_NORMAL,
                SET_SERVICE_SUSPEND,
                GET_SERVICE_MODE,
                SUSPEND_BACKGROUND_EXECUTORS,
                RESUME_BACKGROUND_EXECUTORS,
                GET_BACKGROUND_EXECUTORS_STATUS);

    }

    public void showHelp() {
        System.out.println("\nThe following commands are supported.");
        System.out.println("");
        System.out.println(ADD_CLUSTER_CMD + " <input_json>");
        System.out.println(GET_CLUSTER_CMD + " <input_json>");
        System.out.println(UPDATE_CLUSTER_CMD + " <input_json>");
        System.out.println(LIST_CLUSTER_CMD);
        System.out.println(LIST_CLUSTER_DETAILS_CMD);
        System.out.println(CREATE_PROJECT_CMD + " <input_json>");
        System.out.println(GET_PROJECT_CMD + " <input_json>");
        System.out.println(UPDATE_PROJECT_CMD + " <input_json>");
        System.out.println(DELETE_PROJECT_CMD + " <input_json>");
        System.out.println(LIST_PROJECT_CMD + " <input_json>");
        System.out.println(LIST_PROJECT_DETAILS_CMD + " <input_json>");
        System.out.println(CREATE_INDEX_TEMPLATE_CMD + " <input_json>");
        System.out.println(GET_INDEX_TEMPLATE_CMD + " <input_json>");
        System.out.println(UPDATE_INDEX_TEMPLATE_CMD + " <input_json>");
        System.out.println(UPDATE_INDEX_TEMPLATE_MAPPINGS_CMD + "[project_name] [template_name] [mappings_file_path]");
        System.out.println(UPDATE_INDEX_TEMPLATE_SETTINGS_CMD + "[project_name] [template_name] [settings_file_path]");
        System.out.println(DELETE_INDEX_TEMPLATE_CMD + " <input_json>");
        System.out.println(LIST_INDEX_TEMPLATE_CMD + " <input_json>");
        System.out.println(LIST_INDEX_TEMPLATE_DETAILS_CMD + " <input_json>");
        System.out.println(CREATE_INDEX_CMD + " <input_json>");
        System.out.println(GET_INDEX_CMD + " <input_json>");
        System.out.println(UPDATE_INDEX_CMD + " <input_json>");
        System.out.println(UPDATE_INDEX_MAPPINGS_CMD + "[project_name] [template_name] [index_name] [mappings_file_path]");
        System.out.println(UPDATE_INDEX_SETTINGS_CMD + "[project_name] [template_name] [index_name] [settings_file_path]");
        System.out.println(DELETE_INDEX_CMD + " <input_json>");
        System.out.println(LIST_INDEX_CMD + " <input_json>");
        System.out.println(LIST_INDEX_DETAILS_CMD + " <input_json>");
        System.out.println(LIST_INDEX_NAME + " <input_json>");
        System.out.println(ATTACH_ES_INDEX_CMD + " <input_json>");
        System.out.println(DETACH_ES_INDEX_CMD + " <input_json>");
        System.out.println(SET_SERVICE_READONLY);
        System.out.println(SET_SERVICE_NORMAL);
        System.out.println(SET_SERVICE_SUSPEND);
        System.out.println(GET_SERVICE_MODE);
        System.out.println(SUSPEND_BACKGROUND_EXECUTORS);
        System.out.println(RESUME_BACKGROUND_EXECUTORS);
        System.out.println(GET_BACKGROUND_EXECUTORS_STATUS);
    }

    public void addCluster(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            ClusterCreateRequest clusterCreateRequest = JSON.parseObject(inputString, ClusterCreateRequest.class);
            client.createCluster(clusterCreateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to create cluster. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void getCluster(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            ClusterGetRequest clusterGetRequest = JSON.parseObject(inputString, ClusterGetRequest.class);
            ClusterInfo outputString = client.getCluster(clusterGetRequest);
            System.out.println("");
            System.out.println(formatJson(JSON.toJSONString(outputString)));
            System.out.println("");
        } catch (Exception e) {
            System.err.println(String.format("Fail to create cluster. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void updateCluster(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            ClusterUpdateRequest clusterUpdateRequest = JSON.parseObject(inputString, ClusterUpdateRequest.class);
            client.updateCluster(clusterUpdateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to update cluster. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void listCluster() {
        try {
            ClusterListRequest clusterListRequest = new ClusterListRequest();
            List<String> outputString = client.listCluster(clusterListRequest);
            System.out.println(formatJson(JSON.toJSONString(outputString)));
        } catch (Exception e) {
            System.err.println(String.format("Fail to list cluster. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void listClusterDetails() {
        try {
            ClusterListRequest clusterListRequest = new ClusterListRequest();
            List<ClusterInfo> outputString = client.listClusterDetails(clusterListRequest);
            System.out.println(formatJson(JSON.toJSONString(outputString)));
        } catch (Exception e) {
            System.err.println(String.format("Fail to list cluster details. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void createProject(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            ProjectCreateRequest projectCreateRequest = JSON.parseObject(inputString, ProjectCreateRequest.class);
            client.createProject(projectCreateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to create project.  ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void getProject(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            ProjectGetRequest projectGetRequest = new ProjectGetRequest();
            ProjectInfo outputString = client.getProject(projectGetRequest);
            System.out.println("");
            System.out.println(formatJson(JSON.toJSONString(outputString)));
            System.out.println("");
        } catch (Exception e) {
            System.err.println(String.format("Fail to get project. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void updateProject(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            ProjectUpdateRequest projectUpdateRequest = JSON.parseObject(inputString, ProjectUpdateRequest.class);
            client.updateProject(projectUpdateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to update project. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void deleteProject(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            ProjectDeleteRequest projectDeleteRequest = JSON.parseObject(inputString, ProjectDeleteRequest.class);
            client.deleteProject(projectDeleteRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to delete project. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void listProject(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            ProjectListRequest projectListRequest = JSON.parseObject(inputString, ProjectListRequest.class);
            List<String> outputString = client.listProject(projectListRequest);
            System.out.println("");
            System.out.println(formatJson(JSON.toJSONString(outputString)));
            System.out.println("");
        } catch (Exception e) {
            System.err.println(String.format("Fail to list project. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void listProjectDetails(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            ProjectListRequest projectListRequest = JSON.parseObject(inputString, ProjectListRequest.class);
            List<ProjectInfo> outputString = client.listProjectDetails(projectListRequest);
            System.out.println("");
            System.out.println(formatJson(JSON.toJSONString(outputString)));
            System.out.println("");
        } catch (Exception e) {
            System.err.println(String.format("Fail to list project details. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void createIndexGroup(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexTemplateCreateRequest indexTemplateCreateRequest = JSON.parseObject(inputString, IndexTemplateCreateRequest.class);
            client.createIndexTemplate(indexTemplateCreateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to create index template. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void getIndexGroup(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexTemplateGetRequest indexTemplateGetRequest = JSON.parseObject(inputString, IndexTemplateGetRequest.class);
            IndexTemplateInfo outputString = client.getIndexTemplate(indexTemplateGetRequest);
            System.out.println("");
            System.out.println(formatJson(JSON.toJSONString(outputString)));
            System.out.println("");
        } catch (Exception e) {
            System.err.println(String.format("Fail to get index template. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void updateIndexGroupMappings(String inputString) {
        String[] parts = inputString.split(" ");
        if (parts.length != 3) {
            System.err.println("The input format is not [project_name] [index_template_name] [mappings_file_path]");
        }
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("projectName", parts[0]);
            jsonObject.put("name", parts[1]);
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new FileReader(parts[2]));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                buffer.append(line);
            }
            jsonObject.put("mapping", buffer.toString());
            IndexTemplateUpdateRequest indexTemplateUpdateRequest = JSON.parseObject(jsonObject.toJSONString(), IndexTemplateUpdateRequest.class);
            client.updateIndexTemplate(indexTemplateUpdateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to update index template. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void updateIndexGroupSettings(String inputString) {
        String[] parts = inputString.split(" ");
        if (parts.length != 3) {
            System.err.println("The input format is not [project_name] [template_name] [settings_file_path]");
        }
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("projectName", parts[0]);
            jsonObject.put("name", parts[1]);
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new FileReader(parts[2]));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                buffer.append(line);
            }
            jsonObject.put("setting", buffer.toString());
            IndexTemplateUpdateRequest indexTemplateUpdateRequest = JSON.parseObject(jsonObject.toJSONString(), IndexTemplateUpdateRequest.class);
            client.updateIndexTemplate(indexTemplateUpdateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to update index template. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void updateIndexGroup(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexTemplateUpdateRequest indexTemplateUpdateRequest = JSON.parseObject(inputString, IndexTemplateUpdateRequest.class);
            client.updateIndexTemplate(indexTemplateUpdateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to update index template. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void deleteIndexGroup(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexTemplateDeleteRequest indexTemplateDeleteRequest = JSON.parseObject(inputString, IndexTemplateDeleteRequest.class);
            client.deleteIndexTemplate(indexTemplateDeleteRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to delete index template. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void listIndexGroup(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexTemplateListRequest list = JSON.parseObject(inputString, IndexTemplateListRequest.class);
            List<String> outputString = client.listIndexTemplate(list);
            System.out.println("");
            System.out.println(formatJson(JSON.toJSONString(outputString)));
            System.out.println("");
        } catch (Exception e) {
            System.err.println(String.format("Fail to list index template. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void listIndexGroupDetails(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexTemplateListRequest list = JSON.parseObject(inputString, IndexTemplateListRequest.class);
            List<IndexTemplateInfo> outputString = client.listIndexTemplateDetails(list);
            System.out.println("");
            System.out.println(formatJson(JSON.toJSONString(outputString)));
            System.out.println("");
        } catch (Exception e) {
            System.err.println(String.format("Fail to list index template details. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void createIndex(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexCreateRequest indexCreateRequest = JSON.parseObject(inputString, IndexCreateRequest.class);
            client.createIndex(indexCreateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to create index. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void attachESIndex(String inputString) {
        try {
            JSONObject jsonObject = JSON.parseObject(inputString);
            if (jsonObject == null) {
                System.err.println("Input string can't be parsed correctly.");
                return;
            }
            IndexAttachRequest indexAttachRequest = JSON.parseObject(inputString, IndexAttachRequest.class);
            client.attachIndex(indexAttachRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to attach existing index. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void detachESIndex(String inputString) {
        try {
            JSONObject jsonObject = JSON.parseObject(inputString);
            if (jsonObject == null) {
                System.err.println("Input string can't be parsed correctly.");
                return;
            }
            IndexDetachRequest detachRequest = JSON.parseObject(inputString, IndexDetachRequest.class);
            client.detachIndex(detachRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to detach existing index. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void getIndex(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexGetRequest indexGetRequest = JSON.parseObject(inputString, IndexGetRequest.class);
            IndexInfo outputString = client.getIndex(indexGetRequest);
            System.out.println("");
            System.out.println(formatJson(JSON.toJSONString(outputString)));
            System.out.println("");
        } catch (Exception e) {
            System.err.println(String.format("Fail to get index. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void refreshIndex(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexRefreshRequest indexRefreshRequest = JSON.parseObject(inputString, IndexRefreshRequest.class);
            client.refreshIndex(indexRefreshRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to refresh index. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void updateIndex(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexUpdateRequest indexUpdateRequest = JSON.parseObject(inputString, IndexUpdateRequest.class);
            client.updateIndex(indexUpdateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to update index. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void updateIndexMappings(String inputString) {
        String[] parts = inputString.split(" ");
        if (parts.length != 4) {
            System.err.println("The input format is not [project_name] [template_name] [index_name] [mappings_file_path]");
        }
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("project", parts[0]);
            jsonObject.put("template", parts[1]);
            jsonObject.put("name", parts[2]);
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new FileReader(parts[3]));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                buffer.append(line);
            }
            jsonObject.put("mapping", buffer.toString());
            IndexUpdateRequest indexUpdateRequest = JSON.parseObject(jsonObject.toJSONString(), IndexUpdateRequest.class);
            client.updateIndex(indexUpdateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to update index group. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void updateIndexSettings(String inputString) {
        String[] parts = inputString.split(" ");
        if (parts.length != 4) {
            System.err.println("The input format is not [project_name] [template_name] [index_name] [settings_file_path]");
        }
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("project", parts[0]);
            jsonObject.put("template", parts[1]);
            jsonObject.put("name", parts[2]);
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(new FileReader(parts[3]));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                buffer.append(line);
            }
            IndexUpdateRequest indexUpdateRequest = JSON.parseObject(jsonObject.toJSONString(), IndexUpdateRequest.class);
            client.updateIndex(indexUpdateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to update index template. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void deleteIndex(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexDeleteRequest indexUpdateRequest = JSON.parseObject(inputString, IndexDeleteRequest.class);
            client.deleteIndex(indexUpdateRequest);
        } catch (Exception e) {
            System.err.println(String.format("Fail to delete index. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void listIndex(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexListRequest indexListRequest = JSON.parseObject(inputString, IndexListRequest.class);
            List<String> outputString = client.listIndex(indexListRequest);
            System.out.println("");
            System.out.println(formatJson(JSON.toJSONString(outputString)));
            System.out.println("");
        } catch (Exception e) {
            System.err.println(String.format("Fail to list index. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void listIndexDetails(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexListDetailsRequest indexListRequest = JSON.parseObject(inputString, IndexListDetailsRequest.class);
            List<IndexInfo> outputString = client.listIndexDetails(indexListRequest);
            System.out.println("");
            System.out.println(formatJson(JSON.toJSONString(outputString)));
            System.out.println("");
        } catch (Exception e) {
            System.err.println(String.format("Fail to list index details. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void listIndexNames(String inputString) {
        try {
            JSON.parseObject(inputString);
        } catch (Exception e) {
            System.err.println("Input json parameter is invalid to parse.");
        }
        try {
            IndexListNameRequest indexListRequest = JSON.parseObject(inputString, IndexListNameRequest.class);
            List<IndexNameEntry> outputString = client.listIndexName(indexListRequest);
            System.out.println("");
            System.out.println(formatJson(JSON.toJSONString(outputString)));
            System.out.println("");
        } catch (Exception e) {
            System.err.println(String.format("Fail to list index names. ErrorMessage: [%s].", e.getMessage()));
        }
    }


    public void setReadOnly() {
        try {
            client.setServiceReadOnly();
            System.out.println("Service mode is changed into READONLY.");
        } catch (Exception e) {
            System.err.println(String.format("Fail to set service to readonly mode. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void setNormal() {
        try {
            client.setServiceNormal();
            System.out.println("Service mode is changed into NORMAL.");
        } catch (Exception e) {
            System.err.println(String.format("Fail to set service to normal mode. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void setSuspend() {
        try {
            client.setServiceSuspend();
            System.out.println("Service mode is changed into SUSPEND.");
        } catch (Exception e) {
            System.err.println(String.format("Fail to set service to suspend mode. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void getServiceMode() {
        try {
            String mode = client.getServiceMode();
            System.out.println("Service mode: " + mode);
        } catch (Exception e) {
            System.err.println(String.format("Fail to get service mode. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void suspendBackgroundExecutors() {
        try {
            client.suspendBackgroundExecutors();
            System.out.println("Background executors are suspended.");
        } catch (Exception e) {
            System.err.println(String.format("Fail to suspend background executors. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void resumeBackgroundExecutors() {
        try {
            client.resumeBackgroundExecutors();
            System.out.println("Background executors are resumed.");
        } catch (Exception e) {
            System.err.println(String.format("Fail to resume background executors. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    public void getBackgroundExecutorsStatus() {
        try {
            boolean isRunning = client.getBackgroundExecutorsStatus();
            if (isRunning) {
                System.out.println("Background executors are running.");
            } else {
                System.out.println("Background executors are not running.");
            }
        } catch (Exception e) {
            System.err.println(String.format("Fail to get background executors status. ErrorMessage: [%s].", e.getMessage()));
        }
    }

    private static String formatJson(String jsonStr) {
        if (null == jsonStr || "".equals(jsonStr)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }

        return sb.toString();
    }

    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append(' ');
            sb.append(' ');
            sb.append(' ');
            sb.append(' ');
        }
    }
}
