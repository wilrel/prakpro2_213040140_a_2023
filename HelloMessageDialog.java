/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yow;

/**
 * Kelas HelloMessageDialog adalah kelas utama yang menggambarkan sebuah aplikasi sederhana
 * yang menampilkan pesan sambutan melalui dialog saat tombol "Klik" ditekan.
 *
 * @author M Azka Ramadhan 213040121
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloMessageDialog extends JFrame {
    
    public HelloMessageDialog(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        
        JButton button = new JButton("Klik");
        button.setBounds(130,100,100, 40);
        
        // Menambahkan ActionListener untuk tombol "Klik"
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                // Menampilkan pesan sambutan melalui dialog
                JOptionPane.showMessageDialog(HelloMessageDialog.this, "Halo, Selamat Datang di Praktikum Pemrograman II.");
            }
        });
        
        this.add(button);
        
        this.setSize(200,200);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
           public void run() {
               // Membuat instance dari kelas HelloMessageDialog dan menampilkannya
               HelloMessageDialog h = new HelloMessageDialog();
               h.setVisible(true);
           }     
        });
    }
}
