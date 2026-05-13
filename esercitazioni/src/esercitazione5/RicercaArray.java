package esercitazione5;

public class RicercaArray {

    /*
     * Algoritmo di ricerca sequenziale di un elemento in un Array di Oggetti
     */
    static boolean sequentialSearch(Comparable[] A, Comparable B, int[] numeroConfronti) {
        numeroConfronti[0] = 0;
        boolean trovato = false;

        // Controllo di sicurezza se B è nullo
        if (B == null) {
            return false;
        }

        for (int i = 0; i < A.length; i++) {
            numeroConfronti[0]++;
            // Usiamo == 0 per verificare l'uguaglianza dei valori
            if (A[i] != null && A[i].compareTo(B) == 0) {
                trovato = true;
                break;
            }
        }
        return trovato;
    }

    /*
     * Algoritmo di ricerca binaria di un oggetto in un array di oggetti ORDINATI
     */
    static boolean binarySearch(Comparable[] A, Comparable B, int[] numeroConfronti) {
        numeroConfronti[0] = 0;
        boolean trovato = false;

        if (B == null) {
            return false;
        }

        int inf = 0;
        int sup = A.length - 1;

        // Continuiamo finché gli indici non si incrociano e finché non troviamo l'elemento
        while (inf <= sup && !trovato) {

            numeroConfronti[0]++;

            int med = (inf + sup) / 2;

            // Salviamo il risultato del confronto per non richiamare il metodo due volte
            int risultatoConfronto = A[med].compareTo(B);

            if (risultatoConfronto == 0) {
                trovato = true; // Bingo!
            } else if (risultatoConfronto < 0) {
                // A[med] è più piccolo di B, quindi B si trova nella metà DESTRA
                inf = med + 1;
            } else {
                // A[med] è più grande di B, quindi B si trova nella metà SINISTRA
                sup = med - 1;
            }
        }

        return trovato;
    }

    /*
     * Inizializza l'array di interi A con i numeri interi 1, 2, 3,..., A.length
     */
    static void inizializzaArrayCrescente(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = i + 1;
        }
    }

    /*
     * Stampa gli elementi contenuti nell'array A
     */
    static void stampaArray(int[] A) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println(); // Va a capo alla fine della stampa
    }

    /**
     * Metodo Main per testare le funzioni
     */
    public static void main(String[] args) {

        // Esempio di Test con Array di Stringhe (String implementa già Comparable)
        String[] nomi = {"Anna", "Bruno", "Carlo", "Dario", "Elena"};
        int[] contatore = {0};

        boolean trovatoSequenziale = sequentialSearch(nomi, "Carlo", contatore);
        System.out.println("Trovato con ricerca sequenziale: " + trovatoSequenziale + " (Confronti: " + contatore[0] + ")");

        boolean trovatoBinario = binarySearch(nomi, "Carlo", contatore);
        System.out.println("Trovato con ricerca binaria: " + trovatoBinario + " (Confronti: " + contatore[0] + ")");
    }
}
