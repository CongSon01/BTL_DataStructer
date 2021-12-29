package Greedy;

import java.util.*;

public abstract class Knapsack {

    public static int getValue(List<Item> listOfItems) {
        int val = 0;
        for (int i = 0; i < listOfItems.size(); i++) {
            val += listOfItems.get(i).value;
        }
        return val;
    }

    public static int getWeight(List<Item> listOfItems) {
        int size = 0;
        for (int i = 0; i < listOfItems.size(); i++) {
            size += listOfItems.get(i).weight;
        }
        return size;
    }
}
