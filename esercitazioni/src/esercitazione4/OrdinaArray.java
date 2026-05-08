

import java.util.*;

public class OrdinaArray {

    static int bubblesort(int A[]) {
        int counter = 0;
        boolean swapped;

        for (int i = 0; i < A.length - 1; i++) {
            swapped = false;

            // Il ciclo j deve arrivare fino alla parte non ancora ordinata
            for (int j = 0; j < A.length - 1 - i; j++) {
                counter++; // Conta ogni confronto effettuato

                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                    swapped = true;
                }
            }

            // Se dopo un intero passaggio non ci sono stati scambi, esci
            if (!swapped) {
                break;
            }
        }
        return counter;
    }

    static int insertionsort(int A[]) {
        int counter = 0;

        // Partiamo dall'indice 1, perché il primo elemento (indice 0) 
        // lo consideriamo già "ordinato" da solo.
        for (int i = 1; i < A.length; i++) {

            int key = A[i]; // La "carta" che stiamo esaminando e che vogliamo inserire
            int j = i - 1;  // L'indice della carta subito a sinistra

            // Continuiamo a scorrere verso sinistra finché non finiamo l'array (j >= 0)
            while (j >= 0) {

                counter++; // Contiamo il confronto che stiamo per fare

                if (A[j] > key) {
                    // Se la carta a sinistra è più grande, la spostiamo di un posto a destra
                    A[j + 1] = A[j];
                    j--; // Ci spostiamo ancora più a sinistra
                } else {
                    // Se la carta a sinistra è più piccola o uguale, abbiamo trovato 
                    // il buco giusto! Interrompiamo il ciclo.
                    break;
                }
            }

            // Inseriamo la nostra "carta" nel buco che abbiamo creato
            A[j + 1] = key;
        }

        return counter;
    }

    static int selectsort(int A[]) {
        int counter = 0;

        // Il ciclo esterno si ferma al penultimo elemento (A.length - 1)
        // perché quando arriviamo all'ultimo, l'array è già tutto ordinato!
        for (int i = 0; i < A.length - 1; i++) {

            // 1. Assumiamo che il minimo sia l'elemento attuale
            int minIndex = i;

            // 2. Cerchiamo se esiste un elemento ancora più piccolo a destra
            for (int j = i + 1; j < A.length; j++) {
                counter++; // Contiamo il confronto

                if (A[j] < A[minIndex]) {
                    minIndex = j; // Aggiorniamo l'indice del nuovo minimo
                }
            }

            // 3. Facciamo lo Swap SOLO se il minimo trovato non è già al suo posto
            if (minIndex != i) {
                swap(A, minIndex, i);
            }
        }

        return counter;
    }

    static int shellsort(int A[]) {
        int counter = 0;
        int inc = A.length / 2; // Partiamo con un gap pari alla metà dell'array

        while (inc >= 1) {
            // Per ogni "catena" creata da questo incremento...
            for (int i = 0; i < inc; i++) {
                // ...sommiamo al counter totale i confronti fatti in quella catena
                counter += ordinaCatena(A, i, inc);
            }
            inc = inc / 2; // Riduciamo il gap dimezzandolo
        }

        return counter;
    }

    static int ordinaCatena(int A[], int i, int inc) {
        int confrontiLocali = 0; // Contatore per questa specifica catena
        int k = i + inc;

        while (k < A.length) {
            boolean inserito = false;
            int x = A[k];
            int corrente = k, precedente = corrente - inc;

            while (precedente >= i && !inserito) {

                confrontiLocali++; // Incrementiamo prima del confronto

                if (x < A[precedente]) {
                    // SHIFT A DESTRA DELL'ELEMENTO A[PRECEDENTE]
                    A[corrente] = A[precedente];
                    corrente = precedente;
                    precedente = precedente - inc;
                } else {
                    inserito = true; // Abbiamo trovato la posizione corretta
                }
            }

            A[corrente] = x;
            k = k + inc;
        }

        return confrontiLocali; // Restituiamo i confronti al ciclo principale
    }

