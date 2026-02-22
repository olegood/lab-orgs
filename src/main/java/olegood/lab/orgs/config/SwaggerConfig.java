package olegood.lab.orgs.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI orgsOpenAPI(BuildProperties build) {
    return new OpenAPI()
        .info(
            new Info()
                .title(build.getName())
                .description("API for managing organizations and enrollments")
                .version(build.getVersion()));
  }
}
