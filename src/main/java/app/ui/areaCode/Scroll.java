package app.ui.areaCode;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;

import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;

public class Scroll extends RTextScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//---------- Variables ----------
	
	private CodeArea codeArea;

	//---------- Constructor ----------
	
	/**
	 * Constructor de la clase Scroll que extiende RTextScrollPane. Configura el
	 * área de código para mostrar números de línea, indicador de plegado, icono en
	 * el encabezado de la fila y quita las barras de desplazamiento.
	 * 
	 * @param codeArea El área de código a asociar con este panel de desplazamiento.
	 */
	public Scroll(CodeArea codeArea , Font font) {
		super(codeArea);
		
		this.codeArea = codeArea;
		
		setLineNumbersEnabled(true);//muestra los numeros de linea
		setFoldIndicatorEnabled(true);//muestra el indicador de plegado
		setIconRowHeaderEnabled(true);//muestra el icono en el encabezado de la fila
		setBorder(BorderFactory.createEmptyBorder());//establece el borde vacio)
		
		setFoldIndicatorEnabled(false);     // ❌ Indicador de plegado
		setIconRowHeaderEnabled(false);     // ❌ Iconos al lado de las líneas
		
		
		
		//Quitando las barras vertical y horizontal de desplazamiento
		setVerticalScrollBarPolicy(RTextScrollPane.VERTICAL_SCROLLBAR_NEVER);
		setHorizontalScrollBarPolicy(RTextScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		// Obtener el Gutter (barra lateral izquierda)
        Gutter gutter = getGutter();
        
        // 🎨 Cambiar color de fondo, fuente, color de número, etc.
        gutter.setLineNumberFont(font);
        gutter.setLineNumberColor(Color.gray);
        gutter.setBackground(Color.black);
        gutter.setBorderColor(Color.DARK_GRAY);
		
	}
	
	//---------- Getters y Setters ----------
	
	//Funcion para obtener el CodeArea asociado a este Scroll, por que 
	//abra varias pestañas de archivos.
	public CodeArea getCodeArea() {
		return codeArea;
	}

}
