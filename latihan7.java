/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yow;

/**
 *
 * @author M Azka Ramadhan 213040121
 */
import java.awt.event.*; // Mengimpor pustaka event AWT dan Swing, seperti ActionListener dan ItemListener.
import javax.swing.*; // Mengimpor pustaka Swing, yang digunakan untuk membuat GUI.
import javax.swing.table.*; // Mengimpor kelas-kelas yang terkait dengan tabel dalam Swing.
import java.util.*; // Mengimpor pustaka utilitas umum, termasuk ArrayList untuk penyimpanan data.




public class latihan7 extends JFrame {

	private boolean checkBoxSelected; // Variabel untuk menyimpan status checkbox

    public latihan7() {
        this.checkBoxSelected = false; // Inisialisasi CheckBoxSelected menggunakan false
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Label untuk "Form Biodata"
        JLabel labelForm = new JLabel("Form Biodata"); // Menampilkan teks "Form Biodata"
        labelForm.setBounds(150, 80, 100, 20); // Mengatur posisi dan ukuran label
        this.add(labelForm);

        // Label dan input untuk "Nama"
        JLabel labelInput = new JLabel("Nama : ");
        labelInput.setBounds(15, 120, 100, 20);
        
        // Input field untuk nama
        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 140, 100, 20);

        // Label dan input untuk "Nomor HP"
        JLabel labelTelepon = new JLabel("Nomor HP : ");
        labelTelepon.setBounds(15, 160, 100, 20);
        
        // Input field untuk nomor HP
        JTextField textFieldTelepon = new JTextField();
        textFieldTelepon.setBounds(15, 180, 100, 20);

        // Label dan pilihan jenis kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin : ");
        labelRadio.setBounds(130, 120, 100, 20);
        
        // RadioButton untuk Laki-Laki
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(130, 140, 100, 20);
        
        // RadioButton untuk Perempuan
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(130, 160, 100, 20);

        // Checkbox "Warga Negara Asing"
        JCheckBox checkBox = new JCheckBox("WNA");
        checkBox.setBounds(130, 180, 200, 20);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        
        // Tombol "Simpan"
        JButton button = new JButton("Simpan");
        button.setBounds(15, 205, 100, 40);
        
        // Tabel untuk menampilkan data
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 250, 350, 200);
        
        MyTableModel7 tableModel7 = new MyTableModel7();
        table.setModel(tableModel7);
        
        // Mendeteksi perubahan pada checkbox
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });
        
        // Mengatur aksi yang dilakukan saat tombol "Simpan" ditekan
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Jeniskelamin = "";
                if (radioButton1.isSelected()) {
                    Jeniskelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    Jeniskelamin = radioButton2.getText();
                }

                // Mendapatkan data dari inputan pengguna
                String nama = textFieldNama.getText();
                String nomorHp = textFieldTelepon.getText();
                String WNA = checkBoxSelected ? "Ya" : "Bukan";
                
                // Menggunakan ArrayList untuk menyimpan data
                ArrayList<String> rowData = new ArrayList<>();
                rowData.add(nama);
                rowData.add(Jeniskelamin);
                rowData.add(nomorHp);
                rowData.add(WNA);
                
                // Menambahkan data ke model tabel
                tableModel7.add(rowData);
                
                // Membersihkan input setelah data disimpan
                textFieldNama.setText("");
                textFieldTelepon.setText("");
            }
        });

        // Menambahkan semua komponen ke frame
        this.add(labelInput);
        this.add(textFieldNama);
        this.add(labelTelepon);
        this.add(textFieldTelepon);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(checkBox);
        this.add(button);
        this.add(scrollableTable);    
        this.setSize(400, 500); // Mengatur ukuran frame
        this.setLayout(null);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                latihan7 h = new latihan7(); // Membuat objek dari kelas Latihan7
                h.setVisible(true); // Menampilkan frame
            }
        });
    }
}