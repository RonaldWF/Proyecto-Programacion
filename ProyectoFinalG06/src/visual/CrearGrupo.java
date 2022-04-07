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
			
			JScrollPane scrollPaneEst = new JScrollPane();
			scrollPaneEst.setBounds(65, 205, 269, 220);
			panel.add(scrollPaneEst);
			
			JList list = new JList();
			scrollPaneEst.setViewportView(list);
			
			JLabel lblNewLabel = new JLabel("Disponibles");
			scrollPaneEst.setColumnHeaderView(lblNewLabel);
			
			JScrollPane scrollPaneGrup = new JScrollPane();
			scrollPaneGrup.setBounds(420, 205, 269, 220);
			panel.add(scrollPaneGrup);
			
			JList list_1 = new JList();
			scrollPaneGrup.setViewportView(list_1);
			
			JLabel lblNewLabel_1 = new JLabel("Grupo");
			scrollPaneGrup.setColumnHeaderView(lblNewLabel_1);
			
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
			
			JScrollPane scrollPanePro = new JScrollPane();
			scrollPanePro.setBounds(65, 205, 269, 220);
			panel.add(scrollPanePro);
			
			JList list_2 = new JList();
			scrollPanePro.setViewportView(list_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Crear");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
