package app.enums;

import java.awt.Color;

//Clase dedicada al manejo de colores para las plantillas de código y la barra de herramientas.
public class ColoresPlantillas {
	private final static Color[] coloresAreaDeCodigo = new Color[] {
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
	
	private final static Color[] coloresAreaDeCodigo2 = new Color[] {
		    Color.decode("#000000"),       // 0 - Fondo del editor (negro puro)
		    Color.decode("#0d1117"),       // 1 - Fondo línea actual (gris oscuro GitHub)
		    Color.decode("#f0f0f0"),       // 2 - Texto por defecto (blanco suave)
		    Color.decode("#79c0ff"),       // 3 - Palabras clave (azul GitHub)
		    Color.decode("#58a6ff"),       // 4 - Tipos de dato (azul más intenso)
		    Color.decode("#9ecbff"),       // 5 - Strings (azul claro)
		    Color.decode("#8b949e"),       // 6 - Comentarios (gris GitHub)
		    Color.decode("#b5cee8"),       // 7 - Números (azul muy claro)
		    Color.decode("#d2a8ff"),       // 8 - Operadores (morado claro)
		    Color.decode("#ff7b72"),       // 9 - Errores (rojo suave GitHub)
		    Color.decode("#d2a8ff"),       // 10 - Funciones (igual que operadores)
		    Color.decode("#9cdcfe"),       // 11 - Identificadores (celeste claro)
		    Color.decode("#264f78"),       // 12 - Selección (azul selección oscuro)
		    Color.decode("#aeafad")        // 13 - Cursor (gris claro)
		};
	
	private final static Color[] coloresDeepSeek = new Color[] {

		    Color.decode("#1a1a1a"),       // 0 - Fondo del editor (gris oscuro profundo)
		    Color.decode("#252525"),       // 1 - Fondo línea actual (gris oscuro resaltado)
		    Color.decode("#e0e0e0"),       // 2 - Texto principal (blanco suave)
		    Color.decode("#569CD6"),       // 3 - Palabras clave (azul clásico IDE)
		    Color.decode("#4EC9B0"),       // 4 - Tipos de dato (verde-azulado brillante)
		    Color.decode("#CE9178"),       // 5 - Strings (naranja cálido)
		    Color.decode("#6A9955"),       // 6 - Comentarios (verde apagado)
		    Color.decode("#B5CEA8"),       // 7 - Números (verde pastel)
		    Color.decode("#D7BA7D"),       // 8 - Operadores (amarillo dorado)
		    Color.decode("#F44747"),       // 9 - Errores (rojo intenso)
		    Color.decode("#C586C0"),       // 10 - Funciones (morado/lila)
		    Color.decode("#9CDCFE"),       // 11 - Identificadores (azul cielo)
		    Color.decode("#264F78"),       // 12 - Selección (azul oscuro)
		    Color.decode("#D4D4D4")        // 13 - Cursor (gris claro brillante)
		};
	
	private final static Color[] coloresMonokai = new Color[] {
		    Color.decode("#272822"), // 0 - Fondo base
		    Color.decode("#3E3D32"), // 1 - Línea actual
		    Color.decode("#F8F8F2"), // 2 - Texto principal

		    Color.decode("#F92672"), // 3 - RESERVED_WORD
		    Color.decode("#66D9EF"), // 4 - DATA_TYPE
		    Color.decode("#E6DB74"), // 5 - STRING
		    Color.decode("#75715E"), // 6 - Comentarios
		    Color.decode("#AE81FF"), // 7 - Números
		    Color.decode("#F8F8F2"), // 8 - Operadores
		    Color.decode("#FF5555"), // 9 - ERROR_IDENTIFIER
		    Color.decode("#A6E22E"), // 10 - FUNCIONES
		    Color.decode("#F8F8F2"), // 11 - IDENTIFICADORES

		    Color.decode("#49483E"), // 12 - Selección
		    Color.decode("#F8F8F0"), // 13 - Cursor

		    Color.decode("#FD971F"), // 14 - CHAR
		    Color.decode("#F92672"), // 15 - BACKQUOTE
		    Color.decode("#FD5FF0"), // 16 - Otro tipo (regex, etc.)
		    Color.decode("#A6E22E"), // 17 - VARIABLE
		    Color.decode("#FD5FF0"), // 18 - REGEX
		    Color.decode("#66D9EF"), // 19 - ANNOTATION
		    Color.decode("#F8F8F2"), // 20 - IDENTIFIER (again)
		    Color.decode("#272822"), // 21 - WHITESPACE
		    Color.decode("#F8F8F2"), // 22 - SEPARATOR
		    Color.decode("#F8F8F2"), // 23 - OPERATOR
		    Color.decode("#66D9EF"), // 24 - PREPROCESSOR
		    Color.decode("#F8F8F2"), // 25 - TAG_DELIMITER
		    Color.decode("#F92672"), // 26 - TAG_NAME
		    Color.decode("#FD971F"), // 27 - ATTR
		    Color.decode("#E6DB74"), // 28 - ATTR_VALUE
		    Color.decode("#75715E"), // 29 - MARKUP_COMMENT
		    Color.decode("#75715E"), // 30 - MARKUP_DTD
		    Color.decode("#66D9EF"), // 31 - PROC_INSTR
		    Color.decode("#E6DB74"), // 32 - CDATA_DELIMITER
		    Color.decode("#F8F8F2"), // 33 - CDATA
		    Color.decode("#A6E22E"), // 34 - ENTITY_REFERENCE
		    Color.decode("#FF5555"), // 35 - ERROR_IDENTIFIER
		    Color.decode("#FF6E6E"), // 36 - ERROR_NUM_FORMAT
		    Color.decode("#FF6E6E"), // 37 - ERROR_STRING
		    Color.decode("#FF6E6E")  // 38 - ERROR_CHAR
		};

	private final static Color[] coloresMacOSLight = new Color[] {
		    Color.decode("#ffffff"), // 0 - Fondo base
		    Color.decode("#f2f2f2"), // 1 - Línea actual
		    Color.decode("#000000"), // 2 - Texto principal

		    Color.decode("#0066cc"), // 3 - RESERVED_WORD
		    Color.decode("#ff6f00"), // 4 - DATA_TYPE
		    Color.decode("#008000"), // 5 - STRING
		    Color.decode("#999999"), // 6 - Comentarios
		    Color.decode("#af00db"), // 7 - Números
		    Color.decode("#000000"), // 8 - Operadores
		    Color.decode("#ff3b30"), // 9 - ERROR_IDENTIFIER
		    Color.decode("#c800ff"), // 10 - FUNCIONES
		    Color.decode("#000000"), // 11 - IDENTIFICADORES

		    Color.decode("#cce8ff"), // 12 - Selección
		    Color.decode("#000000"), // 13 - Cursor

		    Color.decode("#ff4081"), // 14 - CHAR
		    Color.decode("#aa00ff"), // 15 - BACKQUOTE
		    Color.decode("#f50057"), // 16 - Otro tipo (regex, etc.)
		    Color.decode("#ffab00"), // 17 - VARIABLE
		    Color.decode("#d500f9"), // 18 - REGEX
		    Color.decode("#651fff"), // 19 - ANNOTATION
		    Color.decode("#000000"), // 20 - IDENTIFIER (again)
		    Color.decode("#ffffff"), // 21 - WHITESPACE
		    Color.decode("#808080"), // 22 - SEPARATOR
		    Color.decode("#000000"), // 23 - OPERATOR
		    Color.decode("#6200ea"), // 24 - PREPROCESSOR
		    Color.decode("#000000"), // 25 - TAG_DELIMITER
		    Color.decode("#1e88e5"), // 26 - TAG_NAME
		    Color.decode("#d32f2f"), // 27 - ATTR
		    Color.decode("#43a047"), // 28 - ATTR_VALUE
		    Color.decode("#9e9e9e"), // 29 - MARKUP_COMMENT
		    Color.decode("#757575"), // 30 - MARKUP_DTD
		    Color.decode("#00acc1"), // 31 - PROC_INSTR
		    Color.decode("#ffcc80"), // 32 - CDATA_DELIMITER
		    Color.decode("#000000"), // 33 - CDATA
		    Color.decode("#689f38"), // 34 - ENTITY_REFERENCE
		    Color.decode("#ff3b30"), // 35 - ERROR_IDENTIFIER
		    Color.decode("#d50000"), // 36 - ERROR_NUM_FORMAT
		    Color.decode("#d50000"), // 37 - ERROR_STRING
		    Color.decode("#d50000")  // 38 - ERROR_CHAR
		};

	private final static Color[] coloresGitHubDarkPlus = new Color[] {
			
	        // 0 a 38 → Basado en DEFAULT_NUM_TOKEN_TYPES
	        Color.decode("#0d1117"), // 0 - Fondo base (GitHub Dark)
	        Color.decode("#161b22"), // 1 - Línea actual
	        Color.decode("#e6edf3"), // 2 - Texto principal

	        Color.decode("#ffea00"), // 3 - RESERVED_WORD 💛
	        Color.decode("#79c0ff"), // 4 - DATA_TYPE
	        Color.decode("#a5d6ff"), // 5 - STRING
	        Color.decode("#8b949e"), // 6 - Comentarios
	        Color.decode("#d2a8ff"), // 7 - NÚMEROS (violeta claro)
	        Color.decode("#ffd700"), // 8 - OPERADORES 💛
	        Color.decode("#f85149"), // 9 - ERROR_IDENTIFIER
	        Color.decode("#f5a1ff"), // 10 - FUNCIONES 💜
	        Color.decode("#c9d1d9"), // 11 - IDENTIFICADORES

	        Color.decode("#264f78"), // 12 - Selección
	        Color.decode("#d4d4d4"), // 13 - Cursor

	        // Extras (para completar hasta 39)
	        Color.decode("#ffcc00"), // 14 - LITERAL_CHAR
	        Color.decode("#ffb86c"), // 15 - BACKQUOTE
	        Color.decode("#ff79c6"), // 16 - Otro tipo (regex, etc.)
	        Color.decode("#f5f5a2"), // 17 - VARIABLE 💛
	        Color.decode("#ff79c6"), // 18 - REGEX
	        Color.decode("#c678dd"), // 19 - ANNOTATION
	        Color.decode("#c9d1d9"), // 20 - IDENTIFIER (de nuevo)
	        Color.decode("#0d1117"), // 21 - WHITESPACE (fondo)
	        Color.decode("#8b949e"), // 22 - SEPARATOR
	        Color.decode("#ffd700"), // 23 - OPERATOR
	        Color.decode("#7fdbca"), // 24 - PREPROCESSOR
	        Color.decode("#c9d1d9"), // 25 - TAG_DELIMITER
	        Color.decode("#79c0ff"), // 26 - TAG_NAME
	        Color.decode("#f2cc60"), // 27 - ATTR
	        Color.decode("#d2a8ff"), // 28 - ATTR_VALUE
	        Color.decode("#6e7681"), // 29 - MARKUP_COMMENT
	        Color.decode("#8b949e"), // 30 - MARKUP_DTD
	        Color.decode("#a5d6ff"), // 31 - PROC_INSTR
	        Color.decode("#ffb86c"), // 32 - CDATA_DELIMITER
	        Color.decode("#c9d1d9"), // 33 - CDATA
	        Color.decode("#7ee787"), // 34 - ENTITY_REFERENCE
	        Color.decode("#f85149"), // 35 - ERROR_IDENTIFIER (repetido para claridad)
	        Color.decode("#ff6e6e"), // 36 - ERROR_NUM_FORMAT
	        Color.decode("#ff6e6e"), // 37 - ERROR_STRING
	        Color.decode("#ff6e6e")  // 38 - ERROR_CHAR
	    };
	
	private final static Color[] coloresRetroTerminal = new Color[] {
		    Color.decode("#000000"), // 0 - Fondo base (negro total)
		    Color.decode("#1c1c1c"), // 1 - Línea actual
		    Color.decode("#00FF00"), // 2 - Texto principal (verde fósforo)

		    Color.decode("#FFFF00"), // 3 - RESERVED_WORD 💛
		    Color.decode("#00FFFF"), // 4 - DATA_TYPE (cian)
		    Color.decode("#FF00FF"), // 5 - STRING 💜
		    Color.decode("#808080"), // 6 - Comentarios
		    Color.decode("#FFA500"), // 7 - Números
		    Color.decode("#FFFFFF"), // 8 - Operadores
		    Color.decode("#FF0000"), // 9 - ERROR_IDENTIFIER
		    Color.decode("#FFFF00"), // 10 - FUNCIONES 💛
		    Color.decode("#00FF00"), // 11 - IDENTIFICADORES

		    Color.decode("#003300"), // 12 - Selección
		    Color.decode("#00FF00"), // 13 - Cursor

		    Color.decode("#FFD700"), // 14 - CHAR
		    Color.decode("#FF1493"), // 15 - BACKQUOTE
		    Color.decode("#DA70D6"), // 16 - Otro tipo
		    Color.decode("#ADFF2F"), // 17 - VARIABLE
		    Color.decode("#FF69B4"), // 18 - REGEX
		    Color.decode("#BA55D3"), // 19 - ANNOTATION
		    Color.decode("#00FF00"), // 20 - IDENTIFIER (again)
		    Color.decode("#000000"), // 21 - WHITESPACE
		    Color.decode("#00FF00"), // 22 - SEPARATOR
		    Color.decode("#FFFFFF"), // 23 - OPERATOR
		    Color.decode("#00FFFF"), // 24 - PREPROCESSOR
		    Color.decode("#00FF00"), // 25 - TAG_DELIMITER
		    Color.decode("#00FFFF"), // 26 - TAG_NAME
		    Color.decode("#FFD700"), // 27 - ATTR
		    Color.decode("#FFB6C1"), // 28 - ATTR_VALUE
		    Color.decode("#A9A9A9"), // 29 - MARKUP_COMMENT
		    Color.decode("#696969"), // 30 - MARKUP_DTD
		    Color.decode("#5F9EA0"), // 31 - PROC_INSTR
		    Color.decode("#FFE4B5"), // 32 - CDATA_DELIMITER
		    Color.decode("#00FF00"), // 33 - CDATA
		    Color.decode("#7CFC00"), // 34 - ENTITY_REFERENCE
		    Color.decode("#FF0000"), // 35 - ERROR_IDENTIFIER
		    Color.decode("#FF4500"), // 36 - ERROR_NUM_FORMAT
		    Color.decode("#FF6347"), // 37 - ERROR_STRING
		    Color.decode("#FF6347")  // 38 - ERROR_CHAR
		};

	
	
	
		public static Color[] getColoresAreaDeCodigo() {
			return coloresMonokai;
		}

		public static Color[] getColoresBarra() {
			Color[] coloresBarra = new Color[] {
					new Color(90, 90, 90),
					Color.decode("#F44747"), // Rojo claro para el botón de cerrar
			};

			return coloresBarra;
		}
			
			
}
