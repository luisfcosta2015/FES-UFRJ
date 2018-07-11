package br.com.fes.relatorios.main;

import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		System.out.println("comecou tudo");
		br.com.fes.relatorios.factory.ConexaoBanco conexao = new br.com.fes.relatorios.factory.ConexaoBanco();
		conexao.createConnection();
		
		System.out.println("Conectado ao Banco");
		
		conexao.createConnection().close();
	}
}