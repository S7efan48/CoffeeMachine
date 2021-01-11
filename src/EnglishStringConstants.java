public class EnglishStringConstants implements StringConstants{

    @Override
    public void printSupplies(int water,int milk, int coffeeBeans, int cups, int money) {
        // polimorfism (o alta forma de polimorfism pentru ca tre sa bagi string-urile in metode)
        // defineste o interfata cu numele StringConstants si doua clase EnglishStringConstants si RomanianStringConstants
        String statusDetailsFormat = "The coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "%d dollars\n";
        String status = String.format(statusDetailsFormat,water,milk,coffeeBeans,cups,money);
        System.out.println(status);
    }

    public void takeMoney(int money){
        String moneyStatus = "I gave you %d dollars";
        String status = String.format(moneyStatus,money);
        System.out.println(status);
    }
    @Override
    public void choosingMainMenuOption(){
        System.out.println("Write action (buy, fill, take, remaining, exit:) ");
    }
    @Override
    public void choosingCoffee(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
    }
    @Override
    public void fillWater(){
        System.out.println("Write how many ml of water do you want to add:");
    }
    @Override
    public void fillMilk(){
        System.out.println("Write how many ml of milk do you want to add:");
    }
    @Override
    public void fillBeans(){
        System.out.println("Write how many grams of beans do you want to add:");
    }
    @Override
    public void fillCups(){
        System.out.println("Write how many disposable cups of coffee do you want to add:");
    }
    @Override
    public void exit(){
        System.out.println("Have a nice day!");
    }
    @Override
    public void incorrect(){
        System.out.println("Sorry! I don't understand your command.");
    }
    @Override
    public void lowWater(){
        System.out.println("Sorry, not enough water!");
    }
    @Override
    public void lowMilk(){
        System.out.println("Sorry, not enough milk!");
    }
    @Override
    public void lowBeans(){
        System.out.println("Sorry, not enough coffee beans!");
    }
    @Override
    public void lowCups(){
        System.out.println("Sorry, not enough cups of coffee!");
    }
    @Override
    public void enoughResources(){
        System.out.println("I have enough resources, making you a coffee!");
    }
}
