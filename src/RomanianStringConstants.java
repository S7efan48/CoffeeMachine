public class RomanianStringConstants implements StringConstants {

    public void printSupplies(int water,int milk, int coffeeBeans, int cups, int money) {
        // polimorfism (o alta forma de polimorfism pentru ca tre sa bagi string-urile in metode)
        // defineste o interfata cu numele StringConstants si doua clase EnglishStringConstants si RomanianStringConstants
        String statusDetailsFormat = "Aparatul de cafea are:\n" +
                "%d ml de apa\n" +
                "%d ml de lapte\n" +
                "%d grame de cafea\n" +
                "%d pahare\n" +
                "%d dolari\n";
        String status = String.format(statusDetailsFormat,water,milk,coffeeBeans,cups,money);
        System.out.println(status);
    }

    public void takeMoney(int money){
        String moneyStatus = "V-am dat %d dolari";
        String status = String.format(moneyStatus,money);
        System.out.println(status);
    }

    @Override
    public void choosingMainMenuOption(){
        System.out.println("Selecteaza actiunea(buy(cumpara), fill(alimenteaza), take(colecteaza), remaining(stare), exit(iesire):)");
    }

    @Override
    public void choosingCoffee() {
        System.out.println("Ce doriti sa cumparati? 1 - espresso, 2 - latte, 3 - cappuccino, back - inapoi la meniul principal");
    }

    @Override
    public void fillWater() {
        System.out.println("Cati ml de apa vreti sa adaugati?");
    }

    @Override
    public void fillMilk() {
        System.out.println("Cati ml de lapte vreti sa adaugati?");
    }

    @Override
    public void fillBeans() {
        System.out.println("Cate grame de boabe vreti sa adaugati?");
    }

    @Override
    public void fillCups() {
        System.out.println("Cate pahare de cafea vreti sa adaugati?");
    }

    @Override
    public void exit() {
        System.out.println("O zi buna!");
    }

    @Override
    public void incorrect() {
        System.out.println("Va rugam sa repetati comanda.");
    }

    @Override
    public void lowWater() {
        System.out.println("Nu exista suficienta apa in aparat.");
    }

    @Override
    public void lowMilk() {
        System.out.println("Nu exista suficient lapte in aparat.");
    }

    @Override
    public void lowBeans() {
        System.out.println("Nu exista suficiente boabe de cafea in aparat.");
    }

    @Override
    public void lowCups() {
        System.out.println("Nu exista suficiente pahare de cafea in aparat");
    }

    @Override
    public void enoughResources() {
        System.out.println("Avem resurse indeajuns. Va pregatim cafeaua!");
    }
}
