package jeon.slot;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Menu extends JFrame{
    ImageIcon ii3 = new ImageIcon("imgs/p5-2.jpg");
	ImageIcon ii4 = new ImageIcon("imgs/p5-1.png");
	ImageIcon ii5 = new ImageIcon("imgs/p5-3.png");	
	ImageIcon ii6 = new ImageIcon("imgs/a.gif");
	ImageIcon ii7 = new ImageIcon("imgs/cigar.gif");
	
	Container cp;
	JPanel jp;
	JButton b2, b3, b4;
    Pub pub;
    //int credit;
    PubTalk pubTalk;
	

	Menu(Pub pub){
        this.pub = pub;
       // this.credit = Client.credit;
		init2();
		setUI2();
		choose();
	}

	void init2(){
		setLayout(null);
		
		JButton closebButton = new JButton();
        closebButton.setIcon(new ImageIcon(new ImageIcon("imgs/exit.png").getImage().getScaledInstance(60, 40, Image.SCALE_SMOOTH)));
        closebButton.setBounds(550, 40,80, 40);
        closebButton.setBorderPainted(false);
        closebButton.setContentAreaFilled(false);
        closebButton.setFocusPainted(false);
		closebButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closebButton.addActionListener((e)-> {
            setVisible(false);
			new Pub(pub.gop);
			 
        });

		cp = getContentPane();
		cp.setBackground(Color.white);

		b2 = new JButton(ii3);
		b2.setBackground(Color.white);
		
		b3 = new JButton(ii4);
		b3.setBackground(Color.white);
	
		b4 = new JButton(ii5);
		b4.setBackground(Color.white);
		
        b2.setBorderPainted(false);
        b3.setBorderPainted(false);
        b4.setBorderPainted(false);

		b2.setBounds(70, 100, 153, 312);
      	b3.setBounds(250, 100, 177, 301);
      	b4.setBounds(450, 150, 200, 175);

		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b4.setCursor(new Cursor(Cursor.HAND_CURSOR));

		cp.add(b2); cp.add(b3); cp.add(b4);cp.add(closebButton);

		
	}

	void setUI2(){
		setTitle("☆Click the Menu★");
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
        setVisible(true);
		setLocation(620, 300);
		setResizable(false);
	}

	void choose(){
		ActionListener lst = (e2) -> {
			pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			try{
				int answer = JOptionPane.showConfirmDialog(null, "맥주를 구매하시겠습니까?" + "\n" + "500포인트가 차감됩니다.","☆Mini Pub: BEER★", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, ii3);
			if(answer == JOptionPane.YES_OPTION){
				if(Client.credit>=500){
					Client.credit = Client.credit-500; new Beer(this);
					pub.gop.poo.ps.client.remaincoin();
					setEnabled(false);
				}else{JOptionPane.showMessageDialog(null, "아쉽지만 포인트가 부족하네요!" + "\n" + " 다음에 또 이용해주세요.");}
				
			}else if(answer == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "감사합니다!" + "\n" + " 다음에 또 이용해주세요.");
			}
		}catch(HeadlessException he){}
		};

		ActionListener lst2 = (e3) -> {
			pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			try{
				int answer = JOptionPane.showConfirmDialog(null, "담배를 구매하시겠습니까?" + "\n" + "1000포인트가 차감됩니다.","☆Mini Pub: CIGARETTES★", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, ii4);
			if(answer == JOptionPane.YES_OPTION){
				if(Client.credit>=1000){
					Client.credit = Client.credit-1000; new Cigar(this);
					pub.gop.poo.ps.client.remaincoin();
					setEnabled(false);
				}else{JOptionPane.showMessageDialog(null, "아쉽지만 포인트가 부족하네요!" + "\n" + " 다음에 또 이용해주세요.");}
				
				//JOptionPane.showMessageDialog(null, "User:" + "\n" + "'후우~~ 시원해! 감사합니다.'" + "\n" + "1000포인트가 차감되었습니다.");
			}else if(answer == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "감사합니다!" + "\n" + " 다음에 또 이용해주세요.");
			}
		}catch(HeadlessException he){}
		};

		ActionListener lst3 = (e4) -> {
			pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			try{
				int answer = JOptionPane.showConfirmDialog(null, "사람들과 이야기를 하시겠습니까?","☆Mini Pub: TALKING★", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, ii5);
			if(answer == JOptionPane.YES_OPTION){
					new PubTalk(this);
					pub.gop.poo.ps.client.remaincoin();
					setVisible(false);		    
			}else if(answer == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "감사합니다!" + "\n" + " 다음에 또 이용해주세요.");
			}
		}catch(HeadlessException he){}
		};

		b2.addActionListener(lst);
		b3.addActionListener(lst2);
		b4.addActionListener(lst3);

	}
}
