package com.algaworks.algalog.api.dto;

import lombok.Getter;
import lombok.Setter;

import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter
public class ClienteResponse {
	
	@ApiModelProperty(value = "Nome do Cliente")
	private Long id;
	private String nome;
}
