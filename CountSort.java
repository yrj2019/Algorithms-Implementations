import java.util.Arrays;
import java.util.Collections;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 3, 0, 2, 3, 0, 3};
        int[] res = countSort(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] countSort(int[] arr){
        int upper = findMax(arr);
        int[] indArr = new int[upper + 1];
        int[] regArr = new int[arr.length];
        for (int i = 0; i <= upper; i++){
            indArr[i] = 0;
        }

        for (int j = 0; j < arr.length; j++){
            indArr[arr[j]] += 1;
        }

//        System.out.println(Arrays.toString(indArr));

        for (int k = 1; k <= upper; k++){
            indArr[k] = indArr[k] + indArr[k - 1];
        }
//        System.out.println(Arrays.toString(indArr));

        for (int l = arr.length - 1; l >= 0; l--){
            regArr[indArr[arr[l]] - 1] = arr[l];
            indArr[arr[l]] -= 1;
        }

        return regArr;
    }

    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }

        return max;
    }
}
