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
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class RegistroUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JRadioButton rdbProfesor;
	private JRadioButton rdbEstudiante;
	private String tipo;
	private JPasswordField textContra;
	private JPasswordField textContraConfirm;
	private JPanel panelExit;
	private JLabel xExit;
	private JLabel lblEstudiante;
	private JLabel lblProfesor;
	private JLabel lblNewLabel_1;

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
		setUndecorated(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroUsuario.class.getResource("/imagenes/registros-medicos.png")));
		setBounds(100, 100, 513, 377);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLUE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(21, 42, 471, 292);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(textUsuario.getText().equals("Ingrese el nombre de usuario")) {
					textUsuario.setText("");
					textUsuario.setForeground(Color.BLACK);
				}
				if(textContra.getText().isEmpty()) {
					textContra.setText("********");
					textContra.setForeground(Color.GRAY);
				}
				if(textContraConfirm.getText().isEmpty()) {
					textContraConfirm.setText("********");
					textContraConfirm.setForeground(Color.GRAY);
				}
			}
		});
		textUsuario.setForeground(Color.GRAY);
		textUsuario.setText("Ingrese el nombre de usuario");
		textUsuario.setBorder(null);
		textUsuario.setBounds(137, 52, 187, 27);
		panel.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(137, 23, 56, 16);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(137, 92, 69, 16);
		panel.add(lblPassword);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword_1.setBounds(137, 161, 69, 16);
		panel.add(lblPassword_1);
		
		rdbEstudiante = new JRadioButton("Estudiante");
		rdbEstudiante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rdbEstudiante.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rdbEstudiante.setForeground(Color.GRAY);
			}
		});
		rdbEstudiante.setForeground(Color.LIGHT_GRAY);
		rdbEstudiante.setBackground(Color.WHITE);
		rdbEstudiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbProfesor.setSelected(false);
				tipo = "Estudiante";
				lblEstudiante.setVisible(true);
				lblProfesor.setVisible(false);
				
			}
		});
		rdbEstudiante.setBounds(22, 241, 127, 25);
		panel.add(rdbEstudiante);
		
		rdbProfesor = new JRadioButton("Profesor");
		rdbProfesor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rdbProfesor.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rdbProfesor.setForeground(Color.GRAY);
			}
		});
		rdbProfesor.setForeground(Color.LIGHT_GRAY);
		rdbProfesor.setBackground(Color.WHITE);
		rdbProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbEstudiante.setSelected(false);
				tipo = "Profesor";
				lblEstudiante.setVisible(false);
				lblProfesor.setVisible(true);
			}
		});
		rdbProfesor.setBounds(336, 241, 127, 25);
		panel.add(rdbProfesor);
		
		textContra = new JPasswordField();
		textContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(textUsuario.getText().isEmpty()) {
					textUsuario.setText("Ingrese el nombre de usuario");
					textUsuario.setForeground(Color.GRAY);
				}
				if(textContra.getText().equals("********")) {
					textContra.setText("");
					textContra.setForeground(Color.BLACK);
				}
				if(textContraConfirm.getText().isEmpty()) {
					textContraConfirm.setText("********");
					textContraConfirm.setForeground(Color.GRAY);
				}
			}
		});
		textContra.setForeground(Color.GRAY);
		textContra.setText("********");
		textContra.setBorder(null);
		textContra.setBounds(137, 121, 187, 27);
		panel.add(textContra);
		
		textContraConfirm = new JPasswordField();
		textContraConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(textUsuario.getText().isEmpty()) {
					textUsuario.setText("Ingrese el nombre de usuario");
					textUsuario.setForeground(Color.BLACK);
				}
				if(textContra.getText().isEmpty()) {
					textContra.setText("********");
					textContra.setForeground(Color.GRAY);
				}
				if(textContraConfirm.getText().equals("********")) {
					textContraConfirm.setText("");
					textContraConfirm.setForeground(Color.BLACK);
				}
			}
		});
		textContraConfirm.setForeground(Color.GRAY);
		textContraConfirm.setText("********");
		textContraConfirm.setBorder(null);
		textContraConfirm.setBounds(137, 190, 187, 27);
		panel.add(textContraConfirm);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(137, 81, 203, 10);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(137, 153, 203, 10);
		panel.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(137, 222, 203, 10);
		panel.add(separator_2);
		{
			JButton okButton = new JButton("");
			okButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					okButton.setBackground(Color.LIGHT_GRAY);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					okButton.setBackground(Color.WHITE);
				}
			});
			okButton.setBorder(null);
			okButton.setBackground(Color.WHITE);
			okButton.setBounds(211, 243, 49, 36);
			panel.add(okButton);
			okButton.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/imagenes/guardar-el-archivo (1).png")));
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
			getRootPane().setDefaultButton(okButton);
		}
		
		lblEstudiante = new JLabel("");
		lblEstudiante.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/imagenes/leer (1).png")));
		lblEstudiante.setBounds(22, 26, 98, 95);
		panel.add(lblEstudiante);
		
		lblProfesor = new JLabel("");
		lblProfesor.setIcon(new ImageIcon(RegistroUsuario.class.getResource("/imagenes/profesor (1).png")));
		lblProfesor.setBounds(27, 26, 98, 82);
		panel.add(lblProfesor);
		lblEstudiante.setVisible(false);
		lblProfesor.setVisible(false);
		
		panelExit = new JPanel();
		panelExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelExit.setBackground(Color.RED);
				xExit.setForeground(Color.BLACK);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelExit.setBackground(Color.BLUE);
				xExit.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panelExit.setBackground(Color.BLUE);
		panelExit.setBounds(482, 0, 31, 30);
		contentPanel.add(panelExit);
		
		xExit = new JLabel("X");
		xExit.setForeground(Color.WHITE);
		xExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelExit.add(xExit);
		
		lblNewLabel_1 = new JLabel("Registro");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(203, 13, 107, 29);
		contentPanel.add(lblNewLabel_1);
	}
}
