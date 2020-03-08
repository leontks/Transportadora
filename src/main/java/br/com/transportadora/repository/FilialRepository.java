package br.com.transportadora.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.transportadora.model.Filial;

public interface FilialRepository extends JpaRepository<Filial, Long>{
	
}
