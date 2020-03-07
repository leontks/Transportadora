package br.com.transportadora.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Long id;
	private String nome;
	private BigDecimal valor;
	private String tipoTransporte;
	private Long tempoMedio;

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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public Long getTempoMedio() {
		return tempoMedio;
	}

	public void setTempoMedio(Long tempoMedio) {
		this.tempoMedio = tempoMedio;
	}

	public Filial(Long id, String nome, BigDecimal valor, String tipoTransporte, Long tempoMedio) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.tipoTransporte = tipoTransporte;
		this.tempoMedio = tempoMedio;
	}

	public Filial() {
		super();
	}
}
