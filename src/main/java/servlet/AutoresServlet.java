package servlet;


import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AutorDAO;
import factory.ConnectionFactory;
import livraria.Autor;


@WebServlet("/autores")
public class AutoresServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private AutorDAO dao = null;
	
	public AutoresServlet() {
		this.dao = new AutorDAO(new ConnectionFactory().getConnection());
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("autores", dao.listar());
		
		req.getRequestDispatcher("WEB-INF/jsp/Autores.jsp").forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String email = req.getParameter("email");
		LocalDate dataNascimento = LocalDate.parse(req.getParameter("data_nascimento"));
		String miniCurriculo = req.getParameter("mini_curriculo");		

		Autor autor = new Autor(nome, email, dataNascimento, miniCurriculo);
		
		this.dao.cadastrar(autor);
		
		resp.sendRedirect("autores");
	}
	
	
}
