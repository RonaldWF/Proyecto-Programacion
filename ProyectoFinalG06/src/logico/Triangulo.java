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
	
	@Override
	public float calcularVolumenes() {
		float total=0;
		
		total+=((1/3)*altura * base * (Math.PI));
		return total;
	}
	@Override
	public float calcularAreasLaterales() {
		float total=0;
		total+=altura * base * (Math.PI);
		
		return total;
	}
	@Override
	public float calcularAreasTotales() {
		float total=0;
		
		total+=altura * base * (Math.PI) + ((Math.PI) * Math.pow(base, 2));
		
		return total;
	}

	
}
