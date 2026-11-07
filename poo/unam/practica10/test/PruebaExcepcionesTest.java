package poo.unam.practica10;

/**
 * Clase de pruebas automatizadas y verificación de casos para la Práctica 10.
 * <p>
 * Valida los distintos escenarios de manejo y relanzamiento de excepciones:
 * </p>
 * <ul>
 *   <li>Caso exitoso: edad válida en el rango permitido.</li>
 *   <li>Caso error formato: cadena no numérica (relanzamiento de {@link NumberFormatException}).</li>
 *   <li>Caso error rango: edad negativa o mayor a 120 (lanzamiento de {@link DatoInvalidoException}).</li>
 * </ul>
 *
 * @author Equipo 5
 * @version 1.0
 */
public class PruebaExcepcionesTest {

    /**
     * Ejecuta una serie de pruebas de consola para verificar el comportamiento
     * de las clases de validación de edad y relanzamiento de excepciones.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        System.out.println("=== INICIO DE PRUEBAS DE EXCEPCIONES (EQUIPO 5) ===");

        probarEdadValida("25");
        probarFormatoInvalido("veinticinco");
        probarRangoInvalido("-5");
        probarRangoInvalido("150");

        System.out.println("=== FIN DE PRUEBAS ===");
    }

    private static void probarEdadValida(String entrada) {
        System.out.println("\n[PRUEBA 1] Validando edad correcta: '" + entrada + "'");
        try {
            int edad = RelanzamientoNuevaException.validarEdad(entrada);
            System.out.println("-> ÉXITO: Edad validada = " + edad);
        } catch (DatoInvalidoException e) {
            System.err.println("-> FALLO INESPERADO: " + e.getMessage());
        }
    }

    private static void probarFormatoInvalido(String entrada) {
        System.out.println("\n[PRUEBA 2] Validando formato inválido: '" + entrada + "'");
        try {
            RelanzamientoNuevaException.validarEdad(entrada);
            System.err.println("-> FALLO: Se esperaba DatoInvalidoException pero no ocurrió.");
        } catch (DatoInvalidoException e) {
            System.out.println("-> ÉXITO: Se capturó DatoInvalidoException correctamente.");
            System.out.println("   Mensaje: " + e.getMessage());
            System.out.println("   Causa raíz: " + e.getCause().getClass().getName());
        }
    }

    private static void probarRangoInvalido(String entrada) {
        System.out.println("\n[PRUEBA 3] Validando rango fuera de límites: '" + entrada + "'");
        try {
            RelanzamientoNuevaException.validarEdad(entrada);
            System.err.println("-> FALLO: Se esperaba DatoInvalidoException pero no ocurrió.");
        } catch (DatoInvalidoException e) {
            System.out.println("-> ÉXITO: Se capturó DatoInvalidoException por rango fuera de límites.");
            System.out.println("   Mensaje: " + e.getMessage());
            System.out.println("   Causa: " + e.getCause().getClass().getName());
        }
    }
}
