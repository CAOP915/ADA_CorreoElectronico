
public class CorreoElectronico implements Comparable<CorreoElectronico>{
    
	//Comienzo y Comentarios del proyecto (Correo Electronico con cola de mensajes):
	//1 //Integrantes del equipo:
	//1.1 // Caamal Franco, Yazmin Guadalupe. RAMA: RAMA_YAZMIN.
	//1.2 // Diaz Jimenez, Nallely Patricia. RAMA: RAMA_NALLELY.
	//1.3 // Ojeda Pereira, Carlos Abraham. RAMA: RAMA_CARLOS.
	
	//2// Tareas del equipo:
	//2.1 //Ahora, se hara el cambio de la master a la rama del lider Carlos Abraham Ojeda Pereira (RAMA_CARLOS) para su edicion.
	//2.2 //Asimismo, Carlos Abraham Ojeda Pereira es el responsable de integrar todas las ramas a la rama principal y hacer su parte asignada del proyecto en su respectiva rama.
	//2.3 // Caamal Franco, Yazmin Guadalupe y Diaz Jimenez, Nallely Patricia haran sus partes asignadas del proyecto en sus respectivas ramas.
	
	//Atributos de la clase:
	private String emisor; 
	private String receptor;
	private String asunto;
	private String mensaje;
	private int tipoDeMensaje; // 1 Personal, 2 Trabajo, 3 Otro tipo.
	
	//Constructor de la clase:
	public CorreoElectronico (String emisor, String receptor, String asunto, String mensaje, int tipoDeMensaje) {
		
		this.emisor = emisor;
		this.receptor = receptor;
		this.asunto = asunto;
		this.mensaje = mensaje;
		this.tipoDeMensaje = tipoDeMensaje;
	}
    
    //Get y Set de la clase CorreoElectronico:
	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public String getReceptor() {
		return receptor;
	}

	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public int getTipoDeMensaje() {
		return tipoDeMensaje;
	}

	public void setTipoDeMensaje(int tipoDeMensaje) {
		this.tipoDeMensaje = tipoDeMensaje;
	}
    
	//Comparacion entre correos electronicos con el atributo tipoDeMensaje para la cola de la clase CorreoElectronico:
	@Override
    public int compareTo(CorreoElectronico otroCorreoEletronico) {
    
	// Comparara mensajes basadas en el atributo tipoDeMensaje:
        return Integer.compare(this.tipoDeMensaje, otroCorreoEletronico.getTipoDeMensaje());
    }
}
