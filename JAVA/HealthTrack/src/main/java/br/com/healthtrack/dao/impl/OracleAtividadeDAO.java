package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.bean.Atividade;
import br.com.healthtrack.dao.AtividadeDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.ConnectionManager;

public class OracleAtividadeDAO implements AtividadeDAO {

	private Connection conexao;

	@Override
	public void cadastrar(Atividade atividade) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SIP_ATIV (CD_ATIV, CD_USUARIO, NM_ATIV, DT_ATIV, HR_ATIV, VAL_CAL) VALUES (CD_ATIV.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, atividade.getCdUsuario());
			stmt.setString(2, atividade.getNmAtiv());
			stmt.setString(3, atividade.getDtAtiv());
			stmt.setString(4, atividade.getHrAtiv());
			stmt.setDouble(5, atividade.getValCal());

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
	public void atualizar(Atividade atividade) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_SIP_ATIV SET NM_ATIV = ?, DT_ATIV = ?, HR_ATIV = ?, VAL_CAL = ?, CD_USUARIO = ? WHERE CD_ATIV = ?";
			stmt = conexao.prepareStatement(sql);			
			stmt.setString(1, atividade.getNmAtiv());
			stmt.setString(2, atividade.getDtAtiv());
			stmt.setString(3, atividade.getHrAtiv());
			stmt.setDouble(4, atividade.getValCal());			
			stmt.setInt(5, atividade.getCdUsuario());
			stmt.setInt(6, atividade.getCdAtiv());

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
			String sql = "DELETE FROM T_SIP_ATIV WHERE CD_ATIV = ?";
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
	public Atividade buscar(int id) {
		Atividade atividade = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		try {
			conexao = ConnectionManager.getInstance().getConnection();			
			stmt = conexao.prepareStatement("SELECT * FROM T_SIP_ATIV WHERE CD_ATIV = ?");			
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if(rs.next()) {
				int cdAtiv = rs.getInt("CD_ATIV");
				int cdUsuario = rs.getInt("CD_USUARIO");				
				String nmAtiv = rs.getString("NM_ATIV");
				String dtAtiv = rs.getString("DT_ATIV");
				String hrAtiv = rs.getString("HR_ATIV");
				double valCal = rs.getDouble("VAL_CAL");

				atividade = new Atividade(cdAtiv, nmAtiv, cdUsuario, dtAtiv, hrAtiv, valCal);

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
		return atividade;
	}

	@Override
	public List<Atividade> listar(){
		List<Atividade> lista = new ArrayList<Atividade>();
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		try {
			conexao = ConnectionManager.getInstance().getConnection();			
			stmt = conexao.prepareStatement("SELECT * FROM T_SIP_ATIV ORDER BY CD_ATIV DESC");			

			rs = stmt.executeQuery();

			while(rs.next()) {
				int cdAtiv = rs.getInt("CD_ATIV");
				int cdUsuario = rs.getInt("CD_USUARIO");
				String nmAtiv = rs.getString("NM_ATIV");
				String dtAtiv = rs.getString("DT_ATIV");
				String hrAtiv = rs.getString("HR_ATIV");
				double valCal = rs.getDouble("VAL_CAL");

				Atividade atividade = new Atividade(cdAtiv, nmAtiv, cdUsuario, dtAtiv, hrAtiv, valCal);
				lista.add(atividade);

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
