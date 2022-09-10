package org.example.score.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

public class NacosConfig {

    @Value("${spring.cloud.nacos.server-addr}")
    public String server;

    public String group = "DEFAULT_GROUP";
}
