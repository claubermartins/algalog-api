package com.algaworks.algalog.api.dto;

import lombok.Getter;
import lombok.Setter;
import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter
public class DestinatarioResponse {
	
	@ApiModelProperty(value = "Informações do destinatário")
	private String nome;
	private String logradouro;
	private String numero;
	private String complemento;
	private String bairro;

}
