package merenda.repository;

import org.springframework.data.repository.CrudRepository;

import merenda.model.Usuario;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}