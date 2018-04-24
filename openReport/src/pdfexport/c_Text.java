package pdfexport;

import pdfexport.Component;

public class c_Text extends Component {
    public String text;

    public c_Text(String text) {
        this.text = text;
        
        type = ComponentType.PLAIN_TEXT;
    }
    public void SetText(String txt){
        this.text = txt;
    }
}
