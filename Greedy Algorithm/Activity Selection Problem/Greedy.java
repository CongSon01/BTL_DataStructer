public class Greedy {

    int[] start;
    int[] end;
    int length;

    public Greedy (int[] start, int[] end, int array_length) {
        this.start = start;
        this.end = end;
        this.length = array_length;
    }

    public long search () {

        long start = System.nanoTime();

        int i, j;

        System.out.print("Thu tu cac hoat dong duoc chon: ");

        // The first activity always gets selected
        i = 0;
        System.out.print(i+" ");

        // Consider rest of the activities
        for (j = 1; j < length; j++) {
            // If this activity has start time greater than or
            // equal to the finish time of previously selected
            // activity, then select it
            if (this.start[j] >= this.end[i]) {
                  System.out.print(j+" ");
                  i = j;
            }
        }

        long end = System.nanoTime();
        long runtime = (end-start);

        return runtime;
    }

    public static void main(String[] args) {
        int[] start = {1,2,4,1,5,8,9,11,13};
        int[] end = {3,5,7,8,9,10,11,14,16};
        Greedy greedy = new Greedy(start, end, 6);
        long runtime = greedy.search();
        System.out.println("\nToc do chay: " + runtime + " nanoseconds");
    }
}
