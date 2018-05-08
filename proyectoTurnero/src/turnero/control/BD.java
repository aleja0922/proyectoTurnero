package turnero.control;

import turnero.control.IO;
import java.sql.*;

public class BD {

    private String driver, url, ip, bd, usr, pass;
    private Connection conexion;
    private Statement sentenciaSQL;
    private ResultSet registro;

    public BD() {
        registro = null;
    }

    public ResultSet getRegistro() {
        return registro;
    }

    public ResultSet hacerConsulta(String consulta) {
        try {
            registro = sentenciaSQL.executeQuery(consulta);
        } catch (SQLException e) {
            System.out.println("ERROR EN CONSULTA - en ResultSet: " + e);
        }
        return registro;
    }

    public void conectar() {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
              conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "aleja1997");  // Coloque aqu� su Login y Password
            //conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "luisleon9");  // Coloque aqu� su Login y Password
            sentenciaSQL = conexion.createStatement();
            System.out.println("Conexion hecha");
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println("ERROR EN CONEXION: " + error);
        }
    }

    public Connection CerrarConexion() throws SQLException {
        conexion.close();
        conexion = null;
        return conexion;
    }

    public Connection getConexion() {
        return (conexion);
    }

    public boolean ejecutar(String commit) {
        try {
            sentenciaSQL.executeUpdate(commit);
            return true;

        } catch (SQLException error) {
            IO.mostrar("ERROR DE EJECUCIÓN" + error);
            IO.mostrar(commit);
            return false;

        }
    }

    public void getBD(String commit) {

        try {

            registro = sentenciaSQL.executeQuery(commit);

        } catch (SQLException error) {
            IO.mostrar("ERROR DE EJECUCIÓN" + error);
            IO.mostrar(commit);

        }
    }

    public void desconectar() {
        try {
            if (registro != null) {
                registro.close();
            }
            sentenciaSQL.close();
            conexion.close();
        } catch (SQLException error) {
            System.out.println("ERROR EN DESCONEXION: " + error);
        }

    }

}
