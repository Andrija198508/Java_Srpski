package andrija;

import java.util.Scanner;

public class PalindromBroj {

	public static void main(String[] args) {
		
		Scanner ulaz = new Scanner(System.in);
		System.out.print("Unesite broj: ");
		int n = ulaz.nextInt();
		int k, n2 = n, obrnutBroj = 0;
		
		while(n != 0) {
			k = n % 10;
			obrnutBroj = obrnutBroj * 10 + k * 10;
			n = n / 10;
		}
		obrnutBroj = obrnutBroj / 10;
		
		if(n2 == obrnutBroj) {
			System.out.println("Broj je palindrom.");
		}
		else
			System.out.println("Broj nije palindrom.");
		ulaz.close();
	}

}
