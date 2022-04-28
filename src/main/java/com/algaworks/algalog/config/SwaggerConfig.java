package com.algaworks.algalog.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
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
	       .apis(RequestHandlerSelectors.basePackage("com.algaworks.algalog.api.controller"))
	        .paths(PathSelectors.any())
	        .build()
	        .useDefaultResponseMessages(false)
	        .apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
	    return new ApiInfo(
	  	      "API QUE SIMULA UMA LOGÍSTICA DE ENTREGAS DE MERCADORIAS", 
		      "API RESTful de logistica para entrega de mercadorias, desenvolvida em java com springboot framework, Swagger para documentação e Docker para conteinerização de contêineres.", 
		      "API", 
		      "Terms of service", 
		      new Contact("Clauber Martins", "https://github.com/claubermartins", "clauber789@gmail.com"), 
		      "Linkedin", "https://www.linkedin.com/in/clauber-martins-095889200/", Collections.emptyList());
	}

    private List<ResponseMessage> responseMessageForGET()
    {
        return new ArrayList<ResponseMessage>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
            add(new ResponseMessageBuilder()
                .code(500)
                .message("500 message")
                .responseModel(new ModelRef("Error"))
                .build());
            add(new ResponseMessageBuilder()
                    .code(200)
                    .message("Ok!")
                    .build());
            add(new ResponseMessageBuilder()
                    .code(400)
                    .message("Bad Request!")
                    .build());
            add(new ResponseMessageBuilder()
                    .code(404)
                    .message("Not Found!")
                    .build());
        }};
    }
}