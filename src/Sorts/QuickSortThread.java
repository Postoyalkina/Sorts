package Sorts;

public class QuickSortThread {
    private int[] arr;
    private int n;

    QuickSortThread(int[] m, int n) {
        arr = new int[m.length];
        System.arraycopy(m, 0, arr, 0, m.length);
        this.n = n;
    }
    public int[] sort() {
        n--;
        Thread t = new Thread(new ThreadQuick(arr,0,arr.length-1,n));
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arr;
    }

}
