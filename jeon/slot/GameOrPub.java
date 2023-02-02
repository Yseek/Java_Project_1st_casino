package jeon.slot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameOrPub extends JFrame{
    Container cp;
    ImageIcon ii1, ii2, ii3, ii4;
 
    JPanel p;
    JButton bPC, bPE, b; 
    PlayOrOff poo;
    int credit;
    Pub pub;
    Slot slot;
    
    
    

    GameOrPub(PlayOrOff poo){
        this.poo = poo;
        this.credit = Client.credit;
        init();
       }
       
       void init(){
        p = new JPanel();
         JPanel p = new JPanel(); 
         //JPanel p2 = new JPanel();
         cp = getContentPane();
          
          p.setLayout(null);   //(new GridLayout(1,3)); 
          //p2.setLayout(null); 
          p.setBackground(Color.WHITE);
          //p2.setBackground(Color.WHITE);
          
          ii1 = new ImageIcon("imgs/p2-4_.png");
          ii2 = new ImageIcon("imgs/p2-5_.png");
          ii3 = new ImageIcon(new ImageIcon("imgs/exit.png").getImage().getScaledInstance(60, 40, Image.SCALE_SMOOTH));
          bPC = new JButton(ii1);
          bPE = new JButton(ii2);
          b = new JButton(ii3);
          bPC.addActionListener((e)->{
            poo.ps.client.playSound("./music/ButtonSound1.wav", false);
            new Slot(this);
            setVisible(false);  
          });
          bPE.addActionListener((e)->{
            poo.ps.client.playSound("./music/ButtonSound1.wav", false);
            poo.ps.client.playSound2("./music/crowdsound.wav", true);
            pub = new Pub(this);
            setVisible(false);
          });
          b.addActionListener((e)-> {
            poo.ps.client.playSound("./music/ButtonSound1.wav", false);
              setVisible(false);
              poo.setVisible(true);
                
          });
          
          bPC.setBounds(70, 40, 386, 542);
          bPE.setBounds(440, 40, 386, 542);
          //bPC.setBackground(Color.white);
          //bPE.setBackground(Color.white);
          
          bPC.setContentAreaFilled(false);
          bPE.setContentAreaFilled(false);
    
          bPC.setBorderPainted(false);
          bPE.setBorderPainted(false);
    
          bPC.setCursor(new Cursor(Cursor.HAND_CURSOR));
          bPE.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
          b.setBounds(760, 1, 158, 100);
          b.setBorderPainted(false);
          b.setContentAreaFilled(false);
          b.setFocusPainted(false);
          b.setCursor(new Cursor(Cursor.HAND_CURSOR));
    
          p.add(bPC);
          p.add(bPE);
          p.add(b);
    
         // bC = new JButton("센터");
    
          cp.add(p, BorderLayout.CENTER);
         // cp.add(p2);
       
          setUI();
       }
       void setUI(){
          setTitle("☆ Click the game ☆");
          setSize(900, 650);
          setVisible(true);
          setLocationRelativeTo(null);
    
          setResizable(false);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
           
}
