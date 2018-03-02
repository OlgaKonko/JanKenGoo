package data.predicator;

import java.util.ArrayList;
import java.util.List;

import static constants.StepSign.expectedVariations;
import static constants.StepSign.stepsNumber;

public class StepsBase {
    List<Steps> defineSteps;

    public StepsBase() {
        defineSteps = new ArrayList<Steps>(expectedVariations);
        for (int c1 = 0; c1 < stepsNumber; c1++)
            for (int p1 = 0; p1 < stepsNumber; p1++)
                for (int c2 = 0; c2 < stepsNumber; c2++)
                    for (int p2 = 0; p2 < stepsNumber; p2++)
                        for (int c3 = 0; c3 < stepsNumber; c3++)
                            for (int pExpected = 1; pExpected < 4; pExpected++) {
                                defineSteps.add(new Steps(new int[]{c1, p1, c2, p2, c3}, pExpected));
                            }

    }

    public List<Steps> findStepsMathed(int[] pattern, int lastStep) {

        List<Steps> matchedSteps = new ArrayList<Steps>();
        for (Steps step : defineSteps) {
            if (StepsComparator.math(step, pattern, lastStep) == 0) {
                matchedSteps.add(step);
            }
        }
        System.out.println("!!!" + matchedSteps.size());
        return matchedSteps;
    }

    public long findStepsQuantity(int[] pattern, int move) {
        long quantity = 0;
        List<Steps> stepsToUpdate = findStepsMathed(pattern, move);
        for (Steps step : stepsToUpdate) {
            quantity += step.getQuantity();
        }
        return quantity;
    }

    public void updateBase(int[] pattern, int move) {
        List<Steps> stepsToUpdate = findStepsMathed(pattern, move);
        for (Steps step : stepsToUpdate) {
            step.increaseQuantity();
        }
    }


}
