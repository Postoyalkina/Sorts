package Sorts;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class ThreadBubble extends Thread {
    int first, last, countIt = 0;
    int[] arr,check;
    CyclicBarrier cb;
    ThreadBubble(CyclicBarrier cb,int []arr, int first, int last, int[] check) {
        this.first = first;
        this.last = last;
        this.arr = arr;
        this.cb = cb;
        this.check = check;
    }
    public void run() {
        while(!sortb()) { }
        cb.reset();
    }
    public boolean sortb(){
        try {
            cb.await();
            if(countIt%2==0) {
                for(int i = first; i <= last; i+=2) {
                    if (i != arr.length-1 ) {
                        if (arr[i] > arr[i + 1]) {
                            int temp = arr[i];
                            arr[i] = arr[i + 1];
                            arr[i + 1] = temp;
                        }
                    }
                }
            }
            else {
                for (int i = first + 1; i <= last; i += 2) {
                    if(i != arr.length-1) {
                        if (arr[i] > arr[i + 1]) {
                            int temp = arr[i];
                            arr[i] = arr[i + 1];
                            arr[i + 1] = temp;
                        }
                    }
                }
            }
            countIt++;
        } catch (Exception e) {}
        return (Arrays.equals(arr,check));
    }
}
