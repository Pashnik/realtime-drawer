package Client;

import Client.Core.Client;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Client client = new Client("localhost", 29288);
        try {
            client.start();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}