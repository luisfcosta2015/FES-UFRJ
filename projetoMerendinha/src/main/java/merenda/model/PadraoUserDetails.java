package merenda.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class PadraoUserDetails extends Usuario implements UserDetails{

	private static final long serialVersionUID = 4370786252565773499L;

	public PadraoUserDetails(final Usuario usuario) {
		super(usuario);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return getPerfis()
				.stream()
				.map(perfil -> new SimpleGrantedAuthority("ROLE_" + perfil.getTipoPerfil()))
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return super.getSenha();
	}

	@Override
	public String getUsername() {
		return super.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
