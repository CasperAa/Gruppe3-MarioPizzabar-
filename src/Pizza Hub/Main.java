import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        //Menu og extra ingredienser oprettes
        Pizza.menuOpretter();
        EkstraIngredienser.ingrediensListeOpretter();

        //Ny instance af programMenu classen da den oprindelig er non-static
        ProgramMenu menu = new ProgramMenu();
        menu.welcomeScreen();
        menu.presentMainMenu();

        boolean endProgram = false;
        while (!endProgram) { //while for at køre menuen
            switch (menu.fetchUserInput()) {

                case "1":                //vis main menu
                    Pizza.printPizzaMenu();
                    menu.presentMainMenu();
                    break;

                case "2":               //opret ny order
                    Bestilling.opretOrdre();
                    menu.presentMainMenu();
                    break;

                case "3":                //vis forberedelserækkefølge
                    Bestilling.sorterListe(Bestilling.alleOrdrer);
                    Bestilling.printTilberedningsRækkefølge(Bestilling.alleOrdrer);
                    System.out.println("Du er i hovedmenuen nu!");
                    break;

                case "4":                //vis statestik
                    System.out.println("Den samlede omsætning er " + Statistik.omsætning() + " kr.");
                    System.out.println("Den mest populære pizza er " + Statistik.mestPopulærePizza() + ".");
                    Statistik.pizzaFrekvensPrinter();
                    System.out.println("\nHerunder er en liste over tidligere ordrer:");
                    //OrdreListe.ordreListePrint(Bestilling.getFærdiggjorteOrdrer());
                    System.out.println("Du er i hovedmenuen nu!");
                    break;

                case "5":                //Fjern en ordre fra ordrelisten
                    Bestilling.sorterListe(Bestilling.alleOrdrer);
                    Bestilling.printTilberedningsRækkefølge(Bestilling.getAlleOrdrer());
                    Bestilling.sletOrdre();
                    menu.presentMainMenu();
                    break;

                case "9":                //To end program
                    System.out.println("Afslutter program");
                    endProgram = true;
                    break;

                default:                //default reply
                    System.out.println("Jeg forstår dig ikke. Prøv igen!");
                    menu.presentMainMenu();
            }
        }
    }
}
