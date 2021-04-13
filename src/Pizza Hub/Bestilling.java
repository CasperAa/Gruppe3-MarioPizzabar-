public class Bestilling {

    private int samletPris;
    private double bestillingsTidspunkt;
    private boolean levering;
    private boolean status;
    private int antalPizza;
    static ArrayList<Pizza> pizzaMenu = Pizza.getPizzaMenu();
    static ArrayList<ArrayList> ordrer = new ArrayList<ArrayList>();
    static ArrayList<Integer> indkomst = new ArrayList<Integer>();
    static int userPizzaInt;


    public static void opretOrdre() {

            System.out.println("Indtast pizzanummer \nWrite \"DONE\" to finish order");
            boolean endOrder = true;

            Scanner userInput = new Scanner(System.in);
            ArrayList<Pizza> pizzaOrder = new ArrayList<Pizza>();
            while (endOrder == true) {
                String userPizza = userInput.nextLine();
                if (userPizza.equals("DONE")) {
                    if (pizzaOrder.isEmpty() == false){
                        ordrer.add(pizzaOrder);
                        indkomst.add(totalPrice(pizzaOrder));
                    }
                    endOrder = false;
                    break;
                } else if (isNumeric(userPizza) && pizzaMenu.size() >= Integer.parseInt(userPizza)) {
                    userPizzaInt = Integer.parseInt(userPizza) - 1;
                    pizzaOrder.add(pizzaMenu.get(userPizzaInt));
                } else if (userPizza.equals("print")){
                    System.out.println("Bestilling:");
                    for (Pizza temp : pizzaOrder) {
                        System.out.println(temp);
                    }
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

    public static int totalPrice(ArrayList<Pizza> array) {
        int totalpris = 0;
        for (Pizza temp : array) {
            totalpris += Pizza.getPris();
        }
        return totalpris;
    }

    public static ArrayList<Integer> getIndkomst() {
        return indkomst;
    }
}

/*
if (pizzaOrder.isEmpty() == false){
                        ordrer.add(pizzaOrder);
                    }
 */
