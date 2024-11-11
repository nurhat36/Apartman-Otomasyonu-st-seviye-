/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apartmanotomasyonu;
import java.sql.*;
/**
 *
 * @author Nurhat
 */
public class SQLHelper {
    private static final String DB_URL = "jdbc:sqlserver://DESKTOP-QQQ1H73;databaseName=APARTMAN;integratedSecurity=True;encrypt=True;trustServerCertificate=True";
   
    private Connection conn;

    public SQLHelper() {
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Bağlantı başarılı!");
        } catch (SQLException e) {
            System.err.println("Bağlantı başarısız: " + e.getMessage());
        }
    }
    

    // Parametreli veri çekme metodu
    public ResultSet executeQuery(String query, Object... params) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            System.err.println("Sorgu hatası: " + e.getMessage());
            return null;
        }
    }

    // Parametreli veri ekleme/güncelleme/silme metodu
    public int executeUpdate(String query, Object... params) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Sorgu hatası: " + e.getMessage());
            return -1;
        }
    }

    // Veritabanı bağlantısını kapatma metodu
    public void close() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Bağlantı kapatıldı.");
            }
        } catch (SQLException e) {
            System.err.println("Bağlantı kapatma hatası: " + e.getMessage());
        }
    }
}
