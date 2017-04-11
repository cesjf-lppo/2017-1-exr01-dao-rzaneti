package Exercico_DAO_01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RafaelaEmília
 */
public class CriaTabela {
    
    public static void main (String[] args){
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            String url = "jdbc:derby://localhost:1527/lpto-2017-1";
            
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            System.out.println("Conexao aberta com sucesso");
            
            String sql = "CREATE TABLE contatos (nome VARCHAR(50), sobrenome VARCHAR(50), telefone VARCHAR(10), email VARCHAR(50))";
            
            Statement operacao = conexao.createStatement();
            
            operacao.executeUpdate(sql);
            System.out.println("Tabela Criada!");
            
        } catch (ClassNotFoundException ex) {
             System.err.println("Driver indisponível");
            Logger.getLogger(ConectaComBanco.class.getName()).log(Level.SEVERE, null, ex);
           
        } catch (SQLException ex) {
             System.err.println("Problema ao acessar o banco");
            Logger.getLogger(ConectaComBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    
    }
    
}
