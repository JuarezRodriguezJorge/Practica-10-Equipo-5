package poo.unam.practica10;

/**
 * Clase que ilustra el patrón de captura y <b>relanzamiento de una nueva excepción</b>
 * (también conocido como <i>exception wrapping</i> o <i>encadenamiento de excepciones</i>).
 * <p>
 * En este enfoque, una excepción técnica de bajo nivel o genérica se captura y se
 * transforma en una excepción de dominio más significativa (en este caso,
 * {@link DatoInvalidoException}), preservando la causa original para fines de depuración.
 * </p>
 *
 * @author Equipo 5
 * @version 1.0
 * @see DatoInvalidoException
 * @see RelanzamientoMismaException
 */
public class RelanzamientoNuevaException {

    /**
     * Constructor por defecto de la clase.
     */
    public RelanzamientoNuevaException() {
    }

    /**
     * Valida que la cadena ingresada corresponda a una edad válida en el rango
     * de 0 a 120 años inclusive.
     * <p>
     * Utiliza internamente {@link RelanzamientoMismaException#convertirEdad(String)}
     * para la conversión a número entero. Si la edad está fuera de los límites o si el
     * formato no es válido, se captura la excepción correspondiente y se relanza como
     * una {@link DatoInvalidoException}.
     * </p>
     *
     * @param texto Cadena recibida del usuario que contiene la edad.
     * @return La edad validada como número entero dentro del rango permitido [0, 120].
     * @throws DatoInvalidoException Si el texto no es numérico o si el valor numérico
     *                               se encuentra fuera del intervalo [0, 120].
     */
    public static int validarEdad(String texto) throws DatoInvalidoException {
        try {
            int edad = RelanzamientoMismaException.convertirEdad(texto);

            if (edad < 0 || edad > 120) {
                throw new IllegalArgumentException(
                    "La edad debe estar entre 0 y 120."
                );
            }

            return edad;
        } catch (IllegalArgumentException e) {
            throw new DatoInvalidoException(
                "No se pudo registrar la edad. Verifica el dato.",
                e
            );
        }
    }
}
