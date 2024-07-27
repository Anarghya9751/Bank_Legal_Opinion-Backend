package controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.PricingEntity;
import services.PricingService;

@RestController
	@RequestMapping("/api/pricings")
	
	public class PricingController {

	    @Autowired
	    private PricingService pricingService;

	    @PostMapping
	    public PricingEntity createPricing(@RequestBody PricingEntity pricing) {
	        return pricingService.savePricing(pricing);
	    }

	    @GetMapping
	    public List<PricingEntity> getAllPricings() {
	        return pricingService.getAllPricings();
	    }

	    @GetMapping("/{id}")
	    public Optional<PricingEntity> getPricingById(@PathVariable Long id) {
	        return pricingService.getPricingById(id);
	    }

	    @DeleteMapping("/{id}")
	    public void deletePricing(@PathVariable Long id) {
	        pricingService.deletePricing(id);
	    }

}
