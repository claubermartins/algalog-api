package com.algaworks.algalog.api.dto.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaRequest {
	
	@Valid
	@NotNull
	private ClienteIdRequest cliente;
	
	@Valid
	@NotNull
	private DestinatarioRequest destinatario;
	
	@NotNull
	private BigDecimal taxa;
}
