


public class Libro{
    String title;
    double price;
    String[] author = new String[5];

    private String[] getAuthor(){
        return this.author; 
    }

    private String getTitle(){
        return this.title;
    }

    private double getPrice(){
        return this.price;
    }

    private void setAuthors(String aut){
        for (int i = 0; i < author.length; i++) {
            if(aut.equals(this.author[i])){
                System.out.println("This Author is already present.");
            }
            else{
            }
        }
    }


}