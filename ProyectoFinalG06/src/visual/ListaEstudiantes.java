package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Estudiante;
import logico.GestionFigura;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ListaEstudiantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];
	private JButton ModificarButton;
	private JButton EliminarButton;
	private Estudiante selected = null;
	private JTextField TextoApellido;
	private JTextField TextoMatricula;
	private JTextField TextoNombre;
	private JTextField TextoEdad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaEstudiantes dialog = new ListaEstudiantes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaEstudiantes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaEstudiantes.class.getResource("/imagenes/tarea-completada.png")));
		setBounds(100, 100, 548, 486); 
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(175, 0, 343, 381);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					{
						String headers[]= {"Matricula","Nombre","Apellido","Edad"};
					    model = new DefaultTableModel();
						model.setColumnIdentifiers(headers);
						table = new JTable();
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if(table.getSelectedRow()>-1) {
								int row = -1;
								row = table.getSelectedRow();
								if(row > -1) {
									
									ModificarButton.setEnabled(true);
									EliminarButton.setEnabled(true);
									selected = GestionFigura.getInstance().BuscarEstudianteBymatricula(table.getValueAt(row, 0).toString());
								}
							}}
								
						});
						table.setModel(model);
						scrollPane.setViewportView(table);
					}
					scrollPane.setViewportView(table);
				}
			}
			
			JPanel panelModificacion = new JPanel();
			panelModificacion.setBorder(new TitledBorder(null, "Modificar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelModificacion.setBounds(10, 21, 155, 354);
			panel.add(panelModificacion);
			panelModificacion.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Matricula: ");
			lblNewLabel.setBounds(51, 26, 64, 14);
			panelModificacion.add(lblNewLabel);
			
			TextoMatricula = new JTextField();
			TextoMatricula.setBounds(21, 51, 106, 20);
			panelModificacion.add(TextoMatricula);
			TextoMatricula.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre: ");
			lblNewLabel_1.setBounds(51, 98, 64, 14);
			panelModificacion.add(lblNewLabel_1);
			
			TextoNombre = new JTextField();
			TextoNombre.setBounds(21, 123, 106, 20);
			panelModificacion.add(TextoNombre);
			TextoNombre.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Apellido: ");
			lblNewLabel_2.setBounds(51, 167, 64, 14);
			panelModificacion.add(lblNewLabel_2);
			{
				TextoApellido = new JTextField();
				TextoApellido.setBounds(21, 192, 106, 20);
				panelModificacion.add(TextoApellido);
				TextoApellido.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Edad: ");
				lblNewLabel_3.setBounds(51, 236, 46, 14);
				panelModificacion.add(lblNewLabel_3);
			}
			{
				TextoEdad = new JTextField();
				TextoEdad.setBounds(21, 261, 106, 20);
				panelModificacion.add(TextoEdad);
				TextoEdad.setColumns(10);
			}
			
			JButton btnNewButton = new JButton("Modificar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int  fila = table.getSelectedRow();
					GestionFigura.getInstance().getEstudiantes().get(fila).setMatricula(TextoMatricula.getText());
					GestionFigura.getInstance().getProfesores().get(fila).setNombre(TextoNombre.getText());
					GestionFigura.getInstance().getProfesores().get(fila).setApellido(TextoApellido.getText());
					GestionFigura.getInstance().getProfesores().get(fila).setEdad(Integer.parseInt(TextoEdad.getText()));
					panelModificacion.setVisible(false);
					loadTable();
				}
			});
			btnNewButton.setBounds(26, 309, 89, 23);
			panelModificacion.add(btnNewButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				ModificarButton = new JButton("");
				ModificarButton.setIcon(new ImageIcon(ListaEstudiantes.class.getResource("/imagenes/editar.png")));
				ModificarButton.setEnabled(false);
				ModificarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						modificar();
					}

					
				});
				buttonPane.add(ModificarButton);
			}
			{
				EliminarButton = new JButton("\r\n");
				EliminarButton.setIcon(new ImageIcon(ListaEstudiantes.class.getResource("/imagenes/eliminar.png")));
				EliminarButton.setEnabled(false);
				EliminarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(selected!=null) {
							int fila = -1;
							 fila = table.getSelectedRow();
							 int option = JOptionPane.showConfirmDialog(EliminarButton, "Desea eliminar este figura?","Advertencia", 0,1);
							 if(option == JOptionPane.YES_OPTION) {
								 eliminar(fila); 
							 }
						}
						 
					}
				});
				EliminarButton.setActionCommand("OK");
				buttonPane.add(EliminarButton);
				getRootPane().setDefaultButton(EliminarButton);
			}
			{
				JButton cancelButton = new JButton("");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setIcon(new ImageIcon(ListaEstudiantes.class.getResource("/imagenes/flecha-hacia-atras (2).png")));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable();
	}
	
	
	private void eliminar(int fila) {
		selected = GestionFigura.getInstance().BuscarEstudianteBymatricula(table.getValueAt(fila, 0).toString());
		model.removeRow(fila);
		if(selected != null) {
			GestionFigura.getInstance().EliminarEstudiante(selected);
		}
	}
	
	private void modificar() {
		int fila = table.getSelectedRow();
		TextoMatricula.setText(GestionFigura.getInstance().getEstudiantes().get(fila).getMatricula());
		TextoNombre.setText(GestionFigura.getInstance().getEstudiantes().get(fila).getNombre());
		TextoApellido.setText(GestionFigura.getInstance().getEstudiantes().get(fila).getApellido());
		TextoEdad.setText(Integer.toString(GestionFigura.getInstance().getEstudiantes().get(fila).getEdad()));
		
	}
	
	private void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < GestionFigura.getInstance().getCantEstudiantes();i++) {
		 row[0] = GestionFigura.getInstance().getEstudiantes().get(i).getMatricula();
		 row[1] = GestionFigura.getInstance().getEstudiantes().get(i).getNombre();
		 row[2] = GestionFigura.getInstance().getEstudiantes().get(i).getApellido();
		 row[3] = GestionFigura.getInstance().getEstudiantes().get(i).getEdad();
		 model.addRow(row);
			}
		}
}
