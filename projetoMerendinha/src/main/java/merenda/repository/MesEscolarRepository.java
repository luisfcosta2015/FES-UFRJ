package merenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import merenda.model.MesEscolar;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface MesEscolarRepository extends JpaRepository<MesEscolar, String> {
	
	Optional<MesEscolar> findById(String id);
}