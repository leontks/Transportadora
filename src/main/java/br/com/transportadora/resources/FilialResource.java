package br.com.transportadora.resources;

import java.math.BigDecimal;
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
import br.com.transportadora.model.FiltroVO;
import br.com.transportadora.model.apiEnum.Prioridade;
import br.com.transportadora.model.apiEnum.TipoTransporte;
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

	@GetMapping("/service/transportadora")
	public List<FilialVO> melhorFilial(@Valid @RequestBody FiltroVO filtro) {

		if (filtro.getPrioridade() == null || filtro.getOrigem() == null || 
				filtro.getDestino() == null || filtro.getDistancia() == null) {
			//return ResponseEntity.badRequest().build();
			return null;
		}
		
		List<FilialVO> filialsVO = new ArrayList<FilialVO>();
		FilialVO filialVO = new FilialVO();
		List<Filial> filiais = filialRepository.findAll();
		for (Filial filialCorrente : filiais) {
			BigDecimal valorTotalAereo = new BigDecimal(0);
			BigDecimal valorTotalTerrestre = new BigDecimal(0);
			if(filialCorrente.getValorAereo().compareTo(BigDecimal.ZERO) > 0) {
				valorTotalAereo = filtro.getDistancia().multiply(filialCorrente.getValorAereo());
				valorTotalAereo = valorTotalAereo.divide(new BigDecimal(10));
			}
			if(filialCorrente.getValorTerrestre().compareTo(BigDecimal.ZERO) > 0) {
				valorTotalTerrestre = filtro.getDistancia().multiply(filialCorrente.getValorTerrestre());
				valorTotalTerrestre = valorTotalTerrestre.divide(new BigDecimal(10));
			}
			filialVO.setId(filialCorrente.getId());
			filialVO.setNome(filialCorrente.getNome());
			filialVO.setValorTotalAereo(valorTotalAereo);
			filialVO.setValorTotalTerrestre(valorTotalTerrestre);
			filialVO.setTempoTotalAereo((filialCorrente.getTempoMedioAereo() * Integer.parseInt(filtro.getDistancia().toString()))/60);
			filialVO.setTempoTotalTerrestre((filialCorrente.getTempoMedioTerrestre() * Integer.parseInt(filtro.getDistancia().toString()))/60);
			
			filialsVO.add(filialVO);
		}
		if (filtro.getPrioridade().equals(Prioridade.preco)) {
			if(filtro.getTipoTransporte().equals(TipoTransporte.aereo)) {
				Collections.sort(filialsVO, new Comparator<FilialVO>() {
					@Override
					public int compare(FilialVO o1, FilialVO o2) {
						return o1.getValorTotalAereo().compareTo(o2.getValorTotalAereo());
					}
				});
			}else if(filtro.getTipoTransporte().equals(TipoTransporte.terrestre)) {
				Collections.sort(filialsVO, new Comparator<FilialVO>() {
					@Override
					public int compare(FilialVO o1, FilialVO o2) {
						return o1.getValorTotalTerrestre().compareTo(o2.getValorTotalTerrestre());
					}
				});
			}
		} else if (filtro.getPrioridade().equals(Prioridade.tempo)) {
			if(filtro.getTipoTransporte().equals(TipoTransporte.aereo)) {
				Collections.sort(filialsVO, new Comparator<FilialVO>() {
					@Override
					public int compare(FilialVO o1, FilialVO o2) {
						return o1.getTempoTotalAereo().compareTo(o2.getTempoTotalAereo());
					}
				});
			}else if(filtro.getTipoTransporte().equals(TipoTransporte.terrestre)) {
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
