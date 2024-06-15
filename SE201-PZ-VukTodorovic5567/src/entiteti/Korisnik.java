/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entiteti;

/**
 *
 * @author Vuk
 */
public class Korisnik {
    private int korisnikId;
    private int terminId;
    private int prevozId;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private boolean rezervisao;
    private String mesto;

    public Korisnik(int korisnikId, int terminId, int prevozId, String ime, String prezime, String korisnickoIme, boolean rezervisao, String mesto) {
        this.korisnikId = korisnikId;
        this.terminId = terminId;
        this.prevozId = prevozId;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.rezervisao = rezervisao;
        this.mesto = mesto;
    }

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    public int getTerminId() {
        return terminId;
    }

    public void setTerminId(int terminId) {
        this.terminId = terminId;
    }

    public int getPrevozId() {
        return prevozId;
    }

    public void setPrevozId(int prevozId) {
        this.prevozId = prevozId;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public boolean isRezervisao() {
        return rezervisao;
    }

    public void setRezervisao(boolean rezervisao) {
        this.rezervisao = rezervisao;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "korisnikId=" + korisnikId + ", terminId=" + terminId + ", prevozId=" + prevozId + ", ime=" + ime + ", prezime=" + prezime + ", korisnickoIme=" + korisnickoIme + ", rezervisao=" + rezervisao + ", mesto=" + mesto + '}';
    }
    
}
