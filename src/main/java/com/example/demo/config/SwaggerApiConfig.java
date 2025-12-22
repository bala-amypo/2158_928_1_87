// package com.example.demo.config;

// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.servers.Server;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import java.util.List;

// @Configuration
// public class SwaggerApiConfig {

//     @Bean
//     public OpenAPI customOpenAPI() {
//         return new OpenAPI()
//                 // You need to change the port as per your server
//                 .servers(List.of(
//                         new Server().url("https://9003.pro604cr.amypo.ai/")
//                 ));
//         }
//}

package com.example.demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Carbon Footprint Estimator API")
                        .version("1.0"))
                // 1. KEEP YOUR PORTAL SERVER URL HERE
                .servers(List.of(
                        new Server().url("https://9003.pro604cr.amypo.ai/")
                ))
                // 2. ADD THE SECURITY REQUIREMENT (This enables the lock icons)
                .addSecurityItem(new SecurityRequirement().addList("JavaBearerAuth"))
                // 3. ADD THE SECURITY SCHEME (This enables the Authorize button)
                .components(new Components()
                        .addSecuritySchemes("JavaBearerAuth", new SecurityScheme()
                                .name("JavaBearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}