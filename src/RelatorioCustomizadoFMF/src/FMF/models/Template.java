/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.models;

import FMF.controllers.Leitor;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucca
 * 
 * Definição: Classe que representa os elementos HTML individualmente 
 * e o relatório como um todo em métodos estáticos
 * 
 * Todo template é representado por uma pasta nomeada com um número positivo
 * 
 * Arquivos necessários: desc.txt , template.html
 *  - desc.txt : possui a descrição do template, como seu nome e identificador único,
 *  - template.html : possui a div com as configurações visuais em html
 */
public class Template {
    private final static String PATH = "../data/Templates/";
    private final static String SUFIX_DESC = "desc.txt";
    private final static String SUFIX_TEMPLATE = "template.html";
    private final static String ESQUELETO_PATH = "Esqueleto/";
    private final static String OUT_FILE = "../data/Templates/out/out.html";
    
    public static List<Template> headers, bodys, footers;
    private final static Template esqueleto = new Template(ESQUELETO_PATH);
            
    private String folderPath;
    private String descPath;
    private String templatePath;
    private Map<String, String> atributos;
    
    public Template(String folderName){
        if(!"/".equals(folderName.substring(folderName.length() - 1))){
            folderName = folderName+"/";
        } 
 
        this.folderPath = PATH + folderName;
        this.descPath = this.folderPath + SUFIX_DESC;
        this.templatePath = this.folderPath + SUFIX_TEMPLATE;
        this.atributos = this.getAtributos();
    }
    
    public static void generatePDF(Template header, Template body, Template footer){
        PrintWriter writer = null;
        try {
            String corpo = Template.esqueleto.getTemplate();
            corpo = corpo.replace("$header$", header.getTemplate());
            corpo = corpo.replace("$body$", body.getTemplate());
            corpo = corpo.replace("$footer$", footer.getTemplate());
            writer = new PrintWriter(OUT_FILE, "UTF-8");
            writer.print(corpo);
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Template.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Template.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            writer.close();
        }
    }
    
    private String getDesc(){
        return Leitor.leArquivo(this.descPath);
    }
    
    private String getTemplate(){
        return Leitor.leArquivo(this.templatePath);    
    }
    
    private String getTemplatePreenchido(Map<String, String> valores){
        String arquivo = getTemplate();
        for (Map.Entry<String, String> it : valores.entrySet()){
            arquivo = arquivo.replace("$"+it.getKey()+"$", it.getValue());
        }
        return arquivo;
    }

    
    private Map<String, String> getAtributos(){
        String texto = getTemplate();
        Map<String, String> atributos = new HashMap<>();
        
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
                atributos.put(palavra_chave, "");
                // System.out.println(palavra_chave);
                palavra_chave=""; //reset a string p/ proxima iteracao
            }
        }
        
        
        return atributos;        
    }
    
    /* -------------MÉTODOS PRIVADOS COM ACESSO PÚBLICO PRA ACESSO----------------*/
    public String TESTgetDesc(){
        return getDesc();
    }
    public String TESTgetTemplate(){
        return getTemplate();
    }
    public String TESTgetTemplatePreenchido(Map<String, String> valores){
        return getTemplatePreenchido(valores);
    }
    public Map<String, String> TESTgetAtributos(){
        return getAtributos();
    }
}
