package merenda.model;

import java.util.ArrayList;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="MesEscolar")
public class MesEscolar {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name="MesEscolar_id")
    private String id;

    @Column(name="Mes")
	private short mes;
    
    @OneToMany(mappedBy="mesEscolar", cascade = CascadeType.ALL)
    @OrderBy("Modalidade ASC")
    private List<AlunosMatriculados> alunosMatriculados = new ArrayList<AlunosMatriculados>();
	
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="AnoEscolar_id")
    private AnoEscolar ano;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<AlunosMatriculados> getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(List<AlunosMatriculados> alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}

	public short getMes() {
		return mes;
	}

	public void setMes(short mes) {
		this.mes = mes;
	}

	public AnoEscolar getAno() {
		return ano;
	}

	public void setAno(AnoEscolar ano) {
		this.ano = ano;
	}

}
