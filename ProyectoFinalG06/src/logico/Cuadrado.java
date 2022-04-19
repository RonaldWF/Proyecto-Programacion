package logico;

public  class Cuadrado extends Prisma {

	private float profundidad;
	private float altura;
	public Cuadrado(float base, float altura, float profundidad,int color,String codigo) {
		super(base, color, codigo);
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
	
	
	@Override
	public float calcularVolumenes() {
		
		float total=0;
		total += base * altura * profundidad;	
		
		
		return total;
	}
	
	@Override
	public float calcularAreasLaterales() {
		float total=0;
		
		total+=((4) * Math.pow(base,2));
		
		return total;
	}
	
	@Override
	public float calcularAreasTotales() {
		float total=0;
		
		total+=((6) * Math.pow(base,2));


		return total;
	}
	
}

