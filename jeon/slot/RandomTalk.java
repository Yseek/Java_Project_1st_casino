package jeon.slot;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RandomTalk extends JFrame {
	Container cp;
	JLabel laM;
	//JPanel jp1;
	PubTalk pt;
    
	
	
	ArrayList<String> talking = new ArrayList<String>();

	/*RandomTalk(){
		saveToArray();
	}*/

	RandomTalk(PubTalk pt){
		this.pt = pt;
		saveToArray();
       // outCall();
		showLines();
	}

	void saveToArray(){
		
			try{
				File file = new File("./");
				if(file.exists()){
					System.out.println("읽힘 ");
					System.out.println(file.getAbsolutePath());
					String path = file.getAbsolutePath();
					path = path.replace(".", "");
					path = path.replace("\\", "/");
					System.out.println(path);

					BufferedReader br = new BufferedReader(new FileReader("./talkingmsg/talking.txt"));
					System.out.println("정상 읽힘");
					String line = "";
					//int i = 0;
					while((line = br.readLine()) != null){
						line = line.trim();
						if(line.length() !=0){						
							talking.add(line);
						}
					}
					br.close();		
				}	
			}catch(NullPointerException ne){
				System.out.println("파일 경로 불가");
			}catch(FileNotFoundException fe){
				System.out.println("파일 없어");
			}catch(IOException ie){}
	}

	void outCall(){
		for(String lines : talking){
			pln(lines);
		}
	}

	Random r = new Random();
	String rr;
	void showLines(){
		int idx = r.nextInt(talking.size());
		System.out.println(talking.size());
		rr = talking.get(idx);
		pln("Unknown: " + rr);
			if(idx ==0){
				Client.credit = Client.credit-800;
				pt.menu.pub.gop.poo.ps.client.remaincoin();
				if(Client.credit<0){
					Client.credit=0;
					pt.menu.pub.gop.poo.ps.client.remaincoin();
					setVisible(false);
					end();
				}
			}else if(idx ==1){
				Client.credit = Client.credit+300;
				pt.menu.pub.gop.poo.ps.client.remaincoin();
			}else if(idx ==2){
				Client.credit = Client.credit-100;
				pt.menu.pub.gop.poo.ps.client.remaincoin();
				if(Client.credit<0){
					Client.credit=0;
					pt.menu.pub.gop.poo.ps.client.remaincoin();
					setVisible(false);
					end();
				}
			}else if(idx ==3){
				Client.credit = Client.credit+200;
				pt.menu.pub.gop.poo.ps.client.remaincoin();
			}else if(idx ==4){
				Client.credit = Client.credit+400;
				pt.menu.pub.gop.poo.ps.client.remaincoin();
			}else if(idx ==5){
				Client.credit = Client.credit+300;
				pt.menu.pub.gop.poo.ps.client.remaincoin();
			}else if(idx ==6){
				Client.credit = Client.credit-300;
				pt.menu.pub.gop.poo.ps.client.remaincoin();
				if(Client.credit<0){
					Client.credit=0;
					pt.menu.pub.gop.poo.ps.client.remaincoin();
					setVisible(false);
					end();
				}
			}else if(idx ==7){
				Client.credit = Client.credit+1000;
				pt.menu.pub.gop.poo.ps.client.remaincoin();
			}else if(idx ==8){
				Client.credit = Client.credit-500;
				pt.menu.pub.gop.poo.ps.client.remaincoin();
				if(Client.credit<0){
					Client.credit=0;
					pt.menu.pub.gop.poo.ps.client.remaincoin();
					setVisible(false);
					end();
				}
			}else if(idx ==9){
				Client.credit = Client.credit+100;
				pt.menu.pub.gop.poo.ps.client.remaincoin();
			}else if(idx ==10){
				Client.credit = Client.credit-600;
				pt.menu.pub.gop.poo.ps.client.remaincoin();
				if(Client.credit<0){
					Client.credit=0;
					pt.menu.pub.gop.poo.ps.client.remaincoin();
					setVisible(false);
					end();
				}
			}
		if(Client.credit<=0){}
		else{init();setUI();}	
		
	}

	void pln(String str){
		System.out.println(str);
	}

	void end(){
	JFrame exit = new JFrame("kosmo");     
        
	Container exitcon = new Container();
	exitcon = exit.getContentPane();

	JPanel exitpanel = new JPanel()/*{
		public void paintComponent(Graphics g){
			g.drawImage(new ImageIcon(new ImageIcon(getClass().getResource("./imgs/p2-2.jpg")).getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH)).getImage(),0, 0, null);
			setOpaque(false);
			super.paintComponent(g);
		}
	}*/;
	exitpanel.setLayout(null);
	exitpanel.setBackground(Color.white);
	exitcon.add(exitpanel);
	
	
	JButton exitB = new JButton(new ImageIcon("imgs/p2-8.png"));
	exitB.setBounds(240, 200, 90, 57);
	exitB.setContentAreaFilled(false);
	exitB.setFocusPainted(false);
	exitB.setBorderPainted(false);
	exitB.setCursor(new Cursor(Cursor.HAND_CURSOR));
	exitB.addActionListener((e)-> {
		pt.menu.pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
		System.exit(0);});
	exitpanel.add(exitB);

	JLabel exitletter = new JLabel("<html><body><center>You lost all your money.<br>Go to the currency exchange and get points.<br>See you next time.</center></body></html>");
	Font f1 = new Font("8-bit Operator+ 8",Font.PLAIN,20);
	exitletter.setFont(f1);
	exitletter.setBounds(150, 70, 300, 100);
	
	exitpanel.add(exitletter);

	exit.setSize(600,400);
	exit.setResizable(false);
	exit.setVisible(true);
	exit.setLocationRelativeTo(null);
	exit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	void init(){
		JButton closebButton = new JButton();
        closebButton.setIcon(new ImageIcon(new ImageIcon("imgs/exit.png").getImage().getScaledInstance(60, 40, Image.SCALE_SMOOTH)));
        closebButton.setBounds(800, 40,80, 40);
        closebButton.setBorderPainted(false);
        closebButton.setContentAreaFilled(false);
        closebButton.setFocusPainted(false);
		closebButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closebButton.addActionListener((e)-> {
			pt.menu.pub.gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
			new PubTalk(pt.menu);
			setVisible(false);
			pt.setVisible(false);
        });

		laM = new JLabel();
		laM.setForeground(Color.black);
		laM.setText(rr); 
		laM.setHorizontalAlignment(JLabel.CENTER);

		Font f1 = new Font("8-bit Operator+ 8", Font.BOLD, 20);
		laM.setFont(f1);

		cp = getContentPane();
		cp.add(closebButton);
		cp.add(laM, null);
		cp.setBackground(Color.white);
	}

	void setUI(){
		setTitle("Talking with People");
		//pack();
		setVisible(true);
		setSize(1000, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
