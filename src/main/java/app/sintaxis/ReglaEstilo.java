package app.sintaxis;

import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;

public class ReglaEstilo {
	public Pattern patron;
    public AttributeSet estilo;
	
    public ReglaEstilo(String regex , AttributeSet estilo) {
    	this.patron = Pattern.compile(regex);
    	this.estilo = estilo;
    }
}
