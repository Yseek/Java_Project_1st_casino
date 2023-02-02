package jeon.slot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cigar extends JFrame {
    Container cp;
	ImageIcon ii = new ImageIcon("imgs/cigar.gif");
	ImageIcon ii2 = new ImageIcon(new ImageIcon("imgs/exit.png").getImage().getScaledInstance(60, 40, Image.SCALE_SMOOTH));
	JLabel laI, laM, laM2;
	JButton b;
	JPanel jp1;
	//JFrame fr = new JFrame();
	Menu menu;
	Cigar(Menu menu){
		this.menu = menu;
		init();
		initt();
		setUI();
	}

	void init(){
		cp = getContentPane();
		laI = new JLabel(ii);

		b = new JButton(ii2);
		b.setBounds(595, 5, 158, 100);
		b.setBorderPainted(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		b.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		jp1 = new JPanel(new GridLayout(2,1));
		jp1.setBackground(Color.white);
		laM = new JLabel();
		laM.setForeground(Color.black);
		laM.setText("     ＊º☆★º＊      "); 
		laM.setHorizontalAlignment(JLabel.CENTER);

		laM2 = new JLabel();
		laM2.setForeground(Color.black);
		laM2.setText("      Your 1000 points have been deducted.      ");
		laM2.setHorizontalAlignment(JLabel.CENTER);

				//"      Your 500 points have been deducted.      "

		Font f1 = new Font("궁서체", Font.BOLD, 30);
		laM.setFont(f1);
		Font f2 = new Font("8-bit Operator+ 8", Font.PLAIN, 20); //8-bit Operator+ 8
		laM2.setFont(f2);

		jp1.add(laM); 
		jp1.add(laM2);
		
		cp.add(b);
		cp.add(laI);
		cp.add(jp1, BorderLayout.SOUTH);
		cp.setBackground(Color.white);
		
				
	}

	void initt(){
		ActionListener listener = (e) -> {
			menu.pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			setVisible(false);
			menu.setEnabled(true);
	};
		b.addActionListener(listener);
	}

	void setUI(){
		setTitle("Let's SMOKEEEE");
		pack();
		setVisible(true);
		setSize(750, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
