/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entiteti;

/**
 *
 * @author Vuk
 */
public class TuristickaAgencija {
    private int turistickaAgencijaId;
    private double JMBG;
    private String naziv;
    private char sifra;
    private char adresa;

    public TuristickaAgencija(int turistickaAgencijaId, double JMBG, String naziv, char sifra, char adresa) {
        this.turistickaAgencijaId = turistickaAgencijaId;
        this.JMBG = JMBG;
        this.naziv = naziv;
        this.sifra = sifra;
        this.adresa = adresa;
    }

    public int getTuristickaAgencijaId() {
        return turistickaAgencijaId;
    }

    public void setTuristickaAgencijaId(int turistickaAgencijaId) {
        this.turistickaAgencijaId = turistickaAgencijaId;
    }

    public double getJMBG() {
        return JMBG;
    }

    public void setJMBG(double JMBG) {
        this.JMBG = JMBG;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public char getSifra() {
        return sifra;
    }

    public void setSifra(char sifra) {
        this.sifra = sifra;
    }

    public char getAdresa() {
        return adresa;
    }

    public void setAdresa(char adresa) {
        this.adresa = adresa;
    }

    @Override
    public String toString() {
        return "TuristickaAgencija{" + "turistickaAgencijaId=" + turistickaAgencijaId + ", JMBG=" + JMBG + ", naziv=" + naziv + ", sifra=" + sifra + ", adresa=" + adresa + '}';
    }
    
}
