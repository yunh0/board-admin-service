package org.yunho.boardadminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class BoardAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardAdminServiceApplication.class, args);
    }

}
