package pokerAparatGUI;

import java.util.ArrayList;

public class Karte {
	
	String str = "a";
	
	public ArrayList<String> podeliKarte(ArrayList<String> karteKarte, int i) {
		do {
			while(karteKarte.contains(str) || str == "a") {
				int broj = 0;
				int boja = 0;
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
						str = "Karo " + "Žandar" + ".png";
					}
					else if(broj == 13) {
						str = "Karo " + "Dama" + ".png";
					}
					else if(broj == 14) {
						str = "Karo " + "Kralj" + ".png";
					}
					else if(broj == 1) {
						str = "Karo " + "Kec" + ".png";
					}
					else
						str = "Karo " + Integer.toString(broj) + ".png";
				}
				else if(boja > 13 && boja <= 26) {
					if(broj == 12) {
						str = "Srce " + "Žandar" + ".png";
					}
					else if(broj == 13) {
						str = "Srce " + "Dama" + ".png";
					}
					else if(broj == 14) {
						str = "Srce " + "Kralj" + ".png";
					}
					else if(broj == 1) {
						str = "Srce " + "Kec" + ".png";
					}
					else
						str = "Srce " + Integer.toString(broj) + ".png";
				}
				else if(boja > 26 && boja <= 39){
					if(broj == 12) {
						str = "Pik " + "Žandar" + ".png";
					}
					else if(broj == 13) {
						str = "Pik " + "Dama" + ".png";
					}
					else if(broj == 14) {
						str = "Pik " + "Kralj" + ".png";
					}
					else if(broj == 1) {
						str = "Pik " + "Kec" + ".png";
					}
					else
						str = "Pik " + Integer.toString(broj) + ".png";
				}
				else if (boja > 39 && boja <= 52){
					if(broj == 12) {
						str = "Tref " + "Žandar" + ".png";
					}
					else if(broj == 13) {
						str = "Tref " + "Dama" + ".png";
					}
					else if(broj == 14) {
						str = "Tref " + "Kralj" + ".png";
					}
					else if(broj == 1) {
						str = "Tref " + "Kec" + ".png";
					}
					else
						str = "Tref " + Integer.toString(broj) + ".png";
				}
				else
					str = "Džoker.png";
			}
			karteKarte.add(str);
			i++;
		}while(i < 5);
		return karteKarte;
	}
}
