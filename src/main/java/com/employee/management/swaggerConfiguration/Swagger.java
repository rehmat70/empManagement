package com.employee.management.swaggerConfiguration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {

    @Bean // Defines a bean that will be managed by the Spring container
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Adds components such as security schemes to the OpenAPI instance
                .components(new Components()
                        // Adds a security scheme named "basicAuth" with HTTP Basic Authentication type
                        .addSecuritySchemes("basicAuth", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                // Specifies that the security scheme "basicAuth" should be applied globally
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
                // Sets metadata information about the API
                .info(new Info()
                        .title("Employees Management System API") // Sets the title of the API
                        .version("1.0") // Sets the version of the API
                        .description("API documentation for the Employees Management System")); // Sets the description of the API
    }
}
