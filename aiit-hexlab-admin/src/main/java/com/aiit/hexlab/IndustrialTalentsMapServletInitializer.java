package com.aiit.hexlab;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author Zkoi
 * @date 2024/1/25 15:40
 */
public class IndustrialTalentsMapServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(IndustrialTalentsMapApplication.class);
    }
}
