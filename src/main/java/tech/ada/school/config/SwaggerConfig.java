package tech.ada.school.config;

import static io.swagger.v3.oas.annotations.enums.SecuritySchemeIn.HEADER;
import static io.swagger.v3.oas.annotations.enums.SecuritySchemeType.HTTP;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
    servers = {@Server(url = "/")},
    security = {@SecurityRequirement(name = "BasicAuth")}
)
@SecurityScheme(
    name = "BasicAuth",
    type = HTTP,
    in = HEADER,
    scheme = "basic"
)
@SecurityScheme(
    name = "JWT",
    type = HTTP,
    in = HEADER,
    scheme = "bearer"
)
public class SwaggerConfig {
}
