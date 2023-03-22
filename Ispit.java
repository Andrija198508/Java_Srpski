package vezbanje;

import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ispit extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JRadioButton dugme;
	JRadioButton dugme2;
	JRadioButton dugme3;
	JButton sledece;
	JLabel label;
	int pitanjeBroj = 1, tacniOdgovori = 0;
	
	Ispit(){
		
		label = new JLabel();
		label.setBounds(30, 40, 450, 20);  
		
		dugme = new JRadioButton();
		dugme2 = new JRadioButton();
		dugme3 = new JRadioButton();
		
		dugme.setBounds(20, 80, 200, 20);
		dugme2.setBounds(20, 110, 200, 20);
		dugme3.setBounds(20, 140, 200, 20);
		
		dugme.addActionListener(this);
		dugme2.addActionListener(this);
		dugme3.addActionListener(this);
		
		dodavanjePitanja();
		
		ButtonGroup group = new ButtonGroup();
		group.add(dugme);
		group.add(dugme2);
		group.add(dugme3);
		
		sledece = new JButton("Sledeće");
		sledece.setBounds(450, 150, 100, 50);
		sledece.addActionListener(this);
		
		add(sledece);
		add(label);
		add(dugme);
		add(dugme2);
		add(dugme3);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setLayout(null);
		setVisible(true);
		setLocation(350, 250);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sledece) {
			proveriOdgovor();
			pitanjeBroj++;
			dodavanjePitanja();
		}
	}
	
	void dodavanjePitanja(){
		if(pitanjeBroj == 1) {
		label.setText("Kako se zove predsednik Kazahstana:");
		dugme.setText("Nursultan Nazarbajev");
		dugme2.setText("Kasim Žomart Tokajev");
		dugme3.setText("Šavkat Mirzijojev");
		}
		if(pitanjeBroj == 2) {
			label.setText("Kako se zove premijer Izraela:");
			dugme.setText("Benjamin Netanjahu");
			dugme2.setText("Golda Meir");
			dugme3.setText("Jair Lapip");
		}
		if(pitanjeBroj == 3) {
			label.setText("Kako se zove bivši predsednik Ekvadora:");
			dugme.setText("Staljin Moreno");
			dugme2.setText("Lenjin Moreno");
			dugme3.setText("Tito Moreno");
		}
		if(pitanjeBroj == 4) {
			label.setText("Kako se zove predsednik Sirije:");
			dugme.setText("Bašar el Asad");
			dugme2.setText("Redžep Tajip Erdoan");
			dugme3.setText("Hafez el Asad");
		}
		if(pitanjeBroj == 5) {
			label.setText("Kako se zove predsednik Hrvatske:");
			dugme.setText("Andrej Plenković");
			dugme2.setText("Zdravko Mamić");
			dugme3.setText("Zoran Milanović");
			sledece.setText("Rezultat");
		}
		if(pitanjeBroj == 6) {
			JOptionPane.showMessageDialog(this, "Tačnih odgovora: " + tacniOdgovori + "/5");
		}
	}
	
	void proveriOdgovor() {
		if(pitanjeBroj == 1 && dugme.isSelected()) {
			tacniOdgovori++;
		}
		if(pitanjeBroj == 2 && dugme.isSelected()) {
			tacniOdgovori++;
		}
		if(pitanjeBroj == 3 && dugme2.isSelected()) {
			tacniOdgovori++;
		}
		if(pitanjeBroj == 4 && dugme.isSelected()) {
			tacniOdgovori++;
		}
		if(pitanjeBroj == 5 && dugme3.isSelected()) {
			tacniOdgovori++;
		}
	}
	public static void main(String[] args) {
		new Ispit();
	}
}
