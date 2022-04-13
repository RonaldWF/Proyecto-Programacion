package logico;

public class Triangulo extends Prisma {

	private float altura;
	public Triangulo(float base, float altura,int color) {
		super(base, color);
		this.setAltura(altura);
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}

	
}
