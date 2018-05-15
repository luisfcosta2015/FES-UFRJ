package relatoriocustomizadofmf;

import java.util.Set;
import java.util.HashSet;

public class Modelo {
	private Set<TemplateStatement> templates;
	private String nome;

	public Modelo(String nome) {
		this.templates = new HashSet<>();
		this.nome = nome;
	}
	
	public void addTemplate(TemplateStatement stmt) {
		templates.add(stmt);
	}
}
