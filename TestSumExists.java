package Sort;

//This program utilizes mergeSort + (head, tail)
//O(nlogn + n)

public class TestSumExsits {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 5, 4, 6, 1};
        System.out.println(search(arr, 100));
    }

    public static boolean search(int[] arr, int dest){
        merge(arr, 0, arr.length - 1);
        int head = 0, tail = arr.length - 1;
        while(tail > head){
            if(arr[head] + arr[tail] < dest){
                head += 1;
            }else if(arr[head] + arr[tail] > dest){
                tail -= 1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void merge(int[] arr, int p, int r){
        if(p < r){
            int q = (int)(Math.floor((p + r) / 2));
            merge(arr, p, q);
            merge(arr, q + 1, r);
            mergeSort(arr, p, q, r);
        }
    }
    public static void mergeSort(int[] arr, int p, int q, int r){
        int lenL = q - p + 1;
        int lenR = r - q;
        int[] L = new int[lenL + 1];
        int[] R = new int[lenR + 1];

        for(int i = 0; i < lenL; i++){
            L[i] = arr[p + i];
        }

        for(int i = 0; i < lenR; i++){
            R[i] = arr[q + 1 + i];
        }
        L[lenL] = R[lenR] = Integer.MAX_VALUE;

        int indL = 0, indR = 0;
        for(int i = p; i < r + 1; i++){
            if(L[indL] <= R[indR]){
                arr[i] = L[indL];
                indL += 1;
            }else{
                arr[i] = R[indR];
                indR += 1;
            }
        }
    }
}
