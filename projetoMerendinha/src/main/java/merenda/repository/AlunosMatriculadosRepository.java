package merenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import merenda.model.AlunosMatriculados;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface AlunosMatriculadosRepository extends JpaRepository<AlunosMatriculados, String> {
	
	Optional<AlunosMatriculados> findById(String id);
}