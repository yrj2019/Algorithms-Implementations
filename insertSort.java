<<<<<<< HEAD
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
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class insertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 3, 5, 6};
//        System.out.println(Arrays.toString(InsertSort(arr)));
//        System.out.println(Arrays.toString(InsertSortDesc(arr)));
        int[] a = new int[]{1, 1, 0, 1};
        int[] b = new int[]{1, 1, 1, 0};//
        System.out.println(Arrays.toString(binAdd(a, b)));
//        System.out.println(Arrays.toString(chooseSort(arr)));
        mergeSortWithFlag(arr, 0, (int) (Math.floor(arr.length / 2)), arr.length);
        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length / 2, arr.length)));

    }

    //升序插入排序
    public static int[] InsertSort(int[] Arr) {
        int length = Arr.length;
        for (int i = 1; i < length; i++) {
            final int key = Arr[i];
            int j = i - 1;
            while (j > -1 && Arr[j] > key) {
                Arr[j + 1] = Arr[j];
                j -= 1;
            }
            Arr[j + 1] = key;
        }
        return Arr;
    }

    //降序插入排序
    public static int[] InsertSortDesc(int[] Arr) {
        final int length = Arr.length;
        for (int i = 1; i < length; i++) {
            final int key = Arr[i];
            int j = i - 1;
            while (j >= 0 && Arr[j] < key) {
                Arr[j + 1] = Arr[j];
                j -= 1;
            }
            Arr[j + 1] = key;
        }
        return Arr;
    }

    //选择排序
    public static int[] chooseSort(int[] a) {
        final int length = a.length;
        for (int i = 0; i < length - 1; i++) {
            int index = i;
            int temp;
            for (int j = i; j < length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        return a;
    }

    //两二进制数组相加
    public static int[] binAdd(int[] a, int[] b) {
        final int length = a.length;
        int[] res = new int[length + 1];
        Arrays.fill(res, 0);
        res[length] = (a[length - 1] + b[length - 1]) % 2;
        int flag = (a[length - 1] + b[length - 1]) / 2;
        for (int i = length - 2; i >= 0; i--) {
            res[i + 1] = (a[i] + b[i] + flag) % 2;
            flag = (a[i] + b[i] + flag) / 2;
        }
        res[0] = flag;
        return res;
    }

    public static void mergeSortWithFlag(int[] arr, int p, int q, int r) {
        int len1 = q - p + 1;
        int len2 = r - q;
        int[] L = new int[len1 + 1];
        int[] R = new int[len2 + 1];
        for (int i = p; i < q + 1; i++) {
            L[i - p] = arr[i];
        }
        for (int i = q + 1; i < r; i++) {
            R[i - q - 1] = arr[i];
        }
        L[len1] = R[len2] = Integer.MAX_VALUE;

        int ind1 = 0, ind2 = 0;
        for (int i = p; i < r; i++) {
            if (L[ind1] <= R[ind2]) {
                arr[i] = L[ind1];
                ind1++;
            } else {
                arr[i] = R[ind2];
                ind2++;
            }
        }
    }
}


>>>>>>> 9dd3b131b21e48a653610eea702dc4a9203bf149
