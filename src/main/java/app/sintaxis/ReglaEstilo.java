package app.sintaxis;

import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;

/**
 * Clase que representa una regla de estilo para aplicar a un texto basado en
 * una expresión regular. Contiene un patrón de expresión regular y un conjunto
 * de atributos de estilo.
 * 
 * esta clase la usamos en EditorCodigo.java para aplicar estilos
 */
public class ReglaEstilo {
	
	
	public Pattern patron;
    public AttributeSet estilo;
	
    public ReglaEstilo(String regex , AttributeSet estilo) {
    	this.patron = Pattern.compile(regex);
    	this.estilo = estilo;
    }
}
