package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logico.GestionFigura;
import logico.UsuarioGestion;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Dialog.ModalityType;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;

public class Inicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JButton btnNewButton_1;
	private JPasswordField textContra;
	private JPanel panelExit;
	private JLabel lblFoto;
	private JLabel lblExit;
	private JLabel lblMostrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream ("gestion05.dat");
					empresaRead = new ObjectInputStream(empresa);
					GestionFigura temp = (GestionFigura)empresaRead.readObject();
					GestionFigura.setGestion(temp);
					empresa.close();
					empresaRead.close();
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("gestion05.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						UsuarioGestion aux = new UsuarioGestion("admin", "admin", "Profesor");
						GestionFigura.getInstance().CrearUsuarioGestion(aux);
						empresaWrite.writeObject(GestionFigura.getInstance());
						empresa2.close();
						empresaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) { 
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					Inicio dialog = new Inicio();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Inicio() {
		setUndecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/imagenes/usuario (3).png")));
		setBounds(100, 100, 869, 571);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(null);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBorder(null);
			panel_1.setBounds(12, 78, 514, 436);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblContrasen = new JLabel("");
			lblContrasen.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/bloquear (1).png")));
			lblContrasen.setBounds(130, 162, 94, 64);
			panel_1.add(lblContrasen);
			lblContrasen.setFont(new Font("Rockwell", Font.PLAIN, 18));
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/usuario (3).png")));
			lblNewLabel.setBounds(130, 22, 94, 64);
			panel_1.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 18));
			
			textUsuario = new JTextField();
			textUsuario.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					if(textUsuario.getText().equals("Ingrese su nombre de usuario")) {
						textUsuario.setText("");
						textUsuario.setForeground(Color.BLACK);
					}
					if(textContra.getText().isEmpty()) {
						textContra.setText("********");
						textContra.setForeground(Color.GRAY);
					}
				}
			});
			
			textUsuario.setBorder(null);
			textUsuario.setForeground(Color.LIGHT_GRAY);
			textUsuario.setText("Ingrese su nombre de usuario");
			textUsuario.setBounds(130, 99, 269, 33);
			panel_1.add(textUsuario);
			textUsuario.setColumns(10);
			
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setBackground(Color.WHITE);
			btnNewButton_1.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/iniciar-sesion (1).png")));
			btnNewButton_1.setBounds(214, 322, 94, 73);
			panel_1.add(btnNewButton_1);
			
			textContra = new JPasswordField();
			textContra.setEchoChar('*');
			textContra.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(textContra.getText().equals("********")) {
					textContra.setText("");
					textContra.setForeground(Color.BLACK);
					}
				if(textUsuario.getText().isEmpty()) {
					textUsuario.setText("Ingrese su nombre de usuario");
					textUsuario.setForeground(Color.GRAY);
				}
				
				}
			});
			textContra.setForeground(Color.LIGHT_GRAY);
			textContra.setText("********");
			textContra.setBorder(null);
			textContra.setToolTipText("");
			textContra.setBounds(130, 239, 269, 33);
			panel_1.add(textContra);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(130, 137, 251, 12);
			panel_1.add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(130, 274, 251, 12);
			panel_1.add(separator_1);
			
			lblMostrar = new JLabel("");
			lblMostrar.setForeground(Color.WHITE);
			lblMostrar.setBackground(Color.WHITE);
			lblMostrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					if(!textContra.getText().equals("********")) {
						textContra.setEchoChar((char)0);
						lblMostrar.setBackground(Color.LIGHT_GRAY);
						
					}
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					if(!textContra.getText().equals("********")) {
						textContra.setEchoChar('*');
						lblMostrar.setBackground(Color.WHITE);
					}
				}
			});
			lblMostrar.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/boton-de-visibilidad.png")));
			lblMostrar.setBounds(407, 256, 37, 30);
			panel_1.add(lblMostrar);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(0, 0, 530, 27);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			panelExit = new JPanel();
			panelExit.setBackground(Color.WHITE);
			panelExit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					panelExit.setBackground(Color.RED);
					lblExit.setForeground(Color.WHITE);
					
					
				}
				@Override
				public void mouseExited(MouseEvent e) {
					panelExit.setBackground(Color.WHITE);
					lblExit.setForeground(Color.BLACK);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});
			panelExit.setBounds(0, 0, 34, 27);
			panel_2.add(panelExit);
			
			lblExit = new JLabel("X");
			lblExit.setFont(new Font("Trebuchet MS", Font.PLAIN, 17));
			panelExit.add(lblExit);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/prisma (2).png")));
			lblNewLabel_1.setBounds(642, 78, 159, 156);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("PRISMA 3D");
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 28));
			lblNewLabel_2.setBounds(642, 229, 129, 45);
			panel.add(lblNewLabel_2);
			
			lblFoto = new JLabel("");
			lblFoto.setBounds(538, 0, 321, 551);
			panel.add(lblFoto);
			lblFoto.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/blue-light-background-12465.jpg")));
			
			JLabel lblNewLabel_3 = new JLabel("INICIAR SECCION");
			lblNewLabel_3.setFont(new Font("Myanmar Text", Font.BOLD, 25));
			lblNewLabel_3.setBounds(149, 40, 276, 35);
			panel.add(lblNewLabel_3);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = textUsuario.getText();
					if(GestionFigura.getInstance().buscarUsuarioGestion(aux)!= null) {
						UsuarioGestion use =  GestionFigura.getInstance().buscarUsuarioGestion(aux);
						if(use.getPassword().equalsIgnoreCase(textContra.getText())) {
							Principal frame = new Principal();
							frame.setVisible(true);
							dispose();
						}
						
					}
					else 
						JOptionPane.showMessageDialog(getComponent(0), "Usuario no existe, o algun campo incorrecto");
					
				}
			});
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
