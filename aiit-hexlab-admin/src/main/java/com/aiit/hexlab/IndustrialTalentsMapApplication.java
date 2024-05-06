package com.aiit.hexlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Zkoi
 * @date 2024/1/25 15:29
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class IndustrialTalentsMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(IndustrialTalentsMapApplication.class, args);
        System.out.println("【萧山产才地图启动成功！】");
    }

}
