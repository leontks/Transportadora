package br.com.transportadora.model;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.transportadora.model.apiEnum.Prioridade;
import br.com.transportadora.model.apiEnum.TipoTransporte;

public class FilialVO implements Serializable{

	/**
	 * Usado apenas como segurança para transforma-la em uma sequência de bytes,
	 * visto que será uma API rest.
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private BigDecimal valorTotalAereo;
	private BigDecimal valorTotalTerrestre;
	private Integer tempoTotalAereo;
	private Integer tempoTotalTerrestre;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValorTotalAereo() {
		return valorTotalAereo;
	}
	public void setValorTotalAereo(BigDecimal valorTotalAereo) {
		this.valorTotalAereo = valorTotalAereo;
	}
	public BigDecimal getValorTotalTerrestre() {
		return valorTotalTerrestre;
	}
	public void setValorTotalTerrestre(BigDecimal valorTotalTerrestre) {
		this.valorTotalTerrestre = valorTotalTerrestre;
	}
	public Integer getTempoTotalAereo() {
		return tempoTotalAereo;
	}
	public void setTempoTotalAereo(Integer tempoTotalAereo) {
		this.tempoTotalAereo = tempoTotalAereo;
	}
	public Integer getTempoTotalTerrestre() {
		return tempoTotalTerrestre;
	}
	public void setTempoTotalTerrestre(Integer tempoTotalTerrestre) {
		this.tempoTotalTerrestre = tempoTotalTerrestre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public FilialVO(Long id, String nome, BigDecimal valorTotalAereo, BigDecimal valorTotalTerrestre,
			Integer tempoTotalAereo, Integer tempoTotalTerrestre) {
		super();
		this.id = id;
		this.nome = nome;
		this.valorTotalAereo = valorTotalAereo;
		this.valorTotalTerrestre = valorTotalTerrestre;
		this.tempoTotalAereo = tempoTotalAereo;
		this.tempoTotalTerrestre = tempoTotalTerrestre;
	}
	public FilialVO() {
		super();
	}
	
}
