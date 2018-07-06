    package merendaprojectdb;
// @author joycinha

public class ItemComida {
    public String tipoItem;
    public int entrada;
    public int saida;
    public String unidade;
    ItemComida(String tipoItem, int entrada,int saida, String unidade) {
        this.tipoItem = tipoItem;
        this.entrada = entrada;
        this.saida=saida;
        this.unidade = unidade;
    }
}
