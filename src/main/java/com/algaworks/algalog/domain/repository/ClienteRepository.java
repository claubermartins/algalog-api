package com.algaworks.algalog.domain.repository;
import com.algaworks.algalog.domain.model.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
//	List<Cliente> findByNome(String nome);
//	List<Cliente> findByNomeContaining(String nome);
}
