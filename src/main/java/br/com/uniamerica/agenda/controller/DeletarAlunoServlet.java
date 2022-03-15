package br.com.uniamerica.agenda.controller;

import java.io.IOException;

import br.com.uniamerica.agenda.service.AlunoService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeletarAlunoServlet extends HttpServlet{

	private AlunoService alunoService = new AlunoService();
	
	public void doPost(
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) 
	throws IOException {
		int id = Integer.valueOf(httpServletRequest.getParameter("id"));
		
		alunoService.deletarAluno(id);
		
		httpServletResponse.sendRedirect("./listarAlunos.html");
	}
}
