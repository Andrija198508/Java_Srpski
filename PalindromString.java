package andrija;

import java.util.Scanner;

public class PalindromString {
	
		public void DaLiJePalindrom(String n) {
			String m = "";
			for(int i = n.length() - 1; i >= 0; i--) {
				
				m += n.charAt(i);
			}
			if(n.equals(m)) {
				System.out.println("Jeste");
			}else
				System.out.println("Nije");
		}

	public static void main(String[] args) {
		
		Scanner ulaz = new Scanner(System.in);
		System.out.println("Unesite reč: ");
		String n = ulaz.nextLine();
		
		PalindromString p = new PalindromString();
		
		p.DaLiJePalindrom(n);
		ulaz.close();

	}

}