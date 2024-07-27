package entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


	
	
	@Entity
	@Table(name = "users")
	
	public class UserEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String username;
	    private String password;
	    private String email;
	    private String firstName;
	    private String lastName;

	    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	    private Set<UserEntity> invoices;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Set<UserEntity> getInvoices() {
			return invoices;
		}

		public void setInvoices(Set<UserEntity> invoices) {
			this.invoices = invoices;
		}

		public UserEntity(Long id, String username, String password, String email, String firstName, String lastName,
				Set<UserEntity> invoices) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.email = email;
			this.firstName = firstName;
			this.lastName = lastName;
			this.invoices = invoices;
		}

		public UserEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

	    
	    
	    

}
