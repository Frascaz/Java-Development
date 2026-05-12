package esercitazione5;

public class Libro {

    String title;
    double price;
    String[] author = new String[5];

    protected String[] getAuthor() {
        return this.author;
    }

    protected String getTitle() {
        return this.title;
    }

    protected double getPrice() {
        return this.price;
    }

    // CORRETTO: Cerca prima i duplicati, poi trova il primo posto libero (null)
    protected void setAuthors(String aut) {
        // 1. Controllo se è già presente
        if (isAuthorPresent(aut)) {
            // System.out.println("This Author is already present.");
            return;
        }

        // 2. Se non è presente, lo aggiungo al primo posto libero
        for (int i = 0; i < author.length; i++) {
            if (this.author[i] == null) {
                this.author[i] = aut;
                // System.out.println("Author added successfully.");
                return;
            }
        }
        // System.out.println("You can't add more than 5 authors.");
    }

    // CORRETTO: Evita i NullPointerException aggiungendo `author[i] != null`
    protected boolean isAuthorPresent(String aut) {
        for (int i = 0; i < author.length; i++) {
            if (this.author[i] != null && this.author[i].equals(aut)) {
                return true;
            }
        }
        return false;
    }

    // CORRETTO: Controlla che le due liste di autori siano perfettamente uguali
    protected boolean isAuthorEquals(Libro other) {
        // Contiamo quanti autori ha questo libro
        int countThis = 0;
        for (String a : this.author) {
            if (a != null)
                countThis++;
        }

        // Contiamo quanti autori ha l'altro libro
        int countOther = 0;
        for (String a : other.author) {
            if (a != null)
                countOther++;
        }

        // Se hanno un numero di autori diverso, non sono uguali
        if (countThis != countOther)
            return false;

        // Se non hanno nessun autore (Libri del caso 10%), ignoriamo (o ritorna true a
        // seconda delle specifiche)
        if (countThis == 0)
            return false;

        // Verifichiamo che ogni autore di questo libro sia presente nell'altro
        for (int i = 0; i < this.author.length; i++) {
            if (this.author[i] != null) {
                if (!other.isAuthorPresent(this.author[i])) {
                    return false; // Appena ne manca uno, non sono uguali
                }
            }
        }
        return true; // Se arriviamo qui, gli array contengono esattamente gli stessi autori
    }

    protected void printBookInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Price: " + this.price);
        System.out.print("Authors: ");
        for (int i = 0; i < author.length; i++) {
            if (this.author[i] != null) {
                System.out.print(this.author[i] + " ");
            }
        }
        System.out.println();
    }
}