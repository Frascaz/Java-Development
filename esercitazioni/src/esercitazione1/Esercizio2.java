package esercitazione1;

import java.util.*;

public class Esercizio2 {

	public static void main(String[] args) {
		
		Scanner tastiera1 = new Scanner(System.in);
		
		System.out.println("Inserisci 3 numeri interi separati da uno spazio: ");
		
		int n1, n2, n3;
		
		n1 = tastiera1.nextInt();
		n2 = tastiera1.nextInt();
		n3 = tastiera1.nextInt();
		
		
		
		System.out.println("Inserisci 3 parole,separate dal carattere &: ");

		String s1, s2, s3;
		
		Scanner tastiera2 = new Scanner(System.in);
		
		
		tastiera2.useDelimiter("&|\\+s");
		
		
		s1 = tastiera2.next();
		s2 = tastiera2.next();			
		s3 = tastiera2.next();		
		
		int mediaNum = (n1 + n2 + n3) / 3;
		
		int mediaStr = (s1.length() + s2.length() + s3.length()) / 3;
		
		System.out.println("Abbiamo \"stimato\" che la media dei numeri che pensi è: " + mediaNum + " mentre la\n"
				+ "lunghezza media delle parole che digiti è: " + mediaStr);
		
		tastiera1.close();
		tastiera2.close();
	}

}
