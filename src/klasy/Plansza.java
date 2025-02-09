package klasy;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Plansza {
    public static final String EMPTY_FIELD = "| |";
    int wymiarx;
    int wymiary;
    int iloczyWymiarow;
    int iloscSymboli;
    public List<String> pola;


    public Plansza(int wymiarx, int wymiary,int iloscSymboli) {
        this.wymiarx = wymiarx;
        this.wymiary = wymiary;
        this.iloczyWymiarow = wymiarx * wymiary;
        this.pola = new ArrayList<>();
        this.iloscSymboli = iloscSymboli;
        for (int i = 0; i < iloczyWymiarow; i++) {
            pola.add(EMPTY_FIELD);
        }
    }

    public static Plansza create() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podajcie teraz ile symboli pod rząd ma dawac zwycięstwo: ");
        String iloscSymboli = scanner.nextLine();
        int iloscSymboli2 = Integer.parseInt(iloscSymboli);
        System.out.println("Podaj wymiar w poziomie planszy");
        int wymiarx = scanner.nextInt();
        System.out.println("Podaj wymiar w pionie planszy");
        int wymiary = scanner.nextInt();
        return new Plansza(wymiarx, wymiary,iloscSymboli2);
    }


    public void pokazSciage() {

        for (int i = 1; i < iloczyWymiarow + 1; i++) {
            if (i<10){
                System.out.print("| "+ i +"|");
            }
            else {
                System.out.print("|" + i + "|");
            }
            if (i % wymiary == 0) {
                System.out.println();
            }
        }

    }

    public void pokazPlansze() {
        for (int i = 1; i < pola.size() + 1; i++) {

            System.out.print(pola.get(i - 1));
            if (i % wymiary == 0) {
                System.out.println();
            }

        }

    }

    public int getIloczyWymiarow() {
        return iloczyWymiarow;
    }

    public boolean wykonajRuch(String ksztalt, int ruch) {
        if (!EMPTY_FIELD.equals(pola.get(ruch - 1))) {
            System.out.println("Ta część planszy jest juz zapełniona ");
            return false;
        } else {
            pola.set(ruch - 1, "|" + ksztalt + "|");
            return true;
        }
    }


    public boolean sprawdzCzyWygral(String ksztalt) {
        ksztalt = "|" + ksztalt + "|";
        // Sprawdzamy poziom
        for (int i = 0; i < wymiary; i++) {
            int licznik = 0;
            for (int j = 0; j < wymiarx; j++) {
                if (pola.get(i * wymiary + j).equals(ksztalt)) {
                    licznik++;
                }
            }
            if (licznik == iloscSymboli) {
                return true;
            }
        }

        // Sprawdzamy pion
        for (int i = 0; i < wymiary; i++) {
            int licznik = 0;
            for (int j = 0; j < wymiarx; j++) {
                if (pola.get(j * wymiary + i).equals(ksztalt)) {
                    licznik++;
                }
            }
            if (licznik == iloscSymboli) {
                return true;
            }
        }
        // Sprawdzamy skos
        int licznik = 0;
        for (int i = 0; i< pola.size(); i += wymiary + 1) {
            if (pola.get(i).equals(ksztalt)) {
                licznik++;
            }
            if (licznik == iloscSymboli) {
                return true;
            }
        }
        licznik = 0;
        for (int i = pola.size()-1; i>0; i -= wymiary - 1) {

            if (pola.get(i).equals(ksztalt)) {
                licznik++;
            }
            if (licznik == iloscSymboli) {
                return true;
            }
        }

        return false;
    }
    public void resetujPlansze(){
        for (int i = 0; i< pola.size(); i++){
            pola.set(i, EMPTY_FIELD);
        }
    }
}