/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yow;

/**
 * Kelas HelloInputDialog adalah kelas utama yang menggambarkan sebuah aplikasi sederhana
 * yang meminta input dari pengguna melalui dialog dan menampilkan pesan sambutan berdasarkan input tersebut.
 *
 * @author M Azka Ramadhan 213040121
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloInputDialog extends JFrame {
    public HelloInputDialog() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        JButton button = new JButton("Input");
        button.setBounds(130, 100, 100, 40);

        // Menambahkan ActionListener untuk tombol "Input"
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Meminta pengguna untuk memasukkan nama melalui dialog
                String name = JOptionPane.showInputDialog(HelloInputDialog.this, "Inputkan nama anda");
                // Menampilkan pesan sambutan dengan nama yang dimasukkan oleh pengguna
                JOptionPane.showMessageDialog(HelloInputDialog.this, "Hello, " + name);
            }
        });

        this.add(button);

        this.setSize(200, 200);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Membuat instance dari kelas HelloInputDialog dan menampilkannya
                HelloInputDialog h = new HelloInputDialog();
                h.setVisible(true);
            }
        });
    }
}
