import java.util.Arrays;

/*
    - Priority Queue represented as a Max Heap
    - with Array implementation
*/
public class PriorityQueue<T> {

    public static void main (String[] args) {

        MaxHeap<Integer> nums = new MaxHeap<Integer>();

        nums.nodes[0] = 254;
        System.out.println(Arrays.toString(nums.nodes));
        System.out.println("Running...");
        
        try{
            Thread.sleep(3000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}



/*
    - Max Heap with Array implementation
    - Array is auto-resized such that elements occupy at least 1/4 of array of lenght 2^n with nMin = 3
        - Resize down when below 1/4 full
        - Resize up when half full
*/
class MaxHeap<T> {

    T[] nodes;

    private final int MIN_SIZE = 8;

    public MaxHeap() {
        this.nodes = new Object[MIN_SIZE];
    }
}