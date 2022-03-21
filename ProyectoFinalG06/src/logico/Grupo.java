package logico;

import java.util.ArrayList;

public class Grupo {
private ArrayList<Estudiante> estudiantes;
private Profesor profesor;
private int NumGrupo;
public Grupo(ArrayList<Estudiante> estudiantes, Profesor profesor, int numGrupo) {
	super();
	this.setEstudiantes(estudiantes);
	this.setProfesor(profesor);
	setNumGrupo(numGrupo);
}
public int getNumGrupo() {
	return NumGrupo;
}
public void setNumGrupo(int numGrupo) {
	NumGrupo = numGrupo;
}
public Profesor getProfesor() {
	return profesor;
}
public void setProfesor(Profesor profesor) {
	this.profesor = profesor;
}
public ArrayList<Estudiante> getEstudiantes() {
	return estudiantes;
}
public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
	this.estudiantes = estudiantes;
}

}
