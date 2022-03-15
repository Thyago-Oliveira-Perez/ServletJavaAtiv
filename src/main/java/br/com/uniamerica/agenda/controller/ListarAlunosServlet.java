package br.com.uniamerica.agenda.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.com.uniamerica.agenda.model.Aluno;
import br.com.uniamerica.agenda.service.AlunoService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ListarAlunosServlet extends HttpServlet{

	private AlunoService alunoService = new AlunoService();
	
	public void doGet(
			HttpServletRequest httpServletRequest, 
			HttpServletResponse httpServletResponse) 
	throws IOException {
		
		httpServletResponse.setContentType("text/html");
		PrintWriter printWriter = httpServletResponse.getWriter();
		printWriter.println("<body>"
				+ "<a href='aluno.html'>Adicionar mais Alunos</a>");
		printWriter.println("<h1>Lista De Alunos</h1>");
		
        List<Aluno> listAlunos = alunoService.listarAlunos();
        
        printWriter.print("<table border='1' width='100%'>");
        printWriter.print("<tr><th>Nome</th><th>Turma</th><th>Opções</th></tr>");  
       for(Aluno a:listAlunos){  
    	   printWriter.print("<tr><td>"+ a.getNome() + "</td>"
    	   		+ "<td>" + a.getTurma() + "</td>"
    	   				+ "<td><div class='options'>"
    	   				+ "<form action='editarAluno' method='post'>"
    	   					+ "<input type='hidden' name='id' value='"+listAlunos.indexOf(a)+"'>"
    	   					+ "<button type='submit'>editar</button>"
    	   				+ "</form>"
    	   				+ "<form action='deletarAluno' method='post'>"
    	   					+ "<input type='hidden' name='id' value='"+listAlunos.indexOf(a)+"'>"
   							+ "<button type='submit'>apagar</button>"
    	   				+ "</form>"
    	   				+ "</div></td></tr>");
       }
       printWriter.print("</table></body></html>");
	}
}