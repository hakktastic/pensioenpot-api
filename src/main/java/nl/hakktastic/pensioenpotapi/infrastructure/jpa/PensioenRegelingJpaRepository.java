package nl.hakktastic.pensioenpotapi.infrastructure.jpa;

import nl.hakktastic.pensioenpotapi.domain.aggregate.PensioenRegeling;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.PensioenRegelingReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PensioenRegelingJpaRepository extends JpaRepository<PensioenRegeling, Long> {

    Optional<PensioenRegeling> findByPensioenRegelingReference(PensioenRegelingReference pensioenRegelingReference);
}