/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2distribuidos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyecto2distribuidos.distribuidor1.ConexionBDdistribuidor1;
import proyecto2distribuidos.distribuidor1.Distribuidor1;

/**
 *
 * @author ignacio
 */
public class Empresa extends Observable implements Runnable{


    private int puerto; 
    private String mensaje;
    private String host;
    
    
    public Empresa(int puerto,String host, String mensaje){
        this.puerto = puerto;
        this.host = host;
        this.mensaje = mensaje;
    }
    
    @Override
    public void run() {
        //Host del servidor
            
            DataInputStream in ;
            DataOutputStream out;
        
        
        try {
            //Creo el socket para conetarme con el cliente
            Socket sc = new Socket(this.host,puerto);
            out = new DataOutputStream(sc.getOutputStream());
            in = new DataInputStream(sc.getInputStream());

            out.writeUTF(mensaje);
            
            String men = in.readUTF();

            this.setChanged();
            this.notifyObservers(men + "\n");
            this.clearChanged();

            sc.close();

            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Distribuidor1.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
 
}
