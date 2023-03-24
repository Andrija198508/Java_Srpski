package vezbanje;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LotoGUI extends JFrame implements ActionListener{
	
	
	private static final long serialVersionUID = 1L;
	
	Scanner ulaz = new Scanner(System.in);
	List<Integer> brojevi = new ArrayList<Integer>();
	List<Integer> izvuceniBrojevi = new ArrayList<Integer>();
	JPanel panel = new JPanel();
	JTextField tf = new JTextField();
	JButton button = new JButton();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	JLabel label4 = new JLabel();
	JLabel label5 = new JLabel();
	int b = 0;
	
	LotoGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 400);
		setLayout(null);
		setLocationRelativeTo(null);
		setTitle("Loto 7/39");
		
		panel.setBounds(0, 0, 800, 500);
		panel.setBackground(Color.blue);
		panel.setLayout(null);
		
		label.setBounds(0, 0, 800, 50);
		label.setFont(new Font("MV Boli", Font.BOLD, 40));
		label.setText("Unesite 7 brojeva od 1 do 39:");
		
		label2.setBounds(0, 50, 800, 50);
		label2.setFont(new Font("MV Boli", Font.BOLD, 40));
		
		label3.setBounds(0, 100, 800, 50);
		label3.setFont(new Font("MV Boli", Font.BOLD, 40));
		
		label4.setBounds(0, 150, 800, 50);
		label4.setFont(new Font("MV Boli", Font.BOLD, 40));
		
		label5.setBounds(0, 200, 800, 50);
		label5.setFont(new Font("MV Boli", Font.BOLD, 40));
		
		tf = new JTextField();
		tf.setBounds(100, 100, 500, 50);
		tf.setFont(new Font("Consolas", Font.PLAIN, 35));
		tf.setForeground(Color.green);
		tf.setBackground(Color.black);
		tf.setCaretColor(Color.orange);
		
		button.setBounds(100, 200, 100, 50);
		button.setText("dalje");
		button.addActionListener(this);
		button.setFocusable(false);
		
		add(label5);
		add(label4);
		add(label3);
		add(label2);
		add(label);
		add(button);
		add(tf);
		add(panel);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			if(b < 7){
				while(Integer.parseInt(tf.getText()) < 1 || Integer.parseInt(tf.getText()) > 39 || 
						brojevi.contains(Integer.parseInt(tf.getText()))) {
					tf.setText("Greška unesite ponovo");
				}
				brojevi.add(Integer.parseInt(tf.getText()));
				tf.setText("");
				b++;
			}
			if(b == 7) {
				int broj = 99, i = 0;
				button.setVisible(false);
				label.setText("Izvuceni brojevi su:" );
				do {
					while(broj < 1 || broj > 39 || izvuceniBrojevi.contains(broj)) {
					broj = (int)(Math.random()* 100);
					}
					tf.setVisible(false);
					izvuceniBrojevi.add(broj);
					i++;
				}while(i < 8);
				
				label2.setText(izvuceniBrojevi + " ");
				label3.setText("Odigrani brojevi:");
				label4.setText(brojevi + " ");
				
				i = 0;
				Iterator<Integer> iter = izvuceniBrojevi.iterator();
				while(iter.hasNext()) {
					if(brojevi.contains(iter.next())) {
						i++;
					}
				}
				label5.setText("Broj pogodaka: " + i);
			}
		}
	}
	public static void main(String[] args) {
		 new LotoGUI();
	}

}
