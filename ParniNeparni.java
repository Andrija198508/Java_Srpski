package andrija;

import java.util.Scanner;

public class ParniNeparni {

	public static void main(String[] args) {
		
		Scanner ulaz = new Scanner(System.in);
		
		System.out.print("Unesite broj članova niza: ");
		int n = ulaz.nextInt();
		int niz[] = new int[n];
		int pb = 0, nb = 0;
		
		for(int i = 0; i < n; i++) {
			System.out.print("niz[" + i + "] = ");
			niz[i] = ulaz.nextInt();
			
			if(niz[i] % 2 == 0) {
				pb++;
			}
			else
				nb++;
		}
		System.out.print("Parnih brojeva: " + pb + "\nNeparnih brojeva: " + nb);
		ulaz.close();
	}

}