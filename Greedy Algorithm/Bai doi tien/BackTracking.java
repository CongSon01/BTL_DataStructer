
public class BackTracking {
    private int maxValue, sumWeight, solution[], finalSolution[];

    public BackTracking(int item) {
        this.maxValue = 0;
        this.sumWeight = 0;
        this.solution = new int[item];
        this.finalSolution = new int[item];
    }
    
    public void knapsack(int maxWeight, int weights[], int value[], int item, int index) {
        solution[index] = -1;
        int n = weights.length;
        while (solution[index] < 1) {
            solution[index] = solution[index] + 1;

            if ((sum(index, weights) <= maxWeight) && (index == n - 1)) {
                update(maxWeight, weights, value, index);
            } else if (index < n - 1) {
                knapsack(maxWeight, weights, value, item, index + 1);
            }

        }
    }

    public int sum(int index, int weights[]) {
        int sum = 0;
        for (int i = 0; i < solution.length; i++) {
            sum += solution[i] * weights[i];
        }
        return sum;
    }

    public void update(int maxWeight, int weights[], int value[], int index) {
        int totalValue = 0;
        int totalWeight = 0;

        for (int i = 0; i < weights.length; i++) {
            if (solution[i] == 1) {
                totalValue += value[i];
                totalWeight += weights[i];
            }
        }

        if (totalValue > maxValue) {
            for (int i = 0; i < weights.length; i++) {
                finalSolution[i] = solution[i];
            }
            maxValue = totalValue;
            sumWeight = totalWeight;
        }
    }
    public int getValue() {
        return maxValue;
    }

    public int getWeight() {
        return sumWeight;
    }


    public static void main(String[] args) {
        int item = 10;
        int maxWeight = 40;
        int[] weights = { 5, 12, 4, 9, 1, 5, 6, 10, 8, 1 };
        int[] value = { 9, 2, 7, 6, 6, 5, 4, 13, 1, 7 };

        BackTracking backtrack = new BackTracking(item);
        long start = System.nanoTime();
        backtrack.knapsack(maxWeight, weights, value, item, 0);
        long end = System.nanoTime();
        long runtime = (end-start);
        System.out.println(runtime);
        // backtrack.printSolution(weights, value);
        System.out.println("Tổng trọng lượng: " + backtrack.getWeight());
        System.out.println("Tổng giá trị: " + backtrack.getValue());
    }
        

        
        // public void printSolution(int weights[], int value[]) {
        //     // System.out.println("\nĐồ vật có thể bỏ vào:");
        //     for (int i = 0; i < finalSolution.length; i++) {
        //         if (finalSolution[i] == 1) {
        //             // System.out.println("- Đồ vật có trọng lượng " + weights[i] + " , giá trị " + value[i]);
        //         }
        //     }
        //     // System.out.println("Đồ vật không bị lấy:");
        //     // for(int i = 0; i < finalSolution.length; i++)
        //     // {
        //     // if(finalSolution[i] != 1)
        //     // {
        //     // System.out.println("- Đồ vật có trọng lượng " + weights[i] + " , giá trị " +
        //     // value[i]);
        //     // }
        //     // }
        // }

        
}
