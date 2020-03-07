package br.com.transportadora.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.transportadora.model.Filial;
import br.com.transportadora.repository.FilialRepository;

@RestController
@RequestMapping("/service/transportadora")
public class FilialResource {
	
	@Autowired
	FilialRepository filialRepository;
	
	@GetMapping("/filiais")
	public List<Filial> listarFiliais(){
		return filialRepository.findAll();
	}
	
	@GetMapping("/filiais/{id}")
	public Filial listarFilial(@PathVariable(value = "id") Long id) {
		return filialRepository.findById(id);
	}
	
	public Filial adicionar(Filial filial) {
		return filial;
	}
	
}
