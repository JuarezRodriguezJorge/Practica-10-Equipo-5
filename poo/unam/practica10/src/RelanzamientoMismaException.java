package poo.unam.practica10;

/**
 * Clase que ilustra el patrón de captura y <b>relanzamiento de la misma excepción</b>.
 * <p>
 * En este patrón, el bloque {@code catch} intercepta una excepción para realizar
 * acciones intermedias (como registro en consola, diagnóstico o auditoría) y
 * posteriormente la vuelve a lanzar utilizando la instrucción {@code throw e},
 * permitiendo que un manejador superior decida cómo gestionarla finalmente.
 * </p>
 *
 * @author Equipo 5
 * @version 1.0
 */
public class RelanzamientoMismaException {

    /**
     * Constructor por defecto de la clase.
     */
    public RelanzamientoMismaException() {
    }

    /**
     * Convierte una cadena de texto a un valor numérico entero que representa una edad.
     * <p>
     * Si la cadena no contiene un formato numérico válido, captura la excepción
     * {@link java.lang.NumberFormatException}, emite mensajes informativos a la
     * salida estándar y relanza exactamente la misma excepción capturada.
     * </p>
     *
     * @param texto Cadena con el valor de edad a convertir.
     * @return El valor entero correspondiente a la edad.
     * @throws NumberFormatException Si la cadena {@code texto} no puede ser analizada
     *                               como un número entero válido.
     */
    public static int convertirEdad(String texto) {
        try {
            int edad = Integer.parseInt(texto);
            System.out.println("Edad convertida correctamente.");
            return edad;
        } catch (NumberFormatException e) {
            System.out.println("El dato ingresado no es un numero.");
            System.out.println("Se vuelve a lanzar la excepcion.");
            throw e;
        }
    }
}
