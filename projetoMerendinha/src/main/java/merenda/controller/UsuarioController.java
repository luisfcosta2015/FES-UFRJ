package merenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import merenda.model.Alimento;
import merenda.model.Usuario;
import merenda.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(path = "/usuarios/add", method = RequestMethod.GET)
	public String addNovoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "addUsuario";
    }
	
	@RequestMapping(path = "usuarios", method = RequestMethod.POST)
    public String salvarUsuario(Usuario usuario) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		
		usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

	@RequestMapping(path = "/usuarios", method = RequestMethod.GET)
    public String getTodosUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios";
    }
	
	@RequestMapping(path = "/usuarios/delete/{id}", method = RequestMethod.GET)
    public String deletarUsuario(@PathVariable(name = "id") Integer id) {
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }
}