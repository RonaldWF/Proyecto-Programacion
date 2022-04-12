package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cuadrado;
import logico.Estudiante;
import logico.GestionFigura;
import logico.Prisma;
import logico.Profesor;
import logico.Rectangulo;
import logico.Triangulo;
import logico.Usuario;
import java.util.ArrayList;

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
import javax.swing.ImageIcon;

public class CrearPrisma extends JDialog {

	protected static final int ArrayList = 0;
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombreEstudiante;
	private JTextField textApellidoEstudiante;
	private JTextField textEdadEstudiante;
	private JTextField textMatricula;
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
	private JTextField textAnchoCuadrado;
	private JTextField textAlturaCuadrado;
	private JTextField textAnchoRectangulo;
	private JTextField textAlturaRectangulo;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textBaseTriangulo;
	private JTextField textAlturaTriangulo;
	private JTextField textProfundidadRectangulo;
	private JRadioButton rdbtnTriangulo;
	private JPanel pnlRectangulo;
	private JPanel pnlRombo;
	private JPanel pnlTriangulo;
	private JPanel pnlTrapecio;
	private JPanel pnlCuadrado;
	private int hola=5000;
	private JTextField textProfundidadCuadrado;

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
				
				JLabel lblNewLabel_3 = new JLabel("Ancho:");
				lblNewLabel_3.setBounds(10, 41, 81, 14);
				pnlCuadrado.add(lblNewLabel_3);
				
				JLabel lblNewLabel_4 = new JLabel("Altura:");
				lblNewLabel_4.setBounds(10, 80, 81, 14);
				pnlCuadrado.add(lblNewLabel_4);
				
				textAnchoCuadrado = new JTextField();
				textAnchoCuadrado.setBounds(107, 38, 561, 20);
				pnlCuadrado.add(textAnchoCuadrado);
				textAnchoCuadrado.setColumns(10);
				
				textAlturaCuadrado = new JTextField();
				textAlturaCuadrado.setBounds(107, 77, 561, 20);
				pnlCuadrado.add(textAlturaCuadrado);
				textAlturaCuadrado.setColumns(10);
				
				JButton btnNewButton_1 = new JButton("Crear");
				btnNewButton_1.addActionListener(new ActionListener() {
					 public void actionPerformed(ActionEvent arg0) {
						if(!textAnchoCuadrado.getText().equalsIgnoreCase("")&& !textAlturaCuadrado.getText().equalsIgnoreCase("") && !textProfundidadCuadrado.getText().equalsIgnoreCase("")) {
							
							float ancho = Float.parseFloat(textAnchoCuadrado.getText());
							float altura = Float.parseFloat(textAlturaCuadrado.getText());
							float profundidad = Float.parseFloat(textProfundidadCuadrado.getText());
							if(ancho > altura || altura > ancho) {
								JOptionPane.showMessageDialog(contentPanel, "El Cuadrado debe tener todos los lados iguales.");
								
							}
							else {
							Prisma aux = new Cuadrado(ancho,altura,profundidad);
							ArrayList<Prisma> prismasUser = new ArrayList<Prisma>(100);
							prismasUser.add(aux);
							GestionFigura.getInstance().CrearPrisma(aux);
							if(!textCedula.getText().equalsIgnoreCase("")) {
								  
									if(GestionFigura.getInstance().BuscarProfesorByCedula(textCedula.getText())!= null) {
										Profesor au3 = GestionFigura.getInstance().BuscarProfesorByCedula(textCedula.getText());
										au3.setPrismas(prismasUser);
									}
								}
							else if(!textMatricula.getText().equalsIgnoreCase("")) {
								if (GestionFigura.getInstance().BuscarEstudianteBymatricula(textMatricula.getText())!= null) {
									Estudiante au4 = GestionFigura.getInstance().BuscarEstudianteBymatricula(textMatricula.getText());
									au4.setPrismas(prismasUser);
								}
							}
						    Prisma3d dialog = new Prisma3d();
						    dialog.setVisible(true);
						    
							}
						
						}
						else 
						{
							JOptionPane.showMessageDialog(contentPanel, "Algun campo vacio, por favor llenar todos los campos.");
						}
							
					}
				});
				btnNewButton_1.setBounds(685, 198, 97, 23);
				pnlCuadrado.add(btnNewButton_1);
				
