package merenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import merenda.model.Turno;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface TurnoRepository extends JpaRepository<Turno, String> {
	
	Optional<Turno> findById(String id);
}