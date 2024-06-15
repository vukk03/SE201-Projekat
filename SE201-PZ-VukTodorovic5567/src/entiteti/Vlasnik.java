/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entiteti;

import exceptions.JmbgEx;

/**
 *
 * @author Vuk
 */
public class Vlasnik {
    private String JMBG;
    private String ime;
    private String prezime;
    private String adresa;
    private int brojAgencija;

    public Vlasnik(String JMBG, String ime, String prezime, String adresa, int brojAgencija) {
        this.JMBG = JMBG;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.brojAgencija = brojAgencija;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJmbg(String jmbg) throws JmbgEx {
        if (jmbg.length() == 13) {
            this.JMBG = JMBG;
        }else{
            throw new JmbgEx("JMBG treba da ima tacno 13 cifara!");
        }
    }
    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int getBrojAgencija() {
        return brojAgencija;
    }

    public void setBrojAgencija(int brojAgencija) {
        this.brojAgencija = brojAgencija;
    }

    @Override
    public String toString() {
        return "Vlasnik{" + "JMBG=" + JMBG + ", ime=" + ime + ", prezime=" + prezime + ", adresa=" + adresa + ", brojAgencija=" + brojAgencija + '}';
    }
    
}
