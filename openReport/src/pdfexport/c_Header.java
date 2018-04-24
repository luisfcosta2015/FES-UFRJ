package pdfexport;

public class c_Header extends Component {
    public String schoolName;
    public String street;
    public String aptNumber;
    public String cep;
    public String telefone;
    public String webSite;
    public String image;

    public c_Header(String schoolName, String street, String aptNumber, String cep, String telefone, String webSite, String image) {
        this.schoolName = schoolName;
        this.street = street;
        this.aptNumber = aptNumber;
        this.cep = cep;
        this.telefone = telefone;
        this.webSite = webSite;
        this.image = image;
        
        type = ComponentType.HEADER;
    }
}
