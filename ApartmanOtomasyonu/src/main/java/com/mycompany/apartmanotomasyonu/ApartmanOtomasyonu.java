package com.mycompany.apartmanotomasyonu;//wrgerge

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApartmanOtomasyonu {


    public static void main(String[] args) {
           // Formu başlat
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Burada açmak istediğiniz formun ismini kullanın
                new girisekranı().setVisible(true); 
                
                
                // çok iyi işler çıkarıyonuz böyle devam...
            }
        });

    }
}
