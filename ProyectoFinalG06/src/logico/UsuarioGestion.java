package logico;

import java.io.Serializable;

public class UsuarioGestion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NombreUsuario;
	private String password;
	private String tipo;
	public UsuarioGestion(String nombreUsuario, String password,String tipo) {
		super();
		setNombreUsuario(nombreUsuario);
		this.setPassword(password);
		this.setTipo(tipo);
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
