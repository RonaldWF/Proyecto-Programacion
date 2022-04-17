package logico;

public class Triangulo extends Prisma {

	private float altura;
	public Triangulo(float base, float altura,int color) {
		super(base, color);
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
		Prisma aux = null;
		float total=0;
		
		total+=((1/3)*(((Triangulo)aux).getAltura()) * (((Triangulo)aux).getBase()) * (Math.PI));
		return total;
	}
	@Override
	public float calcularAreasLaterales() {
		Prisma aux = null;
		float total=0;
		total+=((((Triangulo)aux).getAltura()) * (((Triangulo)aux).getBase()) * (Math.PI));
		
		return total;
	}
	@Override
	public float calcularAreasTotales() {
		Prisma aux = null;
		float total=0;
		
		total+=(((((Triangulo)aux).getAltura()) * (((Triangulo)aux).getBase()) * (Math.PI)) + ((Math.PI) * Math.pow(((Triangulo)aux).getBase(), 2)));
		
		return total;
	}

	
}
