package cl.ucn.PIPA.interfazGrafica.ventanas;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cl.ucn.PIPA.dominio.Panel;
import cl.ucn.PIPA.logica.Sistema;
/*
* Clase que administra las ventanas
*/
public class AdministradorDeVentanas {
    private Sistema sistema;
	private JFrame ventana;
	private List<Panel> paneles;
	/*
	* Constructor de la clase
	* @param sistema, la superclase del sistema
	*/
	public AdministradorDeVentanas(Sistema sistema) {
		this.sistema = sistema;
		this.ventana = new JFrame();
		this.paneles = new LinkedList<>();
	}
	/*
	* Metodo que despliega la ventana menu
	* @param administradorDeVentanas, la ventana inicializada
	*/
    public void menu(AdministradorDeVentanas administradorDeVentanas) {
		Ventana ventana = new VentanaMenu(administradorDeVentanas,this.ventana);
		paneles.add(ventana.getPanel());
		ventana.iniciarVentana();
	}
	/*
	* Metodo que despliega la ventana de lectura de archivo
	* @param administradorDeVentanas, la ventana inicializada
	*/
	public void leerArchivo(AdministradorDeVentanas administradorDeVentanas){
		Ventana ventana = new VentanaLectura(administradorDeVentanas,sistema,this.ventana);
		paneles.add(ventana.getPanel());
		ventana.iniciarVentana();
	}
	/*
	* Metodo que despliega la ventana que muestra el mapa
	* @param administradorDeVentanas, la ventana inicializada
	*/
	public void mostrarMapa(AdministradorDeVentanas administradorDeVentanas){
		Ventana ventana = new VentanaMapa(administradorDeVentanas,sistema,this.ventana);
		paneles.add(ventana.getPanel());
		ventana.iniciarVentana();
	}
	/*
	* Metodo que despliega la ventana error
	* @param administradorDeVentanas, la ventana inicializada
	*/
	public void mostrarError(String mensajeError){
		JOptionPane.showMessageDialog(null, mensajeError,"Error", 0);
	}

    public void limpiarVentana(JFrame ventana) {
		ventana.getContentPane().removeAll();
    }
}