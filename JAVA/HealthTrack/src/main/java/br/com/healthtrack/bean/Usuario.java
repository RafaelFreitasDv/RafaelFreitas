package br.com.healthtrack.bean;

public class Usuario {
	
	//	Atributos
	private int cdUsuario;
	private String nmUsuario;
	private String dtNasc;
	private String dsEmail;
	private String dsSenha;
	private String dsBio;
	
	//	Construtor vazio
	public Usuario() {
		super();
	}
	
	//	Construtor carregado
	public Usuario(int cdUsuario, String nmUsuario, String dtNasc, String dsEmail, String dsSenha, String dsBio) {
		super();
		this.cdUsuario = cdUsuario;
		this.nmUsuario = nmUsuario;
		this.dsEmail = dsEmail;
		this.dtNasc = dtNasc;
		this.dsSenha = dsSenha;
		this.dsBio = dsBio;
	}
	
	//	Getter e Setters
	public int getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(int cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getNmUsuario() {
		return nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	
	public String getDsEmail() {
		return dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsSenha() {
		return dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	public String getDsBio() {
		return dsBio;
	}

	public void setDsBio(String dsBio) {
		this.dsBio = dsBio;
	}

}
