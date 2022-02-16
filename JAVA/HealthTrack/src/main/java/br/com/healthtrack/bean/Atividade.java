package br.com.healthtrack.bean;

public class Atividade {

	//	Atributos
	private int cdAtiv;
	private int cdUsuario;
	private String nmAtiv;	
	private String dtAtiv;
	private String hrAtiv;
	private double valCal;

	//	Construtor vazio
	public Atividade() {
		super();
	}

	// Construtor carregado
	public Atividade(int cdAtiv, String nmAtiv, int cdUsuario, String dtAtiv, String hrAtiv, double valCal) {
		super();
		this.cdAtiv = cdAtiv;
		this.cdUsuario = cdUsuario;
		this.nmAtiv = nmAtiv;
		this.dtAtiv = dtAtiv;
		this.hrAtiv = hrAtiv;
		this.valCal = valCal;		
	}

	// Getters e Setters
	public int getCdAtiv() {
		return cdAtiv;
	}

	public void setCdAtiv(int cdAtiv) {
		this.cdAtiv = cdAtiv;
	}
	
	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getNmAtiv() {
		return nmAtiv;
	}

	public void setNmAtiv(String nmAtiv) {
		this.nmAtiv = nmAtiv;
	}

	public String getDtAtiv() {
		return dtAtiv;
	}

	public void setDtAtiv(String dtAtiv) {
		this.dtAtiv = dtAtiv;
	}

	public String getHrAtiv() {
		return hrAtiv;
	}

	public void setHrAtiv(String hrAtiv) {
		this.hrAtiv = hrAtiv;
	}

	public double getValCal() {
		return valCal;
	}

	public void setValCal(double valCal) {
		this.valCal = valCal;
	}	

}
