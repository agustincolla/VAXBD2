package ar.edu.unlp.info.bd2.model;

public class Vaccine {

    public Vaccine() {
    }
	String name;
	Long id;
	//retorna el nombre de la vacuna
		/**
		 * @return el nombre de la vacuna
		 */
		public String getName() {
			return name;
		}
	//modificar el nombre de la vacuna
		/**
		 * @param name el nombre de la vacuna
		 */
		public void setName(String name) {
			this.name = name;
		}
	//retorna id de la vacuna 
		/**
		 * @return el id de la vacuna
		 */
		public Long getId() {
			return id;
		}
	//modificar id de la vacuna
		/**
		 * @param id el id
		 */
		public void setId(Long id) {
			this.id = id;
		}
		
		//crea una vacuna con los parametros recibidos 
		/**
		 * @param id con el id
		 * @param name nombre de la vacuna
		 */
		public Vaccine (String name) {
			this.setName(name);
		}
}
