package Serveur;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import operation.*;
import client.*;

public class Serveur {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Serveur démarré...");
            System.out.println("En attente d'un client...");

            Socket socket = serverSocket.accept();

            System.out.println("Client connecté.");

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            operation operation = (operation) input.readObject();

            System.out.println("Objet reçu :");
            System.out.println(
                    operation.getOperande1() + " "
                            + operation.getOperateur() + " "
                            + operation.getOperande2()
            );

            double resultat = 0;

            switch (operation.getOperateur()) {

                case "+":
                    resultat =
                            operation.getOperande1()
                                    + operation.getOperande2();
                    break;

                case "-":
                    resultat =
                            operation.getOperande1()
                                    - operation.getOperande2();
                    break;

                case "*":
                    resultat =
                            operation.getOperande1()
                                    * operation.getOperande2();
                    break;

                case "/":

                    if (operation.getOperande2() != 0) {
                        resultat =
                                operation.getOperande1()
                                        / operation.getOperande2();
                    } else {
                        System.out.println("Division par zéro impossible.");
                    }

                    break;

                default:
                    System.out.println("Opérateur invalide.");
            }

            output.writeObject(resultat);
            output.flush();

            System.out.println("Résultat envoyé : " + resultat);

            input.close();
            output.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}