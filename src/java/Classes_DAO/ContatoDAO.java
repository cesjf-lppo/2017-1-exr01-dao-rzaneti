/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes_DAO;

import Exercico_DAO_01.Contato;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RafaelaEmília
 */
public class ContatoDAO {
    
    public List<Contato> listAll() throws Exception{
        try {
            List<Contato> contatos = new ArrayList<>();
            
                        
            Connection conexao = ConnectionFactory.createConnection();
            
            
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM contato");
            
            while(resultado.next()){
                Contato novoContato = new Contato();
                novoContato.setId(resultado.getLong("id"));
                novoContato.setNome(resultado.getString("nome"));
                novoContato.setSobrenome(resultado.getString("sobrenome"));
                novoContato.setTelefone(resultado.getString("telefone"));
                
                contatos.add(novoContato);
            
            }
            
            
            return contatos;
        } catch (ClassNotFoundException ex) {            
            throw new Exception("Driver não encontrado!", ex);
        } catch(SQLException ex){
            throw new Exception("Erro ao listar os contatos no banco!", ex);
                    
        
        }
    
    }

    public void cria(Contato novoContato) throws Exception {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            
            Connection conexao = ConnectionFactory.createConnection();
            
            Statement operacao = conexao.createStatement();
            
            operacao.executeUpdate("INSERT INTO contato(nome, sobrenome, telefone) VALUES('"
                    +novoContato.getNome()+ "', '"
                    +novoContato.getSobrenome()+ "', '"
                    +novoContato.getTelefone()+ "') ");
            
        } catch (ClassNotFoundException ex) {
            throw new Exception("Erro ao carregar o driver!", ex);
        } catch(SQLException ex){
            throw new Exception("Erro ao inserir o contato");
        
        }
        
    }
    
}
