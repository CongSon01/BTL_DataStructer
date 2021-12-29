package Greedy;

import java.util.ArrayList;
import java.util.List;

public class Data {
    static int maxWeight;
    final List<Item> items;

    public Data(int maxW, List<Item> items) {
        maxWeight = maxW;
        this.items = maxW;
    }

    public static int getmaxWeight() {
        return maxWeight;
    }

    public static void setmaxWeight(int maxW) {
        maxWeight = maxW;
    }

    static List<Item> getItems(int[] weight, int[] value) {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < weight.length; i++) {
            items.add(new Item());
            items.get(i).weight = weight[i];
            items.get(i).value = value[i];
        }
        return items;
    }

    public static List<Data> getExamples() {
        List<Data> tmp = new ArrayList<>();
        int maxW = 40;
        int[] weight = { 5, 12, 4, 9, 1, 5, 6, 10, 8, 1 };
        int[] value = { 9, 2, 7, 6, 6, 5, 4, 13, 1, 7 };

        tmp.add(new Data(maxW, getItems(weight, value)));
        return tmp;
    }

}
