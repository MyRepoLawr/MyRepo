package machine;
import java.util.Scanner;
import static java.lang.System.*;

public class MyCoffeeMachine {
    private int water;
    private int milk;
    private int coffee;
    private int cups;
    private int money;

    public MyCoffeeMachine() {
        water = 400;
        milk = 540;
        coffee = 120;
        cups = 9;
        money = 550;
    }
    public MyCoffeeMachine(int water, int milk, int coffee, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.money = money;
    }
    public void displayMachine(){
        out.println("The coffee machine has:");
        out.printf("%d of water\n%d of milk\n%d of coffee beans\n", water, milk, coffee);
        out.printf("%d of disposable cups\n$%d of money \n",cups, money);
    }
    public int summa(int a, int b){
        return a + b;
    }
    public int razn(int a, int b){
        return a - b;
    }
    public void fill(){
        Scanner scanner = new Scanner(in);
        out.println("Write how many ml of water do you want to add:");
        int w = scanner.nextInt();
        water = summa(water, w);
        out.println("Write how many ml of milk do you want to add:");
        int m = scanner.nextInt();
        milk = summa(milk, m);
        out.println("Write how many grams of coffee beans do you want to add:");
        int c = scanner.nextInt();
        coffee = summa(coffee, c);
        out.println("Write how many disposable cups of coffee do you want to add:");
        int cup = scanner.nextInt();
        cups = summa(cups, cup);
    }
    public void take(){
        out.printf("I gave you $%d%n",money);
        money = razn(money, money);
    }
    public void buy(){
        Scanner scanner = new Scanner(in);
        out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String num = scanner.nextLine();
        switch (num){
            case "1":
                MyCoffeeMachine tab = new MyCoffeeMachine(250, 0, 16, 1, 4);
                makeCoffee(water, tab.water, milk, tab.milk, coffee, tab.coffee, cups, tab.cups, money, tab.money);
                break;
            case "2":
                tab = new MyCoffeeMachine(350, 75, 20, 1, 7);
                makeCoffee(water, tab.water, milk, tab.milk, coffee, tab.coffee, cups, tab.cups, money, tab.money);
                break;
            case "3":
                tab = new MyCoffeeMachine(200, 100, 12, 1, 6);
                makeCoffee(water, tab.water, milk, tab.milk, coffee, tab.coffee, cups, tab.cups, money, tab.money);
                break;
            default:
                break;
        }
    }
    public void makeCoffee(int w, int w1, int m, int m1, int c, int c1, int cup, int cup1, int many, int many1){
        if(w < w1) {
            out.println("Sorry, not enough water!");
        } else  if ( m < m1) {
            out.println("Sorry, not enough milk!");
        } else if (c < c1) {
            out.println("Sorry, not enough coffee!");
        } else if (cup < cup1) {
            out.println("Sorry, not enough cups!");
        } else {
            water = razn(w, w1);
            milk = razn(m, m1);
            coffee = razn(c, c1);
            cups = razn(cup, cup1);
            money = summa(many, many1);
            out.println("I have enough resources, making you a coffee!");
        }
    }
    public void myCoffeeShow() {
        Scanner scanner = new Scanner(in);
        MyCoffeeMachine myCoffeeMachine = new MyCoffeeMachine();
        String str ="";
        while (!str.equals("exit")) {
            out.println("Write action (buy, fill, take, exit, remaining):");
            str = scanner.nextLine();
            switch (str) {
                case "fill":
                    myCoffeeMachine.fill();
                    break;
                case "take":
                    myCoffeeMachine.take();
                    break;
                case "buy":
                    myCoffeeMachine.buy();
                    break;
                case "exit":
                    break;
                case "remaining":
                    myCoffeeMachine.displayMachine();
                    break;
                default:
                    break;
            }
        }
    }
}
