import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Dialogo extends JDialog implements ActionListener {
	private JLabel label1, label2, label3;
	private JButton boton;
	
	public Dialogo(String vivienda, int dormitorios, float importetotal) {
		setLayout(null);
		setModal(true);
		setResizable(false);
		DecimalFormat df = new DecimalFormat("#.00");
		label1 = new JLabel("La vivienda seleccionada es: " + vivienda);
		label1.setBounds(10,10,200,20);
		add(label1);
		label2 = new JLabel("La cantidad de dormitorios es de: " + dormitorios);
		label2.setBounds(10,40,270,20);
		add(label2);
		label3 = new JLabel("Importe a abonar : $ " + df.format(importetotal));
		label3.setBounds(10,70,200,20);
		add(label3);
		boton = new JButton("Cerrar");
		boton.setBounds(10,100,200,20);
		boton.addActionListener(this);
		add(boton);
		setTitle("Detalle");
	}
	
	public void actionPerformed (ActionEvent e) {
		if(e.getSource() == boton) {
			dispose();
		}
	}
}
