package br.com.healthtrack.bean;

public class Comida {
	
	//	Atributos
	
	private int cdComida;
	private String nmComida;
	private int cdUsuario;
	private String dtComida;
	private String hrComida;
	
	//	Construtor vazio
	public Comida() {
		super();
	}
	
	//	Construtor carregado
	public Comida(int cdComida, String nmComida, int cdUsuario, String dtComida, String hrComida) {
		super();
		this.cdComida = cdComida;
		this.nmComida = nmComida;
		this.cdUsuario = cdUsuario;
		this.dtComida = dtComida;
		this.hrComida = hrComida;
	}
	
	//	Getter e Setters
	public int getCdComida() {
		return cdComida;
	}

	public void setCdComida(int cdComida) {
		this.cdComida = cdComida;
	}

	public String getNmComida() {
		return nmComida;
	}

	public void setNmComida(String nmComida) {
		this.nmComida = nmComida;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getDtComida() {
		return dtComida;
	}

	public void setDtComida(String dtComida) {
		this.dtComida = dtComida;
	}

	public String getHrComida() {
		return hrComida;
	}

	public void setHrComida(String hrComida) {
		this.hrComida = hrComida;
	}
	
}
