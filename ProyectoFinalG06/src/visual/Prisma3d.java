package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.Alpha;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.TransformGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.vecmath.Color3f;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

import logico.Cuadrado;
import logico.GestionFigura;
import logico.Prisma;

public class Prisma3d extends JPanel {

	/**
	 * Create the panel.
	 /*
	  * 
	  */
	public Prisma3d() {
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
		
		Canvas3D canvas3D = new Canvas3D(config);
		
		setLayout(new BorderLayout());
		add(canvas3D);
		
		SimpleUniverse universo = new SimpleUniverse(canvas3D);
		universo.getViewingPlatform().setNominalViewingTransform();
		
		BranchGroup escena = crearGrafoEscena();
		escena.compile();
		
		universo.addBranchGraph(escena);

	}
	public BranchGroup crearGrafoEscena() {
		BranchGroup objetoRaiz = new BranchGroup();
		TransformGroup objetogiro = new TransformGroup();
		
			Prisma aux = GestionFigura.getPrismaMomento();
		objetogiro.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objetoRaiz.addChild(objetogiro);
		float alto = GestionFigura.getPrismaMomento().getAltura();
		float ancho = GestionFigura.getPrismaMomento().getBase();
		float profundidad = ((Cuadrado) GestionFigura.getPrismaMomento()).getProfundidad();
		Appearance AparienciaRoja = new Appearance();
		Color3f rojo = new Color3f(Color.RED);
		ColoringAttributes ca = new ColoringAttributes();
		ca.setColor(rojo);
		AparienciaRoja.setColoringAttributes(ca);
		Box cubo = new Box(alto,ancho,profundidad,AparienciaRoja);
		objetogiro.addChild(cubo);
		Alpha rotacionAlpha = new Alpha(-1,4000);
		RotationInterpolator rotacion =  new RotationInterpolator(rotacionAlpha, objetogiro);
		rotacion.setSchedulingBounds(new BoundingSphere());
		objetoRaiz.addChild(rotacion);
		
		return objetoRaiz;
	}
	public static void main(String [] args) {
		System.setProperty("sun.awt.noerasebackground", "true");
	JFrame ventana = new JFrame("Pisma 3D");
	Prisma3d panel = new Prisma3d();
	ventana.add(panel);
	ventana.setSize(700,700);
	ventana.setVisible(true);
	ventana.setLocationRelativeTo(null);
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

	}
}


