package org.springdoc.demo.services.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("示例 API 文档")
            .version("1.0")
            .description("这是一个示例 API 文档，用于演示如何整合 springdoc-openapi。")
            .contact(new Contact()
                .name("你的名字")
                .email("your.email@example.com")
                .url("https://example.com"))
            .license(new License()
                .name("Apache 2.0")
                .url("http://www.apache.org/licenses/LICENSE-2.0")));
  }

  @Bean
  public GroupedOpenApi userApi() {
    return GroupedOpenApi.builder()
        .group("user")
//        .packagesToScan("org.springdoc.demo.services.user")
        .pathsToMatch("/api/user/**")
        .build();
  }

  @Bean
  public GroupedOpenApi bookpi() {
    return GroupedOpenApi.builder()
        .group("book")
        .pathsToMatch("/api/book/**")
//        .packagesToScan("org.springdoc.demo.services.book")
        .build();
  }

}
