import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class Problema32 extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel resultado;

	/**
	 * all programmed in Eclipse in the second semester of the degree
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Problema32 frame = new Problema32();
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
	public Problema32() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton radio1 = new JRadioButton("Bebida A");
		buttonGroup.add(radio1);
		radio1.setSelected(true);
		radio1.setBounds(26, 31, 109, 23);
		contentPane.add(radio1);
		
		JRadioButton radio2 = new JRadioButton("Bebida B");
		buttonGroup.add(radio2);
		radio2.setBounds(26, 69, 109, 23);
		contentPane.add(radio2);
		
		JRadioButton radio3 = new JRadioButton("Bebida C");
		buttonGroup.add(radio3);
		radio3.setBounds(26, 105, 109, 23);
		contentPane.add(radio3);
		
		JComboBox comboPesos = new JComboBox();
		comboPesos.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5"}));
		comboPesos.setSelectedIndex(0);
		comboPesos.setBounds(313, 31, 60, 22);
		contentPane.add(comboPesos);
		
		JComboBox comboCvos = new JComboBox();
		comboCvos.setModel(new DefaultComboBoxModel(new String[] {"0", "10", "20", "30", "40", "50", "60", "70", "80", "90"}));
		comboCvos.setSelectedIndex(0);
		comboCvos.setBounds(313, 69, 60, 22);
		contentPane.add(comboCvos);
		
		JButton boton = new JButton("Expender");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int pesos = Integer.parseInt((String)comboPesos.getSelectedItem());
				int cvos = Integer.parseInt((String)comboCvos.getSelectedItem());
				if (radio1.isSelected() && pesos == 0 && cvos == 80) {
					resultado.setText("Correcto");
				}
				else if (radio2.isSelected() && pesos == 1 && cvos == 20) {
					resultado.setText("Correcto");
				}
				else if (radio3.isSelected() && pesos == 3 && cvos == 10) {
					resultado.setText("Correcto");
				}
				else {
					resultado.setText("Incorrecto");
				}
			}
		});
		boton.setBounds(46, 207, 89, 23);
		contentPane.add(boton);
		
		resultado = new JLabel("Resultado");
		resultado.setBounds(189, 211, 89, 14);
		contentPane.add(resultado);
	}
}
