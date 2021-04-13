import java.util.Scanner;

public class ProgramMenu {
    private Scanner menuInput = new Scanner(System.in);

    public void presentMainMenu(){
        System.out.println("Velkommen til Marios Pizzabar");
        System.out.println("Tryk 1: Opret ny ordre");
        System.out.println("Tryk 2: Tilberedningsrækkefølge");
        System.out.println("Tryk 3: Se statistik");
        System.out.println("Tryk 9: Afslut program");
    }


    //Scanner class asking for user input
    public  String fetchUserInput() {
        String userInput = menuInput.nextLine();
        return userInput;
    }
}
