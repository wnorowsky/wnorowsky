import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Lavadora extends JFrame {

	private JPanel contentPane;
	private JTextField textoTiempo;
	private JTextField textoEstado;
	private JComboBox comboAlumno;
	private int estado = 1;
	private int choice = 0;
	private String temperatura = "fria";
	private int columnaTemperatura = 400;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lavadora frame = new Lavadora();
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
	public Lavadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Máquina Lavadora");
		
		JButton botonEncender = new JButton("Encender");
		botonEncender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado = 0;
				repaint();
			}
		});
		botonEncender.setBounds(10, 11, 89, 23);
		contentPane.add(botonEncender);
		
		JButton botonApagar = new JButton("Apagar");
		botonApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				estado = 1;
				temperatura = "fria";
				columnaTemperatura = 400;
				textoTiempo.setText("0");
				textoEstado.setText("---");
				repaint();
			}
		});
		botonApagar.setBounds(109, 11, 89, 23);
		contentPane.add(botonApagar);
		
		JLabel labelIndicador = new JLabel("Indicador");
		labelIndicador.setBounds(232, 0, 69, 14);
		contentPane.add(labelIndicador);
		
		comboAlumno = new JComboBox();
		comboAlumno.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String seleccion = (String)comboAlumno.getSelectedItem();
				if (seleccion.equals("Inicializar")) {
					choice = 0;
				}
				else if (seleccion.equals("Alumno")) {
					choice = 1;
				}
				else {
					choice = 2;
				}
			}
		});
		comboAlumno.setMaximumRowCount(3);
		comboAlumno.setModel(new DefaultComboBoxModel(new String[] {"Inicializar", "Alumno", "Terminar"}));
		comboAlumno.setSelectedIndex(0);
		comboAlumno.setBounds(336, 11, 138, 22);
		contentPane.add(comboAlumno);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == 0) {
				
				if (choice == 0) {
					textoTiempo.setText("0");
					temperatura = "fria";
					columnaTemperatura = 400;
					textoEstado.setText("---");
					repaint();
				}
				else if (choice == 1) {
					int tiempo = Integer.parseInt(textoTiempo.getText());
					dialogo d = new dialogo(tiempo);
					d.setVisible(true);
				}
				else {
					System.exit(0);
				}
				}
			}
		});
		botonAceptar.setBounds(515, 11, 89, 23);
		contentPane.add(botonAceptar);
		
		JLabel labelTiempo = new JLabel("Tiempo de funcionamiento");
		labelTiempo.setBounds(75, 75, 184, 14);
		contentPane.add(labelTiempo);
		
		JLabel labelTemperatura = new JLabel("Seleccion de temperatura");
		labelTemperatura.setBounds(407, 75, 216, 14);
		contentPane.add(labelTemperatura);
		
		textoTiempo = new JTextField();
		textoTiempo.setText("0");
		textoTiempo.setFont(new Font("Tahoma", Font.BOLD, 15));
		textoTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		textoTiempo.setBounds(89, 110, 109, 44);
		contentPane.add(textoTiempo);
		textoTiempo.setColumns(10);
		
		JButton botonTiempoIzq = new JButton("<");
		botonTiempoIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == 0) {
				int tiempo = Integer.parseInt(textoTiempo.getText());
				if (tiempo >= 10) {
					tiempo = tiempo - 10;
					textoTiempo.setText(String.valueOf(tiempo));
				}
				}
			}
		});
		botonTiempoIzq.setBounds(46, 183, 89, 23);
		contentPane.add(botonTiempoIzq);
		
		JButton botonTiempoDer = new JButton(">");
		botonTiempoDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == 0) {
				int tiempo = Integer.parseInt(textoTiempo.getText());
				if (tiempo <= 90) {
					tiempo = tiempo + 10;
					textoTiempo.setText(String.valueOf(tiempo));
				}
				}
			}
		});
		botonTiempoDer.setBounds(158, 183, 89, 23);
		contentPane.add(botonTiempoDer);
		
		JButton botonActivar = new JButton("Activar");
		botonActivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == 0) {
				int tiempo = Integer.parseInt(textoTiempo.getText());
				if (temperatura.equals("caliente") && tiempo != 0 && tiempo <= 30) {
					textoEstado.setText("Correcto");
				}
				else if (temperatura.equals("tibia") && tiempo != 0 && tiempo <= 60) {
					textoEstado.setText("Correcto");
				}
				else if (temperatura.equals("fria") && tiempo <= 90) {
					textoEstado.setText("Correcto");
				}
				else {
					textoEstado.setText("Incorrecto");
				}
				}
			}
		});
		botonActivar.setBounds(55, 307, 158, 23);
		contentPane.add(botonActivar);
		
		textoEstado = new JTextField();
		textoEstado.setColumns(10);
		textoEstado.setBounds(291, 307, 210, 23);
		contentPane.add(textoEstado);
		
		JButton botonTemperaturaIzq = new JButton("<");
		botonTemperaturaIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == 0) {
				if (temperatura.equals("tibia")) {
					temperatura = "fria";
					columnaTemperatura = columnaTemperatura - 75;
				}
				else if (temperatura.equals("caliente")) {
					temperatura = "tibia";
					columnaTemperatura = columnaTemperatura - 75;
				}
				repaint();
				}
			}
		});
		botonTemperaturaIzq.setBounds(388, 199, 89, 23);
		contentPane.add(botonTemperaturaIzq);
		
		JButton botonTemperaturaDer = new JButton(">");
		botonTemperaturaDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (estado == 0) {
				if (temperatura.equals("fria")) {
					temperatura = "tibia";
					columnaTemperatura = columnaTemperatura + 75;
				}
				else if (temperatura.equals("tibia")) {
					temperatura = "caliente";
					columnaTemperatura = columnaTemperatura + 75;
				}
				repaint();
				}
			}
		});
		botonTemperaturaDer.setBounds(500, 199, 89, 23);
		contentPane.add(botonTemperaturaDer);
		
		JLabel labelFria = new JLabel("Fria");
		labelFria.setBounds(398, 158, 46, 14);
		contentPane.add(labelFria);
		
		JLabel labelTibia = new JLabel("Tibia");
		labelTibia.setBounds(471, 158, 46, 14);
		contentPane.add(labelTibia);
		
		JLabel labelCaliente = new JLabel("Caliente");
		labelCaliente.setBounds(543, 158, 46, 14);
		contentPane.add(labelCaliente);
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		
		g.setColor(Color.black);
		g.drawRect(30, 95, 275, 200);
		g.drawRect(305, 95, 335, 200);
		g.drawRect(354, 144, 271, 41);
		g.setColor(Color.white);
		g.fillRect (355, 145, 270, 40);

		if (temperatura.equals("fria")) {
			g.setColor(Color.black);
			g.drawRect(columnaTemperatura - 1, 144, 31, 41);
			g.setColor(Color.red);
			g.fillRect(columnaTemperatura, 145, 30, 40);
		}
		else if (temperatura.equals("tibia")) {
			g.setColor(Color.black);
			g.drawRect(columnaTemperatura - 1, 144, 31, 41);
			g.setColor(Color.red);
			g.fillRect(columnaTemperatura, 145, 30, 40);
		}
		else {
			g.setColor(Color.black);
			g.drawRect(columnaTemperatura - 1, 144, 31, 41);
			g.setColor(Color.red);
			g.fillRect(columnaTemperatura, 145, 30, 40);
		}
		
		g.setColor(Color.black);
		g.drawLine (415, 185, 415, 165);
		g.drawLine (490, 185, 490, 165);
		g.drawLine (565, 185, 565, 165);
		
		if (estado == 0) {
			g.setColor(Color.black);
			g.drawRect(254, 49, 31, 31);
			g.setColor(Color.green);
			g.fillRect(255, 50, 30, 30);
		}
		else {
			g.setColor(Color.black);
			g.drawRect(254, 49, 31, 31);
			g.setColor(Color.red);
			g.fillRect(255, 50, 30, 30);
		}
		
		
		
	}
}
