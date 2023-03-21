package povezivanje;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class RuletMySQL {
	static Scanner ulaz = new Scanner(System.in);
	int q = 1;
		public void rulet(int isplata) {
			if(q == 1) {
			uplataIsplata(isplata);
			q++;
			}
			if(isplata < 1) {
				System.out.println("Nemate više kredita");
				return;
			}
			System.out.print("Na koliko brojeva želite da se kladite: ");
			int n = ulaz.nextInt();
			
			int rez = 0, broj = 99, dobitak = 0;
			int [] niz = new int[n * 3];
			int [] ulog = new int[n * 3];
			
			for(int i = 1; i <= n; i++) {
				System.out.println(i + ". broj: ");
				niz[i] = ulaz.nextInt();
				while(niz[i] < 0 || niz[i] >36) {
					System.out.println("Uneli ste nepostojeći broj, unesite ponovo:");
					niz[i] = ulaz.nextInt();
				}
				System.out.println("Koliko novca stavljate na broj: ");
				ulog[i] = ulaz.nextInt();
				while(ulog[i] < 0) {
					System.out.println("Ulog ne može biti manji od nule, unesite ponovo:");
					ulog[i] = ulaz.nextInt();
				}
				rez += ulog[i];
				while(ulog[i] > isplata || rez > isplata) {
					rez = rez - ulog[i];
					System.out.println("Nemate dovoljno kredita, unesite ponovo: ");
					ulog[i] = ulaz.nextInt();
					rez += ulog[i];
				}
			}
			while(broj > 36) {
				broj = (int)(Math.random()* 100);
			}
			System.out.println("Izvučeni broj je: " + broj);
			for(int i = 1; i <= n; i++) {
				if(niz[i] == broj)
					dobitak += ulog[i] * 36;
			}
			if(dobitak > 0)
				System.out.println("Dobili ste: " + dobitak);
			else
				System.out.println("Pokušajte ponovo");
			isplata = isplata - rez + dobitak;
			System.out.println("Stanje: " + isplata);
			System.out.println("Da li želite da nastavite (1: Nastavi, 2: Isplata, 3: Uplati): ");
			int nastavi = ulaz.nextInt();
			if(nastavi == 1) {
				rulet(isplata);
			}
			else if(nastavi == 2) {
				uplataIsplata(-isplata);
				System.out.println("Isplata: " + isplata);
			}
			else if(nastavi == 3) {
				System.out.println("Koliko želite da uplatite:");
				int dodaj = ulaz.nextInt();
				uplataIsplata(dodaj);
				isplata = isplata + dodaj;
				rulet(isplata);
			}
	}
		public void uplataIsplata(int baze) {
			String url = "jdbc:mysql://localhost:3306/RuletBaza";
			String username = "root";
			String password = "";
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				
				String sqlinsert = "INSERT INTO uplaceno(uplataIsplata, vreme)values(?, ?)";
				
				PreparedStatement ps = conn.prepareStatement(sqlinsert);
				ps.setInt(1, baze);
				ps.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime()));
				
				ps.executeUpdate();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	public static void main(String[] args) {
		Scanner ulaz = new Scanner(System.in);
		
		System.out.print("Koliko želite da uplatite: ");
		int uplata = ulaz.nextInt();
		while(uplata < 1) {
			System.out.println("Greška, uplata mora biti veća od nule. Unesite ponovo:");
			uplata = ulaz.nextInt();
		}
		
		RuletMySQL obj = new RuletMySQL();
		obj.rulet(uplata);
		
		ulaz.close();

	}
}
