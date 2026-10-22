package client;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import operation.*;
public class client {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Donner le premier opérande : ");
            double operande1 = scanner.nextDouble();

            System.out.print("Donner l'opérateur (+, -, *, /) : ");
            String operateur = scanner.next();

            System.out.print("Donner le deuxième opérande : ");
            double operande2 = scanner.nextDouble();

            operation operation = new operation(operande1, operateur, operande2);

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            output.writeObject(operation);
            output.flush();

            System.out.println("Objet envoyé au serveur.");

            Double resultat = (Double) input.readObject();

            System.out.println("Résultat reçu : " + resultat);

            input.close();
            output.close();
            socket.close();
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}