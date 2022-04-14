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

public class ListaEstudiantes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];
	private JButton ModificarButton;
	private JButton EliminarButton;
	private Estudiante selected = null;

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
		setBounds(100, 100, 548, 486); 
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
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
								int selected = table.getSelectedColumn();
								if(selected > -1) {
									
									ModificarButton.setEnabled(true);
									EliminarButton.setEnabled(true);
								}
							}
						});
						table.setModel(model);
						scrollPane.setViewportView(table);
					}
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				ModificarButton = new JButton("Modificar");
				ModificarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				buttonPane.add(ModificarButton);
			}
			{
				EliminarButton = new JButton("Eliminar");
				EliminarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 int fila = -1;
						 fila = table.getSelectedRow();
						 JOptionPane.showConfirmDialog(EliminarButton, "Desea eliminar este figura?","Advertencia", 0,1);
						 eliminar(fila); 
					}
				});
				EliminarButton.setActionCommand("OK");
				buttonPane.add(EliminarButton);
				getRootPane().setDefaultButton(EliminarButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
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
