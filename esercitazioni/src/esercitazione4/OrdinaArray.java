
import java.util.*;

public class OrdinaArray {

/*     static int bubblesort(int A[]) {

    }

    static int insertionsort(int A[]) {

    }

    static int selectsort(int A[]) {

    } */

    static void inizializzaArrayCasuale(int A[]) {
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(A.length);
        }
    }   

    static void inizializzaArrayCrescente(int A[]) {
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
    }

    static void inizializzaArrayDecrescente(int A[]) {
        for (int i = A.length; i < 0; i--) {
            A[i] = i;
        }
    }

    static void stampaArray(int A[]) {
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    public static void main(String[] args) {
        for (int n = 5; n <= 200; n = n + 5) {
            //------------------------------------
            //FASE DI INIZIALIZZAZIONE DEGLI ARRAY
            //------------------------------------
            int[] arrayCresc = new int[n];
            inizializzaArrayCrescente(arrayCresc);
            System.out.println("Stampa array cresc");
            stampaArray(arrayCresc);

            int[] arrayDesc = new int[n];
            inizializzaArrayDecrescente(arrayDesc);
            System.out.println("Stampa array desc");
            stampaArray(arrayDesc);

            int[] arrayRand = new int[n];
            inizializzaArrayCasuale(arrayRand);
            System.out.println("Stampa array rand");
            stampaArray(arrayRand);

            //------------------------------------
            //FASE DI ORDINAMENTO DEGLI ARRAY
            //------------------------------------
/*             int[] confrontiBubbleSort = new int[3]; //Si salvano i vari array ordinati in un altro array
            confrontiBubbleSort[0] = bubblesort(Arrays.copyOf(arrayCresc, arrayCresc.length)); //Si passa una copia dell'array iniziale
            confrontiBubbleSort[1] = bubblesort(Arrays.copyOf(arrayDesc, arrayDesc.length));   //per non modificarlo
            confrontiBubbleSort[2] = bubblesort(Arrays.copyOf(arrayRand, arrayRand.length));

            int[] confrontiInsertionSort = new int[3];
            confrontiInsertionSort[0] = insertionsort(Arrays.copyOf(arrayCresc, arrayCresc.length));
            confrontiInsertionSort[1] = insertionsort(Arrays.copyOf(arrayDesc, arrayDesc.length));
            confrontiInsertionSort[2] = insertionsort(Arrays.copyOf(arrayRand, arrayRand.length));

            int[] confrontiSelectionSort = new int[3];
            confrontiSelectionSort[0] = selectsort(Arrays.copyOf(arrayCresc, arrayCresc.length));
            confrontiSelectionSort[1] = selectsort(Arrays.copyOf(arrayDesc, arrayDesc.length));
            confrontiSelectionSort[2] = selectsort(Arrays.copyOf(arrayRand, arrayRand.length));

 */

        }
    }

}
