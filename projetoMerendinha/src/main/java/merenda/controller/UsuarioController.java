package merenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import merenda.model.Usuario;
import merenda.repository.UsuarioRepository;

@Controller
@RequestMapping(path="/usuario") 
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping(path="/add") // Mapeia somente GET Requests
	public @ResponseBody String addNovoUsuario (@RequestParam String login, @RequestParam String senha) {
		Usuario novo = new Usuario();
		novo.setLogin(login);
		novo.setSenha(senha);
		usuarioRepository.save(novo);
		return "Saved\n";
		//curl 'localhost:8080/usuario/add?login=abcd&senha=abcd' para inserir
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Usuario> getTodosUsuarios() {
		// Retorna um JSON com todos os usuários
		return usuarioRepository.findAll();
	}
}