package app.ui;

import javax.swing.BorderFactory;

import org.fife.ui.rtextarea.RTextScrollPane;

public class Scroll extends RTextScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase Scroll que extiende RTextScrollPane. Configura el
	 * área de código para mostrar números de línea, indicador de plegado, icono en
	 * el encabezado de la fila y quita las barras de desplazamiento.
	 * 
	 * @param codeArea El área de código a asociar con este panel de desplazamiento.
	 */
	public Scroll(CodeArea codeArea) {
		super(codeArea);
		
		setLineNumbersEnabled(true);//muestra los numeros de linea
		setFoldIndicatorEnabled(true);//muestra el indicador de plegado
		setIconRowHeaderEnabled(true);//muestra el icono en el encabezado de la fila
		setBorder(BorderFactory.createEmptyBorder());//establece el borde vacio)
		
		setFoldIndicatorEnabled(false);     // ❌ Indicador de plegado
		setIconRowHeaderEnabled(false);     // ❌ Iconos al lado de las líneas
		
		
		
		//Quitando las barras vertical y horizontal de desplazamiento
		setVerticalScrollBarPolicy(RTextScrollPane.VERTICAL_SCROLLBAR_NEVER);
		setHorizontalScrollBarPolicy(RTextScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		
		
		
		
		
	}

}
