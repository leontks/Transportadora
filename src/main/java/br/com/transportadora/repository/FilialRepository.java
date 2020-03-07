package br.com.transportadora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.transportadora.model.Filial;

public interface FilialRepository extends JpaRepository<Filial, Long>{
	
	public Filial findById(Long id);
	
}
