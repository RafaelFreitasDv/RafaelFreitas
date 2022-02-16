package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.Pressao;
import br.com.healthtrack.dao.PressaoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.ConnectionManager;

public class OraclePressaoDAO implements PressaoDAO {

	private Connection conexao;

	@Override
	public void cadastrar(Pressao pressao) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SIP_PRESSAO (CD_PRESSAO, CD_USUARIO, VL_PRESSAO, DT_PRESSAO, HR_PRESSAO) VALUES (CD_PRESSAO.NEXTVAL, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, pressao.getCdUsuario());
			stmt.setDouble(2, pressao.getVlPress());
			stmt.setString(3, pressao.getDtPress());
			stmt.setString(4, pressao.getHrPress());			

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
	public void atualizar(Pressao pressao) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_SIP_PRESSAO SET VL_PRESSAO = ?, DT_PRESSAO = ?, HR_PRESSAO = ?, CD_USUARIO = ? WHERE CD_PRESSAO = ?";
			stmt = conexao.prepareStatement(sql);			
			stmt.setDouble(1, pressao.getVlPress());
			stmt.setString(2, pressao.getDtPress());
			stmt.setString(3, pressao.getHrPress());						
			stmt.setInt(4, pressao.getCdUsuario());
			stmt.setInt(5, pressao.getCdPress());

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
			String sql = "DELETE FROM T_SIP_PRESSAO WHERE CD_PRESSAO = ?";
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
	public Pressao buscar(int id) {
		Pressao pressao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		try {
			conexao = ConnectionManager.getInstance().getConnection();			
			stmt = conexao.prepareStatement("SELECT * FROM T_SIP_PRESSAO WHERE CD_PRESSAO = ?");			
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if(rs.next()) {
				int cdPress = rs.getInt("CD_PRESSAO");
				int cdUsuario = rs.getInt("CD_USUARIO");				
				double vlPress = rs.getDouble("VL_PRESSAO");
				String dtPress = rs.getString("DT_PRESSAO");
				String hrPress = rs.getString("HR_PRESSAO");
				

				pressao = new Pressao(cdPress, vlPress, cdUsuario, dtPress, hrPress);

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
		return pressao;
	}

	@Override
	public List<Pressao> listar(){
		List<Pressao> lista = new ArrayList<Pressao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		try {
			conexao = ConnectionManager.getInstance().getConnection();			
			stmt = conexao.prepareStatement("SELECT * FROM T_SIP_PRESSAO ORDER BY CD_PRESSAO DESC");			

			rs = stmt.executeQuery();

			while(rs.next()) {
				int cdPress = rs.getInt("CD_PRESSAO");
				double vlPress = rs.getDouble("VL_PRESSAO");
				int cdUsuario = rs.getInt("CD_USUARIO");
				String dtPress = rs.getString("DT_PRESSAO");
				String hrPress = rs.getString("HR_PRESSAO");
				
				Pressao pressao = new Pressao(cdPress, vlPress, cdUsuario, dtPress, hrPress);
				lista.add(pressao);

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
