/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.event.*;
public class CustomerDetails extends JFrame implements ActionListener{
    JTable t1;
    JButton b1;
    String x[]={"Customer Name","Meter","Address","City","Email","Phone","State"};
    String y[][]=new String[40][8];
    int i=0,j=0;
    CustomerDetails(){
       super("Cutsomer Detail");
       setSize(1200,650);
       setLocation(400,150);
       
       try{
           Conn c1=new Conn();
           String s1="select *from customer";
           ResultSet rs=c1.s.executeQuery(s1);
           while(rs.next()){
               y[i][j++]=rs.getString("name");
               y[i][j++]=rs.getString("meter");
               y[i][j++]=rs.getString("address");
               y[i][j++]=rs.getString("city");
               y[i][j++]=rs.getString("email");
               y[i][j++]=rs.getString("phone");
               y[i][j++]=rs.getString("state");

               i++;
               j=0;
           }
           t1=new JTable(y,x);
           
       }catch(Exception ae){
           ae.printStackTrace();
       }
       
       b1=new JButton("Print");
       add(b1,"South");
       JScrollPane sp=new JScrollPane(t1);
       add(sp);
       b1.addActionListener(this);
       
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      try{
          t1.print();
      } catch(Exception ae){}

    }
    public static void main(String[]args){
        new CustomerDetails().setVisible(true);
    }
}
