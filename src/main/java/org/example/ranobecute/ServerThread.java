package org.example.ranobecute;

import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;
    private int id;

    public ServerThread(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    public void run(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            String s = "";
            while ((s = (String)inputStream.readObject())!=null ){
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
