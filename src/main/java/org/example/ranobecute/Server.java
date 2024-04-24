package org.example.ranobecute;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(333);// 65536
            int id = 1;
            while (true){
                Socket socket = server.accept();
                System.out.println("Client #"+ id +" connected successfully");
                ServerThread clients = new ServerThread(socket, id);
                id++;
                clients.start();
            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}