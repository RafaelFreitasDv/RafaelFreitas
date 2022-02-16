package br.com.healthtrack.factory;

import br.com.healthtrack.dao.AtividadeDAO;
import br.com.healthtrack.dao.PressaoDAO;
import br.com.healthtrack.dao.PesoDAO;
import br.com.healthtrack.dao.ComidaDAO;
import br.com.healthtrack.dao.UsuarioDAO;
import br.com.healthtrack.dao.impl.OracleAtividadeDAO;
import br.com.healthtrack.dao.impl.OraclePressaoDAO;
import br.com.healthtrack.dao.impl.OraclePesoDAO;
import br.com.healthtrack.dao.impl.OracleComidaDAO;
import br.com.healthtrack.dao.impl.OracleUsuarioDAO;

public class DAOFactory {
	
	public static AtividadeDAO getAtividadeDAO() {
		return new OracleAtividadeDAO();
	}
	
	public static PressaoDAO getPressaoDAO() {
		return new OraclePressaoDAO();
	}
	
	public static PesoDAO getPesoDAO() {
		return new OraclePesoDAO();
	}
	
	public static ComidaDAO getComidaDAO() {
		return new OracleComidaDAO();
	}
	
	public static UsuarioDAO getUsuarioDAO() {
		return new OracleUsuarioDAO();
	}

}
