package jeon.slot;



import java.awt.BorderLayout;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;







public class ServerMulti{
    ServerSocket ss;
    Socket s;
    int port=5000;
    int begin;
    ServerModul sm;
    Vector<ServerModul> v = new Vector<ServerModul>();

    JFrame frame = new JFrame();
    JTextArea text;
    JLabel label;
    JButton button, exiButton;
    boolean flag = true;
    ServerMulti(){
        try{
            setFrame();
            
            ss = new ServerSocket(port);
            
            while(begin==0){
                try{
                    Thread.sleep(100);
                }catch(InterruptedException ie){}
            }
            while(begin==1){  
                if(flag){
                    text.append("서버가 열렸습니다."+"\n");
                    button.setEnabled(false);
                    flag = false;
                }
                s= ss.accept();
                sm = new ServerModul(this);
                v.add(sm);
                sm.start();
            }   
        }catch(IOException ie){}
        finally{
            try{
                if(ss != null) ss.close();
            }catch(IOException ie){}
        }
    }

    void setFrame(){
        
        Container con = new Container();
        con = frame.getContentPane();

        JPanel bottombutton = new JPanel();
        bottombutton.setLayout(new GridLayout(1,2));

        button = new JButton("서버시작");
        button.addActionListener((e)-> {  
              begin = 1;
        });

        exiButton = new JButton("서버 종료");
        exiButton.addActionListener((e)-> System.exit(0));

        bottombutton.add(button);
        bottombutton.add(exiButton);

        
        text = new JTextArea(); 
        text.setText("서버를 시작하세요."+"\n");
        text.setEditable(false);
        

        JScrollPane scrollPane = new JScrollPane(text);

        con.add(scrollPane);
        con.add(bottombutton, BorderLayout.SOUTH);
        
        
    
        setUI();

    }

    void setUI(){
        frame.setTitle("서버");
        frame.setSize(400,400);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ServerMulti();
    }
}
