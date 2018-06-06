/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.jms.ConnectionFactory;


public class VeiculoDAO {
    
    private Connection conexao;
    
    public VeiculoDAO(Connection conexao){
        this.conexao=conexao;  
        
    }

    public VeiculoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean disponivel(String placa) throws SQLException{
        Statement stm = this.conexao.createStatement();
        ResultSet rs;
        String dis = null;
        String sql = "SELECT disponivel FROM veiculo WHERE placa = '"+placa+"'";
        rs = stm.executeQuery(sql);
        
        while(rs.next()){
            dis = rs.getString("disponivel");
        }
        
        if("N".equals(dis)){
            return false;
        }else {
            return true;
        }
        
    }
    
    public String retriveCategoria(String placa) throws SQLException{
            Statement stm = this.conexao.createStatement();
            String categoria = null;
            ResultSet rs;
            String sql = "SELECT fk_categoria FROM VEICULO WHERE placa = '"+placa+"'";
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                categoria = rs.getString("fk_categoria");
            }
            
            return categoria;
    }
    
    
    public void salvaVeiculo(Veiculo v) throws SQLException {
    String sql = "INSERT INTO VEICULO(PLACA, fk_unidade, fk_categoria, cor, numportas, ano, disponivel, modelo)VALUES(?,?,?,?,?,?,?,?)";   
        
            

            PreparedStatement ptm = Conexao.getPreparedStatement(sql);
            ptm.setString(1, v.getPlaca());
            ptm.setInt(2,1);
            ptm.setString(3, v.getFk_categoria());
            ptm.setString(4, v.getCor());
            ptm.setInt(5, v.getNumportas());
            ptm.setInt(6, v.getAno());
            ptm.setObject(7, v.getDisponivel());
            ptm.setString(8, v.getModelo());

            ptm.execute();
            ptm.close();
        }
    
    
    public ResultSet retrive () throws SQLException{
            Statement stm = this.conexao.createStatement();
            ResultSet rs;
            String sql = "SELECT * FROM VEICULO";
            rs = stm.executeQuery(sql);
            return rs;
    }
    
    public ResultSet retrivePlaca (String placa) throws SQLException{
            Statement stm = this.conexao.createStatement();
            ResultSet rs;
            String sql = "SELECT * FROM VEICULO WHERE PLACA ='"+placa+"'";
            rs = stm.executeQuery(sql);
            return rs;
    }
    
    public ResultSet retriveAno (String ano) throws SQLException{
            Statement stm = this.conexao.createStatement();
            ResultSet rs;
            String sql = "SELECT * FROM VEICULO WHERE ANO ="+ano;
            rs = stm.executeQuery(sql);
            return rs;
    }
    
    public ResultSet retrivePlacaD (String placa) throws SQLException{
            Statement stm = this.conexao.createStatement();
            ResultSet rs;
            String sql = "SELECT * FROM VEICULO WHERE PLACA ='"+placa+"'AND DISPONIVEL='S'";
            rs = stm.executeQuery(sql);
            return rs;
    }
    
    public ResultSet retriveAnoD (String ano) throws SQLException{
            Statement stm = this.conexao.createStatement();
            ResultSet rs;
            String sql = "SELECT * FROM VEICULO WHERE ANO ="+ano+"AND DISPONIVEL='S'";
            rs = stm.executeQuery(sql);
            return rs;
    }
   
    public int delete(String placa) throws SQLException {
        Statement stm = this.conexao.createStatement();
        ResultSet rs;        
        String sql = "DELETE FROM VEICULO WHERE PLACA='"+placa+"'";
        int i = stm.executeUpdate(sql);
        return i;
    }

    public List<Veiculo> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
