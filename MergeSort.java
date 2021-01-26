import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, -1, 5, -2};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int p, int r){
        if(p < r){
            int q = (int)(Math.floor((p + r) / 2));
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r){
        int[] L = new int[q - p + 2];
        int[] R = new int[r - q + 1];
        for (int i = p; i <= q; i++){
            L[i - p] = arr[i];
        }

        for (int j = q + 1; j <= r; j++){
            R[j - q - 1] = arr[j];
        }

        L[q - p + 1] = R[r - q] = Integer.MAX_VALUE;
        int l_ind = 0, r_ind = 0;
        for (int k = p; k <= r; k++){
            if (L[l_ind] < R[r_ind]){
                arr[k] = L[l_ind];
                l_ind += 1;
            }else{
                arr[k] = R[r_ind];
                r_ind += 1;
            }
        }
    }
}
