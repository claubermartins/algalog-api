package com.algaworks.algalog.api.dto;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter
public class OcorrenciaResponse {
	
	@ApiModelProperty(value = "Informações das ocorrências")
	private Long id;
	private String descricao;
	private OffsetDateTime dataRegistro;
}
