package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.GestionFigura;
import logico.Prisma;
import logico.Profesor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ListaPrimas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private JButton EliminarButton;
	private JButton ModificarButton;
	private Prisma selected = null;
	private Object row[];
	private JPanel panelModificacion;
	private JTextField textBase;
	private JTextField textColor;
	private JButton MostrarButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaPrimas dialog = new ListaPrimas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaPrimas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListaPrimas.class.getResource("/imagenes/prisma.png")));
		setTitle("Lista de Prismas");
		setBounds(100, 100, 570, 433);
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
				scrollPane.setBounds(209, 0, 325, 333);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					{
						String headers[] = {"Base", "Color"};
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
										MostrarButton.setEnabled(true);
										
										selected = GestionFigura.getInstance().BuscarPrismabyCodigo(table.getValueAt(row, 0).toString());
									}
								}
								
							}
						});
						table.setModel(model);
						scrollPane.setViewportView(table);
					}
					
				}
			}
			
			panelModificacion = new JPanel();
			panelModificacion.setBorder(new TitledBorder(null, "Modificar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelModificacion.setBounds(10, 11, 189, 311);
			panel.add(panelModificacion);
			panelModificacion.setLayout(null);
			panelModificacion.setVisible(false);
			
			JLabel lblNewLabel = new JLabel("Base: ");
			lblNewLabel.setBounds(62, 30, 46, 14);
			panelModificacion.add(lblNewLabel);
			
			textBase = new JTextField();
			textBase.setBounds(36, 55, 86, 20);
			panelModificacion.add(textBase);
			textBase.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Color: ");
			lblNewLabel_1.setBounds(62, 103, 46, 14);
			panelModificacion.add(lblNewLabel_1);
			
			textColor = new JTextField();
			textColor.setBounds(36, 128, 86, 20);
			panelModificacion.add(textColor);
			textColor.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Usuario: ");
			lblNewLabel_2.setBounds(51, 173, 71, 14);
			panelModificacion.add(lblNewLabel_2);
			
			JTextField textUsuario = new JTextField();
			textUsuario.setBounds(36, 198, 86, 20);
			panelModificacion.add(textUsuario);
			textUsuario.setColumns(10);
			
			JButton ModiCambioButton = new JButton("Modificar");
			ModiCambioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int  fila = table.getSelectedRow();
					GestionFigura.getInstance().getPrismas().get(fila).setBase(Integer.parseInt(textBase.getText()));
					GestionFigura.getInstance().getPrismas().get(fila).setColor(Integer.parseInt(textColor.getText()));
					panelModificacion.setVisible(false);
					loadTable();
				}
			});
			ModiCambioButton.setBounds(36, 262, 89, 23);
			panelModificacion.add(ModiCambioButton);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				EliminarButton = new JButton("");
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
				
				MostrarButton = new JButton("");
				MostrarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int fila = -1;
						 fila = table.getSelectedRow();
						String codigo = GestionFigura.getInstance().getPrismas().get(fila).getCodigo();
						GestionFigura.getInstance().BuscarPrismabyCodigo(codigo);
						Prisma3d dialog = new Prisma3d();
						dialog.setVisible(true);
					}
				});
				MostrarButton.setIcon(new ImageIcon(ListaPrimas.class.getResource("/imagenes/show.png")));
				buttonPane.add(MostrarButton);
				EliminarButton.setIcon(new ImageIcon(ListaPrimas.class.getResource("/imagenes/eliminar.png")));
				buttonPane.add(EliminarButton);
			}
			{
				ModificarButton = new JButton("");
				ModificarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelModificacion.setVisible(true);
						Modificar();
					}
				});
				ModificarButton.setIcon(new ImageIcon(ListaPrimas.class.getResource("/imagenes/editar.png")));
				ModificarButton.setActionCommand("OK");
				buttonPane.add(ModificarButton);
				getRootPane().setDefaultButton(ModificarButton);
			}
			{
				JButton cancelButton = new JButton("");
				cancelButton.setIcon(new ImageIcon(ListaPrimas.class.getResource("/imagenes/flecha-hacia-atras (2).png")));
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
		textBase.setText(Float.toString(GestionFigura.getInstance().getPrismas().get(fila).getBase()));
		textColor.setText(Float.toString(GestionFigura.getInstance().getPrismas().get(fila).getColor()));
	}
	
	private void loadTable() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(int i = 0; i < GestionFigura.getInstance().getCantPrismas();i++) {
		 row[0] = GestionFigura.getInstance().getPrismas().get(i).getBase();
		 row[1] = GestionFigura.getInstance().getPrismas().get(i).getColor();
		 model.addRow(row);
			}
		}
}
