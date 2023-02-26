package com.board.boardback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket SwaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.board.boardback.controller"))
                .paths(PathSelectors.any()) // controller Package all
                .build();
    }

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("Spring Boot Board API Documentation")
                .description("스프링부트 게시판 API 설명을 위한 문서입니다.")
                .license("kiziri")
                .version("1")
                .build();
    }
}
