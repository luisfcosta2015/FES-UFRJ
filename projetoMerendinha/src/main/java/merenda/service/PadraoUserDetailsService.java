package merenda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import merenda.model.PadraoUserDetails;
import merenda.model.Usuario;
import merenda.repository.UsuarioRepository;

@Service
public class PadraoUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Optional<Usuario> optionalUsuario = usuarioRepository.findByLogin(login);
		
		optionalUsuario.orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado"));
		
		return optionalUsuario.map(PadraoUserDetails::new).get();
	}

}
