package br.com.transportadora.resources;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
import br.com.transportadora.model.FilialVO;
import br.com.transportadora.model.apiEnum.Prioridade;
import br.com.transportadora.repository.FilialRepository;

@RestController
@RequestMapping("/filial")
public class FilialResource {

	@Autowired
	private FilialRepository filialRepository;

	@GetMapping("/filiais")
	public List<Filial> listarFiliais() {
		return filialRepository.findAll();
	}

	@GetMapping("/filial/{id}")
	public ResponseEntity<Filial> listarFilial(@Valid @PathVariable(value = "id") Long id) {
		Filial filial = filialRepository.getOne(id);
		if (filial == null) {
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
		Filial filialExistente = filialRepository.getOne(id);
		if (filialExistente == null) {
			return ResponseEntity.notFound().build();
		}
		filialRepository.delete(filialExistente);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/filial/{id}")
	public ResponseEntity<Filial> atualizar(@Valid @RequestBody Filial filial, @PathVariable Long id) {
		Filial filialExistente = filialRepository.getOne(id);
		if (filialExistente == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(filial, filialExistente, "id");
		filialExistente = filialRepository.save(filialExistente);
		return ResponseEntity.ok(filialExistente);
	}

	@GetMapping("/service/transportadora/{prioridade}/{origem}/{destino}/{distancia}/{transporte}")
	public List<FilialVO> melhorFilial(@PathVariable String prioridade, @PathVariable String origem,
			@PathVariable String destino, @PathVariable BigDecimal distancia, @PathVariable String transporte) {

		if (prioridade == null || origem == null || destino == null || distancia == null) {
			//return ResponseEntity.badRequest().build();
			return null;
		}
		
		List<FilialVO> filialsVO = new ArrayList<FilialVO>();
		FilialVO filialVO = new FilialVO();
		
		for (Filial filialCorrente : filialRepository.findAll()) {
			
			BigDecimal valorTotalAereo = new BigDecimal(0);
			BigDecimal valorTotalTerrestre = new BigDecimal(0);
			
			if(filialCorrente.getValorAereo().compareTo(BigDecimal.ZERO) > 0) {
				valorTotalAereo = distancia.multiply(filialCorrente.getValorAereo());
				valorTotalAereo = valorTotalAereo.divide(valorTotalAereo,10, RoundingMode.CEILING);
			}
			if(filialCorrente.getValorTerrestre().compareTo(BigDecimal.ZERO) > 0) {
				valorTotalTerrestre = distancia.multiply(filialCorrente.getValorTerrestre());
				valorTotalTerrestre = valorTotalTerrestre.divide(valorTotalTerrestre,10,RoundingMode.CEILING);
			}
			
			filialVO.setId(filialCorrente.getId());
			filialVO.setNome(filialCorrente.getNome());
			filialVO.setOrigem(origem);
			filialVO.setDestino(destino);
			filialVO.setDistancia(distancia);
			filialVO.setValorTotalAereo(valorTotalAereo);
			filialVO.setPrioridade((prioridade.equals(Prioridade.preco)? Prioridade.preco : Prioridade.tempo));
			filialVO.setValorTotalTerrestre(valorTotalTerrestre);
			filialVO.setTempoTotalAereo(filialCorrente.getTempoMedioAereo() * Integer.parseInt(distancia.toString()));
			filialVO.setTempoTotalTerrestre(filialCorrente.getTempoMedioTerrestre() * Integer.parseInt(distancia.toString()));
			
			filialsVO.add(filialVO);
		}
		if (prioridade.equals(Prioridade.preco)) {
			if(transporte.equals("aereo")) {
				Collections.sort(filialsVO, new Comparator<FilialVO>() {
					@Override
					public int compare(FilialVO o1, FilialVO o2) {
						return o1.getValorTotalAereo().compareTo(o2.getValorTotalAereo());
					}
				});
			}else if(transporte.equals("terrestre")) {
				Collections.sort(filialsVO, new Comparator<FilialVO>() {
					@Override
					public int compare(FilialVO o1, FilialVO o2) {
						return o1.getValorTotalTerrestre().compareTo(o2.getValorTotalTerrestre());
					}
				});
			}
		} else if (prioridade.equals(Prioridade.tempo)) {
			if(transporte.equals("aereo")) {
				Collections.sort(filialsVO, new Comparator<FilialVO>() {
					@Override
					public int compare(FilialVO o1, FilialVO o2) {
						return o1.getTempoTotalAereo().compareTo(o2.getTempoTotalAereo());
					}
				});
			}else if(transporte.equals("terrestre")) {
				Collections.sort(filialsVO, new Comparator<FilialVO>() {
					@Override
					public int compare(FilialVO o1, FilialVO o2) {
						return o1.getTempoTotalTerrestre().compareTo(o2.getTempoTotalTerrestre());
					}
				});
			}
		}
		return filialsVO;
	}
}
