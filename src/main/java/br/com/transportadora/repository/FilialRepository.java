package br.com.transportadora.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.transportadora.model.Filial;


public interface FilialRepository extends JpaRepository<Filial, Long>{

	Filial findOne(@Valid Long id);
	
}
