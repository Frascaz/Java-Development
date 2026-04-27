package esercitazione2;

import java.util.Scanner;

public class Esercizio2 {

    public static void main(String args[]) {

        Scanner kbInput = new Scanner(System.in);
        int nNum;

        System.out.println("Inserisci il numero di numeri che vuoi inserire:");

        nNum = kbInput.nextInt();

        int maxNum;
        int minNum;
        int maxAbsNum;

        int primoNum;
        int altriNum;

        System.out.println("Inserisci il primo numero:");

        primoNum = kbInput.nextInt();

        maxNum = primoNum;
        minNum = primoNum;
        maxAbsNum = primoNum;

        nNum--;

        while (nNum != 0) {
            System.out.println("Inserisci il prossimo numero:");
            altriNum = kbInput.nextInt();
            maxNum = calcolaMax(maxNum, altriNum);
            minNum = calcolaMin(minNum, altriNum);
            if (calcolaMaxabs(altriNum) > maxAbsNum) {
                maxAbsNum = calcolaMaxabs(altriNum);    
            } else {
                maxAbsNum = calcolaMaxabs(maxAbsNum);
            }
            nNum--;
        }

        System.out.println("Numero più grande inserito: " + maxNum);
        System.out.println("Numero più piccolo inserito: " + minNum);
        System.out.println("Numero più grande in valore assoluto inserito: " + maxAbsNum);

        int risultatoExp = calcolaExp(maxNum, minNum, maxAbsNum);

        System.out.println("Il risultato della espressione (max - min)^maxabs è: " + risultatoExp);

        System.out.println("Programma terminato...");

        kbInput.close();

    }

    public static int calcolaMax(int x, int y) {
        int max = Math.max(x, y);
        return max;
    }

    public static int calcolaMin(int x, int y) {
        int min = Math.min(x, y);
        return min;
    }

    public static int calcolaMaxabs(int x) {
        int maxabs = Math.abs(x);
        return maxabs;
    }

    public static int calcolaExp(int x, int y, int z){
        int sottrazione = (x - y);
        return Math.powExact(sottrazione, z );
    }
}
