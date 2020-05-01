

import java.util.Scanner;

public class Main
{
    static int waterNow = 400;
    static int milkNow = 540;
    static int  beansNow = 120;
    static int  moneyNow = 550;
    static int cupsNow = 9;
    static boolean running = true;
    public static void updateInventory()
    {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(waterNow + " of water");
        System.out.println(milkNow + " of milk");
        System.out.println(beansNow + " of beans");
        System.out.println(cupsNow + " of disposable cups");
        System.out.println("$" + moneyNow + " of money");
        System.out.println();
    }
    public static void makeEspresso()
    {
        if (waterNow < 250)
        {
            System.out.println("Sorry, not enough water!");
            System.out.println();

        } else if (beansNow < 16)
        {
            System.out.println("Sorry, not enough coffee beans!");
            System.out.println();

        } else {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();

            waterNow = waterNow - 250;
            beansNow = beansNow - 16;
            moneyNow = moneyNow + 4;
            cupsNow = cupsNow - 1;
        }
    }
    public static void makeLatte()
    {
        if (waterNow < 350)
        {
            System.out.println("Sorry, not enough water!");
            System.out.println();

            System.out.println();

        } else if (milkNow < 75)
        {
            System.out.println("Sorry, not enough milk!");
            System.out.println();

            System.out.println();

        } else if (beansNow < 20)
        {
            System.out.println("Sorry, not enough coffee beans!");
            System.out.println();

            System.out.println();

        } else {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();

            System.out.println();
            waterNow = waterNow - 350;
            milkNow = milkNow - 75;
            beansNow = beansNow - 20;
            moneyNow = moneyNow + 7;
            cupsNow = cupsNow - 1;
        }
    }
    public static void makeCappuccino()
    {
        if (waterNow < 200)
        {
            System.out.println("Sorry, not enough water!");
            System.out.println();

        } else if (milkNow < 100)
        {
            System.out.println("Sorry, not enough milk!");
            System.out.println();

        } else if (beansNow < 12)
        {
            System.out.println("Sorry, not enough coffee beans!");
            System.out.println();

        } else
        {
            System.out.println("I have enough resources, making you a coffee!");
            System.out.println();
            waterNow = waterNow - 200;
            milkNow = milkNow - 100;
            beansNow = beansNow - 12;
            moneyNow = moneyNow + 6;
            cupsNow = cupsNow - 1;
        }
    }
    public static void buy()
    {
        System.out.println();
        Scanner buyIn = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        System.out.print(">");
        String selection = buyIn.nextLine();
        System.out.println();
        if (selection.equals("1"))
        {
            makeEspresso();
        } else if (selection.equals("2"))
        {
            makeLatte();
        } else if (selection.equals("3"))
        {
            makeCappuccino();
        } else {
            query();
        }
    }
    public static void fill()
    {
        System.out.println();
        Scanner fillIn = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        System.out.print(">");
        waterNow = waterNow + fillIn.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        System.out.print(">");
        milkNow = milkNow + fillIn.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        System.out.print(">");
        beansNow = beansNow +  fillIn.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        System.out.print(">");
        cupsNow = cupsNow + fillIn.nextInt();
    }
    public static void take()
    {
        System.out.println("I gave you $" + moneyNow);
        System.out.println();
        moneyNow = 0;
    }

    public static void exit()
    {
        running = false;
    }
    public static void query()
    {
        Scanner queryIn = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        System.out.print(">");
        String action = queryIn.nextLine();
        if (action.equals("buy"))
        {
            buy();
        } else if (action.equals("fill"))
        {
            fill();
        } else if (action.equals("take"))
        {

            take();
        } else if (action.equals("remaining"))
        {
            updateInventory();
        } else {
            exit();
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while (running)
        {
            query();
        }
    }
}