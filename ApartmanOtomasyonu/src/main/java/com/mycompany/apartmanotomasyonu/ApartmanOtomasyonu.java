package com.mycompany.apartmanotomasyonu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApartmanOtomasyonu {

    public static void main(String[] args) {
       
        
        // Bağlantı bilgileri
        String url = "jdbc:sqlserver://DESKTOP-T11FMIO;databaseName=APARTMAN;integratedSecurity=True;encrypt=True;trustServerCertificate=True";
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
                new girisekranı().setVisible(true); 
            }
        });

    }
}
