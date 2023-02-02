package jeon.slot;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import java.util.Random;
import java.util.stream.Stream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class Slot {
    Container cp;
    JButton run, betplus,betminus;
    JLabel m1,m2,m3,betshow,n0,n1,n2,n3,n4,n5,n6,n7,n8,n9;
    int idx1, idx2, idx3;
    JPanel basic,p,bottomButton,goldnumber,exitpanel,backimage;
    String number[] = {"0","1","2","3","4","5","6","7","8"};
    ImageIcon aa,bb,cc,dd,ee,ff,gg,hh,ii,n_0,n_1,n_2,n_3,n_4,n_5,n_6,n_7,n_8,n_9;
    ImageIcon image[];
    ImageIcon numberimage[];
    JLabel goldview[] = {n9,n8,n7,n6,n5,n4,n3,n2,n1,n0};
    JFrame exit;
    PressStart ps;
    
    Runnable r;
    //int credit;
    int betcredit = 100;
    Thread th;
    Client client;
    JFrame frame;
    GameOrPub gop;
    int backx;
    Slot(GameOrPub gop){
        this.gop = gop;
        mach();
    }
    
    /*Slot(Client client){
        this.client = client;
        //this.credit = Client.credit;
        new PressStart(this);
        //mach();
    }*/
    

    
    void image() {
    	image = new ImageIcon[9];
        numberimage = new ImageIcon[10];
    	
    	aa = new ImageIcon("imgs/p3-a.png");
    	bb = new ImageIcon("imgs/p3-b.png");
    	cc = new ImageIcon("imgs/p3-c.png");
    	dd = new ImageIcon("imgs/p3-d.png");
    	ee = new ImageIcon("imgs/p3-e.png");
    	ff = new ImageIcon("imgs/p3-f.png");
    	gg = new ImageIcon("imgs/p3-g.png");
    	hh = new ImageIcon("imgs/p3-h.png");
    	ii = new ImageIcon("imgs/p3-i.png");
        n_0 = new ImageIcon("imgs/p2-a.png");
        n_1 = new ImageIcon("imgs/p2-b.png");
        n_2 = new ImageIcon("imgs/p2-c.png");
        n_3 = new ImageIcon("imgs/p2-d.png");
        n_4 = new ImageIcon("imgs/p2-e.png");
        n_5 = new ImageIcon("imgs/p2-f.png");
        n_6 = new ImageIcon("imgs/p2-g.png");
        n_7 = new ImageIcon("imgs/p2-h.png");
        n_8 = new ImageIcon("imgs/p2-i.png");
        n_9 = new ImageIcon("imgs/p2-j.png");
    	
    	
    	image [0]=aa;image [1]=bb;image [2]=cc;image [3]=dd;
    	image [4]=ee;image [5]=ff;image [6]=gg;image [7]=hh;image [8]=ii;

        numberimage[0]=n_0;numberimage[1]=n_1;numberimage[2]=n_2;numberimage[3]=n_3;numberimage[4]=n_4;
        numberimage[5]=n_5;numberimage[6]=n_6;numberimage[7]=n_7;numberimage[8]=n_8;numberimage[9]=n_9;
 	
    }


    void mach(){
        //이미지 메소드 호출
    	image();
        frame = new JFrame();
        //배경화면 설정
        cp = frame.getContentPane();
        cp.setLayout(null);

      backimage = new JPanel(){
            public void paintComponent(Graphics g) {
                g.drawImage(new ImageIcon(new ImageIcon("imgs/light.png").getImage().getScaledInstance(500, 750, Image.SCALE_SMOOTH)).getImage(),backx, 0, null);
                setOpaque(false);
                
            }
        };
       /* backimage.setFocusable(true);
         Runnable rr = ()-> {
            while(true){
                backx-=2;
                backimage.repaint();
                try{
                    Thread.sleep(100);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                backx-=2;
                backimage.repaint();
                try{
                    Thread.sleep(100);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                backx+=2;
                backimage.repaint();
                try{
                    Thread.sleep(100);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                backx+=2;
                backimage.repaint();
                try{
                    Thread.sleep(100);
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        };
        new Thread(rr).start();*/
        backimage.setLayout(null);
        backimage.setSize(new Dimension(470,750));
        
        cp.add(backimage);
        

        basic = new JPanel(){
            public void paintComponent(Graphics g) {
                g.drawImage(new ImageIcon("imgs/p4_1_1.png").getImage(),0, 0, null);
                setOpaque(false);
                
            }
        };  
        basic.setLayout(null);
        basic.setSize(new Dimension(470,750));
        basic.setOpaque(false);
        //basic.setOpaque(false);
        
        backimage.add(basic);
        
        
        
         
        //나가기 버튼
    	JButton closebButton = new JButton();
        closebButton.setIcon(new ImageIcon(new ImageIcon("imgs/exit.png").getImage().getScaledInstance(60, 40, Image.SCALE_SMOOTH)));
        closebButton.setBounds(350, 80,80, 40);
        closebButton.setBorderPainted(false);
        closebButton.setContentAreaFilled(false);
        closebButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closebButton.setFocusPainted(false);
        closebButton.addActionListener((e)-> {
            gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
            frame.setVisible(false);
            gop.setVisible(true);
            //client.clientFrame.setVisible(true);
            //gop.setVisible(true);
            /*try{
                client.s.close();
            }catch(IOException ie){}*/   
        });
        basic.add(closebButton);
        //하단 버튼 
        run = new JButton(new ImageIcon(new ImageIcon("imgs/p3-4.png").getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
        run.setBackground(Color.white);
        run.setCursor(new Cursor(Cursor.HAND_CURSOR));
        run.addActionListener((e)-> {
            gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
        	Runnable r = ()-> {spin();};
        	new Thread(r).start();               
        });
        try {
            new Thread(r).join();
        }catch(Exception ee) {}
    	betplus = new JButton(new ImageIcon(new ImageIcon("imgs/p3-2.png").getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
        betplus.setBackground(Color.white);
        betplus.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	betminus = new JButton(new ImageIcon(new ImageIcon("imgs/p3-3.png").getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH)));
        betminus.setBackground(Color.white);
        betminus.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	run.setBorderPainted(false);
        run.setFocusPainted(false);
        run.setOpaque(false);
        run.setContentAreaFilled(false);
        if(Client.credit==0){
            end();
        }
    	betplus.setBorderPainted(false);
        betplus.setFocusPainted(false);
        betplus.setOpaque(false);
        betplus.setContentAreaFilled(false);
    	betminus.setBorderPainted(false);
        betminus.setFocusPainted(false);
        betminus.setOpaque(false);	
        betminus.setContentAreaFilled(false);
    	betminus.addActionListener((e)->{
            gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);minus();
        });
    	betplus.addActionListener((e)->{
            gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);plus();
        });
        bottomButton = new JPanel();
        bottomButton.setLayout(new GridLayout(1,3));
        bottomButton.setBounds(50, 650, 350, 60);
        bottomButton.setOpaque(false);      
        bottomButton.add(betplus);
        bottomButton.add(betminus);
        bottomButton.add(run);
        basic.add(bottomButton);

        // 포인트 표시
        goldnumber = new JPanel();
        goldnumber.setLayout(new GridLayout(1,9));
        goldnumber.setBounds(25, 10, 400, 50);
        n0 = new JLabel(numberimage[0]); n1 = new JLabel(numberimage[0]); n2 = new JLabel(numberimage[0]); n3 = new JLabel(numberimage[0]); n4 = new JLabel(numberimage[0]);
        n5 = new JLabel(numberimage[0]); n6 = new JLabel(numberimage[0]); n7 = new JLabel(numberimage[0]); n8 = new JLabel(numberimage[0]); n9 = new JLabel(numberimage[0]);
        goldnumber.add(n0); goldnumber.add(n1); goldnumber.add(n2); goldnumber.add(n3); goldnumber.add(n4); 
        goldnumber.add(n5); goldnumber.add(n6); goldnumber.add(n7); goldnumber.add(n8); goldnumber.add(n9);
        goldnumber.setOpaque(false);

        int creditview[] = Stream.of(String.valueOf(Client.credit).split("")).mapToInt(Integer::parseInt).toArray();
        int newcreditview[] = new int [creditview.length];
        for(int i = 0; i<creditview.length;i++){
            newcreditview[creditview.length -1 -i] = creditview[i];
        }

        if(creditview.length==1){
            n9.setIcon(numberimage[newcreditview[0]]);
        }else if(creditview.length==2){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]);
        }else if(creditview.length==3){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]); n7.setIcon(numberimage[newcreditview[2]]);
        }else if(creditview.length==4){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]);n7.setIcon(numberimage[newcreditview[2]]); n6.setIcon(numberimage[newcreditview[3]]);
        }else if(creditview.length==5){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]); n7.setIcon(numberimage[newcreditview[2]]); n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]);
        }else if(creditview.length==6){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]);  n7.setIcon(numberimage[newcreditview[2]]); n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]); n4.setIcon(numberimage[newcreditview[5]]);
        }else if(creditview.length==7){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]);n7.setIcon(numberimage[newcreditview[2]]);n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]); n4.setIcon(numberimage[newcreditview[5]]);n3.setIcon(numberimage[newcreditview[6]]);
        }else if(creditview.length==8){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]); n7.setIcon(numberimage[newcreditview[2]]); n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]); n4.setIcon(numberimage[newcreditview[5]]); n3.setIcon(numberimage[newcreditview[6]]);n2.setIcon(numberimage[newcreditview[7]]);
        }else if(creditview.length==9){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]);   n7.setIcon(numberimage[newcreditview[2]]);  n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]);  n4.setIcon(numberimage[newcreditview[5]]);  n3.setIcon(numberimage[newcreditview[6]]);   n2.setIcon(numberimage[newcreditview[7]]);
            n1.setIcon(numberimage[newcreditview[8]]);
        }else if(creditview.length==10){
            n9.setIcon(numberimage[newcreditview[0]]);  n8.setIcon(numberimage[newcreditview[1]]); n7.setIcon(numberimage[newcreditview[2]]);n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]); n4.setIcon(numberimage[newcreditview[5]]);n3.setIcon(numberimage[newcreditview[6]]); n2.setIcon(numberimage[newcreditview[7]]);
            n1.setIcon(numberimage[newcreditview[8]]); n0.setIcon(numberimage[newcreditview[9]]);
        } 
        basic.add(goldnumber);
    	
        //배팅 포인트 표시
        JPanel betbox = new JPanel(){
            public void paintComponent(Graphics h) {
                h.drawImage(new ImageIcon(new ImageIcon("imgs/betbox.png").getImage().getScaledInstance(200, 50, Image.SCALE_SMOOTH)).getImage(),0, 0, null);
                setOpaque(false);
            }
        };
        betbox.setBounds(130, 600,200,50);
        betbox.setLayout(null);
    	betshow = new JLabel();       
        betshow.setBounds(80, 0, 200, 50);
        Font f2 =new Font("8-bit Operator+ 8",Font.PLAIN,20);
        betshow.setFont(f2);
    	betshow.setText(Integer.toString(betcredit));
    	betbox.add(betshow);

        basic.add(betbox);
        //슬롯머신 룰렛판 
    	p = new JPanel() {
    		public void paintComponent(Graphics h) {
      		   h.drawImage(new ImageIcon("imgs/p5_1.png").getImage(),0, 0, null);
      		   setOpaque(false);
      	   }
    	};
    	p.setLayout(new GridLayout(1,3));
        p.setBounds(113, 243, 222, 136);	
    	m1 = new JLabel(gg);       
    	m2 = new JLabel(gg);   
    	m3 = new JLabel(gg);
    	p.add(m1);
    	p.add(m2);
    	p.add(m3);
        basic.add(p);   
        
        //오류 잡기 위한 Label 이유를 아직 못 찾았음 
        JLabel kk  = new JLabel("");
        kk.setBounds(10, 10, 1, 1);
        basic.add(kk);                 
    
        setUI();       
        
    }
    
    void setUI(){
     
        frame.setSize(470,750);
        frame.setTitle("Kosmo 머신");
        if(Client.credit ==0){frame.setVisible(false);}else{frame.setVisible(true);}
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
    
    void spin() {
        gop.poo.ps.client.playSound("./music/coin.wav", false);
        // 머신 시작되면 버튼 조작 불가
    	run.setEnabled(false);
    	betplus.setEnabled(false);
    	betminus.setEnabled(false);

        // 슬롯머신 룰렛 회전 및 무작위 출력
    	Random r1 = new Random();
        Random r2 = new Random();
        Random r3 = new Random();
        
        idx1 = r1.nextInt(9);
        idx2 = r2.nextInt(9);
        idx3 = r3.nextInt(9);
            	
    	for(int i = 0; i<number.length;i++) {
    		m1.setIcon(image[i]);
    		try {
    			Thread.sleep(50);
    		}catch(InterruptedException ie) {}
            m1.setIcon(image[idx1]);	
    	}   
        	
    	for(int i = 0; i<number.length;i++) {
    		m2.setIcon(image[i]);
    		try {
    			Thread.sleep(70);
    		}catch(InterruptedException ie) {}
            m2.setIcon(image[idx2]);	
    	}	
        
    	for(int j = 0; j<2; j++){
            for(int i = 0; i<number.length;i++) {
                m3.setIcon(image[i]);
                try {
                    Thread.sleep(100);
                }catch(InterruptedException ie) {}  
            }
            m3.setIcon(image[idx3]);
        }
        
        
    	random();
    }

    void random(){
        gop.poo.ps.client.playSound("./music/point.wav", false);
        if(idx1==7 && idx1==idx2 && idx1==idx3){
            Client.credit = Client.credit + betcredit*4;
        }else if(idx1==idx2 && idx1==idx3){
            Client.credit = Client.credit + betcredit*2;     
        }else if(idx1==idx2 || idx1==idx3 || idx2==idx3){
            Client.credit = Client.credit + betcredit;
        }else{
            Client.credit = Client.credit-betcredit;
        }

        int creditview[] = Stream.of(String.valueOf(Client.credit).split("")).mapToInt(Integer::parseInt).toArray();
        int newcreditview[] = new int [creditview.length];
        for(int i = 0; i<creditview.length;i++){
            newcreditview[creditview.length -1 -i] = creditview[i];
        }

        for(int i =0; i<numberimage.length;i++){
            
            n9.setIcon(numberimage[i]);  n8.setIcon(numberimage[i]); n7.setIcon(numberimage[i]);n6.setIcon(numberimage[i]);
            n5.setIcon(numberimage[i]); n4.setIcon(numberimage[i]);n3.setIcon(numberimage[i]); n2.setIcon(numberimage[i]);
            n1.setIcon(numberimage[i]); n0.setIcon(numberimage[i]);
           try{
                Thread.sleep(50);
            }catch(InterruptedException ie){}
        }
        
        n9.setIcon(numberimage[0]);  n8.setIcon(numberimage[0]); n7.setIcon(numberimage[0]);n6.setIcon(numberimage[0]);
        n5.setIcon(numberimage[0]); n4.setIcon(numberimage[0]);n3.setIcon(numberimage[0]); n2.setIcon(numberimage[0]);
        n1.setIcon(numberimage[0]); n0.setIcon(numberimage[0]);

        if(creditview.length==1){
            n9.setIcon(numberimage[newcreditview[0]]);
        }else if(creditview.length==2){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]);
        }else if(creditview.length==3){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]); n7.setIcon(numberimage[newcreditview[2]]);
        }else if(creditview.length==4){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]);n7.setIcon(numberimage[newcreditview[2]]); n6.setIcon(numberimage[newcreditview[3]]);
        }else if(creditview.length==5){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]); n7.setIcon(numberimage[newcreditview[2]]); n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]);
        }else if(creditview.length==6){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]);  n7.setIcon(numberimage[newcreditview[2]]); n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]); n4.setIcon(numberimage[newcreditview[5]]);
        }else if(creditview.length==7){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]);n7.setIcon(numberimage[newcreditview[2]]);n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]); n4.setIcon(numberimage[newcreditview[5]]);n3.setIcon(numberimage[newcreditview[6]]);
        }else if(creditview.length==8){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]); n7.setIcon(numberimage[newcreditview[2]]); n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]); n4.setIcon(numberimage[newcreditview[5]]); n3.setIcon(numberimage[newcreditview[6]]);n2.setIcon(numberimage[newcreditview[7]]);
        }else if(creditview.length==9){
            n9.setIcon(numberimage[newcreditview[0]]); n8.setIcon(numberimage[newcreditview[1]]);   n7.setIcon(numberimage[newcreditview[2]]);  n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]);  n4.setIcon(numberimage[newcreditview[5]]);  n3.setIcon(numberimage[newcreditview[6]]);   n2.setIcon(numberimage[newcreditview[7]]);
            n1.setIcon(numberimage[newcreditview[8]]);
        }else if(creditview.length==10){
            n9.setIcon(numberimage[newcreditview[0]]);  n8.setIcon(numberimage[newcreditview[1]]); n7.setIcon(numberimage[newcreditview[2]]);n6.setIcon(numberimage[newcreditview[3]]);
            n5.setIcon(numberimage[newcreditview[4]]); n4.setIcon(numberimage[newcreditview[5]]);n3.setIcon(numberimage[newcreditview[6]]); n2.setIcon(numberimage[newcreditview[7]]);
            n1.setIcon(numberimage[newcreditview[8]]); n0.setIcon(numberimage[newcreditview[9]]);
        }  
                   
        if(betcredit>Client.credit){          
            run.setEnabled(false);
            betplus.setEnabled(true);
            betminus.setEnabled(true);      
        }else{
            run.setEnabled(true);
            betplus.setEnabled(true);
            betminus.setEnabled(true);
        }
        
        
        gop.poo.ps.client.remaincoin();       
        if(Client.credit<=0 || Client.credit>1000000000){
            frame.setVisible(false);
            end();
        }
    }
    
    void plus() {
        // +버튼을 누를 때 
    	if(betcredit<Client.credit) {
	    	this.betcredit = betcredit+100;
	    	betshow.setText(Integer.toString(betcredit));
	    	if(betcredit>=Client.credit){
                run.setEnabled(true);
                betplus.setEnabled(false);
                betminus.setEnabled(true);
            }else{
                run.setEnabled(true);
                betplus.setEnabled(true);
                betminus.setEnabled(true);
            }
    	}
    }
    void minus() {	
    	 // -버튼을 누를 때
    	if(betcredit>0) {
	    	this.betcredit = betcredit-100;
	    	betshow.setText(Integer.toString(betcredit));
	    	if(betcredit<=0){
                run.setEnabled(false);
                betplus.setEnabled(true);
                betminus.setEnabled(false);
            }else if(betcredit>Client.credit){
                run.setEnabled(false);
                betplus.setEnabled(true);
                betminus.setEnabled(true);
            }else{
                run.setEnabled(true);
                betplus.setEnabled(true);
                betminus.setEnabled(true);
            }
            
    	}
    }

    void end(){
        //모든 버튼을 정지
        run.setEnabled(false);
        betplus.setEnabled(false);
        betminus.setEnabled(false);
        // 새 프레임에서 사용을 종료함 
        exit = new JFrame("kosmo");     
        
        Container exitcon = new Container();
        exitcon = exit.getContentPane();

        exitpanel = new JPanel()/*{
            public void paintComponent(Graphics g){
                g.drawImage(new ImageIcon(new ImageIcon(getClass().getResource("./imgs/p2-2.jpg")).getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH)).getImage(),0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        }*/;
        exitpanel.setLayout(null);
        exitpanel.setBackground(Color.white);
        exitcon.add(exitpanel);
        
        
        JButton exitB = new JButton(new ImageIcon("imgs/p2-8_.png"));
        exitB.setBounds(240, 200, 90, 57);
        exitB.setContentAreaFilled(false);
        exitB.setFocusPainted(false);
        exitB.setBorderPainted(false);
        exitB.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitB.addActionListener((e)-> {
            gop.poo.ps.client.playSound("./music/ButtonSound1.wav", false);
            System.exit(0);
        });
        exitpanel.add(exitB);

        JLabel exitletter = new JLabel("<html><body><center>Go to the currency exchange and get points.<br>See you next time.</center></body></html>");
        Font f1 = new Font("8-bit Operator+ 8",Font.PLAIN,20);
        exitletter.setFont(f1);
        exitletter.setBounds(150, 70, 300, 100);
        
        exitpanel.add(exitletter);

        exitsetUI();
    }

    void exitsetUI(){
        exit.setSize(600,400);
        exit.setResizable(false);
        exit.setVisible(true);
        exit.setLocationRelativeTo(null);
        exit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   /*  public static void main(String[] args) {
        Slot s = new Slot();
        s.mach();        
    }*/
}