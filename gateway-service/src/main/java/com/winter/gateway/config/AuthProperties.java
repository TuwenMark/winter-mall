package com.winter.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "wm.auth")
public class AuthProperties {
    private List<String> includePaths;
    private List<String> excludePaths;
}
