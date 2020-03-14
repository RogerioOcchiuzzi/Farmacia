package farmacia.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rogerio
 */
public class Model {
    
    private ArrayList arrayBusca;
    private Connection conexao;
    
    public Model(){
        
        try {
            
            Class.forName("org.sqlite.JDBC");
            this.conexao = 
                DriverManager.getConnection("jdbc:sqlite:BDFarmacia.db");
            
        } catch (ClassNotFoundException ex) {
            
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public void fazPesquisa(String nomeRemedioInput){
               
        try {
            this.arrayBusca = pesquisaTabela(this.conexao, nomeRemedioInput);
            
        } catch ( Exception e ) {

            System.err.println(e.getMessage());
           
        }       
        
    }
    
    public ArrayList getArrayBusca(){
        
        return this.arrayBusca;
    }
    
    private ArrayList pesquisaTabela(Connection conexao, 
                    String nomeRemedioInput) throws SQLException{
        
        Statement stmt = null;
        String sqlString = "SELECT * FROM farmacia WHERE nome_remedio = '"+
                nomeRemedioInput +"';";
        ArrayList arrayBusca = new ArrayList();
                
        conexao.setAutoCommit(false);
        stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sqlString);        

        while ( rs.next() ) {

            arrayBusca.add(rs.getInt("id"));
            arrayBusca.add(rs.getString("nome_remedio"));
            arrayBusca.add(rs.getString("bula"));
            arrayBusca.add(rs.getInt("quantidade"));
            arrayBusca.add(rs.getFloat("preco"));

        }

        rs.close();
        stmt.close();
        //conexao.close();
        
        return arrayBusca;
    }
    
    public void mudaQuantidade(int quantidade, String nomeItem){

        try {   
            
            
            String sqlString = "UPDATE farmacia SET quantidade = "+
                    quantidade + " WHERE nome_remedio = '"+
                    nomeItem+"';";
            
            this.conexao.setAutoCommit(false);
            Statement stmt = this.conexao.createStatement();
            stmt.executeUpdate(sqlString);
            this.conexao.commit();
            stmt.close();
            
            
        } catch ( Exception e ) {

            System.err.println(e.getMessage());
           
        } 
        
    }
    
}
