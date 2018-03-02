package data.predicator;

import java.util.LinkedList;

public class LastGames {
    public LinkedList<Integer> lastGames;

    public LastGames() {
        lastGames = new LinkedList<Integer>();
        for (int index = 0; index < 5; index++) {
            lastGames.addFirst(0);
        }
    }

    public void update(int lastMove) {
        lastGames.addFirst(lastMove);
        lastGames.removeLast();
    }

    public int[] stepsAsArray() {
        int[] steps = new int[5];
        for (int index = 4; index >= 0; index--) {
            steps[index] = lastGames.get(index);
        }
        return steps;
    }
}
