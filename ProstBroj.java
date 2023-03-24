package andrija;

public class ProstBroj {

	public static void main(String[] args) {
		
		boolean prostBroj = true;
		
		System.out.println("Prosti brojevi od 1 do 100 su: ");
		for(int i = 1; i < 101; i++) {
			prostBroj = true;
			for(int j = 1; j < i; j++) {
				if(j != i && j != 1 && i % j == 0) 
					prostBroj = false;
			}
			if(prostBroj == true)
				System.out.print(i + " ");
		}
	}

}
