package entitis;


	import java.io.Serializable;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;


		@Entity
		@Table(name="contacto")
		public class Contacto implements Serializable {
			private static final long serialVersionUID = 1L;
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="id")
			 private Long id;
			@Column(name="calle")
			 private String calle;
			@Column(name="nombrecine")
			private String nombrecine;
			@Column(name="telefono")
			 private Integer telefono;
			@Column(name="horario")	
			private String horario;
			
			
			
			
			public Contacto(){}
			
public Contacto(Long id, String calle, String nombrecine, Integer telefono, String horario) {
				super();
				this.id = id;
				this.calle = calle;
				this.nombrecine = nombrecine;
				this.telefono = telefono;
				this.horario = horario;

			
			}


			public Long getId() {
				return id;
			}




			public void setId(Long id) {
				this.id = id;
			}




			public String getCalle() {
				return calle;
			}




			public void setCalle(String calle) {
				this.calle = calle;
			}




			public String getNombrecine() {
				return nombrecine;
			}




			public void setNombrecine(String nombrecine) {
				this.nombrecine = nombrecine;
			}




			public Integer getTelefono() {
				return telefono;
			}




			public void setTelefono(Integer telefono) {
				this.telefono = telefono;
			}




			public String getHorario() {
				return horario;
			}




			public void setHorario(String horario) {
				this.horario = horario;
			}

			@Override
			public String toString() {
				return "Contacto [id=" + id + ", calle=" + calle + ", nombrecine=" + nombrecine + ", telefono="
						+ telefono + ", horario=" + horario + "]";
			}
			

		}

			