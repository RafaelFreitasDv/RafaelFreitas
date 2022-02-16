package br.com.healthtrack.bean;

public class Peso {
	
	//	Atributos
	private int cdPeso;
	private double vlPeso;
	private int cdUsuario;
	private String dtPeso;
	private String hrPeso;

	//	Construtor vazio
	public Peso() {
		super();	
	}
	
	//	Construtor carregado
	public Peso(int cdPeso, double vlPeso, int cdUsuario, String dtPeso, String hrPeso) {
		super();
		this.cdPeso = cdPeso;
		this.vlPeso = vlPeso;
		this.cdUsuario = cdUsuario;
		this.dtPeso = dtPeso;
		this.hrPeso = hrPeso;
	}
	
	//	Getters e Setters
	public int getCdPeso() {
		return cdPeso;
	}

	public void setCdPeso(int cdPeso) {
		this.cdPeso = cdPeso;
	}

	public double getVlPeso() {
		return vlPeso;
	}

	public void setVlPeso(double vlPeso) {
		this.vlPeso = vlPeso;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getDtPeso() {
		return dtPeso;
	}

	public void setDtPeso(String dtPeso) {
		this.dtPeso = dtPeso;
	}

	public String getHrPeso() {
		return hrPeso;
	}

	public void setHrPeso(String hrPeso) {
		this.hrPeso = hrPeso;
	}
	
}
