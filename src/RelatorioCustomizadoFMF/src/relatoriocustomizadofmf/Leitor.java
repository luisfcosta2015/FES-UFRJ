/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriocustomizadofmf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lucca
 */
public class Leitor {
    
    public static String getConsulta(String path, Map<String,String> valores){
        String linha = "";
        
        //Recuperando a String do arquivo
        try {
            FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);

            String temp_linha = lerArq.readLine();
            linha = temp_linha + "\n"; // lê a primeira linha
            while (true) {
              temp_linha = lerArq.readLine(); // lê da segunda até a última linha
              if(temp_linha==null){break;}
              linha+= temp_linha+ "\n";
            }
          arq.close();
        } catch (IOException e) {
          System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
        }
        
        
        //Tratando a String
        for (Map.Entry<String, String> entry : valores.entrySet()){
            String palavra_chave = entry.getKey();
            String valor = entry.getValue();
            linha = linha.replace("§"+palavra_chave, valor); 
        }
        
        
        return linha;
    }
    
    static Map<String, String> getAtributos(String path) {
        String linha = "";
        Map<String,String> atributos = new HashMap<>();
        
        //entao tentei ler caracter por caracter mas a classe Buffer nao tem isso, so ler uma linha de cada vez
        //nao mudei o algoritmo do Ducca de ler o arquivo, so tratei a String toda no final
        try {
            FileReader arq = new FileReader(path);
            BufferedReader lerArq = new BufferedReader(arq);

            String temp_linha = lerArq.readLine();
            linha = temp_linha + "\n"; 
            while (true) {
              temp_linha = lerArq.readLine(); 
              if(temp_linha==null){break;}
              linha+= temp_linha+ "\n";
            }
          arq.close();
        } catch (IOException e) {
          System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
        }
        char[] vetor;
        vetor = linha.toCharArray(); //converte toda a linha lida em vetor de char, teoricamente cria o vetor como tamanho da string
        int i;
        String palavra_chave="";
        for(i=0;i < vetor.length;i++){
            if(vetor[i]=='§'){
                i++;
                while(i < vetor.length && vetor[i] != '§'){ // pega cada caracter da palavra até achar um space
                    palavra_chave+=vetor[i];                    //talvez tenhamos q rever o q marca o fim de uma palavra chave
                      i++;      
                }
                atributos.put(palavra_chave, null);
                System.out.println(palavra_chave); //print de teste
                palavra_chave=""; //reset a string p/ proxima iteracao
            }
        }
        
        
        return atributos;
        
    }
    
    
}
