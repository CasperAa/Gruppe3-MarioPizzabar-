import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        //Menu and extra ingredients is created
        Pizza.menuOpretter();
        EkstraIngredienser.ingrediensListeOpretter();

        //New Instance af programMenu class as it's a non-static class & method
        ProgramMenu menu = new ProgramMenu();
        menu.welcomeScreen();
        menu.presentMainMenu();


        boolean endProgram = false;
        while (!endProgram) { //A while loop with a switch to run the menus and methods
            switch (menu.fetchUserInput()) {

                case "1":                //Show menu
                    PizzaMenu.printPizzaMenu();
                    menu.presentMainMenu();
                    System.out.println("Du er i hovedmenuen nu!");
                    break;

                case "2":               //Create new order
                    Bestilling.opretOrdre();
                    menu.presentMainMenu();
                    break;

                case "3":                //Show preparation order
                    OrdreListe.ordreListePrint(Bestilling.getOrdrer());
                    System.out.println("Du er i hovedmenuen nu!");
                    break;

                case "4":                //Show statistic
                    System.out.println("Den samlede omsætning er " + Statistik.omsætning() + " kr.");
                    System.out.println("Den mest populære pizza er nr. " + Statistik.mestPopulærePizza() + ".");
                    Statistik.pizzaFrekvensPrinter();
                    System.out.println("Du er i hovedmenuen nu!");
                    break;

                case "5":                //Start process to remove order
                    OrdreListe.ordreListePrint(Bestilling.getOrdrer());
                    OrdreListe.sletOrdre();
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
