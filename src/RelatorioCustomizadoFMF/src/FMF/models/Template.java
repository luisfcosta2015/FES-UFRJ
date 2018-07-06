/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMF.models;

import FMF.controllers.Leitor;

/**
 *
 * @author lucca
 */
public class Template {
    public final static String PATH = "../data/Templates/";
    private final static String SUFIX_DESC = "desc.txt";
    private final static String SUFIX_TEMPLATE = "template.html";
    private String folderPath;
    private String descPath;
    private String templatePath;
    
    public Template(String folderName){
        if(!"/".equals(folderName.substring(folderName.length() - 1))){
            folderName = folderName+"/";
        } 
 
        this.folderPath = PATH + folderName;
        this.descPath = this.folderPath + SUFIX_DESC;
        this.templatePath = this.folderPath + SUFIX_TEMPLATE;
    }
    
    private String getDesc(){
        return Leitor.leArquivo(this.descPath);
    }
    
    private String getTemplate(){
        return Leitor.leArquivo(this.templatePath);    
    }
    
    
}
