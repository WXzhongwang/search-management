package com.rany.service.master;

import com.rany.service.component.config.MetaStoreConfig;
import com.rany.service.component.impl.AdminServiceComponent;
import com.rany.service.component.impl.MasterServiceInternalImpl;
import com.rany.service.component.impl.MetaServiceComponent;
import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author zhongshengwang
 */
@Service
public class AdminCenter {

    private static final Logger logger = LoggerFactory.getLogger(AdminCenter.class);
    private static final int SERVER_PORT = 8080;
    private Server internalServer;

    @Value("${spring.profiles.active}")
    private String profile;

    @Resource
    private MetaStoreConfig metaStoreConfig;

    private AdminServiceComponent adminComponent;
    private MetaServiceComponent metaComponent;
    private MasterServiceInternalImpl internal;


    @PostConstruct
    public void start() throws Exception {
        logger.info("MasterService begins to create MetaServiceComponent and AdminServiceComponent objects.");
        logger.info("MasterServiceConfig: {}.", metaStoreConfig.dumpConfigString());
        logger.info("MasterService is running on profile [{}].", profile);

        internal = new MasterServiceInternalImpl(profile, metaStoreConfig);
        internal.start();

        metaComponent = new MetaServiceComponent(internal);
        adminComponent = new AdminServiceComponent(internal);
        logger.info("MasterService finishes to create MetaServiceComponent and AdminServiceComponent objects.");

        logger.info("MasterService begins to start and listen on port {}.", SERVER_PORT);
        internalServer = NettyServerBuilder.forPort(SERVER_PORT)
                .addService(adminComponent)
                .addService(metaComponent).build().start();
        logger.info("MasterService finishes to start and listen on port {}.", SERVER_PORT);

        // shutdown hood
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    logger.info("MasterService is going to stop.");
                    AdminCenter.this.stop();
                    logger.info("MasterService succeeds to stop.");
                } catch (Exception e) {
                    logger.error("MasterService fails to stop with message: {}. Cause: {}.", e.getMessage(), e.getCause().toString());
                }
            }
        });
    }

    @PreDestroy
    public void stop() {
        if (internalServer != null) {
            internalServer.shutdown();
        }
        if (internal != null) {
            internal.stop();
        }
    }
}
