/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merendaprojectdb;

/**
 *
 * @author joycinha
 */
public class MaisEducacao {
    public int matriculados;
    public int atendidos;
    public int numDias;
    public int totalDesjejum;
    public int totalLanche;
    public MaisEducacao(int matriculados, int atendidos, int numDias, int totalDesjejum, int totalLanche) {
        changeAll(matriculados, atendidos, numDias, totalDesjejum, totalLanche);
    }
    
    public void changeAll(int matriculados, int atendidos, int numDias, int totalDesjejum, int totalLanche) {
        this.matriculados = matriculados;
        this.atendidos = atendidos;
        this.numDias = numDias;
        this.totalDesjejum = totalDesjejum;
        this.totalLanche = totalLanche;
    }
}
