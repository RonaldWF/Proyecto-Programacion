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
import javax.swing.JRadioButton;

public class Inicio extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textContra;
	private JTextField textUsuario;
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
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel_1.setBounds(104, 44, 347, 342);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblContrasen = new JLabel("contrase\u00F1a:");
			lblContrasen.setBounds(126, 142, 95, 22);
			panel_1.add(lblContrasen);
			lblContrasen.setFont(new Font("Rockwell", Font.PLAIN, 18));
			
			JLabel lblNewLabel = new JLabel("Usuario:");
			lblNewLabel.setBounds(126, 38, 94, 16);
			panel_1.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Rockwell", Font.PLAIN, 18));
			
			textUsuario = new JTextField();
			textUsuario.setBounds(32, 67, 283, 33);
			panel_1.add(textUsuario);
			textUsuario.setColumns(10);
			
			textContra = new JTextField();
			textContra.setBounds(32, 177, 282, 33);
			panel_1.add(textContra);
			textContra.setColumns(10);
			
			btnNewButton_1 = new JButton("Iniciar Seccion");
			btnNewButton_1.setBounds(113, 244, 120, 42);
			panel_1.add(btnNewButton_1);
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
