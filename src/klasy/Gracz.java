package klasy;

import java.util.Scanner;

public class Gracz {
    private final String imie;
    private final  String ksztalt;
    String ruch;
    int ruchint;
    int dlugosc_listy_planszy;

    public static Gracz create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Graczu podaj swoje imię: ");
        String imie = scanner.nextLine();
        System.out.println("Podaj teraz symbol jakim chcesz grac: ");
        String symbol = scanner.nextLine();
        return new Gracz(imie, symbol);
    }
    public String getKsztalt() {
        return ksztalt;
    }

    public String getImie() {
        return imie;
    }

    public Gracz(String imie, String ksztalt) {
        this.imie = imie;
        this.ksztalt = ksztalt;

    }

    public Gracz setDlugosc_listy_planszy(int dlugosc_listy_planszy) {
        this.dlugosc_listy_planszy = dlugosc_listy_planszy;
        return this;
    }

    public Integer zaproponujRuch() {
        System.out.print("Podaj numer pola ");
        Scanner scanner = new Scanner(System.in);
        ruch = scanner.nextLine();
        try {
            ruchint = Integer.parseInt(ruch);
        } catch (NumberFormatException e) {
            System.out.println("Podales zlego typu zmienną!");
            return null;
        }
        if (ruchint > dlugosc_listy_planszy || ruchint < 0) {
            System.out.println("Podales zla wartosc!");
            return null;
        } else {
            return ruchint;
        }
    }



}

