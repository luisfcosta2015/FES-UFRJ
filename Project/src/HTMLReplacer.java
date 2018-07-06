import java.io.File;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLReplacer {

    public Document doc;
    private Pattern p = Pattern.compile("\\$\\{(\\w*)\\}");


/**    Recebe o map com a consulta sem substituir as variáveis e o modelo html
 *     O mesmo Irá substituir os campos com as variáveis finais das consultas
 */
	public HTMLReplacer(String filename) {
		File in = new File(filename);
		try {
			doc = Jsoup.parse(in, null);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void processStatic(HashMap<String,String> staticData){
        Elements els = doc.getElementsByClass("sta");
        for(Element el : els) {
            String staHtml = el.html();
            Matcher m = p.matcher(staHtml);
            while(m.find()) {
                String key = m.group(1);
                if(key!=null){
                    String value = staticData.get(key);
                    if(value!=null){
                        staHtml=staHtml.replace("${"+key+"}",value);
                    }else{
                        staHtml=staHtml.replace("${"+key+"}","---");
                    }
                }
            }
            el.html(staHtml);
        }
    }

    public void processDynamics(HashMap<String,Object> dynamicsData){
	    HashMap<String,Integer> indexes = (HashMap<String,Integer>) dynamicsData.get("keys");
	    String[][] values = (String[][]) dynamicsData.get("values");
        Elements els = doc.getElementsByClass("dyn");

        for(Element el : els) {
            String dynHtml = el.outerHtml();
            Matcher m = p.matcher(dynHtml);
            StringBuilder out = new StringBuilder();
            for(String[] line:values){
                String cloneHtml = new String(dynHtml);
                while(m.find()) {
                    String key = m.group(1);
                    if(key!=null){
                        cloneHtml=cloneHtml.replace("${"+key+"}",line[indexes.get(key)]);
                    }
                }
                out.append(cloneHtml);
            }
            el.parent().html(el.parent().html().replace(dynHtml,out));//Pega o html interno gerado e coloca no mesmo lugar do elemento de modelo
        }
    }
}





