package main;

import java.util.Scanner;

import klasy.Gracz;
import klasy.Plansza;
import klasy.Scoreboard;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Plansza plansza = new Plansza(wymiarx, wymiary,iloscSymboli2);

        System.out.println("Witaj w grze Kółko i Krzyżyk!");
        Gracz gracz1 = Gracz.create();
        Gracz gracz2 = Gracz.create();
        Plansza plansza = Plansza.create();
        gracz1.setDlugosc_listy_planszy(plansza.getIloczyWymiarow());
        gracz2.setDlugosc_listy_planszy(plansza.getIloczyWymiarow());
        plansza.pokazSciage();
        Scoreboard scoreboard = new Scoreboard(gracz1, gracz2);
        boolean isGameOnGoing = true;
        Random random = new Random();
        int aktywnyGraczIndex = random.nextInt(2);
        List<Gracz> gracze = new ArrayList<>();
        gracze.add(gracz1);
        gracze.add(gracz2);
        int kolejnosc = aktywnyGraczIndex;

        System.out.println("Numery w środku planszy wskazują odpowiednie pola, także aby wybrać odpowiednie pole należy wpisać dany numer ");
        Integer ruch;
        boolean czyWygral;
        boolean czyRuchPrawidlowy;


        while (isGameOnGoing) {
            Gracz aktywnyGracz = gracze.get(aktywnyGraczIndex);

            System.out.println("Ruch gracza o imieniu " + aktywnyGracz.getImie());
            plansza.pokazPlansze();
            ruch = aktywnyGracz.zaproponujRuch();
            // poczytac o optional
            while (ruch == null) {
                ruch = aktywnyGracz.zaproponujRuch();
            }
            czyRuchPrawidlowy = plansza.wykonajRuch(aktywnyGracz.getKsztalt(), ruch);
            while (czyRuchPrawidlowy == false) {
                ruch = aktywnyGracz.zaproponujRuch();
                while (ruch == null){
                    ruch = aktywnyGracz.zaproponujRuch();
                }
                czyRuchPrawidlowy = plansza.wykonajRuch(aktywnyGracz.getKsztalt(), ruch);
            }
            plansza.pokazPlansze();
            System.out.println("Ściąga");
            plansza.pokazSciage();
            aktywnyGraczIndex = gracze.indexOf(aktywnyGracz)+1;
            if (aktywnyGraczIndex > gracze.size() - 1){
                aktywnyGraczIndex = 0;
            }
            czyWygral = plansza.sprawdzCzyWygral(aktywnyGracz.getKsztalt());
            if (czyWygral == true) {
                System.out.println("Gratulacje " + aktywnyGracz.getImie());
                scoreboard.zmienPunktacje(aktywnyGracz);
                scoreboard.pokazWyniki();
                aktywnyGraczIndex = gracze.indexOf(aktywnyGracz)+1;
                if (aktywnyGraczIndex > gracze.size() - 1){
                    aktywnyGraczIndex = 0;
                }
                kolejnosc = gracze.indexOf(kolejnosc) + 1;
                if (kolejnosc > gracze.size() - 1){
                    kolejnosc = 0;
                }

                if (scoreboard.czyKoniec() == true) {
                    break;
                }
                System.out.println("Jeśli chcesz zakonczyc gre wpisz quit ");
                if (scanner.nextLine().equals("quit")) {
                    isGameOnGoing = false;
                }
                plansza.resetujPlansze();
            }
        }
    }
}
