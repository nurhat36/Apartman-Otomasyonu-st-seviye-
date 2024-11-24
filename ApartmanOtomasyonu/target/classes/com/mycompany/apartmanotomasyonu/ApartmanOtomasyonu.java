package com.mycompany.apartmanotomasyonu;


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
