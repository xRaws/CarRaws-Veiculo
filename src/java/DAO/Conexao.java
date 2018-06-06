/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author RawMa
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {

private static Connection conect = null;
   

public static Connection getC() {
try{
 conect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/locadora_pg", "postgres", "1234");
return conect;

}
catch(SQLException e){
System.out.println("error " + e.getMessage());

}
return null;
}









public static PreparedStatement getPreparedStatement(String sql) {
        if (conect == null) {
            conect = getC();
        }
        try {
            return conect.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println("Erro de SQL: " + ex.getMessage());
        }
        return null;
    }

}