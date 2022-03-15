package br.com.uniamerica.agenda.controller;

import java.io.IOException;
import java.io.PrintWriter;

import br.com.uniamerica.agenda.model.Aluno;
import br.com.uniamerica.agenda.service.AlunoService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class EditarAlunoServlet extends HttpServlet{

	private AlunoService alunoService = new AlunoService();
	
	public void doPost(
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) 
	throws IOException {
		
		httpServletResponse.setContentType("text/html");
		PrintWriter printWriter = httpServletResponse.getWriter();
		
		Aluno aluno = new Aluno();
		int id = Integer.valueOf(httpServletRequest.getParameter("id"));
		aluno.setNome(alunoService.findById(id).getNome());
		aluno.setTurma(alunoService.findById(id).getTurma());
		
		printWriter.println("<html><head><link href=\"index.css\" rel=\"stylesheet\"></head>");
		printWriter.println("<body><div class='link'>"
				+ "<a href='menu.html'>Voltar ao Menu</a>"
				+ "</div>");
		printWriter.println(""
				+ "<div class='container'>"
				+ "	<form action=cadastrarAluno method='post' id='form'>"
				+ "		<div class='box'>"
				+ "			<div class='title'>"
				+ "		    	<h1>Editar Aluno</h1>"
				+ "		    </div>"
				+ "		    <div class='input'>"
				+ "		        <label>Nome Aluno</label>"
				+ "		        <input type='text' name='nome' value='"+aluno.getNome()+"' id='nome'>"
				+ "		    </div>"
				+ "		    <div class='input'>"
				+ "		    	<label>Turma</label>"
				+ "		        <input type='text' name='turma' value='"+aluno.getTurma()+"' id='turma'>"
				+ "		    </div>"
				+ "         <input type='hidden' name='id' value='"+id+"'>"
				+ "		    <input type='submit' class='button' value='editar'>"
				+ "	    </div>"
				+ "	</form>"
				+ "</div>");
		printWriter.print("</body></html>");
	}

}
