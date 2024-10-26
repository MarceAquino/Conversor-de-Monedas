package model;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<String> monedasDisponibles;
    private HistorialDeConversion historial;

    public Menu(List<String> monedasDisponibles, HistorialDeConversion historial) {
        this.monedasDisponibles = monedasDisponibles;
        this.historial = historial;
    }

    public void mostrarMenu() {
        int ancho = 35;
        System.out.println("\n" + "*".repeat(ancho));
        System.out.println("Menú de Opciones");

        for (int i = 0; i < monedasDisponibles.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, monedasDisponibles.get(i));
        }

        System.out.println((monedasDisponibles.size() + 1) + ". Agregar nueva moneda");
        System.out.println((monedasDisponibles.size() + 2) + ". Mostrar historial de conversiones");
        System.out.println((monedasDisponibles.size() + 3) + ". Salir");
        System.out.println("*".repeat(ancho));
        System.out.print("Seleccione una opción: ");
    }

    public int validarOpcion() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= 1 && opcion <= monedasDisponibles.size() + 3) {
                    return opcion;
                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
    }

    public void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1: // Opción 1
                // Manejar conversión de moneda
                break;
            case 2: // Opción 2
                agregarMoneda();
                break;
            case 3: // Opción 3
                historial.mostrarHistorial();
                break;
            case 4: // Opción de salir
                System.out.println("Saliendo de la aplicación...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public void agregarMoneda() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código y nombre de la nueva moneda (ej: JPY - Yen japonés): ");
        String nuevaMoneda = scanner.nextLine();
        monedasDisponibles.add(nuevaMoneda);
        System.out.println("Moneda agregada exitosamente.");
    }
}
