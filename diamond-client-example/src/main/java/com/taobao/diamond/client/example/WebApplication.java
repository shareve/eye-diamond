package com.taobao.diamond.client.example;

import com.taobao.diamond.annotation.DiamondAno;
import com.taobao.diamond.annotation.DiamondAnoExcute;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author SHAREVE
 */
@SpringBootApplication
public class WebApplication extends SpringBootServletInitializer {

    @DiamondAno(groupId = "test-group1", dataId = "test-dataId1")
    public static String testDataId1 = "dxf";

    @DiamondAno(groupId = "b", dataId = "a")
    public static String a = "dxf";

    @DiamondAno(groupId = "new-group1", dataId = "new-dataId1")
    public static String newDataId1 = "dxf";

    private static final Log logger = LogFactory.getLog(WebApplication.class);

    public static void main(String[] args) {
        logger.info("WebApplication START");
        new SpringApplicationBuilder(WebApplication.class).run(args);
        DiamondAnoExcute.goAway(WebApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }
}
