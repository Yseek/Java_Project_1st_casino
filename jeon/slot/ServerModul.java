package jeon.slot;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerModul extends Thread{
    ServerMulti sml;
    Socket s;
    InputStream is;
    OutputStream os;
    DataInputStream dis;
    DataOutputStream dos;
    String name, loadpoint;
    File file;

    ServerModul(ServerMulti sml){
        this.sml = sml;
        this.s = sml.s;

        try{
            is = s.getInputStream();
            dis = new DataInputStream(is);
            os = s.getOutputStream();
            dos = new DataOutputStream(os);
        }catch(IOException ie){}
    }

    public void run(){
        logincheck();
    }
    void logincheck(){
        try{
            name = dis.readUTF();
            sml.text.append(name+"님이 입장하셨습니다."+"\n");
            sml.text.append("다음 접속 대기중..."+"\n");
            readfile();         
        }catch(IOException ie){}
    }

    void readfile(){
        try{
            file = new File("userdata/"+name+".txt"); 
            if(file.exists()){               
                BufferedReader br = new BufferedReader(new FileReader("userdata/"+name+".txt"));
                loadpoint = br.readLine();
                br.close();
                sml.text.append(name+"님은 기존 회원입니다."+"남은 포인트: "+ loadpoint+"\n");
                sendpoint();
            }else{          
                FileWriter fw = new FileWriter(file,false);
                fw.write("2000");
                fw.flush();
                loadpoint = "2000";
                fw.close();
                sml.text.append(name+"님은 기존 회원이 아닙니다."+"충전 포인트: "+ loadpoint+"\n");        
                sendpoint();
            }
        }catch(FileNotFoundException fe){}
        catch(IOException ie){}
    }

    void sendpoint(){
        try{
            dos.writeUTF(loadpoint);
            dos.flush();           
            getremaincoin();
        }catch(IOException ie){}
    }

    void getremaincoin(){   
        try{
            while(true){
                String remaincoin = dis.readUTF();
                FileWriter fw = new FileWriter(file,false);
                fw.write(remaincoin);
                fw.flush();
                fw.close();
                System.out.println("정상업데이트");
            }            
        }catch(IOException ie){
            sml.v.remove(this);
            sml.text.append(name+"나감"+"\n");
        }finally{
            try{
                dis.close();
                is.close();
                dos.close();
                os.close();
                s.close();
            }catch(IOException ie){}
        }     
    }
}
