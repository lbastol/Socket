/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fabian.giraldo
 */
public class Servidor {
    
    public static void main(String[] args) {
        try {
            //1:ServerSocket
            ServerSocket serverSocket = new ServerSocket(8000);
            //2.Escuchando conexion de un cliente
            System.out.println("Servidor esperando conexiones");
            Socket cliente = serverSocket.accept();
            System.out.println("Se ha conectado un cliente");
            //3.Abriendo flujos
            InputStream flujoEntrada = cliente.getInputStream();
            OutputStream flujoSalida = cliente.getOutputStream();
            //4. Poniendo decoradores para leer informacion textual
            BufferedReader lectura = new BufferedReader(new InputStreamReader(flujoEntrada));
            PrintWriter escritura = new PrintWriter(flujoSalida,true);
            
            BufferedReader lecturaUsuario = new BufferedReader(new InputStreamReader(System.in));
            String mensajeUsuario="";
            String mensajeLeido="";
            while(true){
              //5. Recibo la informacion
              mensajeLeido = lectura.readLine();
                System.out.println(mensajeLeido);
                System.out.println("Respuesta: ");
              //6. Mensaje Respuesta (Realizacion ECO)
                mensajeUsuario= lecturaUsuario.readLine();
              escritura.println(mensajeUsuario);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
