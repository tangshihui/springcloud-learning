package org.example.score.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mysql")
@Data
public class MysqlProperties {

    private String host;
    private Integer port;
    private String username;
    private String password;
}

