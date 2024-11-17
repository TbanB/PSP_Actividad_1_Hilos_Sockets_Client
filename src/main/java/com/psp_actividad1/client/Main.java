package com.psp_actividad1.client;

public class Main {

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int serverPort = 8080;

        Client client = new Client(serverAddress, serverPort);
        ClientMenu menu = new ClientMenu(client);
        menu.showMenu();
    }
}
