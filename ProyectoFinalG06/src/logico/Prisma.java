package logico;

public abstract class Prisma {

	
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
