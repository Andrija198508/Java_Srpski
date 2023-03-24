package andrija;

import java.util.Scanner;

public class SumaRekurzija {
		
		public static int rekurzija(int x, int g, int suma) {
			while(x != 0) {
				g = x % 10;
				suma += g;
				return rekurzija(x / 10, g, suma);
			}
			return suma;
			
		}

	public static void main(String[] args) {
		
		Scanner ulaz = new Scanner(System.in);
		
		System.out.println("Unesite broj: ");
		int x = ulaz.nextInt();
		int g = 0, suma = 0;
		
		System.out.println("Suma cifara unetog broja je: " + rekurzija(x, g, suma));
		ulaz.close();
	}

}