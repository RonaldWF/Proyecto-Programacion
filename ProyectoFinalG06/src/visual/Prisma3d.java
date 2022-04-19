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
import javax.vecmath.Point3d;

import com.sun.j3d.utils.behaviors.mouse.MouseRotate;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

import logico.Cilindro;
import logico.Cuadrado;
import logico.Esfera;
import logico.GestionFigura;
import logico.Prisma;
import logico.Rectangulo;
import logico.Triangulo;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.util.concurrent.CyclicBarrier;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;

public class Prisma3d extends JDialog { 
	private Canvas3D canvas3D;
	private JLabel lblVolumen;
	private JLabel lblBase;

	/**
	 * Create the panel.
	 /*
	  * 
	  */
	public Prisma3d() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Prisma3d.class.getResource("/imagenes/prisma.png")));
		setBounds(100,100,866,759);
		setLocationRelativeTo(null);
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
		
		canvas3D = new Canvas3D(config);
		canvas3D.setBounds(165, 0, 683, 800);
		getContentPane().setLayout(null);
		
		getContentPane().setLayout(null);
		getContentPane().add(canvas3D);
		
		SimpleUniverse universo = new SimpleUniverse(canvas3D);
		
		JLabel lblNewLabel = new JLabel("AREA:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(37, 43, 95, 65);
		getContentPane().add(lblNewLabel);
		
		lblBase = new JLabel("");
		lblBase.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBase.setForeground(Color.RED);
		lblBase.setBounds(23, 101, 109, 58);
		getContentPane().add(lblBase);
		
		JLabel lblVolumentext = new JLabel("VOLUMEN:");
		lblVolumentext.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVolumentext.setBounds(12, 159, 153, 65);
		getContentPane().add(lblVolumentext);
		
		lblVolumen = new JLabel("");
		lblVolumen.setForeground(Color.RED);
		lblVolumen.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblVolumen.setBounds(23, 220, 109, 58);
		getContentPane().add(lblVolumen);
		universo.getViewingPlatform().setNominalViewingTransform();
		
		BranchGroup escena = crearGrafoEscena();
		escena.compile();
		
		universo.addBranchGraph(escena);
		lblBase.setText(Float.toString(GestionFigura.getPrismaMomento().calcularAreasTotales()));
		lblVolumen.setText(Float.toString(GestionFigura.getPrismaMomento().calcularVolumenes()));

	}
	public BranchGroup crearGrafoEscena() {
		BranchGroup objetoRaiz = new BranchGroup();
		TransformGroup mouseGr = new TransformGroup();
		
			Prisma aux = GestionFigura.getPrismaMomento();
			mouseGr.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
			mouseGr.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objetoRaiz.addChild(mouseGr);
		Appearance Apariencia = new Appearance();
		Color3f color = new Color3f();
		if(aux.getColor() == 1) {
		color.set(Color.RED);
		}
		else if(aux.getColor() == 2) {
			color.set(Color.BLUE);
		}
		else if(aux.getColor() == 3) {
			color.set(Color.GREEN);
		}
		else if(aux.getColor() == 4) {
			color.set(Color.YELLOW);
		}
		else if(aux.getColor() == 5) {
			color.set(Color.WHITE);
		}
		ColoringAttributes ca = new ColoringAttributes();
		ca.setColor(color);
		Apariencia.setColoringAttributes(ca);
		if(aux instanceof Cuadrado) {
		float alto = ((Cuadrado) GestionFigura.getPrismaMomento()).getAltura();
		float ancho = GestionFigura.getPrismaMomento().getBase();
		float profundidad = ((Cuadrado) GestionFigura.getPrismaMomento()).getProfundidad();
		Box cubo = new Box(alto,ancho,profundidad,Apariencia);
		mouseGr.addChild(cubo);
		}
		else if(aux instanceof Rectangulo) {
			float alto = ((Rectangulo) aux).getAltura();
			float ancho = aux.getBase();
			float profundidad = ((Rectangulo) GestionFigura.getPrismaMomento()).getProfundidad();
			Box cubo = new Box(alto,ancho,profundidad,Apariencia);
			mouseGr.addChild(cubo);
			
		}
		else if(aux instanceof Cilindro) {
			float alto = ((Cilindro) aux).getAltura();
			float ancho = aux.getBase();
		Cylinder cilindro = new Cylinder(alto,ancho,Apariencia);
		mouseGr.addChild(cilindro);
			
		}
	else if(aux instanceof Esfera) {
			Sphere esfera = new Sphere(aux.getBase(),Apariencia);
			mouseGr.addChild(esfera);
		}
		else if(aux instanceof Triangulo) {
			Cone cono = new Cone(aux.getBase(),((Triangulo) aux).getAltura(),Apariencia);
			mouseGr.addChild(cono);
			
		}
		MouseRotate mr = new MouseRotate();
		mr.setTransformGroup(mouseGr);
		mr.setSchedulingBounds(new BoundingSphere(new Point3d(),1000f));
		objetoRaiz.addChild(mr);
		
		return objetoRaiz;
	}
	public static void main(String [] args) {
		System.setProperty("sun.awt.noerasebackground", "true");
	Prisma3d dialog = new Prisma3d();
	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	dialog.setVisible(true);
	

	}
}


