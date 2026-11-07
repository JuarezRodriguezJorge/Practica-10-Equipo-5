package poo.unam.practica10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import javax.swing.JOptionPane;

/**
 * Clase principal de la aplicación para el registro y gestión de edades.
 * <p>
 * Proporciona una interfaz gráfica basada en cuadros de diálogo con
 * {@link javax.swing.JOptionPane} complementada con mensajes en la consola estándar.
 * Demuestra el flujo completo de:
 * </p>
 * <ul>
 *   <li>Captura interactiva de la edad.</li>
 *   <li>Conversión y relanzamiento de la misma excepción.</li>
 *   <li>Encadenamiento de excepciones hacia una nueva excepción personalizada ({@link DatoInvalidoException}).</li>
 *   <li>Persistencia del valor en un archivo de texto plano (<code>edades.txt</code>).</li>
 *   <li>Manejo de errores durante la escritura mediante {@link ProcesoException}.</li>
 * </ul>
 *
 * @author Equipo 5
 * @version 1.0
 * @see RelanzamientoNuevaException
 * @see RelanzamientoMismaException
 * @see DatoInvalidoException
 * @see ProcesoException
 */
public class AplicacionCLI {

    /**
     * Constructor por defecto de la clase.
     */
    public AplicacionCLI() {
    }

    /**
     * Punto de entrada principal para la ejecución del programa.
     * <p>
     * Solicita la edad mediante un diálogo interactivo, valida los datos aplicando
     * las reglas de negocio y procede a su almacenamiento en disco, manejando de
     * forma adecuada cualquier excepción generada durante el ciclo de vida del proceso.
     * </p>
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("Registro de edad");
        System.out.println("Iniciando captura...");

        String dato = JOptionPane.showInputDialog(
            null,
            "Ingresa tu edad:",
            "Registro de edad",
            JOptionPane.QUESTION_MESSAGE
        );

        if (dato == null) {
            System.out.println("Captura cancelada.");
            return;
        }

        dato = dato.trim();
        System.out.println("Edad recibida: " + dato);

        try {
            int edad = RelanzamientoNuevaException.validarEdad(dato);
            guardarEdad(edad);

            System.out.println("Edad registrada: " + edad);
            JOptionPane.showMessageDialog(
                null,
                "Edad registrada correctamente: " + edad,
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE
            );

        } catch (DatoInvalidoException e) {
            System.out.println(e.getMessage());
            System.out.println("Causa: " + e.getCause().getClass().getSimpleName());

            JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Dato invalido",
                JOptionPane.ERROR_MESSAGE
            );

        } catch (ProcesoException e) {
            System.out.println(e.getMessage());

            JOptionPane.showMessageDialog(
                null,
                e.getMessage(),
                "Error al guardar",
                JOptionPane.ERROR_MESSAGE
            );
        }

        System.out.println("Proceso terminado.");
    }

    /**
     * Almacena una edad validada en el archivo local de texto <code>edades.txt</code>.
     * <p>
     * Si el archivo no existe, lo crea automáticamente; si ya existe, anexa el
     * nuevo registro al final del archivo. En caso de fallas de entrada/salida (I/O),
     * captura la excepción original y la relanza encapsulada dentro de una
     * {@link ProcesoException}.
     * </p>
     *
     * @param edad Valor numérico entero de la edad a registrar.
     * @throws ProcesoException Si ocurre un error de lectura/escritura durante el guardado.
     */
    private static void guardarEdad(int edad) throws ProcesoException {
        try {
            String registro = "Edad: " + edad + System.lineSeparator();
            Files.writeString(
                Path.of("edades.txt"),
                registro,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.out.println("Ocurrio un problema al guardar.");
            throw new ProcesoException(
                "No fue posible guardar la edad.",
                e
            );
        }
    }
}
