package br.com.healthtrack.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.com.healthtrack.bean.Usuario;
import br.com.healthtrack.dao.UsuarioDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.singleton.ConnectionManager;

public class OracleUsuarioDAO implements UsuarioDAO {
	
	private Connection conexao;

	@Override
	public void cadastrar(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "INSERT INTO T_SIP_USUARIO (CD_USUARIO, NM_USUARIO, DT_NASC, DS_EMAIL, DS_SENHA, DS_BIO) VALUES (CD_USUARIO.NEXTVAL, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);			
			stmt.setString(1, usuario.getNmUsuario());
			stmt.setString(2, usuario.getDtNasc());
			stmt.setString(3, usuario.getDsEmail());
			stmt.setString(4, usuario.getDsSenha());
			stmt.setString(5, usuario.getDsBio());

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
	public void atualizar(Usuario usuario) throws DBException {
		PreparedStatement stmt = null;

		try {
			conexao = ConnectionManager.getInstance().getConnection();
			String sql = "UPDATE T_SIP_USUARIO SET NM_USUARIO = ?, DT_NASC = ?, DS_EMAIL = ?, DS_SENHA = ?, DS_BIO = ? WHERE CD_USUARIO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, usuario.getNmUsuario());
			stmt.setString(2, usuario.getDtNasc());
			stmt.setString(3, usuario.getDsEmail());
			stmt.setString(4, usuario.getDsSenha());
			stmt.setString(5, usuario.getDsBio());
			stmt.setInt(6,  usuario.getCdUsuario());
			
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
			String sql = "DELETE FROM T_SIP_USUARIO WHERE CD_USUARIO = ?";
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
	public Usuario buscar(int id) {
		Usuario usuario = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		try {
			conexao = ConnectionManager.getInstance().getConnection();			
			stmt = conexao.prepareStatement("SELECT * FROM T_SIP_USUARIO WHERE CD_USUARIO = ?");			
			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if(rs.next()) {				
				int cdUsuario = rs.getInt("CD_USUARIO");				
				String nmUsuario = rs.getString("NM_USUARIO");
				String dtNasc = rs.getString("DT_NASC");
				String dsEmail = rs.getString("DS_EMAIL");
				String dsSenha = rs.getString("DS_SENHA");
				String dsBio = rs.getString("DS_BIO");

				usuario = new Usuario(cdUsuario, nmUsuario, dtNasc, dsEmail, dsSenha, dsBio);

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
		return usuario;
	}

	@Override
	public List<Usuario> listar(){
		List<Usuario> lista = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		ResultSet rs = null;		

		try {
			conexao = ConnectionManager.getInstance().getConnection();			
			stmt = conexao.prepareStatement("SELECT * FROM T_SIP_USUARIO ORDER BY CD_USUARIO DESC");			

			rs = stmt.executeQuery();

			while(rs.next()) {
				int cdUsuario = rs.getInt("CD_USUARIO");				
				String nmUsuario = rs.getString("NM_USUARIO");
				String dtNasc = rs.getString("DT_NASC");
				String dsEmail = rs.getString("DS_EMAIL");
				String dsSenha = rs.getString("DS_SENHA");
				String dsBio = rs.getString("DS_BIO");				
				

				Usuario usuario = new Usuario(cdUsuario, nmUsuario, dtNasc, dsEmail, dsSenha, dsBio);
				lista.add(usuario);

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
