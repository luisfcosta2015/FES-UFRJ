/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author lucca
 */
public class ArquivoConsulta {
    private final String path;
    private static final String DATAPATH = "../data/Consultas/";
    public ArquivoConsulta(String filename) throws FileNotFoundException{
        this.path = DATAPATH + filename;
        File file = new File(this.path);
        
        //Lança uma exeção caso não ache o arquivo
        BufferedReader reader = new BufferedReader(new FileReader(file));
    }
    
    private String leArquivo(){
        String arquivo = "";
        try {
            FileReader arq = new FileReader(this.path);
            BufferedReader lerArq = new BufferedReader(arq);

            String temp_linha = lerArq.readLine();
            arquivo = temp_linha + "\n"; 
            while (true) {
              temp_linha = lerArq.readLine(); 
              if(temp_linha==null){break;}
              arquivo+= temp_linha+ "\n";
            }
          arq.close();
        } catch (IOException e) {
          System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
        }
        return arquivo;
    }
    
    public Set<String> getAtributos() {
        String texto = this.leArquivo();
        Set<String> atributos = new HashSet<>();
        
        char[] vetor;
        vetor = texto.toCharArray(); //converte toda a linha lida em vetor de char, teoricamente cria o vetor como tamanho da string
        int i;
        String palavra_chave="";
        for(i=0;i < vetor.length;i++){
            if(vetor[i]=='$'){
                i++;
                while(i < vetor.length && vetor[i] != '$'){
                    palavra_chave+=vetor[i];
                    i++;      
                }
                atributos.add(palavra_chave);
                // System.out.println(palavra_chave);
                palavra_chave=""; //reset a string p/ proxima iteracao
            }
        }
        
        
        return atributos;
        
    }

    
}
