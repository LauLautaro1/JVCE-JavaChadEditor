package app.ui.areaNavegacion;

import javax.swing.JMenu;

public interface Menu{

	/**
	 * Inicializa los componentes del menú.
	 */
	void inicializarComponentes();

	/**
	 * Devuelve el menú como un componente de tipo JMenu.
	 * 
	 * @return JMenu
	 */
	JMenu getMenu();

	/**
	 * Devuelve el nombre del menú.
	 * 
	 * @return String
	 */
	String getNombreMenu();

}
