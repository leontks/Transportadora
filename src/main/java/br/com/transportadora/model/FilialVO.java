package br.com.transportadora.model;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.transportadora.model.apiEnum.Prioridade;

public class FilialVO implements Serializable{

	/**
	 * Usado apenas como segurança para transforma-la em uma sequência de bytes,
	 * visto que será uma API rest.
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String origem;
	private String destino;
	private BigDecimal distancia;
	private Prioridade prioridade;
	private BigDecimal valorTotalAereo;
	private BigDecimal valorTotalTerrestre;
	private Integer tempoTotalAereo;
	private Integer TempoTotalTerrestre;
	
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
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public BigDecimal getDistancia() {
		return distancia;
	}
	public void setDistancia(BigDecimal distancia) {
		this.distancia = distancia;
	}
	public Prioridade getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getTempoTotalAereo() {
		return tempoTotalAereo;
	}
	public void setTempoTotalAereo(Integer tempoTotalAereo) {
		this.tempoTotalAereo = tempoTotalAereo;
	}
	public Integer getTempoTotalTerrestre() {
		return TempoTotalTerrestre;
	}
	public void setTempoTotalTerrestre(Integer tempoTotalTerrestre) {
		TempoTotalTerrestre = tempoTotalTerrestre;
	}
	public FilialVO(Long id, String nome, String origem, String destino, BigDecimal distancia, Prioridade prioridade,
			BigDecimal valorTotalAereo, BigDecimal valorTotalTerrestre, Integer tempoTotalAereo,
			Integer tempoTotalTerrestre) {
		super();
		this.id = id;
		this.nome = nome;
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.prioridade = prioridade;
		this.valorTotalAereo = valorTotalAereo;
		this.valorTotalTerrestre = valorTotalTerrestre;
		this.tempoTotalAereo = tempoTotalAereo;
		TempoTotalTerrestre = tempoTotalTerrestre;
	}
	public FilialVO() {
		super();
	}
	
}
