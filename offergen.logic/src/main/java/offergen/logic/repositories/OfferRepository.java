package offergen.logic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import offergen.logic.domain.Offer;

/**
 * @author monta
 *
 */
@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

	/**
	 * @param reference
	 * @return
	 */
	@Query
	public Offer findByReference(@Param("reference") String reference);

	@Query
	public List<Offer> findByActiveTrue();

	/**
	 * @return
	 */
	@Query
	public List<Offer> findByAuthorizedTrue();

	/**
	 * @param offer
	 */
	@Modifying
	@Query("UPDATE Offer o SET o.active = 0, close_date = NOW() WHERE o = :offer")
	public void updateActiveAndCloseDate(@Param("offer") Offer offer);

	/**
	 * @param offer
	 */
	@Modifying
	@Query("UPDATE Offer o SET o.authorized = 1 WHERE o = :offer")
	public void updateAuthorized(@Param("offer") Offer offer);

}
