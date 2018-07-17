package FMF.models;

import FMF.controllers.Leitor;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author lucca
 */
public class Relatorio {
    private final static String  FOLDER_PATH =  "../data/Modelos/";

    private String file_path;
    private List<ArquivoConsulta> Consultas = new ArrayList<ArquivoConsulta>();
    
    public static List<Relatorio> Relatorios = new ArrayList<Relatorio>();
    
    public String nome;
    public Template header, body, footer;
    
    public Relatorio(String JSON_Name){
        this.file_path = FOLDER_PATH + JSON_Name;
        
        JSONObject o = new JSONObject(Leitor.leArquivo(this.file_path));
        this.nome = o.getString("nome");
        
        this.header = new Template(o.getJSONObject("header").getString("id"));
        this.body = new Template(o.getJSONObject("body").getString("id"));
        this.footer = new Template(o.getJSONObject("footer").getString("id"));
        
        JSONArray cons = o.getJSONArray("consultas");
        for(Object consulta: cons){
            try {
                Consultas.add(new ArquivoConsulta(consulta.toString()));
            } catch (FileNotFoundException ex) {
                System.out.println("Problema ao ler o arquivo de consulta");
            }
        }
        
    }
    
    /*
        Carrega todos os relatórios encontrados na pasta Modelos, os instancia e
    os insere na lista global. 
     */
    public static void load(){
        File folder = new File(FOLDER_PATH);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            Relatorios.add(new Relatorio(listOfFiles[i].getName()));
        }
    }
    
    
    /*
        Essa função passa um Map onde todas as chaves são os parâmetros que o
    usuário deve informar no ato de gerar o Relatório
     */
    public Map<String, String> listaPreenchimentosNecessarios(){
        Map<String, String> necessarios = new HashMap<String, String>();
        for(ArquivoConsulta consulta:Consultas){
            //Adicionando as chaves das consultas no mapa de necessários
            Map<String, String> necessarios_cons = consulta.getAtributos();
            for (Map.Entry<String, String> entry : necessarios_cons.entrySet()){
                necessarios.put(entry.getKey(), "");
            }

        }

        JSONObject o = new JSONObject(Leitor.leArquivo(this.file_path));
        Iterator<String> chaves = o.getJSONObject("header").getJSONObject("user_input").keys();
        while(chaves.hasNext()){
            String nec = chaves.next();
            necessarios.put(nec,"");
        }
        chaves = o.getJSONObject("body").getJSONObject("user_input").keys();
        while(chaves.hasNext()){
            String nec = chaves.next();
            necessarios.put(nec,"");
        }
        chaves = o.getJSONObject("footer").getJSONObject("user_input").keys();
        while(chaves.hasNext()){
            String nec = chaves.next();
            necessarios.put(nec,"");
        }

        return necessarios;
    }
    
    /*
        Recebe o Map preenchido e, a partir disso:
        -   Preenche as Constantes no HTML
        -   Preenche os campos preenchidos pelo usuário
        -   Realiza as consultas usando o Map recebido
        -   Preenche os campos onde foram feitas as consultas
     */
    // TODO : preencher os campos obtidos da consulta
    public void geraPDFPreenchido(Map<String, String> preenchido){
        JSONObject o = new JSONObject(Leitor.leArquivo(this.file_path));

        for(ArquivoConsulta cons: Consultas){
            String c = cons.getConsulta(preenchido);
            List<String> temp = new ArrayList<String>();
            temp.add("header");
            temp.add("body");
            temp.add("footer");
            for(String corpo: temp){
                JSONObject ob = o.getJSONObject(corpo).getJSONObject("consultas");
                Iterator<String> campos = ob.keys();
                while(campos.hasNext()){
                    String campo = campos.next();
                    //se esse campo utiliza essa consulta
                    if(ob.getJSONObject(campo).getString("consulta").equals(cons.filename)){
                        preenchido.put(campo, QueryToJSON.valorQuery(preenchido, c, ob.getJSONObject(campo).getInt("pos"), ob.getJSONObject(campo).getString("campo") ));
                    }
                }
            }
        }
        
        //============= START- PREENCHIMENTO DE DADOS

        Iterator<String> constantes = o.getJSONObject("header").getJSONObject("constantes").keys();
        while(constantes.hasNext()){
            String chave = constantes.next();
            preenchido.put(chave,o.getJSONObject("header").getJSONObject("constantes").getString(chave));
        }
        constantes = o.getJSONObject("body").getJSONObject("constantes").keys();
        while(constantes.hasNext()){
            String chave = constantes.next();
            preenchido.put(chave,o.getJSONObject("body").getJSONObject("constantes").getString(chave));
        }
        constantes = o.getJSONObject("footer").getJSONObject("constantes").keys();
        while(constantes.hasNext()){
            String chave = constantes.next();
            preenchido.put(chave,o.getJSONObject("footer").getJSONObject("constantes").getString(chave));
        }
        //============= END - PREENCHIMENTO DE DADOS
        
        Template.generatePDF(this.header.getTemplatePreenchido(preenchido),
                this.body.getTemplatePreenchido(preenchido),
                this.footer.getTemplatePreenchido(preenchido));
    }
    
}
