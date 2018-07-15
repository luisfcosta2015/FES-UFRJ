package FMF.models;

import FMF.controllers.Leitor;
import java.io.FileNotFoundException;
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
    public void geraPDFPreenchido(Map<String, String> preenchido){
    
    }
    
}
