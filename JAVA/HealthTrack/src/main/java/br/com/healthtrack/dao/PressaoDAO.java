package br.com.healthtrack.dao;

import java.util.List;

import br.com.healthtrack.bean.Pressao;
import br.com.healthtrack.exception.DBException; 

public interface PressaoDAO {	
	void cadastrar(Pressao pressao) throws DBException;
	void atualizar(Pressao pressao) throws DBException;
	void remover(int cdPress) throws DBException;
	Pressao buscar(int cdPress);
	List<Pressao> listar();	
}
