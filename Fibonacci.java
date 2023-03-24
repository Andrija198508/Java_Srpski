package andrija;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		
		Scanner ulaz = new Scanner(System.in);
		System.out.println("Unesite pozitivan broj:");
		int n = ulaz.nextInt();
		
		int n2 = 0, n3 = 1, n4;
		
		for(int i = 1; i <= n; i++) {
			n4 = n2 + n3;
			System.out.print(n4 + " ");
			n2 = n3;
			n3 = n4;
		}
		ulaz.close();
	}

}
