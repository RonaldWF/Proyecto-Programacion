package visual;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cilindro;
import logico.Cuadrado;
import logico.Esfera;
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
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;

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
	private JTextField textEsfera;
	private JTextField textAnchoCilindro;
	private JTextField textAlturaCilindro;
	private JTextField textBaseTriangulo;
	private JTextField textAlturaTriangulo;
	private JTextField textProfundidadRectangulo;
	private JRadioButton rdbtnTriangulo;
	private JPanel pnlRectangulo;
	private JPanel pnlCilindro;
	private JPanel pnlTriangulo;
	private JPanel pnlEsfera;
	private JPanel pnlCuadrado;
	private int hola=5000;
	private JTextField textProfundidadCuadrado;
	private JButton btnColor;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearPrisma.class.getResource("/imagenes/prisma.png")));
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
				
				JButton btnNewButton_1 = new JButton("");
				btnNewButton_1.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/agregar.png")));
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
								int color = 1;
								if(btnColor.getBackground() == Color.RED) {
									color = 1;
								}
								if(btnColor.getBackground() == Color.BLUE) {
									color = 2;
								}
								if(btnColor.getBackground() == Color.GREEN) {
									color = 3;
								}
								if(btnColor.getBackground() == Color.YELLOW) {
									color = 4;
								}
								if(btnColor.getBackground() == Color.WHITE) {
									color = 5;
								}
								
							Prisma aux = new Cuadrado(ancho,altura,profundidad,color);
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
				btnNewButton_1.setBounds(685, 188, 97, 33);
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
					btnRegistrarEstudiante = new JButton("");
					btnRegistrarEstudiante.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/guardar-el-archivo.png")));
					btnRegistrarEstudiante.setEnabled(false);
					btnRegistrarEstudiante.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(!textMatricula.getText().equalsIgnoreCase("") && !textNombreEstudiante.getText().equalsIgnoreCase("") && !textApellidoEstudiante.getText().equalsIgnoreCase("")
									&& !textEdadEstudiante.getText().equalsIgnoreCase("")) {
							int edad = Integer.parseInt(textEdadEstudiante.getText());
							boolean estado = true;
							Usuario est = new Estudiante(textNombreEstudiante.getText(),textApellidoEstudiante.getText(),edad,textMatricula.getText(),estado);
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
					btnRegistrarEstudiante.setBounds(685, 101, 78, 66);
					panelEstudiante.add(btnRegistrarEstudiante);
				}
				{
					JButton btnBuscarEstudiante = new JButton("");
					btnBuscarEstudiante.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/buscar (1).png")));
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
					btnBuscarEstudiante.setBounds(590, 101, 70, 66);
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
					boolean estado = true;
					Usuario pro = new Profesor(textNombreProfesor.getText(), textApellidoProfesor.getText(), edad, textCedula.getText(),estado);
					GestionFigura.getInstance().RegistrarProfesor(pro);
					//GestionFigura.getInstance().RegistrarProfesorDisp(pro);
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
					pnlCilindro.setVisible(false);
					pnlEsfera.setVisible(false);
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
					pnlCilindro.setVisible(false);
					pnlEsfera.setVisible(false);
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
					pnlCilindro.setVisible(false);
					pnlEsfera.setVisible(true);
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
					pnlCilindro.setVisible(true);
					pnlEsfera.setVisible(false);
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
					pnlCilindro.setVisible(false);
					pnlEsfera.setVisible(false);
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
					int color = 1;
					if(btnColor.getBackground() == Color.RED) {
						color = 1;
					}
					if(btnColor.getBackground() == Color.BLUE) {
						color = 2;
					}
					if(btnColor.getBackground() == Color.GREEN) {
						color = 3;
					}
					if(btnColor.getBackground() == Color.YELLOW) {
						color = 4;
					}
					if(btnColor.getBackground() == Color.WHITE) {
						color = 5;
					}
					float ancho =  Float.parseFloat(textAnchoRectangulo.getText());
					float altura = Float.parseFloat(textAlturaRectangulo.getText());
					float profundidad = Float.parseFloat(textProfundidadRectangulo.getText());
					Prisma aux2 = new Rectangulo(ancho,altura,profundidad,color);
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
			
			pnlEsfera = new JPanel();
			pnlEsfera.setBorder(new TitledBorder(null, "Trapecio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlEsfera.setBounds(12, 422, 809, 232);
			panel.add(pnlEsfera);
			pnlEsfera.setLayout(null);
			
			JLabel lblNewLabel_6 = new JLabel("Tama\u00F1o:");
			lblNewLabel_6.setSize(81, 14);
			lblNewLabel_6.setLocation(10, 41);
			pnlEsfera.add(lblNewLabel_6);
			
			textEsfera = new JTextField();
			textEsfera.setBounds(107, 38, 561, 20);
			pnlEsfera.add(textEsfera);
			textEsfera.setColumns(10);
			
			JButton btnNewButton_5 = new JButton("Crear");
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int color = 1;
					if(btnColor.getBackground() == Color.RED) {
						color = 1;
					}
					if(btnColor.getBackground() == Color.BLUE) {
						color = 2;
					}
					if(btnColor.getBackground() == Color.GREEN) {
						color = 3;
					}
					if(btnColor.getBackground() == Color.YELLOW) {
						color = 4;
					}
					if(btnColor.getBackground() == Color.WHITE) {
						color = 5;
					}
					Prisma aux = new Esfera(Float.parseFloat(textEsfera.getText()),color);
					GestionFigura.getInstance().CrearPrisma(aux);
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
			});
			btnNewButton_5.setBounds(685, 198, 97, 23);
			pnlEsfera.add(btnNewButton_5);
			
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
					int color = 1;
					if(btnColor.getBackground() == Color.RED) {
						color = 1;
					}
					if(btnColor.getBackground() == Color.BLUE) {
						color = 2;
					}
					if(btnColor.getBackground() == Color.GREEN) {
						color = 3;
					}
					if(btnColor.getBackground() == Color.YELLOW) {
						color = 4;
					}
					if(btnColor.getBackground() == Color.WHITE) {
						color = 5;
					}
					Prisma aux = new Triangulo(Float.parseFloat(textBaseTriangulo.getText()),Float.parseFloat(textAlturaTriangulo.getText()),color);
					GestionFigura.getInstance().CrearPrisma(aux);
					Prisma3d dialog = new Prisma3d();
					dialog.setVisible(true);
				}
			});
			btnCrear.setBounds(685, 198, 97, 23);
			pnlTriangulo.add(btnCrear);
			
			pnlCilindro = new JPanel();
			pnlCilindro.setBorder(new TitledBorder(null, "Rombo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnlCilindro.setBounds(12, 422, 809, 232);
			panel.add(pnlCilindro);
			pnlCilindro.setLayout(null);
			
			JLabel lblVereticeX = new JLabel("Ancho:");
			lblVereticeX.setBounds(10, 41, 81, 14);
			pnlCilindro.add(lblVereticeX);
			
			JLabel lblVerticeY = new JLabel("Altura:");
			lblVerticeY.setBounds(10, 80, 81, 14);
			pnlCilindro.add(lblVerticeY);
			
			textAnchoCilindro = new JTextField();
			textAnchoCilindro.setBounds(107, 38, 561, 20);
			textAnchoCilindro.setColumns(10);
			pnlCilindro.add(textAnchoCilindro);
			
			textAlturaCilindro = new JTextField();
			textAlturaCilindro.setBounds(107, 77, 561, 20);
			textAlturaCilindro.setColumns(10);
			pnlCilindro.add(textAlturaCilindro);
			
			JButton btnRegistrar = new JButton("Crear");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int color = 1;
					if(btnColor.getBackground() == Color.RED) {
						color = 1;
					}
					if(btnColor.getBackground() == Color.BLUE) {
						color = 2;
					}
					if(btnColor.getBackground() == Color.GREEN) {
						color = 3;
					}
					if(btnColor.getBackground() == Color.YELLOW) {
						color = 4;
					}
					if(btnColor.getBackground() == Color.WHITE) {
						color = 5;
					}
					Prisma aux = new Cilindro(Float.parseFloat(textAnchoCilindro.getText()),Float.parseFloat(textAlturaCilindro.getText()),color);
					GestionFigura.getInstance().CrearPrisma(aux);
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
			});
			btnRegistrar.setBounds(685, 198, 97, 23);
			pnlCilindro.add(btnRegistrar);
			
			JLabel lblNewLabel_13 = new JLabel("");
			lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\ronal\\Downloads\\Prisma-Logo-1 (1).png"));
			lblNewLabel_13.setBounds(277, 38, 283, 88);
			panel.add(lblNewLabel_13);
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				buttonPane.setBounds(-19, 667, 877, 46);
				panel.add(buttonPane);
				{
					JButton cancelButton = new JButton("");
					cancelButton.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/flecha-hacia-atras (2).png")));
					cancelButton.setBounds(780, 5, 74, 33);
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					buttonPane.setLayout(null);
					
					btnColor = new JButton("Rojo");
					btnColor.setBounds(357, 5, 131, 25);
					buttonPane.add(btnColor);
					btnColor.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(btnColor.getBackground()== Color.RED) {
							btnColor.setBackground(Color.BLUE);
							btnColor.setText("Azul");
							}
							else if(btnColor.getBackground() == Color.BLUE) {
								btnColor.setBackground(Color.GREEN);
								btnColor.setText("Verde");
							}
							else if(btnColor.getBackground() == Color.GREEN) {
								btnColor.setBackground(Color.YELLOW);
								btnColor.setText("Amarillo");
							}
							else if(btnColor.getBackground() == Color.YELLOW) {
								btnColor.setBackground(Color.WHITE);
								btnColor.setText("Blanco");
							}
							else if(btnColor.getBackground() == Color.WHITE) {
								btnColor.setBackground(Color.RED);
								btnColor.setText("Rojo");
							}
							
						}
					});
					btnColor.setBackground(Color.RED);
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
		}
		pnlCuadrado.setLayout(null);
		pnlCilindro.setVisible(false);
		pnlTriangulo.setVisible(false);
		pnlRectangulo.setVisible(false);
		pnlEsfera.setVisible(false);
		
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
