package arrays;

import java.util.Arrays;

public class BinarySearch {

    static int binarySearch(int[] a, int k,int low, int high){

        while (low < high){
            int mid = low + (high - low) / 2;
            if(a[mid] == k){
                return mid;
            }else if(a[mid] > k){
                high = mid - 1;

            }else {
                low = mid + 1;
            }

        }
        return  -1;
    }

    public static void main(String[] args) {
        int a[] = {10,12,1,2,4,1,344,13,4223,443,233,2333,555,6453,53,2,56,3,5,35544};
        Arrays.sort(a);
        int k = 233;
        int idex = binarySearch(a,k,0,a.length - 1);
        System.out.println(idex + " "+a[idex]);
    }
}
