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
import javax.swing.UIManager;
import javax.swing.JSeparator;

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
	private JTextField textCodigo;
	private JLabel lblNewLabel_9;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel lblNewLabel_10;
	private JLabel label;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearPrisma.class.getResource("/imagenes/prisma.png")));
		setBounds(100, 100, 866, 759);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(null);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				pnlCuadrado = new JPanel();
				pnlCuadrado.setBackground(Color.YELLOW);
				pnlCuadrado.setBorder(null);
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
				
				JButton btnCrearCuadrado = new JButton("");
				btnCrearCuadrado.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						btnCrearCuadrado.setBackground(Color.ORANGE);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						btnCrearCuadrado.setBackground(Color.YELLOW);
					}
				});
				btnCrearCuadrado.setBorder(null);
				btnCrearCuadrado.setBackground(Color.YELLOW);
				btnCrearCuadrado.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/agregar.png")));
				btnCrearCuadrado.addActionListener(new ActionListener() {
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
								
							Prisma aux = new Cuadrado(ancho,altura,profundidad,color,textCodigo.getText());
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
				btnCrearCuadrado.setBounds(717, 188, 52, 33);
				pnlCuadrado.add(btnCrearCuadrado);
				
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
				panelEstudiante.setBackground(Color.BLUE);
				panelEstudiante.setBorder(new LineBorder(new Color(0, 0, 0)));
				panelEstudiante.setBounds(12, 158, 809, 180);
				panel.add(panelEstudiante);
				panelEstudiante.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Nombre:");
					lblNewLabel.setForeground(Color.WHITE);
					lblNewLabel.setBounds(43, 69, 70, 16);
					panelEstudiante.add(lblNewLabel);
				}
				{
					textNombreEstudiante = new JTextField();
					textNombreEstudiante.setBackground(Color.BLUE);
					textNombreEstudiante.setBorder(null);
					textNombreEstudiante.setBounds(125, 66, 241, 22);
					panelEstudiante.add(textNombreEstudiante);
					textNombreEstudiante.setColumns(10);
				}
				{
					textApellidoEstudiante = new JTextField();
					textApellidoEstudiante.setBackground(Color.BLUE);
					textApellidoEstudiante.setBorder(null);
					textApellidoEstudiante.setBounds(125, 114, 241, 22);
					panelEstudiante.add(textApellidoEstudiante);
					textApellidoEstudiante.setColumns(10);
				}
				{
					textEdadEstudiante = new JTextField();
					textEdadEstudiante.setBackground(Color.BLUE);
					textEdadEstudiante.setBorder(null);
					textEdadEstudiante.setColumns(10);
					textEdadEstudiante.setBounds(539, 66, 170, 22);
					panelEstudiante.add(textEdadEstudiante);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Apellido:");
					lblNewLabel_1.setForeground(Color.WHITE);
					lblNewLabel_1.setBounds(43, 114, 56, 16);
					panelEstudiante.add(lblNewLabel_1);
				}
				{
					JLabel lblEdad = new JLabel("Edad:");
					lblEdad.setForeground(Color.WHITE);
					lblEdad.setBounds(471, 69, 56, 16);
					panelEstudiante.add(lblEdad);
				}
				{
					textMatricula = new JTextField();
					textMatricula.setBackground(Color.BLUE);
					textMatricula.setBorder(null);
					textMatricula.setBounds(125, 10, 241, 22);
					panelEstudiante.add(textMatricula);
					textMatricula.setColumns(10);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Matricula:");
					lblNewLabel_2.setForeground(Color.WHITE);
					lblNewLabel_2.setBounds(39, 13, 70, 16);
					panelEstudiante.add(lblNewLabel_2);
				}
				{
					btnRegistrarEstudiante = new JButton("");
					btnRegistrarEstudiante.setBorder(null);
					btnRegistrarEstudiante.setBackground(Color.BLUE);
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
						
						@Override
						public void mouseEntered(MouseEvent e) {
							btnRegistrarEstudiante.setBackground(Color.CYAN);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							btnRegistrarEstudiante.setBackground(Color.BLUE);
						}
					});
					btnRegistrarEstudiante.setBounds(685, 101, 78, 66);
					panelEstudiante.add(btnRegistrarEstudiante);
				}
				{
					JButton btnBuscarEstudiante = new JButton("");
					btnBuscarEstudiante.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							btnBuscarEstudiante.setBackground(Color.cyan);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							btnBuscarEstudiante.setBackground(Color.BLUE);
						}
					});
					btnBuscarEstudiante.setBorder(null);
					btnBuscarEstudiante.setBackground(Color.BLUE);
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
				
				separator = new JSeparator();
				separator.setBounds(125, 33, 241, 2);
				panelEstudiante.add(separator);
				
				separator_1 = new JSeparator();
				separator_1.setBounds(125, 89, 241, 2);
				panelEstudiante.add(separator_1);
				
				separator_2 = new JSeparator();
				separator_2.setBounds(125, 137, 241, 2);
				panelEstudiante.add(separator_2);
				
				separator_3 = new JSeparator();
				separator_3.setBounds(539, 89, 241, 2);
				panelEstudiante.add(separator_3);
			}
			
			panelProfesor = new JPanel();
			panelProfesor.setBackground(Color.BLUE);
			panelProfesor.setLayout(null);
			panelProfesor.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelProfesor.setBounds(12, 158, 809, 180);
			panel.add(panelProfesor);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setBounds(43, 69, 70, 16);
			panelProfesor.add(lblNombre);
			
			separator_4 = new JSeparator();
			separator_4.setBounds(125, 33, 241, 2);
			panelProfesor.add(separator_4);
			
			separator_5 = new JSeparator();
			separator_5.setBounds(125, 89, 241, 2);
			panelProfesor.add(separator_5);
			
			separator_6 = new JSeparator();
			separator_6.setBounds(125, 137, 241, 2);
			panelProfesor.add(separator_6);
			
			separator_7 = new JSeparator();
			separator_7.setBounds(539, 89, 241, 2);
			panelProfesor.add(separator_7);
			
			textNombreProfesor = new JTextField();
			textNombreProfesor.setBorder(null);
			textNombreProfesor.setBackground(Color.BLUE);
			textNombreProfesor.setColumns(10);
			textNombreProfesor.setBounds(125, 66, 241, 22);
			panelProfesor.add(textNombreProfesor);
			
			textApellidoProfesor = new JTextField();
			textApellidoProfesor.setBorder(null);
			textApellidoProfesor.setBackground(Color.BLUE);
			textApellidoProfesor.setColumns(10);
			textApellidoProfesor.setBounds(125, 114, 241, 22);
			panelProfesor.add(textApellidoProfesor);
			
			textEdadProfesor = new JTextField();
			textEdadProfesor.setBorder(null);
			textEdadProfesor.setBackground(Color.BLUE);
			textEdadProfesor.setColumns(10);
			textEdadProfesor.setBounds(539, 66, 170, 22);
			panelProfesor.add(textEdadProfesor);
			
			JLabel label_1 = new JLabel("Apellido:");
			label_1.setForeground(Color.WHITE);
			label_1.setBounds(43, 114, 56, 16);
			panelProfesor.add(label_1);
			
			JLabel label_2 = new JLabel("Edad:");
			label_2.setForeground(Color.WHITE);
			label_2.setBounds(471, 69, 56, 16);
			panelProfesor.add(label_2);
			
			textCedula = new JTextField();
			textCedula.setBorder(null);
			textCedula.setBackground(Color.BLUE);
			textCedula.setColumns(10);
			textCedula.setBounds(125, 10, 241, 22);
			panelProfesor.add(textCedula);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setForeground(Color.WHITE);
			lblCedula.setBounds(39, 13, 70, 16);
			panelProfesor.add(lblCedula);
			
			JButton btnRegistrarProfesor = new JButton("");   //Se necesita agregar algo en el campo prismas, no se que meter ahi
			btnRegistrarProfesor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnRegistrarProfesor.setBackground(Color.CYAN);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnRegistrarProfesor.setBackground(Color.BLUE);
				}
			});
			btnRegistrarProfesor.setBorder(null);
			btnRegistrarProfesor.setBackground(Color.BLUE);
			btnRegistrarProfesor.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/guardar-el-archivo.png")));
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
			btnRegistrarProfesor.setBounds(685, 101, 78, 66);
			panelProfesor.add(btnRegistrarProfesor);
			
			JButton btnBuscarProfesor = new JButton("");
			btnBuscarProfesor.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnBuscarProfesor.setBackground(Color.CYAN);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnBuscarProfesor.setBackground(Color.BLUE);
				}
			});
			btnBuscarProfesor.setBorder(null);
			btnBuscarProfesor.setBackground(Color.BLUE);
			btnBuscarProfesor.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/buscar (1).png")));
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
			btnBuscarProfesor.setBounds(590, 101, 70, 66);
			panelProfesor.add(btnBuscarProfesor);
			
			rdbtnCuadrado = new JRadioButton("Cuadrado");
			rdbtnCuadrado.setBackground(Color.WHITE);
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
					textCodigo.setText("CD-"+ GestionFigura.getNumeroPrisma());
					
					
					
					
				}
			});
			
			
			rdbtnCuadrado.setBounds(33, 362, 127, 25);
			panel.add(rdbtnCuadrado);
			
			rdbtnRectangulo = new JRadioButton("Rectangulo");
			rdbtnRectangulo.setBackground(Color.WHITE);
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
					textCodigo.setText("REC-"+ GestionFigura.getNumeroPrisma());
					
					
				}
			});
			rdbtnRectangulo.setBounds(197, 362, 127, 25);
			panel.add(rdbtnRectangulo);
			
			rdbtnTrapecio = new JRadioButton("Esfera");
			rdbtnTrapecio.setBackground(Color.WHITE);
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
					textCodigo.setText("ESF-"+ GestionFigura.getNumeroPrisma());
					
				}
			});
			rdbtnTrapecio.setBounds(359, 362, 127, 25);
			panel.add(rdbtnTrapecio);
			
			rdbtnRombo = new JRadioButton("Cilindro");
			rdbtnRombo.setBackground(Color.WHITE);
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
					textCodigo.setText("CL-"+ GestionFigura.getNumeroPrisma());
					
					
				}
			});
			rdbtnRombo.setBounds(521, 362, 127, 25);
			panel.add(rdbtnRombo);
			
			rdbtnTriangulo = new JRadioButton("Triangulo");
			rdbtnTriangulo.setBackground(Color.WHITE);
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
					textCodigo.setText("TR-"+ GestionFigura.getNumeroPrisma());
					
				}
			});
			rdbtnTriangulo.setBounds(683, 362, 127, 25);
			panel.add(rdbtnTriangulo);
			
			pnlRectangulo = new JPanel();
			pnlRectangulo.setBackground(Color.YELLOW);
			pnlRectangulo.setBorder(null);
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
			
			label = new JLabel("");
			label.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/prisma (4).png")));
			label.setBounds(710, 35, 87, 106);
			pnlRectangulo.add(label);
			
			textAlturaRectangulo = new JTextField();
			textAlturaRectangulo.setBounds(107, 77, 561, 20);
			pnlRectangulo.add(textAlturaRectangulo);
			textAlturaRectangulo.setColumns(10);
			
			JButton btnCrearRectangulo = new JButton("");
			btnCrearRectangulo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnCrearRectangulo.setBackground(Color.ORANGE);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnCrearRectangulo.setBackground(Color.YELLOW);
				}
			});
			btnCrearRectangulo.setBorder(null);
			btnCrearRectangulo.setBackground(Color.YELLOW);
			btnCrearRectangulo.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/agregar.png")));
			btnCrearRectangulo.addActionListener(new ActionListener() {
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
					Prisma aux2 = new Rectangulo(ancho,altura,profundidad,color,textCodigo.getText());
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
			btnCrearRectangulo.setBounds(717, 188, 52, 33);
			pnlRectangulo.add(btnCrearRectangulo);
			
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
			pnlEsfera.setBackground(Color.YELLOW);
			pnlEsfera.setBorder(null);
			pnlEsfera.setBounds(12, 422, 809, 232);
			panel.add(pnlEsfera);
			pnlEsfera.setLayout(null);
			
			JLabel lblNewLabel_6 = new JLabel("Tama\u00F1o:");
			lblNewLabel_6.setSize(81, 14);
			lblNewLabel_6.setLocation(10, 41);
			pnlEsfera.add(lblNewLabel_6);
			
			label_3 = new JLabel("");
			label_3.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/esfera.png")));
			label_3.setBounds(710, 35, 87, 106);
			pnlEsfera.add(label_3);
			
			textEsfera = new JTextField();
			textEsfera.setBounds(107, 38, 561, 20);
			pnlEsfera.add(textEsfera);
			textEsfera.setColumns(10);
			
			JButton btnCrearEsfera = new JButton("");
			btnCrearEsfera.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnCrearEsfera.setBackground(Color.ORANGE);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnCrearEsfera.setBackground(Color.YELLOW);
				}
			});
			btnCrearEsfera.setBorder(null);
			btnCrearEsfera.setBackground(Color.YELLOW);
			btnCrearEsfera.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/agregar.png")));
			btnCrearEsfera.addActionListener(new ActionListener() {
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
					Prisma aux = new Esfera(Float.parseFloat(textEsfera.getText()),color,textCodigo.getText());
					GestionFigura.getInstance().CrearPrisma(aux);
					ArrayList<Prisma> prismasUser = new ArrayList<Prisma>(100);
					prismasUser.add(aux);
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
			btnCrearEsfera.setBounds(717, 188, 52, 33);
			pnlEsfera.add(btnCrearEsfera);
			
			pnlTriangulo = new JPanel();
			pnlTriangulo.setBackground(Color.YELLOW);
			pnlTriangulo.setBorder(null);
			pnlTriangulo.setLayout(null);
			pnlTriangulo.setBounds(12, 422, 809, 232);
			panel.add(pnlTriangulo);
			
			JLabel lblBase = new JLabel("Base:");
			lblBase.setBounds(10, 41, 81, 14);
			pnlTriangulo.add(lblBase);
			
			label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/cono.png")));
			label_4.setBounds(710, 35, 87, 106);
			pnlTriangulo.add(label_4);
			
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
			
			JButton btnCrearTriangulo = new JButton("");
			btnCrearTriangulo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnCrearTriangulo.setBackground(Color.ORANGE);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnCrearTriangulo.setBackground(Color.YELLOW);
				}
			});
			btnCrearTriangulo.setBorder(null);
			btnCrearTriangulo.setBackground(Color.YELLOW);
			btnCrearTriangulo.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/agregar.png")));
			btnCrearTriangulo.addActionListener(new ActionListener() {
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
					Prisma aux = new Triangulo(Float.parseFloat(textBaseTriangulo.getText()),Float.parseFloat(textAlturaTriangulo.getText()),color,textCodigo.getText());
					GestionFigura.getInstance().CrearPrisma(aux);
					Prisma3d dialog = new Prisma3d();
					dialog.setVisible(true);
				}
			});
			btnCrearTriangulo.setBounds(717, 188, 52, 33);
			pnlTriangulo.add(btnCrearTriangulo);
			
			pnlCilindro = new JPanel();
			pnlCilindro.setBackground(Color.YELLOW);
			pnlCilindro.setBorder(null);
			pnlCilindro.setBounds(12, 422, 809, 232);
			panel.add(pnlCilindro);
			pnlCilindro.setLayout(null);
			
			JLabel lblVereticeX = new JLabel("Ancho:");
			lblVereticeX.setBounds(10, 41, 81, 14);
			pnlCilindro.add(lblVereticeX);
			
			JLabel lblVerticeY = new JLabel("Altura:");
			lblVerticeY.setBounds(10, 80, 81, 14);
			pnlCilindro.add(lblVerticeY);
			
			label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/cilindro.png")));
			label_5.setBounds(710, 35, 87, 106);
			pnlCilindro.add(label_5);
			
			textAnchoCilindro = new JTextField();
			textAnchoCilindro.setBounds(107, 38, 561, 20);
			textAnchoCilindro.setColumns(10);
			pnlCilindro.add(textAnchoCilindro);
			
			textAlturaCilindro = new JTextField();
			textAlturaCilindro.setBounds(107, 77, 561, 20);
			textAlturaCilindro.setColumns(10);
			pnlCilindro.add(textAlturaCilindro);
			
			JButton btnCrearCilindro = new JButton("");
			btnCrearCilindro.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnCrearCilindro.setBackground(Color.ORANGE);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					btnCrearCilindro.setBackground(Color.YELLOW);
				}
			});
			btnCrearCilindro.setBorder(null);
			btnCrearCilindro.setBackground(Color.YELLOW);
			btnCrearCilindro.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/agregar.png")));
			btnCrearCilindro.addActionListener(new ActionListener() {
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
					Prisma aux = new Cilindro(Float.parseFloat(textAnchoCilindro.getText()),Float.parseFloat(textAlturaCilindro.getText()),color,textCodigo.getText());
					GestionFigura.getInstance().CrearPrisma(aux);
					ArrayList<Prisma> prismasUser = new ArrayList<Prisma>(100);
					prismasUser.add(aux);
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
			btnCrearCilindro.setBounds(717, 188, 52, 33);
			pnlCilindro.add(btnCrearCilindro);
			
			JLabel lblNewLabel_13 = new JLabel("");
			lblNewLabel_13.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/prisma (3).png")));
			lblNewLabel_13.setBounds(159, 13, 152, 128);
			panel.add(lblNewLabel_13);
			
			textCodigo = new JTextField();
			textCodigo.setBounds(680, 396, 116, 22);
			panel.add(textCodigo);
			textCodigo.setEditable(false);
			textCodigo.setColumns(10);
			JButton cancelButton = new JButton("");
			cancelButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					cancelButton.setBackground(Color.LIGHT_GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					cancelButton.setBackground(Color.WHITE);
				}
			});
			cancelButton.setBackground(Color.WHITE);
			cancelButton.setBorder(null);
			cancelButton.setBounds(764, 656, 74, 46);
			panel.add(cancelButton);
			cancelButton.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/flecha-hacia-atras (2).png")));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
			
			btnColor = new JButton("Rojo");
			btnColor.setBounds(359, 664, 131, 25);
			panel.add(btnColor);
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
			
			lblNewLabel_9 = new JLabel("CREACION DE PRISMA");
			lblNewLabel_9.setFont(new Font("Trebuchet MS", Font.BOLD, 34));
			lblNewLabel_9.setBounds(303, 39, 361, 76);
			panel.add(lblNewLabel_9);
		}
		pnlCuadrado.setLayout(null);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(CrearPrisma.class.getResource("/imagenes/cubo.png")));
		lblNewLabel_10.setBounds(710, 35, 87, 106);
		pnlCuadrado.add(lblNewLabel_10);
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
