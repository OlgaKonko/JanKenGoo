package data;

import java.util.LinkedList;

public class Statistic {
    private static int REMEMBERED_RESULTS_AMOUNT = 10;
    private int gamesNumber = 0;
    private int winGamesNumber = 0;
    private int loseGamesNumber = 0;
    private int winLastGamesNumber = 0;
    private int loseLastGamesNumber = 0;
    private LinkedList<Integer> lastResults;

    public Statistic() {
        lastResults = new LinkedList<Integer>();
        for (int index = 0; index < REMEMBERED_RESULTS_AMOUNT; index++) {
            lastResults.addFirst(0);
        }
    }

    public void refreshResults(int gameResult) {
        gamesNumber++;
        if (!(gameResult == 0)) {
            if (gameResult == 1) {
                winGamesNumber++;
                winLastGamesNumber++;
            } else {
                loseGamesNumber++;
                loseLastGamesNumber++;
            }
        }
        lastResults.addFirst(gameResult);
        int lastResult = lastResults.getLast();
        if (!(lastResult == 0)) {
            if (lastResult == 1) {
                winLastGamesNumber--;
            } else {
                loseLastGamesNumber--;
            }
        }
        lastResults.removeLast();
    }

    public int getGamesNumber() {
        return gamesNumber;
    }

    public int getMainStatistic() {
        return Math.round((float) winGamesNumber / (winGamesNumber + loseGamesNumber) * 100);
    }

    public int getLastStatistic() {
        return Math.round((float) winLastGamesNumber / (winLastGamesNumber + loseLastGamesNumber) * 100);
    }
}
