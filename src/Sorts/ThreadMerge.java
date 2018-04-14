package Sorts;

import java.util.concurrent.Semaphore;

public class ThreadMerge extends Thread {
    private static final Semaphore sem = new Semaphore(1);
    static int n;
    int first, last;
    int[] arr;
    ThreadMerge(int []arr, int first, int last, int n) {
        this.first = first;
        this.last = last;
        this.arr = arr;
        this.n = n;
    }
    public void run() {
        doSort(first,last);
    }

    private  void doSort(int first, int last) {
        int split = (last+first)/2;
        if(first==last){return;}
        if(first+1==last && arr[first+1] > arr[last]) {
            int temp = arr[first+1];
            arr[first+1] = arr[last];
            arr[last] = temp;
        }else{
            if(n > 0) {
                try { sem.acquire(); } catch (InterruptedException e) { }
                np();
                sem.release();
                if (n >= 0) {
                    Thread t = new Thread(new ThreadMerge(arr, first, split, n));
                    t.start();
                    doSort(split + 1, last);
                    try { t.join(); } catch (InterruptedException e) { }
                }else {
                    doSort(first,split);
                    doSort(split + 1, last);
                }
            }else {
                doSort(first,split);
                doSort(split + 1, last);
            }
        }
        merge(arr,first,split,last);

    }
    private void merge (int []arr,int first, int split, int last) {
        int pos1 = first, pos2 = split+1, pos3 = 0;
        int []temp = new int[last-first+1];
        while (pos1<=split && pos2<=last){
            if (arr[pos1] < arr[pos2])
                temp[pos3++] = arr[pos1++];
            else
                temp[pos3++] = arr[pos2++];
        }

        while (pos2<=last) {
            temp[pos3++] = arr[pos2++];
        }
        while (pos1<=split) {
            temp[pos3++] = arr[pos1++];
        }

        System.arraycopy(temp,0,arr,first,last-first+1);
    }

    private synchronized void np() {
        n--;
    }
}
