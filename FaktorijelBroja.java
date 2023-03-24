package andrija;

import java.util.Scanner;

public class FaktorijelBroja {

	public static void main(String[] args) {
		
		Scanner ulaz = new Scanner(System.in);
		
		System.out.print("Unesite pozitivan broj: ");
		int n = ulaz.nextInt();
		int faktorijel = 1;
		
		for(int i = n; i > 0; i--) {
			faktorijel = faktorijel * i;
		}
		
		System.out.println("Faktorijel unetog broja je: " + faktorijel);
		ulaz.close();
	}

}
