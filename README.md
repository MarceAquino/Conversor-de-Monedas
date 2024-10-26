# Conversor de Monedas en Java

## Descripción
Este proyecto es un conversor de monedas simple implementado en Java. Permite a los usuarios convertir cantidades de una moneda a otra utilizando tasas de cambio obtenidas a través de una API. Además, guarda un historial de conversiones y permite agregar nuevas monedas al sistema.

## Características
- Conversión de varias monedas como Dólar estadounidense, Euro, Bolívar venezolano, Peso argentino, Yuan chino y Peso dominicano.
- Agregar nuevas monedas al menú de opciones.
- Mostrar historial de conversiones.
- Interfaz de consola fácil de usar.
- Manejo de errores y validaciones en la entrada del usuario.
- Guardado y carga del historial de conversiones en un archivo JSON utilizando Gson.

## Requisitos
- Java 22
- Dependencia de Gson para la manipulación de JSON

## Estructura del Proyecto
- **model/**: Contiene las clases del modelo, incluyendo `MonedaAConvertir`, `HistorialDeConversion` y `GeneradorGson`.
- **exception/**: Contiene excepciones personalizadas, como `ConversionException`.
- **Main.java**: Punto de entrada de la aplicación que gestiona el flujo del programa y la interacción con el usuario.

## Cómo Usar
1. Clona este repositorio en tu máquina local: `git clone <URL del repositorio>`
2. Navega al directorio del proyecto: `cd <nombre-del-directorio>`
3. Compila el proyecto: `javac -d out -cp lib/gson-2.8.9.jar src/Main.java src/model/*.java src/exception/*.java`
4. Ejecuta la aplicación: `java -cp out:lib/gson-2.8.9.jar Main`

## Uso de la Aplicación
- Al iniciar la aplicación, se mostrará un menú con las monedas disponibles.
- Selecciona una moneda para convertir y luego ingresa la cantidad a convertir.
- Selecciona la moneda de destino y se mostrará el resultado de la conversión.
- Puedes agregar nuevas monedas y mostrar el historial de conversiones desde el menú.

## Contribuciones
Las contribuciones son bienvenidas. Si deseas contribuir, por favor sigue estos pasos: realiza un fork del proyecto, crea una nueva rama para tu funcionalidad o corrección de errores, realiza tus cambios y realiza un commit, y envía un pull request.

## Licencia
Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
