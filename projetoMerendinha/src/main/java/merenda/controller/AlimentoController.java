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

    private AlimentoRepository produtoRepository;

    @Autowired
    public void setProductRepository(AlimentoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(path = "/alimentos/add", method = RequestMethod.GET)
    public String createProduct(Model model) {
        model.addAttribute("alimento", new Alimento());
        return "edit";
    }

    @RequestMapping(path = "alimentos", method = RequestMethod.POST)
    public String saveProduct(Alimento produtO) {
        produtoRepository.save(produtO);
        return "redirect:/alimentos";
    }

    @RequestMapping(path = "/alimentos", method = RequestMethod.GET)
    public String getAllProducts(Model model) {
        model.addAttribute("alimentos", produtoRepository.findAll());
        model.addAttribute("alimento", new Alimento());
        return "alimentos";
    }

    @RequestMapping(path = "/alimentos/edit/{id}", method = RequestMethod.GET)
    public String editProduct(Model model, @PathVariable(value = "id") String id) {
        model.addAttribute("alimento", produtoRepository.findById(id));
        return "edit";
    }

    @RequestMapping(path = "/alimentos/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id") String id) {
        produtoRepository.deleteById(id);
        return "redirect:/alimentos";
    }
}