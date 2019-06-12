package com.taobao.diamond.client.example;

import com.taobao.diamond.manager.DiamondManager;
import com.taobao.diamond.manager.ManagerListener;
import com.taobao.diamond.manager.impl.DefaultDiamondManager;

import java.util.concurrent.Executor;

/**
 * 接入方式1:
 * 这是最基础的接入方式。优点是接入灵活，确实是代码繁琐
 */
public class DiamondTestClient {
    public static DiamondManager manager;

    public static void main(String[] str) {
        initDiamondManager();
    }

    private static void initDiamondManager() {

        manager = new DefaultDiamondManager("test-group1", "test-dataId1", new ManagerListener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("configInfo=" + configInfo);
            }
        });
    }
}
