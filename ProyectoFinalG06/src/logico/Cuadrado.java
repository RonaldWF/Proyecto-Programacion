package logico;

public class Cuadrado extends Prisma {

	private float verticeX;
	private float verticeY;
	
	public Cuadrado(float base, float altura, float verticeX, float verticeY) {
		super(base,altura);
		
		this.verticeX = verticeX;
		this.verticeY = verticeY;
	}

	public float getVerticeX() {
		return verticeX;
	}

	public void setVerticeX(float verticeX) {
		this.verticeX = verticeX;
	}

	public float getVerticeY() {
		return verticeY;
	}

	public void setVerticeY(float verticeY) {
		this.verticeY = verticeY;
	}
	
	
}
