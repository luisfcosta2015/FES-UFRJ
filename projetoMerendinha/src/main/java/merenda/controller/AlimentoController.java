package merenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import merenda.model.Alimento;
import merenda.repository.AlimentoRepository;

@Controller
public class AlimentoController {

    private AlimentoRepository alimentoRepository;

    @Autowired
    public void setAlimentoRepository(AlimentoRepository alimentoRepository) {
        this.alimentoRepository = alimentoRepository;
    }

    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/alimentos/add", method = RequestMethod.GET)
    public String criarAlimento(Model model) {
        model.addAttribute("alimento", new Alimento());
        return "editAlimentos";
    }

    @RequestMapping(path = "alimentos", method = RequestMethod.POST)
    public String salvarAlimento(Alimento alimento) {
        alimentoRepository.save(alimento);
        return "redirect:/alimentos";
    }

    @RequestMapping(path = "/alimentos", method = RequestMethod.GET)
    public String getTodosAlimentos(Model model) {
        model.addAttribute("alimentos", alimentoRepository.findAll());
        return "alimentos";
    }

    @RequestMapping(path = "/alimentos/edit/{id}", method = RequestMethod.GET)
    public String editarAlimento(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("alimento", alimentoRepository.findById(id));
        return "editAlimentos";
    }

    @RequestMapping(path = "/alimentos/delete/{id}", method = RequestMethod.GET)
    public String deletarAlimento(@PathVariable(name = "id") String id) {
        alimentoRepository.deleteById(id);
        return "redirect:/alimentos";
    }
}