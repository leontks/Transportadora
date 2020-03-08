package br.com.transportadora.model.apiEnum;

public enum TipoTransporte {
	aereo("aereo"),
	terrestre("terrestre");

	private String tipoTransporte;
	
	private TipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}
}
