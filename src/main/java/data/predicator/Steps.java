package data.predicator;

public class Steps {
    private int[] steps;
    private int expectedStep;
    private int quantity;

    public Steps(int[] steps, int expectedStep) {
        this.steps = steps;
        quantity = 0;
        this.expectedStep = expectedStep;
    }

    public int[] getSteps() {
        return steps;
    }

    public int getExpectedStep() {
        return expectedStep;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        quantity++;
    }
}
