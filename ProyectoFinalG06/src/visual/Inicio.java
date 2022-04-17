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

public class Inicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JButton btnNewButton_1;
	private JPasswordField textContra;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/imagenes/usuario (3).png")));
		setBounds(100, 100, 551, 491);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setBorder(null);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.CYAN);
			panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_1.setBounds(23, 25, 476, 374);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblContrasen = new JLabel("");
			lblContrasen.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/bloquear (1).png")));
			lblContrasen.setBounds(34, 143, 94, 58);
			panel_1.add(lblContrasen);
			lblContrasen.setFont(new Font("Rockwell", Font.PLAIN, 18));
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/usuario (3).png")));
			lblNewLabel.setBounds(34, 49, 94, 64);
			panel_1.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 18));
			
			textUsuario = new JTextField();
			textUsuario.setBounds(143, 68, 283, 33);
			panel_1.add(textUsuario);
			textUsuario.setColumns(10);
			
			btnNewButton_1 = new JButton("");
			btnNewButton_1.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/iniciar-sesion (1).png")));
			btnNewButton_1.setBounds(105, 255, 94, 73);
			panel_1.add(btnNewButton_1);
			
			textContra = new JPasswordField();
			textContra.setBounds(143, 156, 283, 33);
			panel_1.add(textContra);
			{
				JButton cancelButton = new JButton("");
				cancelButton.setIcon(new ImageIcon(Inicio.class.getResource("/imagenes/cerrar-sesion (1).png")));
				cancelButton.setBounds(287, 255, 94, 73);
				panel_1.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
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
