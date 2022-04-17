package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class ListaPrimas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private JButton EliminarButton;
	private JButton ModificarButton;

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
		setBounds(100, 100, 506, 378);
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
						String headers[] = {"Base", "Color", "Usuario"};
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
					
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				EliminarButton = new JButton("");
				EliminarButton.setIcon(new ImageIcon(ListaPrimas.class.getResource("/imagenes/eliminar.png")));
				buttonPane.add(EliminarButton);
			}
			{
				ModificarButton = new JButton("");
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
	}

}
