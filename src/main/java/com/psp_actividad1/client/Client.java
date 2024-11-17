package com.psp_actividad1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Esta clase es la responsable de manejar la comunicación entre el cliente y el servidor.
 * Principalmente manda los comandos capturados de la consola al servidor y recibe las respuestas de este.
 */
public class Client {
    private final String serverAddress;
    private final int serverPort;

    public Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public String sendCommand(String command) {
        /**
         * Creamos la conexión con el servidor utilizando la dirección y el puerto definisods. new Socket(serverAddress, serverPort)
         * new BufferedReader(new InputStreamReader(socket.getInputStream())) lee las respuestas enviadas por el servidor
         * new PrintWriter(socket.getOutputStream(), true) envía los comandos al servidor
         */
        try (
                Socket socket = new Socket(serverAddress, serverPort);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)
        ) {
            writer.println(command);
            return reader.readLine();
        } catch (IOException e) {
            return "Error: no se ha podido comunicar con el servidor";
        }
    }
}
