package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.Peso;
import br.com.healthtrack.dao.PesoDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

@WebServlet("/peso")
public class PesoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PesoDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getPesoDAO();
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
			double vlPeso = Double.parseDouble(request.getParameter("vlPeso"));
			int cdUsuario = Integer.parseInt(request.getParameter("cdUsuario"));
			String dtPeso = request.getParameter("dtPeso");
			String hrPeso = request.getParameter("hrPeso");			

			Peso peso = new Peso(0, vlPeso, cdUsuario, dtPeso, hrPeso);
			dao.cadastrar(peso);

			request.setAttribute("msg", "Peso registrado!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar peso!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar! Por favor, valide os dados.");
		}		
		listar(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int cdPeso = Integer.parseInt(request.getParameter("cdPeso"));
			double vlPeso = Double.parseDouble(request.getParameter("vlPeso"));
			int cdUsuario = Integer.parseInt(request.getParameter("cdUsuario"));
			String dtPeso = request.getParameter("dtPeso");
			String hrPeso = request.getParameter("hrPeso");			

			Peso peso = new Peso(cdPeso, vlPeso, cdUsuario, dtPeso, hrPeso);
			dao.atualizar(peso);

			request.setAttribute("msg", "Peso registrado!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar peso!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao registrar! Por favor, valide os dados.");
		}
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cdPeso = Integer.parseInt(request.getParameter("cdPeso"));

		try {
			dao.remover(cdPeso);
			request.setAttribute("msg", "Peso removido com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao remover peso!");
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
				int cdPeso = Integer.parseInt(request.getParameter("cdPeso"));
				Peso peso = dao.buscar(cdPeso);			
				request.setAttribute("peso", peso);
				request.getRequestDispatcher("editar-peso.jsp").forward(request, response);
			}
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Peso> lista = dao.listar();
		request.setAttribute("pesos", lista);
		request.getRequestDispatcher("lista-peso.jsp").forward(request, response);
	}
}
