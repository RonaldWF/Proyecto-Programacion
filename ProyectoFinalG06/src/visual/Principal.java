package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.GestionFigura;

import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JMenuItem mntmNewMenuItem_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/pagina-principal.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("gestion03.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(GestionFigura.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 677);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		panel_1.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Prismas");
		menuBar.add(mnNewMenu);
		
		JMenuItem MenuItemListaPrismas = new JMenuItem("Lista de prismas");
		MenuItemListaPrismas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaPrimas dialog = new ListaPrimas();
				dialog.setVisible(true);
			}
		});
		mnNewMenu.add(MenuItemListaPrismas);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Crear Prisma");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			CrearPrisma dialog = new CrearPrisma();
			dialog.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenu MenuGrupo = new JMenu("Grupo");
		menuBar.add(MenuGrupo);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Lista de Prismas");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaGrupos dialog = new ListaGrupos();
				dialog.setVisible(true);
			}
		});
		MenuGrupo.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Crear Grupo");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearGrupo dialog = new CrearGrupo();
				dialog.setVisible(true);
			}
		});
		MenuGrupo.add(mntmNewMenuItem_7);
		
		JMenu MenuEstudiante = new JMenu("Estudiante");
		menuBar.add(MenuEstudiante);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Lista de Prismas");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPrismasEstudiante dialog = new ListaPrismasEstudiante();
				dialog.setVisible(true);
			}
		});
		MenuEstudiante.add(mntmNewMenuItem_1);
		
		JMenuItem MenuItemEstudiantes = new JMenuItem("Lista de Estudiantes");
		MenuItemEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEstudiantes dialog = new ListaEstudiantes();
				dialog.setVisible(true);
			}
		});
		MenuEstudiante.add(MenuItemEstudiantes);
		
		JMenu MenuProfesor = new JMenu("Profesor");
		if(!GestionFigura.getLoginUser().getTipo().equalsIgnoreCase("Profesor")) {
			MenuProfesor.setEnabled(false);
			MenuGrupo.setEnabled(false);
			MenuItemEstudiantes.setEnabled(false);
			MenuItemListaPrismas.setEnabled(false);
		}
		menuBar.add(MenuProfesor);
		
		mntmNewMenuItem_2 = new JMenuItem("Lista de Prismas");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ListasPrismasProfesor dialog = new ListasPrismasProfesor();
				dialog.setVisible(true);
			}
		});
		MenuProfesor.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Lista de profesores");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaProfesores dialog = new ListaProfesores(); 
				dialog.setVisible(true);
			}
		});
		MenuProfesor.add(mntmNewMenuItem_6);
		
		JMenu MenuUsuario = new JMenu("Usuario");
		menuBar.add(MenuUsuario);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Registrarse");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroUsuario dialog = new RegistroUsuario();
				dialog.setVisible(true);
				
			}
		});
		MenuUsuario.add(mntmNewMenuItem_8);
	}
}
