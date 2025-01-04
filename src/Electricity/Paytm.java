/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Paytm extends JFrame implements ActionListener{
    String meter;
    JButton b1;
    Paytm(String meter){
        this.meter=meter;
        JEditorPane j=new JEditorPane();
        j.setEditable(false);
        
        b1=new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(500,20,120,25);
        b1.addActionListener(this);
        j.add(b1);
        
        try{
            j.setPage("https://paytm.com/electricity-bill-payment");
        }catch(Exception e){
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
            
        }
        JScrollPane scrollpane=new JScrollPane(j);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollpane);
        setPreferredSize(new Dimension(800,600));
        setSize(800,800);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new PayBill(meter).setVisible(true);
    }
    public static void main(String[]args){
        new Paytm("").setVisible(true);
    }
    
}
