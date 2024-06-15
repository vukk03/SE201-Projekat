/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entiteti;

/**
 *
 * @author Admin
 */
public class Vodic {
    private int vodicId;
    private int turistickaAgencijaId;
    private String ime;
    private String prezime;
    private int starost ;
    private int godineRada ;

    public Vodic(int vodicId, int turistickaAgencijaId, String ime, String prezime, int starost, int godineRada) {
        this.vodicId = vodicId;
        this.turistickaAgencijaId = turistickaAgencijaId;
        this.ime = ime;
        this.prezime = prezime;
        this.starost = starost;
        this.godineRada = godineRada;
    }

    public int getVodicId() {
        return vodicId;
    }

    public void setVodicId(int vodicId) {
        this.vodicId = vodicId;
    }

    public int getTuristickaAgencijaId() {
        return turistickaAgencijaId;
    }

    public void setTuristickaAgencijaId(int turistickaAgencijaId) {
        this.turistickaAgencijaId = turistickaAgencijaId;
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

    public int getStarost() {
        return starost;
    }

    public void setStarost(int starost) {
        this.starost = starost;
    }

    public int getGodineRada() {
        return godineRada;
    }

    public void setGodineRada(int godineRada) {
        this.godineRada = godineRada;
    }

    @Override
    public String toString() {
        return "Vodic{" + "vodicId=" + vodicId + ", turistickaAgencijaId=" + turistickaAgencijaId + ", ime=" + ime + ", prezime=" + prezime + ", starost=" + starost + ", godineRada=" + godineRada + '}';
    }

}
