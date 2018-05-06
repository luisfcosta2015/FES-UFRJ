/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatoriocustomizadofmf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
    
    
}
