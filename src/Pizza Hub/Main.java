
public class Main {
    public static void main(String[] args) {
        //New Instance af programMenu class
        ProgramMenu mainMenu = new ProgramMenu();
        mainMenu.presentMainMenu();
        boolean endProgram = false;

        while (!endProgram) { //A while loop with a switch to run the menus and methods
            switch (mainMenu.fetchUserInput()) {
                //Add new Order
                case "1":
                    System.out.println("Her skal opret ordre være");

                //Show preparation order
                    break;
                case "2":
                    System.out.println("Her skal tilberedningsordre være");
                //Show statistic
                    break;
                case "3":
                    System.out.println("Her skal statistik være");
                //To exit HandBook
                    break;
                case "9":
                    System.out.println("Afslutter program");
                    endProgram = true;
                    break;
                default:
                    System.out.println("Forstår dig ikke. Prøv igen!");
                    mainMenu.presentMainMenu();
                    break;
            }
        }
    }
}
