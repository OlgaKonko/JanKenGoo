package data;

import data.predicator.LastGames;
import data.predicator.StepsBase;

public class PCPlayer {
    LastGames lastGames;
    StepsBase stepsBase;

    public PCPlayer() {
        lastGames = new LastGames();
        stepsBase = new StepsBase();
    }

    public int move() {
        int[] steps = lastGames.stepsAsArray();
        long[] predicatedSteps = new long[3];
        for (int index = 0; index < 3; index++) {
            predicatedSteps[index] = stepsBase.findStepsQuantity(steps, index + 1);
        }
        long max = 0;
        int maxIndex = 0;
        for (int index = 0; index < 3; index++) {
            if (predicatedSteps[index] > max) {
                max = predicatedSteps[index];
                maxIndex = index;
            }
        }
        System.out.println("maxIndex " + maxIndex);
        System.out.println("max " + max);
        int psStep = (maxIndex + 1) % 3 + 1;
        updateSteps(psStep);
        return psStep;
    }

    public void updateBase(int move) {
        int[] steps = lastGames.stepsAsArray();
        stepsBase.updateBase(steps, move);
        updateSteps(move);
    }

    private void updateSteps(int move) {
        lastGames.update(move);
    }
}
