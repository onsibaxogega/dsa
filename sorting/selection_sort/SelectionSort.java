import java.util.Arrays;

public class SelectionSort
{

    public static void main(String[] args) {
        int[] nums0 = {33,4,5,234,4,6,8,4,7,4,6,4,3,654,67,3};
        int[] nums1 = {};
        int[] nums2 = {1,6,4,3};
        int[] nums3 = {1,3,6,4,7,4,1};

        System.out.println("\n");

        System.out.println("Running selection sort on: ");
        System.out.println(Arrays.toString(nums0));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));

        System.out.println("\n");

        sort(nums0);
        sort(nums1);
        sort(nums2);
        sort(nums3);

        System.out.println("Sorted arrays: ");

        System.out.println(Arrays.toString(nums0));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
    }

    private static String sort(int[] nums) {

        if (nums == null) return "Input array is null";

        for (int i=0; i<nums.length-1; i++) {

            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return "sorted";
    }
}