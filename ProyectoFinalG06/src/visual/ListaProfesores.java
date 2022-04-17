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
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

public class ListaProfesores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];
	private Profesor selected = null;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JTextField textCedulaModi;
	private JTextField textNombreModi;
	private JTextField textApellidoModi;
	private JTextField textEdadModi;
	private JPanel panelModificacion;

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
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(179, 0, 364, 381);
				panel.add(scrollPane);
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
			{
				panelModificacion = new JPanel();
				panelModificacion.setVisible(false);
				panelModificacion.setBorder(new TitledBorder(null, "Modificacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panelModificacion.setBounds(12, 29, 155, 318);
				panel.add(panelModificacion);
				panelModificacion.setLayout(null);
				{
					textCedulaModi = new JTextField();
					textCedulaModi.setBounds(27, 55, 116, 22);
					panelModificacion.add(textCedulaModi);
					textCedulaModi.setColumns(10);
				}
				{
					textNombreModi = new JTextField();
					textNombreModi.setColumns(10);
					textNombreModi.setBounds(27, 122, 116, 22);
					panelModificacion.add(textNombreModi);
				}
				{
					textApellidoModi = new JTextField();
					textApellidoModi.setBounds(27, 185, 116, 22);
					panelModificacion.add(textApellidoModi);
					textApellidoModi.setColumns(10);
				}
				{
					textEdadModi = new JTextField();
					textEdadModi.setBounds(27, 242, 116, 22);
					panelModificacion.add(textEdadModi);
					textEdadModi.setColumns(10);
				}
				
				JLabel lblNewLabel = new JLabel("Cedula:");
				lblNewLabel.setBounds(53, 28, 56, 16);
				panelModificacion.add(lblNewLabel);
				
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBounds(53, 93, 56, 16);
				panelModificacion.add(lblNombre);
				
				JLabel lblApellido = new JLabel("Apellido:");
				lblApellido.setBounds(53, 157, 56, 16);
				panelModificacion.add(lblApellido);
				
				JLabel lblEdad = new JLabel("Edad:");
				lblEdad.setBounds(63, 213, 56, 16);
				panelModificacion.add(lblEdad);
				{
					JButton btnNewButton = new JButton("");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int  fila = table.getSelectedRow();
							GestionFigura.getInstance().getProfesores().get(fila).setCedula(textCedulaModi.getText());
							GestionFigura.getInstance().getProfesores().get(fila).setNombre(textNombreModi.getText());
							GestionFigura.getInstance().getProfesores().get(fila).setApellido(textApellidoModi.getText());
							GestionFigura.getInstance().getProfesores().get(fila).setEdad(Integer.parseInt(textEdadModi.getText()));
							panelModificacion.setVisible(false);
							loadTable();
						}
					});
					btnNewButton.setIcon(new ImageIcon(ListaProfesores.class.getResource("/imagenes/guardar-el-archivo (1).png")));
					btnNewButton.setBounds(47, 270, 62, 41);
					panelModificacion.add(btnNewButton);
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
					btnModificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							panelModificacion.setVisible(true);
							Modificar();
						}
					});
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
	private void Modificar() {
		int fila = table.getSelectedRow();
		textCedulaModi.setText(GestionFigura.getInstance().getProfesores().get(fila).getCedula());
		textNombreModi.setText(GestionFigura.getInstance().getProfesores().get(fila).getNombre());
		textApellidoModi.setText(GestionFigura.getInstance().getProfesores().get(fila).getApellido());
		textEdadModi.setText(Integer.toString(GestionFigura.getInstance().getProfesores().get(fila).getEdad()));
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
