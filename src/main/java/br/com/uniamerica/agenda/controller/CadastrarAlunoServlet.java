package br.com.uniamerica.agenda.controller;

import java.io.IOException;

import br.com.uniamerica.agenda.model.Aluno;
import br.com.uniamerica.agenda.service.AlunoService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CadastrarAlunoServlet extends HttpServlet{

	private AlunoService alunoService = new AlunoService();
	
	public void doPost(
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) 
	throws IOException {
		
	Aluno aluno = new Aluno();
	aluno.setNome(httpServletRequest.getParameter("nome"));
	aluno.setTurma(httpServletRequest.getParameter("turma"));
	
		if(httpServletRequest.getParameter("id") != null) {
			int id = Integer.valueOf(httpServletRequest.getParameter("id"));
			alunoService.atualizarAluno(id, aluno);
			httpServletResponse.sendRedirect("./listarAlunos.html");
		}else {
			if(alunoService.validacao(aluno)) {
				System.out.println("Aluno: " + aluno.getNome() + " Turma:" + aluno.getTurma());
				if(alunoService.adicionarAluno(aluno)){
					System.out.println("Aluno adicionado com sucesso!");
					httpServletResponse.sendRedirect("./listarAlunos.html");
				}else {
					System.out.println("Falha ao adicionar Aluno!");
				}
			}else {
				System.out.println("Inputs não preenchidos");
				httpServletResponse.sendRedirect("./aluno.html");
			}		
		}
	}
}