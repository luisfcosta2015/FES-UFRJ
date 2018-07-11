package merenda.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Usuario_id")
	private Long id;
    
    @Column(name="Login")
	private String login;
    
    @Column(name="Senha")
	private String senha;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="Usuario_Perfil", joinColumns=@JoinColumn(name="Usuario_id"))
    private Set<Perfil> perfis;
    
    @ManyToMany(cascade = { 
    	    CascadeType.PERSIST, 
    	    CascadeType.MERGE
    	})
	@JoinTable(name = "Usuario_Escola",
	    joinColumns = @JoinColumn(name = "usuario_id"),
	    inverseJoinColumns = @JoinColumn(name = "escola_id")
	)
    private Set<Escola> escolasAdministradas;
	
	public Usuario() {}
	
	public Usuario(Long id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

	public Usuario(Usuario usuario) {
		this.id = usuario.id;
		this.login = usuario.login;
		this.perfis = usuario.perfis;
		this.senha = usuario.senha;
	}

	@Override
    public String toString() {
        return String.format(
                "Usuario [id=%d, login='%s', senha='%s']",
                id, login, senha);
    }
	
	public Set<Escola> getEscolasAdministradas() {
		return escolasAdministradas;
	}

	public void setEscolasAdministradas(Set<Escola> escolasAdministradas) {
		this.escolasAdministradas = escolasAdministradas;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}
	
}
