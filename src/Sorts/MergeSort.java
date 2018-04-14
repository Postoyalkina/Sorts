package Sorts;

public class MergeSort {
    private int []arr;
    MergeSort(int []m){
        arr= new int[m.length];
        System.arraycopy(m,0,arr,0,m.length);
    }

    public int[] sort() {
        int first = 0;
        int last = arr.length-1;
        mergeSort(arr,first,last);
        return arr;
    }

    private void mergeSort(int[] arr,int first,int last) {
        int split;
        if(last>first){
            split = (last+first)/2;
            mergeSort(arr,first,split);
            mergeSort(arr,split+1,last);
            merge(arr,first,split,last);
        }
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
}