package farmacia.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rogerio
 */
public class Model {
    
    private ArrayList arrayBusca;
    
    public Model(){
        
    }
    
    public void fazPesquisa(String nomeRemedioInput){
        
        Connection conexao = null;

        try {

            Class.forName("org.sqlite.JDBC");
            conexao = DriverManager.getConnection("jdbc:sqlite:BDFarmacia.db");
            this.arrayBusca = pesquisaTabela(conexao, nomeRemedioInput);
            
        } catch ( Exception e ) {

            System.err.println(e.getMessage());
           
        }       
        
    }
    
    public ArrayList getArrayBusca(){
        
        return this.arrayBusca;
    }
    
    private ArrayList pesquisaTabela(Connection conexao, String nomeRemedioInput) throws SQLException{
        
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
        conexao.close();
        
        return arrayBusca;
    }
    
}
