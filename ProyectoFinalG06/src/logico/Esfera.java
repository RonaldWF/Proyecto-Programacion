package logico;

import java.io.Serializable;

public class Esfera extends Prisma{


public Esfera(float base, int color,String codigo) {
	super(base, color, codigo);
}

@Override
public float calcularVolumenes() {
	float total=0;
	
	total+=((4/3) * ((Math.PI) * base + base));
	
	return total;
}

@Override
public float calcularAreasLaterales() {
	float total=0;
	
	total+=((4) * (Math.PI) * base);
	
	return total;
}

@Override
public float calcularAreasTotales() {
	float total=0;
	
	total+=((4) * (Math.PI) * base);
	
	return total;
}

}
