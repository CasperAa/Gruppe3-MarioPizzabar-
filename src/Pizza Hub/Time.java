
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Time {
    public static void main(String[] args) {

        testTime();


        } public static void testTime() {
        boolean input = true;

        ArrayList<String> timeSave = new ArrayList<String>();

        System.out.println("Type anything");
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        while (input) {

            Scanner scan = new Scanner(System.in);
            String inputFromUser = scan.nextLine();
            timeSave.add(inputFromUser + ": " + LocalDateTime.now().format(formatTime));
            System.out.println("Type \"show\" to show input");
            String stack[] = timeSave.toArray(new String[timeSave.size()]);

            String s = "show";
            for (String a : stack)

                if (inputFromUser.contains(s)) {
                    System.out.println(a);
                }
        }

    }

}







