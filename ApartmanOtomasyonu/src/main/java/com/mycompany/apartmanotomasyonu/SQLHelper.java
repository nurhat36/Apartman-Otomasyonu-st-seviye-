/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.apartmanotomasyonu;
import java.io.FileInputStream;
import java.sql.*;
/**
 *
 * @author Nurhat
 */
public class SQLHelper {
    private static final String DB_URL = "jdbc:sqlserver://LAPTOP-0Q2FGCL9;databaseName=APARTMAN;integratedSecurity=True;encrypt=True;trustServerCertificate=True";
   
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
     public int executeUpdateresim(String sql, String binaNo, String tarih, String giderTur, Object miktar, FileInputStream fis, int fileLength) {
        int result = 0;

        try  {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, binaNo);
            pstmt.setString(2, tarih);
            pstmt.setString(3, giderTur);
            pstmt.setObject(4, miktar);

            // Dekont olarak resmi InputStream ile ekliyoruz
            if (fis != null) {
                pstmt.setBinaryStream(5, fis, fileLength);
            } else {
                pstmt.setNull(5, java.sql.Types.VARBINARY);
            }

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
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
