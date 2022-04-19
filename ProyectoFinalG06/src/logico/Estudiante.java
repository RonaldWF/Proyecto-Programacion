package logico;

import java.util.ArrayList;

public class Estudiante extends Usuario {
private ArrayList<Prisma>prismas;
private String matricula;
	public Estudiante(String nombre, String apellido, int edad,String matricula,boolean estado,UsuarioGestion usuario) {
		super(nombre, apellido, edad, estado, usuario);
		this.setPrismas(prismas);
		this.setMatricula(matricula);
		// TODO Auto-generated constructor stub
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public ArrayList<Prisma> getPrismas() {
		return prismas;
	}
	public void setPrismas(ArrayList<Prisma> prismas) {
		this.prismas = prismas;
	}

}
