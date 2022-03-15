package com.algaworks.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.api.dto.DestinatarioResponse;
import com.algaworks.algalog.api.dto.EntregaResponse;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		return solicitacaoEntregaService.solicitar(entrega);
	}

	@GetMapping
	public List<Entrega> listar() {
		return entregaRepository.findAll();
	}

	@GetMapping("/{entregaId}")
	public ResponseEntity<EntregaResponse> buscar(@PathVariable Long entregaId) {
		return entregaRepository.findById(entregaId).map(entrega -> {
			EntregaResponse entregaResponse = new EntregaResponse();
			entregaResponse.setId(entrega.getId());
			entregaResponse.setNomeCliente(entrega.getCliente().getNome());
			entregaResponse.setDestinatario(new DestinatarioResponse());
			entregaResponse.getDestinatario().setNome(entrega.getDestinatario().getNome());
			entregaResponse.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
			entregaResponse.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
			entregaResponse.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
			entregaResponse.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
			entregaResponse.setTaxa(entrega.getTaxa());
			entregaResponse.setStatus(entrega.getStatus());
			entregaResponse.setDataPedido(entrega.getDataPedido());
			entregaResponse.setDataFinalizacao(entrega.getDataFinalizacao());

			return ResponseEntity.ok(entregaResponse);
		}).orElse(ResponseEntity.notFound().build());
	}
}
