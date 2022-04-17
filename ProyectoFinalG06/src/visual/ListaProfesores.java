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
import logico.Profesor;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ListaProfesores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];
	private Profesor selected = null;
	private JButton btnEliminar;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaProfesores dialog = new ListaProfesores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaProfesores() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaProfesores.class.getResource("/imagenes/tarea-completada.png")));
		setBounds(100, 100, 571, 489);
		setLocationRelativeTo(null);;
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
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					{
						String headers[]= {"Cedula","Nombre","Apellido","Edad"};
					    model = new DefaultTableModel();
						model.setColumnIdentifiers(headers);
						table = new JTable();
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {
								if(table.getSelectedRow()>-1) {
									int row = -1;
									row = table.getSelectedRow();
									if(row> -1){
										btnModificar.setEnabled(true);
										btnEliminar.setEnabled(true);
										selected = GestionFigura.getInstance().BuscarProfesorByCedula(table.getValueAt(row, 0).toString());
									}
								}
									//okButton.setEnabled(true);
								}
							}
						);
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
				btnEliminar = new JButton("");
				btnEliminar.setIcon(new ImageIcon(ListaProfesores.class.getResource("/imagenes/eliminar.png")));
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if(selected!=null) {
						 int fila = -1;
						 fila = table.getSelectedRow();
						 int option = JOptionPane.showConfirmDialog(btnEliminar, "Está seguro que desea eliminar un profesor?","Advertencia",0,1);
						 if(option == JOptionPane.YES_OPTION) {
							eliminar(fila);
						 }
						 
					}
						}
				});
				{
					btnModificar = new JButton("");
					btnModificar.setIcon(new ImageIcon(ListaProfesores.class.getResource("/imagenes/editar.png")));
					btnModificar.setEnabled(false);
					buttonPane.add(btnModificar);
				}
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				JButton cancelButton = new JButton("");
				cancelButton.setIcon(new ImageIcon(ListaProfesores.class.getResource("/imagenes/flecha-hacia-atras (2).png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable();
	}
	
	private void eliminar(int fila) {
		selected = GestionFigura.getInstance().BuscarProfesorByCedula(table.getValueAt(fila, 0).toString());
		model.removeRow(fila);
		if(selected != null) {
			GestionFigura.getInstance().EliminarProfesor(selected);
		}
	}
	
	private void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < GestionFigura.getInstance().getCantProfesores();i++) {
		 row[0] = GestionFigura.getInstance().getProfesores().get(i).getCedula();
		 row[1] = GestionFigura.getInstance().getProfesores().get(i).getNombre();
		 row[2] = GestionFigura.getInstance().getProfesores().get(i).getApellido();
		 row[3] = GestionFigura.getInstance().getProfesores().get(i).getEdad();
		 model.addRow(row);
			}
		}

}
