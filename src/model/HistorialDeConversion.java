package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HistorialDeConversion {
    private List<String> registros;

    // Constructor que inicializa registros y carga el historial
    public HistorialDeConversion() {
        this.registros = new ArrayList<>(); // Inicializa la lista
        // Aquí puedes cargar el historial desde el archivo JSON si es necesario
        List<String> historialCargado = GeneradorGson.cargarHistorial();
        if (historialCargado != null) {
            registros.addAll(historialCargado); // Agrega registros cargados
        }
    }

    public void agregarRegistro(double cantidad, String monedaOrigen, double resultado, String monedaDestino) {
        String registro = String.format("[Fecha: %s] %.2f %s -> %.2f %s",
                LocalDateTime.now(), cantidad, monedaOrigen, resultado, monedaDestino);
        registros.add(registro);
        GeneradorGson.guardarHistorial(registros);
    }

    public void mostrarHistorial() {
        if (registros.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
        } else {
            System.out.println("\n--- Historial de Conversiones ---");
            for (String registro : registros) {
                System.out.println(registro);
            }
        }
    }
}
