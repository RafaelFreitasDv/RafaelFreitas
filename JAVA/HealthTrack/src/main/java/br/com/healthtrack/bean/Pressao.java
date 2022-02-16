package br.com.healthtrack.bean;

public class Pressao {

	//	Atributos
	private int cdPress;
	private double vlPress;
	private int cdUsuario;
	private String dtPress;
	private String hrPress;
	
	//	Construtor vazio
	public Pressao() {
		super();		
	}

	//	Construtor carregado
	public Pressao(int cdPress, double vlPress, int cdUsuario, String dtPress, String hrPress) {
		super();
		this.cdPress = cdPress;
		this.vlPress = vlPress;
		this.cdUsuario = cdUsuario;
		this.dtPress = dtPress;
		this.hrPress = hrPress;
	}

	//	Getters e Setters
	public int getCdPress() {
		return cdPress;
	}

	public void setCdPress(int cdPress) {
		this.cdPress = cdPress;
	}

	public double getVlPress() {
		return vlPress;
	}

	public void setVlPress(double vlPress) {
		this.vlPress = vlPress;
	}

	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getDtPress() {
		return dtPress;
	}

	public void setDtPress(String dtPress) {
		this.dtPress = dtPress;
	}

	public String getHrPress() {
		return hrPress;
	}

	public void setHrPress(String hrPress) {
		this.hrPress = hrPress;
	}

}
