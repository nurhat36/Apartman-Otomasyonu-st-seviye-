package com.mycompany.apartmanotomasyonu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApartmanOtomasyonu extends JFrame{
   
    private JPanel formPanel;
    
     public ApartmanOtomasyonu() {
        // Ana pencere ayarları
        setTitle("Apartman Otomasyonu ");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Kayıt Ol butonu
        JButton kayitOlButton = new JButton("Kayıt Ol");
        kayitOlButton.setBounds(270, 20, 100, 20);
        add(kayitOlButton);

        // Yönetici ve Kullanıcı butonları yan yana olacak şekilde düzenleme
        JButton yoneticiButton = new JButton("Yönetici Girişi");
        yoneticiButton.setBounds(50, 50, 125, 25);
        add(yoneticiButton);

        JButton kullaniciButton = new JButton("Kullanıcı Girişi");
        kullaniciButton.setBounds(200, 50, 125, 25);
        add(kullaniciButton);

        // Panel ekle
        formPanel = new JPanel();
        formPanel.setBounds(50, 100, 300, 150);
        formPanel.setLayout(new GridBagLayout()); // GridBagLayout kullanarak daha esnek bir düzen elde ettik
        add(formPanel);

        // Yönetici butonuna basıldığında yapılacak işlemler
        yoneticiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yoneticiGirisFormu();
            }
        });

        // Kullanıcı butonuna basıldığında yapılacak işlemler
        kullaniciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kullaniciGirisFormu();
            }
        });
    }
 private void yoneticiGirisFormu() {
        formPanel.removeAll(); // Önceki form alanlarını temizle

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Boşluklar
        gbc.anchor = GridBagConstraints.WEST; // Sola hizala

        // Bina ID etiketi ve text field
        JLabel binaIdLabel = new JLabel("Bina ID:");
        JTextField binaIdField = new JTextField(15); // 15 karakterlik genişlikte

        // Şifre etiketi ve password field
        JLabel sifreLabel = new JLabel("Şifre:");
        JPasswordField sifreField = new JPasswordField(15);

        // Giriş butonu
        JButton girisButton = new JButton("Giriş Yap");

        // GridBag düzenine ekleme
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(binaIdLabel, gbc);
        
        gbc.gridx = 1;
        formPanel.add(binaIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(sifreLabel, gbc);
        
        gbc.gridx = 1;
        formPanel.add(sifreField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        formPanel.add(girisButton, gbc);

        formPanel.revalidate(); // Paneli güncelle
        formPanel.repaint(); // Paneli yeniden çiz
    }
  private void kullaniciGirisFormu() {
        formPanel.removeAll(); // Önceki form alanlarını temizle

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Boşluklar
        gbc.anchor = GridBagConstraints.WEST; // Sola hizala

        // Bina ID etiketi ve text field
        JLabel binaIdLabel = new JLabel("Bina ID :");
        JTextField binaIdField = new JTextField(15); // 15 karakterlik genişlikte

        // Daire No etiketi ve text field
        JLabel daireNoLabel = new JLabel("Daire No :");
        JTextField daireNoField = new JTextField(15);

        // Şifre etiketi ve password field
        JLabel sifreLabel = new JLabel("Şifre :");
        JPasswordField sifreField = new JPasswordField(15);

        // Giriş butonu
        JButton girisButton = new JButton("Giriş Yap");

        // GridBag düzenine ekleme
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(binaIdLabel, gbc);
        
        gbc.gridx = 1;
        formPanel.add(binaIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(daireNoLabel, gbc);
        
        gbc.gridx = 1;
        formPanel.add(daireNoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(sifreLabel, gbc);
        
        gbc.gridx = 1;
        formPanel.add(sifreField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        formPanel.add(girisButton, gbc);

        formPanel.revalidate(); // Paneli güncelle
        formPanel.repaint(); // Paneli yeniden çiz
    }

    public static void main(String[] args) {
       
        
        // Bağlantı bilgileri
        String url = "jdbc:sqlserver://DESKTOP-BT77ME7;databaseName=APARTMAN;integratedSecurity=True;encrypt=True;trustServerCertificate=True";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // JDBC Sürücüsünü yükle
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Bağlantıyı başlat
            connection = DriverManager.getConnection(url);
            System.out.println("Bağlantı başarılı!");
            

            // Sorguyu çalıştır
            
        } catch (ClassNotFoundException e) {
            // Sürücü yükleme hatası
            System.err.println("SQL Server JDBC sürücüsü bulunamadı.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Bağlantı hatası
            e.printStackTrace();
        } finally {
            // Kaynakları kapat
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
           // Formu başlat
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Burada açmak istediğiniz formun ismini kullanın
                new ApartmanOtomasyonu().setVisible(true); 
            }
        });

    }
}
