import model.HistorialDeConversion;
import model.MonedaAConvertir;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Lista de monedas disponibles en el menú
    private static List<String> monedasDisponibles = new ArrayList<>();
    private static HistorialDeConversion historial = new HistorialDeConversion();
    private static Scanner scanner = new Scanner(System.in);

    // Formato de salida para la conversión
    private static final String FORMATO_SALIDA = "%.2f %s son %.2f %s\n";

    static {
        monedasDisponibles.add("USD - Dólar estadounidense");
        monedasDisponibles.add("EUR - Euro");
        monedasDisponibles.add("VES - Bolívar venezolano");
        monedasDisponibles.add("ARS - Peso argentino");
        monedasDisponibles.add("CNY - Yuan chino");
        monedasDisponibles.add("DOP - Peso dominicano");
    }

    public static void mostrarMenu(String titulo) {
        int ancho = 35;
        System.out.println("\n" + "*".repeat(ancho));
        System.out.println(titulo);

        for (int i = 0; i < monedasDisponibles.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, monedasDisponibles.get(i));
        }

        System.out.println((monedasDisponibles.size() + 1) + ". Agregar nueva moneda");
        System.out.println((monedasDisponibles.size() + 2) + ". Mostrar historial de conversiones");
        System.out.println((monedasDisponibles.size() + 3) + ". Salir");
        System.out.println("*".repeat(ancho));
        System.out.print("Seleccione una opción: ");
    }

    private static double leerCantidad() {
        while (true) {
            System.out.print("Ingrese la cantidad a convertir: ");
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }

    public static void agregarMoneda() {
        System.out.print("Ingrese el código y nombre de la nueva moneda (ej: JPY - Yen japonés): ");
        String nuevaMoneda = scanner.nextLine();

        monedasDisponibles.add(nuevaMoneda);
        System.out.println("Moneda agregada exitosamente.");
    }

    public static void convertirMoneda(String monedaOrigen) {
        double cantidad = leerCantidad();

        mostrarMenu("Seleccione la moneda de destino");

        // Asegúrate de leer la opción como String y luego convertir
        int opcionDestino;
        String entradaDestino = scanner.nextLine();

        try {
            opcionDestino = Integer.parseInt(entradaDestino); // Convertir a int
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Debe ser un número.");
            return; // Salir de la función
        }

        // Asegúrate de que la opción esté dentro del rango válido
        if (opcionDestino < 1 || opcionDestino > monedasDisponibles.size()) {
            System.out.println("Opción no válida.");
            return;
        }

        // Obtener la moneda de destino
        String monedaDestino = monedasDisponibles.get(opcionDestino - 1).split(" ")[0];

        try {
            double tasa = MonedaAConvertir.obtenerTasaDeCambio(monedaOrigen, monedaDestino);
            double resultado = cantidad * tasa;
            System.out.printf(FORMATO_SALIDA, cantidad, monedaOrigen, resultado, monedaDestino);

            // Guardar la conversión en el historial
            historial.agregarRegistro(cantidad, monedaOrigen, resultado, monedaDestino);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu("Menú de Opciones");
            String entrada = scanner.nextLine(); // Leer la entrada como String

            // Verificar si el usuario quiere salir
            if (entrada.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo de la aplicación...");
                break; // Romper el bucle
            }

            try {
                opcion = Integer.parseInt(entrada); // Convertir la entrada a int
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Intente de nuevo.");
                continue; // Regresar al inicio del bucle
            }

            switch (opcion) {
                case 1: case 2: case 3: case 4: case 5: case 6:
                    String monedaOrigen = monedasDisponibles.get(opcion - 1).split(" ")[0];
                    convertirMoneda(monedaOrigen);
                    break;
                case 7:
                    agregarMoneda();
                    break;
                case 8:
                    historial.mostrarHistorial();
                    break;
                case 9:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (true);

        scanner.close();
    }

}
