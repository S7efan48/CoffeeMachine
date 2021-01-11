public enum CoffeeType {
    ESPRESSO(250,0,16,1,4),
    LATTE(350,75,20,1,7),
    CAPPUCCINO(200,100,12,1,6);

    public int requiredWater;
    public int requiredMilk;
    public int requiredCoffeeBeans;
    public int requiredCups;
    public int price;

    CoffeeType(int requiredWater, int requiredMilk, int requiredCoffeeBeans, int requiredCups, int price) {
        this.requiredWater = requiredWater;
        this.requiredMilk = requiredMilk;
        this.requiredCoffeeBeans = requiredCoffeeBeans;
        this.requiredCups = requiredCups;
        this.price = price;
    }
}
