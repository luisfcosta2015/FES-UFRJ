/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author lucca
 * 
 * Classe responsável por fazer a leitura de arquivos
 */
public class Leitor {
    public static String leArquivo(String path){
        String arquivo = "";
        try {
            FileReader arq = new FileReader(path);
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

}
