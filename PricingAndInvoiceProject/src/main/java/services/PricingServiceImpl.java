package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entities.PricingEntity;
import repositories.PricingRepository;


	
	@Service
	public class PricingServiceImpl implements PricingService {

	    @Autowired
	    private PricingRepository pricingRepository;

	    @Override
	    public PricingEntity savePricing(PricingEntity pricing) {
	        return pricingRepository.save(pricing);
	    }

	    @Override
	    public Optional<PricingEntity> getPricingById(Long id) {
	        return pricingRepository.findById(id);
	    }

	    @Override
	    public List<PricingEntity> getAllPricings() {
	        return pricingRepository.findAll();
	    }

	    @Override
	    public void deletePricing(Long id) {
	        pricingRepository.deleteById(id);
	    }
	}
