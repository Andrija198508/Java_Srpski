package poker2;

import java.util.ArrayList;

public class Dobitak2 {
		int dobijeno;

		public void dobitak(ArrayList<String> dob, int ulog) {
			dobijeno = 0;
			String index[] = new String[100];
			int srce = 0, karo = 0, tref = 0, pik = 0, dzoker = 0;
			int [] q = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			for(int i = 0; i < 5; i++) {
				index[i] = dob.get(i);
				if (index[i].contains("Srce")) {
					srce++;
				}
				if(index[i].contains("Karo")) {
					karo++;
				}
				if(index[i].contains("Tref")) {
					tref++;
				}
				if(index[i].contains("Pik")) {
					pik++;
				}
				if(index[i].contains("Žandar")) {
					q[9]++;
				}
				if(index[i].contains("Dama")) {
					q[10]++;
				}
				if(index[i].contains("Kralj")){
					q[11]++;
				}
				if(index[i].contains("Kec")) {
					q[12]++;
				}
				if(index[i].contains("2")) {
					q[0]++;
				}
				if(index[i].contains("3")) {
					q[1]++;
				}
				if(index[i].contains("4")) {
					q[2]++;
				}
				if(index[i].contains("5")) {
					q[3]++;
				}
				if(index[i].contains("6")) {
					q[4]++;
				}
				if(index[i].contains("7")) {
					q[5]++;
				}
				if(index[i].contains("8")) {
					q[6]++;
				}
				if(index[i].contains("9")) {
					q[7]++;
				}
				if(index[i].contains("0")) {
					q[8]++;
				}
				if(index[i].contains("Džoker")) {
					dzoker = 1;
				}
			}
			
			//par
			if(q[9] == 2 || q[10] == 2 || q[11] == 2 || q[12] == 2) {
				dobijeno = ulog;
			}
			if((q[9] == 1 || q[10] == 1 || q[11] == 1 || q[12] == 1) && dzoker == 1) {
				dobijeno = ulog;
			}
			//dva para
			int par = 0;
			for(int i = 0; i < 13; i++) {
				if(q[i] == 2) {
					par++;
				}
				if(par == 2) {
					dobijeno = ulog * 2;
				}
				if(par == 1 && dzoker == 1) {
					dobijeno = ulog * 2;
				}
			}
			//triling
			for(int i = 0; i < 13; i++) {
				if(q[i] == 3) {
					dobijeno = ulog * 3;
				}
				if(q[i] == 2 && dzoker == 1) {
					dobijeno = ulog * 3;
				}
			}
			//skala
			boolean skala = false;
			for(int i = 0; i < 9; i++) {
				if(q[i] > 0) {
					if(q[i] == q[i + 1] && q[i] == q[i + 2] && q[i] == q[i + 3] && q[i] == q[i + 4]) {
						skala = true;
					}
					if(q[12] == 1 && q[0] == 1 && q[1] == 1 && q[2] == 1 && q[3] == 1) {
						skala = true;
					}
					if(q[i] == q[i + 1] && q[i] == q[i + 2] && q[i] == q[i + 3] && dzoker == 1) {
						skala = true;
					}
					if(q[i] == q[i + 1] && q[i] == q[i + 2] && q[i] == q[i + 4] && dzoker == 1) {
						skala = true;
					}
					if(q[i] == q[i + 1] && q[i] == q[i + 3] && q[i] == q[i + 4] && dzoker == 1) {
						skala = true;
					}
					if(q[i] == q[i + 2] && q[i] == q[i + 3] && q[i] == q[i + 4] && dzoker == 1) {
						skala = true;
					}
				}
				if(q[9] == q[10] && q[11] == q[12] && dzoker == 1) {
					skala = true;
				}
				if(skala == true) {
					dobijeno = ulog * 4;
				}
			}
			//boja
			boolean boja = false;
			if(srce == 5 || karo == 5 || tref == 5 || pik == 5) {
				dobijeno = ulog * 6;
				boja = true;
			}
			if((srce == 4 || karo == 4 || tref == 4 || pik == 4) && dzoker == 1) {
				dobijeno = ulog * 6;
				boja = true;
			}
			//full
			int full = 0, full2 = 0;
			for(int i = 0; i < 13; i++) {
				if(q[i] == 3) {
					full++;
				}
				if(q[i] == 2) {
					full2++;
				}
				if((full == 1 && full2 == 1) || (full2 == 2 && dzoker == 1)) {
					dobijeno = ulog * 9;
				}
			}
			//poker
			for(int i = 0; i < 13; i++) {
				if(q[i] == 4 || (q[i] == 3 && dzoker == 1)) {
					dobijeno = ulog * 25;
				}
			}
			//skala u boji i fleš rojal
			int flesRojalSaDzokerom = 0;
			for(int h = 8; h < 13; h++) {
				if(q[h] == 1) {
					flesRojalSaDzokerom++;
				}
			}
			if(skala == true && boja == true) {
				dobijeno = ulog * 50;
				if((q[12] == 1 && q[11] == 1) || (flesRojalSaDzokerom == 4 && dzoker == 1)) {
					dobijeno = ulog * 250;
				}
			}
			//pet istih
			for(int i = 0; i < 13; i++) {
				if(q[i] == 4 && dzoker == 1) {
					dobijeno = ulog * 500;
				}
			}
		}
}
