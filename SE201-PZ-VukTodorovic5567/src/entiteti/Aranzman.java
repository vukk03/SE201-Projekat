/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entiteti;

/**
 *
 * @author Vuk
 */
public class Aranzman {
    private int aranzmanId;
    private int turisticka_agencija_Id;
    private String nazivAranzmana;
    private String opis;
    private int cena;
    private int vodicId;
    private String smestaj;
    private String destinacija;
    private boolean zamensko;
    private String polazak;

    public Aranzman(int aranzmanId, int turisticka_agencija_Id, String nazivAranzmana, String opis, int cena, int vodicId, String smestaj, String destinacija, boolean zamensko, String polazak) {
        this.aranzmanId = aranzmanId;
        this.turisticka_agencija_Id = turisticka_agencija_Id;
        this.nazivAranzmana = nazivAranzmana;
        this.opis = opis;
        this.cena = cena;
        this.vodicId = vodicId;
        this.smestaj = smestaj;
        this.destinacija = destinacija;
        this.zamensko = zamensko;
        this.polazak = polazak;
    }

    public int getAranzmanId() {
        return aranzmanId;
    }

    public void setAranzmanId(int aranzmanId) {
        this.aranzmanId = aranzmanId;
    }

    public int getTuristicka_agencija_Id() {
        return turisticka_agencija_Id;
    }

    public void setTuristicka_agencija_Id(int turisticka_agencija_Id) {
        this.turisticka_agencija_Id = turisticka_agencija_Id;
    }

    public String getNazivAranzmana() {
        return nazivAranzmana;
    }

    public void setNazivAranzmana(String nazivAranzmana) {
        this.nazivAranzmana = nazivAranzmana;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public int getVodicId() {
        return vodicId;
    }

    public void setVodicId(int vodicId) {
        this.vodicId = vodicId;
    }

    public String getSmestaj() {
        return smestaj;
    }

    public void setSmestaj(String smestaj) {
        this.smestaj = smestaj;
    }

    public String getDestinacija() {
        return destinacija;
    }

    public void setDestinacija(String destinacija) {
        this.destinacija = destinacija;
    }

    public boolean isZamensko() {
        return zamensko;
    }

    public void setZamensko(boolean zamensko) {
        this.zamensko = zamensko;
    }

    public String getPolazak() {
        return polazak;
    }

    public void setPolazak(String polazak) {
        this.polazak = polazak;
    }

    @Override
    public String toString() {
        return "Aranzman{" + "aranzmanId=" + aranzmanId + ", turisticka_agencija_Id=" + turisticka_agencija_Id + ", nazivAranzmana=" + nazivAranzmana + ", opis=" + opis + ", cena=" + cena + ", vodicId=" + vodicId + ", smestaj=" + smestaj + ", destinacija=" + destinacija + ", zamensko=" + zamensko + ", polazak=" + polazak + '}';
    }
    
}
