package logico;

public class Rectangulo extends Prisma {

	private float profundidad;
	
	
	public Rectangulo(float base, float altura, float profundidad ) {
		super(base, altura);
		this.profundidad = profundidad;
		// TODO Auto-generated constructor stub
	}


	public float getProfundidad() {
		return profundidad;
	}


	public void setProfundidad(float profundidad) {
		this.profundidad = profundidad;
	}

	
	
	
}
