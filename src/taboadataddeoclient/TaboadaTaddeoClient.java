/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taboadataddeoclient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author taboada.taddeo
 */
public class TaboadaTaddeoClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // IP Bucci
        // String ip = "10.205.0.50";
        
        // IP Local
        // String ip = "localhost";
        
        // IP Eldego
        String ip = "10.205.0.32";
        
        int port = 12345;
        Socket socket;
        Scanner s = new Scanner(System.in);
        socket = new Socket(ip, port);
        String message = "";
        
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        
        do {
        message = s.nextLine();
        dataOutputStream.writeUTF(message);
        
        String response = dataInputStream.readUTF();
        System.out.println(response);
        } while (!"Arrivederci".equals(message));
        
        socket.close();
    }
    
}
