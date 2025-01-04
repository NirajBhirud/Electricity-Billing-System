package Electricity;

import java.sql.*;  

public class Conn{
    Connection c;
    Statement s;
    public Conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql://localhost:3307/ebs?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC","root","root");    
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            e.printStackTrace();
        }  
    }  

    void add(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}  