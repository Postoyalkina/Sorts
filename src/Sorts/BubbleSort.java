package Sorts;

public class BubbleSort {
    private int []arr;
    BubbleSort(int []m){
        arr= new int[m.length];
        System.arraycopy(m,0,arr,0,m.length);
    }
    public int[] sort() {
        for(int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //System.out.println(toString(arr));
        return arr;
    }
    public String toString(int []arr){
        String str = "";
        for(int i = 0; i < arr.length; i++) {
            str += " "+arr[i];
        }
        return str;
    }
}
