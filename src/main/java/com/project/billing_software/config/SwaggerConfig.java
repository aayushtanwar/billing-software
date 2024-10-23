package com.project.billing_software.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Billing System API",
        version = "1.0",
        description = "API documentation for Billing System"
    )
)
public class SwaggerConfig {
    // No need for Docket configuration here for springdoc
}