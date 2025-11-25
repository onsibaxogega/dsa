import java.util.Arrays;

public class InsertionSort
{

    public static void main(String[] args) {
        int[] nums0 = {33,4,5,234,4,6,8,4,7,4,6,4,3,654,67,3};
        int[] nums1 = {};
        int[] nums2 = {1,6,4,3};
        int[] nums3 = {1,3,6,4,7,4,1};
        int[] nums4 = null;
        int[] nums5 = {1};

        System.out.println("\n");

        System.out.println("Running INSERTION SORT on: ");
        System.out.println(Arrays.toString(nums0));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums4));
        System.out.println(Arrays.toString(nums5));

        System.out.println("\n");

        sort(nums0);
        sort(nums1);
        sort(nums2);
        sort(nums3);
        sort(nums4);
        sort(nums5);

        System.out.println("Sorted arrays: ");

        System.out.println(Arrays.toString(nums0));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums4));
        System.out.println(Arrays.toString(nums5));
    }


    private static void sort(int[] nums) {

        if (nums == null || nums.length < 2) return;

        for (int i=1; i<nums.length; i++) {

            int j = i;

            while(j > 0 && nums[j] < nums[j-1]) {

                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;

                j--;
            }
        }

    }
}