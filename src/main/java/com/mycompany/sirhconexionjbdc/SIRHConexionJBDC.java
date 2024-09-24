/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sirhconexionjbdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class SIRHConexionJBDC {

    public static void main(String[] args) {
        String usuario="root";
        String password="";
        String url="jdbc:mysql://localhost:3307/sirh";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM establecimiento");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));            
            }
            
            //Inserción de datos
            statement.execute("INSERT INTO `establecimiento` (`Id`, `nombre`, `ciudad`, `direccion`, `telefono`, `correo`) VALUES (NULL, 'Droguería Unida', '', '', NULL, NULL);");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM establecimiento");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));            
            }   
            
            //Actualización de datos
            statement.execute("UPDATE `establecimiento` SET `nombre` = 'Farmacia Salud y Vida' WHERE `establecimiento`.`Id` = 124;");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM establecimiento");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));            
            } 
            
            // Eliminación de datos
            statement.execute("DELETE FROM establecimiento WHERE `establecimiento`.`Id` = 129");
            System.out.println("");
            rs = statement.executeQuery("SELECT * FROM establecimiento");
            while(rs.next()){
                System.out.println(rs.getString("nombre"));            
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(SIRHConexionJBDC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
