import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Collections.addAll(arr, 2, 8, 7, 4, -2, 2, 1, -1, 4);
//        quickSortDesc(arr, 0, arr.size() - 1);
//        System.out.println(arr);
        quickSortWithEqual(arr, 0, arr.size() - 1);
        System.out.println(arr);

    }

    public static void quickSort(ArrayList<Integer> arr, int p, int r){
        if (p < r){
            int gap = Partition(arr, p, r);
            quickSort(arr, p, gap - 1);
            quickSort(arr, gap + 1, r);
        }
    }

    public static void quickSortDesc(ArrayList<Integer> arr, int p, int r){
        if (p < r){
            int q = PartitionDesc(arr, p, r);
            quickSortDesc(arr, 0, q - 1);
            quickSortDesc(arr, q + 1,  r);
        }
    }

    public static void quickSortWithEqual(ArrayList<Integer> arr, int p, int r){
        if (p < r){
            int[] window = PartitionWithEqual(arr, p, r);
            quickSortWithEqual(arr, p, window[0] - 1);
            quickSortWithEqual(arr, window[1] + 1, r);
        }
    }

    public static int Partition(ArrayList<Integer> arr, int p, int r){
        int key = arr.get(r);
        int gap = p - 1;
        for (int j = p; j <= r - 1; j++){
            if (arr.get(j) <= key){
                gap += 1;
                Collections.swap(arr, gap, j);
            }
        }

        Collections.swap(arr, gap + 1, r);
        return gap + 1;
    }

    public static int[] PartitionWithEqual(ArrayList<Integer> arr, int p, int r){
        int slide1 = p, slide2 = p;
        int key = arr.get(p);
        for (int i = p + 1; i <= r; i++){
            if (arr.get(i) < key){
                int tmp = arr.get(i);
                arr.set(i, arr.get(slide2 + 1));
                arr.set(slide2 + 1, arr.get(slide1));
                arr.set(slide1, tmp);
                slide1 += 1;
                slide2 += 1;
            }else if(arr.get(i) == key){
                Collections.swap(arr, slide2 + 1, i);
                slide2 += 1;
            }
        }

        int[] window = new int[]{slide1, slide2};
//        System.out.println(Arrays.toString(window));
        return window;
    }

    public static int PartitionDesc(ArrayList<Integer> arr, int p, int r){
        int key = arr.get(r);
        int gap = p - 1;
        for (int j = p; j <= r - 1; j++){
            if (arr.get(j) >= key){
                gap += 1;
                Collections.swap(arr, gap, j);
            }
        }

        Collections.swap(arr, gap + 1, r);
        return gap + 1;
    }

    public static int RandomizedPartition(ArrayList<Integer> arr, int p, int r){
        int rand = (int)(p + Math.random() * (r - p));
        Collections.swap(arr, r, rand);
        return Partition(arr, p, r);
    }
}
