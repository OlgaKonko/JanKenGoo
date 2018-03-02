package data.predicator;

import static constants.StepSign.unknown;

public class StepsComparator {
    public static int compare(Steps steps1, Steps steps2) {
        int step1;
        int step2;
        if (steps1.getExpectedStep() != steps2.getExpectedStep()) {
            return steps1.getExpectedStep() > steps2.getExpectedStep() ? 1 : -1;
        }

        for (int index = 0; index < steps1.getSteps().length; index++) {
            step1 = steps1.getSteps()[index];
            step2 = steps2.getSteps()[index];
            if (!(step1 == step2 || step1 == unknown || step2 == unknown)) {
                return step1 > step2 ? 1 : -1;
            }
        }
        return 0;
    }

    public static int math(Steps steps, int[] stepsPattern, int expectedStepPattern) {
        int step;
        int stepPattern;
        if (steps.getExpectedStep() != expectedStepPattern) {
            return steps.getExpectedStep() > expectedStepPattern ? 1 : -1;
        }

        for (int index = 0; index < steps.getSteps().length; index++) {
            step = steps.getSteps()[index];
            stepPattern = stepsPattern[index];
            if (!(step == stepPattern || step == unknown || stepPattern == unknown)) {
                return step > stepPattern ? 1 : -1;
            }
        }
        return 0;
    }
}
