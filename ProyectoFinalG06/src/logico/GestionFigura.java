package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class GestionFigura implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ArrayList<Prisma>prismas;
private ArrayList<Usuario> usuarios;
private ArrayList<Grupo> grupos;
private ArrayList<Estudiante> estudiantes;
private ArrayList<UsuarioGestion> usuariosGest;
private ArrayList<Profesor>profesores;
private int cantPrismas;
private int cantUsuarios;
private int cantGrupos;
private int cantUsuariosGestion;
private int cantEstudiantes;
private int cantProfesores;
public static GestionFigura gestion;
public static UsuarioGestion loginUser;
private int hola;
public GestionFigura() {
	setPrismas(new ArrayList<Prisma>(100));
	setUsuarios(new ArrayList<Usuario>(100));
	setGrupos(new ArrayList<Grupo>(100));
	setUsuariosGest(new ArrayList<UsuarioGestion>(100));
	setCantPrismas(0);
	setCantUsuarios(0);
	setCantGrupos(0);
	setCantUsuariosGestion(0);
	setEstudiantes(new ArrayList<Estudiante>(100));
	setProfesores(new ArrayList<Profesor>(100));
	setCantEstudiantes(0);
}
public int getCantGrupos() {
	return cantGrupos;
}
public static GestionFigura getInstance() {
	if(gestion == null) {
		gestion = new GestionFigura();
	}
	return gestion;
}
public UsuarioGestion buscarUsuarioGestion(String user) {
	UsuarioGestion usuario = null;
	for(int i = 0; i < cantUsuariosGestion;i++) {
		if(usuariosGest.get(i).getNombreUsuario().equalsIgnoreCase(user)) {
			usuario = usuariosGest.get(i);
		}
	}
	return usuario;
}

public void CrearUsuarioGestion(UsuarioGestion usuario) {
	usuariosGest.add(usuario);
	cantUsuariosGestion++;
}
public Estudiante BuscarEstudianteBymatricula(String matricula) {
	Estudiante aux = null;
	for(int i = 0; i < cantEstudiantes;i++)
	{
		if(estudiantes.get(i).getMatricula().equalsIgnoreCase(matricula)) {
			aux = estudiantes.get(i);
		}
	}
	return aux;
}
public void RegistrarEstudiante(Estudiante estudiante) {
	estudiantes.add(estudiante);
	cantEstudiantes++;
	cantUsuarios++;
}
public static UsuarioGestion getLoginUser() {
	return loginUser;
}
public static void setLoginUser(UsuarioGestion loginUser) {
	GestionFigura.loginUser = loginUser;
}

public Profesor BuscarProfesorByCedula(String cedula) {
	Profesor aux = null;
	for(int i = 0; i < cantProfesores;i++)
	{
		if(profesores.get(i).getCedula().equalsIgnoreCase(cedula)) {
			aux = profesores.get(i);
		}
	}
	return aux;
}

public void RegistrarProfesor(Profesor profesor) {
	profesores.add(profesor);
	cantProfesores++;
	cantUsuarios++;
}
public ArrayList<Profesor> getProfesores() {
	return profesores;
}
public void setProfesores(ArrayList<Profesor> profesores) {
	this.profesores = profesores;
}
public int getCantProfesores() {
	return cantProfesores;
}
public void setCantProfesores(int cantProfesores) {
	this.cantProfesores = cantProfesores;
}
public static GestionFigura getGestion() {
	return gestion;
}
public static void setGestion(GestionFigura gestion) {
	GestionFigura.gestion = gestion;
}

public ArrayList<Estudiante> getEstudiantes() {
	return estudiantes;
}
public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
	this.estudiantes = estudiantes;
}
public int getCantUsuariosGestion() {
	return cantUsuariosGestion;
}
public void setCantUsuariosGestion(int cantUsuariosGestion) {
	this.cantUsuariosGestion = cantUsuariosGestion;
}
public void setCantGrupos(int cantGrupos) {
	this.cantGrupos = cantGrupos;
}
public int getCantUsuarios() {
	return cantUsuarios;
}
public void setCantUsuarios(int cantUsuarios) {
	this.cantUsuarios = cantUsuarios;
}
public int getCantPrismas() {
	return cantPrismas;
}
public void setCantPrismas(int cantPrismas) {
	this.cantPrismas = cantPrismas;
}
public ArrayList<Grupo> getGrupos() {
	return grupos;
}
public void setGrupos(ArrayList<Grupo> grupos) {
	this.grupos = grupos;
}
public ArrayList<Usuario> getUsuarios() {
	return usuarios;
}
public void setUsuarios(ArrayList<Usuario> usuarios) {
	this.usuarios = usuarios;
}
public ArrayList<Prisma> getPrismas() {
	return prismas;
}
public void setPrismas(ArrayList<Prisma> prismas) {
	this.prismas = prismas;
}
public ArrayList<UsuarioGestion> getUsuariosGest() {
	return usuariosGest;
}
public void setUsuariosGest(ArrayList<UsuarioGestion> usuariosGest) {
	this.usuariosGest = usuariosGest;
}
public boolean ExisteUsuarioGestion(String b) {
	boolean encontrado = false;
	for(int i = 0; i < cantUsuariosGestion;i++) {
		if(usuariosGest.get(i).getNombreUsuario().equalsIgnoreCase(b)) {
			encontrado = true;
		}
	}
		return encontrado;
}
public int getCantEstudiantes() {
	return cantEstudiantes;
}
public void setCantEstudiantes(int cantEstudiantes) {
	this.cantEstudiantes = cantEstudiantes;
}
}
