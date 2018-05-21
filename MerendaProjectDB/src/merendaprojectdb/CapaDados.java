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
    private int linhas = 5;
    private int colunas = 8;
    private int[][] matriculados = new int[linhas][colunas];
    public CapaDados() {
        
    }
    
    /**Método para setar uma linha inteira da matriz, cujo formato é o mesmo da 
     * mostrada na classe CapaRelatorio.
     * @author Joyce Brum
     * @param identificador int - Linha a ser modificada na matriz
     * @param turnos int[] - Vetor de tamanho 4 com os valores por turno
     * @param atendidos int - numero de alunos atendidos
     * @param numDias int - numero de dias em que foram servidos refeições
     */
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
            for(int j=0; j<4; j++) {
                this.matriculados[4][i] += this.matriculados[j][i];
            }
        }
    }
    /**Método para retornar um elemento na posicao i, j da matriz de matriculados
     * @author Joyce Brum
     * @param linha int - Número da linha
     * @param coluna int - Número da coluna
     * @return int - Valor da na posicao i,j da matriz de matriculados
     */
    public int getValueAt(int linha, int coluna) {
        return this.matriculados[linha][coluna];
    }
}
