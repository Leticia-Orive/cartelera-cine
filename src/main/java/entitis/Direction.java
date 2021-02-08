package entitis;


	import java.io.Serializable;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;


		@Entity
		@Table(name="direction")
		public class Direction implements Serializable {
			private static final long serialVersionUID = 1L;
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="id")
			 private Long id;
			@Column(name="firstName")
			 private String firstName;
			@Column(name="last_name")
			private String lastName;
			@Column(name="age")
			 private Integer age;
			@Column(name="nif")	
			private String nif;
			@Column(name="email")
			private String email;
			@Column (name="password")
			private String password;
			
			
			
			public direction(){}



			public Long getId() {
				return id;
			}



			public void setId(Long id) {
				this.id = id;
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



			public Integer getAge() {
				return age;
			}



			public void setAge(Integer age) {
				this.age = age;
			}



			public String getNif() {
				return nif;
			}



			public void setNif(String nif) {
				this.nif = nif;
			}



			public String getEmail() {
				return email;
			}



			public void setEmail(String email) {
				this.email = email;
			}



			public String getPassword() {
				return password;
			}



			public void setPassword(String password) {
				this.password = password;
			}
			


}
