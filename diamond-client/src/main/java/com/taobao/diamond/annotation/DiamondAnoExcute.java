package com.taobao.diamond.annotation;

import com.taobao.diamond.manager.DiamondManager;
import com.taobao.diamond.manager.ManagerListener;
import com.taobao.diamond.manager.impl.DefaultDiamondManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.util.concurrent.Executor;

public class DiamondAnoExcute {

    private static final Log logger = LogFactory.getLog(DiamondAnoExcute.class);

    public static void goAways(Class<?> ... testClasses) {

        for(Class<?> testClass : testClasses){
            goAway(testClass);
        }

    }

    public static void goAway(Class<?> testClass) {

        Field[] fields = testClass.getDeclaredFields();

        if (fields != null) {
            for (Field field : fields) {
                initDiamondManager(field);
            }
        }

    }

    private static void initDiamondManager(final Field field) {
        if(field==null){
            return;
        }
        DiamondAno testAno = field.getAnnotation(DiamondAno.class);
        if(testAno==null){
            return;
        }

        final String groupId = testAno.groupId();
        final String dataId = testAno.dataId();

        DiamondManager manager = new DefaultDiamondManager(groupId, dataId, new ManagerListener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("configInfo=" + configInfo);
                try {
                    field.setAccessible(true);
                    field.set(null, configInfo);
                    logger.info("groupId=" + groupId + ",dataId=" + dataId);
                } catch (Exception e) {
                    logger.error("groupId=" + groupId + ",dataId=" + dataId, e);
                }
            }
        });
    }

}
