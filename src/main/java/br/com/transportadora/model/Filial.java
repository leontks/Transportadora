package br.com.transportadora.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="Filial")
public class Filial implements Serializable {

	/**
	 * Usado apenas como segurança para transforma-la em uma sequência de bytes,
	 * visto que será uma API rest.
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Boolean terrestre;
	@Column(nullable = false)
	private Boolean aereo;
	@Column(nullable = false)
	private Integer tempoMedioAereo;
	@Column(nullable = false)
	private Integer tempoMedioTerrestre;
	@Column(nullable = false)
	private BigDecimal valorAereo;
	@Column(nullable = false)
	private BigDecimal valorTerrestre;
	
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
	public Boolean getTerrestre() {
		return terrestre;
	}
	public void setTerrestre(Boolean terrestre) {
		this.terrestre = terrestre;
	}
	public Boolean getAereo() {
		return aereo;
	}
	public void setAereo(Boolean aereo) {
		this.aereo = aereo;
	}
	public Integer getTempoMedioAereo() {
		return tempoMedioAereo;
	}
	public void setTempoMedioAereo(Integer tempoMedioAereo) {
		this.tempoMedioAereo = tempoMedioAereo;
	}
	public Integer getTempoMedioTerrestre() {
		return tempoMedioTerrestre;
	}
	public void setTempoMedioTerrestre(Integer tempoMedioTerrestre) {
		this.tempoMedioTerrestre = tempoMedioTerrestre;
	}
	public BigDecimal getValorAereo() {
		return valorAereo;
	}
	public void setValorAereo(BigDecimal valorAereo) {
		this.valorAereo = valorAereo;
	}
	public BigDecimal getValorTerrestre() {
		return valorTerrestre;
	}
	public void setValorTerrestre(BigDecimal valorTerrestre) {
		this.valorTerrestre = valorTerrestre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Filial(Long id, String nome, Boolean terrestre, Boolean aereo, Integer tempoMedioAereo,
			Integer tempoMedioTerrestre, BigDecimal valorAereo, BigDecimal valorTerrestre) {
		super();
		this.id = id;
		this.nome = nome;
		this.terrestre = terrestre;
		this.aereo = aereo;
		this.tempoMedioAereo = tempoMedioAereo;
		this.tempoMedioTerrestre = tempoMedioTerrestre;
		this.valorAereo = valorAereo;
		this.valorTerrestre = valorTerrestre;
	}
	public Filial() {
		super();
	}		
}
