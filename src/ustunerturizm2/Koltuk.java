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
public class Koltuk {
    private int id;
    private int otobusid;
    private int yolcuid;
    private int koltuknumara;
    private int turid;

    /**
     *
     * @param id
     * @param otobusid
     * @param yolcuid
     * @param koltuknumara
     * @param turid
     */
    public Koltuk(int id,int otobusid,int yolcuid,int koltuknumara,int turid){
        this.id = id;
        this.koltuknumara = koltuknumara;
        this.turid = turid;
        this.otobusid = otobusid;
        this.yolcuid = yolcuid;
        
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
     * @return the otobusid
     */
    public int getOtobusid() {
        return otobusid;
    }

    /**
     * @param otobusid the otobusid to set
     */
    public void setOtobusid(int otobusid) {
        this.otobusid = otobusid;
    }

    /**
     * @return the yolcuid
     */
    public int getYolcuid() {
        return yolcuid;
    }

    /**
     * @param yolcuid the yolcuid to set
     */
    public void setYolcuid(int yolcuid) {
        this.yolcuid = yolcuid;
    }

    /**
     * @return the koltuknumara
     */
    public int getKoltuknumara() {
        return koltuknumara;
    }

    /**
     * @param koltuknumara the koltuknumara to set
     */
    public void setKoltuknumara(int koltuknumara) {
        this.koltuknumara = koltuknumara;
    }

    /**
     * @return the turid
     */
    public int getTurid() {
        return turid;
    }

    /**
     * @param turid the turid to set
     */
    public void setTurid(int turid) {
        this.turid = turid;
    }
}
