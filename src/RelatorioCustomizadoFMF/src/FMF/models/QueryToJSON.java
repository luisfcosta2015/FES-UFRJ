package FMF.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/* Cuida dos elementos de leitura e escrita dentro do arquivo JSON */
/* Escreve no JSON, prepara e realiza as consultas ao BD, etc */
public class QueryToJSON {
    
    /* Pode passar o arquivo JSON no construtor. Ainda não foi feito */
    public QueryToJSON() {}
    
    /* Executa uma query e retorna seu valor na linha e coluna específicos */
    public String valorQuery(Map<String,String> atrib, String consulta, int lin, String col) {
        String cons = retornaQuery(atrib, consulta); // Consulta tratada e executável ao BD
        Object val;
        val = new Object();
        
        /* Conecta ao BD e realiza a query */
        MysqlCon sqlCon  = new MysqlCon();
        sqlCon.Conectar();
        ResultSet rs = sqlCon.query(cons);
        
        try {
            /* Itera até a linha de índice lin (indexado em 1) do ResultSet */
            int idx = 1;
            while(rs.next() && idx < lin) {
                idx++;
            }
            
            /* Guarda o valor da consulta */
            val = rs.getObject(col);
        } catch(SQLException e) {
            System.out.println(e);
        }
        
        /* Desconecta do BD e retorna o valor da consulta */
        sqlCon.Desconectar();
        return val.toString();
    }
    
    /* Substitui os valores dos atributos entre cifrão e retorna a query executável no BD */
    public String retornaQuery(Map<String,String> atrib, String consulta) {
	String cons = "";
	char c[] = consulta.toCharArray();
	for(int i = 0; i < consulta.length(); i++) {
            if(c[i] != '$') cons += c[i];
            else {
		i++;
                
                /* key é a parte da string que vai ser substituída pelo valor no mapa */
		String key = "";
		while(i < consulta.length() && c[i] != '$') {
                    key += c[i];
                    i++;
		}
                cons += atrib.get(key);
            }
	}
	return cons;
    }
}
