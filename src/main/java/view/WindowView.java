package view;

import controller.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import static constants.StepSign.stepName;
import static javax.swing.JFrame.setDefaultLookAndFeelDecorated;

public class WindowView implements ComponentListener, ActionListener{//implements ActionListener  {
    GameWindow gameWindow;
    int playerChoice;
    Controller controller;

    public WindowView(Controller controller){
        setDefaultLookAndFeelDecorated(true);
        gameWindow = new GameWindow();
        gameWindow.setVisible(true);
        this.controller = controller;
    }
    public void startGame(){
        gameWindow.drawField(this);
    }

    public void actionPerformed(ActionEvent event) {
        Object caller = event.getSource();
        if (caller == gameWindow.rockButton) {
            playerChoice = 1;
        }
        if (caller == gameWindow.paperButton) {
            playerChoice = 2;
        }
        if (caller == gameWindow.scissorsButton) {
            playerChoice = 3;
        }

        controller.makeMove(playerChoice);
    }

    public void showPlayerChoive(int playerChoice){
        gameWindow.message = "You choose "+stepName[playerChoice];
        gameWindow.redrawField();
    }

    public void showPCChoive(int pcChoice){
        gameWindow.message = gameWindow.message+"<br>PC choose "+stepName[pcChoice];
        gameWindow.redrawField();
    }

    public void showResult(int isPlayerWin){
        String message = isPlayerWin ==1?"You win!":(isPlayerWin ==2? "You lose!":"You draw");

        gameWindow.message = gameWindow.message+"<br>"+message;
        gameWindow.redrawField();
    }

    public void showStatistic(int lastTenTurnsWinPercents, int winPercents, int allGamesNumber){
       gameWindow.lastGamesWinPercents = lastTenTurnsWinPercents;
       gameWindow.allGamesWinPercents = winPercents;
       gameWindow.allGamesNumber = allGamesNumber;
        gameWindow.redrawField();
    }

    public void componentResized(ComponentEvent e) {
        gameWindow.resize();
    }

    public void componentMoved(ComponentEvent e) {

    }

    public void componentShown(ComponentEvent e) {

    }

    public void componentHidden(ComponentEvent e) {

    }
}
