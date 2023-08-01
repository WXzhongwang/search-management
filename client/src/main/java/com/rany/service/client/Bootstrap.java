package com.rany.service.client;

/**
 * @author zhongshengwang
 * @description TODO
 * @date 2022/3/26 11:23 下午
 * @email 18668485565@163.com
 */

public interface Bootstrap {


    /**
     * 启动
     *
     * @return
     */
    boolean start();

    /**
     * 停止
     *
     * @return
     */
    boolean shutdown();
}
