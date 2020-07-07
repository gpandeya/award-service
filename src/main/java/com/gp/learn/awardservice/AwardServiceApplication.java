package com.gp.learn.awardservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AwardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwardServiceApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/awards/*"))
				.apis(RequestHandlerSelectors.basePackage("com.gp"))
				.build().apiInfo(this.generateAPIDetails());
	}
	
	private ApiInfo generateAPIDetails() {
		return new ApiInfo(
				"Award APIs", 
				"Api for award management", 
				"1.0", 
				"Free to Use",
		         new Contact("Gyanesh Pandeya","www.gyaneshp.com","gyanesh***@domain.com"), 
		         "Apache 2.0", 
		         "http://www.apache.org/licenses/LICENSE-2.0", 
		         Collections.emptyList());
	}
}
