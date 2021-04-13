public class Kunde {

    private static String navn;
    private static int teleNr;
    private static String adresse;

    public static void kundeOplysninger(){

        ArrayList KundeOp = new ArrayList();

        Scanner kundeOplysninger = new Scanner (System.in);
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

    }

}
