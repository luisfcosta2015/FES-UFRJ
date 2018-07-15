package FMF.models;

import FMF.controllers.Leitor;
import java.util.HashMap;
import org.json.JSONObject;

/**
 *
 * @author lucca
 */
public class Relatorio {
    private final static String  FOLDER_PATH =  "../data/Modelos/";

    private String file_path;
    
    public String nome;
    public Template header, body, footer;
    
    public Relatorio(String JSON_Name){
        this.file_path = FOLDER_PATH + JSON_Name;
        JSONObject o = new JSONObject(Leitor.leArquivo(file_path));
        this.nome = o.getString("nome");
        
        this.header = new Template(o.getJSONObject("header").getString("id"));
        this.body = new Template(o.getJSONObject("body").getString("id"));
        this.footer = new Template(o.getJSONObject("footer").getString("id"));
        
    }
    
    
}
