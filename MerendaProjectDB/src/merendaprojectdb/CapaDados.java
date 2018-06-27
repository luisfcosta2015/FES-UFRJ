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
    private int colunas = 8;
    private int modalidades = 4;
    public RefeicoesDados[] refeicoes = new RefeicoesDados[modalidades];
    private int[] totalRefeicoes = new int[colunas]; //a penultima posicao nao importa pois sera "-----"
    
    //variaveis referentes ao desjejum
    public int desjejumTotalMensalServido;
    public int alunosAtendidosDesjejum;
    
    //variaveis referentes ao desjejum e lanche do mais educação
    public MaisEducacao[] maisEducacao = new MaisEducacao[2];
    private int totalMaisEducacao;
    
    private int totalServido; //desjejumTotalMensalServido + totalMaisEducacao
    
    public CapaDados() {
        this.totalServido = 0;
        this.desjejumTotalMensalServido = 0;
        this.totalMaisEducacao = 0;
        zeraVetor();
        zeraMaisEducacao();
    }
    
    /**Método para setar uma linha inteira da matriz, cujo formato é o mesmo da 
     * mostrada na classe CapaRelatorio.
     * @author Joyce Brum
     * @param identificador int - Linha a ser modificada na matriz
     * @param turnos int[] - Vetor de tamanho 4 com os valores por turno
     * @param atendidos int - numero de alunos atendidos
     * @param numDias int - numero de dias em que foram servidos refeições
     */
    public void setVetorMatriculados(int identificador, int[] turnos, int numDias) {
        if(identificador >= 4) {
            return;
        }
        if(this.refeicoes[identificador] == null){
            this.refeicoes[identificador] = new RefeicoesDados(turnos[0], turnos[1],
            turnos[2], turnos[3], numDias);
        }
        else {
            this.refeicoes[identificador].changeAll(turnos[0], turnos[1],
            turnos[2], turnos[3], numDias);
        }
        calculaTotal();
    }
     /**Método para zerar o vetor totalRefeicoes
     * @author Joyce Brum
     */
    private void zeraVetor() {
        for(int i = 0; i < this.colunas; i++) {
            this.totalRefeicoes[i] = 0;
        }
    }
    /**Método para zerar o vetor MaisEducacao
     * @author Joyce Brum
     */
    private void zeraMaisEducacao() {
        this.maisEducacao[0] = new MaisEducacao(0, 0);
        this.maisEducacao[1] = new MaisEducacao(0, 0);

    }
     /**Método para calcular o vetor com os valores totais por coluna
     * @author Joyce Brum
     */
    private void calculaTotal() {
        zeraVetor();
        for(int j = 0; j < this.modalidades; j++) {
            if(this.refeicoes[j]==null) {
                continue;
            }
            for(int i=0; i < 4; i++) {
            this.totalRefeicoes[i] += this.refeicoes[j].turnos[i];
            }
            this.totalRefeicoes[4] += this.refeicoes[j].totalMatriculados;
            this.totalRefeicoes[5] += this.refeicoes[j].atendidos;
            this.totalRefeicoes[6] = this.refeicoes[j].numDias;
            this.totalRefeicoes[7] += this.refeicoes[j].totalRefeicoes;
        }  
    }
    
    /**Método para retornar um elemento na posicao i, j da matriz de matriculados
     * @author Joyce Brum
     * @param linha int - Número da linha
     * @param coluna int - Número da coluna
     * @return int - Valor da na posicao i,j da matriz de matriculados
     */
    public int getValueAt(int linha, int coluna) {
        if(linha == 4) {
            return this.totalRefeicoes[coluna];
        }
        if(this.refeicoes[linha] == null) {
            return 0;
        }
        switch(coluna) {
            case 0:
            case 1:
            case 2:
            case 3:
                return this.refeicoes[linha].turnos[coluna];
            case 4:
                return this.refeicoes[linha].totalMatriculados;
            case 5:
                return this.refeicoes[linha].atendidos;
            case 6:
                return this.refeicoes[linha].numDias;
            case 7:
                return this.refeicoes[linha].totalRefeicoes;
        }
        return 0;
    }
    
    public void setVetorMaisEducacao(int turno, int matriculados, int atendidos, int numDias) {
        if(this.maisEducacao[turno] == null) {
            this.maisEducacao[turno] = new MaisEducacao(matriculados, numDias);
        }
        else {
            this.maisEducacao[turno].changeAll(matriculados, numDias);
        }
    }
    
    public void setDesjejum(int desjejumTotalMensalServido) {
        this.alunosAtendidosDesjejum = (int)Math.floor(this.totalRefeicoes[0] * TelaEditarPadroes.porcent);
        for(RefeicoesDados dado : this.refeicoes) {
            this.desjejumTotalMensalServido += ((int)Math.floor(dado.turnos[0] * TelaEditarPadroes.porcent)) * dado.numDias;
        }
    }
    
    public int getTotalServido() {
        this.totalServido = this.desjejumTotalMensalServido + this.totalMaisEducacao;
        return this.totalServido;
    }
    public int getTotalMaisEducacao() {
        return this.totalMaisEducacao;
    }
}
