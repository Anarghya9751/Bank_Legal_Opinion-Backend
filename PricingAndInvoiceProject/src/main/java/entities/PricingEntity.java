package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "pricings")
	public class PricingEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String serviceType;
	    private String channel;
	    private Double price;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getServiceType() {
			return serviceType;
		}
		public void setServiceType(String serviceType) {
			this.serviceType = serviceType;
		}
		public String getChannel() {
			return channel;
		}
		public void setChannel(String channel) {
			this.channel = channel;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public PricingEntity(Long id, String serviceType, String channel, Double price) {
			super();
			this.id = id;
			this.serviceType = serviceType;
			this.channel = channel;
			this.price = price;
		}
		public PricingEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	    
	

}
