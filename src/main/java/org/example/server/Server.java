package org.example.server;

import org.example.server.dao.PlayerDAO;
import org.example.server.dao.QuestionDAO;
import org.example.server.games.Player;
import org.example.server.questions.Question;

import java.util.List;
import java.util.Scanner;

public class Server {


    public static void startServer(){
        new Thread(new ServerClient()).start();
        System.out.println("Servidor iniciado en el puerto 48120...");
    }
    public static void printMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Arrancar el servidor");
        System.out.println("2. Consultar el histórico de jugadas");
        System.out.println("3. Consultar el top10 de jugadas");
        System.out.println("4. Resetear resultados");
        System.out.println("5. Preguntas más difíciles y más fáciles");
        System.out.println("6. Creación de jugadore");
        System.out.println("7. Salir");
        System.out.print("Selecciona una opción: ");
    }
    public static void showTopQuestions(){
        List<Question> harderQuestions = QuestionDAO.getTop5HarderQuestions();
        List<Question>easierQuestions = QuestionDAO.getTop5EasierQuestions();
    }
    public static void createPlayer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Creación de jugador");
        System.out.println("Introduce el nombre");
        String name = sc.nextLine();
        System.out.println("Introduce la contraseña");
        String pass = sc.nextLine();
        Player player = new Player(name,pass);
        PlayerDAO.create(player);
    }
    
    public static void main(String[] args) {
        printMenu();
        Scanner sc = new Scanner(System.in);
        boolean exit=false;

        while(!exit){
        String option = sc.nextLine();
        switch (option){
            case "1":
                startServer();
                break;
            case "2":
                //showHistory();
                break;
            case "3":
                //showTop10();
                break;
            case "4":
                //resetResults();
                break;
            case "5":
                showTopQuestions();

                break;
            case "6":
                createPlayer();
                break;
            case "7":
                exit=true;
                System.out.println("Saliendo del programa.");
                break;
            default:
                System.out.println("Opcion inexistente");
                break;
            }
        }
    }
}
