package pokerAparatGUI;

public class NazivDobitka {
		
		
		public String naziv(int dobitakInt, int ulogInt) {
			String d = "";
			
			if(dobitakInt / ulogInt == 500) {
				d = "PET ISTIH";
			}
			else if(dobitakInt / ulogInt == 250) {
				d = "FLES ROJAL";
			}
			else if(dobitakInt / ulogInt == 50) {
				d = "SKALA U BOJI";
			}
			else if(dobitakInt / ulogInt == 25) {
				d = "POKER";
			}
			else if(dobitakInt / ulogInt == 9) {
				d = "FUL";
			}
			else if(dobitakInt / ulogInt == 6) {
				d = "BOJA";
			}
			else if(dobitakInt / ulogInt == 4) {
				d = "SKALA";
			}
			else if(dobitakInt / ulogInt == 3) {
				d = "TRILING";
			}
			else if(dobitakInt / ulogInt == 2) {
				d = "DVA PARA";
			}
			else if(dobitakInt / ulogInt == 1) {
				d = "PAR";
			}
			return d;
		}
}
