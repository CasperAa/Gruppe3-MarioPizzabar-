import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Statistik {

    //Dataen bliver hentet fra ArrayListen med færdiggjorte ordrer, så der kan først laves statistik,
    // når der er blevet slettet ordrer fra ArrayListen alleOrdrer.

    public static void statistikMenu() throws ParseException {
        Scanner userInput = new Scanner(System.in);
        boolean endMenu = false;
        System.out.println("\n---Menu for statistik---" +
                "\nTast 1: Se omsætning" +
                "\nTast 2: Få den mest populære pizza" +
                "\nTast 3: Se antallet af solgte pizzaer" +
                "\nTast 4: Se ordrer fra en bestemt periode" +
                "\nTast 5: Exit");
        while (!endMenu) {
            String valg = userInput.nextLine();
            switch (valg) {

                case "1":
                    System.out.println("Ønsker du at se den samlede omsætning, omsætningen for en/et bestemt " +
                            "år/måned/dag eller for en anden periode?" +
                            "\nTast 1: Samlet omsætning" +
                            "\nTast 2: År/måned/dag" +
                            "\nTast 3: Anden periode" +
                            "\nTast 4: Specifik tidsperiode");

                    String omsætningValg = userInput.nextLine();
                    switch (omsætningValg) {

                        case "1":
                            System.out.println("Den samlede omsætning er " + omsætning() + " kr.");
                            break;
                        case "2":
                            omsætningEfterDato();
                            break;
                        case "3":
                            omsætningForPeriode();
                            break;
                        case "4":
                            omsætningForTidsperiode();
                            break;
                        default:
                            System.out.println("Jeg forstår dig ikke. Prøv igen!");
                    }
                    System.out.println("\nDu er tilbage i statistikmenuen.");
                    break;

                case "2":
                    System.out.println("Den mest populære pizza er " + mestPopulærePizza() + ".");
                    System.out.println("\nDu er tilbage i statistikmenuen.");
                    break;

                case "3":
                    System.out.println("Ønsker du at se antallet af solgte pizzaer i alt eller fra en/et bestemt " +
                            "år/måned/dag?" +
                            "\nTast 1: I alt" +
                            "\nTast 2: År/måned/dag");
                    String printTreValg = userInput.nextLine();
                    switch (printTreValg) {

                        case "1":
                            pizzaFrekvensPrinter(Bestilling.færdiggjorteOrdrer);
                            break;
                        case "2":
                            frekvensEfterDato();
                            break;
                        default:
                            System.out.println("Jeg forstår dig ikke. Prøv igen!");
                    }
                    System.out.println("\nDu er tilbage i statistikmenuen.");
                    break;

                case "4":
                    System.out.println("Ønsker du at se ordrer fra en/et bestemt år/måned/dag eller for en " +
                            "bestemt tidsperiode?" +
                            "\nTast 1: År/måned/dag" +
                            "\nTast 2: Tidsperiode");

                    String printValg = userInput.nextLine();
                    switch (printValg) {

                        case "1":
                            ordrerEfterDato();
                            break;
                        case "2":
                            ordrerITidsperiode();
                            break;
                        default:
                            System.out.println("Jeg forstår dig ikke. Prøv igen!");
                    }
                    System.out.println("\nDu er tilbage i statistikmenuen.");
                    break;

                case "5":
                    endMenu = true;
                    break;

                default:
                    System.out.println("Jeg forstår dig ikke. Prøv igen!");
            }
        }
    }

    public static int omsætning() {
        int omsætning = 0;
        for (int i = 0; i < Bestilling.færdiggjorteOrdrer.size(); ++i) {
            Bestilling.færdiggjorteOrdrer.get(i);
            for (int j = 0; j < Bestilling.færdiggjorteOrdrer.get(i).size(); ++j) {
                omsætning += Bestilling.færdiggjorteOrdrer.get(i).get(j).getPris();
            }
        }
        return omsætning;
    }

    public static String mestPopulærePizza() {
        int tempPizza = 0;
        int tempCount = 0;
        int count = 1;
        int popular = 0;
        if (popular != 0) {
            for (int i = 0; i < Bestilling.færdiggjorteOrdrer.size(); i++) {
                for (int j = 0; j < Bestilling.færdiggjorteOrdrer.get(i).size(); j++) {
                    tempPizza = Bestilling.færdiggjorteOrdrer.get(i).get(j).getNummer();
                    tempCount = 0;

                    if (tempPizza == Bestilling.færdiggjorteOrdrer.get(j).get(j).getNummer())
                        tempCount++;
                }
                if (tempCount > count) {
                    popular = tempPizza;
                    count = tempCount;
                }
            }
            return "nr. " + popular;
        }
        return "ikke afgjort";
    }


    public static void pizzaFrekvensPrinter(ArrayList<ArrayList<Pizza>> ordreliste) {
        int count2 = 0;
        for (int p = 1; p <= Pizza.getPizzaMenu().size(); p++) {
            int count = 0;

            for (int i = 0; i < ordreliste.size(); i++) {
                for (int j = 0; j < ordreliste.get(i).size(); j++) {
                    if (ordreliste.get(i).get(j).getNummer() == p) {
                        count++;
                        count2++;
                    }

                }

            }
            if (count > 1 && !Pizza.getPizzaMenu().get(p).getKategori().contains("Sandwich")) {
                System.out.println("Pizza nr. " + p + " er blevet købt " + count + " gange.");
            } else if (count == 1 && !Pizza.getPizzaMenu().get(p).getKategori().contains("Sandwich")) {
                System.out.println("Pizza nr. " + p + " er blevet købt " + count + " gang.");
            } else if (count > 1 && Pizza.getPizzaMenu().get(p).getKategori().contains("Sandwich")) {
                System.out.println("Sandwich nr. " + p + " er blevet købt " + count + " gange.");
            } else if (count == 1 && Pizza.getPizzaMenu().get(p).getKategori().contains("Sandwich")) {
                System.out.println("Sandwich nr. " + p + " er blevet købt " + count + " gang.");
            }
        }
        if (count2 > 0){
            System.out.println("I alt er der blevet solgt " + count2 + " pizzaer/sandwiches.");
        } else if (count2 == 0){
            System.out.println("Der er ikke belvet solgt nogen pizzaer/sandwiches.");
        }
    }

    public static void ordrerEfterDato() {
        System.out.println("Se ordrer fra en/et bestemt\n1: år\n2: måned\n3: dato");
        Scanner userInput = new Scanner(System.in);
        String valg;
        String år;
        String måned;
        String dag;
        valg = userInput.nextLine();

        switch (valg) {
            case "1":
                int count = 0;
                System.out.println("Hvilket år ønsker du at se data fra?");
                år = userInput.nextLine();
                System.out.println("Alle ordrer fra " + år + ":");
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år)) {
                        System.out.println(ordre.toString());
                        count++;
                    }
                }
                if (count==0){
                    System.out.println("Der er ingen ordrer fra den valgte periode.");
                }
                break;
            case "2":
                count = 0;
                System.out.println("Hvilket år ønsker du at se data fra?");
                år = userInput.nextLine();
                System.out.println("Hvilken måned ønsker du at se data fra?");
                måned = userInput.nextLine();
                System.out.println("Alle ordrer fra " + år + "-" + måned + ":");
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år) &&
                            ordre.get(ordre.size() - 1).getKommentar().substring(3, 5).contains(måned)) {
                        System.out.println(ordre.toString());
                        count++;
                    }
                }
                if (count==0){
                    System.out.println("Der er ingen ordrer fra den valgte periode.");
                }
                break;

            case "3":
                count = 0;
                System.out.println("Hvilket år ønsker du at se data fra? (YYYY)");
                år = userInput.nextLine();
                System.out.println("Hvilken måned ønsker du at se data fra? (MM)");
                måned = userInput.nextLine();
                System.out.println("Hvilken dato ønsker du at se data fra? (DD)");
                dag = userInput.nextLine();
                System.out.println("Alle ordrer fra " + år + "-" + måned + "-" + dag + ":");
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år) &&
                            ordre.get(ordre.size() - 1).getKommentar().substring(3, 5).contains(måned) &&
                            ordre.get(ordre.size() - 1).getKommentar().substring(0, 2).contains(dag)) {
                        System.out.println(ordre.toString());
                        count++;
                    }
                }
                if (count==0){
                    System.out.println("Der er ingen ordrer fra den valgte periode.");
                }
                break;
            default:
                System.out.println("Jeg forstår dig ikke. Prøv igen!");
        }


    }

    public static void ordrerITidsperiode() throws ParseException {
        int count = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Hvad er starttidspunktet for perioden, du ønsker data fra? (dd-MM-yyyy HH:mm)");
        String start = userInput.nextLine();
        Date starttidspunkt = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(start);
        System.out.println("Hvad er sluttidspunktet for perioden, du ønsker data fra? (dd-MM-yyyy HH:mm)");
        String slut = userInput.nextLine();
        Date sluttidspunkt = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(slut);
        for (int i = 0; i < Bestilling.færdiggjorteOrdrer.size(); ++i) {
            Date tempDato = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(Bestilling.færdiggjorteOrdrer.
                    get(i).get(Bestilling.færdiggjorteOrdrer.get(i).size() - 1).getKommentar().substring(0, 16));
            if (starttidspunkt.before(tempDato) || starttidspunkt.equals(tempDato) && sluttidspunkt.after(tempDato) ||
                    sluttidspunkt.equals(tempDato)){
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer)
                    System.out.println(ordre.toString());
                    count++;
            }
        }
        if (count==0){
            System.out.println("Der er ingen ordrer fra den valgte periode.");
        }
    }

    public static void omsætningEfterDato() {
        System.out.println("Se omsætning fra en/et bestemt\n1: år\n2: måned\n3: dato");
        Scanner userInput = new Scanner(System.in);
        String valg;
        String år;
        String måned;
        String dag;
        valg = userInput.nextLine();

        switch (valg) {
            case "1":
                int omsætning = 0;
                System.out.println("Hvilket år ønsker du at se data fra?");
                år = userInput.nextLine();
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år)) {
                        for (Pizza pizza : ordre){
                            omsætning += pizza.getPris();
                        }
                    }
                }
                if (omsætning >0){
                    System.out.print("Den samlede indtjening for " + år + " er " + omsætning + " kr.");
                } else {
                    System.out.println("Der er ingen indtjening for den valgte periode.");
                }
                break;
            case "2":
                omsætning = 0;
                System.out.println("Hvilket år ønsker du at se data fra?");
                år = userInput.nextLine();
                System.out.println("Hvilken måned ønsker du at se data fra?");
                måned = userInput.nextLine();
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år) && ordre.get(ordre.
                            size() - 1).getKommentar().substring(3, 5).contains(måned)) {
                        for (Pizza pizza : ordre)
                            omsætning += pizza.getPris();
                    }
                }
                if (omsætning >0){
                    System.out.print("Den samlede indtjening for " + år + "-" + måned + " er " + omsætning + " kr.");
                } else {
                    System.out.println("Der er ingen indtjening for den valgte periode.");
                }
                break;

            case "3":
                omsætning = 0;
                System.out.println("Hvilket år ønsker du at se data fra? (YYYY)");
                år = userInput.nextLine();
                System.out.println("Hvilken måned ønsker du at se data fra? (MM)");
                måned = userInput.nextLine();
                System.out.println("Hvilken dato ønsker du at se data fra? (DD)");
                dag = userInput.nextLine();
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år) && ordre.get(ordre.
                            size() - 1).getKommentar().substring(3, 5).contains(måned) && ordre.get(ordre.size() - 1).
                            getKommentar().substring(0, 2).contains(dag)) {
                        for (Pizza pizza : ordre)
                            omsætning += pizza.getPris();
                    }
                }
                if (omsætning >0){
                    System.out.print("Den samlede indtjening for " + år + "-" + måned + "-" + dag + " er " + omsætning
                            + " kr.");
                } else {
                    System.out.println("Der er ingen indtjening for den valgte periode.");
                }
                break;

            default:
                System.out.println("Jeg forstår dig ikke. Prøv igen!");
        }


    }

    public static void frekvensEfterDato() {
        System.out.println("Se data fra en/et bestemt\n1: år\n2: måned\n3: dato");
        Scanner userInput = new Scanner(System.in);
        String valg;
        String år;
        String måned;
        String dag;
        valg = userInput.nextLine();
        ArrayList<ArrayList<Pizza>> temp = new ArrayList<>();

        switch (valg) {
            case "1":
                int count = 0;
                System.out.println("Hvilket år ønsker du at se data fra?");
                år = userInput.nextLine();
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år)) {
                        temp.add(ordre);
                        count++;
                    }
                }
                if (count >0){
                    System.out.println("Oversigt for ordrer i " + år + ":");
                    pizzaFrekvensPrinter(temp);
                } else {
                    System.out.println("Der er ingen ordrer for den valgte periode.");
                }
                break;
            case "2":
                count = 0;
                System.out.println("Hvilket år ønsker du at se data fra?");
                år = userInput.nextLine();
                System.out.println("Hvilken måned ønsker du at se data fra?");
                måned = userInput.nextLine();
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år) && ordre.get(ordre.
                            size() - 1).getKommentar().substring(3, 5).contains(måned)) {
                        temp.add(ordre);
                        count++;
                    }
                }
                if (count >0){
                    System.out.println("Oversigt for ordrrer i " + år + "-" + måned + ":");
                    pizzaFrekvensPrinter(temp);
                } else {
                    System.out.println("Der er ingen ordrer for den valgte periode.");
                }
                break;

            case "3":
                count = 0;
                System.out.println("Hvilket år ønsker du at se data fra? (YYYY)");
                år = userInput.nextLine();
                System.out.println("Hvilken måned ønsker du at se data fra? (MM)");
                måned = userInput.nextLine();
                System.out.println("Hvilken dato ønsker du at se data fra? (DD)");
                dag = userInput.nextLine();
                for (ArrayList<Pizza> ordre : Bestilling.færdiggjorteOrdrer) {
                    if (ordre.get(ordre.size() - 1).getKommentar().substring(6, 10).contains(år) && ordre.get(ordre.
                            size() - 1).getKommentar().substring(3, 5).contains(måned) && ordre.get(ordre.size() - 1).
                            getKommentar().substring(0, 2).contains(dag)) {
                        temp.add(ordre);
                        count++;
                    }
                }
                if (count >0){
                    System.out.println("Oversigt for ordrer fra " + år + "-" + måned + "-" + dag + ":");
                    pizzaFrekvensPrinter(temp);
                } else {
                    System.out.println("Der er ingen ordrer for den valgte periode.");
                }
                break;

            default:
                System.out.println("Jeg forstår dig ikke. Prøv igen!");
        }

    }

    public static void omsætningForPeriode() throws ParseException {
        int omsætning = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Hvad er startdatoen for perioden, du ønsker data fra? (dd-MM-yyyy)");
        String start = userInput.nextLine();
        Date startDato = new SimpleDateFormat("dd-MM-yyyy").parse(start);
        System.out.println("Hvad er slutdatoen for perioden, du ønsker data fra? (dd-MM-yyyy)");
        String slut = userInput.nextLine();
        Date slutDato = new SimpleDateFormat("dd-MM-yyyy").parse(slut);
        for (int i = 0; i < Bestilling.færdiggjorteOrdrer.size(); ++i) {
            Date tempDato = new SimpleDateFormat("dd-MM-yyyy").parse(Bestilling.færdiggjorteOrdrer.get(i).
                    get(Bestilling.færdiggjorteOrdrer.get(i).size() - 1).getKommentar().substring(0, 10));
            if (startDato.before(tempDato) || startDato.equals(tempDato) && slutDato.after(tempDato) || slutDato.
                    equals(tempDato)){
                for (Pizza pizza : Bestilling.færdiggjorteOrdrer.get(i))
                    omsætning += pizza.getPris();
            }
        }
        System.out.println("Den samlede indtjening for perioden er " + omsætning + " kr.");
    }

    public static void omsætningForTidsperiode() throws ParseException {
        int omsætning = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Hvad er starttidspunktet for perioden, du ønsker data fra? (dd-MM-yyyy HH:mm)");
        String start = userInput.nextLine();
        Date starttidspunk = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(start);
        System.out.println("Hvad er sluttidspunktet for perioden, du ønsker data fra? (dd-MM-yyyy HH:mm)");
        String slut = userInput.nextLine();
        Date sluttidspunkt = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(slut);
        for (int i = 0; i < Bestilling.færdiggjorteOrdrer.size(); ++i) {
            Date tempDato = new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(Bestilling.færdiggjorteOrdrer.get(i).
                    get(Bestilling.færdiggjorteOrdrer.get(i).size() - 1).getKommentar().substring(0, 16));
            if (starttidspunk.before(tempDato) || starttidspunk.equals(tempDato) && sluttidspunkt.after(tempDato) ||
                    sluttidspunkt.equals(tempDato)){
                for (Pizza pizza : Bestilling.færdiggjorteOrdrer.get(i))
                    omsætning += pizza.getPris();
            }
        }
        System.out.println("Den samlede indtjening for perioden er " + omsætning + " kr.");
    }

}