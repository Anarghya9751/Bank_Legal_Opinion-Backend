package services;

import java.util.List;
import java.util.Optional;

import entities.PricingEntity;

	
	
	
	public interface PricingService {
		
	    PricingEntity savePricing(PricingEntity pricing);
	    
	    Optional<PricingEntity> getPricingById(Long id);
	    
	    List<PricingEntity> getAllPricings();
	    
	    void deletePricing(Long id);

}
