package offergen.logic.offer.service.impl;

import org.springframework.stereotype.Service;

import offergen.logic.domain.Offer;
import offergen.logic.offer.service.AddOfferService;

@Service("addOfferService")
public class AddOfferServiceImpl implements AddOfferService {

	@Override
	public void forOffer() {

		Offer offer = new Offer();

		offer.setReference("ref ref");

		System.out.println(offer);
	}

}
