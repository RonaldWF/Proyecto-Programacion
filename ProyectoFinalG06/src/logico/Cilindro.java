package logico;

public class Cilindro extends Prisma {
private float altura;
	public Cilindro(float base, float altura, int color,String codigo) {
		super(base, color, codigo);
		this.setAltura(altura);
		// TODO Auto-generated constructor stub
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
		
		total+=(Math.PI) * base * altura;
		
		
		return total;
	}
	
	@Override
	public float calcularAreasLaterales() {
		float total=0;
		
		total+=(2) * (Math.PI) * base * altura;
		
		return total;
	}
	@Override
	public float calcularAreasTotales() {
		float total=0;
		
		total+=(2) * ((Math.PI) * base * altura + (2) * ((Math.PI) * Math.pow(base, 2)));
		
		return total;
	}

}
