import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dialogo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textAlumno;
	private JTextField textTiempo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public dialogo(int tiempo) {
		setBounds(100, 100, 414, 176);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle("Detalle de alumno");
		{
			JLabel labelAlumno = new JLabel("Alumno:");
			labelAlumno.setHorizontalAlignment(SwingConstants.RIGHT);
			labelAlumno.setBounds(33, 11, 139, 14);
			contentPanel.add(labelAlumno);
		}
		{
			JLabel labelTiempo = new JLabel("Tiempo de funcionamiento:");
			labelTiempo.setHorizontalAlignment(SwingConstants.RIGHT);
			labelTiempo.setBounds(33, 61, 139, 14);
			contentPanel.add(labelTiempo);
		}
		{
			textAlumno = new JTextField();
			textAlumno.setHorizontalAlignment(SwingConstants.CENTER);
			textAlumno.setText("Wnorowsky, Nicolas");
			textAlumno.setBounds(207, 8, 157, 20);
			contentPanel.add(textAlumno);
			textAlumno.setColumns(10);
		}
		{
			textTiempo = new JTextField();
			textTiempo.setHorizontalAlignment(SwingConstants.CENTER);
			textTiempo.setColumns(10);
			textTiempo.setText(String.valueOf(tiempo));
			textTiempo.setBounds(207, 58, 95, 20);
			contentPanel.add(textTiempo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
