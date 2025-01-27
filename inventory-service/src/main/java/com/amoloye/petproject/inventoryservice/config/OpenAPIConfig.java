package com.amoloye.petproject.inventoryservice.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

public class OpenAPIConfig {
    @Bean
    public OpenAPI InventoryServiceAPI(){
        return new OpenAPI()
                .info(new Info().title("Inventory Service API")
                        .description("This is the REST API for Inventory Service")
                        .version("v).0.1")
                        .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation() //all this part is for when we have an actual url after deployment of confluence page
                        .description("Refer to the Order Service Wiki Documentation") //not real or needed
                        .url("https://inventory-service-dummy-url.com/docs")); //not real
    }
}
