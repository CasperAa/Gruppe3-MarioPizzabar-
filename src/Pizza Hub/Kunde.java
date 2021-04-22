import java.util.ArrayList;
import java.util.Scanner;

public class Kunde {

    private static String navn;
    private static int teleNr;
    private static String adresse;
    private static final int leveringsgebyr = 29;
    private static String leveringsType;

    public static String kundeOplysninger() {

        ArrayList KundeOp = new ArrayList();
        Scanner kundeOplysninger = new Scanner(System.in);
        String kundeInfo = kundeOplysninger.nextLine();

        if(kundeInfo.equals("1") || kundeInfo.equals("2")){
            switch (kundeInfo) {

                case "1":
                leveringsType = "Levering til addresse";
                Bestilling.ordrePris += leveringsgebyr;
                System.out.println("Indtast kundeoplysninger");
                System.out.println("Navn: ");
                navn = kundeOplysninger.nextLine();
                KundeOp.add(navn);
                System.out.println("Adresse: ");
                adresse = kundeOplysninger.nextLine();
                KundeOp.add(adresse);
                System.out.println("Telefonnummer: ");
                teleNr = kundeOplysninger.nextInt();
                KundeOp.add(teleNr);
                Bestilling.tidPizza = new Pizza(Bestilling.tidPizza.getNummer(), Bestilling.tidPizza.getNavn(),
                        Bestilling.tidPizza.getType(), leveringsgebyr, Bestilling.tidPizza.getKategori(),
                        Bestilling.tidPizza.getTopping(), Bestilling.tidPizza.getKommentar());
                Bestilling.kundePizza = new Pizza(Bestilling.kundePizza.getNummer(), navn, "Kunde",
                        Bestilling.kundePizza.getPris(), Bestilling.kundePizza.getKategori(), adresse,
                        String.valueOf(teleNr));
                break;

                case "2":
                leveringsType = "Afhentning i butik";
                System.out.println("Navn: ");
                navn = kundeOplysninger.nextLine();
                KundeOp.add(navn);
                Bestilling.kundePizza = new Pizza(Bestilling.kundePizza.getNummer(), navn, "Kunde",
                        Bestilling.kundePizza.getPris(), Bestilling.kundePizza.getKategori(),
                        Bestilling.kundePizza.getTopping(), Bestilling.kundePizza.getKommentar());
            }
        } else {
            System.out.println("Jeg forstår dig ikke. Prøv igen!");
            kundeOplysninger();
        }

        /*
        System.out.println("Ordreoversigt: ");
            for (ArrayList<Pizza> s : Bestilling.Ordrer()) {
            System.out.println(s.toString().replaceAll("\\[|\\]", ""));
        }

        */
            System.out.println("");
            System.out.println("Kundeinfo:\n" + KundeOp.toString().replaceAll("\\[|\\]", ""));

        return kundeInfo;
    }

    public static String getAdresse() {
        return adresse;
    }

    public static String getNavn() {
        return navn;
    }

    public static int getTeleNr() {
        return teleNr;
    }

    public static String getLeveringsType(){return leveringsType;}

    public static int getLeveringsgebyr() {
        return leveringsgebyr;
    }
}