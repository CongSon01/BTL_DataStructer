package Greedy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Data> datasets = Data.getExamples();

        for (Data data : datasets) {

            long timeStart2 = System.nanoTime();
            List<Item> greedy = Greedy.findBest(data);
            long timeStop2 = System.nanoTime();

            System.out.println("Greedy: \nĐồ vật có thể bỏ vào: ");
            System.out.println(greedy);
            System.out.println("\nTổng trọng lượng: " + Greedy.getWeight(greedy));
            System.out.println("Tổng giá trị : " + Greedy.getValue(greedy));
            System.out.println("Thời gian thực thi: " + (timeStop2 - timeStart2) / 1000000 + " ms");
        }

    }

}
