package logico;

import java.util.ArrayList;

public class Profesor extends Usuario  {
private ArrayList<Prisma>prismas;
private String cedula;

	public Profesor(String nombre, String apellido, int edad, String cedula) {
		super(nombre, apellido, edad);
		this.setPrismas(prismas);
		this.setCedula(cedula);
		// TODO Auto-generated constructor stub
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public ArrayList<Prisma> getPrismas() {
		return prismas;
	}
	public void setPrismas(ArrayList<Prisma> prismas) {
		this.prismas = prismas;
	}

}
