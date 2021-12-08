package com.springboot.api.Transporte.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.springboot.api.Transporte"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiDetails());
				
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Api Empresa",
				"Nombres de Empresas",
				"1.0",
				"GRATIS :)",
				new springfox.documentation.service.Contact("CARTRAN ALIMENTARY S.A ", "http://cartranalimenraty.com", "cartranalimenraty@gmail.com"),
				"Licencia API",
				"http://logistica.empresas.com",
				Collections.emptyList());
	}
	
}
