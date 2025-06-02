package app.ui.areaNavegacion;

import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuArchivo extends JMenu implements Menu {
	
	//---------- Variables ----------
	private static final long serialVersionUID = 1L;
	
	private JMenuItem nuevoArchivo;
	private JMenuItem abrirArchivo;
	private JMenuItem guardarArchivo;
	private JMenuItem guardarComo;
	private JMenuItem salir;
	
	
	
	
	//---------- Constructor ----------
	public MenuArchivo(Font fuente) {
		super("Archivo");
		setFont(fuente);
		setMnemonic('A');
		inicializarComponentes();
	}
	
	//---------- Metodos ----------

	@Override
	public void inicializarComponentes() {
		nuevoArchivo = new JMenuItem("Nuevo archivo");
		nuevoArchivo.setFont(getFont());
		nuevoArchivo.setMnemonic('N');

		abrirArchivo = new JMenuItem("Abrir archivo");
		abrirArchivo.setFont(getFont());
		abrirArchivo.setMnemonic('O');

		guardarArchivo = new JMenuItem("Guardar archivo");
		guardarArchivo.setFont(getFont());
		guardarArchivo.setMnemonic('G');

		guardarComo = new JMenuItem("Guardar como...");
		guardarComo.setFont(getFont());
		guardarComo.setMnemonic('C');

		salir = new JMenuItem("Salir");
		salir.setFont(getFont());
		salir.setMnemonic('S');

		add(nuevoArchivo);
		add(abrirArchivo);
		add(guardarArchivo);
		add(guardarComo);
		addSeparator();
		add(salir);
		
	}

	@Override
	public JMenu getMenu() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNombreMenu() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
