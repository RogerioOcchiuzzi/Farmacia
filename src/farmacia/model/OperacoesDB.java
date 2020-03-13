package farmacia.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rogerio
 */
public class OperacoesDB {
    
    public OperacoesDB(){
        
        Connection conexao = null;

        try {

            Class.forName("org.sqlite.JDBC");
            conexao = DriverManager.getConnection("jdbc:sqlite:BDFarmacia.db");

            //criarTabela(conexao);
            //inserirValores(conexao);
            pesquisatabela(conexao);
            
        } catch ( Exception e ) {

            System.err.println(e.getMessage());
           
        }
    }
    
    public void criarTabela(Connection conexao) throws SQLException{
        
        Statement stmt = null;
        String sqlString = "CREATE TABLE farmacia(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nome_remedio VARCHAR(255) NOT NULL," +
            "bula VARCHAR(255) NOT NULL," +
            "quantidade INT NOT NULL," +
            "preco FLOAT NOT NULL);"; 
        
        stmt = conexao.createStatement();        
        stmt.executeUpdate(sqlString);
        stmt.close();
        conexao.close();

        System.out.println("Tabela criada com sucesso");
    }
    
    public void inserirValores(Connection conexao) throws SQLException{
        
        Statement stmt = null;
        String sqlString = 
            "INSERT INTO farmacia (nome_remedio, bula, quantidade, preco) VALUES " +
            "('Dorflex', 'relaxante muscular', 500, 10.99)," +
            "('Xarelto', 'anticoagulante', 322, 12.00)," +
            "('Selozok', 'redução da pressão arterial', 300, 1.50)," +
            "('Neosaldina', 'analgesico', 350, 5.98)," +
            "('Torsilax', 'relaxante muscular', 40, 35.00)," +
            "('Aradois', 'anti-hipertensivo', 430, 52.25)," +
            "('Glifage XR', 'antidiabetico', 242, 41.00)," +
            "('Addera D3', 'suplemento de vitamina D', 35, 70.00)," +
            "('Anthelios', 'protetor solar', 40, 45.00)," +
            "('Buscopan composto', 'reduz sintomas de colicas menstruais', 62, 8.90);"; 
        
        conexao.setAutoCommit(false);
        stmt = conexao.createStatement();         
        stmt.executeUpdate(sqlString);

        stmt.close();
        conexao.commit();
        conexao.close();
        
        System.out.println("Dados inseridos com sucesso");
    }
    
    public void pesquisatabela(Connection conexao) throws SQLException{
        
        Statement stmt = null;
        String sqlString = "SELECT * FROM farmacia;" ;
                
        conexao.setAutoCommit(false);
        stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sqlString);        

        while ( rs.next() ) {

            int id = rs.getInt("id");
            String  nomeRemedio = rs.getString("nome_remedio");
            String  bula = rs.getString("bula");
            int quantidade  = rs.getInt("quantidade");            
            float preco = rs.getFloat("preco");

            System.out.println(id + nomeRemedio + bula+
                    quantidade + preco);

        }

        rs.close();
        stmt.close();
        conexao.close();
        
        System.out.println("Pesquisa feita com sucesso");
    }
    
    public static void main( String args[] ) {
        
      new OperacoesDB();
      
   }
    
}
