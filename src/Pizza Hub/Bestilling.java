public class Bestilling {

    private int samletPris;
    private double bestillingsTidspunkt;
    private boolean levering;
    private boolean status;
    private int antalPizza;
    private static ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    static int userPizzaInt;


    public static void opretOrdre() {
        System.out.println(pizzaMenu);

            System.out.println("Indtast pizzanummer \nWrite \"DONE\" to finish order");
            boolean endOrder = true;

            Scanner bestillingInput = new Scanner(System.in);
            ArrayList<Pizza> pizzaOrder = new ArrayList<Pizza>();
            while (endOrder == true) {
                String userPizza = bestillingInput.nextLine();
                if (userPizza.equals("DONE")) {
                    endOrder = false;
                    break;
                } else if (userPizza.equals("1") || userPizza.equals("2") || userPizza.equals("3") || userPizza.equals("4") || userPizza.equals("5") || userPizza.equals("6")) {
                    userPizzaInt = Integer.parseInt(userPizza) - 1;
                    pizzaOrder.add(pizzaMenu.get(userPizzaInt));
                } else if (userPizza.equals("print")){
                    System.out.println(pizzaOrder);
                }
            }
        }

    }

//userPizza.equals("1") || userPizza.equals("2") || userPizza.equals("3") || userPizza.equals("4") || userPizza.equals("5") || userPizza.equals("6")