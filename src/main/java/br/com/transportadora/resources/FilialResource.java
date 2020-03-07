package br.com.transportadora.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/filial/{id}")
	public ResponseEntity<Filial> listarFilial(@Valid @PathVariable(value = "id") Long id) {
		Filial filial = filialRepository.findOne(id);
		if(filial == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(filial);
	}
	
	@PostMapping("/filial")
	public Filial adicionar(@Valid @RequestBody Filial filial) {
		return filialRepository.save(filial);
	}
	
	@DeleteMapping("/filial")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		Filial filialExistente = filialRepository.findOne(id);
		if(filialExistente == null) {
			return ResponseEntity.notFound().build();
		}
		filialRepository.delete(filialExistente);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/filial/{id}")
	public ResponseEntity<Filial> atualizar(@Valid @RequestBody Filial filial,@PathVariable Long id) {
		Filial filialExistente = filialRepository.findOne(id);
		if(filialExistente == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(filial, filialExistente, "id");
		filialExistente = filialRepository.save(filialExistente);
		return ResponseEntity.ok(filialExistente);
	}
	
}
