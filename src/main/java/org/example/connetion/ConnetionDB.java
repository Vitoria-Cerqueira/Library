package org.example.connetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnetionDB {
    private static final String url = "jdbc:postgresql://localhost/library";
    private static final String user = "postgres";
    private static final String password = "58235718";

    public static Connection connection(){
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            if (conn != null){
                System.out.println("Foi conectado ao banco de dados");

            }else {
                System.out.println("Conexão ao banco de dados falhou");
            }
            return conn;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }
}
