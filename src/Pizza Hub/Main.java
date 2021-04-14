import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //New Instance af programMenu class
        //Pizzaerne oprettes
        Pizza.pizzaOpretter();
        ProgramMenu mainMenu = new ProgramMenu();
        mainMenu.presentMainMenu();
        boolean endProgram = false;
        while (!endProgram) { //A while loop with a switch to run the menus and methods
            switch (mainMenu.fetchUserInput()) {
                //Add new Order
                case "1":
                    PizzaMenu.printPizzaMenu();
                    mainMenu.presentMainMenu();
                    break;
                case "2":
                    Bestilling.opretOrdre();
                    mainMenu.presentMainMenu();
                    break;
                //Show preparation order
                case "3":
                    //OrdreListe.ordreListePrint();
                    break;
                //Show statistic
                case "4":
                    System.out.println("Den samlede omsætning er " + Statistik.omsætning() + " kr.");
                    System.out.println("Den mest populære pizza er nr. " + Statistik.mestPopulærePizza() + ".");
                    Statistik.pizzaFrekvens();
                    break;
                //To exit HandBook
                case "9":
                    System.out.println("Afslutter program");
                    endProgram = true;
                    break;
                default:
                    System.out.println("Jeg forstår dig ikke. Prøv igen!");
                    mainMenu.presentMainMenu();
            }
        }
    }
}
