package jeon.slot;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PubTalk extends JFrame {
    ImageIcon ii = new ImageIcon("imgs/p4-1-1_2.png");
	ImageIcon ii7 = new ImageIcon("imgs/p4-4.png");
	ImageIcon ii8 = new ImageIcon("imgs/p4-5.png");
	ImageIcon ii9 = new ImageIcon("imgs/p4-6.png");
	ImageIcon ii10 = new ImageIcon("imgs/p4-7.png");
	ImageIcon ii11 = new ImageIcon("imgs/p4-8.png");
	ImageIcon ii12 = new ImageIcon("imgs/p4-9_.png");
	ImageIcon ii13 = new ImageIcon("imgs/p4-10.jpg");
	ImageIcon ii14 = new ImageIcon("imgs/p5-3.png");

    Menu menu;
	int credit;
	JButton b6, b7, b8, b9, b10, b11;
	JLabel showCredit;
	    
	PubTalk(Menu menu){
        this.menu = menu;
        this.credit = Client.credit;
        JPanel p = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(new ImageIcon("imgs/p4-1-1_2.png").getImage(),0, 0, null);
                setOpaque(false);
            }
        };

		showCredit = new JLabel(Integer.toString(Client.credit));

		showCredit.setBounds(680,13,400,100);
        Font font = new Font("8-bit Operator+ 8",Font.PLAIN,50);
		showCredit.setHorizontalAlignment(JLabel.CENTER);
        showCredit.setForeground(Color.yellow);
        showCredit.setFont(font);
		
        
		p.setLayout(null);
		
		b6 = new JButton(ii7);
		b6.setBounds(538, 205, 72, 85);
		b6.setContentAreaFilled(false);
		b6.setCursor(new Cursor(Cursor.HAND_CURSOR));

		b7 = new JButton(ii11);
		b7.setBounds(455, 487, 244, 94);
		b7.setContentAreaFilled(false);
		b7.setCursor(new Cursor(Cursor.HAND_CURSOR));

		b8 = new JButton(ii10);
		b8.setBounds(0, 487, 233, 94);
		b8.setContentAreaFilled(false);
		b8.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		b9 = new JButton(ii9);
		b9.setBounds(0, 355, 76, 94);
		b9.setContentAreaFilled(false);
		b9.setCursor(new Cursor(Cursor.HAND_CURSOR));

		b10 = new JButton(ii8);
		b10.setBounds(232, 355, 77, 94);
		b10.setContentAreaFilled(false);
		b10.setCursor(new Cursor(Cursor.HAND_CURSOR));

		b11 = new JButton(ii12);
		b11.setBounds(839, 285, 86, 76);
		b11.setContentAreaFilled(false);
		b11.setCursor(new Cursor(Cursor.HAND_CURSOR));

		p.add(showCredit);
		p.add(b6);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(b10);
		p.add(b11);
		
        this.add(p);
	
		
		setUI();
		init();
		inita();
		initb();
		initc();
		initd();
		inite();
		
   }

	void setUI(){
		setTitle("Talking with people at MiniPUB★");
      	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1075, 610);
        setVisible(true);
		setLocationRelativeTo(null);;
		setResizable(false);
	}

	void init(){
		ActionListener listener = (e) -> {
			menu.pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			try{
				int answer = JOptionPane.showConfirmDialog(null, 
					"☆대화를 나가시겠습니까?","☆Go out to the MiniPUB★", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ii13);
			if(answer == JOptionPane.YES_OPTION){
				menu.pub.gop.poo.ps.client.clip2.stop();
				setVisible(false);
				new GameOrPub(menu.pub.gop.poo);
			}else if(answer == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "계속 펍을 이용하실 수 있습니다.");
			}
		}catch(HeadlessException he){}
	};
		b11.addActionListener(listener);
}

	void inita(){
		ActionListener listn = (e) -> {
			menu.pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			new RandomTalk(this);//setVisible(false);
			setEnabled(false);
			
	};
		b6.addActionListener(listn);
}

	void initb(){
		ActionListener listn = (e) -> {
			menu.pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			new RandomTalk(this);//setVisible(false);
			setEnabled(false);			
	};
		b7.addActionListener(listn);
}

	void initc(){
		ActionListener listn = (e) -> {
			menu.pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			new RandomTalk(this);//setVisible(false);
			setEnabled(false);
	};
		b8.addActionListener(listn);
}

	void initd(){
		ActionListener listn = (e) -> {
			menu.pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			new RandomTalk(this);//setVisible(false);
			setEnabled(false);
	};
		b9.addActionListener(listn);
}

	void inite(){
		ActionListener listn = (e) -> {
			menu.pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			new RandomTalk(this);//setVisible(false);
			setEnabled(false);
	};
		b10.addActionListener(listn);
}
			
}
