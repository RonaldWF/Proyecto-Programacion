package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import logico.GestionFigura;
import logico.UsuarioGestion;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.EtchedBorder;

public class Inicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textContra;
	private JTextField textUsuario;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Inicio dialog = new Inicio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Inicio() {
		setBounds(100, 100, 572, 491);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Inicio de Seccion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			textUsuario = new JTextField();
			textUsuario.setBounds(276, 87, 139, 33);
			textUsuario.setText(" ");
			panel.add(textUsuario);
			textUsuario.setColumns(10);
			
			textContra = new JTextField();
			textContra.setBounds(276, 167, 139, 33);
			textContra.setText(" ");
			panel.add(textContra);
			textContra.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 18));
			lblNewLabel.setBounds(128, 95, 94, 16);
			panel.add(lblNewLabel);
			
			JLabel lblContrasen = new JLabel("contrase\u00F1a:");
			lblContrasen.setFont(new Font("Rockwell", Font.PLAIN, 18));
			lblContrasen.setBounds(128, 175, 106, 25);
			panel.add(lblContrasen);
			
			btnNewButton = new JButton("Registrarse");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//if(textUsuario.getText() != " " && textContra.getText()!= " ") {
					UsuarioGestion usuario = new UsuarioGestion(textUsuario.getText(),textContra.getText());
					GestionFigura.getInstance().CrearUsuarioGestion(usuario);
					//textContra.setText("");
					//textUsuario.setText("");
				//}
					//else
						//JOptionPane.showMessageDialog(getComponent(0), "Asegure llenar todos los campos");
				}
			});
			btnNewButton.setBounds(128, 283, 120, 42);
			panel.add(btnNewButton);
			
			btnNewButton_1 = new JButton("Iniciar Seccion");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String aux = textUsuario.getText();
					if(GestionFigura.getInstance().buscarUsuarioGestion(aux)!= null) {
						UsuarioGestion use =  GestionFigura.getInstance().buscarUsuarioGestion(aux);
						if(use.getPassword().equalsIgnoreCase(textContra.getText())) {
							Principal frame = new Principal();
							frame.setVisible(true);
						}
						
					}
					else 
						JOptionPane.showMessageDialog(getComponent(0), "Usuario no existe, o algun campo incorrecto");
					
				}
			});
			btnNewButton_1.setBounds(295, 283, 120, 42);
			panel.add(btnNewButton_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_1.setBounds(104, 44, 347, 342);
			panel.add(panel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
