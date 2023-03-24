package andrija;

public class ArmstrongoviBrojevi {

	public static void main(String[] args) {
		
		for(int i = 100; i < 1001; i++) {
			int x, z = i, y = 0;
			while(z != 0) {
				x = z % 10;
				x = x * x * x;
				y = y + x;
				z = z / 10;
			}
			if(y == i) {
				System.out.println(i);
			}
		}
	}

}
