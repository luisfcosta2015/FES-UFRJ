package merendaprojectdb;

import java.util.ArrayList;

/**
 * @author joycinha
 */
public class Itens {
    ArrayList<ItemComida> itens;
    Itens() {
        itens = new ArrayList<ItemComida>();
    }
    public void add(ItemComida item) {
        //adiciona no banco de dados
        itens.add(item);
    }
    public void remove(ItemComida item) {
        //remove do banco de dados
        itens.remove(item);
    }
    public ArrayList<ItemComida>getList() {
        //busca no banco de dados
        return itens;
    }
}
