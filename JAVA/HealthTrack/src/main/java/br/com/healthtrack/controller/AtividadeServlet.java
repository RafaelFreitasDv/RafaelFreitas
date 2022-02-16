package br.com.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrack.bean.Atividade;
import br.com.healthtrack.dao.AtividadeDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

@WebServlet("/atividade")
public class AtividadeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AtividadeDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getAtividadeDAO();
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
			String nmAtiv = request.getParameter("nmAtiv");
			int cdUsuario = Integer.parseInt(request.getParameter("cdUsuario"));
			String dtAtiv = request.getParameter("dtAtiv");
			String hrAtiv = request.getParameter("hrAtiv");
			double valCal = Double.parseDouble(request.getParameter("valCal"));

			Atividade atividade = new Atividade(0, nmAtiv, cdUsuario, dtAtiv, hrAtiv, valCal);
			dao.cadastrar(atividade);

			request.setAttribute("msg", "Sua atividade foi cadastrada com sucesso!");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao cadastrar a atividade!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao cadastrar! Por favor, valide os dados.");
		}		
		listar(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int cdAtiv = Integer.parseInt(request.getParameter("cdAtiv"));
			String nmAtiv = request.getParameter("nmAtiv");
			int cdUsuario = Integer.parseInt(request.getParameter("cdUsuario"));
			String dtAtiv = request.getParameter("dtAtiv");
			String hrAtiv = request.getParameter("hrAtiv");
			double valCal = Double.parseDouble(request.getParameter("valCal"));

			Atividade atividade = new Atividade(cdAtiv, nmAtiv, cdUsuario, dtAtiv, hrAtiv, valCal);
			dao.atualizar(atividade);

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

	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cdAtiv = Integer.parseInt(request.getParameter("cdAtiv"));

		try {
			dao.remover(cdAtiv);
			request.setAttribute("msg", "Sua atividade removida com sucesso!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro ao atualizar a atividade!");
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
				int cdAtiv = Integer.parseInt(request.getParameter("cdAtiv"));
				Atividade atividade = dao.buscar(cdAtiv);			
				request.setAttribute("atividade", atividade);
				request.getRequestDispatcher("editar-atividade.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/perfil").forward(request, response);
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Atividade> lista = dao.listar();
		request.setAttribute("atividades", lista);
		request.getRequestDispatcher("lista-atividade.jsp").forward(request, response);
	}
}
