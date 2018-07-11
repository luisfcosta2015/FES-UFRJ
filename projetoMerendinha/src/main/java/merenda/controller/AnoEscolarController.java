package merenda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import merenda.model.AlunosMatriculados;
import merenda.model.AnoEscolar;
import merenda.model.MesEscolar;
import merenda.model.Turno;
import merenda.repository.AnoEscolarRepository;
import merenda.repository.EscolaRepository;
import merenda.repository.MesEscolarRepository;


@Controller
public class AnoEscolarController {

	private String modalidades[] = {"Pré Escolar", "Ensino Fundamental", "Jovens e Adultos", "Ensino Especial"};
    private EscolaRepository escolaRepository;
    private AnoEscolarRepository anoEscolarRepository;
    private MesEscolarRepository mesEscolarRepository;

    @Autowired
    public void setAnoEscolarRepository(AnoEscolarRepository anoEscolarRepository) {
        this.anoEscolarRepository = anoEscolarRepository;
    }
    @Autowired
    public void setMesEscolarRepository(MesEscolarRepository mesEscolarRepository) {
        this.mesEscolarRepository = mesEscolarRepository;
    }
    @Autowired
    public void setEscolaRepository(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

	@RequestMapping(path = "/anoEscolar/add/{id}", method = RequestMethod.GET)
    public String createAnoEscolar(Model model, @PathVariable(value = "id") String idEscola) {
        model.addAttribute("anoEscolar", new AnoEscolar());
        model.addAttribute("idEscola", idEscola);
        return "editAnoEscolar";
    }
	
	@RequestMapping(path = "/anoEscolar/addMes/{id}", method = RequestMethod.GET)
    public String createMesEscolar(Model model, @PathVariable(value = "id") String idAno) {
        model.addAttribute("mesEscolar", new MesEscolar());
        model.addAttribute("idAno", idAno);
        model.addAttribute("idEscola", anoEscolarRepository.findById(idAno).get().getEscola().getId());
        return "editMesEscolar";
    }

    @RequestMapping(path = "/mesEscolar/{id}", method = RequestMethod.POST)
    public String saveMesEscolar(MesEscolar mesEscolar, @PathVariable(value = "id") String idAno) {
    	
		for(short i=0; i<4; i++) {
			AlunosMatriculados alunosMatriculadosAtual = new AlunosMatriculados();
			alunosMatriculadosAtual.setModalidade(modalidades[i]);
			alunosMatriculadosAtual.setNrDiasDistribuicao(0);
			alunosMatriculadosAtual.setAtendidos(0);
			
			for(short j=0; j<4; j++) {
				Turno turnoAtual = new Turno();
				turnoAtual.setTurno(j);
				turnoAtual.setMatriculados(0);
				turnoAtual.setAlunosMatriculados(alunosMatriculadosAtual);
				//turnoAtual = turnoRepository.save(turnoAtual);
				alunosMatriculadosAtual.getTurnos().add(turnoAtual);
			}
			
			alunosMatriculadosAtual.setMesEscolar(mesEscolar);
			//alunosMatriculadosAtual = alunosMatriculadosRepository.save(alunosMatriculadosAtual);
			mesEscolar.getAlunosMatriculados().add(alunosMatriculadosAtual);
		}
		
    	AnoEscolar anoEscolar = anoEscolarRepository.findById(idAno).get();
		mesEscolar.setAno(anoEscolar);
    	mesEscolarRepository.save(mesEscolar);
        return "redirect:/anoEscolar/" + anoEscolar.getEscola().getId();
    }

    @RequestMapping(path = "/anoEscolar/{id}", method = RequestMethod.POST)
    public String saveAnoEscolar(AnoEscolar anoEscolar, @PathVariable(value = "id") String idEscola) {
		anoEscolar.setEscola(escolaRepository.findById(idEscola).get());
    	anoEscolarRepository.save(anoEscolar);
        return "redirect:/anoEscolar/" + idEscola;
    }

    @RequestMapping(path = "/anoEscolar/{id}", method = RequestMethod.GET)
    public String getAllAnosEscolares(Model model, @PathVariable(value = "id") String idEscola) {
    	model.addAttribute("idEscola", idEscola);
        model.addAttribute("anosEscolares", anoEscolarRepository.findByEscolaId(idEscola));
        return "anoEscolar";
    }

    @RequestMapping(path = "/anoEscolar/edit/{id}", method = RequestMethod.GET)
    public String editAnoEscolar(Model model, @PathVariable(value = "id") String id) {
    	AnoEscolar anoEscolarAtual = anoEscolarRepository.findById(id).get();
        model.addAttribute("anoEscolar", anoEscolarAtual);
        model.addAttribute("idEscola", anoEscolarAtual.getEscola().getId());
        return "editAnoEscolar";
    }

    @RequestMapping(path = "/anoEscolar/delete/{id}", method = RequestMethod.GET)
    public String deleteAnoEscolar(@PathVariable(name = "id") String id) {
    	AnoEscolar anoEscolarAtual = anoEscolarRepository.findById(id).get();
    	anoEscolarRepository.deleteById(id);
        return "redirect:/anoEscolar/"+anoEscolarAtual.getEscola().getId();
    }

    @RequestMapping(path = "/mesEscolar/edit/{id}", method = RequestMethod.GET)
    public String editMesEscolar(Model model, @PathVariable(value = "id") String id) {
    	MesEscolar mesEscolarAtual = mesEscolarRepository.findById(id).get();
        model.addAttribute("mesEscolar", mesEscolarAtual);
        model.addAttribute("idAno", mesEscolarAtual.getAno().getId());
        return "editMesEscolar";
    }

    @RequestMapping(path = "/mesEscolar/delete/{id}", method = RequestMethod.GET)
    public String deleteMesEscolar(@PathVariable(name = "id") String id) {
    	MesEscolar mesEscolarAtual = mesEscolarRepository.findById(id).get();
    	mesEscolarRepository.deleteById(id);
        return "redirect:/anoEscolar/"+mesEscolarAtual.getAno().getEscola().getId();
    }

}