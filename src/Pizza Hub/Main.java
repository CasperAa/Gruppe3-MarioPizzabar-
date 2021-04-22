import java.io.FileNotFoundException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        //Menu oprettes
        Pizza.menuOpretter();

        //Ny instance af programMenu classen da den oprindeligt er non-static
        ProgramMenu menu = new ProgramMenu();
        menu.welcomeScreen();
        menu.presentMainMenu();

        boolean endProgram = false;
        while (!endProgram) { //while for at køre menuen
            switch (menu.fetchUserInput()) {

                case "1":                //Vis pizzamenuen
                    Pizza.printPizzaMenu();
                    menu.presentMainMenu();
                    break;

                case "2":               //Opret ny ordre
                    Bestilling.opretOrdre();
                    menu.presentMainMenu();
                    break;

                case "3":                //Vis forberedelsesrækkefølgen
                    Bestilling.sorterListe(Bestilling.alleOrdrer);
                    Bestilling.printTilberedningsRækkefølge(Bestilling.alleOrdrer);
                    System.out.println("Du er i hovedmenuen nu!");
                    break;

                case "4":                //Vis statistik
                    Statistik.statistikMenu();
                    System.out.println("Du er i hovedmenuen nu!");
                    break;

                case "5":                //Fjern en ordre fra ordrelisten
                    Bestilling.sletOrdre();
                    menu.presentMainMenu();
                    break;

                case "9":                //Exit program
                    System.out.println("Afslutter program.");
                    endProgram = true;
                    break;

                default:                //Hvis brugeren skriver noget, programmet ikke forstår
                    System.out.println("Jeg forstår dig ikke. Prøv igen!");
                    menu.presentMainMenu();
            }
        }
    }
}
