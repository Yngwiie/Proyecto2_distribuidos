package proyecto2distribuidos;

import proyecto2distribuidos.distribuidor1.ConexionBDdistribuidor1;
import proyecto2distribuidos.distribuidor1.Singleton_conexion;
import proyecto2distribuidos.distribuidor2.ConexionBDdistribuidor2;
import proyecto2distribuidos.distribuidor2.Singleton_conexion2;
import proyecto2distribuidos.distribuidor3.ConexionBDdistribuidor3;
import proyecto2distribuidos.distribuidor3.Singleton_conexion3;

/**
 *
 * @author Javier
 */
public class Proyecto2Distribuidos {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
         ConexionBDdistribuidor1 cdb1 = Singleton_conexion.getInstancia().getConexiondb();
         ConexionBDdistribuidor2 cdb2 = Singleton_conexion2.getInstancia().getConexiondb();
         ConexionBDdistribuidor3 cdb3 = Singleton_conexion3.getInstancia().getConexiondb();
    }
    
}
