package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.Usuario;
import br.com.healthtrack.dao.UsuarioDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getUsuarioDAO();
	}    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;		
		case "editar":
			editar(request, response);
			break;		
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			String nmUsuario = request.getParameter("nmUsuario");			
			String dtNasc = request.getParameter("dtNasc");
			String dsEmail = request.getParameter("dsEmail");
			String dsSenha = request.getParameter("dsSenha");
			String dsBio = request.getParameter("dsBio");

			Usuario usuario = new Usuario(0, nmUsuario, dtNasc, dsEmail, dsSenha, dsBio);
			dao.cadastrar(usuario);

			request.setAttribute("msg", "Usuário cadastrado com sucesso!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao cadastrar o usuaário!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao cadastrar! Por favor, valide os dados.");
		}		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int cdUsuario = Integer.parseInt(request.getParameter("cdUsuario"));
			String nmUsuario = request.getParameter("nmUsuario");			
			String dtNasc = request.getParameter("dtNasc");
			String dsEmail = request.getParameter("dsEmail");
			String dsSenha = request.getParameter("dsSenha");
			String dsBio = request.getParameter("dsBio");

			Usuario usuario = new Usuario(cdUsuario, nmUsuario, dtNasc, dsEmail, dsSenha, dsBio);
			dao.atualizar(usuario);

			request.setAttribute("msg", "Sua atividade foi atualizada com sucesso!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao atualizar a atividade!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao atualizar! Por favor, valide os dados.");
		}
		listar(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch(acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-edicao":
			int cdUsuario = Integer.parseInt(request.getParameter("cdUsuario"));
			Usuario usuario = dao.buscar(cdUsuario);			
			request.setAttribute("usuario", usuario);
			request.getRequestDispatcher("editar-atividade.jsp").forward(request, response);
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> lista = dao.listar();
		request.setAttribute("usuario", lista);
		request.getRequestDispatcher("lista-usuario.jsp").forward(request, response);
	}
}