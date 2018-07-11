package merenda.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import merenda.model.Escola;
import merenda.model.Usuario;
import merenda.repository.EscolaRepository;

@Controller
public class EscolaController {
	
	private EscolaRepository escolaRepository;

    @Autowired
    public void setEscolaRepository(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }
    
	@RequestMapping(path = "/userID", method = RequestMethod.GET)
	@ResponseBody
    public String getUserID(Authentication authentication) {
		Usuario usuario = (Usuario)authentication.getPrincipal();
        return usuario.getId().toString();
    }

/************************* Primeira página, correspondente às escolas ****************************************/
    @RequestMapping(path = "/escolas/add", method = RequestMethod.GET)
    public String criarEscola(Model model) {
        model.addAttribute("escola", new Escola());
        return "editEscola";
    }

    @RequestMapping(path = "escolas", method = RequestMethod.POST)
    public String salvarEscola(Escola escola) {
        escolaRepository.save(escola);
        return "redirect:/escolas";
    }

    @RequestMapping(path = "/escolas", method = RequestMethod.GET)
    public String getTodasEscolas(Model model) {
        model.addAttribute("escolas", escolaRepository.findAll());
        return "escolas";
    }

    @RequestMapping(path = "/escolas/edit/{id}", method = RequestMethod.GET)
    public String editarEscola(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("escola", escolaRepository.findById(id));
        return "editEscolas";
    }

    @RequestMapping(path = "/esgcolas/delete/{id}", method = RequestMethod.GET)
    public String deletarEscola(@PathVariable(name = "id") String id) {
        escolaRepository.deleteById(id);
        return "redirect:/escolas";
    }

}
