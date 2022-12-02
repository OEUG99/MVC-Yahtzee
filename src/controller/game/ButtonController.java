package controller.game;

import model.MainModel;
import view.game.MainView;

import java.awt.*;
import java.awt.event.ActionEvent;

public class ButtonController extends AbstractControllerListener {

    private int rollsLeft = 3;

    private MusicController musicController;

    private MainController controller;

    public ButtonController(MainView view, MainModel model, MainController controller) {
        super(view, model);
        this.controller = controller;
        musicController = controller.getMusicController();
    }


    boolean scoreBoardPressed = false;

    public boolean getScoreBoardPressed() {
        return scoreBoardPressed;
    }

    public void changeScoreBoardPressed(){
        scoreBoardPressed = false;
    }

    // Very messy brute force variables for storing scores
    public int onesFinal = 0;
    public int twosFinal = 0;
    public int threesFinal = 0;
    public int foursFinal = 0;
    public int fivesFinal = 0;
    public int sixesFinal = 0;
    public int bonusFinal = 0;
    public int topTotalFinal = 0;
    public int threeOfAKindFinal = 0;
    public int fourOfAKindFinal = 0;
    public int fullHouseFinal = 0;
    public int smallStraitFinal = 0;
    public int largeStraitFinal = 0;
    public int yahtzeeFinal = 0;
    public int chanceFinal = 0;
    public int botTotalFinal = 0;
    public int grandTotalFinal = 0;

    // For calcing the uninteractible buttons on the scoreboard
    public void calcTotals() {
 
        // Top bonus
        bonusFinal = ( onesFinal + twosFinal + threesFinal + foursFinal + fivesFinal + sixesFinal );
        if ( bonusFinal >= 63 ){
            bonusFinal = 35;
        }
        else {
            bonusFinal = 0;
        }
        view.getScoreboardView().getScoreContainerView().getScoreArray()[6].getScoreButton().setText("" + bonusFinal);
        view.getScoreboardView().getScoreContainerView().getScoreArray()[6].getScoreButton().setEnabled(false);

        // Top total
        topTotalFinal = ( onesFinal + twosFinal + threesFinal + foursFinal + fivesFinal + sixesFinal + bonusFinal );
        view.getScoreboardView().getScoreContainerView().getScoreArray()[7].getScoreButton().setText("" + topTotalFinal);
        view.getScoreboardView().getScoreContainerView().getScoreArray()[7].getScoreButton().setEnabled(false);

        // Bot total
        botTotalFinal = ( threeOfAKindFinal + fourOfAKindFinal + fullHouseFinal + smallStraitFinal + largeStraitFinal + yahtzeeFinal + chanceFinal );
        view.getScoreboardView().getScoreContainerView().getScoreArray()[15].getScoreButton().setText("" + botTotalFinal);
        view.getScoreboardView().getScoreContainerView().getScoreArray()[15].getScoreButton().setEnabled(false);

        // Grand total
        grandTotalFinal = ( topTotalFinal + botTotalFinal );
        view.getScoreboardView().getScoreContainerView().getScoreArray()[16].getScoreButton().setText("" + grandTotalFinal);
        view.getScoreboardView().getScoreContainerView().getScoreArray()[16].getScoreButton().setEnabled(false);

        model.getScoreModel(model.getCurPlayer()).setArrayValue(6, bonusFinal);
        model.getScoreModel(model.getCurPlayer()).setArrayValue(7, topTotalFinal);
        model.getScoreModel(model.getCurPlayer()).setArrayValue(15, botTotalFinal);
        model.getScoreModel(model.getCurPlayer()).setArrayValue(16, grandTotalFinal);
    }

