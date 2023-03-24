package andrija;

import java.util.Scanner;

public class FaktorijelRekurzija {
		
		static int rekurzija(int n, int faktorijel) {
			while(n >= 1) {
				faktorijel = faktorijel * n;
				return rekurzija(n - 1, faktorijel);
			}
			return faktorijel;
		}
	public static void main(String[] args) {
		
		Scanner ulaz = new Scanner(System.in);
		int faktorijel = 1;
		System.out.print("Unesite pozitivan broj: ");
		int n = ulaz.nextInt();
		
		faktorijel = rekurzija(n, faktorijel);
		
		System.out.println("Faktorijel unetog broja je: " + faktorijel);
		ulaz.close();
	}

}
