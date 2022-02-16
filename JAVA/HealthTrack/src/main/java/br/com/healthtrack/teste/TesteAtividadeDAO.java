package br.com.healthtrack.teste;

import java.util.List;

import br.com.healthtrack.bean.Atividade;
import br.com.healthtrack.dao.AtividadeDAO;
import br.com.healthtrack.exception.DBException;
import br.com.healthtrack.factory.DAOFactory;

public class TesteAtividadeDAO {

	public static void main(String[] args) {
		AtividadeDAO dao = DAOFactory.getAtividadeDAO();
		
		Atividade atividade = new Atividade(0, "Corrida", 4, "21/11/21","08h45", 234.32);
		
		try {
			dao.cadastrar(atividade);
			System.out.println("Atividade cadastrada com sucesso!");
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		atividade = dao.buscar(8);
		atividade.setNmAtiv("Corrida de explosão");
		atividade.setValCal(393.23);
		try {
			dao.atualizar(atividade);
			System.out.println("Atividade atualizada com sucesso!");
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Atividade> lista = dao.listar();
		for(Atividade item: lista) {
			System.out.println(item.getNmAtiv() + "" + item.getDtAtiv() + "" + item.getHrAtiv() + "" + item.getValCal());
		}
		
//		try {
//			dao.remover(6);
//			System.out.println("Produto removido com sucesso!");
//		} catch (DBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
	}	
}
