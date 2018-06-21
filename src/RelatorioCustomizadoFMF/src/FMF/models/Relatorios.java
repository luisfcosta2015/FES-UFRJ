package FMF.models;
import java.util.ArrayList;
import java.util.List;

public class Relatorios  {
    public List<Modelo> lista_modelos;
    public static String nomeArqModelos;
        
    public Relatorios (String nomeArqModelos){
        nomeArqModelos = nomeArqModelos;
        this.lista_modelos = this.getModelos(nomeArqModelos);
    }
    
    public void criarModelo(String nomeModelo, String arqConsulta) {  
        Modelo modelo = new Modelo(nomeModelo, new TemplateStatement(arqConsulta));
        lista_modelos.add(modelo);
    }
    
    public List<Modelo> getModelos(String nomeArqModelos) {
        List<Modelo> modelos = new ArrayList<>();        
        return modelos;        
    }
}
    
