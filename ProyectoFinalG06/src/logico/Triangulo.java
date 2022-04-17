package logico;

public class Triangulo extends Prisma {

	private float altura;
	public Triangulo(float base, float altura,int color, String codigo) {
		super(base, color, codigo);
		this.setAltura(altura);
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}

	
}
