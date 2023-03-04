package domain;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.ConnectIOException;
import java.util.Scanner;

import enums.Command;

public class SocketModel{
    
    private String host;
    private int port;
    private PrintWriter out;
    private Scanner in;
    private Account acc = new Account();
    

    public SocketModel(String host, int port, String nick, String password) {
        this.host = host;
        this.port = port;
        acc.setNick(nick);
        acc.setPass(password);
    }

    public void connect() {
        try (Socket socket = new Socket(this.host, this.port)) {
            if(socket.isConnected()){
                System.out.println("Connected Successfully");

                out = new PrintWriter(socket.getOutputStream(), true);
                in = new Scanner(socket.getInputStream());

                sendMessage(Command.PASS, acc.getPass());
                sendMessage(Command.NICK, acc.getNick());
                sendMessage(5, "#yoda");
                while(in.hasNext()){
                    System.out.println(in.nextLine());

                }
            }
            throw new ConnectIOException("Connection refused");
        } catch (IOException e) {
           
            e.printStackTrace();
        }
    }

    public void sendMessage(Command cmd, String message){
        String msg = cmd + " " + message;
        out.println(msg);
        out.flush();
    }

    public void sendMessage(int code, String message){
        String msg = Command.valueOf(code) + " " + message;
        out.println(msg);
        out.flush();
    }

    private static String getCommand(String msg){
        String command[] = msg.split(" ", 3);
        
        return command[1];
    }
    
}
