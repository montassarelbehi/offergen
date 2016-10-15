package offergen.logic;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import offergen.logic.domain.Lot;
import offergen.logic.domain.Offer;
import offergen.logic.repositories.OfferRepository;

/**
 * @author monta
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/context-test.xml" })
// @TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
// @DbUnitConfiguration(databaseConnection = "offergenDS")
public class addOfferServiceTest {

	/**
	 * {@link OfferRepository}.
	 */
	@Autowired
	private OfferRepository offerRepository;

	/**
	 * test.
	 */
	@Test
	public void test() {
		List<Offer> offers = new ArrayList<>();
		List<Lot> lots = new ArrayList<>();

		Offer offer = new Offer();
		offer.setReference("ref de test");
		offer.setCreationDate(LocalDateTime.now());
		offer.setActive(Boolean.TRUE);

		// LotType lt = new LotType();
		// lt.setLibelle("libelle");
		// lt.setReference("ref");

		Lot l1 = new Lot();
		l1.setDescription("test");
		l1.setReference("ref");
		l1.setParentOffer(offer);

		lots.add(l1);

		offer.setLots(lots);

		try {
			offerRepository.save(offer);

			offers = offerRepository.findByActiveTrue();

			assertNotNull(offers);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
