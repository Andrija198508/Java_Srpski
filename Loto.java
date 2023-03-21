package loto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Loto {
	
	public static void main(String[] args) throws InterruptedException {
		Scanner ulaz = new Scanner(System.in);
		
		List<Integer> brojevi = new ArrayList<Integer>();
		List<Integer> izvuceniBrojevi = new ArrayList<Integer>();
		int i = 1, broj = 0;
		do{
			System.out.println("Unesite " + i + ". broj:");
			broj = ulaz.nextInt();
			while(broj < 1 || broj > 39 || brojevi.contains(broj)) {
				System.out.println("Greška, unesite ponovo:");
				broj = ulaz.nextInt();
			}
			brojevi.add(broj);
			i++;
		}while(i < 8);
		
		System.out.println("Odigrali ste brojeve: " + brojevi);
		
		i = 1;
		do {
			while(broj < 1 || broj > 39 || izvuceniBrojevi.contains(broj)) {
			broj = (int)(Math.random()* 100);
			}
			Thread.sleep(1500);
			System.out.println(i + ". izvučeni broj je: " + broj);
			izvuceniBrojevi.add(broj);
			i++;
		}while(i < 8);
		
		System.out.println("Izvučeni brojevi su: " + izvuceniBrojevi);
		i = 0;
		Iterator<Integer> iter = izvuceniBrojevi.iterator();
		while(iter.hasNext()) {
			if(brojevi.contains(iter.next())) {
				i++;
			}
		}
		System.out.println("Imate " + i + " pogodaka");
		ulaz.close();
	}

}
