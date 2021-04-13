import java.util.Scanner;

public class ProgramMenu {
    private Scanner menuInput = new Scanner(System.in);

    public void presentMainMenu(){
        System.out.println("Welcome to Mario's Pissabar");
        System.out.println("Tryk 1: Opret ny ordre");
        System.out.println("Tryk 2: Tilberednings rækkefølge");
        System.out.println("Tryk 3: Check statistik");
    }


    //Scanner class asking for user input
    public int fetchUserInput() {
        int userInput = menuInput.nextInt();
        return userInput;
    }
}
