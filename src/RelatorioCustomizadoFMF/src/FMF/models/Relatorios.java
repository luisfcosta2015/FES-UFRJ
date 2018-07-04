package FMF.models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Relatorios  {
    public List<Modelo> lista_modelos;
    
    public static final String pastaArqModelos="../data/Modelos/";
    
    public Relatorios (){
        try {
            this.lista_modelos = this.buildModelos();
        } catch (IOException ex) {
            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addModelo(String nome, String arqConsult, String parametrosIN,String parametrosOUT, String descricao, String arqPDF) {  
        Modelo modelo;           
        try {
            modelo = new Modelo(nome, new ArquivoConsulta(arqConsult), parametrosIN, parametrosOUT, descricao, arqPDF);
            lista_modelos.add(modelo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        File file = new File(pastaArqModelos + nome + ".txt");
        try {
            file.createNewFile();
            FileWriter writer= new FileWriter(file);
                
           // System.out.println("Estou escrevendo "+ listaConfigs[i]);
            writer.write("NOME="+ nome + "\n");
            writer.write("ARQCONS="+ arqConsult + "\n");
            writer.write("DESC="+ descricao + "\n");
            writer.write("IN="+ parametrosIN +"\n");
            writer.write("OUT="+ parametrosOUT +"\n");
            writer.write("PDF="+ arqPDF +"\n");
            
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Relatorios.class.getName()).log(Level.SEVERE, null, ex);
        }   
              
        
    }
    
    
    //Metodo de contrucao da lista de modelos existente na ferramenta
    private List<Modelo> buildModelos() throws FileNotFoundException, IOException {
        List<Modelo> modelos = new ArrayList<>();        
                 
        File folder = new File(pastaArqModelos);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                FileReader reader= new FileReader(listOfFiles[i]);
                BufferedReader lerArq= new BufferedReader(reader);
                String nomeArq= lerArq.readLine();
                nomeArq=nomeArq.substring(nomeArq.indexOf("=")+1);
                String arqConsult=lerArq.readLine();
                arqConsult=arqConsult.substring(arqConsult.indexOf("=")+1);
                modelos.add(new Modelo(nomeArq,new ArquivoConsulta(arqConsult)));
                reader.close();                
            } 
        }
           
        return modelos;        
    }
}
    
