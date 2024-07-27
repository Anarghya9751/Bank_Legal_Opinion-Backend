package entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
	@Table(name = "invoices")
	public class InvoiceEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String invoiceNumber;
	    private Date date;
	    private Double totalAmount;
	    private String companyLogo;
	    private String companyAddress;

	    @ManyToOne
	    private UserEntity user;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getInvoiceNumber() {
			return invoiceNumber;
		}

		public void setInvoiceNumber(String invoiceNumber) {
			this.invoiceNumber = invoiceNumber;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public Double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public String getCompanyLogo() {
			return companyLogo;
		}

		public void setCompanyLogo(String companyLogo) {
			this.companyLogo = companyLogo;
		}

		public String getCompanyAddress() {
			return companyAddress;
		}

		public void setCompanyAddress(String companyAddress) {
			this.companyAddress = companyAddress;
		}

		public UserEntity getUser() {
			return user;
		}

		public void setUser(UserEntity user) {
			this.user = user;
		}

		public InvoiceEntity(Long id, String invoiceNumber, Date date, Double totalAmount, String companyLogo,
				String companyAddress, UserEntity user) {
			super();
			this.id = id;
			this.invoiceNumber = invoiceNumber;
			this.date = date;
			this.totalAmount = totalAmount;
			this.companyLogo = companyLogo;
			this.companyAddress = companyAddress;
			this.user = user;
		}

		public InvoiceEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
	
	    
	    

}
