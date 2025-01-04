/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class DepositDetails extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;
    JLabel l1,l2;
    Choice c1,c2;
    String x[]={"Meter Number","Month","Units","Total Bill","Status"};
    String y[][]=new String[40][8];
    DepositDetails(){
        super("Deposite Details");
        setSize(700,750);
        setLocation(600,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        l1=new JLabel("Sort by Meter Number");
        l1.setBounds(20,20,150,20);
        add(l1);
        
        c1=new Choice();
        
        
        l2=new JLabel("Sort by Month");
        l2.setBounds(400,20,100,20);
        add(l2);

        c2=new Choice();

        t1=new JTable(y,x);
        
        try{
            Conn c=new Conn();
            String s1="select *from bill";
            ResultSet rs=c.s.executeQuery(s1);
            
            t1.setModel(DbUtils.resultSetToTableModel(rs));
            
            String str2="select *from customer";
            rs=c.s.executeQuery(str2);
            while(rs.next()){
                c1.add(rs.getString("meter"));
            }
        }catch(Exception ae){
            ae.printStackTrace();
        }
        
        c1.setBounds(180,20,150,20);
        add(c1);
        
        
        c2.setBounds(180,20,150,20);
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        add(c2);
        
        b1=new JButton("Search");
        b1.setBounds(20,70,80,20);
        b1.addActionListener(this);
        add(b1);
        
        b2=new JButton("Print");
        b2.setBounds(120,70,80,20);
        b2.addActionListener(this);
        add(b2);
        
        JScrollPane sp=new JScrollPane(t1);
        sp.setBounds(0,100,700,650);
        add(sp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String str="select *from bill wher meter='"+c1.getSelectedItem()+"' AND month='"+c2.getSelectedItem()+"'";
            try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception ae){}
        }else if(e.getSource()==b2){
            try{
                t1.print();
            }catch(Exception ae){}
        }

    }
    public static void main(String[]args){
        new DepositDetails().setVisible(true);
    }
}
