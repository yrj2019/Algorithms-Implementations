package Sort;

public class binarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(binSearch(arr, 11));
    }

    public static int binSearch(int[] arr, int key){
        int low = 0, high = arr.length - 1;
        int mid = (low + high) / 2;
        while (high > low){
            if (arr[mid] > key){
                high = mid - 1;
                mid = (high + low) / 2;
            }else if(arr[mid] < key){
                low = mid + 1;
                mid = (high + low) / 2;
            }else{
                return mid;
            }

        }
        return -1;
    }
}
