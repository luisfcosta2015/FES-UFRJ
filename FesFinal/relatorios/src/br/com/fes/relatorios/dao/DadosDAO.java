package br.com.fes.relatorios.dao;

import java.sql.SQLException;

import br.com.fes.relatorios.domain.Dados;

public class DadosDAO {
	
	public String consultar(Dados dados) throws SQLException, Exception{
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT matricula,nome,situacao FROM alunos");

		System.out.println("caminho 1");
		 if(!(dados.getMatrícula().toString().isEmpty()) || !(dados.getNome().isEmpty()) || !(dados.getIdade().isEmpty())  || !(dados.getEscola().isEmpty()) || !(dados.getSerie().isEmpty()) || !(dados.getTurma().isEmpty()) || !(dados.getSituacao().isEmpty()) ){
			System.out.println("caminho 2");
			query.append(" WHERE ");
		}
		else if(dados.getMatrícula().toString().isEmpty() && dados.getNome().isEmpty() && dados.getIdade().isEmpty()  && dados.getEscola().isEmpty() && dados.getSerie().isEmpty() && dados.getTurma().isEmpty() && dados.getSituacao().isEmpty() ){
			System.out.println("caminho 3");
			System.out.println("Query : " + query.toString());
			return query.toString();
			
		}

		// matricula
		if(!(dados.getMatrícula().toString().isEmpty())){
			query.append("matricula LIKE '" + dados.getMatrícula().toString() + "'");
			System.out.println("Query : " + query.toString());
		}
		
		//nome
		if(!(dados.getMatrícula().toString().isEmpty()) && !(dados.getNome().isEmpty())){
			query.append(" AND nome LIKE '" + dados.getNome() + "'"); 
			System.out.println("Query : " + query.toString());
		} else if(dados.getMatrícula().toString().isEmpty() && !(dados.getNome().isEmpty())){
			query.append("nome LIKE '" + dados.getNome() + "'"); 
		}
		
		//idade
		if((!(dados.getMatrícula().toString().isEmpty()) || !(dados.getNome().isEmpty())) && !(dados.getIdade().toString().isEmpty())){
			query.append(" AND idade = " + dados.getIdade());	
			System.out.println("Query : " + query.toString());
		} else if((dados.getMatrícula().toString().isEmpty() && (dados.getNome().isEmpty()) && !(dados.getIdade().isEmpty()))){ 
			query.append("idade = " + dados.getIdade());
		}
		
		//escola
		if((!(dados.getMatrícula().toString().isEmpty()) || !(dados.getNome().isEmpty()) || !(dados.getIdade().isEmpty()))  && !(dados.getEscola().isEmpty()) ){
			query.append(" AND escola LIKE '" + dados.getEscola() + "'");	
			System.out.println("Query : " + query.toString());
		} else if(dados.getMatrícula().toString().isEmpty() && dados.getNome().isEmpty() && dados.getIdade().isEmpty()  && !(dados.getEscola().isEmpty())){
			query.append("escola LIKE '" + dados.getEscola() + "'");	
		}

		//serie
		if((!(dados.getMatrícula().toString().isEmpty()) || !(dados.getNome().isEmpty()) || !(dados.getIdade().isEmpty())  || !(dados.getEscola().isEmpty())) && !(dados.getSerie().isEmpty())){
			query.append(" AND serie LIKE '" + dados.getSerie() + "'");	
			System.out.println("Query : " + query.toString());
		} else if(dados.getMatrícula().toString().isEmpty() && dados.getNome().isEmpty() && dados.getIdade().isEmpty() && dados.getEscola().isEmpty() && !(dados.getSerie().isEmpty())){
			query.append("serie LIKE '" + dados.getSerie() + "'");	
		}
		
		//turma
		if( (!(dados.getMatrícula().toString().isEmpty()) || !(dados.getNome().isEmpty()) || !(dados.getIdade().isEmpty())  || !(dados.getEscola().isEmpty()) || !(dados.getSerie().isEmpty())) && !(dados.getTurma().isEmpty()) ){
			query.append(" AND turma LIKE '" + dados.getTurma() + "'");	
			System.out.println("Query : " + query.toString());
		} else if(dados.getMatrícula().toString().isEmpty() && dados.getNome().isEmpty() && dados.getIdade().isEmpty() && dados.getEscola().isEmpty() && dados.getSerie().isEmpty() && !(dados.getTurma().isEmpty())){
			query.append("turma LIKE '" + dados.getTurma() + "'");	
		}
		
		//situacao
		if((!(dados.getMatrícula().toString().isEmpty()) || !(dados.getNome().isEmpty()) || !(dados.getIdade().isEmpty())  || !(dados.getEscola().isEmpty())) && !(dados.getSituacao().isEmpty())){
			query.append(" AND situacao LIKE '" + dados.getSituacao() + "'");	
			System.out.println("Query : " + query.toString());
		} else if(dados.getMatrícula().toString().isEmpty() && dados.getNome().isEmpty() && dados.getIdade().isEmpty() && dados.getEscola().isEmpty() && dados.getSerie().isEmpty() && dados.getTurma().isEmpty() && !(dados.getSituacao().isEmpty())){
			query.append("situacao LIKE '" + dados.getSituacao() + "'");	
		}
		
		
//SELECT matricula,nome,situacao FROM alunos
		System.out.println("Query : " + query.toString());
		return query.toString();
		
	}
	
}
