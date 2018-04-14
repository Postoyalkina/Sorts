package Sorts;

import java.util.concurrent.CyclicBarrier;

public class BubbleSortThread {
    private int []arr;
    private static int n;
    CyclicBarrier cb;
    BubbleSortThread(int []m, int n) {
        arr= new int[m.length];
        System.arraycopy(m,0,arr,0,m.length);
        this.n = n;
        cb = new CyclicBarrier(n);
    }

    public int[] sort(int[] check) {
        try {
        int parts = arr.length/n, pos = 0;
        Thread[] t = new Thread[n];
        ThreadBubble []threads = new ThreadBubble[n];
        for(int i = 0; i < n; i++) {
            if(i==n-1){
                threads[i] =new ThreadBubble(cb,arr,pos,arr.length-1,check);
            }
            else {
                threads[i] = new ThreadBubble(cb, arr, pos, pos += (parts - 1),check);
            }
            t[i] = new Thread(threads[i],""+i);
            t[i].start();
            pos++;
        }
            t[0].join();
        } catch (InterruptedException e) {System.out.println(e);}
        return arr;
    }
}




