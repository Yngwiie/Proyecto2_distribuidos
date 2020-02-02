/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2distribuidos.distribuidor3;


/**
 *
 * @author Javier
 */
public class Singleton_conexion3 {
    //puntero que hereda conexion
    private ConexionBDdistribuidor3 cdb;
    
    private static Singleton_conexion3 instancia;
    
    public Singleton_conexion3(){
        
    }
    
    public static Singleton_conexion3 getInstancia(){
        if(instancia==null){
            instancia = new Singleton_conexion3();
        }
        return instancia;
    }
    
    public ConexionBDdistribuidor3 getConexiondb() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        if(cdb == null){
            String nombreClase = "proyecto2distribuidos.distribuidor3.Conexion_Postgres3";
            
            cdb = (ConexionBDdistribuidor3) Class.forName(nombreClase).newInstance();
        }
        return cdb;
    }
}
