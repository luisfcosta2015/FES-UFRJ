package merenda.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="AnoEscolar")
public class AnoEscolar {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name="AnoEscolar_id")
    private String id;

    @Column(name="Ano")
	private int ano;
    
    @OneToMany(mappedBy="ano", cascade = CascadeType.ALL)
    private List<MesEscolar> mesesEscolares;
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Escola_id")
    private Escola escola;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public List<MesEscolar> getMesesEscolares() {
		return mesesEscolares;
	}

	public void setMesesEscolares(List<MesEscolar> mesesEscolares) {
		this.mesesEscolares = mesesEscolares;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
    
}
