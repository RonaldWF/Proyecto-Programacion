package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import logico.GestionFigura;
import logico.UsuarioGestion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class RegistroUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JTextField textContra;
	private JTextField textContraConfirm;
	private JRadioButton rdbProfesor;
	private JRadioButton rdbEstudiante;
	private String tipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroUsuario dialog = new RegistroUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistroUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroUsuario.class.getResource("/imagenes/registros-medicos.png")));
		setBounds(100, 100, 513, 401);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registrate", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(72, 27, 351, 265);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(137, 27, 187, 27);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(33, 32, 56, 16);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(33, 87, 69, 16);
		panel.add(lblPassword);
		
		textContra = new JTextField();
		textContra.setColumns(10);
		textContra.setBounds(137, 82, 187, 27);
		panel.add(textContra);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setBounds(33, 144, 69, 16);
		panel.add(lblPassword_1);
		
		textContraConfirm = new JTextField();
		textContraConfirm.setColumns(10);
		textContraConfirm.setBounds(137, 139, 187, 27);
		panel.add(textContraConfirm);
		
		rdbEstudiante = new JRadioButton("Estudiante");
		rdbEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbProfesor.setSelected(false);
				tipo = "Estudiante";
				
			}
		});
		rdbEstudiante.setBounds(54, 193, 127, 25);
		panel.add(rdbEstudiante);
		
		rdbProfesor = new JRadioButton("Profesor");
		rdbProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbEstudiante.setSelected(false);
				tipo = "Profesor";
			}
		});
		rdbProfesor.setBounds(197, 193, 127, 25);
		panel.add(rdbProfesor);
		{
			JButton cancelButton = new JButton("");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			cancelButton.setBounds(444, 318, 51, 36);
			contentPanel.add(cancelButton);
			cancelButton.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/imagenes/flecha-hacia-atras (2).png")));
			cancelButton.setActionCommand("Cancel");
		}
		{
			JButton okButton = new JButton("");
			okButton.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/imagenes/guardar-el-archivo (1).png")));
			okButton.setBounds(396, 318, 51, 36);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if(rdbEstudiante.isSelected()) {
						 tipo = "Estudiante";
					}
					else if(rdbProfesor.isSelected()) {
						 tipo = "Profesor";
					}
					UsuarioGestion aux2 = new UsuarioGestion(textUsuario.getText(),textContra.getText(),tipo);
					GestionFigura.getInstance().CrearUsuarioGestion(aux2);
					dispose();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 316, 495, 38);
		contentPanel.add(panel_1);
	}
}
