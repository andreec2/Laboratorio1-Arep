import org.example.HttpServer;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.*;

public class ClientHandlerTest {

    private Thread serverThread;
    @Test
    public void setUp() {
        // Iniciar el servidor en un hilo separado
        serverThread = new Thread(() -> HttpServer.startServer());
        serverThread.start();

        // Esperar un poco para asegurarnos de que el servidor se inicie
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        // Detener el servidor después de cada prueba
        HttpServer.stopServer();
    }

    @Test
    public void testGetRequest() throws IOException {
        // Conecta al servidor
        try (Socket socket = new Socket("localhost", 35000)) {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            // Enviar solicitud GET
            out.write("GET /index.html HTTP/1.1\r\n".getBytes());
            out.write("Host: localhost\r\n".getBytes());
            out.write("\r\n".getBytes());
            out.flush();

            // Leer la respuesta
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String responseLine = reader.readLine();
            assertNotNull(responseLine);
            assertTrue(responseLine.contains("200 OK")); // Verificar que la respuesta contiene "200 OK"
        }
    }

    @Test
    public void testPostRequest() throws IOException {
        // Conecta al servidor
        try (Socket socket = new Socket("localhost", 35000)) {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            // Enviar solicitud POST
            String body = "name=John&age=30";
            out.write("POST /submit HTTP/1.1\r\n".getBytes());
            out.write("Host: localhost\r\n".getBytes());
            out.write("Content-Type: application/x-www-form-urlencoded\r\n".getBytes());
            out.write(("Content-Length: " + body.length() + "\r\n").getBytes());
            out.write("\r\n".getBytes());
            out.write(body.getBytes());
            out.flush();

            // Leer la respuesta
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String responseLine = reader.readLine();
            assertNotNull(responseLine);
            assertTrue(responseLine.contains("200 OK")); // Verificar que la respuesta contiene "200 OK"
        }
    }

    @Test
    public void testFileNotFound() throws IOException {
        // Conecta al servidor
        try (Socket socket = new Socket("localhost", 35000)) {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            // Enviar solicitud GET para un archivo inexistente
            out.write("GET /notfound.html HTTP/1.1\r\n".getBytes());
            out.write("Host: localhost\r\n".getBytes());
            out.write("\r\n".getBytes());
            out.flush();

            // Leer la respuesta
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String responseLine = reader.readLine();
            assertNotNull(responseLine);
            assertTrue(responseLine.contains("404 Not Found")); // Verificar que contiene "404 Not Found"
        }
    }
}
