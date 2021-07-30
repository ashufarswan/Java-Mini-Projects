import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Tictactoe extends JFrame implements ActionListener {
	JButton[] b = new JButton[9];
	JButton b1 = new JButton(" PLAY GAME ");
	JButton b2 = new JButton("EXIT");
	JButton b3 = new JButton("RESET");
	JButton b4 = new JButton("BACK");
	JButton b5 = new JButton("HELP");
	JLabel l =new JLabel("TIC - TAC - TOE");
	JLabel l1 =new JLabel("Player 1 - X");
	JLabel l2 =new JLabel("Player 2 - O");
	String letter="";
	String winner="none";
	int count = 0;
	boolean player1 = true;
	Tictactoe() {
		Home_window();
		setTitle("TIC-TAC-TOE");
	}
	
	private void Home_window() {
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		b1.setMaximumSize(new Dimension(125,25));
		b2.setMaximumSize(new Dimension(125,25));
		b5.setMaximumSize(new Dimension(125,25));
		Box box = Box.createVerticalBox();
		box.add(Box.createVerticalStrut(25));
		box.add(b1);
		box.add(Box.createVerticalStrut(25));
		box.add(b5);
		box.add(Box.createVerticalStrut(25));
		box.add(b2);  
		p1.setPreferredSize(new Dimension(325,50));
		l.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 32));
		p1.add(l);
        p1.setBackground(Color.gray);
        p2.setPreferredSize(new Dimension(300,170));
        p2.setLayout(new FlowLayout());
		p2.add(box);
        add(p1);
        add(p2);
        setSize(325,320);
        setLayout(new FlowLayout());
        setResizable(false);
        setVisible(true);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b5.addActionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void Play_window() {
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		p3.setPreferredSize(new Dimension(325,50));
		l1.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 14));
		l2.setFont(new Font(Font.DIALOG_INPUT,  Font.BOLD|Font.ITALIC, 14));
		Box box = Box.createHorizontalBox();
		box.add(l1);
		box.add(Box.createHorizontalStrut(50));
		box.add(l2);
		p3.add(box);
		p3.setLayout(new FlowLayout());
		p4.setPreferredSize(new Dimension(150,150));
		p4.setLayout(new GridLayout(3,3));
		for(int i=0;i<9;i++) {
			b[i] = new JButton();
			b[i].setBackground(Color.LIGHT_GRAY);
			p4.add(b[i]);
			b[i].addActionListener(this);
		}
		b3.setMaximumSize(new Dimension(125,25));
		b4.setMaximumSize(new Dimension(125,25));
		p5.add(b4);
		p5.add(b3);
		b4.addActionListener(this);
		b3.addActionListener(this);
		add(p3);
		add(p4);
		add(p5);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(player1)
			letter = "X";
		else
			letter = "O";
		if(e.getSource()==b1) {
			getContentPane().removeAll();
			repaint();
			validate();
			Play_window();
			
		}
		else if(e.getSource()==b2)
			System.exit(0);
		else if(e.getSource()==b[0]) {
			b[0].setText(letter);
			b[0].setEnabled(false);
			count++;
			checkWin();
			player1 =!player1;
		}
		else if(e.getSource()==b[1]) {
			b[1].setText(letter);
			b[1].setEnabled(false);
			count++;
			checkWin();
			player1 =!player1;
		}
		else if(e.getSource()==b[2]) {
			b[2].setText(letter);
			b[2].setEnabled(false);
			count++;
			checkWin();
			player1 =!player1;
		}
		else if(e.getSource()==b[3]) {
			b[3].setText(letter);
			b[3].setEnabled(false);
			count++;
			checkWin();
			player1 =!player1;
		}
		else if(e.getSource()==b[4]) {
			b[4].setText(letter);
			b[4].setEnabled(false);
			count++;
			checkWin();
			player1 =!player1;
		}
		else if(e.getSource()==b[5]) {
			b[5].setText(letter);
			b[5].setEnabled(false);
			count++;
			checkWin();
			player1 =!player1;
		}
		else if(e.getSource()==b[6]) {
			b[6].setText(letter);
			b[6].setEnabled(false);
			count++;
			checkWin();
			player1 =!player1;
		}
		else if(e.getSource()==b[7]) {
			b[7].setText(letter);
			b[7].setEnabled(false);
			count++;
			checkWin();
			player1 =!player1;
		}
		else if(e.getSource()==b[8]) {
			b[8].setText(letter);
			b[8].setEnabled(false);
			count++;
			checkWin();
			player1 =!player1;
		}
		else if(e.getSource()==b3) {
			letter = "";
			for(int i=0;i<9;i++) {
				b[i].setEnabled(true);
				b[i].setText(letter);
			}
			player1 = true;
		}
		else if(e.getSource()==b4) {
			getContentPane().removeAll();
			repaint();
			validate();
			Home_window();
		}
		if(!winner.equals("none")) {
			JOptionPane.showMessageDialog(this,"Hurray!!!!   "+winner+"   wins........");
			letter="";
			for(int i=0;i<9;i++) {
				b[i].setEnabled(true);
				b[i].setText(letter);
			}
			count = 0;
			winner ="none";
			player1 = true;
		}
		if(winner.equals("none")&&count==9) {
			JOptionPane.showMessageDialog(this,"ohhhh.....It's a Tie!!!!!");
			letter="";
			for(int i=0;i<9;i++) {
				b[i].setEnabled(true);
				b[i].setText(letter);
			}
			count = 0;
			player1 = true;
		}
	 }
	private void checkLetter() {
		if(letter.equals("X"))
			winner = "Player 1";
		else if(letter.equals("O"))
			winner = "Player 2";
	}
	
	private void checkWin() {
		for(int i=0;i<9;i+=3) {                                                                                      //Checking Row
			if(b[i].getText().equals(letter)&&b[i+1].getText().equals(letter)&&b[i+2].getText().equals(letter)) {
				checkLetter();
				return;
			}
		}
		
		for(int i=0;i<3;i++) {                                                                                       //Checking Column
			if(b[i].getText().equals(letter)&&b[i+3].getText().equals(letter)&&b[i+6].getText().equals(letter)) {
				checkLetter();
				return;
			}
		}
		
		if(b[0].getText().equals(letter)&&b[4].getText().equals(letter)&&b[8].getText().equals(letter)) {            //Checking Primary Diagonal
			checkLetter();
			return;
		}
		
		if(b[2].getText().equals(letter)&&b[4].getText().equals(letter)&&b[6].getText().equals(letter)) {            //Checking Secondry Diagonal
			checkLetter();
			return;
		}
	}
}
