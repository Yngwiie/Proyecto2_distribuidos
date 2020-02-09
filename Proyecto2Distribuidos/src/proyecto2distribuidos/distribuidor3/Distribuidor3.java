
package proyecto2distribuidos.distribuidor3;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class Distribuidor3 extends Observable implements Runnable {

    
    private int puerto;
    private ConexionBDdistribuidor3 cbd;
    
    public Distribuidor3(int puerto,ConexionBDdistribuidor3 cbd){
        this.puerto = puerto;
        this.cbd = cbd;
    }
    
    @Override
    public void run() {
        
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
            
                
        try {            
            //Creamos el socket del servidor
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");
                    
            //Siempre estara escuchado peticiones
            
            while(true){
                //Espero a que un cliente se conecte
                sc = servidor.accept();
                
                System.out.println("Cliente conectado");
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                String mensaje = in.readUTF();
                if(mensaje.equals("3"+"\n")){
                     this.cbd.un_sql = "select sum(cantidad_litros) as total_litros,count(id) as cargas_realizadas from transacciones";
                     cbd.resultado = this.cbd.statement.executeQuery(cbd.un_sql);
                     if(cbd.resultado.next()){
                         mensaje ="Resultado \n"+ 
                                 "Litros Consumidos: "+cbd.resultado.getInt("total_litros")+"\n"+
                                 "Cantidad cargas: "+cbd.resultado.getString("cargas_realizadas");
                     }else{
                         mensaje = "No se encontro nada";
                     }
                     this.setChanged();
                     this.notifyObservers(mensaje + "\n");
                     this.clearChanged();

                 }
                 else if(mensaje.equals("dos"+"\n")){
                     mensaje = "pedir por la cantidad de surtidores";
             }
                
                    
            out.writeUTF(mensaje);

            

            //Ciero el soket
            sc.close();
            System.out.println("Cliente desconectado");
                
            }
                
   
           
                    
        } catch (IOException ex) {
            Logger.getLogger(Distribuidor3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Distribuidor3.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }
    
}
