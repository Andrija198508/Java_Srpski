package iksoks;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Iks_Oks implements ActionListener{
	
	JFrame okvir;
	JTextField tekst;
	Font myFont = new Font("Ink free", Font.BOLD, 50);
	Font dugmiciFont = new Font("Ink free", Font.BOLD, 150);
	JPanel panel;
	JButton[] dugmici = new JButton[9];
	boolean prviIgrac = true;
	
	Iks_Oks(){
		okvir = new JFrame("Iks-Oks");
		okvir.setSize(600, 600);
		okvir.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		okvir.setLocationRelativeTo(null);
		okvir.setLayout(null);
		okvir.setResizable(false);
		
		tekst = new JTextField();
		tekst.setBounds(0, 0, 600, 100);
		tekst.setFont(myFont);
		tekst.setText("IKS-OKS");
		tekst.setBackground(Color.red);
		tekst.setEditable(false);
		tekst.setHorizontalAlignment(JTextField.CENTER);
		tekst.setFocusable(false);
		
		for(int i = 0; i < dugmici.length; i++) {
			dugmici[i] = new JButton();
			dugmici[i].addActionListener(this);
			dugmici[i].setFont(dugmiciFont);
			dugmici[i].setFocusable(false);
			dugmici[i].setText(String.valueOf(i + 1));
		}
		
		panel = new JPanel();
		panel.setBounds(0, 100, 600, 465);
		panel.setBackground(Color.blue);
		panel.setLayout(new GridLayout(3,3));
		
		panel.add(dugmici[0]);
		panel.add(dugmici[1]);
		panel.add(dugmici[2]);
		panel.add(dugmici[3]);
		panel.add(dugmici[4]);
		panel.add(dugmici[5]);
		panel.add(dugmici[6]);
		panel.add(dugmici[7]);
		panel.add(dugmici[8]);
		
		okvir.add(panel);
		okvir.add(tekst);
		okvir.setVisible(true);
	}
	
	public void pobednik() {
		if(dugmici[0].getText() == dugmici[1].getText() && dugmici[2].getText() == dugmici[1].getText()) {
			if(dugmici[0].getText() == "X") {
				tekst.setText("Pobednik je prvi igrac");
				dugmici[0].setBackground(Color.green);
				dugmici[1].setBackground(Color.green);
				dugmici[2].setBackground(Color.green);
			}
			else {
				tekst.setText("Pobednik je drugi igrac");
				dugmici[0].setBackground(Color.green);
				dugmici[1].setBackground(Color.green);
				dugmici[2].setBackground(Color.green);
			}
			kraj();
		}
		
		if(dugmici[3].getText() == dugmici[4].getText() && dugmici[5].getText() == dugmici[4].getText()) {
			if(dugmici[3].getText() == "X") {
				tekst.setText("Pobednik je prvi igrac");
				dugmici[3].setBackground(Color.green);
				dugmici[4].setBackground(Color.green);
				dugmici[5].setBackground(Color.green);
			}
			else {
				tekst.setText("Pobednik je drugi igrac");
				dugmici[3].setBackground(Color.green);
				dugmici[4].setBackground(Color.green);
				dugmici[5].setBackground(Color.green);
			}
			kraj();
		}
		
		if(dugmici[6].getText() == dugmici[7].getText() && dugmici[8].getText() == dugmici[7].getText()) {
			if(dugmici[6].getText() == "X") {
				tekst.setText("Pobednik je prvi igrac");
				dugmici[6].setBackground(Color.green);
				dugmici[7].setBackground(Color.green);
				dugmici[8].setBackground(Color.green);
			}
			else {
				tekst.setText("Pobednik je drugi igrac");
				dugmici[6].setBackground(Color.green);
				dugmici[7].setBackground(Color.green);
				dugmici[8].setBackground(Color.green);
			}
			kraj();
		}
		
		if(dugmici[0].getText() == dugmici[4].getText() && dugmici[8].getText() == dugmici[4].getText()) {
			if(dugmici[0].getText() == "X") {
				tekst.setText("Pobednik je prvi igrac");
				dugmici[0].setBackground(Color.green);
				dugmici[4].setBackground(Color.green);
				dugmici[8].setBackground(Color.green);
			}
			else {
				tekst.setText("Pobednik je drugi igrac");
				dugmici[0].setBackground(Color.green);
				dugmici[4].setBackground(Color.green);
				dugmici[8].setBackground(Color.green);
			}
			kraj();
		}
		
		if(dugmici[6].getText() == dugmici[4].getText() && dugmici[2].getText() == dugmici[4].getText()) {
			if(dugmici[6].getText() == "X") {
				tekst.setText("Pobednik je prvi igrac");
				dugmici[6].setBackground(Color.green);
				dugmici[4].setBackground(Color.green);
				dugmici[2].setBackground(Color.green);
			}
			else {
				tekst.setText("Pobednik je drugi igrac");
				dugmici[6].setBackground(Color.green);
				dugmici[4].setBackground(Color.green);
				dugmici[2].setBackground(Color.green);
			}
			kraj();
		}
		
		if(dugmici[0].getText() == dugmici[3].getText() && dugmici[6].getText() == dugmici[3].getText()) {
			if(dugmici[0].getText() == "X") {
				tekst.setText("Pobednik je prvi igrac");
				dugmici[0].setBackground(Color.green);
				dugmici[3].setBackground(Color.green);
				dugmici[6].setBackground(Color.green);
			}
			else {
				tekst.setText("Pobednik je drugi igrac");
				dugmici[0].setBackground(Color.green);
				dugmici[3].setBackground(Color.green);
				dugmici[6].setBackground(Color.green);
			}
			kraj();
		}
		
		if(dugmici[1].getText() == dugmici[4].getText() && dugmici[4].getText() == dugmici[7].getText()) {
			if(dugmici[1].getText() == "X") {
				tekst.setText("Pobednik je prvi igrac");
				dugmici[1].setBackground(Color.green);
				dugmici[4].setBackground(Color.green);
				dugmici[7].setBackground(Color.green);
			}
			else {
				tekst.setText("Pobednik je drugi igrac");
				dugmici[1].setBackground(Color.green);
				dugmici[4].setBackground(Color.green);
				dugmici[7].setBackground(Color.green);
			}
			kraj();
		}
		
		if(dugmici[2].getText() == dugmici[5].getText() && dugmici[8].getText() == dugmici[5].getText()) {
			if(dugmici[2].getText() == "X") {
				tekst.setText("Pobednik je prvi igrac");
				dugmici[2].setBackground(Color.green);
				dugmici[5].setBackground(Color.green);
				dugmici[8].setBackground(Color.green);
			}
			else {
				tekst.setText("Pobednik je drugi igrac");
				dugmici[2].setBackground(Color.green);
				dugmici[5].setBackground(Color.green);
				dugmici[8].setBackground(Color.green);
			}
			kraj();
		}
	}
	
	public void kraj() {
			for(int i = 0; i < dugmici.length; i++) {
				dugmici[i].setEnabled(false);
		}
	}
	
	public static void main(String[] args) {
		new Iks_Oks();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(prviIgrac) {
			for(int i = 0; i < dugmici.length; i++) {
				if(e.getSource() == dugmici[i]) {
					dugmici[i].setText("X");
					dugmici[i].setEnabled(false);
					prviIgrac = false;
					pobednik();
				}
			}
		}
		else
			for(int i = 0; i < dugmici.length; i++){
				if(e.getSource() == dugmici[i]) {
					dugmici[i].setText("O");
					dugmici[i].setEnabled(false);
					prviIgrac = true;
					pobednik();
				}
			}
	}

}
