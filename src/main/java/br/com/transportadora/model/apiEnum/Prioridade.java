package br.com.transportadora.model.apiEnum;

public enum Prioridade {
	tempo("tempo"),
	preco("preco");

	private String prioridade;
	
	Prioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getPrioridade() {
		return prioridade;
	}
	
}
