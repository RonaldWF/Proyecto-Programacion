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
private int cantEstudiantesDisp;
private int cantProfesoresDisp;
public static GestionFigura gestion;
public static UsuarioGestion loginUser;
private static Prisma prismaMomento;
private static Usuario usuarioActual;
private static int numeroGrupo = 1;
private static int numeroPrisma = 1;
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
	setCantProfesoresDisp(0);
	setCantEstudiantesDisp(0);
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
			loginUser = usuariosGest.get(i);
		}
	}
	return usuario;
}

public Usuario eliminarUsuario(Usuario usuario) {
	usuarios.remove((Usuario)usuario);  
	cantUsuarios--;
	
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

public Prisma BuscarPrismabyCodigo(String codigo) {
	Prisma aux = null;
	for(int i = 0; i < cantPrismas;i++)
	{
		if(prismas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
			aux = prismas.get(i);
			prismaMomento = prismas.get(i);
		}
	}
	return aux;
}

public void RegistrarEstudiante(Usuario estudiante) {
	estudiantes.add((Estudiante) estudiante);
	//estudiantesDisponibles.add((Estudiante) estudiante);
	cantEstudiantes++;
	cantUsuarios++;
	//cantEstudiantesDisp++;
}
public void EliminarEstudiante(Usuario estudiante) {
	estudiantes.remove((Estudiante)estudiante);  
	cantEstudiantes--;
	cantUsuarios--;
}


public void EliminarProfesor(Usuario profesor) {
	profesores.remove((Profesor)profesor);  
	cantProfesores--;
	cantUsuarios--;
}

public void CrearPrisma(Prisma prisma) {
	prismas.add(prisma);
	prismaMomento = prisma;
	cantPrismas++;
	numeroPrisma++;
}

public void EliminarPrisma(Prisma prisma) {
	prismas.remove(prisma);
	prismaMomento = prisma;
	cantPrismas--;
	numeroPrisma--;
}

public Grupo BuscarGrupo(Usuario usuario) {
	Grupo aux = null;
	
	for(int i = 0; i < cantGrupos; i++) {
		if(usuario instanceof Estudiante) {
		if(grupos.get(i).getEstudiantes().get(i) == usuario) {
			aux = grupos.get(i);
			
		}
		else 
		{
			if(grupos.get(i).getProfesor() == usuario) {
				aux = grupos.get(i);
			}
		}
		}
	}
	
	return aux;
}

public void EliminarGrupo(Grupo grupo) {
	grupos.remove(grupo);
	cantGrupos--;
	numeroGrupo--;
}

public ArrayList<Prisma> BuscarPrismabyMatricula(String matricula) {
	ArrayList<Prisma> aux = null;
	for(int i = 0; i < cantEstudiantes;i++)
	{
		if(estudiantes.get(i).getMatricula().equalsIgnoreCase(matricula)) {
			aux = estudiantes.get(i).getPrismas();
		}
	}
	return aux;
}

public ArrayList<Prisma> BuscarPrismabyCedula(String cedula) {
	ArrayList<Prisma> aux = null;
	for(int i = 0; i < cantEstudiantes;i++)
	{
		if(profesores.get(i).getCedula().equalsIgnoreCase(cedula)) {
			aux = profesores.get(i).getPrismas();
		}
	}
	return aux;
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

public void RegistrarProfesor(Usuario pro) {
	profesores.add((Profesor) pro);
	cantProfesores++;
	cantUsuarios++;
}
//public void RegistrarProfesorDisp(Usuario pro) {
//	profesoresDisponibles.add((Profesor) pro);
	//cantProfesoresDisp++;
//}
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
public static Prisma getPrismaMomento() {
	return prismaMomento;
}
public static void setPrismaMomento(Prisma prismaMomento) {
	GestionFigura.prismaMomento = prismaMomento;
}
public static Usuario getUsuarioActual() {
	return usuarioActual;
}
public static void setUsuarioActual(Usuario usuarioActual) {
	GestionFigura.usuarioActual = usuarioActual;
}

public int getCantEstudiantesDisp() {
	return cantEstudiantesDisp;
}
public void setCantEstudiantesDisp(int cantEstudiantesDisp) {
	this.cantEstudiantesDisp = cantEstudiantesDisp;
}
public int getCantProfesoresDisp() {
	return cantProfesoresDisp;
}
public void setCantProfesoresDisp(int cantProfesoresDisp) {
	this.cantProfesoresDisp = cantProfesoresDisp;
}
public boolean ExisteEstudianteBymatricula(String b) {
	boolean encontrado = false;
	for(int i = 0; i < cantEstudiantes;i++) {
		if(estudiantes.get(i).getMatricula().equalsIgnoreCase(b)) {
			encontrado = true;
		}
	}
		return encontrado;
}
public boolean ExisteProfesorByCedula(String b) {
	boolean encontrado = false;
	for(int i = 0; i < cantProfesores;i++) {
		if(profesores.get(i).getCedula().equalsIgnoreCase(b)) {
			encontrado = true;
		}
	}
		return encontrado;
	
}
public Usuario BuscarUsuariobyLogin(UsuarioGestion usuario) {
	Usuario aux = null;
	for(int i = 0;i < cantUsuarios;i++) {
		if(usuarios.get(i).getUsuario().equals(usuario)){
			aux = usuarios.get(i);
		}
	}
	return aux;
}
public void CrearGrupo(Grupo grupo) {
	grupos.add(grupo);
	cantGrupos++;
	numeroGrupo++;
}
public static int getNumeroGrupo() {
	return numeroGrupo;
}
public static void setNumeroGrupo(int numeroGrupo) {
	GestionFigura.numeroGrupo = numeroGrupo;
}
public static int getNumeroPrisma() {
	return numeroPrisma;
}
public static void setNumeroPrisma(int numeroPrisma) {
	GestionFigura.numeroPrisma = numeroPrisma;
}
}
