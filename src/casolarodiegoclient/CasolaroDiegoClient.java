/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casolarodiegoclient;

import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author CASOLARO.DIEGO
 */
public class CasolaroDiegoClient {

    /**
     * @param args the command line argumentsv  10.205.0.32
     * 10.205.0.50
     */
    public static void main(String[] args) throws IOException {
        String ip = "10.205.0.22";
        int porta = 12345;
        Socket socket= new Socket(ip,porta);
        Scanner scanner=new Scanner(System.in);
        String message, response;
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        response = dataInputStream.readUTF(); // Su response ho la risposta
        System.out.println(response);
        dataOutputStream.writeUTF("Ciao io sono Eldego e sono collegato!");
        response = dataInputStream.readUTF(); // Su response ho la risposta
        System.out.println(response);
        if(response=="Arrivederci"){
            socket.close();
        }
        else{
            do{
                System.out.println("messaggia:");
                message = scanner.nextLine();
                dataOutputStream.writeUTF(message);

                response = dataInputStream.readUTF(); // Su response ho la risposta
                System.out.println(response);
            }while(!response.equals("Arrivederci")||!message.equals("Arrivederci"));
            socket.close();
        }
    }    
}
