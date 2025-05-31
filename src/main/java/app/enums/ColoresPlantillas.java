package app.enums;

import java.awt.Color;

//Clase dedicada al manejo de colores para las plantillas de código y la barra de herramientas.
public class ColoresPlantillas {
	Color[] coloresAreaDeCodigo = new Color[] {
		    Color.decode("#1E1E1E"), // 0 - fondo del editor (gris oscuro)
		    Color.decode("#2A2A2A"), // 1 - fondo línea actual (un poco más claro)
		    Color.decode("#D4D4D4"), // 2 - texto por defecto (gris muy claro)
		    Color.decode("#569CD6"), // 3 - palabras clave (azul Eclipse Dark)
		    Color.decode("#4EC9B0"), // 4 - tipos de dato (verde azulado)
		    Color.decode("#CE9178"), // 5 - strings (naranja claro)
		    Color.decode("#6A9955"), // 6 - comentarios (verde opaco)
		    Color.decode("#B5CEA8"), // 7 - números (verde claro)
		    Color.decode("#DCDCAA"), // 8 - operadores (amarillo pálido)
		    Color.decode("#F44747"), // 9 - errores (rojo brillante)
		    Color.decode("#DCDCAA"), // 10 - funciones (igual que operadores)
		    Color.decode("#9CDCFE"), // 11 - identificadores (celeste claro)
		    Color.decode("#264F78"), // 12 - selección (azul selección)
		    Color.decode("#AEAFAD")  // 13 - cursor (gris claro)
		};
	
		public static Color[] getColoresAreaDeCodigo() {
			Color[] coloresAreaDeCodigo = new Color[] {
				    Color.decode("#1E1E1E"), // 0 - fondo del editor (gris oscuro)
				    Color.decode("#2A2A2A"), // 1 - fondo línea actual (un poco más claro)
				    Color.decode("#D4D4D4"), // 2 - texto por defecto (gris muy claro)
				    Color.decode("#569CD6"), // 3 - palabras clave (azul Eclipse Dark)
				    Color.decode("#4EC9B0"), // 4 - tipos de dato (verde azulado)
				    Color.decode("#CE9178"), // 5 - strings (naranja claro)
				    Color.decode("#6A9955"), // 6 - comentarios (verde opaco)
				    Color.decode("#B5CEA8"), // 7 - números (verde claro)
				    Color.decode("#DCDCAA"), // 8 - operadores (amarillo pálido)
				    Color.decode("#F44747"), // 9 - errores (rojo brillante)
				    Color.decode("#DCDCAA"), // 10 - funciones (igual que operadores)
				    Color.decode("#9CDCFE"), // 11 - identificadores (celeste claro)
				    Color.decode("#264F78"), // 12 - selección (azul selección)
				    Color.decode("#AEAFAD")  // 13 - cursor (gris claro)
				    };
			
			return coloresAreaDeCodigo;
		}

		public static Color[] getColoresBarra() {
			Color[] coloresBarra = new Color[] {
					new Color(90, 90, 90),
					Color.decode("#F44747"), // Rojo claro para el botón de cerrar
			};

			return coloresBarra;
		}
			
			
}
