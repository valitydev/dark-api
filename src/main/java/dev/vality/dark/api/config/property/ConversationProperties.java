package dev.vality.dark.api.config.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "conversations")
@Validated
@Getter
@Setter
public class ConversationProperties {

    @NotNull
    private Resource url;

    @NotNull
    private Integer networkTimeout;

}
