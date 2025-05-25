package ga;

public class KnapsackProblem {
    private final int maxCapacity;
    private final int[] weights = {10, 20, 30, 40, 50};
    private final int[] values = {60, 100, 120, 240, 300};

    public KnapsackProblem(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getWeight(int index) {
        return weights[index];
    }

    public int getValue(int index) {
        return values[index];
    }

    public int getItemCount() {
        return weights.length;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
