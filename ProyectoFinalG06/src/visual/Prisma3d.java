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

public class Prisma3d extends JDialog {
	private Canvas3D canvas3D;

	/**
	 * Create the panel.
	 /*
	  * 
	  */
	public Prisma3d() {
		setBounds(100,100,866,759);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
		
		canvas3D = new Canvas3D(config);
		
		setLayout(new BorderLayout());
		add(canvas3D);
		
		SimpleUniverse universo = new SimpleUniverse(canvas3D);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cerrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});
		panel.add(btnNewButton_1, BorderLayout.EAST);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2, BorderLayout.WEST);
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
		objetogiro.addChild(cubo);
		}
		else if(aux instanceof Rectangulo) {
			float alto = ((Rectangulo) aux).getAltura();
			float ancho = aux.getBase();
			float profundidad = ((Rectangulo) GestionFigura.getPrismaMomento()).getProfundidad();
			Box cubo = new Box(alto,ancho,profundidad,Apariencia);
			objetogiro.addChild(cubo);
			
		}
		else if(aux instanceof Cilindro) {
			float alto = ((Cilindro) aux).getAltura();
			float ancho = aux.getBase();
		Cylinder cilindro = new Cylinder(alto,ancho,Apariencia);
		objetogiro.addChild(cilindro);
			
		}
	else if(aux instanceof Esfera) {
			Sphere esfera = new Sphere(aux.getBase(),Apariencia);
			objetogiro.addChild(esfera);
		}
		else if(aux instanceof Triangulo) {
			Cone cono = new Cone(aux.getBase(),((Triangulo) aux).getAltura(),Apariencia);
			objetogiro.addChild(cono);
			
		}
		Alpha rotacionAlpha = new Alpha(-1,4000);
		RotationInterpolator rotacion =  new RotationInterpolator(rotacionAlpha, objetogiro);
		rotacion.setSchedulingBounds(new BoundingSphere());
		objetoRaiz.addChild(rotacion);
		
		return objetoRaiz;
	}
	public static void main(String [] args) {
		System.setProperty("sun.awt.noerasebackground", "true");
	//JFrame ventana = new JFrame("Pisma 3D");
	//Prisma3d panel = new Prisma3d();
	Prisma3d dialog = new Prisma3d();
	dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	dialog.setVisible(true);
	/*ventana.getContentPane().add(panel);
	ventana.setSize(700,700);
	ventana.setVisible(true);
	ventana.setLocationRelativeTo(null);
	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	

	}
}


