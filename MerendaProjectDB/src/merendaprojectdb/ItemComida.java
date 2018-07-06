    package merendaprojectdb;
// @author joycinha

public class ItemComida {
    public String tipoItem;
    public int estoqueInicial;
    public int semana1Entrada;
    public int semana1Saida;
    public int semana2Entrada;
    public int semana2Saida;
    public int semana3Entrada;
    public int semana3Saida;
    public int semana4Entrada;
    public int semana4Saida;
    public int semana5Entrada;
    public int semana5Saida;
    public int remanejamentoEntrada;
    public int remanejamentoSaida;
    public int ataSaida;
    public int totalEntrada;
    public int totalSaida;
    public int estoqueFinal;
    public String unidade;
    ItemComida(String tipoItem, int estoqueInicial, int semana1Entrada, int semana1Saida, int semana2Entrada, int semana2Saida, int semana3Entrada, int semana3Saida, int semana4Entrada, int semana4Saida,int semana5Entrada, int semana5Saida, int remanejamentoEntrada, int remanejamentoSaida, int ataSaida, int totalEntrada, int totalSaida,int estoqueFinal, String unidade) {
        this.tipoItem = tipoItem;
        this.estoqueInicial=estoqueInicial;
        this.semana1Entrada=semana1Entrada;
        this.semana1Saida=semana1Saida;
        this.semana2Entrada=semana2Entrada;
        this.semana2Saida=semana2Saida;
        this.semana3Entrada=semana3Entrada;
        this.semana3Saida=semana3Saida;
        this.semana4Entrada=semana4Entrada;
        this.semana4Saida=semana4Saida;
        this.semana5Entrada=semana5Entrada;
        this.semana5Saida=semana5Saida;
        this.remanejamentoEntrada=remanejamentoEntrada;
        this.remanejamentoSaida=remanejamentoSaida;
        this.ataSaida=ataSaida;
        this.totalEntrada=totalEntrada;
        this.totalSaida= totalSaida;
        this.estoqueFinal=estoqueFinal;
        this.unidade = unidade;
    }
}
