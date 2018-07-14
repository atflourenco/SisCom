
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class GerenciadorConexao {
    private String usuario = "postgres";
    private String senha = "postgres";
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost:5432/siscom";
    
    //Inicio singleton
    //Constutor privado
    private GerenciadorConexao(){}
    //Objeto da propria classe privado e estatico
    private static GerenciadorConexao instance = null;
    //Método que retorna a instancia da classe
    public static GerenciadorConexao getInstance(){
        if(instance==null){
            instance = new GerenciadorConexao();
        }
        return instance;
    }
    //Fim singleton
    
    public Connection getConexao(){
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao BD!");
        }        
        return conn;
    }
}
