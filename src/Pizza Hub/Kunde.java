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
            break;

            case "2":
            leveringsType = "Afhentning i butik";
            System.out.println("Navn: ");
            navn = kundeOplysninger.nextLine();
            KundeOp.add(navn);
        }   System.out.println("Ordreoversigt: ");

            for (ArrayList<Pizza> s : Bestilling.getAlleOrdrer()) {
                System.out.println(s.toString().replaceAll("\\[|\\]", ""));
            }
            System.out.println("");
            System.out.println("Kundeinfo:\n" + KundeOp.toString().replaceAll("\\[|\\]", ""));

        return kundeInfo;
    }

    public static int getLeveringsgebyr() {
        return leveringsgebyr;
    }
}