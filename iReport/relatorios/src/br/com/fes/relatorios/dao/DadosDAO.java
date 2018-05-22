package br.com.fes.relatorios.dao;

import br.com.fes.relatorios.domain.Dados;

public class DadosDAO {
	
	public String salvar(Dados dados){
		
		StringBuilder query = new StringBuilder();
		
		query.append("SELECT * FROM alunos");
		
		if(!(dados.getMatrícula().toString().isEmpty()) || !(dados.getNome().isEmpty()) || !(dados.getIdade().isEmpty()) || !(dados.getDataNascimento().toString().isEmpty()) || !(dados.getEscola().isEmpty()) || !(dados.getSerie().isEmpty())){
			query.append(" WHERE ");
		} else if(dados.getMatrícula().toString().isEmpty() && dados.getNome().isEmpty() && dados.getIdade().isEmpty() && dados.getDataNascimento().toString().isEmpty() && dados.getEscola().isEmpty() && dados.getSerie().isEmpty()){
			return query.toString();
		}

		
		
		if(!(dados.getMatrícula().toString().isEmpty())){
			query.append("matricula LIKE '" + dados.getMatrícula().toString() + "'");
		}
		
		if(!(dados.getMatrícula().toString().isEmpty()) && !(dados.getNome().isEmpty())){
			query.append(" AND nome LIKE '" + dados.getNome() + "'"); 
		} else if(dados.getMatrícula().toString().isEmpty() && !(dados.getNome().isEmpty())){
			query.append("nome LIKE '" + dados.getNome() + "'"); 
		}
		
		if(!(dados.getMatrícula().toString().isEmpty()) || !(dados.getNome().isEmpty()) && !(dados.getIdade().isEmpty())){
			query.append(" AND idade = " + dados.getIdade());	
		} else if((dados.getMatrícula().toString().isEmpty() && (dados.getNome().isEmpty()) && !(dados.getIdade().isEmpty()))){ 
			query.append("idade = " + dados.getIdade());
		}
		
		if(!(dados.getMatrícula().toString().isEmpty()) || !(dados.getNome().isEmpty()) || !(dados.getIdade().isEmpty()) && !(dados.getDataNascimento().toString().isEmpty())){
			query.append(" AND dadoNascimento = '" + dados.getDataNascimento().getYear() + "-" + (dados.getDataNascimento().getMonth() + 1) + "-" + dados.getDataNascimento().getDate() + "'");	
		} else if((dados.getMatrícula().toString().isEmpty() && (dados.getNome().isEmpty()) && dados.getIdade().isEmpty() && !(dados.getDataNascimento().toString().isEmpty()))){ 
			query.append(" AND dadoNascimento = '" + dados.getDataNascimento().getYear() + "-" + (dados.getDataNascimento().getMonth() + 1) + "-" + dados.getDataNascimento().getDate() + "'");	
		}
		
		if(!(dados.getMatrícula().toString().isEmpty()) || !(dados.getNome().isEmpty()) || !(dados.getIdade().isEmpty()) || !(dados.getDataNascimento().toString().isEmpty()) && !(dados.getEscola().isEmpty())){
			query.append(" AND escola LIKE '" + dados.getEscola() + "'");	
		} else if(dados.getMatrícula().toString().isEmpty() && dados.getNome().isEmpty() && dados.getIdade().isEmpty() && dados.getDataNascimento().toString().isEmpty() && !(dados.getEscola().isEmpty())){
			query.append("escola LIKE '" + dados.getEscola() + "'");	
		}

		if(!(dados.getMatrícula().toString().isEmpty()) || !(dados.getNome().isEmpty()) || !(dados.getIdade().isEmpty()) || !(dados.getDataNascimento().toString().isEmpty()) || !(dados.getEscola().isEmpty()) && !(dados.getSerie().isEmpty())){
			query.append(" AND serie LIKE '" + dados.getSerie() + "'");	
		} else if(dados.getMatrícula().toString().isEmpty() && dados.getNome().isEmpty() && dados.getIdade().isEmpty() && dados.getDataNascimento().toString().isEmpty() && dados.getEscola().isEmpty() && !(dados.getSerie().isEmpty())){
			query.append("serie LIKE '" + dados.getSerie() + "'");	
		}

		return query.toString();
		
	}
	
}
