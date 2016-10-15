package offergen.logic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import offergen.logic.domain.Modification;

@Repository
public interface ModificationRepository extends JpaRepository<Modification, Long> {

	//
}
