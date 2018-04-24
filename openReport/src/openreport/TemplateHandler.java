package openreport;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import pdfexport.Component;
import pdfexport.c_Header;
import pdfexport.c_Text;

public class TemplateHandler {
    
    
    
    public static String serializeTemplateToXML(Template t){
        
        XStream xstream = new XStream();
        xstream.alias("template", Template.class);
        
        String xml = xstream.toXML(t);
        
        try (PrintWriter out = new PrintWriter("results/objects/template.xml")) {
        out.println(xml);
        }catch (FileNotFoundException ex) {
            Logger.getLogger(TemplateHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("File saved!");
    
    return xml;
    }
    
    public Template deserializeTemplateFromXML(String template){
        XStream xstream = new XStream();
        xstream.alias("template", Template.class);
        
        Template t = (Template)xstream.fromXML(template);
        
        return t;
    }
    
    public static void main(String argv[]) {
        List<Component> t = new ArrayList<Component>();
        Component c = new c_Text("sofas");
        t.add(c);
        Component c2 = new c_Text("sos");
        t.add(c2);
        Component c3 = new c_Header("a","b","c","d","e","f","g");
        t.add(c3);
               
        Template te = new Template(t, null,null,null,null);
        
        serializeTemplateToXML(te);
    }
}
