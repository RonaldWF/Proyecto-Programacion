package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class CrearPrisma extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearPrisma dialog = new CrearPrisma();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearPrisma() {
		setBounds(100, 100, 860, 693);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Creacion de Prisma", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(null, "Cuadrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(12, 351, 809, 232);
				panel.add(panel_1);
				panel_1.setLayout(null);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_1.setBounds(12, 158, 809, 180);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Nomrbe:");
					lblNewLabel.setBounds(43, 13, 70, 16);
					panel_1.add(lblNewLabel);
				}
				{
					textField = new JTextField();
					textField.setBounds(125, 10, 241, 22);
					panel_1.add(textField);
					textField.setColumns(10);
				}
				{
					textField_1 = new JTextField();
					textField_1.setBounds(125, 66, 241, 22);
					panel_1.add(textField_1);
					textField_1.setColumns(10);
				}
				{
					textField_2 = new JTextField();
					textField_2.setColumns(10);
					textField_2.setBounds(125, 128, 241, 22);
					panel_1.add(textField_2);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Apellido:");
					lblNewLabel_1.setBounds(43, 69, 56, 16);
					panel_1.add(lblNewLabel_1);
				}
				{
					JLabel lblEdad = new JLabel("Edad:");
					lblEdad.setBounds(43, 131, 56, 16);
					panel_1.add(lblEdad);
				}
				{
					textField_3 = new JTextField();
					textField_3.setBounds(538, 66, 116, 22);
					panel_1.add(textField_3);
					textField_3.setColumns(10);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Matricula:");
					lblNewLabel_2.setBounds(446, 69, 70, 16);
					panel_1.add(lblNewLabel_2);
				}
				{
					JButton btnNewButton = new JButton("Registrar");
					btnNewButton.setBounds(685, 142, 97, 25);
					panel_1.add(btnNewButton);
				}
				{
					JButton btnNewButton_1 = new JButton("Buscar");
					btnNewButton_1.setBounds(557, 142, 97, 25);
					panel_1.add(btnNewButton_1);
				}
			}
			{
				JRadioButton rdbtnNewRadioButton = new JRadioButton("Estudiante");
				rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
				rdbtnNewRadioButton.setBounds(193, 68, 145, 25);
				panel.add(rdbtnNewRadioButton);
			}
			{
				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Profesor");
				rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
				rdbtnNewRadioButton_1.setBounds(495, 68, 145, 25);
				panel.add(rdbtnNewRadioButton_1);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.LIGHT_GRAY);
				panel_1.setForeground(Color.WHITE);
				panel_1.setBounds(148, 38, 536, 88);
				panel.add(panel_1);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
