package Sorts;


import java.util.concurrent.Semaphore;

public class ThreadQuick extends Thread{
    private static final Semaphore sem = new Semaphore(1,true);
    static int n;
    int first, last;
    int[] arr;
    ThreadQuick(int []arr, int first, int last, int n) {
        this.first = first;
        this.last = last;
        this.arr = arr;
        this.n = n;
    }
    public void run() {
        doSort(first,last);
    }

    private  void doSort(int firstIndex, int lastIndex) {
        int last = lastIndex, first = firstIndex;
        if(first>=last) {
            return;
        }
        int rndm = (first+last)/2;
        while (first < last) {
            while (first < rndm && (arr[first] <= arr[rndm])) {
                first++;
            }
            while (last > rndm && (arr[rndm] <= arr[last])) {
                last--;
            }
            if (first < last) {
                int temp = arr[first];
                arr[first] = arr[last];
                arr[last] = temp;
                if (first == rndm)
                    rndm = last;
                else if (last == rndm)
                    rndm = first;
            }
        }
        if(n > 0) {
            try { sem.acquire(); } catch (InterruptedException e) {}
            np();
            sem.release();
            if(n >= 0){
                Thread t = new Thread(new ThreadQuick(arr, firstIndex, rndm, n));
                t.start();
                doSort(rndm + 1, lastIndex);
                try { t.join(); } catch (InterruptedException e) { }
            }else {
                doSort(firstIndex, rndm);
                doSort(rndm + 1, lastIndex);

            }
        }else {
            doSort(firstIndex, rndm);
            doSort(rndm + 1, lastIndex);

        }
    }

    private synchronized void np() {
        n--;
    }
}
