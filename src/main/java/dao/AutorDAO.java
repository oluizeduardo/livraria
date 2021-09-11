package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import livraria.Autor;

public class AutorDAO {
	
	private Connection conexao = null;
	
	public AutorDAO(Connection conn) {
		this.conexao = conn;
	}
	
	public void cadastrar(Autor novoAutor) {
		try {
			
			String sql = "INSERT INTO autores (nome, email, data_nascimento, mini_curriculo) VALUES (?, ?, ?, ?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			
			ps.setString(1, novoAutor.getNome());
			ps.setString(2, novoAutor.getEmail());
			ps.setDate(3, Date.valueOf(novoAutor.getDataNascimento()));
			ps.setString(4, novoAutor.getMiniCurriculo());
			
			ps.execute();
			
		} catch (SQLException e) {
			System.err.println("Erro ao conectar com o banco de dados!");
			e.printStackTrace();
		}
	}
	
	
	public List<Autor> listar(){
		
		List<Autor> autores = new ArrayList<Autor>();

		try {
			
			String sql = "SELECT * FROM autores";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Autor autor = new Autor();
				
				autor.setNome(rs.getString("nome"));
				autor.setEmail(rs.getString("email"));
				autor.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
				autor.setMiniCurriculo(rs.getString("mini_curriculo"));
				
				autores.add(autor);
			}
			
		} catch (SQLException e) {
			System.err.println("Erro ao conectar com o banco de dados!\n"+e.getMessage());
			e.printStackTrace();
		}
		return autores;
	}
}
