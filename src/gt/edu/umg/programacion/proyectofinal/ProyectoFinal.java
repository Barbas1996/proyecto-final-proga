package gt.edu.umg.programacion.proyectofinal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.awt.event.ActionEvent;

public class ProyectoFinal extends JFrame {

	private JPanel contentPane;
	private JTextField TxtEntidad;
	private JTextField TxtAtributo;
	private JTable table;
	private String filePath;
	private JButton Cargar;
	private JTable tbData;
	RandomAccessFile archivo;
	private JTextField txtEntidad;
	private JTextField txtAtributo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProyectoFinal frame = new ProyectoFinal();
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

	static int cantidadCaracteres = 20;

	public static final int SIZE = Integer.BYTES + (2 * (Character.BYTES * cantidadCaracteres));

	public void abrirArchivo(String ruta) throws Exception {
		archivo = new RandomAccessFile(ruta, "rw");
	}

	public void cerrarArhcivo() throws Exception {
		if (archivo != null)
			archivo.close();
	}

	private String leerString() throws IOException {
		char[] s = new char[cantidadCaracteres];
		for (int i = 0; i < s.length; i++) {
			s[i] = archivo.readChar();
		}
		return new String(s).replace('\0', ' ');
	}

	private void escribirString(String linea) throws Exception {
		StringBuffer buffer = null;
		if (linea != null) {
			buffer = new StringBuffer(linea);
		} else {
			buffer = new StringBuffer(cantidadCaracteres);

		}
		buffer.setLength(cantidadCaracteres);
		archivo.writeChars(buffer.toString());
	}
	


	public ProyectoFinal() {
		;
		setTitle("Proyecto Final");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre De La Entidad");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(10, 11, 153, 30);
		contentPane.add(lblNewLabel);

		TxtEntidad = new JTextField();
		TxtEntidad.setHorizontalAlignment(SwingConstants.CENTER);
		TxtEntidad.setBounds(20, 41, 153, 30);
		contentPane.add(TxtEntidad);
		TxtEntidad.setColumns(10);

		JButton BtnEntidad = new JButton("Agregar Entidad");
		BtnEntidad.setBounds(200, 48, 130, 23);
		contentPane.add(BtnEntidad);

		JLabel lblNombreDelAtributo = new JLabel("Nombre Del Atributo");
		lblNombreDelAtributo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreDelAtributo.setForeground(Color.BLACK);
		lblNombreDelAtributo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNombreDelAtributo.setBackground(Color.BLACK);
		lblNombreDelAtributo.setBounds(20, 97, 153, 30);
		contentPane.add(lblNombreDelAtributo);

		TxtAtributo = new JTextField();
		TxtAtributo.setHorizontalAlignment(SwingConstants.CENTER);
		TxtAtributo.setColumns(10);
		TxtAtributo.setBounds(20, 125, 153, 30);
		contentPane.add(TxtAtributo);

		JButton BtnAtributo = new JButton("Agregar Atributo");
		BtnAtributo.setBounds(200, 129, 130, 23);
		contentPane.add(BtnAtributo);

		JButton BtnCargar = new JButton("Cargar");
		BtnCargar.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				
			}
			});
		BtnCargar.setBounds(20, 169, 153, 23);
		contentPane.add(BtnCargar);

		table = new JTable();
		table.setBounds(10, 407, 519, -160);
		contentPane.add(table);

		JButton BtnBorrarEntidad = new JButton("Borrar Entidad");
		BtnBorrarEntidad.setBounds(420, 15, 120, 23);
		contentPane.add(BtnBorrarEntidad);

		JButton btnBorrarEntidad = new JButton("Borrar Atributo");
		btnBorrarEntidad.setBounds(420, 74, 120, 23);
		contentPane.add(btnBorrarEntidad);

		JButton btnVaciarEntidad = new JButton("Vaciar Entidad");
		btnVaciarEntidad.setBounds(420, 129, 120, 23);
		contentPane.add(btnVaciarEntidad);

		JLabel LblRuta = new JLabel("Ruta:");
		LblRuta.setBounds(196, 169, 344, 23);
		contentPane.add(LblRuta);
	}
}
