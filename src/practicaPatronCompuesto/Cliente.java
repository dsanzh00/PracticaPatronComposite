/**
 * 				PRACTICA PATRON COMPUESTO
 * 				Ingenieria del Software
 * 
 * @author Sanz Herrero, Daniel
 * @author Valencia Michelena, Blanca
 * 
 * 
 */

package practicaPatronCompuesto;

public class Cliente {

	private String nombre;
	private int edad;

	public Cliente(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
