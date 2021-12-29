package Greedy;

import java.util.*;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Comparator;
// import java.util.List;

public class Greedy extends Knapsack {
    public static List<Item> findBest(Data dataset) {
        List<Item> bestList = new ArrayList<Item>();
        List<Item> allItems = dataset.items;

        Collections.sort(allItems, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return Double.compare(item2.getRatio(), item1.getRatio());
            }
        });

        int weightLeft = Data.getmaxWeight();
        for (Item item : allItems) {
            if (weightLeft - item.weight >= 0) {
                weightLeft -= item.weight;
                bestList.add(item);
            } else
                break;
        }
        return bestList;
    }

}