package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import logico.Estudiante;
import logico.GestionFigura;
import logico.Grupo;
import logico.Profesor;
import logico.Usuario;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrearGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultListModel<String> listModelDisp;
	private DefaultListModel<String> listModelGrupo;
	private ArrayList<String> pasarIzquierda;
	private JList listDisponible;
	private JList listGrupo;
	private JRadioButton rdbEstudiantes;
	private JRadioButton rdbProfesores;
	private String selectedIzquierda = "";
	private String selectedDerecha = "";
	private ArrayList<Profesor> profesoresGrupo;
	private Profesor profesorUnicoGrupo;
	private ArrayList<Estudiante> estudiantesGrupo;
	private JTextField textNumero;
	private int hola = 2;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearGrupo dialog = new CrearGrupo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearGrupo() {
		setBounds(100, 100, 827, 662);
		pasarIzquierda = new ArrayList<>();
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Creacion de Grupo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(34, 188, 731, 369);
			panel.add(panel_1);
			panel_1.setLayout(null);
			profesoresGrupo = new ArrayList<Profesor>(100);
			estudiantesGrupo = new ArrayList<Estudiante>(100);
			
			JButton btnNewButton = new JButton(">>");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listModelGrupo.addElement(selectedIzquierda);
					int o = listModelDisp.indexOf(selectedIzquierda);
					if(o >= 0) {
						 String aux = listModelDisp.get(o);
						int indiceChart = aux.indexOf("-");
						String substring = aux.substring(indiceChart);
						 if(GestionFigura.getInstance().ExisteEstudianteBymatricula(substring)== true){
					        Estudiante aux3 = GestionFigura.getInstance().BuscarEstudianteBymatricula(substring);
					        estudiantesGrupo.add(aux3);
					        aux3.setEstado(false);
						 }
						 else if(GestionFigura.getInstance().ExisteProfesorByCedula(substring)== true){
						        Profesor aux3 = GestionFigura.getInstance().BuscarProfesorByCedula(substring);
						        aux3.setEstado(false);
						        if(profesoresGrupo.size()<1) {
						        	profesoresGrupo.add(aux3);
						        	profesorUnicoGrupo = aux3;
						        	
						        }
						        else 
						        	JOptionPane.showMessageDialog(contentPanel, "Solo puede tener un profesor");
						        
							 } 
						listModelDisp.remove(o);
					}
				
				}
			});
			btnNewButton.setBounds(327, 150, 78, 25);
			panel_1.add(btnNewButton);
			
			JButton button = new JButton("<<");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listModelDisp.addElement(selectedDerecha);
					int o = listModelGrupo.indexOf(selectedDerecha);
					if (o >= 0) {
						String aux = listModelGrupo.get(o);
						int indiceChart = aux.indexOf("-");
						String substring = aux.substring(indiceChart);
						 if(GestionFigura.getInstance().ExisteEstudianteBymatricula(substring)== true){
					        Estudiante aux3 = GestionFigura.getInstance().BuscarEstudianteBymatricula(substring);
					        aux3.setEstado(true);
					        estudiantesGrupo.remove(aux3);
						 }
						 else if(GestionFigura.getInstance().ExisteProfesorByCedula(substring)== true){
						        Profesor aux3 = GestionFigura.getInstance().BuscarProfesorByCedula(substring);
						        aux3.setEstado(true);
						        profesoresGrupo.remove(aux3);
							 } 
						listModelGrupo.remove(o);
					}
				}
			});
			button.setBounds(327, 219, 78, 25);
			panel_1.add(button);
			
			rdbEstudiantes = new JRadioButton("Estudiantes");
			rdbEstudiantes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbProfesores.setSelected(false);
					listModelDisp.removeAllElements();
					pasarIzquierda = LoadEstudiantes();
					
				}
			});
			rdbEstudiantes.setBounds(45, 50, 127, 25);
			panel_1.add(rdbEstudiantes);
			
			rdbProfesores = new JRadioButton("Profesores");
			rdbProfesores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbEstudiantes.setSelected(false);
					listModelDisp.removeAllElements();
					pasarIzquierda = LoadProfesores();
				}
			});
			rdbProfesores.setBounds(176, 50, 127, 25);
			panel_1.add(rdbProfesores);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(57, 100, 246, 216);
			panel_1.add(scrollPane);
			
			listDisponible = new JList();
			listDisponible.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int i = listDisponible.getSelectedIndex();
					if(i != -1) {
						selectedIzquierda = (String)listDisponible.getModel().getElementAt(i);
					}
					
				}
			});
			listModelDisp = new DefaultListModel<>();
			listDisponible.setModel(listModelDisp);
			scrollPane.setViewportView(listDisponible);
			
			JLabel lblNewLabel = new JLabel("Disponibles:");
			scrollPane.setColumnHeaderView(lblNewLabel);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(427, 100, 246, 216);
			panel_1.add(scrollPane_1);
			
			listGrupo = new JList();
			listGrupo.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int i = listGrupo.getSelectedIndex();
					if(i != -1) {
						selectedDerecha = (String)listGrupo.getModel().getElementAt(i);
					}
					
				}
			});
			listModelGrupo = new DefaultListModel<>();
			listGrupo.setModel(listModelGrupo);
			scrollPane_1.setViewportView(listGrupo);
			
			JLabel lblNewLabel_1 = new JLabel("Grupo:");
			scrollPane_1.setColumnHeaderView(lblNewLabel_1);
			
			textNumero = new JTextField();
			textNumero.setEditable(false);
			textNumero.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textNumero.setBounds(337, 65, 56, 22);
			panel_1.add(textNumero);
			textNumero.setColumns(10);
			textNumero.setText("GR-"+String.valueOf(GestionFigura.getNumeroGrupo()));
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon("C:\\Users\\ronal\\Downloads\\material-Ucar7PHU-thumb.png"));
			label.setBounds(258, 0, 282, 188);
			panel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Grupo grupo = new Grupo(estudiantesGrupo,profesorUnicoGrupo,GestionFigura.getNumeroGrupo());
						GestionFigura.getInstance().CrearGrupo(grupo);
						textNumero.setText("GR-" + String.valueOf(GestionFigura.getNumeroGrupo()));
						JOptionPane.showMessageDialog(contentPanel, "Grupo Creado Exitosamente.");
						rdbEstudiantes.setSelected(true);
						rdbProfesores.setSelected(false);
						listModelDisp.removeAllElements();
						pasarIzquierda =  LoadEstudiantes();
						//pasarIzquierda = LoadProfesores();
						listModelGrupo.removeAllElements();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		pasarIzquierda = LoadEstudiantes();
	}
	private ArrayList<String> LoadEstudiantes() {
		ArrayList<String> aux1 = new ArrayList<>();
	for(int i = 0; i < GestionFigura.getInstance().getCantEstudiantes();i++) {
		if(GestionFigura.getInstance().getEstudiantes().get(i).isEstado() == true) {
		String aux = new String(GestionFigura.getInstance().getEstudiantes().get(i).getMatricula() + "-" + GestionFigura.getInstance().getEstudiantes().get(i).getNombre() );
		listModelDisp.addElement(aux);
		aux1.add(aux);
		}
	}
	return aux1;
	}
	private ArrayList<String> LoadProfesores() {
		ArrayList<String> aux1 = new ArrayList<>();
	for(int i = 0; i < GestionFigura.getInstance().getCantProfesores();i++) {
		if(GestionFigura.getInstance().getProfesores().get(i).isEstado() == true) {
		String aux = new String(GestionFigura.getInstance().getProfesores().get(i).getCedula()+ "-" + GestionFigura.getInstance().getProfesores().get(i).getNombre());
		listModelDisp.addElement(aux);
		aux1.add(aux);
		}
	}
	return aux1;
	}
}
