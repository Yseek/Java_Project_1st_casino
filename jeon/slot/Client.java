package jeon.slot;

import java.awt.Container;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Client {
    Socket s;
    int port =5000;
    int coin;
    String ipServer = "127.0.0.1";

    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;

    String id, point,path;
    JFrame clientFrame;
    PressStart ps;
    static int credit;
    Client client;
    Slot slot;
    Clip clip,clip2;
    File file = new File("./");
    
    
    
    Client(){
        path = file.getAbsolutePath();
        System.out.println(path);
        path = path.replace(".", "");
		path = path.replace("\\", "/");
        System.out.println(path);
        playSound("./music/bgm1.wav", true);
        System.out.println("./music/bgm1.wav");
        frameclient(); 
    }

    void playSound(String pathName, boolean isloop) {
        try {
           clip = AudioSystem.getClip();
           File audioFile = new File(pathName);
           AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
           clip.open(audioStream);
           clip.start();
           
           if(isloop)
              clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
           e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    void playSound2(String pathName, boolean isloop) {
        try {
           clip2 = AudioSystem.getClip();
           File audioFile = new File(pathName);
           AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
           clip2.open(audioStream);
           clip2.start();
           
           if(isloop)
              clip2.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException e) {
           e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
           e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
    
    void frameclient(){
        clientFrame = new JFrame(); 
        Container con = new Container();
        con = clientFrame.getContentPane();
        
        /*System.out.println("./imgs/p2-6.png");
        System.out.println(this.getClass().getClassLoader().getResource("./"));
        System.out.println(this.getClass().getResource("./"));*/
        JPanel cliJPanel = new JPanel(){
            public void paintComponent(Graphics g){  
                    g.drawImage(new ImageIcon("imgs/p1-1-1.jpg").getImage(),0, 0, null);
                    setOpaque(false);
            }  
        };       
        cliJPanel.setLayout(null);
        JTextField box = new JTextField();
        box.setBounds(180, 220, 200, 40);
        box.addActionListener((e)->{
            
            playSound("./music/ButtonSound1.wav", false);
            id=box.getText();
            if(id.length()==0){
                JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
                return;
            }
            connect();
            login();
            clientFrame.setVisible(false);    
        });
        JButton logiButton = new JButton();
        logiButton.setIcon(new ImageIcon(new ImageIcon("imgs/p2-6.png").getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH)));     
        logiButton.setBounds(400,220,50,40);
        logiButton.setContentAreaFilled(false);
        logiButton.setBorderPainted(false);
		logiButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logiButton.addActionListener((e)->{
            
            playSound("./music/ButtonSound1.wav", false);
            id=box.getText();
            if(id.length()==0){
                JOptionPane.showMessageDialog(null, "이름을 입력하세요.");
                return;
            }
            connect();
            login();
            clientFrame.setVisible(false);    
        });

        JLabel name = new JLabel();
        name.setBounds(180, 170, 300, 50);
        Font f1 = new Font("8-bit Operator+ 8", Font.PLAIN, 20);
        name.setFont(f1);
        name.setText("Please enter your name");


        
        
        cliJPanel.add(name);
        cliJPanel.add(box);
        cliJPanel.add(logiButton);
        con.add(cliJPanel);
        setUI();
        
    }
    void setUI(){
        clientFrame.setSize(648,760);
        clientFrame.setResizable(false);
        clientFrame.setLocationRelativeTo(null);
        clientFrame.setVisible(true);
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    

    void connect(){
        try{
            s = new Socket(ipServer,port);
            System.out.println("접속 성공");
            is = s.getInputStream();
            dis = new DataInputStream(is);
            os = s.getOutputStream();
            dos = new DataOutputStream(os);
        }catch(IOException ie){
                JOptionPane.showMessageDialog(null, "서버가 닫혀있습니다.");
        }
    }

    void login(){
        try{
            dos.writeUTF(id);
            dos.flush();
            getpoint();
        }catch(IOException ie){}      
    }
    void getpoint(){
        try{
            point = dis.readUTF();
            credit = Integer.parseInt(point);
            //coin = Integer.parseInt(point); 원본
           // slot = new Slot(this); 
            ps = new PressStart(this);            
        }catch(IOException ie){} 
    }

    void remaincoin(){
        System.out.println("안온다");
        try{
            dos.writeUTF(Integer.toString(Client.credit));
            dos.flush();
           // credit = slot.credit;
            System.out.println(Client.credit);
            System.out.println("남은 포인트 정상 업데이트");
        }catch(IOException ie){}        
    }


    public static void main(String[] args) {
       new Client();
      
    }
}
