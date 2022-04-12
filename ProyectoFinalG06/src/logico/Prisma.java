package logico;

import java.io.Serializable;

public abstract class Prisma implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float base;
	protected float altura;
	
	public Prisma(float base, float altura) {
		super();
		this.base = base;
		this.altura = altura;
		
	}

	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		this.base = base;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	
	
	
}
