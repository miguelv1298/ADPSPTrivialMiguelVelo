package org.example.cliente;



import org.example.server.games.Game;
import org.example.server.questions.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{
    private Socket socket;
    private Game game;
    private Question[] questions;

    public static void main(String[] args) {
        try {

            // 1 y 2. Creación del socket, se conecta al servidor a su IP y puerto.

            // Se deja que el SO asigne el puerto del cliente.
            Socket socket = new Socket("localhost", 49153);
            System.out.println("Conexión establecida");

            //3. Envío y recepción de mensajes. Se redireccionan E/S.
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Leo del servidor
            System.out.println(br.readLine());

            // Escribo
            pw.println("Soy");

            // Leo
            System.out.println(br.readLine());

            //4. Cierre de la conexión. Se cierran los streams asociados al socket.
            socket.close();
        } catch (IOException e) {
            System.err.println("Error al crear el socket: " +
                    e.getMessage());
        }
    }
}
