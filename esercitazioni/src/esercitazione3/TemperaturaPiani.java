package esercitazione3;

// Runnare il codice attraverso java TemperaturaPiani Nome Cognome (dell'utente)
import java.util.Scanner;

public class TemperaturaPiani {

    public static void main(String args[]) {

        System.out.println("Benvenuto " + args[0] + " " + args[1] + "!");
        Scanner kbInput = new Scanner(System.in);

        double[] tempMedia = new double[7];

        double[] personeMediaPiano = {400, 300, 200, 100, 60, 18, 18, 16};

        for (int i = 0; i < 7; i++) {
            System.out.println("Temperatura media per il piano: " + i);
            tempMedia[i] = kbInput.nextDouble();
        }

        double[] punteggiPiani = new double[7];
        double punteggioMax;
        int pianoCounter = 0;

        punteggiPiani[0] = tempMedia[0] * personeMediaPiano[0];

        punteggioMax = punteggiPiani[0];

        for (int i = 1; i < 7; i++) {
            double punteggioMaxTmp;
            punteggiPiani[i] = tempMedia[i] * personeMediaPiano[i];
            punteggioMaxTmp = calcolaMaxPunteggio(punteggiPiani[i - 1], punteggiPiani[i]);
            if (punteggiPiani[i - 1] < punteggiPiani[i]) {
                pianoCounter = i;
            }
            punteggioMax = calcolaMaxPunteggio(punteggioMaxTmp, punteggioMax);
        }

        System.out.println("Il piano che necessità urgentemente un intervento è: Piano n." + pianoCounter);
        System.out.println("Con una temperatura di: " + tempMedia[pianoCounter]);
        System.out.println("Con una frequenza media di persone che ammonta a: " + personeMediaPiano[pianoCounter]);
        System.out.println("Programma terminato...");

        kbInput.close();

    }

    public static double calcolaMaxPunteggio(double x, double y) {
        return Math.max(x, y);
    }
}
