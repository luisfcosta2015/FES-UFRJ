package merenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import merenda.model.Alimento;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, String> {
}