package logico;

public class Cuadrado extends Prisma {

	private float profundidad;
	
	public Cuadrado(float base, float altura, float profundidad) {
		super(base,altura);
		
	this.profundidad = profundidad;
	}

	public float getProfundidad() {
		return profundidad;
	}

	public void setProfundidad(float profundidad) {
		this.profundidad = profundidad;
	}
}

