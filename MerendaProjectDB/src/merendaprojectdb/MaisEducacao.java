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
    public MaisEducacao(int matriculados, int numDias) {
        changeAll(matriculados, numDias);
    }
    
    public void changeAll(int matriculados, int numDias) {
        this.matriculados = matriculados;
        this.atendidos = (int)Math.floor(matriculados * TelaEditarPadroes.porcent);
        this.numDias = numDias;
        this.totalDesjejum = this.atendidos * numDias;
        this.totalLanche = this.totalDesjejum;
    }
}
