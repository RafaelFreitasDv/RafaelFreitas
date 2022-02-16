package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.Comida;
import br.com.healthtrack.dao.ComidaDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.ConnectionManager;

public class OracleComidaDAO implements ComidaDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Comida comida) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SIP_COMIDA (CD_COMIDA, CD_USUARIO, NM_COMIDA, DT_COMIDA, HR_COMIDA) VALUES (CD_COMIDA.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, comida.getCdUsuario());
			stmt.setString(2, comida.getNmComida());			
			stmt.setString(3, comida.getDtComida());
			stmt.setString(4, comida.getHrComida());			

			stmt.executeUpdate();

		} catch (SQLException e) {			
			e.printStackTrace();
			throw new DBException("Erro ao cadastrar!", e);
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void atualizar(Comida comida) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_SIP_COMIDA SET NM_COMIDA = ?, DT_COMIDA = ?, HR_COMIDA = ?, CD_USUARIO = ? WHERE CD_COMIDA = ?";
			stmt = conexao.prepareStatement(sql);			
			stmt.setString(1, comida.getNmComida());
			stmt.setString(2, comida.getDtComida());
			stmt.setString(3, comida.getHrComida());
			stmt.setInt(4, comida.getCdUsuario());			
			stmt.setInt(5, comida.getCdComida());
			
			stmt.executeUpdate();

		} catch (SQLException e) {			
			e.printStackTrace();
			//			throw new DBException("Erro ao atualizar");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void remover(int cd) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "DELETE FROM T_SIP_COMIDA WHERE CD_COMIDA = ?";
			stmt = conexao.prepareStatement(sql);			
			stmt.setInt(1, cd);

			stmt.executeUpdate();

		} catch (SQLException e) {			
			e.printStackTrace();
			//			throw new DBException("Erro ao remover");
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Comida buscar(int id) {
		Comida comida = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		try {
			conexao = ConnectionManager.getInstance().getConnection();			
			stmt = conexao.prepareStatement("SELECT * FROM T_SIP_COMIDA WHERE CD_COMIDA = ?");			
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if(rs.next()) {
				int cdComida = rs.getInt("CD_COMIDA");
				int cdUsuario = rs.getInt("CD_USUARIO");				
				String nmComida = rs.getString("NM_COMIDA");
				String dtComida = rs.getString("DT_COMIDA");
				String hrComida = rs.getString("HR_COMIDA");				

				comida = new Comida(cdComida, nmComida, cdUsuario, dtComida, hrComida);

			}

		} catch (SQLException e) {			
			e.printStackTrace();
			//			throw new DBException("Erro ao remover");
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comida;
	}

	@Override
	public List<Comida> listar(){
		List<Comida> lista = new ArrayList<Comida>();
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		try {
			conexao = ConnectionManager.getInstance().getConnection();			
			stmt = conexao.prepareStatement("SELECT * FROM T_SIP_COMIDA ORDER BY CD_COMIDA DESC");			

			rs = stmt.executeQuery();

			while(rs.next()) {
				int cdComida = rs.getInt("CD_COMIDA");
				int cdUsuario = rs.getInt("CD_USUARIO");
				String nmComida = rs.getString("NM_COMIDA");
				String dtComida = rs.getString("DT_COMIDA");
				String hrComida = rs.getString("HR_COMIDA");				

				Comida comida = new Comida(cdComida, nmComida, cdUsuario, dtComida, hrComida);
				lista.add(comida);

			}

		} catch (SQLException e) {			
			e.printStackTrace();
			//			throw new DBException("Erro ao remover");
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

}
