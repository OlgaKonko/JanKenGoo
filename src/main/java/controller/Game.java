package controller;

import data.PCPlayer;
import data.Statistic;
import view.WindowView;

import java.util.Random;

public class Game implements Controller {
    PCPlayer pcPlayer;
    private Random random = new Random();
    private WindowView view;
    private Statistic statistic;

    public void startGame() {
        view = new WindowView(this);
        view.startGame();
        statistic = new Statistic();
        pcPlayer = new PCPlayer();
    }

    public void makeMove(int playerChoice) {
        //int pcChoice = random.nextInt(3)+1;
        int pcChoice = pcPlayer.move();
        view.showPlayerChoive(playerChoice);
        pcPlayer.updateBase(playerChoice);
        view.showPCChoive(pcChoice);
        int result = (3 + playerChoice - pcChoice) % 3;
        view.showResult(result);
        statistic.refreshResults(result);
        view.showStatistic(statistic.getLastStatistic(), statistic.getMainStatistic(), statistic.getGamesNumber());
    }
}
