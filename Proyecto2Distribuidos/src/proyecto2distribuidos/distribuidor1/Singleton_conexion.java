
package proyecto2distribuidos.distribuidor1;

/**
 *
 * @author Javier
 */
public class Singleton_conexion {
    
    //puntero que hereda conexion
    private ConexionBDdistribuidor1 cdb;
    
    private static Singleton_conexion instancia;
    
    public Singleton_conexion(){
        
    }
    
    public static Singleton_conexion getInstancia(){
        if(instancia==null){
            instancia = new Singleton_conexion();
        }
        return instancia;
    }
    
    public ConexionBDdistribuidor1 getConexiondb() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        if(cdb == null){
            String nombreClase = "proyecto2distribuidos.distribuidor1.Conexion_Postgres";
            
            cdb = (ConexionBDdistribuidor1) Class.forName(nombreClase).newInstance();
        }
        return cdb;
    }
}
