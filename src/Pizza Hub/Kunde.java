import java.util.ArrayList;
import java.util.Scanner;

public class Kunde {

    private static String navn;
    private static int teleNr;
    private static String adresse;
    private static final int leveringsgebyr = 29;
    private static String leveringsType;

    public static String kundeOplysninger() {

        //Kunde info gemme i arraylist
        ArrayList KundeOp = new ArrayList();
        Scanner kundeOplysninger = new Scanner(System.in);
        String kundeInfo = kundeOplysninger.nextLine();

        //If-statement, som fører til en switch-case
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
                Bestilling.tidspizza = new Pizza(Bestilling.tidspizza.getNummer(), Bestilling.tidspizza.getNavn(),
                        Bestilling.tidspizza.getType(), leveringsgebyr, Bestilling.tidspizza.getKategori(),
                        Bestilling.tidspizza.getTopping(), Bestilling.tidspizza.getKommentar());
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
            //hvis input ikke stemmer overens
            System.out.println("Jeg forstår dig ikke. Prøv igen!");
            kundeOplysninger();
        }
        //Her fjernes [] for at gøre output af arraylisten mere nydelig.
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