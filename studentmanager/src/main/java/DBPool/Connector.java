/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author young
 */
public class Connector {
  public final static String connectionString = "jdbc:mysql://localhost:3306/student";
    public final static String user = "root";
    public final static String password = "";

    private static Connector instance;

    Connection conn;
    private Connector() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        // tao connect
        conn = DriverManager.getConnection(connectionString,user,password);
    }

    public static Connector getInstance() throws Exception {
        if (instance == null){
            instance = new Connector();
        }
        return instance;
    }

    public PreparedStatement getStatement(String sql) throws Exception{
        PreparedStatement statement = conn.prepareStatement(sql);
        return statement;
    }


}
