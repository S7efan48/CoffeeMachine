import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please select your language: 1 - english, 2 - romanian.");
        int selection = sc.nextInt();
        sc.nextLine();

        CoffeeMachine machine;
        if (selection == 1){
            machine = new CoffeeMachine(new EnglishStringConstants());
        }
        else {
            machine = new CoffeeMachine(new RomanianStringConstants());
            }

        while (machine.isRunning()) {
        String input = sc.nextLine();
        machine.execute(input);
        }
    }

}
