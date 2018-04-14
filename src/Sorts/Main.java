package Sorts;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;

public class Main {
    public static void main(String [] args) throws BrokenBarrierException, InterruptedException {
        int [] m = new int[5000000];
        int [] check = new int[m.length];
        int [] tempArray;
        int countThread = 8;
        System.out.println("Count threads: " + countThread);
        for(int i = 0; i < m.length; i++) {
            m[i] = (int) (Math.random()*100000);
        }
        System.arraycopy(m,0,check,0,m.length);
        Arrays.sort(check);

        BubbleSort bubble = new BubbleSort(m);
        QuickSort quickSort = new QuickSort(m);
        MergeSort mergeSort = new MergeSort(m);
        BubbleSortThread bubbleSortThread = new BubbleSortThread(m,countThread);
        QuickSortThread quickSortThread = new QuickSortThread(m,countThread);
        MergeSortThread mergeSortThread = new MergeSortThread(m,countThread);

        //сортировка пузырьком
        /*System.out.println("Bubble sort:");
        long starttime = System.nanoTime();
        tempArray = bubble.sort();
        long timeSpent = System.nanoTime();
        if(CheckResult(check,tempArray)) System.out.println("Correct!");
        else System.out.println("Incorrect!");
        System.out.println("Time: "+(timeSpent-starttime));*/

        //быстрая сортировка
        System.out.println("Quick sort:");
        long starttimeQ = System.nanoTime();
        tempArray = quickSort.sortQ();
        long timeSpentQ = System.nanoTime();
        if(CheckResult(check,tempArray)) System.out.println("Correct!");
        else System.out.println("Incorrect!");
        System.out.println("Time: "+(timeSpentQ-starttimeQ));

        //сортировка слиянием
        System.out.println("Merge sort:");
        long starttimeM = System.nanoTime();
        tempArray = mergeSort.sort();
        long timeSpentM = System.nanoTime();
        if(CheckResult(check,tempArray)) System.out.println("Correct!");
        else System.out.println("Incorrect!");
        System.out.println("Time: "+(timeSpentM-starttimeM));

        //многопоточная сортировка пузырьком
        /*System.out.println("Bubble sort(concurrent):");
        long starttimeBC = System.nanoTime();
        tempArray = bubbleSortThread.sort(check);
        long timeSpentBC = System.nanoTime();
        if(CheckResult(check,tempArray)) System.out.println("Correct!");
        else System.out.println("Incorrect!");
        System.out.println("Time: "+(timeSpentBC-starttimeBC));*/

        //многопоточная быстрая сортировка
        System.out.println("Quick sort(concurrent):");
        long starttimeQC = System.nanoTime();
        tempArray = quickSortThread.sort();
        long timeSpentQC = System.nanoTime();
        if(CheckResult(check,tempArray)) System.out.println("Correct!");
        else System.out.println("Incorrect!");
        System.out.println("Time: "+(timeSpentQC-starttimeQC));

        //многопоточная сортировка слиянием
        System.out.println("Merge sort(concurrent):");
        long starttimeMC = System.nanoTime();
        tempArray = mergeSortThread.sort();
        long timeSpentMC = System.nanoTime();
        if(CheckResult(check,tempArray)) System.out.println("Correct!");
        else System.out.println("Incorrect!");
        System.out.println("Time: "+(timeSpentMC-starttimeMC));
    }

    //проверка отсортированого массива
    public static boolean CheckResult(int[] arr, int[] result) {
        return Arrays.equals(arr,result);
    }
}
