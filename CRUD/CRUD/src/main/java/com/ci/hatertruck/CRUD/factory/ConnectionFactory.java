package com.ci.hatertruck.CRUD.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Classe responsavel por criar 
 * e futuramente administrar as 
 * conexoes ativas com o banco de dados
 */
public class ConnectionFactory {
	
	// Infomacoes necessarias para criar uma conexao com o banco de dados
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "postgres";
	public static final String DB_DRIVER = "org.postgresql.Driver";
	public static final String DB_URL = "jdbc:postgresql://localhost:5432/hatertruck";
	
	// Estabelece a conexao com o banco de dados
	public static Connection createConnection() {
		try {
			Class.forName(DB_DRIVER);
			Connection conexao = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			return conexao;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
