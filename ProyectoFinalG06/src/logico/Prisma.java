package logico;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Prisma implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float base;
	protected int color;
	protected String codigo;

	private ArrayList<Prisma>misPrismas;
	
	public Prisma(float base, int color, String codigo) {
		super();
		this.base = base;
		this.color = color;
		this.codigo = codigo;

	}

	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		this.base = base;
	}
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	public  String getCodigo() {
		return codigo;
	}

	public  void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public abstract float calcularVolumenes();
	public abstract float calcularAreasLaterales();	
	public abstract float calcularAreasTotales();
	


}
