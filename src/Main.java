import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);
    public static Player ai = new Player();
    public static Player player1 = new Player();
    public static Player player2 = new Player();
    static String[] gameWeapons = {"Rock", "Paper", "Scissor"};
    static int numOfGamesPlayed;
    static boolean singlePlayer;
    static boolean autoPlay;

    static double procentOfRock;
    static double procentOfPaper;
    static double procentOfScissor;

    static void mainMenu(){
        ai.setName("HAL 9000");
        player2.setName("Player 2");
        System.out.println("-------------------------------------");
        System.out.println("|----| ROCK | PAPER | SCISSORS |----|");
        System.out.println("-------------------------------------");

        System.out.println("Welcome");
        System.out.println("Player 1 -> enter your name:");
        player1.setName(scan.next() + scan.nextLine());
        System.out.println("\n");
        boolean run = true;
        while (run) {
        System.out.println("Choose game mode:");
        System.out.println("1) Player vs Player");
        System.out.println("2) Player vs Computer");
        System.out.println("3) View statistics");
        System.out.println("4) Exit program");

            int choice = validateUserIntInput();

            switch (choice) {
                case 1:
                    playerVSPlayer();
                    break;
                case 2:
                    playerVSComp();
                    break;
                case 3:

                    try {
                    Game.printStats(player1);

                    Game.printStats(player2);
                    Game.printStats(ai);
                    }catch(NullPointerException e){
                        System.out.println("There are no stats to show!" +
                                "\nTry playing some games!\n\n");
                    break;
                    }
                case 4:
                    run = false;
                    scan.close();
                    System.out.println("Goodbye");
                    break;
            }
        }
    }

    static void playerVSPlayer() {
        singlePlayer = false;
        System.out.println("-------------------------------------");
        System.out.println("|---------PLAYER VS PLAYER---------|");
        System.out.println("-------------------------------------");
        System.out.println("");

            if(player2.getName().equals("Player 2")){
                System.out.println("Player 2 -> enter your name:");
                player2.setName(scan.next() + scan.nextLine());
            }

        System.out.println("Welcome " + player1.getName() + " & " + player2.getName());

            System.out.println("-----------------------------------");
            System.out.println("1) Play best out of three");
            System.out.println("2) Play best out of five");
            System.out.println("3) Play best out of your choice");
            System.out.println("4) Back to menu");

            int choice = validateUserIntInput();
            if (choice <= 3){
            new Game(choice, true);
            } else if (choice == 4){
                mainMenu();
            }


    }

    static void playerVSComp() {
        singlePlayer = true;
        System.out.println("-------------------------------------");
        System.out.println("|---------PLAYER VS COMPUTER---------|");
        System.out.println("-------------------------------------");
        System.out.println("AI speaks --> Who dare wake me from my slumber?");

        System.out.println("Oh It's you! Welcome " + player1.getName() +
                "\n");

            System.out.println("-----------------------------------");
            System.out.println("1) Play best out of three");
            System.out.println("2) Play best out of five");
            System.out.println("3) Play best out of your choice");
            System.out.println("4) Autoplay random number of games");
            System.out.println("5) Back to menu");

        int choice = validateUserIntInput();
        if (choice <= 4){
            new Game(choice, false);
        } else if (choice == 5){
            mainMenu();
        }
    }






    static int validateUserIntInput(){
        int returnNum = 0;
        boolean run = true;
        while (run) {
            try {
                returnNum = scan.nextInt();
                run = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! try a number");
                scan.next();
            }
        }
        return returnNum;
    }



    public static void main(String[] args) {


        mainMenu();



            /*
            play a hand
            add to weapon choice
            determine a winner
             */






    }
}
