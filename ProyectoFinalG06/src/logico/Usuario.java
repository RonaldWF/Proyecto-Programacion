package logico;

import java.io.Serializable;

public class Usuario implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected String nombre;
protected String apellido;
protected int edad;
public Usuario(String nombre, String apellido, int edad) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.edad = edad;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
	
	
}
