package com.psp_actividad1.client;

/**
 * Punto de entrada a la aplicación su único proposito es iniciar las clases necesarias para ejecutar el cliente
 * y conectarlos con el servidor
 */
public class Main {

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int serverPort = 8080;

        Client client = new Client(serverAddress, serverPort);
        ClientMenu menu = new ClientMenu(client);
        menu.showMenu();
    }
}
