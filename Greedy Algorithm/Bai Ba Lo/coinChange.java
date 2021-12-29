import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class coinChange {
    // khoi tao cac gia tri cho ham cac ham
    private static List<Integer> coinsy;
    private static List<Integer> coinsx;
    private static int count = 0;

    private static void init() {
        coinsx = new ArrayList<Integer>();
        coinsx.add(1);
        coinsx.add(2);
        coinsx.add(5);
        coinsx.add(10);
        coinsx.add(20);
    }

    // Ham doi tien su dung thuat toan Greedy
    public static void coinChangeGreedy(int n) {
        int i = 0;

        coinsx.sort((o1, o2) -> o2 - o1);
        while (n > 0) {
            if (coinsx.get(i) > n) {
                i++;
            } else {
                // System.out.print(coinsx.get(i) + "\t");
                n = n - coinsx.get(i);
            }
        }
        // System.out.println("");
    }

    // Ham doi tien su dung thuat toan Backtraking
    public static void coinChangeBacktrack(int amount, int index, LinkedList<Integer> list) {
        if (amount == 0) {
            count++;
            // System.out.println(list.toString());
            return;
        }

        if (amount < 0)
            return;

        for (int i = index; i < coinsx.size(); i++) {
            int coin = coinsx.get(i);
            if (amount >= coin) {
                list.add(coin);
                coinChangeBacktrack(amount - coin, i, list);
                list.removeLast();

            }
        }
    }

    // -------------------------------------------------------------
    public static void main(String[] args) {

        System.out.println("Nhập số tiền bạn muốn quy đổi:");
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();

        init();

        System.out.println("Các nghiệm của thuật toán Backtracking:");
        long start = System.nanoTime();
        coinChangeBacktrack(amount, 0, new LinkedList<Integer>());
        long end = System.nanoTime();
        long runtime = (end-start);
        System.out.println(runtime);
        // System.out.println("Số nghiệm của thuật toán Backtracking:" + count);

        // System.out.println("\n");
        System.out.println("Nghiệm tối ưu nhất với thuật toán Greedy:");
        long start_1 = System.nanoTime();
        coinChangeGreedy(amount);
        long end_1 = System.nanoTime();
        long runtime_1 = (end_1-start_1);
        System.out.println(runtime_1);
    }

}