// 1. Funzione "Wrapper" da chiamare nel main: arrayBubble[0] = quicksort(A);
    static int quicksort(int[] A) {
        int[] counter = {0}; // Array di un elemento per simulare il passaggio per riferimento
        quicksortRicorsivo(A, 0, A.length - 1, counter);
        return counter[0];   // Restituisce il totale dei confronti
    }

    // 2. Il vero algoritmo ricorsivo
    static void quicksortRicorsivo(int[] A, int inf, int sup, int[] counter) {
        if (inf < sup) {
            int pos = partition(A, inf, sup, counter);

            // Ottimizzazione: ordiniamo prima la metà più piccola per risparmiare memoria (Stack)
            if ((pos - inf) < (sup - pos)) {
                quicksortRicorsivo(A, inf, pos - 1, counter);
                quicksortRicorsivo(A, pos + 1, sup, counter);
            } else {
                quicksortRicorsivo(A, pos + 1, sup, counter);
                quicksortRicorsivo(A, inf, pos - 1, counter);
            }
        }
    }

    // 3. La logica di partizionamento
    static int partition(int[] A, int inf, int sup, int[] counter) {
        int med = (inf + sup) / 2;
        int x = A[med];

        // Spostiamo il pivot all'inizio per comodità
        swap(A, inf, med);

        int i = inf + 1; // Partiamo dall'elemento subito dopo il pivot
        int j = sup;

        while (true) {

            // Cerchiamo il primo elemento più grande del pivot da sinistra
            while (i <= sup) {
                counter[0]++; // Incrementiamo il contatore per ogni confronto
                if (A[i] > x) {
                    break;
                }
                i++;
            }

            // Cerchiamo il primo elemento più piccolo o uguale al pivot da destra
            while (j >= inf + 1) {
                counter[0]++; // Incrementiamo il contatore per ogni confronto
                if (A[j] <= x) {
                    break;
                }
                j--;
            }

            // Se gli indici non si sono incrociati, scambiamo i valori
            if (i < j) {
                swap(A, i, j);
            } else {
                break; // Se si incrociano, abbiamo finito
            }
        }

        // Rimettiamo il pivot nella sua posizione definitiva (j)
        swap(A, inf, j);

        return j;
    }

    // 4. La funzione di swap 
    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static int mergesort(int A[]) {
        int[] counter = {0};
        mergesortRicorsivo(A, 0, A.length - 1, counter);
        return counter[0];
    }

    static void mergesortRicorsivo(int[] A, int inf, int sup, int[] counter) {
        if (inf < sup) {
            int m = (inf + sup) / 2;
            mergesortRicorsivo(A, inf, m, counter);
            mergesortRicorsivo(A, m + 1, sup, counter);
            merge(A, inf, m, sup, counter);
        }
    }

    static void merge(int[] A, int p, int q, int r, int[] counter) {
        int[] aus = new int[r - p + 1];
        int i = p;       // Indice per scorrere la metà sinistra
        int j = q + 1;   // Indice per scorrere la metà destra
        int k = 0;       // Indice per riempire l'array ausiliario

        // 1. FASE DI FUSIONE CON CONFRONTI
        while (i <= q && j <= r) {
            counter[0]++; // Incrementiamo il contatore dei confronti

            // Usiamo <= per mantenere l'algoritmo "stabile" (non inverte elementi uguali)
            if (A[i] <= A[j]) {
                aus[k] = A[i];
                i++;
            } else {
                aus[k] = A[j];
                j++;
            }
            k++;
        }

        // 2. RACCOLTA DEGLI AVANZI (Nessun confronto necessario!)
        // Se la metà destra si è esaurita prima, copiamo ciò che resta a sinistra
        while (i <= q) {
            aus[k] = A[i];
            i++;
            k++;
        }

        // Se la metà sinistra si è esaurita prima, copiamo ciò che resta a destra
        while (j <= r) {
            aus[k] = A[j];
            j++;
            k++;
        }

        // 3. RIVERSAMENTO FINALE
        // Trasferiamo l'array ausiliario ordinato dentro l'array originale A
        for (k = 0; k < aus.length; k++) {
            A[p + k] = aus[k];
        }
    }

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
        for (int i = 0; i < A.length; i++) {
            A[i] = A.length - 1 - i;
        }
    }

    static void stampaConfronti(int x, int A[], int B[], int C[], int D[], int E[], int F[]) {

        System.out.printf("%-10d %-15d %-15d %-15d %-15d %-15d %-15d %-15d %-15d %-15d %-15d %-15d %-15d %-15d %-15d %-15d %-15d %-15d %-15d\n",
                x,
                A[0],
                A[1],
                A[2],
                B[0],
                B[1],
                B[2],
                C[0],
                C[1],
                C[2],
                D[0],
                D[1],
                D[2],
                E[0],
                E[1],
                E[2],
                F[0],
                F[1],
                F[2]
        );

    }

    static void stampaIntestazione(String tipoConfronto1, String tipoConfronto2, String tipoConfronto3, String tipoConfronto4, String tipoConfronto5, String tipoConfronto6) {
        System.out.printf("%-10s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s \n", "DimArray", tipoConfronto1 + "Cresc", tipoConfronto1 + "Desc", tipoConfronto1 + "Rand",
                tipoConfronto2 + "Cresc", tipoConfronto2 + "Desc", tipoConfronto2 + "Rand",
                tipoConfronto3 + "Cresc", tipoConfronto3 + "Desc", tipoConfronto3 + "Rand",
                tipoConfronto4 + "Cresc", tipoConfronto4 + "Desc", tipoConfronto4 + "Rand",
                tipoConfronto5 + "Cresc", tipoConfronto5 + "Desc", tipoConfronto5 + "Rand",
                tipoConfronto6 + "Cresc", tipoConfronto6 + "Desc", tipoConfronto6 + "Rand");
    }

    public static void main(String[] args) {

        final int primo = 5, ultimo = 20, incremento = 5;

        stampaIntestazione("Bubble", "Selection", "Insertion", "Shell", "Quick", "Merge");

        // Una linea decorativa per separare l'intestazione dai dati
        System.out.print("""
                         ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                         """);

        for (int n = primo; n <= ultimo; n = n + incremento) {
            //------------------------------------
            //FASE DI INIZIALIZZAZIONE DEGLI ARRAY
            //------------------------------------
            int[] arrayCresc = new int[n];
            inizializzaArrayCrescente(arrayCresc);

            int[] arrayDesc = new int[n];
            inizializzaArrayDecrescente(arrayDesc);

            int[] arrayRand = new int[n];
            inizializzaArrayCasuale(arrayRand);

            //------------------------------------
            //FASE DI ORDINAMENTO DEGLI ARRAY
            //------------------------------------
            int[] confrontiBubbleSort = new int[3]; //Si salvano i vari array ordinati in un altro array
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

            int[] confrontiShellSort = new int[3];
            confrontiShellSort[0] = shellsort(Arrays.copyOf(arrayCresc, arrayCresc.length));
            confrontiShellSort[1] = shellsort(Arrays.copyOf(arrayDesc, arrayDesc.length));
            confrontiShellSort[2] = shellsort(Arrays.copyOf(arrayRand, arrayRand.length));

            int[] confrontiQuickSort = new int[3];
            confrontiQuickSort[0] = quicksort(Arrays.copyOf(arrayCresc, arrayCresc.length));
            confrontiQuickSort[1] = quicksort(Arrays.copyOf(arrayDesc, arrayDesc.length));
            confrontiQuickSort[2] = quicksort(Arrays.copyOf(arrayRand, arrayRand.length));

            int[] confrontiMergeSort = new int[3];
            confrontiMergeSort[0] = mergesort(Arrays.copyOf(arrayCresc, arrayCresc.length));
            confrontiMergeSort[1] = mergesort(Arrays.copyOf(arrayDesc, arrayDesc.length));
            confrontiMergeSort[2] = mergesort(Arrays.copyOf(arrayRand, arrayRand.length));

            // STAMPA I DATI IN TABELLA
            stampaConfronti(n, confrontiBubbleSort, confrontiSelectionSort, confrontiInsertionSort, confrontiShellSort, confrontiQuickSort, confrontiMergeSort);
        }

    }
}
