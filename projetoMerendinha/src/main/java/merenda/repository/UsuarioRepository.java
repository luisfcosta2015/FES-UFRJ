package merenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import merenda.model.Usuario;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByLogin(String login);

}