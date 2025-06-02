package app.ui.areaNavegacion;

import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MenuEditar extends JMenu implements Menu {
	
	private static final long serialVersionUID = 1L;
	
	// ---------- Variables ----------	

	private JMenuItem deshacer;
	private JMenuItem rehacer;
	private JMenuItem cortar;
	private JMenuItem copiar;
	private JMenuItem pegar;
	private JMenuItem seleccionarTodo;
	private JMenuItem buscar;
	
	
	// ---------- Constructor ----------
	
	public MenuEditar(Font fuente) {
		super("Editar");
		setFont(fuente);
		setMnemonic('E');
		inicializarComponentes();
	}
	

	// ---------- Metodos ----------
	
	@Override
	public void inicializarComponentes() {
		deshacer = new JMenuItem("Deshacer");
		rehacer = new JMenuItem("Rehacer");
		cortar = new JMenuItem("Cortar");
		copiar = new JMenuItem("Copiar");
		pegar = new JMenuItem("Pegar");
		seleccionarTodo = new JMenuItem("Seleccionar todo");
		buscar = new JMenuItem("Buscar");

		deshacer.setFont(getFont());
		rehacer.setFont(getFont());
		cortar.setFont(getFont());
		copiar.setFont(getFont());
		pegar.setFont(getFont());
		seleccionarTodo.setFont(getFont());
		buscar.setFont(getFont());

		add(deshacer);
		add(rehacer);
		add(cortar);
		add(copiar);
		add(pegar);
		add(seleccionarTodo);
		addSeparator();
		add(buscar);
		
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
