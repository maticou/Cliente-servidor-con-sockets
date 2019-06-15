/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author mati_
 */
public class Cliente {

    public static String HOST = "127.0.0.1";
    public static int PUERTO = 5000;
    public static DataInputStream entrada;
    public static DataOutputStream salida;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

            try (Socket socket = new Socket(HOST, PUERTO)) {
                entrada = new DataInputStream(socket.getInputStream());
                salida = new DataOutputStream(socket.getOutputStream());
                salida.writeUTF("Soy el cliente y quiero conectarme. Déjame entrar!!!!");
                
                String mensaje = entrada.readUTF();                
                System.out.println(mensaje);
            }catch(IOException ex){
                System.out.println(ex);
            }
    }
}
