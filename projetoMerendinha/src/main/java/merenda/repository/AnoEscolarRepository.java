package merenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import merenda.model.AnoEscolar;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface AnoEscolarRepository extends JpaRepository<AnoEscolar, String> {
	
	Iterable<AnoEscolar> findByEscolaId(String id);
	Optional<AnoEscolar> findById(String id);
}