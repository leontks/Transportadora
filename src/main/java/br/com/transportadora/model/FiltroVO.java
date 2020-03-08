package br.com.transportadora.model;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.transportadora.model.apiEnum.Prioridade;
import br.com.transportadora.model.apiEnum.TipoTransporte;

public class FiltroVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String origem;
	private String destino;
	private BigDecimal distancia;
	private Prioridade prioridade;
	private TipoTransporte tipoTransporte;
	
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
	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}
	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}
	public FiltroVO(String origem, String destino, BigDecimal distancia, Prioridade prioridade,
			TipoTransporte tipoTransporte) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.prioridade = prioridade;
		this.tipoTransporte = tipoTransporte;
	}
	public FiltroVO() {
		super();
	}
	
}
