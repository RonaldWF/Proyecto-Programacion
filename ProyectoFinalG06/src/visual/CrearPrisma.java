package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Estudiante;
import logico.GestionFigura;
import logico.Profesor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;

public class CrearPrisma extends JDialog {

	protected static final int ArrayList = 0;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombreEstudiante;
	private JTextField textApellidoEstudiante;
	private JTextField textEdadEstudiante;
	private JTextField textMatricula;
	private JRadioButton rdbEstudiante;
	private JRadioButton rdbProfesor;
	private JPanel panelProfesor;
	private JPanel panelEstudiante;
	private JButton btnRegistrarEstudiante;
	private JTextField textNombreProfesor;
	private JTextField textCedula;
	private JTextField textApellidoProfesor;
	private JTextField textEdadProfesor;

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
					JLabel lblNewLabel = new JLabel("Nombre:");
					lblNewLabel.setBounds(43, 69, 70, 16);
					panelEstudiante.add(lblNewLabel);
				}
				{
					textNombreEstudiante = new JTextField();
					textNombreEstudiante.setBounds(125, 66, 241, 22);
					panelEstudiante.add(textNombreEstudiante);
					textNombreEstudiante.setColumns(10);
				}
				{
					textApellidoEstudiante = new JTextField();
					textApellidoEstudiante.setBounds(125, 114, 241, 22);
					panelEstudiante.add(textApellidoEstudiante);
					textApellidoEstudiante.setColumns(10);
				}
				{
					textEdadEstudiante = new JTextField();
					textEdadEstudiante.setColumns(10);
					textEdadEstudiante.setBounds(539, 66, 170, 22);
					panelEstudiante.add(textEdadEstudiante);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Apellido:");
					lblNewLabel_1.setBounds(43, 114, 56, 16);
					panelEstudiante.add(lblNewLabel_1);
				}
				{
					JLabel lblEdad = new JLabel("Edad:");
					lblEdad.setBounds(471, 69, 56, 16);
					panelEstudiante.add(lblEdad);
				}
				{
					textMatricula = new JTextField();
					textMatricula.setBounds(125, 10, 241, 22);
					panelEstudiante.add(textMatricula);
					textMatricula.setColumns(10);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Matricula:");
					lblNewLabel_2.setBounds(39, 13, 70, 16);
					panelEstudiante.add(lblNewLabel_2);
				}
				{
					btnRegistrarEstudiante = new JButton("Registrar");
					btnRegistrarEstudiante.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int edad = Integer.parseInt(textEdadEstudiante.getText());
							Estudiante est = new Estudiante(textNombreEstudiante.getText(),textApellidoEstudiante.getText(),edad,textMatricula.getText());
							GestionFigura.getInstance().RegistrarEstudiante(est);
							JOptionPane.showMessageDialog(panel, "Registro con Exito");
							clear();
						}

					});
					btnRegistrarEstudiante.addMouseListener(new MouseAdapter() {
						
					});
					btnRegistrarEstudiante.setBounds(685, 142, 97, 25);
					panelEstudiante.add(btnRegistrarEstudiante);
				}
				{
					JButton btnBuscarEstudiante = new JButton("Buscar");
					btnBuscarEstudiante.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							if (GestionFigura.getInstance().BuscarEstudianteBymatricula(textMatricula.getText())!= null) {
								Estudiante aux = GestionFigura.getInstance().BuscarEstudianteBymatricula(textMatricula.getText());
								textNombreEstudiante.setText(aux.getNombre());
								textApellidoEstudiante.setText(aux.getApellido());
								textEdadEstudiante.setText(Integer.toString(aux.getEdad()));
								textMatricula.setText(aux.getMatricula());
							}
						}
					});
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
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(43, 69, 70, 16);
			panelProfesor.add(lblNombre);
			
			textNombreProfesor = new JTextField();
			textNombreProfesor.setColumns(10);
			textNombreProfesor.setBounds(125, 66, 241, 22);
			panelProfesor.add(textNombreProfesor);
			
			textApellidoProfesor = new JTextField();
			textApellidoProfesor.setColumns(10);
			textApellidoProfesor.setBounds(125, 114, 241, 22);
			panelProfesor.add(textApellidoProfesor);
			
			textEdadProfesor = new JTextField();
			textEdadProfesor.setColumns(10);
			textEdadProfesor.setBounds(539, 66, 170, 22);
			panelProfesor.add(textEdadProfesor);
			
			JLabel label_1 = new JLabel("Apellido:");
			label_1.setBounds(43, 114, 56, 16);
			panelProfesor.add(label_1);
			
			JLabel label_2 = new JLabel("Edad:");
			label_2.setBounds(471, 69, 56, 16);
			panelProfesor.add(label_2);
			
			textCedula = new JTextField();
			textCedula.setColumns(10);
			textCedula.setBounds(125, 10, 241, 22);
			panelProfesor.add(textCedula);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBounds(39, 13, 70, 16);
			panelProfesor.add(lblCedula);
			
			JButton btnRegistrarProfesor = new JButton("Registrar");   //Se necesita agregar algo en el campo prismas, no se que meter ahi
			btnRegistrarProfesor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int edad = Integer.parseInt(textEdadProfesor.getText()); 
					Profesor pro = new Profesor(textNombreProfesor.getText(), textApellidoProfesor.getText(), edad, textCedula.getText());
					GestionFigura.getInstance().RegistrarProfesor(pro);
					JOptionPane.showMessageDialog(panel, "Registro con Exito");
					clear();
				}
			});
			btnRegistrarProfesor.setBounds(685, 142, 97, 25);
			panelProfesor.add(btnRegistrarProfesor);
			
			JButton btnBuscarProfesor = new JButton("Buscar");
			btnBuscarProfesor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(GestionFigura.getInstance().BuscarProfesorByCedula(textCedula.getText())!= null) {
						Profesor aux = GestionFigura.getInstance().BuscarProfesorByCedula(textCedula.getText());
						textNombreProfesor.setText(aux.getNombre());
						textApellidoProfesor.setText(aux.getApellido());
						textEdadProfesor.setText(Integer.toString(aux.getEdad()));
						textCedula.setText(aux.getCedula());
					}
				}
			});
			btnBuscarProfesor.setBounds(557, 142, 97, 25);
			panelProfesor.add(btnBuscarProfesor);
			
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
	private void clear() {
		textNombreEstudiante.setText("");
		textApellidoEstudiante.setText("");
		textMatricula.setText("");
		textEdadEstudiante.setText("");
		textNombreProfesor.setText("");
		textApellidoProfesor.setText("");
		textCedula.setText("");
		textEdadProfesor.setText("");
	}
}
