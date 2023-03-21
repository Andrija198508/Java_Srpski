package poker2;

import java.util.Scanner;

public class Glavna {
	Scanner ulaz = new Scanner(System.in);
	Karte2 k2 = new Karte2();
	Dobitak2 d = new Dobitak2();
	public void uloziti(int uplata) {
		if(uplata < 1) {
			System.out.println("Nemate više kredita!");
			return;
		}
		System.out.println("Koliki vam je ulog:");
		int ulog = ulaz.nextInt();
		while(ulog > uplata || ulog < 1) {
			if(ulog < 1) {
				System.out.println("Greška, ulog mora biti veći od nule. Odredite ulog ponovo:");
				ulog = ulaz.nextInt();
			}
			else {
				System.out.println("Greška, ulog mora biti manji od stanja. Odredite ulog ponovo:");
				ulog = ulaz.nextInt();
			}
		}
		k2.podeliKarte(0);
		uplata = uplata - ulog;
		System.out.println(k2.brojevi);
		System.out.println("Koje karte želite da vratite (1, 2, 3, 4, 5):");
		int n = ulaz.nextInt(); 
		int n2 = n;
		int i = 5;
		while(n2 != 0) {
			n2 = n2 / 10;
			k2.podeliKarte(i);
		}

		while(n != 0) {
			int x = n % 10;
			k2.brojevi.remove(x - 1);
			n = n / 10;
		}
		System.out.println(k2.brojevi);
		
		d.dobitak(k2.brojevi, ulog);
		k2.brojevi.removeAll(k2.brojevi);
		
		if(d.dobijeno > 0) {
			System.out.println("Dobili ste: " + d.dobijeno);
			System.out.println("Dupliraj(1) ili nastavi(2):");
			int dupliraj = ulaz.nextInt();
			if(dupliraj == 1) {
				k2.dupliraj(d.dobijeno);
			}
			else
				uplata = uplata + d.dobijeno;
		}
		if(k2.dobijeno2 > 0) {
			System.out.println("Dobili ste dobijeno2: " + k2.dobijeno2);
			uplata = uplata + k2.dobijeno2;
		}
		System.out.println("Stanje: " + uplata);
		k2.brojevi.removeAll(k2.brojevi);
		k2.dobijeno2 = 0;
		
		System.out.println("Da li želite da nastavite (1: Nastavi, 2: Isplata, 3: Uplati): ");
		int nastavi = ulaz.nextInt();
		if(nastavi == 1) {
			uloziti(uplata);
		}
		else if(nastavi == 2) {
			System.out.println("Isplata: " + uplata);
		}
		else if(nastavi == 3) {
			System.out.println("Koliko želite da uplatite:");
			int dodaj = ulaz.nextInt();
			uplata = uplata + dodaj;
			uloziti(uplata);
		}
	}

	public static void main(String[] args) {
		Scanner ulaz = new Scanner(System.in);
		System.out.println("Koliko želite da uplatite:");
		int uplata = ulaz.nextInt();
		while(uplata < 1) {
			System.out.println("Greška, uplata mora biti veća od nule. Pokušajte ponovo:");
			uplata = ulaz.nextInt();
		}
		Glavna obj = new Glavna();
		obj.uloziti(uplata);
		
		ulaz.close();
	}

}
