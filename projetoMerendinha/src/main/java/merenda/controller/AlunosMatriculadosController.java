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
import merenda.repository.AlunosMatriculadosRepository;
import merenda.repository.AnoEscolarRepository;
import merenda.repository.EscolaRepository;
import merenda.repository.MesEscolarRepository;
import merenda.repository.TurnoRepository;


@Controller
public class AlunosMatriculadosController {

    private TurnoRepository turnoRepository;
    private AlunosMatriculadosRepository alunosMatriculadosRepository;
    private MesEscolarRepository mesEscolarRepository;

    @Autowired
    public void setMesEscolarRepository(MesEscolarRepository mesEscolarRepository) {
        this.mesEscolarRepository = mesEscolarRepository;
    }
    @Autowired
    public void setTurnoRepository(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }
    @Autowired
    public void setAlunosMatriculadosRepository(AlunosMatriculadosRepository alunosMatriculadosRepository) {
        this.alunosMatriculadosRepository = alunosMatriculadosRepository;
    }
    
    @RequestMapping(path = "/turno/{id}", method = RequestMethod.POST)
    public String saveTurnos(MesEscolar mesEscolar, @PathVariable(value = "id") String idEscola) {
    	for(AlunosMatriculados alunosMatriculados : mesEscolar.getAlunosMatriculados()) {
    		for(Turno turno : alunosMatriculados.getTurnos()) {
    			Turno atual = turnoRepository.findById(turno.getId()).get();
    			atual.setMatriculados(turno.getMatriculados());
    			turnoRepository.save(atual);
    		}
    		AlunosMatriculados atual = alunosMatriculadosRepository.findById(alunosMatriculados.getId()).get();
    		atual.setAtendidos(alunosMatriculados.getAtendidos());
    		atual.setNrDiasDistribuicao(alunosMatriculados.getNrDiasDistribuicao());
    	}
        return "redirect:/anoEscolar/" + idEscola;
    }

    @RequestMapping(path = "/turno/{id}", method = RequestMethod.GET)
    public String editTurnos(Model model, @PathVariable(value = "id") String id) {
    	MesEscolar mesEscolarAtual = mesEscolarRepository.findById(id).get();
        model.addAttribute("mesEscolar", mesEscolarAtual);
        model.addAttribute("idEscola", mesEscolarAtual.getAno().getEscola().getId());
        return "controleAlimentacao";
    }
    
}