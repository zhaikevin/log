package com.github.log.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Arrays;

/**
 * @Description: 启动类
 * @Author: kevin
 * @Date: 2019/11/1 15:16
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.github.foundation", "com.github.log"})
@MapperScan("com.github.log.server.dao")
public class LogServer {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LogServer.class, args);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
