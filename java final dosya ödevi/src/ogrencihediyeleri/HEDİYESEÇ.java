package ogrencihediyeleri;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HEDİYESEÇ {

    private static final String KOTU_DURUM = "Kötü";
    private static final String IYI_DURUM = "İyi";
    private static final String KALEM_HEDIYE = "kalem";
    private static final String BISIKLET_HEDIYE = "bisiklet";
    private static final String TABLET_HEDIYE = "tablet bilgisayar";
    private static final String KIZ = "F";
    private static final String ERKEK = "M";

    public static void main(String[] args) {
        File dosya = null;
        FileWriter yazici = null;
        Scanner okuyucu = null;

        try {

            dosya = new File("./OgrenciListesi.txt");
            okuyucu = new Scanner(dosya);


            int kalemsayisi = 0;
            int bisikletsayisi = 0;
            int tabletsayisi = 0;

            StringBuilder DOSYAİÇERİĞİ = new StringBuilder();


            while (okuyucu.hasNextLine()) {
                String ogrenci = okuyucu.nextLine();


                String[] ogrenciBilgileri = ogrenci.split(" ");


                String cinsiyet = ogrenciBilgileri[0];
                String ad = ogrenciBilgileri[1];
                String soyad = ogrenciBilgileri[2];
                String durum = ogrenciBilgileri[3];

                String verilecekHediye = "";


                if (durum.equals(KOTU_DURUM)) {
                    verilecekHediye = KALEM_HEDIYE;
                    kalemsayisi++;
                } else if (durum.equals(IYI_DURUM) && cinsiyet.equals(KIZ)) {
                    verilecekHediye = BISIKLET_HEDIYE;
                    bisikletsayisi++;
                } else if (durum.equals(IYI_DURUM) && cinsiyet.equals(ERKEK)) {
                    verilecekHediye = TABLET_HEDIYE;
                    tabletsayisi++;
                }

                DOSYAİÇERİĞİ.append(soyad +", " + ad + " " + verilecekHediye);
                DOSYAİÇERİĞİ.append("\n");


            }
            DOSYAİÇERİĞİ.append("\n");
            DOSYAİÇERİĞİ.append("kalem : " + kalemsayisi);
            DOSYAİÇERİĞİ.append("\n");
            DOSYAİÇERİĞİ.append("bisiklet : " + bisikletsayisi);
            DOSYAİÇERİĞİ.append("\n");
            DOSYAİÇERİĞİ.append("tablet bilgisayar : " + tabletsayisi);

            yazici = new FileWriter("OgrenciHediler.txt");
            yazici.write(DOSYAİÇERİĞİ.toString());



        } catch (FileNotFoundException e) {
            System.out.println("'OgrenciListesi.txt' adında bir dosya bulunmadı.");
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally{
            okuyucu.close();
            try {
                yazici.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

