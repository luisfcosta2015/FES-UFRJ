package merenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Perfil")
public class Perfil {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Perfil_id")
	private String id;
    
    @Column(name="TipoPerfil")
    private String tipoPerfil;
    
    Perfil () {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
    
}
