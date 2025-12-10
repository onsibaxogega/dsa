import java.util.Arrays;

/*
    - Priority Queue represented as a Max Heap
    - with Array implementation
*/
public class PriorityQueue<T> {

    public static void main (String[] args) {

        MaxHeap<Integer> nums = new MaxHeap<Integer>();

        nums.add(Integer.valueOf(254));
        nums.add(Integer.valueOf(573));

        // nums.add("Hello");
        // nums.add("World");

        System.out.println(nums);
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

    private Object[] nodes;
    private Class type;

    private final int MIN_SIZE = 8;

    /* Number of nodes in the heap */
    private int count;

    public MaxHeap() {
        this.nodes = new Object[MIN_SIZE];
        this.count = 0;
    }

    public void add(Object newNode) {

        if (this.type == null) {
            this.type = newNode.getClass();
            this.nodes[++this.count] = newNode;
            return;
        }

        this.resize();

        if (!(newNode.getClass().equals(this.type)))
            throw new IllegalArgumentException("Input must be of type: " + this.type);

        this.nodes[++this.count] = newNode;
    }

    /* Resizes array of nodes when necessary */
    public void resize() {
        return;
    }


    @Override
    public String toString() {
        return Arrays.toString(this.nodes);
    }
}