/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2distribuidos.distribuidor2;

/**
 *
 * @author Javier
 */
public class Singleton_conexion2 {
    //puntero que hereda conexion
    private ConexionBDdistribuidor2 cdb;
    
    private static Singleton_conexion2 instancia;
    
    public Singleton_conexion2(){
        
    }
    
    public static Singleton_conexion2 getInstancia(){
        if(instancia==null){
            instancia = new Singleton_conexion2();
        }
        return instancia;
    }
    
    public ConexionBDdistribuidor2 getConexiondb() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        if(cdb == null){
            String nombreClase = "proyecto2distribuidos.distribuidor2.Conexion_Postgres2";
            
            cdb = (ConexionBDdistribuidor2) Class.forName(nombreClase).newInstance();
        }
        return cdb;
    }
}
