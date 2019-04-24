package com.sample.dcs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// TODO: Auto-generated Javadoc
/**
 * The Class SwaggerConfig.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * Api.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.select()//
				.apis(RequestHandlerSelectors.basePackage("com.sample.dcs.controller"))//
				// .paths(PathSelectors.ant("/api/*"))
				.paths(PathSelectors.any())//
				.build()//
				.apiInfo(apiInfo());
	}

	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder().title("Spring Boot Data Caching Service REST API")
	            .description("Data Caching Service REST API")
	            .contact(new Contact("Sunil Kumar Dash", "ssunil.dash@gmail.com", "ssunil.dash@gmail.com"))
	            .version("1.0.0")
	            .build();
	}
}
