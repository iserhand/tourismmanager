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
public class Tur {

    private int id;
    private String turadi;
    private String hareket_tarihi;
    private String donus_tarihi;
    private String hareket_saati;
    private String hareket_yeri;
    private String tur_danismani;
    private int tur_otobusu_id;

    /**
     *
     * @param id
     * @param turadi
     * @param hareket_tarihi
     * @param donus_tarihi
     * @param hareket_saati
     * @param hareket_yeri
     * @param tur_danismani
     * @param tur_otobusu_id
     */
    public Tur(int id,
            String turadi,
            String hareket_tarihi,
            String donus_tarihi,
            String hareket_saati,
            String hareket_yeri,
            String tur_danismani,
            int tur_otobusu_id) {
        this.id = id;
        this.turadi = turadi;
        this.hareket_tarihi = hareket_tarihi;
        this.donus_tarihi = donus_tarihi;
        this.hareket_saati = hareket_saati;
        this.hareket_yeri = hareket_yeri;
        this.tur_danismani = tur_danismani;
        this.tur_otobusu_id = tur_otobusu_id;

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
     * @return the turadi
     */
    public String getTuradi() {
        return turadi;
    }

    /**
     * @param turadi the turadi to set
     */
    public void setTuradi(String turadi) {
        this.turadi = turadi;
    }

    /**
     * @return the hareket_tarihi
     */
    public String getHareket_tarihi() {
        return hareket_tarihi;
    }

    /**
     * @param hareket_tarihi the hareket_tarihi to set
     */
    public void setHareket_tarihi(String hareket_tarihi) {
        this.hareket_tarihi = hareket_tarihi;
    }

    /**
     * @return the donus_tarihi
     */
    public String getDonus_tarihi() {
        return donus_tarihi;
    }

    /**
     * @param donus_tarihi the donus_tarihi to set
     */
    public void setDonus_tarihi(String donus_tarihi) {
        this.donus_tarihi = donus_tarihi;
    }

    /**
     * @return the hareket_saati
     */
    public String getHareket_saati() {
        return hareket_saati;
    }

    /**
     * @param hareket_saati the hareket_saati to set
     */
    public void setHareket_saati(String hareket_saati) {
        this.hareket_saati = hareket_saati;
    }

    /**
     * @return the hareket_yeri
     */
    public String getHareket_yeri() {
        return hareket_yeri;
    }

    /**
     * @param hareket_yeri the hareket_yeri to set
     */
    public void setHareket_yeri(String hareket_yeri) {
        this.hareket_yeri = hareket_yeri;
    }

    /**
     * @return the tur_danismani
     */
    public String getTur_danismani() {
        return tur_danismani;
    }

    /**
     * @param tur_danismani the tur_danismani to set
     */
    public void setTur_danismani(String tur_danismani) {
        this.tur_danismani = tur_danismani;
    }

    /**
     * @return the tur_otobusu_id
     */
    public int getTur_otobusu_id() {
        return tur_otobusu_id;
    }

    /**
     * @param tur_otobusu_id the tur_otobusu_id to set
     */
    public void setTur_otobusu_id(int tur_otobusu_id) {
        this.tur_otobusu_id = tur_otobusu_id;
    }

}
