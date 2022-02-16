package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Atividade;
import br.com.healthtrack.exception.DBException; 

public interface AtividadeDAO {
	
	void cadastrar(Atividade atividade) throws DBException;
	void atualizar(Atividade atividade) throws DBException;
	void remover(int cdAtiv) throws DBException;
	Atividade buscar(int cdAtiv);
	List<Atividade> listar();
	
}
