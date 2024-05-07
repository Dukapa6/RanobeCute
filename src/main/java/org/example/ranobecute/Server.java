package org.example.ranobecute;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(444);// 65536
            while (true){
                Socket socket = server.accept();
                ServerThread clients = new ServerThread(socket);
                clients.start();
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}