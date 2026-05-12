package esercitazione3;

import java.util.*;

public class MatriceQuadrata {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String args[]) {

        int matrixSize;

        Scanner kbInput = new Scanner(System.in);

        System.out.println("Inserisci il numero di righe/colonne della matrice quadrata: ");

        matrixSize = kbInput.nextInt();

        System.out.println("Inserisci " + matrixSize + " numeri interi separandoli con lo spazio: ");

        int[] insertedNum = new int[matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            insertedNum[i] = kbInput.nextInt();
        }

        int[][] MatriceQuadrata = creaMatrice(insertedNum);

        stampaMatrice(MatriceQuadrata);

        System.out.println("Programma terminato...");

        kbInput.close();

    }

    public static int[][] creaMatrice(int[] numArray) {
        int[][] matrix = new int[numArray.length][numArray.length];
        for (int diagrow = 0; diagrow < numArray.length; diagrow++) {
            for (int diagcol = 0; diagcol < numArray.length; diagcol++) {

                matrix[diagrow][diagcol] = numArray[diagrow];

                if (diagrow != diagcol) {
                    matrix[diagrow][diagcol] = -1;

                }
            }

        }
        return matrix;
    }

    public static void stampaMatrice(int[][] matrice) {
        for (int[] riga : matrice) {
            for (int elem : riga) {
                System.out.printf(" " + elem + " | ");
            }
            System.out.println();
        }
    }

}
