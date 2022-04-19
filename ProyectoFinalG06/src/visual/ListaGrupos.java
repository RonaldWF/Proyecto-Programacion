package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Estudiante;
import logico.GestionFigura;
import logico.Grupo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaGrupos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];
	private JButton EliminarButton;
	private JButton cancelButton;
	private Grupo selected = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaGrupos dialog = new ListaGrupos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaGrupos() {
		setBounds(100, 100, 574, 500);
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
				scrollPane.setBounds(12, 0, 526, 418);
				panel.add(scrollPane);
				{
					
					{
						String headers[] = {"Numero de grupo" };
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
										
										EliminarButton.setEnabled(true);
										
										Estudiante aux =  GestionFigura.getInstance().BuscarEstudianteBymatricula(table.getValueAt(row, 0).toString());
										selected = GestionFigura.getInstance().BuscarGrupo(aux);
									}
								}
								
							}
						});
					}
					
					
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				EliminarButton = new JButton("Eliminar");
				EliminarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(selected!=null) {
							 int fila = -1;
							 fila = table.getSelectedRow();
							 int option = JOptionPane.showConfirmDialog(EliminarButton, "Está seguro que desea eliminar un profesor?","Advertencia",0,1);
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
				cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable();
	}

	private void eliminar(int fila) {
		Estudiante aux =  GestionFigura.getInstance().BuscarEstudianteBymatricula(table.getValueAt(fila, 0).toString());
		selected = GestionFigura.getInstance().BuscarGrupo(aux);
		model.removeRow(fila);
		if(selected != null) {
			GestionFigura.getInstance().EliminarGrupo(selected);
		}
	}
	
	
	private void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < GestionFigura.getInstance().getCantGrupos();i++) {
		 row[0] = GestionFigura.getInstance().getGrupos().get(i).getNumGrupo();
		 model.addRow(row);
			}
		}
	
}
