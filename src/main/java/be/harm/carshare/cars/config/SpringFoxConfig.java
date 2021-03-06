package be.harm.carshare.cars.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.ant("/cars/**"))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData() {
        Contact contact = new Contact("Harm De Weirdt", "https://github.com/hdeweirdt", "harm.deweirdt@mailfence.com");

        return new ApiInfo("Carshare cars API" ,
                "Service regarding cars in the carshare platform",
                "v0.0.1",
                null,
                contact,
                null,
                null,
                Collections.emptyList());
    }
}

