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
@Table(name="AlunosPorTurno")
public class AlunosMatriculados {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name="AlunosPorTurno_id")
    private String id;

	@Column(name="Atendidos")
	private int atendidos;

	@Column(name="Nr_Dias_Distribuicao")
	private int nrDiasDistribuicao;

    @Column(name="Modalidade")
    private String modalidade;

    @OneToMany(mappedBy="alunosMatriculados", cascade = CascadeType.ALL)
    @OrderBy("Turno ASC")
    private List<Turno> turnos = new ArrayList<Turno>();

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MesEscolar_id")
    private MesEscolar mesEscolar;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public int getAtendidos() {
		return atendidos;
	}

	public void setAtendidos(int atendidos) {
		this.atendidos = atendidos;
	}

	public int getNrDiasDistribuicao() {
		return nrDiasDistribuicao;
	}

	public void setNrDiasDistribuicao(int nrDiasDistribuicao) {
		this.nrDiasDistribuicao = nrDiasDistribuicao;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

	public MesEscolar getMesEscolar() {
		return mesEscolar;
	}

	public void setMesEscolar(MesEscolar mesEscolar) {
		this.mesEscolar = mesEscolar;
	}
    
}
