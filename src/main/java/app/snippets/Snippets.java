package app.snippets;

import org.fife.ui.autocomplete.*;

public class Snippets {
	
	public static CompletionProvider createCompletionProvider() {
		DefaultCompletionProvider provider = new DefaultCompletionProvider();

        // Métodos principales
        provider.addCompletion(new ShorthandCompletion(provider, "main",
            "public static void main(String[] args) {\n\t$cursor$\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "public",
            "public ${ReturnType} ${methodName}(${params}) {\n\t$cursor$\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "init",
            "public ${ClassName}(${params}) {\n\t$cursor$\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "return",
            "return $cursor$;"));

        // Impresiones
        provider.addCompletion(new ShorthandCompletion(provider, "sysout",
            "System.out.println($cursor$);"));

        provider.addCompletion(new ShorthandCompletion(provider, "syserr",
            "System.err.println($cursor$);"));

        // Estructuras de control
        provider.addCompletion(new ShorthandCompletion(provider, "if",
            "if (${condition}) {\n\t$cursor$\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "else",
            "else {\n\t$cursor$\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "ifelse",
            "if (${condition}) {\n\t$cursor$\n} else {\n\t\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "switch",
            "switch (${variable}) {\n\tcase ${value}:\n\t\t$cursor$\n\t\tbreak;\n\tdefault:\n\t\tbreak;\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "while",
            "while (${condition}) {\n\t$cursor$\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "do",
            "do {\n\t$cursor$\n} while (${condition});"));

        provider.addCompletion(new ShorthandCompletion(provider, "fori",
            "for (int i = 0; i < ${n}; i++) {\n\t$cursor$\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "foreach",
            "for (${Type} ${item} : ${collection}) {\n\t$cursor$\n}"));

        // Clases y estructuras
        provider.addCompletion(new ShorthandCompletion(provider, "class",
            "public class ${ClassName} {\n\t$cursor$\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "interface",
            "public interface ${InterfaceName} {\n\t$cursor$\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "enum",
            "public enum ${EnumName} {\n\t${ITEM1}, ${ITEM2};\n\t$cursor$\n}"));

        // Excepciones
        provider.addCompletion(new ShorthandCompletion(provider, "trycatch",
            "try {\n\t$cursor$\n} catch (${Exception} e) {\n\te.printStackTrace();\n}"));

        provider.addCompletion(new ShorthandCompletion(provider, "tryresources",
            "try (${Resource res = new Resource()}) {\n\t$cursor$\n} catch (${Exception} e) {\n\te.printStackTrace();\n}"));

        // Utilidades comunes
        provider.addCompletion(new ShorthandCompletion(provider, "scanner",
            "Scanner sc = new Scanner(System.in);"));

        provider.addCompletion(new ShorthandCompletion(provider, "arraylist",
            "ArrayList<${Type}> list = new ArrayList<>();"));

        // Palabras clave
        provider.addCompletion(new ShorthandCompletion(provider, "package",
            "package ${your.package.name};"));

        provider.addCompletion(new ShorthandCompletion(provider, "import",
            "import ${package.ClassName};"));

        provider.addCompletion(new ShorthandCompletion(provider, "staticimport",
            "import static ${package.ClassName}.*;"));

        provider.addCompletion(new ShorthandCompletion(provider, "this",
            "this.$cursor$;"));

        provider.addCompletion(new ShorthandCompletion(provider, "super",
            "super($cursor$);"));

        return provider;
	}
	
	

}
