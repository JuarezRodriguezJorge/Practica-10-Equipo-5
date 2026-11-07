package poo.unam.practica10;

/**
 * Excepción personalizada que indica un fallo ocurrido durante el procesamiento,
 * persistencia o almacenamiento de datos en la aplicación.
 * <p>
 * Permite abstraer excepciones de bajo nivel (como {@link java.io.IOException})
 * para presentar un mensaje comprensible y mantener el registro del error original
 * mediante encadenamiento de excepciones.
 * </p>
 *
 * @author Equipo 5
 * @version 1.0
 * @see java.lang.Exception
 */
public class ProcesoException extends Exception {

    /**
     * Construye una nueva excepción {@code ProcesoException} con el mensaje
     * descriptivo y la causa original especificados.
     *
     * @param mensaje Mensaje descriptivo que detalla el problema ocurrido.
     * @param causa   La causa raíz del problema (por ejemplo, una excepción de E/S),
     *                o {@code null} si no existe o se desconoce.
     */
    public ProcesoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
