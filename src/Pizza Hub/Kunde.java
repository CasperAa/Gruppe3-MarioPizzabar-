import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Kunde {

    private static String navn;
    private static int teleNr;
    private static String adresse;
    static int leveringsgebyr = 29;


    public static void kundeOplysninger() {

        ArrayList KundeOp = new ArrayList();
        Scanner kundeOplysninger = new Scanner(System.in);
        String kundeInfo = kundeOplysninger.nextLine();

        if (kundeInfo.contains("1")) {
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

            System.out.println("Ordre oversigt: ");

            } if (kundeInfo.contains("2")) {
            System.out.println("Navn: ");
            navn = kundeOplysninger.nextLine();
            KundeOp.add(navn);
        }
            for (ArrayList s : Bestilling.getOrdrer()) {
                System.out.println(s.stream().map(Object::toString).collect(Collectors.joining("\n")));
            }
            System.out.println("");
            System.out.println("Kundeinfo:\n" + KundeOp.stream().map(Object::toString).collect(Collectors.joining("\n")));

    }

}


