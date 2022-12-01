package controller.game;

import model.MainModel;
import view.game.MainView;

import java.awt.event.ActionEvent;

public class ButtonController extends AbstractControllerListener {

    private int rollsLeft = 3;

    private MusicController musicController;

    public ButtonController(MainView view, MainModel model, MainController controller) {
        super(view, model);
        musicController = controller.getMusicController();
    }

    /**
     * Called from the main controller, whenever a turn is over.
     */
    public void resetRollButton() {
        rollsLeft = 3;
        view.getDiceContainer().getButton().setEnabled(true);

    }

    // Veyr messy brute force variables for storing scores
    int onesFinal = 0;
    int twosFinal = 0;
    int threesFinal = 0;
    int foursFinal = 0;
    int fivesFinal = 0;
    int sixesFinal = 0;
    int bonusFinal = 0;
    int topTotalFinal = 0;
    int threeOfAKindFinal = 0;
    int fourOfAKindFinal = 0;
    int fullHouseFinal = 0;
    int smallStraitFinal = 0;
    int largeStraitFinal = 0;
    int yahtzeeFinal = 0;
    int chanceFinal = 0;
    int botTotalFinal = 0;
    int grandTotalFinal = 0;

    public void actionPerformed(ActionEvent e) {

        // if the button is the one in the DiceRowContainer
        if (e.getSource() == view.getDiceContainer().getButton()) {

            // play sound effect from music controller
            musicController.playRollSound();


            rollsLeft--;
            view.getDiceContainer().getButton().setText("rolls Left: " + rollsLeft);

            if (rollsLeft == 0) {
                view.getDiceContainer().getButton().setEnabled(false);
            }

            model.gameStarted = true; // if we roll all teh dice, we know the game started.

            // roll every dice
            for (int i = 0; i < 5; i++) {
                model.getDice(i).roll();
                view.getDiceContainer().getDice(i).setDiceText(model.getDice(i).getValue());
            }
        }

        // temporary, incredibly messy brute force code for storing variables for algorithms
        int onesCalc = 0;
        int twosCalc = 0;
        int threesCalc = 0;
        int foursCalc = 0;
        int fivesCalc = 0;
        int sixesCalc = 0;
        int bonusCalc = 0;
        int topTotalCalc = 0;
        int threeOfAKindCalc = 0;
        int fourOfAKindCalc = 0;
        int fullHouseCalc = 0;
        int smallStraitCalc = 0;
        int largeStraitCalc = 0;
        int yahtzeeCalc = 0;
        int chanceCalc = 0;
        int botTotalCalc = 0;
        int grandTotalCalc = 0;

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
        }

        // Top bonus
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[6].getScoreButton()) {
            bonusCalc = ( onesFinal + twosFinal + threesFinal + foursFinal + fivesFinal + sixesFinal );
            if ( bonusCalc >= 63 ){
                bonusCalc = 35;
            }
            else {
                bonusCalc = 0;
            }
            view.getScoreboardView().getScoreContainerView().getScoreArray()[6].getScoreButton().setText("" + bonusCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[6].getScoreButton().setEnabled(false);
            bonusFinal = bonusCalc;
        }

        // Top total
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[7].getScoreButton()) {
            topTotalCalc = ( onesFinal + twosFinal + threesFinal + foursFinal + fivesFinal + sixesFinal + bonusFinal );
            view.getScoreboardView().getScoreContainerView().getScoreArray()[7].getScoreButton().setText("" + topTotalCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[7].getScoreButton().setEnabled(false);
            topTotalFinal = topTotalCalc;
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
        }

        // Bottom total
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[15].getScoreButton()) {
            botTotalCalc = ( threeOfAKindFinal + fourOfAKindFinal + fullHouseFinal + smallStraitFinal + largeStraitFinal + yahtzeeFinal + chanceFinal );
            view.getScoreboardView().getScoreContainerView().getScoreArray()[15].getScoreButton().setText("" + botTotalCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[15].getScoreButton().setEnabled(false);
            botTotalFinal = botTotalCalc;
        }

        // Grand total
        if (e.getSource() == view.getScoreboardView().getScoreContainerView().getScoreArray()[16].getScoreButton()) {
            grandTotalCalc = ( topTotalFinal + botTotalFinal );
            view.getScoreboardView().getScoreContainerView().getScoreArray()[16].getScoreButton().setText("" + grandTotalCalc);
            view.getScoreboardView().getScoreContainerView().getScoreArray()[16].getScoreButton().setEnabled(false);
            grandTotalFinal = grandTotalCalc;
        }

        //
        System.out.println(e.getSource());


    }

    public int returnRolls() {
        return rollsLeft;
    }
}
