package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.Peso;
import br.com.healthtrack.dao.PesoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.ConnectionManager;

public class OraclePesoDAO implements PesoDAO {

	private Connection conexao;

	@Override
	public void cadastrar(Peso peso) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SIP_PESO (CD_PESO, CD_USUARIO, VL_PESO, DT_PESO, HR_PESO) VALUES (CD_PESO.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, peso.getCdUsuario());
			stmt.setDouble(2, peso.getVlPeso());
			stmt.setString(3, peso.getDtPeso());
			stmt.setString(4, peso.getHrPeso());			

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
	public void atualizar(Peso peso) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_SIP_PESO SET VL_PESO = ?, DT_PESO = ?, HR_PESO = ?, CD_USUARIO = ? WHERE CD_PESO = ?";
			stmt = conexao.prepareStatement(sql);			
			stmt.setDouble(1, peso.getVlPeso());
			stmt.setString(2, peso.getDtPeso());
			stmt.setString(3, peso.getHrPeso());						
			stmt.setInt(4, peso.getCdUsuario());
			stmt.setInt(5, peso.getCdPeso());

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
			String sql = "DELETE FROM T_SIP_PESO WHERE CD_PESO = ?";
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
	public Peso buscar(int id) {
		Peso peso = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		try {
			conexao = ConnectionManager.getInstance().getConnection();			
			stmt = conexao.prepareStatement("SELECT * FROM T_SIP_PESO WHERE CD_PESO = ?");			
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if(rs.next()) {
				int cdPeso = rs.getInt("CD_PESO");
				int cdUsuario = rs.getInt("CD_USUARIO");				
				double vlPeso = rs.getDouble("VL_PESO");
				String dtPeso = rs.getString("DT_PESO");
				String hrPeso = rs.getString("HR_PESO");
				
				peso = new Peso(cdPeso, vlPeso, cdUsuario, dtPeso, hrPeso);

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
		return peso;
	}

	@Override
	public List<Peso> listar(){
		List<Peso> lista = new ArrayList<Peso>();
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		try {
			conexao = ConnectionManager.getInstance().getConnection();			
			stmt = conexao.prepareStatement("SELECT * FROM T_SIP_PESO ORDER BY CD_PESO DESC");			

			rs = stmt.executeQuery();

			while(rs.next()) {
				int cdPeso = rs.getInt("CD_PESO");
				int cdUsuario = rs.getInt("CD_USUARIO");
				double vlPeso = rs.getDouble("VL_PESO");
				String dtPeso = rs.getString("DT_PESO");
				String hrPeso = rs.getString("HR_PESO");				

				Peso peso = new Peso(cdPeso, vlPeso, cdUsuario, dtPeso, hrPeso);
				lista.add(peso);

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

