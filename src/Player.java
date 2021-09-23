public class Player {

    private String name;
    private final String[] weaponsToChoseFrom = { "Rock", "Paper", "Scissor"};
    private String currentWeapon;
    private int rockChoiceCount, paperChoiceCount, scissorChoiceCount;
    private int timesWonWithRock, timesWonWithPaper, timesWonWithScissor;
    private int timesWonBestOfThree, timesWonBestOfFive, timesWonBestOfPlayerChoice, timesWonAutoPlay;
    private String weaponOfChoice;

    Player(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setWeapon(int indexNum){
        currentWeapon = weaponsToChoseFrom[indexNum];
    }

    public String getCurrentWeapon(){
        return currentWeapon;
    }

    public int getRockChoiceCount() {
        return rockChoiceCount;
    }

    public void addToRockChoiceCount() {
        this.rockChoiceCount ++;
    }

    public int getPaperChoiceCount() {
        return paperChoiceCount;
    }

    public void addToPaperChoiceCount() {
        this.paperChoiceCount ++;
    }

    public int getScissorChoiceCount() {
        return scissorChoiceCount;
    }

    public void addToScissorChoiceCount() {
        this.scissorChoiceCount ++;
    }

    public int getTimesWonWithRock() {
        return timesWonWithRock;
    }

    public void addToTimesWonWithRock() {
        this.timesWonWithRock ++;
    }

    public int getTimesWonWithPaper() {
        return timesWonWithPaper;
    }

    public void addToTimesWonWithPaper() {
        this.timesWonWithPaper ++;
    }

    public int getTimesWonWithScissor() {
        return timesWonWithScissor;
    }

    public void addToTimesWonWithScissor() {
        this.timesWonWithScissor ++;
    }

    public int getTimesWonBestOfThree() {
        return timesWonBestOfThree;
    }

    public void addToTimesWonBestOfThree() {
        this.timesWonBestOfThree ++;
    }

    public int getTimesWonBestOfFive() {
        return timesWonBestOfFive;
    }

    public void addToTimesWonBestOfFive() {
        this.timesWonBestOfFive ++;
    }

    public int getTimesWonBestOfPlayerChoice() {
        return timesWonBestOfPlayerChoice;
    }

    public void addToTimesWonBestOfPlayerChoice() {
        this.timesWonBestOfPlayerChoice ++;
    }

    public int getTimesWonAutoPlay() {
        return timesWonAutoPlay;
    }

    public void addToTimesWonAutoPlay() {
        this.timesWonAutoPlay ++;
    }

    public String getWeaponOfChoice() {
        return weaponOfChoice;
    }

    public void setWeaponOfChoice(String weaponOfChoice) {
        this.weaponOfChoice = weaponOfChoice;
    }

    public String getMostWinningWeapon() {
        String mostWinningWeapon = "";
        int[] weaponWinnings = {timesWonWithRock, timesWonWithPaper, timesWonWithScissor};
        int temp = 0;
        for (int i = 0; i < 3; i++) {
            if (weaponWinnings[i] > temp){
                mostWinningWeapon = weaponsToChoseFrom[i];
            }
        }

        return mostWinningWeapon;
    }

    public int getTimesWonTotal(){
        return timesWonWithRock + timesWonWithPaper + timesWonWithScissor;
    }
    public void addToWeaponTimesChosenStats(String weapon){
        switch (weapon){
            case "Rock":
                rockChoiceCount ++;
                break;
            case "Paper":
                paperChoiceCount ++;
                break;
            case "Scissor":
                scissorChoiceCount ++;
                break;
        }
    }

    public void addToWeaponTimesWonStats(String weapon){
        switch (weapon){
            case "Rock":
                timesWonWithRock ++;
                break;
            case "Paper":
                timesWonWithPaper ++;
                break;
            case "Scissor":
                timesWonWithScissor ++;
                break;
        }
    }

}


