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
public class RefeicoesDados {
    public int[] turnos = new int[4];
    public int totalMatriculados;
    public int atendidos;
    public int numDias;
    public int totalRefeicoes;
    public RefeicoesDados(int turno1, int turno2, int turno3, int turno4, 
            int atendidos, int numDias) {
        changeAll(turno1, turno2, turno3, turno4, atendidos, numDias);
    }
    public void changeAll(int turno1, int turno2, int turno3, int turno4, 
            int atendidos, int numDias) {
        this.turnos[0] = turno1;
        this.turnos[1] = turno2;
        this.turnos[2] = turno3;
        this.turnos[3] = turno4;
        this.totalMatriculados = turno1 + turno2 + turno3 + turno4;
        this.atendidos = atendidos;
        this.numDias = numDias;
        this.totalRefeicoes = atendidos * numDias;
    }
}
