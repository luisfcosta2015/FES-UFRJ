package report;

import java.sql.Date;
import java.time.Period;
import java.time.LocalDate;

class Aluno {
    String nome;
    Date nascimento;
    int registro;
    String genero;

    public Aluno (String nome, Date nascimento, int registro, String genero) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.registro = registro;
        this.genero = genero;
    }

    public int getIdade() {
        LocalDate now = LocalDate.now();
        LocalDate nasc = this.nascimento.toLocalDate();
        Period diff = Period.between(nasc, now);
        return diff.getYears();
    }
}
