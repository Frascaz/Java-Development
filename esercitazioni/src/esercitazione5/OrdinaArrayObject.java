package esercitazione5;

public class OrdinaArrayObject {

    /*
	 * Algoritmo bubblesort per l'ordinamento di un array di oggetti A
	 * per iquali sia definita una relazione d'ordine totale "<="
	 * @param A
     */
    static void bubblesort(Studente A[]) {
        for (int i = 1; i <= A.length - 1; i++) {
            boolean scambiAvvenuti = false;
            for (int j = 1; j <= A.length - i; j++) {
                if (A[j - 1].compareTo(A[j]) > 0) {
                    Studente temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                    scambiAvvenuti = true;
                }
            }
            if (!scambiAvvenuti) {
                break;
            }
        }

    }

    /*
	 * Stampa gli elementi contenuti nell'array A
	 * @param A
     */
    static void stampaArray(Object A[]) {
        int i;
        for (i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

    public static void main(String args[]) {

        Studente A[] = new Studente[10];
        for (int i = 0; i < A.length; i++) {
            A[i] = new Studente();
        }

        stampaArray(A);
        System.out.println("Ordinamento");
        bubblesort(A);
        stampaArray(A);
    }

}
