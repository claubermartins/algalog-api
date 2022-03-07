package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController
public class ClienteController {

	@GetMapping("/clientes")
	public List<Cliente> listar() {
		var cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("Claubergol");
		cliente1.setTelefone("9899889988");
		cliente1.setEmail("claubergol.gmail.com");

		var cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Claubercsgo");
		cliente2.setTelefone("5555667788");
		cliente2.setEmail("claubercsgo@gmail.com");
		
		return Arrays.asList(cliente1, cliente2);
	}
}
