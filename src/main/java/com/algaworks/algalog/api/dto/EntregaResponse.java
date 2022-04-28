package com.algaworks.algalog.api.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.algaworks.algalog.domain.model.StatusEntrega;

import lombok.Getter;
import lombok.Setter;

import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter
public class EntregaResponse {
	
	@ApiModelProperty(value = "Detalhes da entrega")
	private Long id;
	private ClienteResponse cliente;
	private DestinatarioResponse destinatario;
	private BigDecimal taxa;
	private StatusEntrega status;
	private OffsetDateTime dataPedido;
	private OffsetDateTime dataFinalizacao;
}
