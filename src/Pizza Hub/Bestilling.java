public class Bestilling {

    private int samletPris;
    private double bestillingsTidspunkt;
    private boolean levering;
    private boolean status;
    private int antalPizza;



        public static void opretOrdre() {
            Scanner userInput = new Scanner(System.in);

            System.out.println("Indtast pizzanummer \nWrite \"DONE\" to finish order");
            boolean endOrder = true;

            String userPizza = userInput.nextLine();
            ArrayList<Pizza> pizzaOrder = new ArrayList<Pizza>();
            while (endOrder == true) {
                if (userPizza.equals("DONE")) {
                    endOrder = false;
                } else {
                    int userPizzaInt = Integer.parseInt(userPizza);
                    pizzaOrder.add(Pizza.getPizzaMenu2(userPizzaInt - 1));
                }
            }
        }

}




