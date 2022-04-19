package visual;

import java.awt.BorderLayout;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.GestionFigura;
import logico.Prisma;
import logico.Usuario;
import logico.UsuarioGestion;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ListasPrismasProfesor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel model;
	private JButton btnEliminar;
	private JTable table;
	private JButton btnCancel;
	private JButton btnModificar;
	private Prisma selected = null;
	private Object[] row;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListasPrismasProfesor dialog = new ListasPrismasProfesor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListasPrismasProfesor() {
		setBounds(100, 100, 450, 513);
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
				scrollPane.setBounds(178, 11, 246, 256);
				panel.add(scrollPane);
				
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(table.getSelectedRow()>-1) {
							int row = -1;
							row = table.getSelectedRow();
							if(row > -1) {
								
								btnModificar.setEnabled(true);
								btnEliminar.setEnabled(true);
								selected = GestionFigura.getInstance().BuscarPrismabyCodigo(table.getValueAt(row, 0).toString());
							}
						
					}
					
					
					}});
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnModificar = new JButton("Modificar");
				buttonPane.add(btnModificar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						dispose();
					}
					
					
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		loadTable();
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
