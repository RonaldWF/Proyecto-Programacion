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
import logico.UsuarioGestion;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ListaPrismasEstudiante extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel model;
	private JButton EliminarButton;
	private JButton cancelButton;
	private Prisma selected = null;
	private JTable table;
	private Object[] row;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JPanel panel_1;
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
		setBounds(100, 100, 522, 442);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Modificar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(193, 6, 292, 319);
			panel.add(scrollPane);
			{
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
								EliminarButton.setEnabled(true);
								//MostrarButton.setEnabled(true);
								
								//selected = GestionFigura.getInstance().BuscarPrismabyCodigo(table.getValueAt(row, 0).toString());
							}
						}
						
						
						
					}
				});
				scrollPane.setViewportView(table);
			}
			{
				panel_1 = new JPanel();
				panel_1.setBounds(7, 20, 166, 263);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					lblNewLabel = new JLabel("Codigo:");
					lblNewLabel.setBounds(89, 11, 46, 14);
					panel_1.add(lblNewLabel);
				}
				{
					txtCodigo = new JTextField();
					txtCodigo.setBounds(64, 30, 86, 20);
					panel_1.add(txtCodigo);
					txtCodigo.setColumns(10);
				}
				{
					lblNewLabel_1 = new JLabel("Base:");
					lblNewLabel_1.setBounds(89, 78, 46, 14);
					panel_1.add(lblNewLabel_1);
				}
				{
					txtBase = new JTextField();
					txtBase.setBounds(64, 102, 86, 20);
					panel_1.add(txtBase);
					txtBase.setColumns(10);
				}
				{
					lblNewLabel_2 = new JLabel("Color:");
					lblNewLabel_2.setBounds(89, 154, 46, 14);
					panel_1.add(lblNewLabel_2);
				}
				{
					txtColor = new JTextField();
					txtColor.setBounds(64, 179, 86, 20);
					panel_1.add(txtColor);
					txtColor.setColumns(10);
				}
				{
					btnModificar = new JButton("Modificar");
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
						}
					});
					btnModificar.setBounds(53, 219, 107, 23);
					panel_1.add(btnModificar);
				}
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
