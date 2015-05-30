
import java.awt.*;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class QickGame extends JFrame{
	JPanel p2;
	JButton RedButton = new JButton("Red");
	JButton BlackButton = new JButton("Black");
	JButton BlueButton = new JButton("Blue");
	JButton WhiteButton = new JButton("White");
	
	public QickGame(){
		p2 = new JPanel();
		p2.setLayout(new GridLayout(1,4,15,0));
		p2.add(BlackButton);
		p2.add(RedButton);
		p2.add(BlueButton);
		p2.add(WhiteButton);
		
		add(p2,BorderLayout.SOUTH);
	}
	
	public static void main(String[] args){
		QickGame frame = new QickGame();
		frame.setTitle("Qick Game");
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
