package poker2;

import java.util.ArrayList;
import java.util.Scanner;

public class Karte2 {
		int broj = 0, boja = 0, d = 0, i = 0, dobijeno2 = 0;
		String str = "a";
		ArrayList<String> brojevi = new ArrayList<String>();
		Scanner ulaz = new Scanner(System.in);
		
		public void podeliKarte(int i) {
			do {
				while(brojevi.contains(str) || str == "a") {
					broj = 0;
					boja = 0;
					while(boja < 1 || boja > 53) {
						boja = (int)(Math.random() * 100);
					}
					if(boja != 53) {
					while(broj < 1 || broj > 14 || broj == 11) {
						broj = (int)(Math.random() * 100);
					}
					}
					if(boja <= 13) {
						if(broj == 12) {
							str = "Karo " + "Žandar";
						}
						else if(broj == 13) {
							str = "Karo " + "Dama";
						}
						else if(broj == 14) {
							str = "Karo " + "Kralj";
						}
						else if(broj == 1) {
							str = "Karo " + "Kec";
						}
						else
							str = "Karo " + Integer.toString(broj);
					}
					else if(boja > 13 && boja <= 26) {
						if(broj == 12) {
							str = "Srce " + "Žandar";
						}
						else if(broj == 13) {
							str = "Srce " + "Dama";
						}
						else if(broj == 14) {
							str = "Srce " + "Kralj";
						}
						else if(broj == 1) {
							str = "Srce " + "Kec";
						}
						else
							str = "Srce " + Integer.toString(broj);
					}
					else if(boja > 26 && boja <= 39){
						if(broj == 12) {
							str = "Pik " + "Žandar";
						}
						else if(broj == 13) {
							str = "Pik " + "Dama";
						}
						else if(broj == 14) {
							str = "Pik " + "Kralj";
						}
						else if(broj == 1) {
							str = "Pik " + "Kec";
						}
						else
							str = "Pik " + Integer.toString(broj);
					}
					else if (boja > 39 && boja <= 52){
						if(broj == 12) {
							str = "Tref " + "Žandar";
						}
						else if(broj == 13) {
							str = "Tref " + "Dama";
						}
						else if(broj == 14) {
							str = "Tref " + "Kralj";
						}
						else if(broj == 1) {
							str = "Tref " + "Kec";
						}
						else
							str = "Tref " + Integer.toString(broj);
					}
					else
						str = "Džoker";
				}
				brojevi.add(str);
				i++;
			}while(i < 5);
		}

		public void dupliraj(int dobijeno2){
			System.out.println("Crveno(1) ili crno(2):");
			int udari = ulaz.nextInt();
			podeliKarte(5);
			System.out.println(brojevi);
			if(brojevi.get(i).contains("Srce") || brojevi.get(i).contains("Karo")) {
				d = 1;
			}
			if(brojevi.get(i).contains("Tref") || brojevi.get(i).contains("Pik")) {
				d = 2;
			}
			if(brojevi.get(i).contains("Džoker")) {
				d = udari;
			}
			if(udari == d) {
				dobijeno2 = dobijeno2 * 2;
			}
			else if(udari != d){
				dobijeno2 = 0;
			}
			i++;
			if(dobijeno2 > 0) {
				System.out.println("Dobili ste: " + dobijeno2);
				System.out.println("Dupliraj(1) ili nastavi(2):");
				udari = ulaz.nextInt();
				if(udari == 1) {
					dupliraj(dobijeno2);
				}
				else{
					this.dobijeno2 = dobijeno2;
				}
			}
			brojevi.removeAll(brojevi);
			i = 0;
		}
		
}
