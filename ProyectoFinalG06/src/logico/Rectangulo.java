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


	@Override
	public float calcularVolumenes() {
		float total=0;
		total +=(base * altura * profundidad);
		
		
		return total;
	}


	@Override
	public float calcularAreasLaterales() {
		float total=0;
		total += (2) * ((altura * base) + profundidad);
		
		
		
		return total;
	}


	@Override
	public float calcularAreasTotales() {
		float total=0;
		total += (2) * (base *altura + (base * profundidad));
		
		
		return total;
	}

	
	
	
}
