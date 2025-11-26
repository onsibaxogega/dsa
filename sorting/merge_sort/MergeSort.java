import java.util.Arrays;

public class MergeSort
{

    public static void main(String[] args) {
        int[] nums0 = {33,4,5,234,4,6,8,4,7,4,6,4,3,654,67,3};
        int[] nums1 = {};
        int[] nums2 = {1,6,4,3};
        int[] nums3 = {1,3,6,4,7,4,1};
        int[] nums4 = null;
        int[] nums5 = {1};

        System.out.println("\n");

        System.out.println("Running MERGE SORT on: ");
        System.out.println(Arrays.toString(nums0));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums4));
        System.out.println(Arrays.toString(nums5));

        System.out.println("\n");

        mergeSort(nums0);
        mergeSort(nums1);
        mergeSort(nums2);
        mergeSort(nums3);
        mergeSort(nums4);
        mergeSort(nums5);

        System.out.println("Sorted arrays: ");

        System.out.println(Arrays.toString(nums0));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums4));
        System.out.println(Arrays.toString(nums5));
    }


    private static void mergeSort(int[] nums) {

        if (nums == null || nums.length < 2) return;

        int[] aux = new int[nums.length];

        sort(nums, aux, 0, nums.length - 1);
    }


    private static void sort(int[] nums, int[] aux, int low, int high) {

        if (high == low) return;

        int mid = low + (high - low) / 2;
        sort(nums, aux, low, mid);
        sort(nums, aux, mid + 1, high);
        merge(nums, aux, low, mid, high);
    }


    private static void merge (int[] nums, int[] aux, int low, int mid, int high) {

        for (int i = low; i <= high; i++) {
            aux[i] = nums[i];
        }

        int pLow = low;
        int pHigh = mid + 1;

        for (int i = low; i <= high; i++) {

            if (pLow > mid) nums[i] = aux[pHigh++];
            else if (pHigh > high) nums[i] = aux[pLow++];
            else if (aux[pHigh] < aux[pLow]) nums[i] = aux[pHigh++];
            else nums[i] = aux[pLow++];

        }
    }

    
}