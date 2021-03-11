package ogrencihediyeleri;

import java.io.Serializable;

public class OGRENCİCLASSI implements Serializable {
    private String ad;
    private String soyad;
    private String cinsiyet;
    private String durum;
    public String getAd() {
        return ad;
    }
    public void setAd(String ad) {
        this.ad = ad;
    }
    public String getSoyad() {
        return soyad;
    }
    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }
    public String getCinsiyet() {
        return cinsiyet;
    }
    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
    public String getDurum() {
        return durum;
    }
    public void setDurum(String durum) {
        this.durum = durum;
    }



}
