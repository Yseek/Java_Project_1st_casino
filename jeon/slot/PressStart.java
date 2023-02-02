package jeon.slot;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;




public class PressStart extends JFrame{

   ImageIcon ii = new ImageIcon("imgs/p1-1_.png");
   ImageIcon ii2 = new ImageIcon("imgs/p1-3.png");
   ImageIcon ii6 = new ImageIcon("imgs/p1-4.png"); 
   ImageIcon ii7 = new ImageIcon("imgs/p1-10.png"); 
   //Image im = ii.getImage();
   JButton b, b5;
   Slot slot;
   int credit;
   PlayOrOff poo;
    Client client;
   PressStart(Client client){
    
    this.client= client;
    JPanel p = new JPanel(){
        public void paintComponent(Graphics g){
            g.drawImage(new ImageIcon("imgs/p1-1_.png").getImage(),0, 0, null);
            setOpaque(false);
        }
    
    };

        
      p.setLayout(null);
      
      b = new JButton(ii2);
      b5 = new JButton(ii6);
      b.setBounds(285, 320, 180, 70);
      b5.setBounds(630, 320, 180, 70);
      b.setContentAreaFilled(false);
      b5.setContentAreaFilled(false);
	  b.setBorderPainted(false);
      b5.setBorderPainted(false);
      b.setCursor(new Cursor(Cursor.HAND_CURSOR));
      b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
      p.add(b);
      p.add(b5);
      this.add(p);
   
      
      setUI();
	  init();
	  initt();
      
   }

   void setUI(){
      setTitle("☆ Welcome to GASAN-LAND ★");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(1098, 618);
      setVisible(true);
      setLocationRelativeTo(null);;
      setResizable(false);
   }

	void init(){
		ActionListener listn = (e) -> {
            client.playSound("./music/ButtonSound1.wav", false);
		try{
			int answer = JOptionPane.showConfirmDialog(null, 
					"가산랜드에 입장하시겠습니까?", "☆Enter the GASAN-LAND★", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ii7);
			if(answer == JOptionPane.YES_OPTION){
                poo = new PlayOrOff(this);
                setVisible(false);
			}else if(answer == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "다음에 또 이용해주세요.");
			}
		}catch(HeadlessException he){}
	};
		b.addActionListener(listn);
}

	void initt(){
		ActionListener listn2 = (e) -> {
            client.playSound("./music/ButtonSound1.wav", false);
			try{
				int answer = JOptionPane.showConfirmDialog(null, 
					"게임을 종료하시겠습니까?","☆Go out to the GASAN-LAND★", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, ii7);
			if(answer == JOptionPane.YES_OPTION){
						 System.exit(0);
			}else if(answer == JOptionPane.NO_OPTION){
				JOptionPane.showMessageDialog(null, "계속 게임을 이용하실 수 있습니다.");
			}
		}catch(HeadlessException he){}
	};
		b5.addActionListener(listn2);
}
}
