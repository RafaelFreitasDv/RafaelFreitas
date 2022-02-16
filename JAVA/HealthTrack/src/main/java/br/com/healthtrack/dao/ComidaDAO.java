package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Comida;
import br.com.healthtrack.exception.DBException;

public interface ComidaDAO {
	
	void cadastrar(Comida comida) throws DBException;
	void atualizar(Comida comida) throws DBException;
	void remover(int cdComida) throws DBException;
	Comida buscar(int cdComida);
	List<Comida> listar();	

}
