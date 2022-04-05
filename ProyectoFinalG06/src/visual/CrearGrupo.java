package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class CrearGrupo extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearGrupo dialog = new CrearGrupo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearGrupo() {
		setBounds(100, 100, 809, 586);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(65, 205, 269, 220);
			panel.add(scrollPane);
			
			JList list = new JList();
			scrollPane.setViewportView(list);
			
			JLabel lblNewLabel = new JLabel("Disponibles");
			scrollPane.setColumnHeaderView(lblNewLabel);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(420, 205, 269, 220);
			panel.add(scrollPane_1);
			
			JList list_1 = new JList();
			scrollPane_1.setViewportView(list_1);
			
			JLabel lblNewLabel_1 = new JLabel("Grupo");
			scrollPane_1.setColumnHeaderView(lblNewLabel_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Creacion de Grupo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(24, 112, 731, 369);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JButton btnNewButton = new JButton(">>");
			btnNewButton.setBounds(315, 151, 78, 25);
			panel_1.add(btnNewButton);
			
			JButton button = new JButton("<<");
			button.setBounds(315, 219, 78, 25);
			panel_1.add(button);
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("Estudiantes");
			rdbtnNewRadioButton.setBounds(45, 50, 127, 25);
			panel_1.add(rdbtnNewRadioButton);
			
			JRadioButton rdbtnProfesores = new JRadioButton("Profesores");
			rdbtnProfesores.setBounds(176, 50, 127, 25);
			panel_1.add(rdbtnProfesores);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
