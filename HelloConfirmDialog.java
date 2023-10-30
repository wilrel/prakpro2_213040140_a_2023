/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yow;

/**
 * Kelas HelloConfirmDialog adalah kelas utama yang menggambarkan sebuah aplikasi sederhana
 * yang menampilkan dialog konfirmasi saat tombol "EXIT" ditekan.
 *
 * @author M Azka Ramadhan 213040121
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloConfirmDialog extends JFrame {
    
    public HelloConfirmDialog(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        JButton button = new JButton("EXIT");
        button.setBounds(130,100,100, 40);
        
        // Menambahkan ActionListener untuk tombol "EXIT"
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int confirmation = JOptionPane.showConfirmDialog(HelloConfirmDialog.this, 
                        "Apakah anda yakin ingin keluar dari aplikasi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                } else
                {
                    JOptionPane.showMessageDialog(HelloConfirmDialog.this, "Anda menekan tombol NO");
                }
            }
        });
        
        this.add(button);
        
        this.setSize(200,200);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                HelloConfirmDialog h = new HelloConfirmDialog();
                h.setVisible(true);
            }
        });
    }
    
}
