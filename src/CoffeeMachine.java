public class CoffeeMachine {// aici se defineste tot ce ARE si tot ce FACE FIECARE aparat de cafea
    private int water;//apa pe care o ARE FIECARE aparat de cafea
    private int milk;//laptele pe care il ARE FIECARE aparat de cafea
    private int coffeeBeans;//boabele de cafe pe care le ARE FIECARE aparat de cafea
    private int cups;//paharele pe care le ARE FIECARE aparat de cafea
    private int money;// banii incasati de FIECARE aparat de cafea
    private StateMachine currentState;//starea in care se afla FIECARE aparat de cafea (acesta este un indiciu despre ce face aparatul in fiecare moment de timp
    private StringConstants constants;

    CoffeeMachine(StringConstants constants) {// constructorul se apeleaza din main de fiecare data cand instantiem un obiect
        //rolul constructorului este sa stabileasca care sunt valorile initiale ale tuturor variabilelor de mai sus
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        cups = 9;
        money = 550;
        this.constants = constants;
        printChoosingOptionMenu();// starea initiala va fi choosingOption
    }
    //de aici in jos urmeaza sa definim toate operatiile pe care FIECARE masina le FACE

    public void printChoosingOptionMenu() {
        //afisarea asta sa fie facuta in asa fel incat sa mearga si pentru ConsoleOutput si pentru FileOutput
        //polimorfism
        constants.choosingMainMenuOption();
        currentState = StateMachine.CHOOSING_OPTION;
    }

    public void choosingAction(String input)
    {
        switch(input)
        {
            case "buy":
                constants.choosingCoffee();
                currentState = StateMachine.CHOOSING_COFFEE_TYPE;
                break;
            case "fill":
                constants.fillWater();
                currentState = StateMachine.FILL_WATER;
                break;
            case "take":
                take();
                printChoosingOptionMenu();
                break;
            case "remaining":
                constants.printSupplies(water,milk,coffeeBeans,cups,money);
                printChoosingOptionMenu();
                break;
            case "exit":
                constants.exit();
                currentState = StateMachine.EXIT;
                break;
            default:
                constants.incorrect();
                printChoosingOptionMenu();
        }
    }

    public void makeCoffeeIfPossible(int water, int milk, int coffeeBeans, int cupsOfCoffee, int price) {
        if (this.water < water) {
            constants.lowWater();
            printChoosingOptionMenu();
        }
        else if (this.milk < milk) {
            constants.lowMilk();
            printChoosingOptionMenu();
        }
        else if (this.coffeeBeans < coffeeBeans) {
            constants.lowBeans();
            printChoosingOptionMenu();
        }
        else if (cups == 0) {
            constants.lowCups();
            printChoosingOptionMenu();
        }
        else {
            constants.enoughResources();
            this.water -= water;
            this.milk -= milk;
            this.coffeeBeans -= coffeeBeans;
            cups -= 1;
            money += price;
            printChoosingOptionMenu();
        }
    }

    public void take() {
        constants.takeMoney(money);
        money = 0;
    }

    public void choosingCoffee( String input){
        switch (input){
            case "1":
                makeCoffeeIfPossible(CoffeeType.ESPRESSO.requiredWater, CoffeeType.ESPRESSO.requiredMilk,
                        CoffeeType.ESPRESSO.requiredCoffeeBeans, CoffeeType.ESPRESSO.requiredCups, CoffeeType.ESPRESSO.price);
                break;
            case "2":
                makeCoffeeIfPossible(CoffeeType.LATTE.requiredWater, CoffeeType.LATTE.requiredMilk,
                        CoffeeType.LATTE.requiredCoffeeBeans, CoffeeType.LATTE.requiredCups, CoffeeType.LATTE.price);
                break;
            case "3":
                makeCoffeeIfPossible(CoffeeType.CAPPUCCINO.requiredWater, CoffeeType.CAPPUCCINO.requiredMilk,
                        CoffeeType.CAPPUCCINO.requiredCoffeeBeans, CoffeeType.CAPPUCCINO.requiredCups, CoffeeType.CAPPUCCINO.price);
                break;
            case "back":
                printChoosingOptionMenu();
                break;
            default:
                constants.incorrect();
                constants.choosingCoffee();
        }
    }

    public void fillWater(String input){
        water += Integer.parseInt(input);
        currentState = StateMachine.FILL_MILK;
        constants.fillMilk();
    }

    public void fillMilk(String input) {
        milk += Integer.parseInt(input);
        currentState = StateMachine.FILL_COFFEE_BEANS;
        constants.fillBeans();
    }

    public void fillBeans(String input) {
        coffeeBeans += Integer.parseInt(input);
        currentState = StateMachine.FILL_CUPS;
        constants.fillCups();
    }

    public void fillCups(String input){
        cups += Integer.parseInt(input);
        printChoosingOptionMenu();
    }

    public void execute(String input){
        // verific starea in care ma aflu si in functie de comanda primita execut comanda si tranzitionez catre o noua stare
        if (currentState == StateMachine.CHOOSING_OPTION)
            choosingAction(input);
        else if (currentState == StateMachine.CHOOSING_COFFEE_TYPE)
            choosingCoffee(input);
        else if (currentState == StateMachine.FILL_WATER)
            fillWater(input);
        else if (currentState == StateMachine.FILL_MILK)
            fillMilk(input);
        else if (currentState == StateMachine.FILL_COFFEE_BEANS)
            fillBeans(input);
        else if (currentState == StateMachine.FILL_CUPS)
            fillCups(input);
    }

    public boolean isRunning(){
        return currentState != StateMachine.EXIT;
    }

}
