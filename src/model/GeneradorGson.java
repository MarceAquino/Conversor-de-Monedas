package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GeneradorGson {
    private static final String HISTORIAL_FILE = "historial.json";
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void guardarHistorial(List<String> historial) {
        try (Writer writer = new FileWriter(HISTORIAL_FILE)) {
            GSON.toJson(historial, writer);
        } catch (IOException e) {
            System.err.println("Error al guardar el historial: " + e.getMessage());
        }
    }

    public static List<String> cargarHistorial() {
        try (Reader reader = new FileReader(HISTORIAL_FILE)) {
            return GSON.fromJson(reader, List.class);
        } catch (IOException e) {
            System.err.println("Error al cargar el historial: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

