package esercitazione2;

import java.util.Scanner;

public class Esercizio1 {
    public static void main(String args[]) {

        Scanner kbInput = new Scanner(System.in);
        int Nparole;

        System.out.println("Inserisci il numero di parole che vuoi inserire:");

        Nparole = kbInput.nextInt();

        String parolaInserita;

        while (Nparole != 0) {
            System.out.print("Inserisci la parola:");
            parolaInserita = kbInput.next();
            if (parolaInserita.length() < 3) {
                System.out.println("Parola corta");
            }
            else if (parolaInserita.length() >= 3 && parolaInserita.length() < 8) {
                System.out.println("Parola di media lunghezza");
            }
            else{
                System.out.println("Parola lunga");
            }
            Nparole--;
            System.out.println();
        }

        System.out.println("Parole finite: Programma terminato...");

        kbInput.close();

    }
}