package model;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MonedaAConvertir {
    private static final String API_KEY = "aa2bec6e6841299708f4d5c3";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static double obtenerTasaDeCambio(String monedaOrigen, String monedaDestino) throws IOException, InterruptedException {
        String url = API_URL + monedaOrigen;

        // Crear cliente HTTP
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Enviar solicitud y recibir respuesta
        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        // Parsear respuesta JSON
        JsonObject jsonRespuesta = JsonParser.parseString(respuesta.body()).getAsJsonObject();

        if (!jsonRespuesta.get("result").getAsString().equals("success")) {
            throw new IOException("Error al obtener los datos de la tasa de cambio");
        }

        // Devolver la tasa de cambio para la moneda de destino
        return jsonRespuesta.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();
    }
}
