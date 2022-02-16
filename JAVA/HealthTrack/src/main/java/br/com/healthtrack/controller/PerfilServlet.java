package br.com.healthtrack.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.Usuario;
import br.com.healthtrack.dao.impl.OracleUsuarioDAO;


@WebServlet("/perfil")
public class PerfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OracleUsuarioDAO dao = new OracleUsuarioDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = dao.buscar(4);
		request.setAttribute("nmUser", usuario.getNmUsuario());
		request.setAttribute("bioUser", usuario.getDsBio());
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
}