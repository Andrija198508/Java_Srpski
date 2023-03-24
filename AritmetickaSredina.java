package andrija;

import java.util.Scanner;

public class AritmetickaSredina {

	public static void main(String[] args) {
		
		Scanner ulaz = new Scanner(System.in);
		System.out.println("Unesite broj elemenata niza: ");
		int n = ulaz.nextInt();
		int niz[] = new int[n];
		int suma = 0;
		double aritmetickaSredina;
		
		for(int i = 0; i < n; i++) {
			System.out.println("Unesite " + (i + 1) + ". broj: ");
			niz[i] = ulaz.nextInt();
			suma += niz[i];
		}
		
		aritmetickaSredina = (double)suma / n;
		System.out.print("\nAritmetička sredina unetih brojeva je: " + aritmetickaSredina);
		ulaz.close();
	}

}
