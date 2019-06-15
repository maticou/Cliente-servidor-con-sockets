/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Manuel_Gonzalez-Matias_Parra
 */
public class Servidor {

    public static void main(String[] args) {
        ServerSocket servidor;
        Socket socket;
        DataInputStream entrada;
        DataOutputStream salida;
        
        int puerto = 5000;
        
        try {
            servidor = new ServerSocket(puerto);
            
            System.out.println("Servidor iniciado");
            
            while(true){
                socket = servidor.accept();
                
                System.out.println("Cliente conectado.");
                
                entrada = new DataInputStream(socket.getInputStream());
                salida = new DataOutputStream(socket.getOutputStream());
                
                String mensaje = entrada.readUTF();
                
                System.out.println(mensaje);
                
                salida.writeUTF("Este mesaje fue enviado desde el servidor");
            }
        } catch (IOException ex) {
            System.out.println("Ocurrió un problema con el servidor");
        }
    }
    
}
