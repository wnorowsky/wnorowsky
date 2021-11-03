import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Problema33 extends JFrame {

	private JPanel contentPane;
	private JLabel resultado;
	private JSpinner spinner1;
	private JSpinner spinner2;
	private JSpinner spinner3;

	/**
	 * all programmed in Eclipse in the second semester of the degree
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema33 frame = new Problema33();
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
	public Problema33() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		spinner1 = new JSpinner();
		spinner1.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner1.setBounds(33, 32, 65, 20);
		contentPane.add(spinner1);
		
		spinner2 = new JSpinner();
		spinner2.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner2.setBounds(33, 67, 65, 20);
		contentPane.add(spinner2);
		
		spinner3 = new JSpinner();
		spinner3.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner3.setBounds(33, 98, 65, 20);
		contentPane.add(spinner3);
		
		JLabel compuerta1 = new JLabel("Compuerta 1");
		compuerta1.setBounds(132, 35, 89, 14);
		contentPane.add(compuerta1);
		
		JLabel compuerta2 = new JLabel("Compuerta 2");
		compuerta2.setBounds(132, 70, 89, 14);
		contentPane.add(compuerta2);
		
		JLabel compuerta3 = new JLabel("Compuerta 3");
		compuerta3.setBounds(132, 101, 89, 14);
		contentPane.add(compuerta3);
		
		JButton caudal = new JButton("Actualizar caudal");
		caudal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (e.getSource() == caudal) {
			int c1 = Integer.parseInt(spinner1.getValue().toString());
			int c2 = Integer.parseInt(spinner1.getValue().toString());
			int c3 = Integer.parseInt(spinner1.getValue().toString());
			int caudalactual = c1 + c2 + c3;
			
				if (caudalactual <= 100) {
					resultado.setText("Caudal Bajo " + caudalactual);
				}
				else if (caudalactual <= 200) {
					resultado.setText("Caudal Medio " + caudalactual);
				}
				else {
					resultado.setText("Caudal Alto " + caudalactual);
				}
				}
			}
		});
		caudal.setBounds(10, 186, 131, 23);
		contentPane.add(caudal);
		
		resultado = new JLabel("resultado");
		resultado.setBounds(163, 190, 261, 14);
		contentPane.add(resultado);
	}
}
