import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class SubsetSum
{
    private static int[] numbers;
    private static int sum = 0;
    private static int totalSum = 0;
    private static ArrayList<ArrayList<Integer>> results;
 
    public SubsetSum(int[] numbers)
    {
        this.numbers = numbers;
        Arrays.sort(numbers);
        for(int item : numbers) 
            totalSum += item;
    }

    private void Try(int index, int currentSum, int totalSum, ArrayList<Integer> sublist)
    {
        sublist.add(numbers[index]);
        if(numbers[index] + currentSum == sum)
        {
            print(sublist);
        }
        else if(index + 1 < numbers.length && currentSum + numbers[index] + numbers[index + 1] <= sum)
        {
            Try(index + 1, currentSum + numbers[index], totalSum - numbers[index], new ArrayList<Integer>(sublist));
        }
        if(index + 1 < numbers.length && currentSum + numbers[index + 1] <= sum && currentSum + totalSum - numbers[index] >= sum)
        {
            sublist.remove(sublist.size()-1);
            Try(index + 1, currentSum, totalSum - numbers[index], new ArrayList<Integer>(sublist));
        }
    }

    public static void print(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            System.out.print(arr.get(i) + " + ");
        }
        System.out.print(arr.get(arr.size() - 1)  + " = " + sum);
        System.out.println();
    }
 
    public static void main(String[] args)
    {
        int[] numbers  = {1, 2, 3 , 4 , 5};
        SubsetSum algo = new SubsetSum(numbers);
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap tong: ");
        sum = input.nextInt();
        algo.Try(0, 0, totalSum, new ArrayList<Integer>());
    }
}