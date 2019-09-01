package com.seenukarthi.so.jdbctest;

import com.seenukarthi.so.jdbctest.config.Config;
import com.seenukarthi.so.jdbctest.service.TestJdbcService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        TestJdbcService test = context.getBean(TestJdbcService.class);
        test.testService();
    }
}
