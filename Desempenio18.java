import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Desempenio18 extends JFrame {

	private JPanel contentPane;
	private JLabel resultado;
	int monto = 3000;

	/**
	 * all programmed in Eclipse in the second semester of the degree
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desempenio18 frame = new Desempenio18();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Desempenio18() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Dinero a extraer:");
		label1.setBounds(46, 28, 118, 14);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("Tipo de cuenta:");
		label2.setBounds(266, 28, 126, 14);
		contentPane.add(label2);
		
		JComboBox combodinero = new JComboBox();
		combodinero.setModel(new DefaultComboBoxModel(new String[] {"0", "50", "100", "150", "200", "250", "300", "350", "400", "450", "500"}));
		combodinero.setSelectedIndex(0);
		combodinero.setBounds(46, 53, 107, 22);
		contentPane.add(combodinero);
		
		JComboBox combocuenta = new JComboBox();
		combocuenta.setModel(new DefaultComboBoxModel(new String[] {"Caja de ahorro", "Cuenta corriente"}));
		combocuenta.setSelectedIndex(0);
		combocuenta.setBounds(266, 53, 126, 22);
		contentPane.add(combocuenta);
		
		JButton extraer = new JButton("Extraer");
		extraer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int dinero = Integer.parseInt((String)combodinero.getSelectedItem());
				String cuenta = (String)combocuenta.getSelectedItem();
				
				if (dinero <= monto) {
					if (cuenta.equals("Caja de ahorro") && dinero <= 200) {
						monto = monto - dinero;
						resultado.setText("correcto");
					}
					else if (cuenta.equals("Cuenta corriente") && dinero <= 400) {
						monto = monto - dinero;
						resultado.setText("correcto");
					}
					else {
						resultado.setText("Incorrecto");
					}
				}
				else
				{
					resultado.setText("Fuera de servicio");
				}
			}
		});
		extraer.setBounds(46, 198, 89, 23);
		contentPane.add(extraer);
		
		resultado = new JLabel("resultado");
		resultado.setBounds(266, 202, 126, 14);
		contentPane.add(resultado);
	}
}
