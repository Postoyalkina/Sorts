package Sorts;

public class QuickSort {
    private int []arr;
    QuickSort(int []m){
        arr= new int[m.length];
        System.arraycopy(m,0,arr,0,m.length);
    }
    public int[] sortQ() {
        int lastIndex = arr.length-1;
        int firstIndex = 0;
        doSort(firstIndex,lastIndex);
        return arr;
    }

    private  void doSort(int firstIndex, int lastIndex) {
        int last = lastIndex, first = firstIndex;
        if(first > last) {
            return;
        }
        if(first+1 == last) {
            if(arr[first] > arr[last]) {
                swap(first,last);
            }
        }else{
            int rndm = (first+last)/2;
            while (first < last) {
                while (first < rndm && (arr[first] <= arr[rndm])) {
                    first++;
                }
                while (last > rndm && (arr[rndm] <= arr[last])) {
                    last--;
                }
                if (first < last) {
                    swap(first,last);
                    if (first == rndm)
                        rndm = last;
                    else if (last == rndm)
                        rndm = first;
                }
            }
            if(firstIndex != lastIndex) {
                doSort(firstIndex, rndm);
                doSort(rndm + 1, lastIndex);
            }
        }

    }

    private void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
