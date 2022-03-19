package logico;

public class Trapecio extends Prisma {

	
	private float verticeTX;
	private float verticeTY;
	private float verticeTZ;
	private float verticeT;
	private float alturaT;
	
	public Trapecio(float base, float altura, float verticeTX, float verticeTY, float verticeTZ, float verticeT,
			float alturaT) {
		super(base, altura);
		this.verticeTX = verticeTX;
		this.verticeTY = verticeTY;
		this.verticeTZ = verticeTZ;
		this.verticeT = verticeT;
		this.alturaT = alturaT;
	}

	public float getVerticeTX() {
		return verticeTX;
	}

	public void setVerticeTX(float verticeTX) {
		this.verticeTX = verticeTX;
	}

	public float getVerticeTY() {
		return verticeTY;
	}

	public void setVerticeTY(float verticeTY) {
		this.verticeTY = verticeTY;
	}

	public float getVerticeTZ() {
		return verticeTZ;
	}

	public void setVerticeTZ(float verticeTZ) {
		this.verticeTZ = verticeTZ;
	}

	public float getVerticeT() {
		return verticeT;
	}

	public void setVerticeT(float verticeT) {
		this.verticeT = verticeT;
	}

	public float getAlturaT() {
		return alturaT;
	}

	public void setAlturaT(float alturaT) {
		this.alturaT = alturaT;
	}
	
	
	
}
