package logico;

public class Rectangulo extends Prisma {

	private float profundidad;
	private float altura;
	
	
	public Rectangulo(float base, float altura, float profundidad,int color,String codigo ) {
		super(base, color, codigo);
		this.profundidad = profundidad;
		this.setAltura(altura);
		// TODO Auto-generated constructor stub
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
