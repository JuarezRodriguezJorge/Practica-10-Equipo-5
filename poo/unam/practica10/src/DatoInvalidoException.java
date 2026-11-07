package poo.unam.practica10;

/**
 * Excepción personalizada que indica que un dato ingresado no cumple con
 * los criterios o el formato esperado por el sistema.
 * <p>
 * Esta excepción se utiliza para encapsular y encadenar errores originados
 * durante la conversión y validación de datos de entrada (por ejemplo,
 * {@link java.lang.NumberFormatException} o {@link java.lang.IllegalArgumentException}).
 * </p>
 *
 * @author Equipo 5
 * @version 1.0
 * @see java.lang.Exception
 */
public class DatoInvalidoException extends Exception {

    /**
     * Construye una nueva excepción {@code DatoInvalidoException} con el mensaje
     * descriptivo y la causa original especificados.
     *
     * @param mensaje Mensaje descriptivo que explica la razón del error.
     * @param causa   La causa subyacente del error (otra excepción encadenada),
     *                o {@code null} si no existe o se desconoce.
     */
    public DatoInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
