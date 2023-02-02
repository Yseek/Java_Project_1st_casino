package jeon.slot;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PlayOrOff extends JFrame{

	

    ImageIcon ii = new ImageIcon("imgs/p2-2_1.png");
	ImageIcon ii2 = new ImageIcon("imgs/p2-6.png");
	ImageIcon ii3 = new ImageIcon("imgs/p2-8.png"); 
	ImageIcon ii4 = new ImageIcon("imgs/p1-11_.png"); 
   
	Image im = ii.getImage();
	JButton b, b2;
    PressStart ps;
    int credit;
	GameOrPub gop;


	
    
	PlayOrOff(PressStart ps){
        this.ps = ps;
        this.credit = Client.credit;

        JPanel p = new JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(new ImageIcon("imgs/p2-2_1.png").getImage(),0, 0, null);
                setOpaque(false);
            }
        };
				
		p.setLayout(null);
		b = new JButton(ii2);
		b2 = new JButton(ii3);
		b.setBounds(380, 410, 158, 100);
		b2.setBounds(545, 410, 158, 100);
		b.setBorderPainted(false);
		b2.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b2.setContentAreaFilled(false);
		b.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p.add(b);
		p.add(b2);
        this.add(p);
	
		
		setUI();
		init();
		initt();
		
   }

	void setUI(){
		setTitle("☆Welcome to GASAN-LAND★");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1075, 582);
        setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	void init(){
		ActionListener listener = (e) -> {
			ps.client.playSound("./music/ButtonSound1.wav", false);
			gop = new GameOrPub(this);
            setVisible(false);
	};
		b.addActionListener(listener);
}
	
	void initt(){
		ActionListener listn = (e) -> {
			ps.client.playSound("./music/ButtonSound1.wav", false);
			try{
			int answer = JOptionPane.showConfirmDialog(null, 
					"첫화면으로 돌아가겠습니까?", "☆Go out to the GASAN-LAND★", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ii4);
			if(answer == JOptionPane.YES_OPTION){
						setVisible(false);
						ps.setVisible(true);
			}else if(answer == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "다시 이용해주세요.");
			}
		}catch(HeadlessException he){}
	};
		b2.addActionListener(listn);
}
}
