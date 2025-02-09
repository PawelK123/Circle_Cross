package klasy;

public class Scoreboard {
    public Gracz gracz1;
    public Gracz gracz2;
    int pktgracz1;
    int pktgracz2;

    public Scoreboard(Gracz gracz1, Gracz gracz2) {
        this.gracz1 = gracz1;
        this.gracz2 = gracz2;
    }

    public void zmienPunktacje(Gracz gracz) {
        if (gracz == gracz1) {
            pktgracz1 += 1;
        }
        if (gracz == gracz2) {
            pktgracz2 += 1;
        }
    }
    public void pokazWyniki(){
        int nameWidth = Math.max(gracz1.getImie().length(), gracz2.getImie().length()) + 2; // +2 dla marginesów


        // Nagłówki tabeli
        System.out.printf("+%-" + nameWidth + "s+%-" + nameWidth + "s+%n", "Imię", "Imię");
        System.out.printf("+" + "-".repeat(nameWidth) + "+" + "-".repeat(nameWidth) + "+%n");

        // Wyświetlanie danych graczy
        System.out.printf("| %-"+nameWidth+"s| %-"+nameWidth+"s|%n", gracz1.getImie(), gracz2.getImie());
        System.out.printf("+" + "-".repeat(nameWidth) + "+" + "-".repeat(nameWidth) + "+%n");

        // Wyśrodkowanie liczb punktów w 3-znakowej szerokości
        System.out.printf("| %-"+nameWidth+"s| %-"+nameWidth+"s|%n", pktgracz1, pktgracz2);
        System.out.printf("+" + "-".repeat(nameWidth) + "+" + "-".repeat(nameWidth) + "+%n");

    }
    public boolean czyKoniec(){
        return pktgracz2 == 3 || pktgracz1 == 3;
    }
}