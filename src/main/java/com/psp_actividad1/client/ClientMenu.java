package com.psp_actividad1.client;

import java.util.Scanner;

/**
 * Esta clase esta creada para gestionar la interacción entre el usuario y la aplicación.
 */
public class ClientMenu {
    /**
     * declaramos el atributo dónde vamos a instanciar la clase Client que se encarga de la comunicación con el servidor.
     * La declaramos cómo final para evitar que se reasigne a otra instancia y así mantener la conexión.
     */
    private final Client client;

    public ClientMenu(Client client) {
        /**
         * recibimos el la instancia de cliente y la asignamos al atributo interno
         */
        this.client = client;
    }

    /**
     * al iniciar este método mostramos en consola las opciones de uso que tiene el usuario.
     * Capturamos los comandos ingresador por el usuario y ejecutamos los métodos correspondientes a
     * la opción elegida por el usuario gracias al switch case
     */
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        String option;

        System.out.println("Aplicación de libreria!");
        do {
            printOptions();
            System.out.print("Seleccione una opción: ");
            option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    findBookByIsbn(scanner);
                    break;
                case "2":
                    findBooksByTitle(scanner);
                    break;
                case "3":
                    findBooksByAuthor(scanner);
                    break;
                case "4":
                    addBook(scanner);
                    break;
                case "x":
                    System.out.println("Saliendo de la aplicación!");
                    break;
                default:
                    System.out.println("No se encuentra la opción seleccionada. Seleccione una opción valida.");
            }
        } while (!option.equals("x"));
    }

    /**
     * Mostramos en consola las opciones.
     */
    private void printOptions() {
        System.out.println("\nOpciones:");
        System.out.println("1. Encontrar libro por ISBN");
        System.out.println("2. Encontrar libro por título");
        System.out.println("3. Encontrar libro por autor");
        System.out.println("4. Añadir un nuevo libro");
        System.out.println("x. Salir");
    }

    /**
     * en los siguientes métodos capturamos los parametros ingresados por el usuario en consola para poder enviarlos
     * al servidor a travez de la instancia de client apuntando a su método .sendCommand()
     * @param scanner
     */
    private void findBookByIsbn(Scanner scanner) {
        System.out.print("Ingrese el ISBN: ");
        String isbn = scanner.nextLine().trim();
        String response = client.sendCommand("GET_BY_ISBN, " + isbn);
        System.out.println("Respuesta: " + response);
    }

    private void findBooksByTitle(Scanner scanner) {
        System.out.print("Ingrese title: ");
        String title = scanner.nextLine().trim();
        String response = client.sendCommand("GET_BY_TITLE, " + title);
        System.out.println("Respuesta: " + response);
    }

    private void findBooksByAuthor(Scanner scanner) {
        System.out.print("Ingrese author: ");
        String author = scanner.nextLine().trim();
        String response = client.sendCommand("GET_BY_AUTHOR, " + author);
        System.out.println("Respuesta: " + response);
    }

    private void addBook(Scanner scanner) {
        System.out.print("Ingrese ISBN: ");
        String isbn = scanner.nextLine().trim();
        System.out.print("Ingrese title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Ingrese author: ");
        String author = scanner.nextLine().trim();
        System.out.print("Ingrese price: ");
        String price = scanner.nextLine().trim();

        String response = client.sendCommand("ADD_BOOK, " + isbn + " " + title + " " + author + " " + price);
        System.out.println("Respuesta: " + response);
    }
}