    public void actionPerformed(ActionEvent e) {

        // if the button is the one in the DiceRowContainer
        if (e.getSource() == view.getDiceContainer().getButton()) {

            // play sound effect from music controller
            musicController.playRollSound();

            rollsLeft--;
            view.getDiceContainer().getButton().setText("rolls Left: " + rollsLeft);

            if (rollsLeft == 0) { // todo make it show the scorebuttons are always usable but change turns
                view.getDiceContainer().getButton().setEnabled(false);


            }

            model.gameStarted = true; // if we roll all the dice, we know the game started.

            // enable all 15 of the scores
            for (int i = 0; i < 15; i++) {
                if (i != 6 && i != 7) { // we ignore 6 and 7th
                    if (view.getScoreboardView().getScoreContainerView().getScoreArray()[i].getScoreHere() == "Score here."){
                        view.getScoreboardView().getScoreContainerView().getScoreArray()[i].getScoreButton().setEnabled(true);
                    }
                }
            }


            // roll every dice
            for (int i = 0; i < 5; i++) {


                model.getDice(i).roll();
                // fancy large arial font
                view.getDiceContainer().getDice(i).getDiceLabel().setFont(new Font("Arial", Font.BOLD, 32));

                if(model.getFancyDiceMode()){
                    view.getDiceContainer().getDice(i).setFancyDice(Integer.parseInt(model.getDice(i).getValue()));
                } else {
                    view.getDiceContainer().getDice(i).setDiceText(model.getDice(i).getValue());
                }

            }
        }

        // temporary, incredibly messy brute force code for storing variables for algorithms
        int onesCalc = 0;
        int twosCalc = 0;
        int threesCalc = 0;
        int foursCalc = 0;
        int fivesCalc = 0;
        int sixesCalc = 0;
        int threeOfAKindCalc = 0;
        int fourOfAKindCalc = 0;
        int fullHouseCalc = 0;
        int smallStraitCalc = 0;
        int largeStraitCalc = 0;
        int yahtzeeCalc = 0;
        int chanceCalc = 0;



        // Ones
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[0].getScoreButton()) {
            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 1) {
                    onesCalc += 1;
                }
            }
            view.getScoreboardView().getScoreContainerView().getScoreArray()[0].getScoreButton().setText("" + onesCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[0].getScoreButton().setEnabled(false);
            onesFinal = onesCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(0, onesFinal);
        }

        // Twos
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[1].getScoreButton()) {
            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 2) {
                    twosCalc += 2;
                }
            }
            view.getScoreboardView().getScoreContainerView().getScoreArray()[1].getScoreButton().setText("" + twosCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[1].getScoreButton().setEnabled(false);
            twosFinal = twosCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(1, twosFinal);
        }

        // Threes
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[2].getScoreButton()) {
            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 3) {
                    threesCalc += 3;
                }
            }
            view.getScoreboardView().getScoreContainerView().getScoreArray()[2].getScoreButton().setText("" + threesCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[2].getScoreButton().setEnabled(false);
            threesFinal = threesCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(2, threesFinal);
        }

        // Fours
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[3].getScoreButton()) {
            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 4) {
                    foursCalc += 4;
                }
            }
            view.getScoreboardView().getScoreContainerView().getScoreArray()[3].getScoreButton().setText("" + foursCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[3].getScoreButton().setEnabled(false);
            foursFinal = foursCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(3, foursFinal);
        }

        // Fives
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[4].getScoreButton()) {
            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 5) {
                    fivesCalc += 5;
                }
            }
            view.getScoreboardView().getScoreContainerView().getScoreArray()[4].getScoreButton().setText("" + fivesCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[4].getScoreButton().setEnabled(false);
            fivesFinal = fivesCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(4, fivesFinal);
        }

        // Sixes
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[5].getScoreButton()) {
            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 6) {
                    sixesCalc += 6;
                }
            }
            view.getScoreboardView().getScoreContainerView().getScoreArray()[5].getScoreButton().setText("" + sixesCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[5].getScoreButton().setEnabled(false);
            sixesFinal = sixesCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(5, sixesFinal);
        }

        // Three of a kind
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[8].getScoreButton()) {
            Boolean threeSame = false;
            int score1 = 0;
            int score2 = 0;
            int score3 = 0;
            int score4 = 0;
            int score5 = 0;
            int score6 = 0;

            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 1) {
                    score1++;
                }
                if (temp == 2) {
                    score2++;
                }
                if (temp == 3) {
                    score3++;
                }
                if (temp == 4) {
                    score4++;
                }
                if (temp == 5) {
                    score5++;
                }
                if (temp == 6) {
                    score6++;
                }
                threeOfAKindCalc += temp;
            }

            if (score1 >= 3 || score2 >= 3 || score3 >= 3 || score4 >= 3 || score5 >= 3 || score6 >= 3) {
                threeSame = true;
            }

            if (threeSame == false) {
                threeOfAKindCalc = 0;
            }

            view.getScoreboardView().getScoreContainerView().getScoreArray()[8].getScoreButton().setText("" + threeOfAKindCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[8].getScoreButton().setEnabled(false);
            threeOfAKindFinal = threeOfAKindCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(8, threeOfAKindFinal);
        }

        // Four of a kind
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[9].getScoreButton()) {
            Boolean fourSame = false;
            int score1 = 0;
            int score2 = 0;
            int score3 = 0;
            int score4 = 0;
            int score5 = 0;
            int score6 = 0;

            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 1) {
                    score1++;
                }
                if (temp == 2) {
                    score2++;
                }
                if (temp == 3) {
                    score3++;
                }
                if (temp == 4) {
                    score4++;
                }
                if (temp == 5) {
                    score5++;
                }
                if (temp == 6) {
                    score6++;
                }
                fourOfAKindCalc += temp;
            }

            if (score1 >= 4 || score2 >= 4 || score3 >= 4 || score4 >= 4 || score5 >= 4 || score6 >= 4) {
                fourSame = true;
            }

            if (fourSame == false) {
                fourOfAKindCalc = 0;
            }

            view.getScoreboardView().getScoreContainerView().getScoreArray()[9].getScoreButton().setText("" + fourOfAKindCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[9].getScoreButton().setEnabled(false);
            fourOfAKindFinal = fourOfAKindCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(9, fourOfAKindFinal);
        }

        // Full house
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[10].getScoreButton()) {
            int score1 = 0;
            int score2 = 0;
            int score3 = 0;
            int score4 = 0;
            int score5 = 0;
            int score6 = 0;

            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 1) {
                    score1++;
                }
                if (temp == 2) {
                    score2++;
                }
                if (temp == 3) {
                    score3++;
                }
                if (temp == 4) {
                    score4++;
                }
                if (temp == 5) {
                    score5++;
                }
                if (temp == 6) {
                    score6++;
                }
            }

            if ( (score1 == 2 && score2 == 3) || (score1 == 2 && score3 == 3) || (score1 == 2 && score4 == 3) || (score1 == 2 && score5 == 3) || (score1 == 2 && score6 == 3) || (score2 == 2 && score1 == 3) || (score2 == 2 && score3 == 3) || (score2 == 2 && score4 == 3) || (score2 == 2 && score5 == 3) || (score2 == 2 && score6 == 3) || (score3 == 2 && score1 == 3) || (score3 == 2 && score2 == 3) || (score3 == 2 && score4 == 3) || (score3 == 2 && score5 == 3) || (score3 == 2 && score6 == 3) || (score4 == 2 && score1 == 3) || (score4 == 2 && score2 == 3) || (score4 == 2 && score3 == 3) || (score4 == 2 && score5 == 3) || (score4 == 2 && score6 == 3) || (score5 == 2 && score1 == 3) || (score5 == 2 && score2 == 3) || (score5 == 2 && score3 == 3) || (score5 == 2 && score4 == 3) || (score5 == 2 && score6 == 3) || (score6 == 2 && score1 == 3) || (score6 == 2 && score2 == 3) || (score6 == 2 && score3 == 3) || (score6 == 2 && score4 == 3) || (score6 == 2 && score5 == 3)) {
                fullHouseCalc = 25;
            }

            view.getScoreboardView().getScoreContainerView().getScoreArray()[10].getScoreButton().setText("" + fullHouseCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[10].getScoreButton().setEnabled(false);
            fullHouseFinal = fullHouseCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(10, fullHouseFinal);
        }

        // Small strait
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[11].getScoreButton()) {
            int score1 = 0;
            int score2 = 0;
            int score3 = 0;
            int score4 = 0;
            int score5 = 0;
            int score6 = 0;

            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 1) {
                    score1++;
                }
                if (temp == 2) {
                    score2++;
                }
                if (temp == 3) {
                    score3++;
                }
                if (temp == 4) {
                    score4++;
                }
                if (temp == 5) {
                    score5++;
                }
                if (temp == 6) {
                    score6++;
                }
            }

            if ( (score1 >= 1 && score2 >= 1 && score3 >= 1 && score4 >= 1) || (score2 >= 1 && score3 >= 1 && score4 >= 1 && score5 >= 1) || (score3 >= 1 && score4 >= 1 && score5 >= 1 && score6 >=1)) {
                smallStraitCalc = 30;
            }

            view.getScoreboardView().getScoreContainerView().getScoreArray()[11].getScoreButton().setText("" + smallStraitCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[11].getScoreButton().setEnabled(false);
            smallStraitFinal = smallStraitCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(11, smallStraitFinal);
        }

        // Large strait
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[12].getScoreButton()) {
            int score1 = 0;
            int score2 = 0;
            int score3 = 0;
            int score4 = 0;
            int score5 = 0;
            int score6 = 0;

            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 1) {
                    score1++;
                }
                if (temp == 2) {
                    score2++;
                }
                if (temp == 3) {
                    score3++;
                }
                if (temp == 4) {
                    score4++;
                }
                if (temp == 5) {
                    score5++;
                }
                if (temp == 6) {
                    score6++;
                }
            }

            if ( (score1 == 1 && score2 == 1 && score3 == 1 && score4 == 1 && score5 == 1) || (score2 == 1 && score3 == 1 && score4 == 1 && score5 == 1 && score6 == 1)) {
                largeStraitCalc = 40;
            }

            view.getScoreboardView().getScoreContainerView().getScoreArray()[12].getScoreButton().setText("" + largeStraitCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[12].getScoreButton().setEnabled(false);
            largeStraitFinal = largeStraitCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(12, largeStraitFinal);
        }

        // Yahtzee
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[13].getScoreButton()) {
            int score1 = 0;
            int score2 = 0;
            int score3 = 0;
            int score4 = 0;
            int score5 = 0;
            int score6 = 0;

            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                if (temp == 1) {
                    score1++;
                }
                if (temp == 2) {
                    score2++;
                }
                if (temp == 3) {
                    score3++;
                }
                if (temp == 4) {
                    score4++;
                }
                if (temp == 5) {
                    score5++;
                }
                if (temp == 6) {
                    score6++;
                }
            }

            if ( score1 == 5 || score2 == 5 || score3 == 5 || score4 == 5 || score5 == 5 || score6 == 5) {
                yahtzeeCalc = 50;
            }

            view.getScoreboardView().getScoreContainerView().getScoreArray()[13].getScoreButton().setText("" + yahtzeeCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[13].getScoreButton().setEnabled(false);
            yahtzeeFinal = yahtzeeCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(13, yahtzeeFinal);
        }

        // Chance
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[14].getScoreButton()) {
            for (int i = 0; i < 5; i++) {
                int temp = Integer.parseInt(model.getDice(i).getValue());
                chanceCalc += temp;
            }
            view.getScoreboardView().getScoreContainerView().getScoreArray()[14].getScoreButton().setText("" + chanceCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[14].getScoreButton().setEnabled(false);
            chanceFinal = chanceCalc;
            scoreBoardPressed = true;
            disableScoreButtons();
            calcTotals();
            model.getScoreModel(model.getCurPlayer()).setArrayValue(14, chanceFinal);
        }

        //
        System.out.println(e.getSource());


    }

    public int returnRolls() {
        return rollsLeft;
    }

    /**
     * Called from the main controller, whenever a turn is over.
     */
    public void resetRollButton() {
        rollsLeft = 3;
        view.getDiceContainer().getButton().setEnabled(true);
        view.getDiceContainer().getButton().setText("Roll Me!");
        musicController.playSound("sounds/voicelines/next_turn.wav", false, true);

    }

    public void disableScoreButtons(){
        for (int i = 0; i < 15; i++) {
            if (i != 6 && i != 7) { // we ignore 6 and 7th
                if (view.getScoreboardView().getScoreContainerView().getScoreArray()[i].getScoreHere() == "Score here."){
                    view.getScoreboardView().getScoreContainerView().getScoreArray()[i].getScoreButton().setEnabled(false);
                }
            }
        }

       controller.changeTurn();

    }
}
