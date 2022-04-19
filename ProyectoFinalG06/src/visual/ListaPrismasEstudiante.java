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
import logico.Prisma;
import logico.Usuario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaPrismasEstudiante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel model;
	private JButton EliminarButton;
	private JButton ModificarButton;
	private JButton cancelButton;
	private Prisma selected = null;
	private JTable table;
	private Object[] row;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaPrismasEstudiante dialog = new ListaPrismasEstudiante();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaPrismasEstudiante() {
		setBounds(100, 100, 509, 427);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(229, 31, 221, 238);
			panel.add(scrollPane);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(table.getSelectedRow()>-1) {
							int row = -1;
						    row = table.getSelectedRow();
							if(row > -1) {
								
								ModificarButton.setEnabled(true);
								EliminarButton.setEnabled(true);
								//MostrarButton.setEnabled(true);
								
								selected = GestionFigura.getInstance().BuscarPrismabyCodigo(table.getValueAt(row, 0).toString());
							}
						}
						
						
						
					}
				});
				scrollPane.setViewportView(table);
			}
			{
				{

					String headers[]= {"Base","Color","Usuario","Edad"};
				    model = new DefaultTableModel();
					model.setColumnIdentifiers(headers);
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
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				{
					ModificarButton = new JButton("Modificar");
					ModificarButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
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
					buttonPane.add(ModificarButton);
				}
				EliminarButton.setActionCommand("OK");
				buttonPane.add(EliminarButton);
				getRootPane().setDefaultButton(EliminarButton);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
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
		selected = GestionFigura.getInstance().BuscarPrismabyCodigo(table.getValueAt(fila, 0).toString());
		model.removeRow(fila);
		if(selected != null) {
			GestionFigura.getInstance().EliminarPrisma(selected);
		}
	}
	
	private void loadTable() {
		Usuario aux = GestionFigura.getInstance().BuscarUsuariobyLogin(GestionFigura.getLoginUser());
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < aux.getMisprismas().size();i++) {
		 row[0] = aux.getMisprismas().get(i).getCodigo();
		 row[1] = aux.getMisprismas().get(i).getBase();
		 row[2] = aux.getMisprismas().get(i).getColor();
		
		 model.addRow(row);
			}
		}
}
