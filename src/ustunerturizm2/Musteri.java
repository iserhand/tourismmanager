/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ustunerturizm2;

/**
 *
 * @author iserh
 */
public class Musteri {

    private int id;
    private String isim;
    private String soyisim;
    private String tckimlikno;
    private String heskodu;
    private String telefonnumarasi;
    private String gecmisturlar;
    private String istenenturlar;
    private String yorum;

    /**
     *
     * @param id
     * @param isim
     * @param soyisim
     * @param tckimlikno
     * @param heskodu
     * @param telefonnumarasi
     * @param gecmisturlar
     * @param istenenturlar
     * @param yorum
     */
    public Musteri(int id, String isim, String soyisim, String tckimlikno,
            String heskodu, String telefonnumarasi, String gecmisturlar,
            String istenenturlar, String yorum) {
        this.id = id;
        this.isim = isim;
        this.soyisim = soyisim;
        this.tckimlikno = tckimlikno;
        this.heskodu = heskodu;
        this.telefonnumarasi = telefonnumarasi;
        this.gecmisturlar = gecmisturlar;
        this.istenenturlar = istenenturlar;
        this.yorum = yorum;
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the isim
     */
    public String getIsim() {
        return isim;
    }

    /**
     * @param isim the isim to set
     */
    public void setIsim(String isim) {
        this.isim = isim;
    }

    /**
     * @return the soyisim
     */
    public String getSoyisim() {
        return soyisim;
    }

    /**
     * @param soyisim the soyisim to set
     */
    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    /**
     * @return the tckimlikno
     */
    public String getTckimlikno() {
        return tckimlikno;
    }

    /**
     * @param tckimlikno the tckimlikno to set
     */
    public void setTckimlikno(String tckimlikno) {
        this.tckimlikno = tckimlikno;
    }

    /**
     * @return the heskodu
     */
    public String getHeskodu() {
        return heskodu;
    }

    /**
     * @param heskodu the heskodu to set
     */
    public void setHeskodu(String heskodu) {
        this.heskodu = heskodu;
    }

    /**
     * @return the telefonnumarasi
     */
    public String getTelefonnumarasi() {
        return telefonnumarasi;
    }

    /**
     * @param telefonnumarasi the telefonnumarasi to set
     */
    public void setTelefonnumarasi(String telefonnumarasi) {
        this.telefonnumarasi = telefonnumarasi;
    }

    /**
     * @return the gecmisturlar
     */
    public String getGecmisturlar() {
        return gecmisturlar;
    }

    /**
     * @param gecmisturlar the gecmisturlar to set
     */
    public void setGecmisturlar(String gecmisturlar) {
        this.gecmisturlar = gecmisturlar;
    }

    /**
     * @return the istenenturlar
     */
    public String getIstenenturlar() {
        return istenenturlar;
    }

    /**
     * @param istenenturlar the istenenturlar to set
     */
    public void setIstenenturlar(String istenenturlar) {
        this.istenenturlar = istenenturlar;
    }

    /**
     * @return the yorum
     */
    public String getYorum() {
        return yorum;
    }

    /**
     * @param yorum the yorum to set
     */
    public void setYorum(String yorum) {
        this.yorum = yorum;
    }
}
