package pokerAparatGUI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Okvir implements ActionListener{
	
	JFrame okvir;
	JTextField stanje, ulog, dobitak, nazivDobitka;
	JButton nastavi, povecaj, smanji, uplati, dupliraj, crvena, crna;
	JButton karta1, karta2, karta3, karta4, karta5;
	
	Font myFont = new Font("Ink free", Font.BOLD, 50);
	Border border = BorderFactory.createLineBorder(Color.green, 3);
	Border borderKarte = BorderFactory.createLineBorder(Color.green, 7);
	
	ImageIcon orao = new ImageIcon(getClass().getClassLoader().getResource("orao.jpg"));
	ImageIcon zamenskaKarta;
	
	int stanjeInt = 0, ulogInt = 0, nastaviInt = 0, dobitakInt = 0, zameniKarte = 5;
	int karta1Int = 0, karta2Int = 0, karta3Int = 0, karta4Int = 0, karta5Int = 0;
	
	ArrayList<String> karte = new ArrayList<String>();
	ArrayList<String> karteDupliranje = new ArrayList<String>();
	Karte k = new Karte();
	Dobitak d = new Dobitak();
	NazivDobitka nd = new NazivDobitka();
	
	Okvir(){
		okvir = new JFrame();
		okvir.setSize(1500, 800);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setLocationRelativeTo(null);
		okvir.setLayout(null);
		okvir.setLayout(new BorderLayout());
		okvir.setContentPane(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("svemir.jpg"))));
		
		stanje = new JTextField();
		stanje.setBounds(1080, 50, 380, 80);
		stanje.setEditable(false);
		stanje.setFont(myFont);
		stanje.setText("Stanje: " + stanjeInt);
		stanje.setBackground(Color.red);
		stanje.setBorder(border);
		stanje.setFocusable(false);
		
		ulog = new JTextField();
		ulog.setBounds(1080, 150, 380, 80);
		ulog.setEditable(false);
		ulog.setFont(myFont);
		ulog.setText("Ulog: " + ulogInt);
		ulog.setBackground(Color.red);
		ulog.setBorder(border);
		ulog.setFocusable(false);
		
		dobitak = new JTextField();
		dobitak.setBounds(300, 50, 545, 80);
		dobitak.setEditable(false);
		dobitak.setFont(myFont);
		dobitak.setBorder(border);
		dobitak.setBackground(Color.red);
		dobitak.setFocusable(false);
		dobitak.setHorizontalAlignment(JTextField.CENTER);
		dobitak.setVisible(false);
		
		nazivDobitka = new JTextField();
		nazivDobitka.setBounds(300, 150, 575, 100);
		nazivDobitka.setEditable(false);
		nazivDobitka.setFont(new Font("Ink free", Font.BOLD, 80));
		nazivDobitka.setForeground(Color.green);
		nazivDobitka.setBorder(BorderFactory.createLineBorder(Color.white, 0));
		nazivDobitka.setOpaque(false);
		nazivDobitka.setFocusable(false);
		nazivDobitka.setHorizontalAlignment(JTextField.CENTER);
		nazivDobitka.setVisible(false);
		
		nastavi = new JButton("Nastavi");
		nastavi.setBounds(1150, 650, 240, 80);
		nastavi.setFont(myFont);
		nastavi.setFocusable(false);
		nastavi.setBorder(border);
		nastavi.addActionListener(this);
		
		povecaj = new JButton("+");
		povecaj.setBounds(1150, 250, 100, 100);
		povecaj.setFont(new Font("Ink free", Font.BOLD, 120));
		povecaj.setFocusable(false);
		povecaj.setBorder(border);
		povecaj.addActionListener(this);
		
		smanji = new JButton("-");
		smanji.setBounds(1280, 250, 100, 100);
		smanji.setFont(new Font("Ink free", Font.BOLD, 120));
		smanji.setFocusable(false);
		smanji.setBorder(border);
		smanji.addActionListener(this);
		
		uplati = new JButton("Uplati");
		uplati.setBounds(50, 50, 180, 80);
		uplati.setFont(myFont);
		uplati.setFocusable(false);
		uplati.setBorder(border);
		uplati.addActionListener(this);
		
		karta1 = new JButton();
		karta1.setBounds(50, 300, 196, 286);
		karta1.setFocusable(false);
		karta1.addActionListener(this);
		karta1.setIcon(orao);
		karta1.setEnabled(true);
		
		karta2 = new JButton();
		karta2.setBounds(260, 300, 196, 286);
		karta2.setFocusable(false);
		karta2.addActionListener(this);
		karta2.setIcon(orao);
		karta2.setEnabled(true);
		
		karta3 = new JButton();
		karta3.setBounds(470, 300, 196, 286);
		karta3.setFocusable(false);
		karta3.addActionListener(this);
		karta3.setIcon(orao);
		karta3.setEnabled(true);
		
		karta4 = new JButton();
		karta4.setBounds(680, 300, 196, 286);
		karta4.setFocusable(false);
		karta4.addActionListener(this);
		karta4.setIcon(orao);
		karta4.setEnabled(true);
		
		karta5 = new JButton();
		karta5.setBounds(890, 300, 196, 286);
		karta5.setFocusable(false);
		karta5.addActionListener(this);
		karta5.setIcon(orao);
		karta5.setEnabled(true);
		
		dupliraj = new JButton("Dupliraj dobitak");
		dupliraj.setBounds(360, 650, 440, 100);
		dupliraj.setFont(new Font("Ink free", Font.BOLD, 60));
		dupliraj.setFocusable(false);
		dupliraj.setBorder(border);
		dupliraj.addActionListener(this);
		dupliraj.setVisible(false);
		
		crvena = new JButton("Crvena");
		crvena.setBounds(220, 380, 240, 100);
		crvena.setBackground(Color.red);
		crvena.setFont(new Font("Ink free", Font.BOLD, 60));
		crvena.setFocusable(false);
		crvena.setVisible(false);
		crvena.addActionListener(this);
		
		crna = new JButton("Crna");
		crna.setBounds(680, 380, 240, 100);
		crna.setBackground(Color.black);
		crna.setFont(new Font("Ink free", Font.BOLD, 60));
		crna.setForeground(Color.white);
		crna.setFocusable(false);
		crna.setVisible(false);
		crna.addActionListener(this);
		
		okvir.add(crna);
		okvir.add(crvena);
		okvir.add(dupliraj);
		okvir.add(karta5);
		okvir.add(karta4);
		okvir.add(karta3);
		okvir.add(karta2);
		okvir.add(karta1);
		okvir.add(nazivDobitka);
		okvir.add(dobitak);
		okvir.add(uplati);
		okvir.add(smanji);
		okvir.add(povecaj);
		okvir.add(nastavi);
		okvir.add(ulog);
		okvir.add(stanje);
		okvir.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == povecaj) {
			if(((ulogInt + 1) <= stanjeInt) && ulogInt <= 9) {
			ulogInt++;
			ulog.setText("Ulog: " + ulogInt);
			}
			else if(ulogInt >= 10 && (ulogInt + 5) <= stanjeInt && ulogInt < 50) {
				ulogInt = ulogInt + 5;
				ulog.setText("Ulog: " + ulogInt);
			}
			else if(ulogInt >= 50 && ulogInt <= 175 && (ulogInt + 25) <= stanjeInt) {
				ulogInt = ulogInt + 25;
				ulog.setText("Ulog: " + ulogInt);
			}
			else if(ulogInt >= 200 && ulogInt <= 450 && (ulogInt + 50) <= stanjeInt) {
				ulogInt = ulogInt + 50;
				ulog.setText("Ulog: " + ulogInt);
			}
			else if(ulogInt >= 500 && (ulogInt + 100) <= stanjeInt) {
				ulogInt = ulogInt + 100;
				ulog.setText("Ulog: " + ulogInt);
			}
		}
		
		if(e.getSource() == smanji) {
			if(ulogInt >= 1 && ulogInt < 11) {
			ulogInt--;
			ulog.setText("Ulog: " + ulogInt);
			}
			else if (ulogInt > 14 && ulogInt <= 50) {
				ulogInt = ulogInt - 5;
				ulog.setText("Ulog: " + ulogInt);
			}
			else if(ulogInt > 50 && ulogInt <= 200) {
				ulogInt = ulogInt - 25;
				ulog.setText("Ulog: " + ulogInt);
			}
			else if(ulogInt >= 250 && ulogInt <= 500) {
				ulogInt = ulogInt - 50;
				ulog.setText("Ulog: " + ulogInt);
			}
			else if(ulogInt > 500) {
				ulogInt = ulogInt - 100;
				ulog.setText("Ulog: " + ulogInt);
			}
		}
		
		if(e.getSource() == uplati) {
			String m = JOptionPane.showInputDialog("Koliko zelite da uplatite:");
			stanjeInt = stanjeInt + Integer.parseInt(m);
			stanje.setText("Stanje: " + stanjeInt);
		}
		
		if(e.getSource() == nastavi) {
			if(stanjeInt >= ulogInt && nastaviInt == 0 && ulogInt > 0) {
				if(nastaviInt == 0)
					stanjeInt = stanjeInt - ulogInt;
					stanje.setText("Stanje: " + stanjeInt);
					povecaj.setEnabled(false);
					smanji.setEnabled(false);
					nastaviInt++;
					k.podeliKarte(karte, 0);
					
					dobitakInt = d.dobitak(karte, ulogInt);
					
					if(dobitakInt > 0) {
						nazivDobitka.setVisible(true);
						nazivDobitka.setText(nd.naziv(dobitakInt, ulogInt));
					}
					
					ImageIcon k1 = new ImageIcon(getClass().getClassLoader().getResource(karte.get(0)));
					karta1.setIcon(k1);
					ImageIcon k2 = new ImageIcon(getClass().getClassLoader().getResource(karte.get(1)));
					karta2.setIcon(k2);
					ImageIcon k3 = new ImageIcon(getClass().getClassLoader().getResource(karte.get(2)));
					karta3.setIcon(k3);
					ImageIcon k4 = new ImageIcon(getClass().getClassLoader().getResource(karte.get(3)));
					karta4.setIcon(k4);
					ImageIcon k5 = new ImageIcon(getClass().getClassLoader().getResource(karte.get(4)));
					karta5.setIcon(k5);
				}
				
			else if(nastaviInt == 1) {
					
					k.podeliKarte(karte, (karta1Int + karta2Int + karta3Int + karta4Int + karta5Int));
					int b = 0;
					if(karta1Int == 0) {
						karte.remove(0);
						b++;
					}
					if(karta2Int == 0) {
						karte.remove(1 - b);
						b++;
					}
					if(karta3Int == 0) {
						karte.remove(2 - b);
						b++;
					}
					if(karta4Int == 0) {
						karte.remove(3 - b);
						b++;
					}
					if(karta5Int == 0) {
						karte.remove(4 - b);
						b++;
					}
					
					ImageIcon k6 = new ImageIcon(getClass().getClassLoader().getResource(karte.get(0)));
					karta1.setIcon(k6);
					ImageIcon k7 = new ImageIcon(getClass().getClassLoader().getResource(karte.get(1)));
					karta2.setIcon(k7);
					ImageIcon k8 = new ImageIcon(getClass().getClassLoader().getResource(karte.get(2)));
					karta3.setIcon(k8);
					ImageIcon k9 = new ImageIcon(getClass().getClassLoader().getResource(karte.get(3)));
					karta4.setIcon(k9);
					ImageIcon k10 = new ImageIcon(getClass().getClassLoader().getResource(karte.get(4)));
					karta5.setIcon(k10);
					
					zamenskaKarta = new ImageIcon(getClass().getClassLoader().getResource(karte.get(2)));
					
					dobitakInt = d.dobitak(karte, ulogInt);
					
					karta1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
					karta2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
					karta3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
					karta4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
					karta5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
					
					if(dobitakInt > 0) {
						dupliraj.setVisible(true);
						nazivDobitka.setVisible(true);
						dobitak.setVisible(true);
						dobitak.setText("Dobitak: " + dobitakInt);
						nazivDobitka.setText(nd.naziv(dobitakInt, ulogInt));
						nastaviInt++;
					}
					else {
						karte.removeAll(karte);
						
						karta1Int = 0;
						karta2Int = 0;
						karta3Int = 0;
						karta4Int = 0;
						karta5Int = 0;
						
						nastaviInt = 0;
						
						nazivDobitka.setVisible(false);
						povecaj.setEnabled(true);
						smanji.setEnabled(true);
					}
				}
			else if(nastaviInt == 2) {
				stanjeInt = stanjeInt + dobitakInt;
				stanje.setText("Stanje: " + stanjeInt);
				
				karte.removeAll(karte);
				karteDupliranje.removeAll(karteDupliranje);
				
				karta1Int = 0;
				karta2Int = 0;
				karta3Int = 0;
				karta4Int = 0;
				karta5Int = 0;
				
				karta1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				karta2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				karta3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				karta4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				karta5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				
				karta1.setVisible(true);
				karta2.setVisible(true);
				karta4.setVisible(true);
				karta5.setVisible(true);
				
				karta3.setIcon(zamenskaKarta);
				
				crvena.setVisible(false);
				crna.setVisible(false);
				
				nastaviInt = 0;
				
				nazivDobitka.setVisible(false);
				dobitak.setVisible(false);
				povecaj.setEnabled(true);
				smanji.setEnabled(true);
				dupliraj.setVisible(false);
			}
		}
		
		if(e.getSource() == karta1) {
			if(karta1Int == 0 && nastaviInt == 1) {
				karta1.setBorder(borderKarte);
				karta1Int++;
			}
			else if(karta1Int == 1 && nastaviInt == 1){
				karta1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				karta1Int = 0;
			}
		}
		
		if(e.getSource() == karta2) {
			if(karta2Int == 0 && nastaviInt == 1) {
				karta2.setBorder(borderKarte);
				karta2Int++;
			}
			else if(karta2Int == 1 && nastaviInt == 1){
				karta2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				karta2Int = 0;
			}
		}
		
		if(e.getSource() == karta3) {
			if(karta3Int == 0 && nastaviInt == 1) {
				karta3.setBorder(borderKarte);
				karta3Int++;
			}
			else if(karta3Int == 1 && nastaviInt == 1){
				karta3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				karta3Int = 0;
			}
		}
		
		if(e.getSource() == karta4) {
			if(karta4Int == 0 && nastaviInt == 1) {
				karta4.setBorder(borderKarte);
				karta4Int++;
			}
			else if(karta4Int == 1 && nastaviInt == 1){
				karta4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				karta4Int = 0;
			}
		}
		
		if(e.getSource() == karta5) {
			if(karta5Int == 0 && nastaviInt == 1) {
				karta5.setBorder(borderKarte);
				karta5Int++;
			}
			else if(karta5Int == 1 && nastaviInt == 1){
				karta5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
				karta5Int = 0;
			}
		}
		
		if(e.getSource() == dupliraj) {
			karta1.setVisible(false);
			karta2.setVisible(false);
			karta4.setVisible(false);
			karta5.setVisible(false);
			
			karte.removeAll(karte);
			k.podeliKarte(karteDupliranje, 4);
			
			orao = new ImageIcon(getClass().getClassLoader().getResource("orao.jpg"));
			karta3.setIcon(orao);
			
			dupliraj.setVisible(false);
			crvena.setVisible(true);
			crna.setVisible(true);
		}
		
		if(e.getSource() == crvena) {
			k.podeliKarte(karteDupliranje, 4);
			orao = new ImageIcon(getClass().getClassLoader().getResource(karteDupliranje.get(karteDupliranje.size()-1)));
			karta3.setIcon(orao);
			
			if(karteDupliranje.get(karteDupliranje.size()-1).contains("Srce") || 
					karteDupliranje.get(karteDupliranje.size()-1).contains("Karo") || 
					karteDupliranje.get(karteDupliranje.size()-1).contains("Džoker")) {
				dobitakInt = dobitakInt * 2;
				dobitak.setText("Dobitak: " + dobitakInt);
			}
			else {
				dobitakInt = 0;
				dobitak.setText("Dobitak: " + dobitakInt);
				dupliraj.setVisible(false);
				crvena.setVisible(false);
				crna.setVisible(false);
			}
		}
		
		if(e.getSource() == crna) {
			k.podeliKarte(karteDupliranje, 4);
			orao = new ImageIcon(getClass().getClassLoader().getResource(karteDupliranje.get(karteDupliranje.size()-1)));
			karta3.setIcon(orao);
			if(karteDupliranje.get(karteDupliranje.size()-1).contains("Tref") || 
					karteDupliranje.get(karteDupliranje.size()-1).contains("Pik") || 
					karteDupliranje.get(karteDupliranje.size()-1).contains("Džoker")) {
				dobitakInt = dobitakInt * 2;
				dobitak.setText("Dobitak: " + dobitakInt);
			}
			else {
				dobitakInt = 0;
				dobitak.setText("Dobitak: " + dobitakInt);
				dupliraj.setVisible(false);
				crvena.setVisible(false);
				crna.setVisible(false);
			}
		}
	}

}
