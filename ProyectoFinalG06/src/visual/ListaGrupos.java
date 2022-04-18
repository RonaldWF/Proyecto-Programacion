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
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ListaGrupos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];
	private JButton EliminarButton;
	private JButton ModificarButton;
	private JButton cancelButton;
	private Grupo selected = null;
	private JTextField textField;

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
				scrollPane.setBounds(250, 0, 288, 418);
				panel.add(scrollPane);
				{
					
					{
						String headers[] = {"Matricula", "Nombre", "Apellido","Edad"};
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
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(10, 11, 230, 42);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Profesor:  ");
					lblNewLabel.setBounds(10, 11, 61, 14);
					panel_1.add(lblNewLabel);
				}
				{
					textField = new JTextField();
					textField.setBounds(81, 8, 139, 20);
					panel_1.add(textField);
					textField.setColumns(10);
				}
			}
			{
				JPanel paneModificacion = new JPanel();
				paneModificacion.setBorder(new TitledBorder(null, "Modificar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				paneModificacion.setBounds(10, 64, 230, 343);
				panel.add(paneModificacion);
				paneModificacion.setLayout(null);
				{
					JLabel lblNewLabel_1 = new JLabel("Matricula: ");
					lblNewLabel_1.setBounds(82, 31, 89, 14);
					paneModificacion.add(lblNewLabel_1);
				}
				{
					JTextField textMatricula = new JTextField();
					textMatricula.setBounds(59, 56, 101, 20);
					paneModificacion.add(textMatricula);
					textMatricula.setColumns(10);
				}
				{
					JLabel lblNewLabel_2 = new JLabel("Nombre:  ");
					lblNewLabel_2.setBounds(82, 103, 89, 14);
					paneModificacion.add(lblNewLabel_2);
				}
				{
					JTextField textNombre = new JTextField();
					textNombre.setBounds(59, 128, 101, 20);
					paneModificacion.add(textNombre);
					textNombre.setColumns(10);
				}
				{
					JLabel lblNewLabel_3 = new JLabel("Apellido: ");
					lblNewLabel_3.setBounds(82, 169, 89, 14);
					paneModificacion.add(lblNewLabel_3);
				}
				{
					JTextField textApellido = new JTextField();
					textApellido.setBounds(59, 194, 101, 20);
					paneModificacion.add(textApellido);
					textApellido.setColumns(10);
				}
				{
					JLabel lblNewLabel_4 = new JLabel("Edad: ");
					lblNewLabel_4.setBounds(82, 225, 55, 14);
					paneModificacion.add(lblNewLabel_4);
				}
				{
					JTextField textEdad = new JTextField();
					textEdad.setBounds(59, 250, 101, 20);
					paneModificacion.add(textEdad);
					textEdad.setColumns(10);
				}
				{
					JButton NewModificarButton = new JButton("Modificar");
					NewModificarButton.setBounds(69, 288, 89, 23);
					paneModificacion.add(NewModificarButton);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				ModificarButton = new JButton("Modificar");
				buttonPane.add(ModificarButton);
			}
			{
				EliminarButton = new JButton("Eliminar");
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
	}

}
