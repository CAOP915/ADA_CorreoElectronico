import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CorreoElectronico_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Asunto;
	private JTextField textField_Emisor;
	private JTextField textField_Receptor;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	Queue<CorreoElectronico> cola =new PriorityQueue<CorreoElectronico>();//Cola sobre el CorreoElectronico.
	DefaultListModel model = new DefaultListModel();//Es un modelo de lista, que puede usarse para administrar los elementos mostrados por un control JList.
	DefaultListModel model2 = new DefaultListModel();//Es un segundo modelo de lista que se encarga del segundo Jlist.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CorreoElectronico_GUI frame = new CorreoElectronico_GUI();
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
	public CorreoElectronico_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1321, 737);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_TituloDeLaGUI = new JLabel("Correo Electronico Con Cola De Mensajes (\"My Mail\")");
		lblNewLabel_TituloDeLaGUI.setFont(new Font("Dubai", Font.BOLD, 34));
		lblNewLabel_TituloDeLaGUI.setBounds(297, 0, 804, 71);
		contentPane.add(lblNewLabel_TituloDeLaGUI);
		
		textField_Asunto = new JTextField();
		textField_Asunto.setBounds(113, 198, 204, 20);
		contentPane.add(textField_Asunto);
		textField_Asunto.setColumns(10);
		
		JLabel lblNewLabel_TituloDelAsunto = new JLabel("Asunto:");
		lblNewLabel_TituloDelAsunto.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblNewLabel_TituloDelAsunto.setBounds(20, 188, 65, 42);
		contentPane.add(lblNewLabel_TituloDelAsunto);
		
		JLabel lblNewLabel_TituloDelEmisor = new JLabel("Emisor:");
		lblNewLabel_TituloDelEmisor.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblNewLabel_TituloDelEmisor.setBounds(20, 104, 65, 42);
		contentPane.add(lblNewLabel_TituloDelEmisor);
		
		textField_Emisor = new JTextField();
		textField_Emisor.setColumns(10);
		textField_Emisor.setBounds(113, 114, 204, 20);
		contentPane.add(textField_Emisor);
		
		JLabel lblNewLabel_TituloDelReceptor = new JLabel("Receptor:");
		lblNewLabel_TituloDelReceptor.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblNewLabel_TituloDelReceptor.setBounds(20, 145, 83, 42);
		contentPane.add(lblNewLabel_TituloDelReceptor);
		
		textField_Receptor = new JTextField();
		textField_Receptor.setColumns(10);
		textField_Receptor.setBounds(113, 155, 204, 20);
		contentPane.add(textField_Receptor);
		
		JLabel lblNewLabel_TituloDelMensaje = new JLabel("Tipo De Mensaje:");
		lblNewLabel_TituloDelMensaje.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblNewLabel_TituloDelMensaje.setBounds(20, 241, 195, 42);
		contentPane.add(lblNewLabel_TituloDelMensaje);
		
		JLabel lblNewLabel_TituloDeRedactarMensaje = new JLabel("Redactar Mensaje:");
		lblNewLabel_TituloDeRedactarMensaje.setForeground(new Color(255, 255, 255));
		lblNewLabel_TituloDeRedactarMensaje.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_TituloDeRedactarMensaje.setBounds(105, 68, 182, 35);
		contentPane.add(lblNewLabel_TituloDeRedactarMensaje);
		
		JLabel lblNewLabel_TituloDeServidorDeImpresionDeMensajes = new JLabel("Servidor De Impresion De Mensajes:");
		lblNewLabel_TituloDeServidorDeImpresionDeMensajes.setForeground(new Color(255, 255, 255));
		lblNewLabel_TituloDeServidorDeImpresionDeMensajes.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_TituloDeServidorDeImpresionDeMensajes.setBounds(471, 64, 315, 42);
		contentPane.add(lblNewLabel_TituloDeServidorDeImpresionDeMensajes);
		
		JList list_Despachar = new JList();
		
		//JScrollPane Jlist_Despachar
		JScrollPane scroll1 = new JScrollPane (list_Despachar, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll1.setBounds(428, 116, 386, 462);
		contentPane.add(scroll1);
	
		JList list_Enviados = new JList();
		
		JButton btnNewButton_DespacharMensaje = new JButton("Despachar Mensaje Seleccionado");
		btnNewButton_DespacharMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Creación de RAMA_YAZMIN
					
		int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas despachar todos los elementos?", "Confirmar Despache", JOptionPane.YES_NO_OPTION);
			if (opcion == JOptionPane.YES_OPTION) { /*Se creo un variable llamada "opcion" para guaradar la respuesta del usuario. 
				Se pone un JOptionPane con cuadros de diálogo para que el usuario pueda elegir entre dos respuestas concretas,
				y de acuerdo a lo que escoja se ejecute el "if" o de lo contrario un "else".*/
					    
				while (!cola.isEmpty()) {//Se utiliza para saber si la cola esta vacia.
							 
				CorreoElectronico a = cola.remove(); /*El código de cola.remove() se utilizó para remover los datos almacenados en los atributos de la clase CorreoElectronico que fueron puestos en el Jlist.*/
				System.out.println(a.getTipoDeMensaje() + " " + a.getAsunto()+ " " + a.getEmisor()      + " " + a.getReceptor()+ " " + a.getMensaje()); /*Se manda un System.out.println para imprimir los datos, 
				y se utilizó ".get" que devuelve los datos que había puesto el usuario*/
					
			    model2.addElement(a); // Se declaró un DefaultListModel como "model2" al inicio del JFrame. El addElement se utilizó para que se añada un evento de datos en un paquete determinado en el mismo bote.
				list_Enviados.setModel(model2);//En este código el setModel le asigna un valor al Jlist a través de los atributos proporcionados.
			    model.clear(); //Se utilizo para limpiar la pantalla del Jlist de la información almacenada en las colas.
				model.removeAllElements();	//En esta línea el "removeAllElements" se utilizó para remover o quitar la información almacenada en pila.		
				}
					
			} else {
					    // Si el usuario selecciona "No" o cierra el cuadro de diálogo, no se hace nada.
				}
			}
		});
		btnNewButton_DespacharMensaje.setForeground(Color.WHITE);
		btnNewButton_DespacharMensaje.setBackground(new Color(0, 0, 205));
		btnNewButton_DespacharMensaje.setBounds(501, 589, 247, 35);
		contentPane.add(btnNewButton_DespacharMensaje);
		
		JLabel lblNewLabel_TituloMensajesEnviados = new JLabel("Mensajes Enviados:");
		lblNewLabel_TituloMensajesEnviados.setForeground(new Color(255, 255, 255));
		lblNewLabel_TituloMensajesEnviados.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		lblNewLabel_TituloMensajesEnviados.setBounds(1013, 68, 166, 35);
		contentPane.add(lblNewLabel_TituloMensajesEnviados);
		
		
		list_Enviados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		//JScrollPane Jlist_Enviados
		JScrollPane scroll2 = new JScrollPane (list_Enviados, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll2.setBounds(885, 116, 386, 462);
		contentPane.add(scroll2);
		
		
		JButton btnNewButton_EliminarMensaje = new JButton("Eliminar Mensaje Seleccionado");
				list_Enviados.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						String seleccionado = list_Enviados.getSelectedValue().toString(); //Se creó la variable "seleccionado" para agarrar los datos almacenados en el Jlist de Enviados.
						JOptionPane.showMessageDialog(null, seleccionado); //Se escribio un JOPtionPane para seleccionar un mensaje en el jlist.
						int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el elemento seleccionado?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
		                // Se creó otra variable con el motivo de preguntarle al usuario si esta seguro de eliminar el mensaje.
						if (opcion == JOptionPane.YES_OPTION) {//Se utilizó un "if" para los usuarios que dicen "si" podrán eliminar sus mensajes uno por uno.
						  
							model2.remove(list_Enviados.getSelectedIndex());//Este código permite quitar o remover del Jlist los datos obtenidos anteriormente.
						
						} else {
						    // Si el usuario selecciona "No" o cierra el cuadro de diálogo, no se hace nada
						}
					}
		});
		btnNewButton_EliminarMensaje.setForeground(Color.WHITE);
		btnNewButton_EliminarMensaje.setBackground(new Color(0, 0, 205));
		btnNewButton_EliminarMensaje.setBounds(980, 592, 226, 35);
		contentPane.add(btnNewButton_EliminarMensaje);
		
		JLabel lblNewLabel_FondodeRedactarMensaje_Titulo = new JLabel("");
		lblNewLabel_FondodeRedactarMensaje_Titulo.setBounds(10, 70, 338, 33);
		contentPane.add(lblNewLabel_FondodeRedactarMensaje_Titulo);
		lblNewLabel_FondodeRedactarMensaje_Titulo.setIcon(new ImageIcon("Imagenes_CorreoElectronico_GUI/Fondo de Redactar Mensaje_Titulo.png"));
		
		JLabel lblNewLabel_Logo = new JLabel("");
		lblNewLabel_Logo.setBounds(212, 11, 75, 48);
		contentPane.add(lblNewLabel_Logo);
		lblNewLabel_Logo.setIcon(new ImageIcon("Imagenes_CorreoElectronico_GUI/Logo de Correo Electronico.gif"));
		
		//JTextArea
		JTextArea textArea_EscribirMensaje = new JTextArea();
		textArea_EscribirMensaje.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textArea_EscribirMensaje.setText("Escribe aqui tu mensaje");
		textArea_EscribirMensaje.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textArea_EscribirMensaje.getText().equals("Escribe aqui tu mensaje")){
					textArea_EscribirMensaje.setText("");
            }
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textArea_EscribirMensaje.getText().isEmpty()){
					textArea_EscribirMensaje.setText("Escribe aqui tu mensaje");
		            }
			}
		});
		textArea_EscribirMensaje.setLineWrap(true);
		
		//JScrollPane de textArea_EscribirMensaje
		JScrollPane scroll = new JScrollPane (textArea_EscribirMensaje, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(10, 306, 338, 275);
		contentPane.add(scroll);
		
		JRadioButton rdbtnNewRadioButton_TipoDeMensajeTrabajo = new JRadioButton("2. Trabajo.");
		buttonGroup.add(rdbtnNewRadioButton_TipoDeMensajeTrabajo);
		rdbtnNewRadioButton_TipoDeMensajeTrabajo.setBounds(165, 250, 111, 23);
		contentPane.add(rdbtnNewRadioButton_TipoDeMensajeTrabajo);
		
		JRadioButton rdbtnNewRadioButton_TipoDeMensajeOtroTipo = new JRadioButton("3. Otro Tipo.");
		buttonGroup.add(rdbtnNewRadioButton_TipoDeMensajeOtroTipo);
		rdbtnNewRadioButton_TipoDeMensajeOtroTipo.setBounds(165, 276, 111, 23);
		contentPane.add(rdbtnNewRadioButton_TipoDeMensajeOtroTipo);
		
		JRadioButton rdbtnNewRadioButton_TipoDeMensajePersonal = new JRadioButton("1. Personal.");
		buttonGroup.add(rdbtnNewRadioButton_TipoDeMensajePersonal);
		rdbtnNewRadioButton_TipoDeMensajePersonal.setBounds(165, 225, 111, 23);
		contentPane.add(rdbtnNewRadioButton_TipoDeMensajePersonal);
		
		JLabel lblNewLabel_FondodeRedactarMensaje_DatosDelMensaje = new JLabel("");
		lblNewLabel_FondodeRedactarMensaje_DatosDelMensaje.setBounds(10, 98, 338, 209);
		contentPane.add(lblNewLabel_FondodeRedactarMensaje_DatosDelMensaje);
		lblNewLabel_FondodeRedactarMensaje_DatosDelMensaje.setIcon(new ImageIcon("Imagenes_CorreoElectronico_GUI/Fondo de Redactar Mensaje_Datos Del Mensaje.png"));
		
		
		JButton btnNewButton_EnviarMensaje = new JButton("Enviar Mensaje");
		btnNewButton_EnviarMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (rdbtnNewRadioButton_TipoDeMensajePersonal.isSelected()) {
					int tipoDeMensajeOrden= 1;
					String tipoDeMensajeSeleccionado = ("Personal");
				}
				
				if (rdbtnNewRadioButton_TipoDeMensajeTrabajo.isSelected()) {
					int tipoDeMensajeOrden= 2;
					String tipoDeMensajeSeleccionado = ("Trabajo");	
				}
				
				if (rdbtnNewRadioButton_TipoDeMensajeOtroTipo.isSelected()) {
					int tipoDeMensajeOrden= 3;
					String tipoDeMensajeSeleccionado = ("Otro Tipo");
				}	
			}
		});
		
		JLabel lblNewLabel_TituloDeServidorDeImpresionDeMensajes_1 = new JLabel("(Ver Informacion Del Mensaje Al Seleccionarlo)");
		lblNewLabel_TituloDeServidorDeImpresionDeMensajes_1.setForeground(Color.WHITE);
		lblNewLabel_TituloDeServidorDeImpresionDeMensajes_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_TituloDeServidorDeImpresionDeMensajes_1.setBounds(489, 80, 285, 54);
		contentPane.add(lblNewLabel_TituloDeServidorDeImpresionDeMensajes_1);
		
		JLabel lblNewLabel_TituloMensajesEnviados_1 = new JLabel("(Ver Informacion Del Mensaje Al Seleccionarlo)");
		lblNewLabel_TituloMensajesEnviados_1.setForeground(Color.WHITE);
		lblNewLabel_TituloMensajesEnviados_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_TituloMensajesEnviados_1.setBounds(957, 80, 285, 54);
		contentPane.add(lblNewLabel_TituloMensajesEnviados_1);
		
		btnNewButton_EnviarMensaje.setForeground(new Color(255, 255, 255));
		btnNewButton_EnviarMensaje.setBackground(new Color(0, 0, 205));
		btnNewButton_EnviarMensaje.setBounds(105, 592, 128, 35);
		contentPane.add(btnNewButton_EnviarMensaje);
		
		JLabel lblNewLabel_FondodeRedactarMensaje_BotonDelMensaje = new JLabel("");
		lblNewLabel_FondodeRedactarMensaje_BotonDelMensaje.setBounds(10, 577, 338, 71);
		contentPane.add(lblNewLabel_FondodeRedactarMensaje_BotonDelMensaje);
		lblNewLabel_FondodeRedactarMensaje_BotonDelMensaje.setIcon(new ImageIcon("Imagenes_CorreoElectronico_GUI/Fondo de Redactar Mensaje_Boton Del Mensaje.png"));
		
		JLabel lblNewLabel_FondoDeServidorDeImpresionDeMensajes_BotonDespacharMensaje = new JLabel("");
		lblNewLabel_FondoDeServidorDeImpresionDeMensajes_BotonDespacharMensaje.setBounds(428, 556, 386, 90);
		contentPane.add(lblNewLabel_FondoDeServidorDeImpresionDeMensajes_BotonDespacharMensaje);
		lblNewLabel_FondoDeServidorDeImpresionDeMensajes_BotonDespacharMensaje.setIcon(new ImageIcon("Imagenes_CorreoElectronico_GUI/Fondo De Servidor De Impresion De Mensajes_Boton Despachar Mensaje.png"));
		
		JLabel lblNewLabel_FondoDeServidorDeImpresionDeMensajes_Titulo = new JLabel("");
		lblNewLabel_FondoDeServidorDeImpresionDeMensajes_Titulo.setBounds(428, 71, 386, 54);
		contentPane.add(lblNewLabel_FondoDeServidorDeImpresionDeMensajes_Titulo);
		lblNewLabel_FondoDeServidorDeImpresionDeMensajes_Titulo.setIcon(new ImageIcon("Imagenes_CorreoElectronico_GUI/Fondo De Servidor De Impresion De Mensajes_Titulo.png"));
		
		JLabel lblNewLabel_FondoDeMensajesEnviados_BotonEliminarMensajeSeleccionado = new JLabel("");
		lblNewLabel_FondoDeMensajesEnviados_BotonEliminarMensajeSeleccionado.setBounds(885, 556, 386, 90);
		contentPane.add(lblNewLabel_FondoDeMensajesEnviados_BotonEliminarMensajeSeleccionado);
		lblNewLabel_FondoDeMensajesEnviados_BotonEliminarMensajeSeleccionado.setIcon(new ImageIcon("Imagenes_CorreoElectronico_GUI/Fondo De Mensajes Enviados_Boton Eliminar Mensaje Seleccionado.png"));
		
		JLabel lblNewLabel_FondoDeMensajesEnviados_Titulo = new JLabel("");
		lblNewLabel_FondoDeMensajesEnviados_Titulo.setBounds(885, 68, 386, 54);
		contentPane.add(lblNewLabel_FondoDeMensajesEnviados_Titulo);
		lblNewLabel_FondoDeMensajesEnviados_Titulo.setIcon(new ImageIcon("Imagenes_CorreoElectronico_GUI/Fondo De Mensajes Enviados_Titulo.png"));
		
		JLabel lblNewLabel_FondoCorreoElectronico_GUI = new JLabel("");
		lblNewLabel_FondoCorreoElectronico_GUI.setBounds(0, -27, 1297, 727);
		contentPane.add(lblNewLabel_FondoCorreoElectronico_GUI);
		lblNewLabel_FondoCorreoElectronico_GUI.setIcon(new ImageIcon("Imagenes_CorreoElectronico_GUI/Fondo Correo Electronico_GUI.jpg"));
	
	}
}