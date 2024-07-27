package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.PricingEntity;
	
	
@Repository
public interface PricingRepository extends JpaRepository<PricingEntity, Long> {

	

}
