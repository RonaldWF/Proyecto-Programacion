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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;

public class CrearPrisma extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNombreEstudiante;
	private JTextField textApellidoEstudiante;
	private JTextField textEdadEstudiante;
	private JTextField textMatricula;
	private JRadioButton rdbEstudiante;
	private JRadioButton rdbProfesor;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPanel panelProfesor;
	private JPanel panelEstudiante;
	private JButton btnRegistrarEstudiante;

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
		setBounds(100, 100, 866, 759);
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
				panel_1.setBounds(12, 422, 809, 232);
				panel.add(panel_1);
				panel_1.setLayout(null);
			}
			{
				panelEstudiante = new JPanel();
				panelEstudiante.setBorder(new LineBorder(new Color(0, 0, 0)));
				panelEstudiante.setBounds(12, 158, 809, 180);
				panel.add(panelEstudiante);
				panelEstudiante.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Nomrbe:");
					lblNewLabel.setBounds(43, 13, 70, 16);
					panelEstudiante.add(lblNewLabel);
				}
				{
					textNombreEstudiante = new JTextField();
					textNombreEstudiante.setBounds(125, 10, 241, 22);
					panelEstudiante.add(textNombreEstudiante);
					textNombreEstudiante.setColumns(10);
				}
				{
					textApellidoEstudiante = new JTextField();
					textApellidoEstudiante.setBounds(125, 66, 241, 22);
					panelEstudiante.add(textApellidoEstudiante);
					textApellidoEstudiante.setColumns(10);
				}
				{
					textEdadEstudiante = new JTextField();
					textEdadEstudiante.setColumns(10);
					textEdadEstudiante.setBounds(125, 128, 241, 22);
					panelEstudiante.add(textEdadEstudiante);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Apellido:");
					lblNewLabel_1.setBounds(43, 69, 56, 16);
					panelEstudiante.add(lblNewLabel_1);
				}
				{
					JLabel lblEdad = new JLabel("Edad:");
					lblEdad.setBounds(43, 131, 56, 16);
					panelEstudiante.add(lblEdad);
				}
				{
					textMatricula = new JTextField();
					textMatricula.setBounds(538, 66, 116, 22);
					panelEstudiante.add(textMatricula);
					textMatricula.setColumns(10);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Matricula:");
					lblNewLabel_2.setBounds(446, 69, 70, 16);
					panelEstudiante.add(lblNewLabel_2);
				}
				{
					btnRegistrarEstudiante = new JButton("Registrar");
					btnRegistrarEstudiante.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						//	Estudiante est = new Estudiante(textNombreEstudiante.getText(),text)
							
						}
					});
					btnRegistrarEstudiante.addMouseListener(new MouseAdapter() {
						
					});
					btnRegistrarEstudiante.setBounds(685, 142, 97, 25);
					panelEstudiante.add(btnRegistrarEstudiante);
				}
				{
					JButton btnBuscarEstudiante = new JButton("Buscar");
					btnBuscarEstudiante.setBounds(557, 142, 97, 25);
					panelEstudiante.add(btnBuscarEstudiante);
				}
			}
			{
				rdbEstudiante = new JRadioButton("Estudiante");
				rdbEstudiante.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						rdbProfesor.setSelected(false);
						panelEstudiante.setVisible(true);
						panelProfesor.setVisible(false);
						
					}
					
				});
				rdbEstudiante.setFont(new Font("Tahoma", Font.PLAIN, 18));
				rdbEstudiante.setBounds(182, 68, 145, 25);
				panel.add(rdbEstudiante);
			}
			{
				rdbProfesor = new JRadioButton("Profesor");
				rdbProfesor.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						rdbEstudiante.setSelected(false);
						panelProfesor.setVisible(true);
						panelEstudiante.setVisible(false);
					}
				});
				rdbProfesor.setFont(new Font("Tahoma", Font.PLAIN, 18));
				rdbProfesor.setBounds(509, 68, 145, 25);
				panel.add(rdbProfesor);
			}
			
			panelProfesor = new JPanel();
			panelProfesor.setLayout(null);
			panelProfesor.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelProfesor.setBounds(12, 158, 809, 180);
			panel.add(panelProfesor);
			
			JLabel label = new JLabel("Nomrbe:");
			label.setBounds(43, 13, 70, 16);
			panelProfesor.add(label);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(125, 10, 241, 22);
			panelProfesor.add(textField_4);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(125, 66, 241, 22);
			panelProfesor.add(textField_5);
			
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(125, 128, 241, 22);
			panelProfesor.add(textField_6);
			
			JLabel label_1 = new JLabel("Apellido:");
			label_1.setBounds(43, 69, 56, 16);
			panelProfesor.add(label_1);
			
			JLabel label_2 = new JLabel("Edad:");
			label_2.setBounds(43, 131, 56, 16);
			panelProfesor.add(label_2);
			
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(538, 66, 116, 22);
			panelProfesor.add(textField_7);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(446, 69, 70, 16);
			panelProfesor.add(lblCedula);
			
			JButton button = new JButton("Registrar");
			button.setBounds(685, 142, 97, 25);
			panelProfesor.add(button);
			
			JButton button_1 = new JButton("Buscar");
			button_1.setBounds(557, 142, 97, 25);
			panelProfesor.add(button_1);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Cuadrado");
			rdbtnNewRadioButton.setBounds(35, 377, 127, 25);
			panel.add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnRectangulo = new JRadioButton("Rectangulo");
			rdbtnRectangulo.setBounds(197, 377, 127, 25);
			panel.add(rdbtnRectangulo);
			
			JRadioButton rdbtnTrapecio = new JRadioButton("Trapecio");
			rdbtnTrapecio.setBounds(359, 377, 127, 25);
			panel.add(rdbtnTrapecio);
			
			JRadioButton rdbtnRombo = new JRadioButton("Rombo");
			rdbtnRombo.setBounds(521, 377, 127, 25);
			panel.add(rdbtnRombo);
			
			JRadioButton rdbtnTriangulo = new JRadioButton("Triangulo");
			rdbtnTriangulo.setBounds(683, 377, 127, 25);
			panel.add(rdbtnTriangulo);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				panel_1.setBounds(138, 37, 544, 85);
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
