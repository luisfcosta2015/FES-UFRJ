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
public class CapaDados {
    int linhas = 5;
    int colunas = 8;
    int[][] matriculados = new int[linhas][colunas];
    public CapaDados() {
        
    }
    
    public void setVetorMatriculados(int identificador, int[] turnos, int atendidos, int numDias) {
        int soma = 0;
        for(int i=0; i < 4;i++) {
            soma += turnos[i];
            this.matriculados[identificador][i] = turnos[i];
        }
        this.matriculados[identificador][4] = soma;
        this.matriculados[identificador][5] = atendidos;
        this.matriculados[identificador][6] = numDias;
        this.matriculados[identificador][7] = atendidos*numDias;
        //calcula o total
        for(int i=0; i<colunas; i++) {
            this.matriculados[4][i] = 0;
            for(int j=0; j<linhas; j++) {
                this.matriculados[4][i] += this.matriculados[i][j];
            }
        }
    }
}
