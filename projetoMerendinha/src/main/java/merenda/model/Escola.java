package merenda.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Escola")
public class Escola {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name="Escola_id")
    private String id;

    @Column(name="Nome")
	private String nome;

    @Column(name="CNPJ")
	private String CNPJ;

    @Column(name="Localizacao")
	private String localizacao;
    
    @OneToMany(mappedBy="escola", cascade = CascadeType.ALL)
    private List<AnoEscolar> anosEscolares;
    
    @ManyToMany(mappedBy="escolasAdministradas")
    private List<Usuario> usuariosResponsaveis;
    
	public List<Usuario> getUsuariosResponsaveis() {
		return usuariosResponsaveis;
	}
	public void setUsuariosResponsaveis(List<Usuario> usuariosResponsaveis) {
		this.usuariosResponsaveis = usuariosResponsaveis;
	}
	public List<AnoEscolar> getAnosEscolares() {
		return anosEscolares;
	}
	public void setAnosEscolares(List<AnoEscolar> anosEscolares) {
		this.anosEscolares = anosEscolares;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	

}
