/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entiteti;

/**
 *
 * @author Vuk
 */
public class Termin {
    private int terminId;
    private String datumPolaska;
    private String datumPovratka;

    public Termin(int terminId, String datumPolaska, String datumPovratka) {
        this.terminId = terminId;
        this.datumPolaska = datumPolaska;
        this.datumPovratka = datumPovratka;
    }

    public int getTerminId() {
        return terminId;
    }

    public void setTerminId(int terminId) {
        this.terminId = terminId;
    }

    public String getDatumPolaska() {
        return datumPolaska;
    }

    public void setDatumPolaska(String datumPolaska) {
        this.datumPolaska = datumPolaska;
    }

    public String getDatumPovratka() {
        return datumPovratka;
    }

    public void setDatumPovratka(String datumPovratka) {
        this.datumPovratka = datumPovratka;
    }

    @Override
    public String toString() {
        return "Termin{" + "terminId=" + terminId + ", datumPolaska=" + datumPolaska + ", datumPovratka=" + datumPovratka + '}';
    }
    
}
