import postfix.Infix;
import postfix.Postfix;
import stack.Underflow;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Infix infixConverter = new Infix();
        Postfix postfixEvaluator = new Postfix();

        System.out.println("Willkommen! Gib einen Infix-Ausdruck ein (z.B. 3 + 4 * 2). 'b' zum Beenden.");

        while (true) {
            System.out.print("Eingabe: ");
            String infix = scanner.nextLine();

            if (infix.equalsIgnoreCase("b")) {
                System.out.println("Programm wird beendet. Tschüss!");
                break;
            }

            try {
                String postfix = infixConverter.toPostfix(infix);
                double result = postfixEvaluator.evaluate(postfix);
                System.out.println("Ergebnis: " + result);
            } catch (Underflow e) {
                System.out.println("Fehler: Stack ist leer. " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Fehler bei der Auswertung: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
