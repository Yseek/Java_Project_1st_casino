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

public class Pub extends JFrame{
    ImageIcon ii = new ImageIcon("imgs/p4-1-1_2.png");
	ImageIcon ii2 = new ImageIcon("imgs/p4-2.png");
	ImageIcon ii6 = new ImageIcon("imgs/p4-3.png");
	ImageIcon ii0 = new ImageIcon("imgs/p4-9_.png");
	ImageIcon ii13 = new ImageIcon("imgs/p4-10.jpg");
    JLabel showCredit;
	JButton b, b5, b0;
    GameOrPub gop;
   // int credit;
	Menu menu;
 
    

	Pub(GameOrPub gop){
        this.gop = gop;
       // this.credit = Client.credit;
        JPanel p = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(new ImageIcon("imgs/p4-1-1_2.png").getImage(),0, 0, null);
                setOpaque(false);
            }
        };
				
		p.setLayout(null);
		b = new JButton(ii2);
		b5 = new JButton(ii6);
		b0 = new JButton(ii0);
        showCredit = new JLabel(Integer.toString(Client.credit));

        showCredit.setBounds(680,13,400,100);
        Font font = new Font("8-bit Operator+ 8",Font.PLAIN,50);
        showCredit.setHorizontalAlignment(JLabel.CENTER);
		showCredit.setForeground(Color.yellow);
        showCredit.setFont(font);
		b.setBounds(289, 200, 92, 93);
		b5.setBounds(235, 195, 50, 73);
		b0.setBounds(839, 285, 86, 76);

		b.setContentAreaFilled(false);
		b5.setContentAreaFilled(false);
		b0.setContentAreaFilled(false);

		b.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b0.setCursor(new Cursor(Cursor.HAND_CURSOR));

        p.add(showCredit);
        p.add(b);
		p.add(b5);
		p.add(b0);
        this.add(p);
	
		
		setUI();
		init();
		initt();
		inittt();
		
   }

	void setUI(){
		setTitle("☆Welcome to MiniPUB★");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1075, 610);
        setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	void init(){
		ActionListener listener = (e) -> {
			gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			try{
				int answer = JOptionPane.showConfirmDialog(null, "어서오세요 고객님!" + "\n" + "주문 도와드릴까요?","☆Welcome to MiniPUB★", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ii2);
			if(answer == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "User: '네, 메뉴 부탁드립니다.'" + "\n" + "직원 옆에 메뉴를 클릭하세요.");
			}else if(answer == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "감사합니다!" + "\n" + " 다음에 또 오세요.");
			}
		}catch(HeadlessException he){}
	};
		b.addActionListener(listener);
}

	void initt(){
		ActionListener listn = (e) -> {
			gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			menu = new Menu(this);
			setVisible(false);
	};
		b5.addActionListener(listn);
}

	void inittt(){
		ActionListener listenerr = (e) -> {
			gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			try{
				int answer = JOptionPane.showConfirmDialog(null, 
					"펍을 나가시겠습니까?","☆Go out to the MiniPUB★", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ii13);
			if(answer == JOptionPane.YES_OPTION){
						setVisible(false);
                        gop.setVisible(true);
						gop.poo.ps.client.clip2.stop();
			}else if(answer == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "계속 펍을 이용하실 수 있습니다.");
			}
		}catch(HeadlessException he){}
	};
		b0.addActionListener(listenerr);
}


}
