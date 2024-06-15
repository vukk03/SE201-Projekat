/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entiteti;

/**
 *
 * @author Admin
 */
public class PrevoznoSredstvo {

    private int prevozId;
    private String tipSredstva;
    private int brojMesta;
    private int brojSlobodnihMesta;

    public PrevoznoSredstvo(int prevozId, String tipSredstva, int brojMesta, int brojSlobodnihMesta) {
        this.prevozId = prevozId;
        this.tipSredstva = tipSredstva;
        this.brojMesta = brojMesta;
        this.brojSlobodnihMesta = brojSlobodnihMesta;
    }

    public int getPrevozId() {
        return prevozId;
    }

    public void setPrevozId(int prevozId) {
        this.prevozId = prevozId;
    }

    public String getTipSredstva() {
        return tipSredstva;
    }

    public void setTipSredstva(String tipSredstva) {
        this.tipSredstva = tipSredstva;
    }

    public int getBrojMesta() {
        return brojMesta;
    }

    public void setBrojMesta(int brojMesta) {
        this.brojMesta = brojMesta;
    }

    public int getBrojSlobodnihMesta() {
        return brojSlobodnihMesta;
    }

    public void setBrojSlobodnihMesta(int brojSlobodnihMesta) {
        this.brojSlobodnihMesta = brojSlobodnihMesta;
    }

    @Override
    public String toString() {
        return "prevoznoSredstvo{" + "prevozId=" + prevozId + ", tipSredstva=" + tipSredstva + ", brojMesta=" + brojMesta + ", brojSlobodnihMesta=" + brojSlobodnihMesta + '}';
    }

}
