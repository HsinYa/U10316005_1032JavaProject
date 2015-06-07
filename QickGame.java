import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class QickGame extends JFrame implements ActionListener{
	//Data fields
	JPanel p1,p2,p3;
	JButton RedButton = new JButton("紅");
	JButton BlackButton = new JButton("黑");
	JButton BlueButton = new JButton("藍");
	JButton GreenButton = new JButton("綠");
	JLabel[] word = new JLabel[10];
	int index=0,right=0,error=0,total=0;
	JLabel title ;
	long startTime=0,endTime=0,totTime=0;

	
	//Constructor
	QickGame(){
		p1 = new JPanel();
		//Create some words of JLabel in different colors
		Font font = new Font("標楷體", Font.BOLD, 230);
		word[0] = new JLabel("紅");
		word[0].setFont(font);
		word[0].setForeground(Color.BLUE);
		word[1] = new JLabel("綠");
		word[1].setFont(font);
		word[1].setForeground(Color.RED);
		word[2] = new JLabel("黑");
		word[2].setFont(font);
		word[2].setForeground(Color.BLUE);
		word[3] = new JLabel("藍");
		word[3].setFont(font);
		word[3].setForeground(Color.GREEN);
		word[4] = new JLabel("藍");
		word[4].setFont(font);
		word[4].setForeground(Color.RED);
		word[5] = new JLabel("黑");
		word[5].setFont(font);
		word[5].setForeground(Color.GREEN);
		word[6] = new JLabel("紅");
		word[6].setFont(font);
		word[6].setForeground(Color.BLUE);
		word[7] = new JLabel("綠");
		word[7].setFont(font);
		word[7].setForeground(Color.BLACK);
		word[8] = new JLabel("藍");
		word[8].setFont(font);
		word[8].setForeground(Color.BLACK);
		word[9] = new JLabel("黑");
		word[9].setFont(font);
		word[9].setForeground(Color.RED);
		index = (int)(Math.random()*word.length);
		p1.setLayout(new GridLayout(1,1));
		p1.add(word[index]);
		//Put four buttons in location
		p2 = new JPanel();
		p2.setLayout(new GridLayout(1,4,15,0));
		p2.add(BlackButton);
		BlackButton.addActionListener(this);
		p2.add(RedButton);
		RedButton.addActionListener(this);
		p2.add(BlueButton);
		BlueButton.addActionListener(this);
		p2.add(GreenButton);
		GreenButton.addActionListener(this);
		p3 = new JPanel();
		Font font2 = new Font("標楷體", Font.BOLD, 20);
		title = new JLabel("以最快的速度找出字的「顏色」!!!");
		title.setFont(font2);
		title.setForeground(Color.BLACK);
		p3.add(title,BorderLayout.NORTH);
		p3.add(p1,BorderLayout.CENTER);
		p3.add(p2,BorderLayout.SOUTH);
		add(p3);
		startTime = System.currentTimeMillis();
	}
	
	@Override
	 public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//Judge the button and the word if it's the same color
		 if(e.getSource() == BlackButton){  
			 if(index == 7 || index == 8){
				 right++;
			 }else{
				 error++;
			 }
			 total++;
			 endTime = System.currentTimeMillis();
		 }
		 else if(e.getSource() == RedButton){
			 if(index == 1 || index == 4 || index == 9){
				 right++;
			 }else{
				 error++;
			 }
			 total++;
			 endTime = System.currentTimeMillis();
		 }
		 else if(e.getSource() == BlueButton){
			 if(index == 0 || index == 2 || index == 6){
				 right++;
			 }else{
				 error++;
			 }
			 total++;
			 endTime = System.currentTimeMillis();
		 }
		 else if(e.getSource() == GreenButton){
			 if(index == 3 || index == 5 ){
				 right++;
			 }else{
				 error++;
			 }
			 total++;
			 endTime = System.currentTimeMillis();
		 }
		 //Calculate the time of executing the action
		 totTime = (endTime - startTime)/1000;
		 //In different conditions display the different result
		 if(total==1){
			 if( totTime < 1.5 && right == 1){
				 JOptionPane.showMessageDialog(null, "答對了!!\n反應超迅速~~");
				 System.exit(error);
			 }
			 else if( totTime > 1.5 && totTime < 3 && right == 1){
				 JOptionPane.showMessageDialog(null, "答對了!!\n反應好阿~~");
				 System.exit(error);
			 }
			 else if(totTime > 3 && right == 1){
				 JOptionPane.showMessageDialog(null, "答對了!!\n反應可再加強~~");
				 System.exit(error);
			 }else if(error == 1){
				 JOptionPane.showMessageDialog(null, "答錯了~~~\n要再看仔細一點，加油!!!", "訊息",JOptionPane.ERROR_MESSAGE); 
				 System.exit(error);
			 }
		 } 
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
