package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.Pressao;
import br.com.healthtrack.dao.PressaoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

@WebServlet("/pressao")
public class PressaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PressaoDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getPressaoDAO();
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
			double vlPress = Double.parseDouble(request.getParameter("vlPress"));
			int cdUsuario = Integer.parseInt(request.getParameter("cdUsuario"));
			String dtPress = request.getParameter("dtPress");
			String hrPress = request.getParameter("hrPress");			

			Pressao pressao = new Pressao(0, vlPress, cdUsuario, dtPress, hrPress);
			dao.cadastrar(pressao);

			request.setAttribute("msg", "Pressão registrada com sucesso!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar! Por favor, valide os dados.");
		}		
		listar(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int cdPress = Integer.parseInt(request.getParameter("cdPress"));
			double vlPress = Double.parseDouble(request.getParameter("vlPress"));
			int cdUsuario = Integer.parseInt(request.getParameter("cdUsuario"));
			String dtPress = request.getParameter("dtPress");
			String hrPress = request.getParameter("hrPress");

			Pressao pressao = new Pressao(cdPress, vlPress, cdUsuario, dtPress, hrPress);
			dao.atualizar(pressao);

			request.setAttribute("msg", "Pressão registrada com sucesso!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar! Por favor, valide os dados.");
		}
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cdPress = Integer.parseInt(request.getParameter("cdPress"));


		try {
			dao.remover(cdPress);
			request.setAttribute("msg", "Pressão registrada com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar");
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
				int cdPress = Integer.parseInt(request.getParameter("cdPress"));
				Pressao pressao = dao.buscar(cdPress);			
				request.setAttribute("pressao", pressao);
				request.getRequestDispatcher("editar-pressao.jsp").forward(request, response);
			}
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Pressao> lista = dao.listar();
		request.setAttribute("pressao", lista);
		request.getRequestDispatcher("lista-pressao.jsp").forward(request, response);
	}
}
