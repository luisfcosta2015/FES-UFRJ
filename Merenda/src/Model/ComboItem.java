package Model;

// CLASSE FEITA PRA SER UM ITEM DA COMBOBOX
// Util pra preencher ComboBox com resultados de uma query

public class ComboItem{
    private String key;
    private String value;

    public ComboItem(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key;
    }

    public String getKey()
    {
        return key;
    }

    public String getValue()
    {
        return value;
    }
}