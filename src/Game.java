public class Game {

    public static String[] gameWeapons = {"Rock", "Paper", "Scissor"};
    public static boolean autoPlay;
    public static boolean twoPlayers;

    public static int numOfSinglePlayerGamesPlayed;
    public static int numOfMultiPlayerGamesPlayed;

    Game(int gameMode, boolean twoPlayers){
        autoPlay = false;
        this.twoPlayers = twoPlayers;

        switch (gameMode){
            case 1:
                playNumOfGames(3, twoPlayers);
                break;
            case 2:
                playNumOfGames(5, twoPlayers);
                break;
            case 3:
                System.out.println("How many games should be played?");
                int numOfGames = Main.validateUserIntInput();
                playNumOfGames(numOfGames, twoPlayers);
                break;
            case 4:
                autoPlay = true;
                System.out.println("How many games should be played?");
                int numOfAutoGames = Main.validateUserIntInput();
                playNumOfGames(numOfAutoGames, false);
                break;
        }
    }

    static void playNumOfGames(int numOfGamesToPlay, Boolean twoPlayer){
        System.out.println("---------------------------------");
        System.out.println("-----BEST OF " + numOfGamesToPlay + "------");
        System.out.println("---------------------------------");

        String weaponChoice = "choose your weapon";

        printWeapons();

        for (int i = 0; i < numOfGamesToPlay; i++) {
            System.out.println("-------round " + (i + 1) + "---------");
            if (autoPlay){
                int randomNum = (int) ((Math.random() * 3) + 1);
                playerChoice(Main.player1, randomNum);
                generateRandomAIRespons();
                validateWinner(Main.ai);
                updateStats(Main.player1);
            }else if (!autoPlay && !twoPlayer){
                System.out.println(Main.player1.getName() + " " + weaponChoice);
                playerChoice(Main.player1, Main.validateUserIntInput());
                generateRandomAIRespons();
                validateWinner(Main.ai);
                updateStats(Main.player1);

            }else if (twoPlayer){

                System.out.println(Main.player1.getName() + " " + weaponChoice);
                playerChoice(Main.player1, Main.validateUserIntInput());
                System.out.println(Main.player2.getName() + " " + weaponChoice);
                playerChoice(Main.player2, Main.validateUserIntInput());
                validateWinner(Main.player2);
                updateStats(Main.player1);

            }

        }

    }

    public static void printWeapons(){
        int count = 1;
        for (String weapon : gameWeapons) {
            System.out.println(count + ") --> " + weapon);
            count++;
        }
    }

    static void updateStats(Player player){


            if (twoPlayers){
                numOfMultiPlayerGamesPlayed ++;
            }else if (!twoPlayers){
            numOfSinglePlayerGamesPlayed ++;

            }
/*
            Main.procentOfRock = ((double) player.getRockChoiceCount() / numOfGamesPlayed) * 100;
            Main.procentOfPaper = ((double) player.getPaperChoiceCount() / numOfGamesPlayed) * 100;
            Main.procentOfScissor = ((double) player.getScissorChoiceCount() / numOfGamesPlayed) * 100;
            */


    }

    static void playerChoice(Player player, int choice) {
        while (true){
            try{
                if (choice <= gameWeapons.length && choice > 0) {
                    player.setWeapon(choice - 1);
                    player.addToWeaponTimesChosenStats(player.getCurrentWeapon());
                    break;
                }
            } catch(IndexOutOfBoundsException noWeaponAtIndex){
                System.out.println("No such weapon! try again");
            }

        }
    }

    static void generateRandomAIRespons(){
        int randomNum = (int) (Math.random()*3);
        Main.ai.setWeapon(randomNum);
    }

     static void validateWinner(Player player2orAI){

        String playerWins = Main.player1.getCurrentWeapon() + " beats " + player2orAI.getCurrentWeapon() +
                "\n" + Main.player1.getName().toUpperCase() + " WINS\n";
        String aIorPlayer2Wins = player2orAI.getCurrentWeapon() + " beats " + Main.player1.getCurrentWeapon() +
                "\n" + player2orAI.getName().toUpperCase() + " WINS\n";


        System.out.println(Main.player1.getName() + " played     --> " + Main.player1.getCurrentWeapon());
        System.out.println(player2orAI.getName() + " played  --> " + player2orAI.getCurrentWeapon());

        if(player2orAI.getCurrentWeapon().equals(Main.player1.getCurrentWeapon())){
            System.out.println("STALEMATE\n");
        }else if(player2orAI.getCurrentWeapon().equals("Rock") && Main.player1.getCurrentWeapon().equals("Paper")){
            Main.player1.addToWeaponTimesWonStats(Main.player1.getCurrentWeapon());
            System.out.println(playerWins);
            Main.player1.addToWeaponTimesWonStats(Main.player1.getCurrentWeapon());
        }else if(player2orAI.getCurrentWeapon().equals("Rock") && Main.player1.getCurrentWeapon().equals("Scissor")){
            player2orAI.addToWeaponTimesWonStats(player2orAI.getCurrentWeapon());
            System.out.println(aIorPlayer2Wins);
            player2orAI.addToWeaponTimesWonStats(player2orAI.getCurrentWeapon());
        }else if(player2orAI.getCurrentWeapon().equals("Paper") && Main.player1.getCurrentWeapon().equals("Rock")){
            player2orAI.addToWeaponTimesWonStats(player2orAI.getCurrentWeapon());
            System.out.println(aIorPlayer2Wins);
            player2orAI.addToWeaponTimesWonStats(player2orAI.getCurrentWeapon());
        }else if(player2orAI.getCurrentWeapon().equals("Scissor") && Main.player1.getCurrentWeapon().equals("Rock")){
            Main.player1.addToTimesWonWithRock();
            System.out.println(playerWins);
            Main.player1.addToWeaponTimesWonStats(Main.player1.getCurrentWeapon());
        }else if(player2orAI.getCurrentWeapon().equals("Paper") && Main.player1.getCurrentWeapon().equals("Scissor")){
            Main.player1.addToWeaponTimesWonStats(Main.player1.getCurrentWeapon());
            System.out.println(playerWins);
            Main.player1.addToWeaponTimesWonStats(Main.player1.getCurrentWeapon());
        }else if(player2orAI.getCurrentWeapon().equals("Scissor") && Main.player1.getCurrentWeapon().equals("Paper")){
            player2orAI.addToWeaponTimesWonStats(player2orAI.getCurrentWeapon());
            System.out.println(aIorPlayer2Wins);
            player2orAI.addToWeaponTimesWonStats(player2orAI.getCurrentWeapon());
        }
    }

    public static void printStats(Player player){

        System.out.println("-------------------------------------");
        System.out.println("|----------| STATISTICS |-----------|");
        System.out.println("-----------| FOR " + player.getName().toUpperCase() + " |-------------|");
        if (twoPlayers){
            System.out.println(numOfMultiPlayerGamesPlayed + " games played in total!");
        } else if (!twoPlayers){
            System.out.println(numOfSinglePlayerGamesPlayed + " games played in total!");
        }
        System.out.println(player.getName() + " won " + player.getTimesWonTotal() + " times");


        System.out.println("Played " + gameWeapons[0] + " " +
                player.getRockChoiceCount() + " times (" +
                String.format("%.2f", Main.procentOfRock) + "%)");
        System.out.println("Played " + gameWeapons[1] + " " +
                player.getPaperChoiceCount() + " times (" +
                String.format("%.2f", Main.procentOfPaper) + "%)");
        System.out.println("Played " + gameWeapons[2] + " " +
                player.getScissorChoiceCount() + " times (" +
                String.format("%.2f", Main.procentOfScissor) + "%)");
        System.out.println("---------------------------------------");
        System.out.println("The weapon with most winnings was: " + player.getMostWinningWeapon());
    }

}
