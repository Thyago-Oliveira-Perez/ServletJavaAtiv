package br.com.uniamerica.agenda.service;

import java.util.ArrayList;
import java.util.List;

import br.com.uniamerica.agenda.dao.AlunoDao;
import br.com.uniamerica.agenda.model.Aluno;

public class AlunoService {

	AlunoDao alunoDao = new AlunoDao();
	
	public List<Aluno> listarAlunos(){
		
		List<Aluno> listaDeAlunos = new ArrayList<Aluno>();
		
		int tamanhoLista = alunoDao.findAllAlunos().size();
		
		for(int i = 0; i < tamanhoLista; i++) {
			listaDeAlunos.add(alunoDao.findAllAlunos().get(i));			
		}
		
		return listaDeAlunos;
	}
	
	public void deletarAluno(int id) {
		
		alunoDao.deletaItem(id);
	
	}
	
	public boolean validacao(Aluno aluno) {
		
		if(aluno.getNome().isEmpty() && aluno.getTurma().isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
	public boolean adicionarAluno(Aluno aluno) {
		alunoDao.adicionarAluno(aluno);
		return true;
	}
	
	public boolean atualizarAluno(int id, Aluno aluno) {
		alunoDao.atualizarAluno(id, aluno);
		return true;
	}
	
	public Aluno findById(int id) {
		return alunoDao.findById(id);
	}
}
