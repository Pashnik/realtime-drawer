package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 29288);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
