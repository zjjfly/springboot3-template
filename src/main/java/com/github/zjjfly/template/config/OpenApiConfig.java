package com.github.zjjfly.template.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zi JunJie(junjie.zi@siemens.com)
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
            .info(new Info().title("XXX APIs")
                .description("some description")
                .version("v1.0")
                .license(new License().name("Apache 2.0")
                    .url("https://www.apache.org/licenses/LICENSE-2.0.txt")))
            .externalDocs(
                new ExternalDocumentation().description("GitHub").url("https://github.com/zjjfly"));
    }

}
