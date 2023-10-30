/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yow;

/**
 *
 * @author wildan 
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author User
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Tugas7 {
    private JFrame frame; // Mendefinisikan frame utama
    private JTextField nameField; // Bidang input untuk nama
    private JComboBox<String> genderComboBox; // ComboBox untuk jenis kelamin
    private JTextField phoneNumberField; // Bidang input untuk nomor telepon
    private JTextArea addressArea; // Area teks untuk alamat
    private JTable table; // Tabel untuk menampilkan data biodata
    private DefaultTableModel tableModel; // Model tabel untuk biodata

    public Tugas7() {
        frame = new JFrame("Biodata App"); // Membuat frame dengan judul "Biodata App"
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Menetapkan aksi tutup jendela

        frame.addWindowListener(new WindowAdapter() { // Menambahkan window listener untuk menangani penutupan jendela
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION); // Konfirmasi sebelum keluar
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0); // Keluar dari aplikasi
                }
            }
        });

        nameField = new JTextField(20); // Bidang input untuk nama dengan panjang 20 karakter
        genderComboBox = new JComboBox<>(new String[]{"Pria", "Wanita"}); // ComboBox untuk jenis kelamin
        phoneNumberField = new JTextField(20); // Bidang input untuk nomor telepon dengan panjang 20 karakter
        addressArea = new JTextArea(5, 20); // Area teks untuk alamat dengan ukuran 5 baris dan 20 kolom

        tableModel = new DefaultTableModel(); // Mendefinisikan model tabel
        tableModel.addColumn("Nama"); // Menambahkan kolom "Nama" ke tabel
        tableModel.addColumn("Jenis Kelamin"); // Menambahkan kolom "Jenis Kelamin" ke tabel
        tableModel.addColumn("Nomor HP"); // Menambahkan kolom "Nomor HP" ke tabel
        tableModel.addColumn("Alamat"); // Menambahkan kolom "Alamat" ke tabel

        table = new JTable(tableModel); // Membuat tabel dengan model tabel yang telah dibuat sebelumnya
        JScrollPane scrollPane = new JScrollPane(table); // Menambahkan tabel ke panel dengan kemampuan scrolling

        JButton saveButton = new JButton("Simpan"); // Tombol untuk menyimpan data biodata
        JButton editButton = new JButton("Edit"); // Tombol untuk mengedit data biodata
        JButton deleteButton = new JButton("Hapus"); // Tombol untuk menghapus data biodata

        saveButton.addActionListener(new ActionListener() { // Menambahkan ActionListener untuk tombol Simpan
            @Override
            public void actionPerformed(ActionEvent e) {
                saveBiodata(); // Memanggil method untuk menyimpan biodata
            }
        });

        editButton.addActionListener(new ActionListener() { // Menambahkan ActionListener untuk tombol Edit
            @Override
            public void actionPerformed(ActionEvent e) {
                editBiodata(); // Memanggil method untuk mengedit biodata
            }
        });

        deleteButton.addActionListener(new ActionListener() { // Menambahkan ActionListener untuk tombol Hapus
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBiodata(); // Memanggil method untuk menghapus biodata
            }
        });

        // Panel untuk input biodata
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); // Mengatur tata letak komponen dalam panel

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        inputPanel.add(new JLabel("Nama:"), gbc); // Menambahkan label "Nama"
        gbc.gridx = 1;
        inputPanel.add(nameField, gbc); // Menambahkan bidang input nama

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Jenis Kelamin:"), gbc); // Menambahkan label "Jenis Kelamin"
        gbc.gridx = 1;
        inputPanel.add(genderComboBox, gbc); // Menambahkan ComboBox jenis kelamin

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Nomor HP:"), gbc); // Menambahkan label "Nomor HP"
        gbc.gridx = 1;
        inputPanel.add(phoneNumberField, gbc); // Menambahkan bidang input nomor telepon

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("Alamat:"), gbc); // Menambahkan label "Alamat"
        gbc.gridx = 1;
        inputPanel.add(new JScrollPane(addressArea), gbc); // Menambahkan area teks alamat

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        inputPanel.add(saveButton, gbc); // Menambahkan tombol Simpan

        // Panel untuk tabel biodata
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER); // Menambahkan tabel ke panel

        // Panel untuk tombol aksi
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton); // Menambahkan tombol Simpan
        buttonPanel.add(editButton); // Menambahkan tombol Edit
        buttonPanel.add(deleteButton); // Menambahkan tombol Hapus

        // Menetapkan tata letak pada frame
        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH); // Menambahkan panel input ke bagian atas frame
        frame.add(tablePanel, BorderLayout.CENTER); // Menambahkan panel tabel ke bagian tengah frame
        frame.add(buttonPanel, BorderLayout.SOUTH); // Menambahkan panel tombol aksi ke bagian bawah frame

        frame.pack(); // Mengatur ukuran frame sesuai dengan komponen di dalamnya
        frame.setVisible(true); // Menampilkan frame
    }

    // Method untuk menyimpan biodata
    private void saveBiodata() {
        String name = nameField.getText(); // Mendapatkan nama dari bidang input
        String gender = (String) genderComboBox.getSelectedItem(); // Mendapatkan jenis kelamin dari ComboBox
        String phoneNumber = phoneNumberField.getText(); // Mendapatkan nomor telepon dari bidang input
        String address = addressArea.getText(); // Mendapatkan alamat dari area teks

        if (name.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) { // Memeriksa jika ada input yang kosong
            JOptionPane.showMessageDialog(frame, "Semua input harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE); // Menampilkan pesan peringatan
            return;
        }

        tableModel.addRow(new String[]{name, gender, phoneNumber, address}); // Menambahkan data biodata ke tabel
        nameField.setText(""); // Mengosongkan bidang input nama
        genderComboBox.setSelectedIndex(0); // Mengatur ComboBox jenis kelamin ke indeks pertama
        phoneNumberField.setText(""); // Mengosongkan bidang input nomor telepon
        addressArea.setText(""); // Mengosongkan area teks alamat
    }

    // Method untuk mengedit biodata
    private void editBiodata() {
        int selectedRow = table.getSelectedRow(); // Mendapatkan baris yang dipilih dari tabel
        if (selectedRow != -1) { // Memeriksa jika baris dipilih
            String name = nameField.getText(); // Mendapatkan nama dari bidang input
            String gender = (String) genderComboBox.getSelectedItem(); // Mendapatkan jenis kelamin dari ComboBox
            String phoneNumber = phoneNumberField.getText(); // Mendapatkan nomor telepon dari bidang input
            String address = addressArea.getText(); // Mendapatkan alamat dari area teks

            if (name.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) { // Memeriksa jika ada input yang kosong
                JOptionPane.showMessageDialog(frame, "Semua input harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE); // Menampilkan pesan peringatan
                return;
            }

            // Memperbarui data pada baris yang dipilih
            tableModel.setValueAt(name, selectedRow, 0);
            tableModel.setValueAt(gender, selectedRow, 1);
            tableModel.setValueAt(phoneNumber, selectedRow, 2);
            tableModel.setValueAt(address, selectedRow, 3);

            nameField.setText(""); // Mengosongkan bidang input nama
            genderComboBox.setSelectedIndex(0); // Mengatur ComboBox jenis kelamin ke indeks pertama
            phoneNumberField.setText(""); // Mengosongkan bidang input nomor telepon
            addressArea.setText(""); // Mengosongkan area teks alamat
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih baris untuk diedit", "Peringatan", JOptionPane.WARNING_MESSAGE); // Menampilkan pesan peringatan jika tidak ada baris yang dipilih
        }
    }

    // Method untuk menghapus biodata
    private void deleteBiodata() {
        int selectedRow = table.getSelectedRow(); // Mendapatkan baris yang dipilih dari tabel
        if (selectedRow != -1) { // Memeriksa jika baris dipilih
            tableModel.removeRow(selectedRow); // Menghapus baris dari tabel
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih baris untuk dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE); // Menampilkan pesan peringatan jika tidak ada baris yang dipilih
        }
    }

    // Main method untuk menjalankan aplikasi
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Tugas7(); // Membuat instance dari BiodataApp
            }
        });
    }
}
