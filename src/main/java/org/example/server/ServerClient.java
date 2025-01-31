package org.example.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClient implements Runnable {
    private int port;

    @Override
    public void run() {
                try {
                    // 1, 2 y 3. Creación del socket servidor ServerSocket.
                    // Se hace la operación de binding (IP y puerto)
                    // El servidor escucha por la IP y el puerto asignado
                    ServerSocket server = new ServerSocket(49153);

                    // 4. Acepta conexión de cliente.
                    // accept es espera bloqueante hasta que llega conexión
                    System.out.println("Aceptando conexiones de clientes...");
                    Socket cliente = server.accept();
                    System.out.println("Conexión establecida con el cliente");

                    // 5. Envío y recepción de mensajes.
                    // Redirección de E/S del socket cliente para comunicarse
                    PrintWriter pw = new PrintWriter(cliente.getOutputStream(), true);// autoflush
                    BufferedReader br = new BufferedReader(new
                            InputStreamReader(cliente.getInputStream()));
                    // Envío mensaje al cliente
                    pw.println("Hola, soy el servidor");
                    // Recibo mensaje del cliente
                    String m = br.readLine();
                    System.out.println("-->" + m);
                    // Envío mensaje al cliente
                    pw.println("Tu cadena tiene " + m.length() + " chars.");
                    // 6. Cierre de la conexión
                    // Lleva implícito el cierre de InputStream y OutputSream

                    cliente.close();
                    server.close();
                } catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        }


