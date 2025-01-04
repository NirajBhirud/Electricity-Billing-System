/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.font.*;
import javax.swing.JFrame.*;
import javax.swing.border.Border;
public class About extends JFrame implements ActionListener{

    JButton b1;
    JLabel l1;
    Font f,f1,f2;
    TextArea t1;
    String s;
    public About(){
        setLayout(null);
        b1=new JButton("Exit");
       
        b1.setBounds(180,430,120,20);
         add(b1);
        b1.addActionListener(this);
        
        f= new Font("Times New Roman",Font.BOLD,180);
        setFont(f);
        
        s="                          About Projects                       \n "
          +"\n Electricity Billing Systenm is a software-based application"
          +"developed in java programming languuage.the project aims at serving"
          +"the department of electricity by computerizing the billing system"
          +"It Mainly focuses on the calculations of units consumed during the"      
          +"specified time and the money to be paid to electricity offices"      
          +"this cpomputerized system wll make the overall billing system easy.,"
          +"acccessible,comfortable and effective for communication.\n\n";
        
          
        t1=new TextArea(s,10,40,Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);
        
        
        
        
        add(t1);
        
        Container contentPane=this.getContentPane();
        t1=new TextArea();
        
        l1=new JLabel("ABOUT PROJECT");
        add(l1);
        l1.setBounds(170, 20, 180, 80);
        l1.setForeground(Color.red);
        
        f2=new Font("Times New Roman",Font.BOLD,20);
        l1.setFont(f2);
        setBounds(700,220,500,550);
        
        setLayout(null);
        setVisible(true);

    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
     dispose();   
    }
    public static void main(String[]args){
        new About().setVisible(true);
    }
}


