import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.awt.*;

public class Alquiler extends JFrame implements ActionListener, ChangeListener {
	private JLabel seleccione, cantidad;
	JButton botonmostrar, botoncalcular;
	private JTextField textdias, importe;
	private JRadioButton radio1, radio2, radio3;
	private JRadioButton radioa, radiob, radioc;
	private ButtonGroup grupo1, grupo2;
	private int dormitorios;
	private String vivienda;
	private float importetotal;
	
	public Alquiler () {
	setLayout(null);
	seleccione = new JLabel("Seleccione el tipo de Vivienda:");
	seleccione.setBounds(150,10,250,40);
	add(seleccione);
	cantidad = new JLabel("Cantidad de Días:");
	cantidad.setBounds(50,220,140,40);
	add(cantidad);
	botonmostrar = new JButton("Mostrar Diálogo");
	botonmostrar.addActionListener(this);
	botonmostrar.setBounds(230,135,185,40);
	add(botonmostrar);
	botoncalcular = new JButton("Calcular Importe");
	add(botoncalcular);
	botoncalcular.addActionListener(this);
	botoncalcular.setBounds(230,190,185,40);
	textdias = new JTextField("", JLabel.CENTER);
	textdias.setFont(new Font("Aria", Font.BOLD,20));
	textdias.setBounds(60,250,70,30);
	add(textdias);
	importe = new JTextField("$ 0,00", JLabel.CENTER);
	importe.setFont(new Font("Aria", Font.BOLD,20));
	importe.setBounds(260,240,120,40);
	add(importe);
	grupo1 = new ButtonGroup();
	radio1 = new JRadioButton("Casa");
	radio1.setBounds(60,60,150,40);
	radio1.addChangeListener(this);
	add(radio1);
	grupo1.add(radio1);
	radio2 = new JRadioButton("Dúplex");
	radio2.setBounds(210,60,120,40);
	radio2.addChangeListener(this);
	add(radio2);
	grupo1.add(radio2);
	radio3 = new JRadioButton("Departamento");
	radio3.setBounds(350,60,150,40);
	radio3.addChangeListener(this);
	add(radio3);
	grupo1.add(radio3);
	grupo2 = new ButtonGroup();
	radioa = new JRadioButton("Un Dormitorio");
	radioa.setBounds(50,120,130,20);
	radioa.addChangeListener(this);
	add(radioa);
	grupo2.add(radioa);
	radiob = new JRadioButton("Dos Dormitorios");
	radiob.setBounds(50,150,130,20);
	radiob.addChangeListener(this);
	add(radiob);
	grupo2.add(radiob);
	radioc = new JRadioButton("Tres Dormitorios");
	radioc.setBounds(50,180,130,20);
	radioc.addChangeListener(this);
	add(radioc);
	grupo2.add(radioc);
	setTitle("Alquiler de Viviendas");
	setBackground(Color.gray);
	}
	
	public void stateChanged (ChangeEvent e) {
		if (radio1.isSelected() == true) {
			vivienda = "Casa";
		}
		if (radio2.isSelected() == true) {
			vivienda = "Dúplex";
		}
		if (radio3.isSelected() == true) {
			vivienda = "Departamento";
		}
		if (radioa.isSelected() == true) {
			dormitorios = 1;
		}
		if (radiob.isSelected() == true) {
			dormitorios = 2;
		}
		if (radioc.isSelected() == true) {
			dormitorios = 3;
		}
	}
	
	public void actionPerformed (ActionEvent e) {
		if(e.getSource() == botonmostrar) {
			Dialogo d = new Dialogo(vivienda, dormitorios, importetotal);
			d.setBounds(10,10,350,300);
			d.setVisible(true);
		}
		if(e.getSource() == botoncalcular) {
			float precioxdia;
			float dias = Float.parseFloat(textdias.getText());
			
			if(vivienda == "Casa") {
				precioxdia = 50f;
			}
			else if (vivienda == "Dúplex") {
				precioxdia = 40f;
			}
			else {
				precioxdia = 30f;
			}
			
					
			if(dormitorios == 1) {
				precioxdia = precioxdia + precioxdia * 20 / 100;
			}
			else if (dormitorios == 2) {
				precioxdia = precioxdia + precioxdia * 25 / 100;
			}
			else {
				precioxdia = precioxdia + precioxdia * 30 / 100;
			}

			importetotal = dias * precioxdia;
			DecimalFormat df = new DecimalFormat("#.00");
			textdias.setText(String.valueOf(df.format(dias)));
			importe.setText("$ " + String.valueOf(df.format(importetotal)));
						
		}
				
	}
	
	
	public static void main (String [] ar) {
		Alquiler a = new Alquiler();
		a.setBounds(0,0,500,400);
		a.setVisible(true);
	}
}
