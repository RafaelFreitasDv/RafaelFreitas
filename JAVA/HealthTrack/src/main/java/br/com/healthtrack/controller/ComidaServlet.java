package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.healthtrack.bean.Comida;
import br.com.healthtrack.dao.ComidaDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

@WebServlet("/comida")
public class ComidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ComidaDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getComidaDAO();
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
		case "excluir":
			excluir(request, response);
			break;
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String nmComida = request.getParameter("nmComida");
			int cdUsuario = Integer.parseInt(request.getParameter("cdUsuario"));
			String dtComida = request.getParameter("dtComida");
			String hrComida = request.getParameter("hrComida");			

			Comida comida = new Comida(0, nmComida, cdUsuario, dtComida, hrComida);
			dao.cadastrar(comida);

			request.setAttribute("msg", "Alimento registrado com sucesso!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar o alimento!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar! Por favor, valide os dados.");
		}		
		listar(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int cdComida = Integer.parseInt(request.getParameter("cdComida"));
			String nmComida = request.getParameter("nmComida");
			int cdUsuario = Integer.parseInt(request.getParameter("cdUsuario"));
			String dtComida = request.getParameter("dtComida");
			String hrComida = request.getParameter("hrComida");	

			Comida comida = new Comida(cdComida, nmComida, cdUsuario, dtComida, hrComida);
			dao.atualizar(comida);

			request.setAttribute("msg", "Alimento registrado com sucesso!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar o alimento!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar! Por favor, valide os dados.");
		}
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cdComida = Integer.parseInt(request.getParameter("cdComida"));

		try {
			dao.remover(cdComida);
			request.setAttribute("msg", "Alimento removido com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao remover alimento!");
		}
		listar(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		if(acao != null && !acao.isEmpty()) {

			switch(acao) {
			case "listar":
				listar(request, response);
				break;
			case "abrir-form-edicao":
				int cdComida = Integer.parseInt(request.getParameter("cdComida"));
				Comida comida = dao.buscar(cdComida);			
				request.setAttribute("comida", comida);
				request.getRequestDispatcher("editar-comida.jsp").forward(request, response);
			}
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Comida> lista = dao.listar();
		request.setAttribute("comidas", lista);
		request.getRequestDispatcher("lista-comida.jsp").forward(request, response);
	}
}
