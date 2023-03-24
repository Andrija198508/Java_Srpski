package andrija;

import java.util.Scanner;

public class TrazeniBroj {

	public static void main(String[] args) {
		
		Scanner ulaz = new Scanner(System.in);
		
		int niz[] = new int[10];
		System.out.print("Unesite traženi broj: ");
		int x = ulaz.nextInt();
		int b = 0;
		
		System.out.println("Unesite elemente niza: ");
		for(int i = 0; i < niz.length; i++) {
			System.out.print("niz[" + i + "] = ");
			niz[i] = ulaz.nextInt();
			if(niz[i] == x) {
				b++;
			}
			
		}
		System.out.println("Traženi broj se pojavljuje: " + b);
		ulaz.close();
	}

}