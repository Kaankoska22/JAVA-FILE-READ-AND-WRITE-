package ogrencihediyeleri;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class TOKENLEREAYIRMACLASSI {

    public static void main(String[] args) {
        File dosya = null;
        FileWriter yazici = null;
        Scanner okuyucu = null;

        dosya = new File("./OgrenciListesi.txt");
        try {
            okuyucu = new Scanner(dosya);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        while (okuyucu.hasNextLine()) {
            String ogrenci = okuyucu.nextLine();
            System.out.println(ogrenci);
        }

        FileReader okuyucu2 = null;
        try {
            okuyucu2 = new FileReader("./OgrenciListesi.txt");

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        StreamTokenizer st = new StreamTokenizer(okuyucu2);

        try {
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                switch (st.ttype) {
                    case StreamTokenizer.TT_EOL:
                        System.out.println("Satır Sonu");
                        break;
                    case StreamTokenizer.TT_NUMBER:
                        System.out.println("Sayı = " + st.nval);
                        break;
                    case StreamTokenizer.TT_WORD:
                        System.out.println("Kelime = " + st.sval);
                        break;
                    default:
                        System.out.println("Diğer = " + (char) st.ttype);

                }
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
