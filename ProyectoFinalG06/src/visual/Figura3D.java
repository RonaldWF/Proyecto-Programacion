package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class Figura3D extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			System.setProperty("sun.awt.noerasebackground", "true");
			Figura3D dialog = new Figura3D();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Figura3D() {
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
	}


