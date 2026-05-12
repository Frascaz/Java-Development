package esercitazione5;

import java.util.Random;

public class Libreria {
        public static void main(String[] args) {
                Libro[] libri = new Libro[100];
                Random rand = new Random();
                String[] autori = { "Mario Rossi", "Luigi Bianchi", "Giovanni Verdi", "Francesca Neri", "Anna Russo",
                                "Paolo Gialli", "Sara Blu", "Marco Viola", "Laura Marrone", "Stefano Grigio" };

                // FASE 1: INIZIALIZZAZIONE
                for (int i = 0; i < libri.length; i++) {
                        libri[i] = new Libro();
                        double price = rand.nextDouble() * 20;
                        int prob = rand.nextInt(100);

                        if (prob < 10) {
                                libri[i].title = "Libro " + i;
                                libri[i].price = price;
                        } else {
                                libri[i].title = "Libro " + i;
                                libri[i].price = price;
                                for (int j = 0; j < 3; j++) {
                                        int randomAuthor = rand.nextInt(autori.length);
                                        libri[i].setAuthors(autori[randomAuthor]);
                                }
                        }
                }

                // FASE 2: RICERCA E CONTEGGIO
                int counterEqualAuthorBook = 0;

                for (int i = 0; i < libri.length; i++) {
                        for (int k = i + 1; k < libri.length; k++) {
                                // Confrontiamo il libro 'i' con il libro 'k'
                                if (libri[i].isAuthorEquals(libri[k])) {
                                        counterEqualAuthorBook++;
                                }
                        }
                }

                System.out.println("Numero di coppie di libri con gli stessi autori: " + counterEqualAuthorBook);
        }
}