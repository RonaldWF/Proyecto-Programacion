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
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
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
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
