package org.example.ranobecute;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        try{

            Scanner sc = new Scanner(System.in);
            Socket socket = new Socket("127.0.0.1", 333);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input your name");
            String name = sc.next();
            String message = "";
            while (true){
                Date date = new Date();
                message = reader.readLine();
                outputStream.writeObject(name + " at "+ date+": "+message);

            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

