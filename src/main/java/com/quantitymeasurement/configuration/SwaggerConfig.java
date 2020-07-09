package com.quantitymeasurement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.quantitymeasurement"))
                .paths(regex("/units.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Quantity Measurement API",
                "This is Quantity Measurement API",
                "5.0",
                "Terms of Service",
                new Contact("Seema Balkrishna Rajpure", "htts//localhost//8082",
                        "seemarajpure16@gmail.com"),
                "Spring Version 5",
                "https://localhost/8082-ui.html"
        );
        return apiInfo;
    }
}
