package logico;

public class Cuadrado extends Prisma {

	private float profundidad;
	private float altura;
	public Cuadrado(float base, float altura, float profundidad,int color) {
		super(base, color);
		this.setAltura(altura);
		
	this.profundidad = profundidad;
	}

	public float getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(float profundidad) {
		this.profundidad = profundidad;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
}

