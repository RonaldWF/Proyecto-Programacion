package visual;

import java.awt.BorderLayout;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Estudiante;
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
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListasPrismasProfesor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel model;
	private JButton btnEliminar;
	private JTable table;
	private JButton btnCancel;
	private Prisma selected = null;
	private Object[] row;
	private JPanel pnlModificacion;
	private JLabel lblNewLabel;
	private JTextField txtCodigo;
	private JLabel lblNewLabel_1;
	private JTextField txtBase;
	private JLabel lblNewLabel_2;
	private JTextField txtColor;
	private JButton btnModificar;

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
		setBounds(100, 100, 533, 520);
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
				scrollPane.setBounds(206, 11, 289, 334);
				panel.add(scrollPane);
				

				String headers[] = {"Codigo","Base", "Color"};
				model = new DefaultTableModel();
				model.setColumnIdentifiers(headers);
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
			{
				pnlModificacion = new JPanel();
				pnlModificacion.setBounds(8, 11, 181, 310);
				panel.add(pnlModificacion);
				pnlModificacion.setLayout(null);
				{
					lblNewLabel = new JLabel("Codigo");
					lblNewLabel.setBounds(81, 5, 33, 14);
					pnlModificacion.add(lblNewLabel);
				}
				{
					txtCodigo = new JTextField();
					txtCodigo.setBounds(57, 30, 86, 20);
					pnlModificacion.add(txtCodigo);
					txtCodigo.setColumns(10);
				}
				{
					lblNewLabel_1 = new JLabel("Base");
					lblNewLabel_1.setBounds(81, 78, 46, 14);
					pnlModificacion.add(lblNewLabel_1);
				}
				{
					txtBase = new JTextField();
					txtBase.setBounds(57, 110, 86, 20);
					pnlModificacion.add(txtBase);
					txtBase.setColumns(10);
				}
				{
					lblNewLabel_2 = new JLabel("Color");
					lblNewLabel_2.setBounds(81, 161, 46, 14);
					pnlModificacion.add(lblNewLabel_2);
				}
				{
					txtColor = new JTextField();
					txtColor.setBounds(57, 193, 86, 20);
					pnlModificacion.add(txtColor);
					txtColor.setColumns(10);
				}
				{
					btnModificar = new JButton("Modificar");
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int  fila = table.getSelectedRow();
							GestionFigura.getInstance().getPrismas().get(fila).setBase(Integer.parseInt(txtBase.getText()));
							GestionFigura.getInstance().getPrismas().get(fila).setColor(Integer.parseInt(txtColor.getText()));
							pnlModificacion.setVisible(false);
							loadTable();
						}
					});
					btnModificar.setBounds(51, 239, 101, 23);
					pnlModificacion.add(btnModificar);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
	
	private void eliminar(int fila) {
		selected = GestionFigura.getInstance().BuscarPrismabyCodigo(table.getValueAt(fila, 0).toString());
		model.removeRow(fila);
		if(selected != null) {
			GestionFigura.getInstance().EliminarPrisma(selected);
		}
	}
	
	private void Modificar() {
		int fila = table.getSelectedRow();
		txtBase.setText(Float.toString(GestionFigura.getInstance().getPrismas().get(fila).getBase()));
		txtColor.setText(Float.toString(GestionFigura.getInstance().getPrismas().get(fila).getColor()));
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
