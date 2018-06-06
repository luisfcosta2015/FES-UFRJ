import java.io.File;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class HTMLReplacer {
	
	
	public HTMLReplacer(String filename, HashMap<String, Object> namespace) {//Recebe o map com a consulta sem substituir as variáveis e o modelo html
		                                                                     //O mesmo Irá substituir os campos com as variáveis finais das consultas
		File in = new File(filename);
		Document doc;
		Pattern p = Pattern.compile("(?!\\$\\{)[a-zA-Z][a-zA-Z0-9\\_]*(?=\\})");
		try {
			doc = Jsoup.parse(in, null);
		}catch (Exception e) {
			e.printStackTrace();
			return;
		}
		Elements els = doc.getElementsByClass("sta");
		for(Element el : els) {
			for(TextNode tn : el.textNodes()) {
				Matcher m = p.matcher(tn.text());
				while(m.find()) {
					String key = m.group();
					tn.text(tn.text()
							.replace("${"+key+"}", 
									(String) namespace.get(key)));
				}
			}
		}
		//TODO adapt code to more dynamic blocks (future)
		Element el = doc.getElementsByClass("dyn").first();
		String [] keys = ((String) namespace.get("dyn")).split(",");
		String[][] values = new String[keys.length][];
		for(int i=0; i<keys.length; i++) {
			values[i] = ((String[]) namespace.get(keys[i]));
		}
		Element model = el.clone();
		Element parent = el.parent();
		el.remove();
		for(int i=0; i<values[0].length; i++) {
			Element aux = model.clone();
			String str = aux.html();
			for(int j=0; j<keys.length; j++) {
				str = str.replace("${"+keys[j]+"}", values[j][i]);
			}
			aux.html(str);
			parent.insertChildren(-1, aux);
		}
		System.out.println(doc.html());
		
	}

}





