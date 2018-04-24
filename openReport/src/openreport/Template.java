package openreport;

import java.util.List;
import pdfexport.Component;

public class Template {
    public List<Component> title;
    public List<Component> pageheader;
    public List<Component> body;
    public List<Component> pagefooter;
    public List<Component> footer;
    
    public Template(List<Component> _title, List<Component> _pageheader, List<Component> _body, List<Component> _pagefooter, List<Component> _footer){
        title = _title;
        pageheader = _pageheader;
        body = _body;
        pagefooter = _pagefooter;
        footer = _footer;
    }
}
