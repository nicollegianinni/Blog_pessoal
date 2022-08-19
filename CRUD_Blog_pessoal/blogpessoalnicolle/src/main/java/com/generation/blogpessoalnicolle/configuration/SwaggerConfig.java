package com.generation.blogpessoalnicolle.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

//classe criada para fazer o deploy

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springBlogPessoalOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Projeto Blog Pessoal - Nicolle Gianinni")
						.description("Projeto Blog Pessoal - Nicolle Gianinni").version("v0.0.1")
						.license(new License().name("Portfolio - Nicollle Gianinni")
								.url("https://beacons.ai/nicollegianinni"))
						.contact(new Contact().name("Nicolle Gianinni").url("https://github.com/nicollegianinni")
								.email("ContatoNicolleGianinni@hotmail.com")))
				.externalDocs(new ExternalDocumentation().description("https://github.com/nicollegianinni")
						.url("https://github.com/nicollegianinni/Pocos_Solidarios_PI/"));
	}

	@Bean
	public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {

		return openApi -> {
			openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {

				ApiResponses apiResponses = operation.getResponses();

				apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
				apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
				apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
				apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
				apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
				apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
				apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

			}));
		};
	}

	private ApiResponse createApiResponse(String message) {

		return new ApiResponse().description(message);

	}

}
