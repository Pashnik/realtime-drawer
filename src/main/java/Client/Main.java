package Client;

import Client.Core.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            Client client = new Client("localhost", 29288);
            client.getMessages();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
