package com.iwillpinchu.cards.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "build")
@Getter
@Setter
public class BuildInfoDto {
    private String version;
    private String javaVersion;
}
