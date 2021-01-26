package Algorithm.Sort;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        QuickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(ar/r));
    }

    public static void QuickSort(int[] arr, int p, int r){
	// First, find the baseline's index
	// Second, iterate in first half
	// Last, iterate in second half
	// The judgement is p < r
	if(p < r){
            int q = Partition(arr, p, r);
            QuickSort(arr, p, q - 1);
            QuickSort(arr, q + 1, r);
        }
    }
    
    // To find the gap lower than the baseline and upper than the baseline.
    // The baseline is to divide the array into two parts, and then iterate in the two parts.
    public static int Partition(int[] arr, int p, int r){
	// The baseline of an iteration
        int key = arr[r];
        int i = p;
        int temp1;
        for(int j = p; j <= r - 1; j++){
            int temp2;
            if(arr[j] <= key){
                temp2 = arr[j];
                arr[j] = arr[i];
                arr[i] = temp2;
                i += 1;
            }
        }
        temp1 = arr[i];
        arr[i] = arr[r];
        arr[r] = temp1;
        // System.out.println(Arrays.toString(arr));
        return i;
    }
}
