package ogrencihediyeleri;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SERİLEŞTİRMECLASSI {


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
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        int SAYIOGRENCİ = 1;

        try {

            dosya = new File("./OgrenciListesi.txt");
            okuyucu = new Scanner(dosya);


            int kalemHediyeSayisi = 0;
            int bisikletHediyeSayisi = 0;
            int tabletHediyeSayisi = 0;


            StringBuilder dosyaIcerik = new StringBuilder();


            while (okuyucu.hasNextLine()) {
                String ogrenci = okuyucu.nextLine();


                String[] ogrenciBilgileri = ogrenci.split(" ");


                String cinsiyet = ogrenciBilgileri[0];
                String ad = ogrenciBilgileri[1];
                String soyad = ogrenciBilgileri[2];
                String durum = ogrenciBilgileri[3];

                OGRENCİCLASSI OGRENCİCLASSINesnesi = new OGRENCİCLASSI();
                OGRENCİCLASSINesnesi.setAd(ad);
                OGRENCİCLASSINesnesi.setCinsiyet(cinsiyet);
                OGRENCİCLASSINesnesi.setDurum(durum);
                OGRENCİCLASSINesnesi.setSoyad(soyad);


                fileOut = new FileOutputStream("ogrenci_"+ SAYIOGRENCİ +".ser");
                out = new ObjectOutputStream(fileOut);
                out.writeObject(OGRENCİCLASSINesnesi);

                SAYIOGRENCİ++;

            }

        } catch (FileNotFoundException e) {
            System.out
                    .println("'OgrenciListesi.txt' adında bir dosya bulunmadı.");
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            okuyucu.close();
            try {
                out.close();
                fileOut.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }


        int SAYIKALEM = 0;
        int SAYIBİSİKLET = 0;
        int SAYITABLET = 0;
        try {

            for(int i = 1; i < SAYIOGRENCİ; i++){
                Object obj = null;
                FileInputStream fileIn = new FileInputStream("./ogrenci_"+i+".ser");
                ObjectInputStream inputStream = new ObjectInputStream(fileIn);
                obj = inputStream.readObject();
                if (obj instanceof OGRENCİCLASSI) {
                    OGRENCİCLASSI OGRENCİCLASSI = (OGRENCİCLASSI) obj;
                    if (OGRENCİCLASSI.getDurum().equals(KOTU_DURUM)) {
                        SAYIKALEM++;
                    } else if (OGRENCİCLASSI.getDurum().equals(IYI_DURUM) && OGRENCİCLASSI.getCinsiyet().equals(KIZ)) {

                        SAYIBİSİKLET++;
                    } else if (OGRENCİCLASSI.getDurum().equals(IYI_DURUM) && OGRENCİCLASSI.getCinsiyet().equals(ERKEK)) {

                        SAYITABLET++;
                    }
                }
                inputStream.close();
                fileIn.close();
            }


            System.out.println("kalem : " + SAYIKALEM);
            System.out.println("bisiklet : " + SAYIBİSİKLET);
            System.out.println("tablet bilgisayar : " + SAYITABLET);
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Hata");
            c.printStackTrace();
            return;
        }

    }
}
