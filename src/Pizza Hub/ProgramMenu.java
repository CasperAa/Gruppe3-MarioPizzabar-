import java.util.Scanner;

public class ProgramMenu {
    final private Scanner menuInput = new Scanner(System.in);

    //Welcome message display
    public void welcomeScreen(){
        System.out.println("\nVelkommen til Mario's Pizzabar");
    }

    //Main menu display
    public void presentMainMenu(){
        System.out.println("\nTryk 1: Se menu");
        System.out.println("Tryk 2: Opret ny ordre");
        System.out.println("Tryk 3: Se tilberedningsrækkefølge");
        System.out.println("Tryk 4: Se statistik");
        System.out.println("Tryk 5: Rediger ordreliste");
        System.out.println("Tryk 9: Afslut program");
    }

    //Scanner class asking for user input
    public  String fetchUserInput() {
        return menuInput.nextLine();
    }

    public static String printItemAddedToOrderMessage (){
        return ("\nIndtast nummer (1 - " + Pizza.getPizzaMenu().size() + ") for at tilføje eller skriv \"done\".");
    }
}