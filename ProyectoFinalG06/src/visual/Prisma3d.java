package visual;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class Prisma3d extends JPanel {

	/**
	 * Create the panel.
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
		
		objetoRaiz.addChild(new ColorCube(0.2));
		
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
