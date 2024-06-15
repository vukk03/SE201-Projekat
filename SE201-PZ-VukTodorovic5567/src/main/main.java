/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.util.*;
import entiteti.*;
import java.sql.SQLException;
import util.*;

/**
 *
 * @author Vuk
 */
public class main {

    /**
     * @param args the command line arguments
      @throws java.sql.SQLException
     */
    public static void main(String[] args) throws  SQLException {
        DatabaseConnector.getConnection();

        boolean exit = false;
        while (!exit) {

            System.out.println("Izaberite opciju:");
            System.out.println("1. Dodavanje novog vodica: ");
            System.out.println("2. Dodavanje novog prevoza: ");
            System.out.println("3. Prikaz vodica: ");
            System.out.println("4. Prikaz prevoza:  ");
            System.out.println("5. Brisanje vodica:  ");
            System.out.println("6. Brisanje prevoza: ");
            System.out.println("7. Sortiranje");
            System.out.println("8. Brute Force napad");
            System.out.println("9. Izlaz iz programa");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Unesi idVodic:");
                    int idVodic = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Unesi turistickaAgencijaId:");
                    int turistickaAgencijaId = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Unesi imeVodica:");
                    String imeVodica = scanner.nextLine();
                    
                    System.out.println("Unesi prezimeVodica:");
                    String prezimeVodica = scanner.nextLine();
                    
                    System.out.println("Unesi starost:");
                    int starost = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Unesi godineRada:");
                    int godineRada = scanner.nextInt();
                    scanner.nextLine();
                    
                    Vodic vodic = new Vodic(idVodic, turistickaAgencijaId, imeVodica, prezimeVodica, starost, godineRada);

                    VodicCRUD.dodajVodica(vodic);

                    break;

                case 2:
                    System.out.println("Unesi ID prevoza:");
                    int prevozId = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Unesi tip sredstva (Avion ili Autobus) :");
                    String tipSredstva = scanner.nextLine();

                    System.out.println("Unesi broj mesta:");
                    int mestaUk = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.println("Unesi broj slobodnih mesta:");
                    int slobodnaUk = scanner.nextInt();
                    scanner.nextLine();

                    PrevoznoSredstvo prevoznoSredstvo = new PrevoznoSredstvo(prevozId, tipSredstva, mestaUk, slobodnaUk);

                    PrevoznoSredstvoCRUD.dodajPrevoz(prevoznoSredstvo);

                    break;
                case 3:
                    VodicCRUD.ispisVodica();
                    break;
                case 4:
                    PrevoznoSredstvoCRUD.ispisPrevoza();
                    break;
                case 5:

                    System.out.println("Unesite redni broj vodica kog hocete da obrisete:");
                    int idVodicaBris = scanner.nextInt();
                    scanner.nextLine();

                    VodicCRUD.obrisiVodica(idVodicaBris);

                    break;
                case 6:
                    System.out.println("Unesite ID prevoza koji hocete da obrisete:");
                    int idPrevozBris = scanner.nextInt();
                    scanner.nextLine();

                    PrevoznoSredstvoCRUD.ObrisiPrevoz(idPrevozBris);

                    break;
                case 7:
                    System.out.println("Unesite tabelu koju sortirate");
                    String tabela = scanner.nextLine();
                  
                    System.out.println("Unesite kolonu po kojoj sortirate");
                    String kolona = scanner.nextLine();

                    System.out.println("Unesite nacin na koji sortirate (ASC ili DESC)");
                    String nacin = scanner.nextLine();
                    
                    System.out.println("Sortirana tabela je: ");
                    SortiranjeBaze.sortTable(tabela, kolona, nacin);

                    break;
                case 8:
                    String targetPassword = "root";
                    String characterSet = "abcdefghijklmnopqrstuvwxyz0123456789";
                    int maxLength = 4;
                    BruteForce.bruteForceAttack(targetPassword, characterSet, maxLength);
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Nevažeći izbor. Molimo unesite ponovo.");
            }
        }
    }
}
