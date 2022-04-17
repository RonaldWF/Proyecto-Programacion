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
	private ArrayList<Prisma>misPrismas;
	
	public Prisma(float base, int color) {
		super();
		this.base = base;
		this.color = color;

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
	
	public abstract float calcularVolumenes();
	public abstract float calcularAreasLaterales();	
	public abstract float calcularAreasTotales();
	




}
