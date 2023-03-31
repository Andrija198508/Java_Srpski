package kazino_awt;

import java.awt.event.*;  

import javax.swing.*;  
  
class Main extends JFrame implements ActionListener  
{  
    // Kreiranje Label-a, dugmadi i potvrdnih dugmadi
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg;  
    int count = 0, current = 0, x = 1, y = 1, now = 0;  
    int m[]=new int[10];      
    Main(String s)  
    {  
        // Dodavanje labela i dugmadi, kao i kreiranje for petlje za odabir odgovora
        super(s);  
        l = new JLabel();  
        add(l);  
        bg = new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i] = new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        // Dodavanje dugmadi za iduće pitanje i označavanje za kasnije odgovaranje
        b1 = new JButton("Iduće");  
        b2 = new JButton("Označi");  
        b1.addActionListener(this);  
        b2.addActionListener(this); 
        
        // Dodavanje elemenata na Frame
        add(b1);
        add(b2);  
        set();  
        
        l.setBounds(30,40,450,20);  
        
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);
        
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,150,30); 
        
        // Podešavanje veličine i prikaza našeg Frame-a
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    // Dodavanje rukovatelja događaja
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1)  
        {  
            if(check())  
                count = count+1;  
                current++;  
                set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setText("Rezultat");  
            }  
        }  
        if(e.getActionCommand().equals("Označi"))  
        {  
            JButton bk = new JButton("Označno "+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x] = current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Rezultat");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Označi "+y))  
        {  
            if(check())  
                count = count+1;  
                now = current;  
                current=m[y];  
                set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current = now;  
            }  
        }  
      
        if(e.getActionCommand().equals("Rezultat"))  
        {  
            if(check())  
                count = count+1;  
                current++;  
                // System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"Tačnih odgovra = "+count);  
            System.exit(0);  
        }  
    }  
    // Kriranje 10 pitanja za naš kviz
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Pitanje br. 1: Šta od navedenog nije primitivni tip podatka?");  
            jb[0].setText("int");
            jb[1].setText("Float");
            jb[2].setText("boolean");
            jb[3].setText("char");   
        }  
        if(current==1)  
        {  
            l.setText("Pitanje br. 2: Koja klasa je automatski dostupan svim klasama?");  
            jb[0].setText("Swing");
            jb[1].setText("Applet");
            jb[2].setText("Object");
            jb[3].setText("ActionEvent");  
        }  
        if(current==2)  
        {  
            l.setText("Pitanje br. 3: Koji paket je direktno dostupan našoj klasi bez importovanja?");  
            jb[0].setText("swing");
            jb[1].setText("applet");
            jb[2].setText("net");
            jb[3].setText("lang");  
        }  
        if(current==3)  
        {  
            l.setText("Pitanje br. 4: String klasa je definisana u kojem paketu?");  
            jb[0].setText("lang");
            jb[1].setText("Swing");
            jb[2].setText("Applet");
            jb[3].setText("awt");  
        }  
        if(current==4)  
        {  
            l.setText("Pitanje br. 5: Koji institut je najbolji za java coaching?");  
            jb[0].setText("Utek");
            jb[1].setText("Aptech");
            jb[2].setText("SSS IT");
            jb[3].setText("jtek");  
        }  
        if(current==5)  
        {  
            l.setText("Pitanje br. 6: Šta od navedenog nije ključna riječ?");  
            jb[0].setText("class");
            jb[1].setText("int");
            jb[2].setText("get");
            jb[3].setText("if");  
        }  
        if(current==6)  
        {  
            l.setText("Pitanje br. 7: Šta od navedenog nije klasa? ");  
            jb[0].setText("Swing");
            jb[1].setText("Actionperformed");
            jb[2].setText("ActionEvent");  
            jb[3].setText("Button");  
        }  
        if(current==7)  
        {  
            l.setText("Pitanje br. 8: Šta od navedenog nije funkcija klase Object?");  
            jb[0].setText("toString");
            jb[1].setText("finalize");
            jb[2].setText("equals");  
            jb[3].setText("getDocumentBase");         
        }  
        if(current==8)  
        {  
            l.setText("Pitanje br. 9: Koja funkcija nije prisutna u Applet klasi?");  
            jb[0].setText("init");
            jb[1].setText("main");
            jb[2].setText("start");
            jb[3].setText("destroy");  
        }  
        if(current==9)  
        {  
            l.setText("Pitanje br. 10: Koja od ovih komponenti nije validna?");  
            jb[0].setText("JButton");
            jb[1].setText("JList");
            jb[2].setText("JButtonGroup");  
            jb[3].setText("JTextArea");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
    // Metoda Main
    public static void main(String s[])  
    {  
        new Main("Online Test o Javi");  
    }  
}