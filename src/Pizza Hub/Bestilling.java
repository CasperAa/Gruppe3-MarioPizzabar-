public class Bestilling {

    private int samletPris;
    private double bestillingsTidspunkt;
    private boolean levering;
    private boolean status;
    private int antalPizza;
    private static ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    static int userPizzaInt;


    public static void opretOrdre() {

            System.out.println("Indtast pizzanummer \nWrite \"DONE\" to finish order");
            boolean endOrder = true;

            Scanner userInput = new Scanner(System.in);
            ArrayList<Pizza> pizzaOrder = new ArrayList<Pizza>();
            while (endOrder == true) {
                String userPizza = userInput.nextLine();
                if (userPizza.equals("DONE")) {
                    endOrder = false;
                    break;
                } else if (isNumeric(userPizza) && pizzaMenu.size() >= Integer.parseInt(userPizza)) {
                    userPizzaInt = Integer.parseInt(userPizza) - 1;
                    pizzaOrder.add(pizzaMenu.get(userPizzaInt));
                } else if (userPizza.equals("print")){
                    System.out.println("Bestilling:");
                    for (Pizza temp : pizzaOrder)
                    System.out.println(temp);
                }
            }
        }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    //userPizza.equals("1") || userPizza.equals("2") || userPizza.equals("3") || userPizza.equals("4") || userPizza.equals("5") || userPizza.equals("6")) {
    //

    }

    //userPizza.equals("1") || userPizza.equals("2") || userPizza.equals("3") || userPizza.equals("4") || userPizza.equals("5") || userPizza.equals("6")