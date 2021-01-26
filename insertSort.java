import java.util.Arrays;

public class insertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, -1, 5, -2};
        InsertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void InsertSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }
    }
}
