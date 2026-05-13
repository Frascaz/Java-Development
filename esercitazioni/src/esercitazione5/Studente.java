package esercitazione5;

import java.util.Random;

public class Studente implements Comparable {

    private static int matricolaCount = 0;
    private int matricola;
    private float mediaVoti;
    private int nroEsamiSostenuti;
    private int nroLodi;

    Studente(float mediaVoti, int nroEsamiSostenuti, int nroLodi) {
        this.matricola = matricolaCount++;
        this.mediaVoti = mediaVoti;
        this.nroEsamiSostenuti = nroEsamiSostenuti;
        this.nroLodi = nroLodi;
    }

    /* 
	 * Genera un Studente casuale
     */
    Studente() {
        this.matricola = matricolaCount++;
        this.mediaVoti = (float) (new Random().nextDouble() * 30.0);
        this.nroEsamiSostenuti = new Random().nextInt(20) + 1;
        this.nroLodi = new Random().nextInt(this.nroEsamiSostenuti) + 1;

    }

    public String toString() {
        return "MATRICOLA: " + matricola + " MEDIA VOTI: " + mediaVoti + " NUMERO ESAMI SOSTENUTI: " + nroEsamiSostenuti + " NUMERO LODI: " + nroLodi;
    }

    float getMediaVoti() {
        return mediaVoti;
    }

    int getNroEsamiSostenuti() {
        return nroEsamiSostenuti;
    }

    int getNroLodi() {
        return nroLodi;
    }

    /*
	@Override
	public int compareTo(Object o) {
		// Confronta usando come relazione d'ordine
		// o1 < o2 iff o1.mediaVoti <= o2.mediaVoti
		if(((Studente)o).getMediaVoti()<this.mediaVoti)
			return +1;
		else 
			if(((Studente)o).getMediaVoti()>this.mediaVoti)
				return -1;
		return 0;
	}
     */

    @Override
    public int compareTo(Object o) {
        // Confronta usando come relazione d'ordine
        // o1 < o2 iff o1.nroEsamiSostenuti <= o2.nroEsamiSostenuti
        if (((Studente) o).getNroLodi() < this.nroLodi) {
            return +1; 
        }else if (((Studente) o).getNroLodi() > this.nroLodi) {
            return -1;
        }
        return 0;
    }

    public static void main(String rgs[]) {
        Studente s[] = new Studente[10];

        for (int i = 0; i < s.length; i++) {
            s[i] = new Studente();
        }

        int tempI = 1;
        for (int i = 0; i < s.length; i++) {
            if (s[i].compareTo(s[tempI]) < 0) {
                tempI = i;
            }
        }

        System.out.println(s[tempI]);

    }

}
