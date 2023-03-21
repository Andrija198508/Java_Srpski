package bingo;

import java.util.ArrayList;
import java.util.Scanner;

public class Bingo extends Thread{
	static Scanner ulaz = new Scanner(System.in);
		public static void brojevi(ArrayList<Integer> brojevi, int i) {
			while(i < 11) {
				System.out.println("Unesite " + i + ". broj:");
				int broj = ulaz.nextInt();
				while(broj < 1 || broj > 100 || brojevi.contains(broj)) {
					System.out.println("Greška, unesite ponovo:");
					broj = ulaz.nextInt();
				}
				brojevi.add(broj);
				i++;
			}
		}

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Integer> prviIgrac = new ArrayList<Integer>();
		ArrayList<Integer> drugiIgrac = new ArrayList<Integer>();
		ArrayList<Integer> izvuceniBrojevi = new ArrayList<Integer>();
		int i = 1, ib = 1, broj = 0, prvi = 0, drugi = 0;
		
		System.out.println("Prvi igrač neka unese 10 brojeva:");
		brojevi(prviIgrac, i);
		
		i = 1;
		System.out.println("Drugi igrač neka unese 10 brojeva:");
		brojevi(drugiIgrac, i);
		
		System.out.println(prviIgrac);
		System.out.println(drugiIgrac);
		
		while(ib < 101) {
			while(broj < 1 || izvuceniBrojevi.contains(broj)) {
				broj = (int)(Math.random() * 100);
			}
			Thread.sleep(500);
			izvuceniBrojevi.add(broj);
			System.out.println(ib + ". izvučeni broj: " + broj);
			ib++;
			if(prviIgrac.contains(broj)) {
				prvi++;
				Thread.sleep(1000);
				System.out.println("Pogodak prvi igrač: " + prvi);
			}
			if(drugiIgrac.contains(broj)) {
				drugi++;
				Thread.sleep(1000);
				System.out.println("Pogodak drugi igrač: " + drugi);
			}
			if(prvi == 10 && drugi == 10) {
				System.out.println("Nerešeno!");
				break;
			}
			if(prvi == 10) {
				System.out.println("Bingo! Prvi igrač je pobedio.");
				break;
			}
			if(drugi == 10) {
				System.out.println("Bingo! Drugi igrač je pobedio.");
				break;
			}
		}
		System.out.println("Prvi igrač: " + prvi + "\nDrugi igrač: " + drugi);
	}

}
