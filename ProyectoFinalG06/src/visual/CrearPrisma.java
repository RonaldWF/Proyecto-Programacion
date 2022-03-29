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
	private JRadioButton rdbtnCuadrado;
	private JRadioButton rdbtnRectangulo;
	private JRadioButton rdbtnTrapecio;
	private JRadioButton rdbtnRombo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JRadioButton rdbtnTriangulo;
	private JPanel pnlRectangulo;
	private JPanel pnlRombo;
	private JPanel pnlTriangulo;
	private JPanel pnlTrapecio;
	private JPanel pnlCuadrado;
	private int hola;

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
				pnlCuadrado = new JPanel();
				pnlCuadrado.setBorder(new TitledBorder(null, "Cuadrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				pnlCuadrado.setBounds(12, 422, 809, 232);
				panel.add(pnlCuadrado);
				pnlCuadrado.setLayout(null);
				
				JLabel lblNewLabel_3 = new JLabel("Vertice X:");
				lblNewLabel_3.setBounds(10, 41, 81, 14);
				pnlCuadrado.add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("Vertice Y:");
				lblNewLabel_4.setBounds(10, 80, 81, 14);
				pnlCuadrado.add(lblNewLabel_4);
				
				textField = new JTextField();
				textField.setBounds(107, 38, 221, 20);
				pnlCuadrado.add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setBounds(107, 77, 221, 20);
				pnlCuadrado.add(textField_1);
				textField_1.setColumns(10);
				
				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.setBounds(557, 198, 97, 23);
				pnlCuadrado.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("Registrar");
				btnNewButton_1.setBounds(685, 198, 97, 23);
				pnlCuadrado.add(btnNewButton_1);
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
			
			rdbtnCuadrado = new JRadioButton("Cuadrado");
			rdbtnCuadrado.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					pnlCuadrado.setVisible(true);
					pnlRectangulo.setVisible(false);
					pnlRombo.setVisible(false);
					pnlTrapecio.setVisible(false);
					pnlTriangulo.setVisible(false);
					rdbtnCuadrado.setSelected(true);
					rdbtnRectangulo.setSelected(false);
					rdbtnRombo.setSelected(false);
					rdbtnTrapecio.setSelected(false);
					rdbtnTriangulo.setSelected(false);
					
					
					
					
				}
			});
			
			
			rdbtnCuadrado.setBounds(35, 377, 127, 25);
			panel.add(rdbtnCuadrado);
			
			rdbtnRectangulo = new JRadioButton("Rectangulo");
			rdbtnRectangulo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					pnlCuadrado.setVisible(false);
					pnlRectangulo.setVisible(true);
					pnlRombo.setVisible(false);
					pnlTrapecio.setVisible(false);
					pnlTriangulo.setVisible(false);
					rdbtnCuadrado.setSelected(false);
					rdbtnRectangulo.setSelected(true);
					rdbtnRombo.setSelected(false);
					rdbtnTrapecio.setSelected(false);
					rdbtnTriangulo.setSelected(false);
					
					
				}
			});
			rdbtnRectangulo.setBounds(197, 377, 127, 25);
			panel.add(rdbtnRectangulo);
			
			rdbtnTrapecio = new JRadioButton("Trapecio");
			rdbtnTrapecio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					pnlCuadrado.setVisible(false);
					pnlRectangulo.setVisible(false);
					pnlRombo.setVisible(false);
					pnlTrapecio.setVisible(true);
					pnlTriangulo.setVisible(false);
					rdbtnCuadrado.setSelected(false);
					rdbtnRectangulo.setSelected(false);
					rdbtnRombo.setSelected(false);
					rdbtnTrapecio.setSelected(true);
					rdbtnTriangulo.setSelected(false);
					
				}
			});
			rdbtnTrapecio.setBounds(359, 377, 127, 25);
			panel.add(rdbtnTrapecio);
			
			rdbtnRombo = new JRadioButton("Rombo");
			rdbtnRombo.setBounds(521, 377, 127, 25);
			panel.add(rdbtnRombo);
			
			rdbtnTriangulo = new JRadioButton("Triangulo");
			rdbtnTriangulo.setBounds(683, 377, 127, 25);
			panel.add(rdbtnTriangulo);
			{
				JPanel pnlEstudianteProfe = new JPanel();
				pnlEstudianteProfe.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				pnlEstudianteProfe.setBounds(138, 37, 544, 85);
				panel.add(pnlEstudianteProfe);
			}
			
			pnlRectangulo = new JPanel();
			pnlRectangulo.setBounds(12, 422, 809, 232);
			panel.add(pnlRectangulo);
			pnlRectangulo.setLayout(null);
			
			JLabel lblNewLabel_5 = new JLabel("Vertice X:");
			lblNewLabel_5.setBounds(10, 41, 81, 14);
			pnlRectangulo.add(lblNewLabel_5);
			
			textField_2 = new JTextField();
			textField_2.setBounds(107, 38, 221, 20);
			pnlRectangulo.add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(107, 77, 221, 20);
			pnlRectangulo.add(textField_3);
			textField_3.setColumns(10);
			
			JButton btnNewButton_2 = new JButton("Buscar");
			btnNewButton_2.setBounds(557, 198, 97, 23);
			pnlRectangulo.add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("Registrar");
			btnNewButton_3.setBounds(685, 198, 97, 23);
			pnlRectangulo.add(btnNewButton_3);
			
			JLabel lblNewLabel_7 = new JLabel("Vertice Y:");
			lblNewLabel_7.setBounds(10, 80, 81, 14);
			pnlRectangulo.add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("Vertice Z:");
			lblNewLabel_8.setBounds(10, 110, 81, 14);
			pnlRectangulo.add(lblNewLabel_8);
			
			textField_16 = new JTextField();
			textField_16.setBounds(107, 110, 221, 20);
			pnlRectangulo.add(textField_16);
			textField_16.setColumns(10);
			
			pnlTrapecio = new JPanel();
			pnlTrapecio.setBounds(12, 422, 809, 232);
			panel.add(pnlTrapecio);
			pnlTrapecio.setLayout(null);
			
			JLabel lblNewLabel_6 = new JLabel(" Vertice TX:");
			lblNewLabel_6.setSize(81, 14);
			lblNewLabel_6.setLocation(10, 41);
			pnlTrapecio.add(lblNewLabel_6);
			
			JLabel lblNewLabel_9 = new JLabel("Vertice TY:");
			lblNewLabel_9.setBounds(10, 80, 81, 14);
			pnlTrapecio.add(lblNewLabel_9);
			
			JLabel lblNewLabel_10 = new JLabel("Vertice TZ:");
			lblNewLabel_10.setBounds(10, 110, 81, 14);
			pnlTrapecio.add(lblNewLabel_10);
			
			JLabel lblNewLabel_11 = new JLabel("Vertice T:");
			lblNewLabel_11.setBounds(10, 130, 81, 14);
			pnlTrapecio.add(lblNewLabel_11);
			
			JLabel lblNewLabel_12 = new JLabel("Altura T:");
			lblNewLabel_12.setBounds(10, 160, 81, 14);
			pnlTrapecio.add(lblNewLabel_12);
			
			textField_4 = new JTextField();
			textField_4.setBounds(107, 38, 221, 20);
			pnlTrapecio.add(textField_4);
			textField_4.setColumns(10);
			
			textField_5 = new JTextField();
			textField_5.setBounds(107, 77, 221, 20);
			pnlTrapecio.add(textField_5);
			textField_5.setColumns(10);
			
			textField_6 = new JTextField();
			textField_6.setBounds(107, 104, 221, 20);
			pnlTrapecio.add(textField_6);
			textField_6.setColumns(10);
			
			textField_7 = new JTextField();
			textField_7.setBounds(107, 130, 221, 20);
			pnlTrapecio.add(textField_7);
			textField_7.setColumns(10);
			
			textField_8 = new JTextField();
			textField_8.setBounds(107, 160, 221, 20);
			pnlTrapecio.add(textField_8);
			textField_8.setColumns(10);
			
			JButton btnNewButton_4 = new JButton("Buscar");
			btnNewButton_4.setBounds(557, 198, 97, 23);
			pnlTrapecio.add(btnNewButton_4);
			
			JButton btnNewButton_5 = new JButton("Registrar");
			btnNewButton_5.setBounds(685, 198, 97, 23);
			pnlTrapecio.add(btnNewButton_5);
			
			pnlRombo = new JPanel();
			pnlRombo.setBounds(0, 0, 809, 232);
			panel.add(pnlRombo);
			pnlRombo.setLayout(null);
			
			JLabel label_3 = new JLabel("New label");
			label_3.setBounds(22, 463, 81, 14);
			pnlRombo.add(label_3);
			
			JLabel label_4 = new JLabel("New label");
			label_4.setBounds(22, 502, 81, 14);
			pnlRombo.add(label_4);
			
			JLabel label_5 = new JLabel("New label");
			label_5.setBounds(22, 532, 81, 14);
			pnlRombo.add(label_5);
			
			JLabel label_6 = new JLabel("New label");
			label_6.setBounds(22, 557, 81, 14);
			pnlRombo.add(label_6);
			
			textField_9 = new JTextField();
			textField_9.setBounds(119, 460, 221, 20);
			textField_9.setColumns(10);
			pnlRombo.add(textField_9);
			
			textField_10 = new JTextField();
			textField_10.setBounds(119, 499, 221, 20);
			textField_10.setColumns(10);
			pnlRombo.add(textField_10);
			
			textField_11 = new JTextField();
			textField_11.setBounds(119, 532, 221, 20);
			textField_11.setColumns(10);
			pnlRombo.add(textField_11);
			
			textField_12 = new JTextField();
			textField_12.setBounds(119, 577, 221, 20);
			textField_12.setColumns(10);
			pnlRombo.add(textField_12);
			
			JButton button = new JButton("New button");
			button.setBounds(569, 620, 97, 23);
			pnlRombo.add(button);
			
			JButton button_1 = new JButton("New button");
			button_1.setBounds(697, 620, 97, 23);
			pnlRombo.add(button_1);
			
			pnlTriangulo = new JPanel();
			pnlTriangulo.setLayout(null);
			pnlTriangulo.setBounds(0, 0, 809, 232);
			panel.add(pnlTriangulo);
			
			JLabel label = new JLabel("Vertice X:");
			label.setBounds(22, 463, 81, 14);
			pnlTriangulo.add(label);
			
			textField_13 = new JTextField();
			textField_13.setColumns(10);
			textField_13.setBounds(119, 460, 221, 20);
			pnlTriangulo.add(textField_13);
			
			textField_14 = new JTextField();
			textField_14.setColumns(10);
			textField_14.setBounds(107, 499, 86, 20);
			pnlTriangulo.add(textField_14);
			
			JButton button_2 = new JButton("New button");
			button_2.setBounds(569, 620, 97, 23);
			pnlTriangulo.add(button_2);
			
			JButton button_3 = new JButton("New button");
			button_3.setBounds(697, 620, 97, 23);
			pnlTriangulo.add(button_3);
			
			JLabel label_7 = new JLabel("New label");
			label_7.setBounds(22, 502, 81, 14);
			pnlTriangulo.add(label_7);
			
			JLabel label_8 = new JLabel("New label");
			label_8.setBounds(22, 532, 81, 14);
			pnlTriangulo.add(label_8);
			
			textField_15 = new JTextField();
			textField_15.setBounds(119, 532, 221, 20);
			pnlTriangulo.add(textField_15);
			textField_15.setColumns(10);
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
