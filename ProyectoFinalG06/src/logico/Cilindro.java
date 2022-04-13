package logico;

public class Cilindro extends Prisma {
private float altura;
	public Cilindro(float base, float altura, int color) {
		super(base, color);
		this.setAltura(altura);
		// TODO Auto-generated constructor stub
	}
	public float getAltura() {
		return altura;
	}
	public void setAltura(float altura) {
		this.altura = altura;
	}

}
