package logico;

public class UsuarioGestion {
	private String NombreUsuario;
	private String password;
	public UsuarioGestion(String nombreUsuario, String password) {
		super();
		setNombreUsuario(nombreUsuario);
		this.setPassword(password);
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombreUsuario() {
		return NombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

}
