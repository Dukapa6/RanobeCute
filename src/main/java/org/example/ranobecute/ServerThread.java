package org.example.ranobecute;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run(){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            String[] s = (String[]) inputStream.readObject();
            if( s[0].equals("Login")){
                DatabaseHandler dbhandler = new DatabaseHandler();
                User user = new User();
                user.setUsername(s[1]);
                user.setPassword(s[2]);
                ResultSet result = dbhandler.getUser(user);
                int counter = 0;
                while( result.next() ){
                    counter++;
                    break;
                }

                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                outputStream.writeObject(String.valueOf(counter));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
