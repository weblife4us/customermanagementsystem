package com.go2it.frame;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationStarter {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }

}
