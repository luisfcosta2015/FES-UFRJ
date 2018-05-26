package FMF.models;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class TemplateStatement {
	private Set<String> atributos;
	
	public TemplateStatement(String path) {
		this.atributos = Leitor.getAtributos(path);
	}
	
	public Set<String> getAtributos() {
		return atributos;
	}
	
	public void setAtributos(Set<String> atributos) {
		this.atributos = atributos;
	}
	
	/* Le, para cada atributo do conjunto, o seu valor correspondente para o mapeamento na consulta
	 * Ideal para ser usada como parametro para Leitor.getConsulta(String, Map<String,String>) */
	public Map<String,String> mapeiaAtributos() {
		Scanner input = new Scanner(System.in);
		Map<String,String> ret = new HashMap<>();
		for(String atrib: atributos) {
			System.out.println("Digite uma " + atrib + ": ");
			String mapeamento = input.next();
			ret.put(atrib, mapeamento);
		}
		return ret;
	}
	
	public void imprime() {
		for(String atrib: atributos) {
			System.out.println(atrib);
		}
	}
}
