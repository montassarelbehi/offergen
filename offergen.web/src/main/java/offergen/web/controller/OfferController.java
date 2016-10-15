package offergen.web.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import offergen.logic.domain.Offer;
import offergen.logic.repositories.OfferRepository;

/**
 * @author monta
 *
 */
@Api(value = "Offer", description = "WebServices concernant les appels d'offre")
@Controller
@RequestMapping("/offer")
public class OfferController {

	/**
	 * {@link OfferRepository}.
	 */
	@Autowired
	private OfferRepository offerRepository;

	/**
	 * @return {@link List} of {@link Offer}.
	 */
	@RequestMapping(value = "/getAllActive", method = GET, produces = "application/json")
	@ResponseBody
	public List<Offer> getActiveOffers() {

		return offerRepository.findByActiveTrue();
	}
}
