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
	@Override
	public float calcularVolumenes() {
		Prisma aux = null;
		float total=0;
		
		total+=((Math.PI) * (((Cilindro)aux).getBase()) * (((Cilindro)aux).getAltura()));
		
		
		return total;
	}
	
	@Override
	public float calcularAreasLaterales() {
		Prisma aux = null;
		float total=0;
		
		total+=(2) * ((Math.PI) * ((Cilindro)aux).getBase() * ((Cilindro)aux).getAltura());
		
		return total;
	}
	@Override
	public float calcularAreasTotales() {
		Prisma aux = null;
		float total=0;
		
		total+=((2) * ((Math.PI) * ((Cilindro)aux).getBase() * ((Cilindro)aux).getAltura())) + (2) * ((Math.PI) * Math.pow(((Cilindro)aux).getBase(), 2));
		
		return total;
	}

}
