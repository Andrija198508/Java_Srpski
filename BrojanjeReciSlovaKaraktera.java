package andrija;

import java.util.Scanner;

public class BrojanjeReciSlovaKaraktera {

	public static void main(String[] args) {
		
		Scanner ulaz = new Scanner(System.in);
		System.out.println("Unesite tekst:");
		String tekst = ulaz.nextLine();
		
		int brojanjeReci = tekst.split("\\s").length;
		int brojanjeSlova = 0, brojanjeKaraktera = 0;
		
		for(int i = 0; i < tekst.length(); i++) {
			if(tekst.charAt(i) != ' ')
				brojanjeSlova++;
			brojanjeKaraktera++;
		}
		System.out.println("Broj reči u tekstu: " + brojanjeReci + "\nBroj slova u tekstu: " 
				+ brojanjeSlova + "\nBroj karaktera u tekstu: " + brojanjeKaraktera);
		ulaz.close();
	}

}
