package com.taobao.diamond.client.example;

import com.taobao.diamond.annotation.DiamondAno;
import com.taobao.diamond.annotation.DiamondAnoExcute;

/**
 * 接入方式2:
 * 这种方式支持注解获取数据。请在WebApplication启动应用，
 * 需要在程序入口加入DiamondAnoExcute.goAways方法。
 */
public class DiamondTestClient2 {

    @DiamondAno(groupId="test-group1",dataId = "test-dataId1")
    public static String testDataId1= "dxf";

    @DiamondAno(groupId="b",dataId = "a")
    public static String a= "dxf";

    @DiamondAno(groupId="new-group1",dataId = "new-dataId1")
    public static String newDataId1= "dxf";

}
