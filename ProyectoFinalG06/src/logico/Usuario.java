package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
protected String nombre;
protected String apellido;
protected int edad;
protected boolean estado;
protected UsuarioGestion usuario;
protected ArrayList<Prisma> misprismas;

public Usuario(String nombre, String apellido, int edad, boolean estado, UsuarioGestion usuario) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.edad = edad;
	this.estado = estado;
	this.usuario = usuario;
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
public boolean isEstado() {
	return estado;
}
public void setEstado(boolean estado) {
	this.estado = estado;
}	
public UsuarioGestion getUsuario() {
	return usuario;
}
public void setUsuario(UsuarioGestion usuario) {
	this.usuario = usuario;
}
public ArrayList<Prisma> getMisprismas() {
	return misprismas;
}
public void setMisprismas(ArrayList<Prisma> misprismas) {
	this.misprismas = misprismas;
}
}
