package andrija;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class DigitronGUI implements ActionListener{
	
	JFrame okvir;
	JTextField tekst;
	Font font;
	JButton[] brojevi;
	JButton[] funkcije;
	JButton plus, minus, mnozenje, deljenje, zarez, jednako, obrisi;
	JPanel panel;
	DecimalFormat df = new DecimalFormat("#.######");
	Border border = BorderFactory.createLineBorder(Color.green, 3);
	
	double prviBroj = 0, drugiBroj = 0, rezultat = 0;
	char f;
	
	DigitronGUI(){
		okvir = new JFrame("Digitron");
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setSize(400, 550);
		okvir.setLayout(null);
		okvir.setLocationRelativeTo(null);
		
		font = new Font("MV Boli", Font.BOLD, 35);
		
		tekst = new JTextField();
		tekst.setFont(font);
		tekst.setBounds(50, 25, 300, 50);
		tekst.setEditable(false);
		tekst.setBackground(Color.white);
		
		brojevi = new JButton[10];
		for(int i = 0; i < 10; i++) {
			brojevi[i] = new JButton(String.valueOf(i));
			brojevi[i].setFont(font);
			brojevi[i].setFocusable(false);
			brojevi[i].addActionListener(this);
			brojevi[i].setBorder(border);
		}
		
		plus = new JButton("+");
		minus = new JButton("-");
		mnozenje = new JButton("*");
		deljenje = new JButton("/");
		zarez = new JButton(".");
		jednako = new JButton("=");
		
		funkcije = new JButton[6];
		funkcije[0] = plus;
		funkcije[1] = minus;
		funkcije[2] = mnozenje;
		funkcije[3] = deljenje;
		funkcije[4] = zarez;
		funkcije[5] = jednako;
		for(int i = 0; i < 6; i++) {
			funkcije[i].setFont(font);
			funkcije[i].addActionListener(this);
			funkcije[i].setFocusable(false);
			funkcije[i].setBorder(border);
		}
		
		obrisi = new JButton("Obrisi");
		obrisi.setBounds(50, 430, 170, 50);
		obrisi.setFont(font);
		obrisi.addActionListener(this);
		obrisi.setFocusable(false);
		obrisi.setBorder(border);
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		panel.add(brojevi[7]);
		panel.add(brojevi[8]);
		panel.add(brojevi[9]);
		panel.add(funkcije[0]);
		
		panel.add(brojevi[4]);
		panel.add(brojevi[5]);
		panel.add(brojevi[6]);
		panel.add(funkcije[1]);
		
		panel.add(brojevi[1]);
		panel.add(brojevi[2]);
		panel.add(brojevi[3]);
		panel.add(funkcije[2]);
		
		panel.add(brojevi[0]);
		panel.add(funkcije[4]);
		panel.add(funkcije[5]);
		panel.add(funkcije[3]);
		
		okvir.add(obrisi);
		okvir.add(panel);
		okvir.add(tekst);
		okvir.setVisible(true);
	}
	public static void main(String[] args) {
		new DigitronGUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == brojevi[i]) {
				tekst.setText(tekst.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == zarez) {
			tekst.setText(tekst.getText().concat(String.valueOf(".")));
		}
		
		if(e.getSource() == plus) {
			prviBroj = Double.parseDouble(tekst.getText());
			tekst.setText("");
			f = '+';
		}
		
		if(e.getSource() == minus) {
			prviBroj = Double.parseDouble(tekst.getText());
			tekst.setText("");
			f = '-';
		}
		
		if(e.getSource() == mnozenje) {
			prviBroj = Double.parseDouble(tekst.getText());
			tekst.setText("");
			f = '*';
		}
		
		if(e.getSource() == deljenje) {
			prviBroj = Double.parseDouble(tekst.getText());
			tekst.setText("");
			f = '/';
		}
		
		if(e.getSource() == jednako) {
			drugiBroj = Double.parseDouble(tekst.getText());
			
			if(f == '+') {
				rezultat = prviBroj + drugiBroj;
			}
			
			if(f == '-') {
				rezultat = prviBroj - drugiBroj;
			}
			
			if(f == '*') {
				rezultat = prviBroj * drugiBroj;
			}
			
			if(f == '/') {
				rezultat = prviBroj / drugiBroj;
			}
			
			tekst.setText(String.valueOf(df.format(rezultat)));
			prviBroj = rezultat;
		}
		
		if(e.getSource() == obrisi) {
			tekst.setText("");
		}
	}

}
