package merenda.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Turno")
public class Turno {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name="Turno_id")
    private String id;

	@Column(name="Matriculados")
	private int matriculados;

	@Column(name="Turno")
	private short turno;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="AlunosMatriculados_id")
    private AlunosMatriculados alunosMatriculados;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public short getTurno() {
		return turno;
	}

	public void setTurno(short turno) {
		this.turno = turno;
	}

	public int getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(int matriculados) {
		this.matriculados = matriculados;
	}

	public AlunosMatriculados getAlunosMatriculados() {
		return alunosMatriculados;
	}

	public void setAlunosMatriculados(AlunosMatriculados alunosMatriculados) {
		this.alunosMatriculados = alunosMatriculados;
	}
    
}
