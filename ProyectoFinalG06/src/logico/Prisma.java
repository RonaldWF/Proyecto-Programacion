package logico;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Prisma implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float base;
	protected int color;
	protected String codigo;

	private ArrayList<Prisma>misPrismas;
	
	public Prisma(float base, int color, String codigo) {
		super();
		this.base = base;
		this.color = color;
		this.codigo = codigo;

	}

	public float getBase() {
		return base;
	}

	public void setBase(float base) {
		this.base = base;
	}
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
	public  String getCodigo() {
		return codigo;
	}

	public  void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public float calcularVolumenes(){
		
	Prisma aux=null;
	
	
	float total = 0;
	
		for (Prisma prisma : misPrismas) {
			
			if(prisma instanceof Cuadrado) {
				total+=(((Cuadrado)aux).getBase() * ((Cuadrado)aux).getAltura() * ((Cuadrado)aux).getProfundidad());	
			}
			
			else if (prisma instanceof Rectangulo) {
				total+=(((Rectangulo)aux).getBase() * ((Rectangulo)aux).getAltura() * ((Rectangulo)aux).getProfundidad());
			}
			
			else if (prisma instanceof Triangulo) {
				total+=((1/3)*(((Triangulo)aux).getAltura()) * (((Triangulo)aux).getBase()) * (Math.PI));
			}
			
			else if (prisma instanceof Cilindro) {
				total+=((Math.PI) * (((Cilindro)aux).getBase()) * (((Cilindro)aux).getAltura()));
				
			}
			
			else if (prisma instanceof Esfera) {
				total+=((4/3) * (Math.PI) * (((Esfera)aux).getBase() + ((Esfera)aux).getBase()));
				
			}
			
		}
		
		
		return 0;
		
		
	}
	
	
	public float calcularAreasLaterales(){
		
		Prisma aux=null;
		
		float total = 0;
		
			for (Prisma prisma : misPrismas) {
				
				if(prisma instanceof Cuadrado) {
					total+=((4) * Math.pow(((Cuadrado)aux).getBase(),2));	
				}
				
				else if (prisma instanceof Rectangulo) {
					total+=(2) * ((((Rectangulo)aux).getAltura() * (((Rectangulo)aux).getBase() + ((Rectangulo)aux).getProfundidad())));
				}
				
				else if (prisma instanceof Triangulo) {
					total+=((((Triangulo)aux).getAltura()) * (((Triangulo)aux).getBase()) * (Math.PI));
				}
				
				else if (prisma instanceof Cilindro) {
					total+=(2) * ((Math.PI) * ((Cilindro)aux).getBase() * ((Cilindro)aux).getAltura());
					
				}
				
				else if (prisma instanceof Esfera) {
					total+=((4) * (Math.PI) * (((Esfera)aux).getBase()));
					
				}
				
			}
			
			
			return 0;
			
			
		}
	
public float calcularAreasTotales(){
		
		Prisma aux=null;
		
		float total = 0;
		
			for (Prisma prisma : misPrismas) {
				
				if(prisma instanceof Cuadrado) {
					total+=((6) * Math.pow(((Cuadrado)aux).getBase(),2));	
				}
				
				else if (prisma instanceof Rectangulo) {
					total+=(2) * (((Rectangulo)aux).getBase() * ((Rectangulo)aux).getAltura() + ((Rectangulo)aux).getBase() * ((Rectangulo)aux).getProfundidad());
				}
				
				else if (prisma instanceof Triangulo) {
					total+=(((((Triangulo)aux).getAltura()) * (((Triangulo)aux).getBase()) * (Math.PI)) + ((Math.PI) * Math.pow(((Triangulo)aux).getBase(), 2)));
				}
				
				else if (prisma instanceof Cilindro) {
					total+=((2) * ((Math.PI) * ((Cilindro)aux).getBase() * ((Cilindro)aux).getAltura())) + (2) * ((Math.PI) * Math.pow(((Cilindro)aux).getBase(), 2));
					
				}
				
				else if (prisma instanceof Esfera) {
					total+=((4) * (Math.PI) * (((Esfera)aux).getBase()));
					
				}
				
			}
			
			
			return 0;
			
			
		}


}
