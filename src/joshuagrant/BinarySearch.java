package joshuagrant;

import java.util.Arrays;

public class BinarySearch {
    static int count = 0;
    public static void main(String[] args) {
        final int size = Integer.MAX_VALUE/3;
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = (int) (Math.random()*10+1);
        }
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, -1, 0, arr.length - 1) + " in " + count + " tries");
    }

    private static int binarySearch(int[] arr, int target, int first, int last) {
        ++count;
        int middle = (first + last) / 2;
        if (first > last) {
            return -1;
        }
        if (arr[middle] == target) {
            return middle;
        }
        if (target < arr[middle]) {
            return binarySearch(arr, target, first, middle - 1);
        }
        return binarySearch(arr, target, middle + 1, last);
    }
}