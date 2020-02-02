/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2distribuidos.distribuidor3;

import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Javier
 */
public class Conexion_Postgres3 extends ConexionBDdistribuidor3 {
    private String opciones ;
    private static String JDBC = "jdbc:postgresql://";
    private static String DRIVER = "org.postgresql.Driver";
    private static String HOST = "localhost:5432";
    
    /**
     * Instancia BD con charSet {LATIN1}.
     * @param database Nombre de la base de datos.
     * @param username Usuario de la base de datos.
     * @param password Clave de la base de datos.
     * @throws ClassNotFoundException En caso de que no se encuentre la clase que
     * permite la conexion con la Base de Datos.
     * @throws InstantiationException En caso de que no se pueda realizar la
     * instanciacion de la Base de Datos.
     * @throws IllegalAccessException En caso de que no se pueda establecer 
     * conexion con la Base de Datos.
     * @throws SQLException En caso que la consulta realizada no sea soportada
     * por el lenguaje SQL.
     */
    public Conexion_Postgres3(String database, String username, String password) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        super(JDBC, DRIVER, HOST, database, username, password);
        this.opciones = "charSet=LATIN1";
        
    }
    
    /**
     * Instancia de la base de datos.
     * @throws ClassNotFoundException En caso de que no se encuentre la clase que
     * permite la conexion con la Base de Datos.
     * @throws InstantiationException En caso de que no se pueda realizar la
     * instanciacion de la Base de Datos.
     * @throws IllegalAccessException En caso de que no se pueda establecer 
     * conexion con la Base de Datos.
     * @throws SQLException En caso que la consulta realizada no sea soportada
     * por el lenguaje SQL.
     */
    public Conexion_Postgres3() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{
        this("distribuidor3", "postgres", "mas");
    }
    
    /**
     * Inicializa la base de datos 
     * @throws ClassNotFoundException En caso de que no se encuentre la clase que
     * permite la conexion con la Base de Datos.
     * @throws InstantiationException En caso de que no se pueda realizar la
     * instanciacion de la Base de Datos.
     * @throws IllegalAccessException En caso de que no se pueda establecer 
     * conexion con la Base de Datos.
     * @throws SQLException En caso que la consulta realizada no sea soportada
     * por el lenguaje SQL.
     */
    @Override
    public void init() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{
        s_conexion = jdbc + host + "/"+database;     
        Class.forName(driver).newInstance();
        conexion = DriverManager.getConnection(jdbc+host+"/"+database+"?"+opciones,username,password);
        dbmd = conexion.getMetaData();
        statement =  conexion.createStatement();
    }
    
}
