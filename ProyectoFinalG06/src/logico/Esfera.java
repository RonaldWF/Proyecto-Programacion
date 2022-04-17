package logico;

import java.io.Serializable;

public class Esfera extends Prisma{


public Esfera(float base, int color) {
	super(base, color);
}

@Override
public float calcularVolumenes() {
	Prisma aux = null;
	float total=0;
	
	total+=((4/3) * (Math.PI) * (((Esfera)aux).getBase() + ((Esfera)aux).getBase()));
	
	return total;
}

@Override
public float calcularAreasLaterales() {
	Prisma aux = null;
	float total=0;
	
	total+=((4) * (Math.PI) * (((Esfera)aux).getBase()));
	
	return total;
}

@Override
public float calcularAreasTotales() {
	Prisma aux = null;
	float total=0;
	
	total+=((4) * (Math.PI) * (((Esfera)aux).getBase()));
	
	return total;
}

}