				JLabel lblProdunfidad = new JLabel("Produnfidad:");
				lblProdunfidad.setBounds(10, 127, 81, 14);
				pnlCuadrado.add(lblProdunfidad);
				
				textProfundidadCuadrado = new JTextField();
				textProfundidadCuadrado.setColumns(10);
				textProfundidadCuadrado.setBounds(107, 123, 561, 20);
				pnlCuadrado.add(textProfundidadCuadrado);
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
					btnRegistrarEstudiante.setEnabled(false);
					btnRegistrarEstudiante.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(!textMatricula.getText().equalsIgnoreCase("") && !textNombreEstudiante.getText().equalsIgnoreCase("") && !textApellidoEstudiante.getText().equalsIgnoreCase("")
									&& !textEdadEstudiante.getText().equalsIgnoreCase("")) {
							int edad = Integer.parseInt(textEdadEstudiante.getText());
							Usuario est = new Estudiante(textNombreEstudiante.getText(),textApellidoEstudiante.getText(),edad,textMatricula.getText());
						//	UsuarioActual = est;
							GestionFigura.getInstance().RegistrarEstudiante(est);
							JOptionPane.showMessageDialog(panel, "Registro con Exito");
							clear();
						}
							else {
								JOptionPane.showMessageDialog(contentPanel, "Asegurese de llenar todos los datos.");
							}
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
							else {
								JOptionPane.showMessageDialog(contentPanel, "Usuario no encontrado.");
								btnRegistrarEstudiante.setEnabled(true);
							}
						}
					});
					btnBuscarEstudiante.setBounds(557, 142, 97, 25);
					panelEstudiante.add(btnBuscarEstudiante);
				}
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
					Usuario pro = new Profesor(textNombreProfesor.getText(), textApellidoProfesor.getText(), edad, textCedula.getText());
					GestionFigura.getInstance().RegistrarProfesor(pro);
					JOptionPane.showMessageDialog(panel, "Registro con Exito");
					clear();
				}
			});
			btnRegistrarProfesor.setBounds(685, 142, 97, 25);
			panelProfesor.add(btnRegistrarProfesor);
			
			JButton btnBuscarProfesor = new JButton("Buscar");
			btnRegistrarProfesor.setEnabled(false);
			btnBuscarProfesor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(GestionFigura.getInstance().BuscarProfesorByCedula(textCedula.getText())!= null) {
						Profesor aux = GestionFigura.getInstance().BuscarProfesorByCedula(textCedula.getText());
						textNombreProfesor.setText(aux.getNombre());
						textApellidoProfesor.setText(aux.getApellido());
						textEdadProfesor.setText(Integer.toString(aux.getEdad()));
						textCedula.setText(aux.getCedula());
					}
					else {
						JOptionPane.showMessageDialog(contentPanel, "Usuario no encontrado.");
						btnRegistrarProfesor.setEnabled(true);
					}
				}
			});
			btnBuscarProfesor.setBounds(557, 142, 97, 25);
			panelProfesor.add(btnBuscarProfesor);
			
			rdbtnCuadrado = new JRadioButton("Cuadrado");
			rdbtnCuadrado.setSelected(true);
			rdbtnCuadrado.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					rdbtnCuadrado.setSelected(true);
					pnlCuadrado.setVisible(true);
					pnlRectangulo.setVisible(false);
					pnlRombo.setVisible(false);
					pnlTrapecio.setVisible(false);
					pnlTriangulo.setVisible(false);
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
			
			rdbtnTrapecio = new JRadioButton("Esfera");
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
			
			rdbtnRombo = new JRadioButton("Cilindro");
			rdbtnRombo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					pnlCuadrado.setVisible(false);
					pnlRectangulo.setVisible(false);
					pnlRombo.setVisible(true);
					pnlTrapecio.setVisible(false);
					pnlTriangulo.setVisible(false);
					rdbtnCuadrado.setSelected(false);
					rdbtnRectangulo.setSelected(false);
					rdbtnRombo.setSelected(true);
					rdbtnTrapecio.setSelected(false);
					rdbtnTriangulo.setSelected(false);
					
					
				}
			});
			rdbtnRombo.setBounds(521, 377, 127, 25);
			panel.add(rdbtnRombo);
			
			rdbtnTriangulo = new JRadioButton("Triangulo");
			rdbtnTriangulo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					pnlCuadrado.setVisible(false);
					pnlRectangulo.setVisible(false);
					pnlRombo.setVisible(false);
					pnlTrapecio.setVisible(false);
					pnlTriangulo.setVisible(true);
					rdbtnCuadrado.setSelected(false);
					rdbtnRectangulo.setSelected(false);
					rdbtnRombo.setSelected(false);
					rdbtnTrapecio.setSelected(false);
					rdbtnTriangulo.setSelected(true);
					
				}
			});
			rdbtnTriangulo.setBounds(683, 377, 127, 25);
			panel.add(rdbtnTriangulo);
			
			pnlRectangulo = new JPanel();
			pnlRectangulo.setBorder(new TitledBorder(null, "Rectangulo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlRectangulo.setBounds(12, 422, 809, 232);
			panel.add(pnlRectangulo);
			pnlRectangulo.setLayout(null);
			
			JLabel lblNewLabel_5 = new JLabel("Ancho:");
			lblNewLabel_5.setBounds(10, 41, 81, 14);
			pnlRectangulo.add(lblNewLabel_5);
			
			textAnchoRectangulo = new JTextField();
			textAnchoRectangulo.setBounds(107, 38, 561, 20);
			pnlRectangulo.add(textAnchoRectangulo);
			textAnchoRectangulo.setColumns(10);
			
			textAlturaRectangulo = new JTextField();
			textAlturaRectangulo.setBounds(107, 77, 561, 20);
			pnlRectangulo.add(textAlturaRectangulo);
			textAlturaRectangulo.setColumns(10);
			
			JButton btnNewButton_3 = new JButton("Crear");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					float ancho =  Float.parseFloat(textAnchoRectangulo.getText());
					float altura = Float.parseFloat(textAlturaRectangulo.getText());
					float profundidad = Float.parseFloat(textProfundidadRectangulo.getText());
					Prisma aux2 = new Rectangulo(ancho,altura,profundidad);
					GestionFigura.getInstance().CrearPrisma(aux2);
					ArrayList<Prisma> prismasUser = new ArrayList<Prisma>(100);
					prismasUser.add(aux2);
					if(GestionFigura.getInstance().BuscarProfesorByCedula(textCedula.getText())!= null) {
						Profesor au3 = GestionFigura.getInstance().BuscarProfesorByCedula(textCedula.getText());
						au3.setPrismas(prismasUser);
					}
				
			else if(!textMatricula.getText().equalsIgnoreCase("")) {
				if (GestionFigura.getInstance().BuscarEstudianteBymatricula(textMatricula.getText())!= null) {
					Estudiante au4 = GestionFigura.getInstance().BuscarEstudianteBymatricula(textMatricula.getText());
					au4.setPrismas(prismasUser);
				}
			}
					Prisma3d dialog = new Prisma3d();
					dialog.setVisible(true);
				}
			});
			btnNewButton_3.setBounds(685, 198, 97, 23);
			pnlRectangulo.add(btnNewButton_3);
			
			JLabel lblNewLabel_7 = new JLabel("Altura:");
			lblNewLabel_7.setBounds(10, 80, 81, 14);
			pnlRectangulo.add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel("Profundidad:");
			lblNewLabel_8.setBounds(10, 127, 81, 14);
			pnlRectangulo.add(lblNewLabel_8);
			
			textProfundidadRectangulo = new JTextField();
			textProfundidadRectangulo.setBounds(107, 123, 561, 20);
			pnlRectangulo.add(textProfundidadRectangulo);
			textProfundidadRectangulo.setColumns(10);
			
			pnlTrapecio = new JPanel();
			pnlTrapecio.setBorder(new TitledBorder(null, "Trapecio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
			
			JButton btnNewButton_5 = new JButton("Crear");
			btnNewButton_5.setBounds(685, 198, 97, 23);
			pnlTrapecio.add(btnNewButton_5);
			
			pnlTriangulo = new JPanel();
			pnlTriangulo.setBorder(new TitledBorder(null, "Triangulo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlTriangulo.setLayout(null);
			pnlTriangulo.setBounds(12, 422, 809, 232);
			panel.add(pnlTriangulo);
			
			JLabel lblBase = new JLabel("Base:");
			lblBase.setBounds(10, 41, 81, 14);
			pnlTriangulo.add(lblBase);
			
			textBaseTriangulo = new JTextField();
			textBaseTriangulo.setColumns(10);
			textBaseTriangulo.setBounds(107, 38, 561, 20);
			pnlTriangulo.add(textBaseTriangulo);
			
			textAlturaTriangulo = new JTextField();
			textAlturaTriangulo.setColumns(10);
			textAlturaTriangulo.setBounds(107, 77, 561, 20);
			pnlTriangulo.add(textAlturaTriangulo);
			
			JLabel lblVerticeY_1 = new JLabel("Altura:");
			lblVerticeY_1.setBounds(10, 80, 81, 14);
			pnlTriangulo.add(lblVerticeY_1);
			
			JButton btnCrear = new JButton("Crear");
			btnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Prisma aux = new Triangulo(Float.parseFloat(textBaseTriangulo.getText()),Float.parseFloat(textAlturaTriangulo.getText()));
					GestionFigura.getInstance().CrearPrisma(aux);
					Prisma3d dialog = new Prisma3d();
					dialog.setVisible(true);
				}
			});
			btnCrear.setBounds(685, 198, 97, 23);
			pnlTriangulo.add(btnCrear);
			
			pnlRombo = new JPanel();
			pnlRombo.setBorder(new TitledBorder(null, "Rombo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlRombo.setBounds(12, 422, 809, 232);
			panel.add(pnlRombo);
			pnlRombo.setLayout(null);
			
			JLabel lblVereticeX = new JLabel("Vertice X");
			lblVereticeX.setBounds(10, 41, 81, 14);
			pnlRombo.add(lblVereticeX);
			
			JLabel lblVerticeY = new JLabel("Vertice Y:");
			lblVerticeY.setBounds(10, 80, 81, 14);
			pnlRombo.add(lblVerticeY);
			
			JLabel lblVerticeZ = new JLabel("Vertice Z:");
			lblVerticeZ.setBounds(10, 110, 81, 14);
			pnlRombo.add(lblVerticeZ);
			
			JLabel lblVerticeR = new JLabel("Vertice R:");
			lblVerticeR.setBounds(10, 130, 81, 14);
			pnlRombo.add(lblVerticeR);
			
			textField_9 = new JTextField();
			textField_9.setBounds(107, 38, 221, 20);
			textField_9.setColumns(10);
			pnlRombo.add(textField_9);
			
			textField_10 = new JTextField();
			textField_10.setBounds(107, 77, 221, 20);
			textField_10.setColumns(10);
			pnlRombo.add(textField_10);
			
			textField_11 = new JTextField();
			textField_11.setBounds(107, 104, 221, 20);
			textField_11.setColumns(10);
			pnlRombo.add(textField_11);
			
			textField_12 = new JTextField();
			textField_12.setBounds(107, 130, 221, 20);
			textField_12.setColumns(10);
			pnlRombo.add(textField_12);
			
			JButton btnRegistrar = new JButton("Crear");
			btnRegistrar.setBounds(685, 198, 97, 23);
			pnlRombo.add(btnRegistrar);
			
			JLabel lblNewLabel_13 = new JLabel("");
			lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\ronal\\Downloads\\Prisma-Logo-1 (1).png"));
			lblNewLabel_13.setBounds(277, 38, 283, 88);
			panel.add(lblNewLabel_13);
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
		pnlCuadrado.setLayout(null);
		pnlRombo.setVisible(false);
		pnlTriangulo.setVisible(false);
		pnlRectangulo.setVisible(false);
		pnlTrapecio.setVisible(false);
		
		if(GestionFigura.getLoginUser().getTipo().equalsIgnoreCase("Profesor")) {
			panelEstudiante.setVisible(false);
			panelProfesor.setVisible(true);
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
