package Sorts;


public class MergeSortThread {
    private int []arr;
    private int n;
    MergeSortThread(int []m, int n){
        arr= new int[m.length];
        System.arraycopy(m,0,arr,0,m.length);
        this.n = n;
    }
    public int[] sort() {
        n--;
        Thread t = new Thread(new ThreadMerge(arr,0,arr.length-1,n));
        t.start();

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
