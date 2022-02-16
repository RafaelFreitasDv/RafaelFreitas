package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Peso;
import br.com.healthtrack.exception.DBException; 

public interface PesoDAO {

	void cadastrar(Peso peso) throws DBException;
	void atualizar(Peso peso) throws DBException;
	void remover(int cdPeso) throws DBException;
	Peso buscar(int cdPeso);
	List<Peso> listar();	
}
