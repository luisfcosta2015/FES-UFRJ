package br.com.fes.relatorios.bean;

import java.io.File;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.fes.relatorios.dao.DadosDAO;
import br.com.fes.relatorios.domain.Dados;
import br.com.fes.relatorios.itext.Gerador;
import br.com.fes.relatorios.itext.PageXofY;


@ManagedBean(name = "MBAlunos")
@ViewScoped
public class AlunosBean {
	public static final String DEST 	= "WebContent/results/alunosPorTurma.pdf";
	public static final String DEST2 	= "WebContent/results/alunosporturma-final.pdf";
    public static final String SRC 		= "WebContent/results/alunosPorTurma.pdf";

	
	private Dados dadosRegistro = new Dados();

	public Dados getDadosRegistro() {
		if(dadosRegistro == null){
			dadosRegistro = new Dados();
		}
		return dadosRegistro;
	}

	public int setDadosRegistro(Dados dadosRegistro) {
		this.dadosRegistro = dadosRegistro;
		return 1;
	}

		
	public int consultar(){
		try {
			
			DadosDAO dao = new DadosDAO();
			String query = dao.consultar(dadosRegistro);
			Gerador ger = new Gerador();
			
			File file = new File(DEST);
	        file.getParentFile().mkdirs();
	        
	        File file2 = new File(DEST2);
	        file2.getParentFile().mkdirs();
			
			System.out.println("ger.createPdf");
			ger.createPdf(DEST, query.toString(), dadosRegistro);
			new PageXofY().manipulatePdf(SRC,DEST2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 2;
	}
}
