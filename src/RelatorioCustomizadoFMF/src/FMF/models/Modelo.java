package FMF.models;

import java.util.Set;
import java.util.HashSet;

public class Modelo {
	private ArquivoConsulta arqConsult;
	private String nome;
        private String parametrosIN;
        private String parametrosOUT;
        private String descricao;
        private String arqPDF;      
	public Modelo(String nome, ArquivoConsulta arqConsult, String parametrosIN,String parametrosOUT, String descricao, String arqPDF) {
		this.nome = nome;
                this.arqConsult=arqConsult;
                this.parametrosIN=parametrosIN;
                this.parametrosOUT=parametrosOUT;
                this.descricao=descricao;
                this.arqPDF=arqPDF;
	}
        public Modelo(String nome, ArquivoConsulta arqConsult) {
		this.nome = nome;
                this.arqConsult=arqConsult;
        }
	
}
