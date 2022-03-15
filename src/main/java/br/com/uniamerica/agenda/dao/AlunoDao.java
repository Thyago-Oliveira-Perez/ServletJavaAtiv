package br.com.uniamerica.agenda.dao;


import java.util.ArrayList;
import java.util.List;

import br.com.uniamerica.agenda.model.Aluno;

public class AlunoDao {

	private static List<Aluno> listaAlunos = new ArrayList<>();
	
	public AlunoDao() {
	}
	
	public void adicionarAluno(Aluno aluno) {
		listaAlunos.add(aluno);
	}
	
	public List<Aluno> findAllAlunos(){
		return listaAlunos;
	}
	
	public Aluno findById(int id) {
		return 	listaAlunos.get(id);
	}
	
	public List<Aluno> deletaItem(int id){
		List<Aluno>list = findAllAlunos();
		list.remove(id);
		return list;
	}
	
	public void atualizarAluno(int id, Aluno aluno) {
		listaAlunos.set(id, aluno);
	}
	
}