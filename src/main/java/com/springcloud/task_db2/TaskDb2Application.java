package com.springcloud.task_db2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@SpringBootApplication(exclude = BatchAutoConfiguration.class)
@EnableTask
public class TaskDb2Application {
    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {SpringApplication.run(com.springcloud.task_db2.TaskDb2Application.class, args);}

    @Bean
    public TaskConfigurer getTaskConfigurer() {
        return new TaskConfigurer(dataSource);
    }

    @Bean
    public TaskListener taskListener() {
        return new TaskListener();
    }

    @Component
    public static class TaskDbApplicationRunner
            implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments arg0) throws Exception {
            System.out.println("Hello World from Spring Cloud Task!");
        }
    }

}
