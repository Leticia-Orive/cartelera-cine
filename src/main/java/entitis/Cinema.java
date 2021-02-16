package entitis;


	import java.io.Serializable;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;


		@Entity
		@Table(name="cine")
		public class Cinema implements Serializable {
			private static final long serialVersionUID = 1L;
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name="id")
			 private Long id;
			@Column(name="nombre")
			 private String nombre;
			@Column(name="duracion")
			private Integer duracion;
			@Column(name="sala")
			 private String sala;
			
			
			
			
			public Cinema(){}

			public Cinema(Long id, String nombre, Integer duracion, String sala) {
				super();
				this.id = id;
				this.nombre = nombre;
				this.duracion = duracion;
				this.sala = sala;
			}




			public Long getId() {
				return id;
			}




			public void setId(Long id) {
				this.id = id;
			}




			public String getNombre() {
				return nombre;
			}




			public void setNombre(String nombre) {
				this.nombre = nombre;
			}




			public Integer getDuracion() {
				return duracion;
			}




			public void setDuracion(Integer duracion) {
				this.duracion = duracion;
			}




			public String getSala() {
				return sala;
			}




			public void setSala(String sala) {
				this.sala = sala;
			}

			@Override
			public String toString() {
				return "Cine [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + ", sala=" + sala + "]";
			}
			
			

}
