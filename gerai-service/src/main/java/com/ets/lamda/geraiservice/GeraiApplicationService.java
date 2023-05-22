package com.ets.lamda.geraiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
class GeraiApplicationService {

    public static void main(String[] args) {
        SpringApplication.run(GeraiApplicationService.class, args);
    }

}