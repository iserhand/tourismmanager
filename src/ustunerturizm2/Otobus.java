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
public class Otobus {

    private int id;
    private String plaka;
    private int koltukSayisi;
            

    public Otobus(int id,
             String plaka, int koltukSayisi) {
        this.id=id;
        this.plaka = plaka;
        this.koltukSayisi=koltukSayisi;

    }




    /**
     * @return the plaka
     */
    public String getPlaka() {
        return plaka;
    }

    /**
     * @param plaka the plaka to set
     */
    public void setPlaka(String plaka) {
        this.plaka = plaka;
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
     * @return the koltukSayisi
     */
    public int getKoltukSayisi() {
        return koltukSayisi;
    }

    /**
     * @param koltukSayisi the koltukSayisi to set
     */
    public void setKoltukSayisi(int koltukSayisi) {
        this.koltukSayisi = koltukSayisi;
    }

}
