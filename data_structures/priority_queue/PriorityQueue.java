import java.util.Arrays;

/**
    - Priority Queue represented as a Max Heap
    - with Array implementation
*/
public class PriorityQueue<T> {

    public static void main (String[] args) {

        MaxHeap<Integer> nums = new MaxHeap<Integer>();

        nums.insert(Integer.valueOf(254));
        System.out.println(nums);
        nums.insert(Integer.valueOf(573));
        System.out.println(nums);
        nums.insert(Integer.valueOf(217));
        System.out.println(nums);
        nums.insert(Integer.valueOf(317));
        System.out.println(nums);
        nums.insert(Integer.valueOf(67));
        System.out.println(nums);
        nums.insert(Integer.valueOf(89));
        System.out.println(nums);

        nums.insert("Hello");
        nums.insert("World");


        System.out.println("Removed: " + nums.delMax());
        System.out.println(nums);
        System.out.println("Removed: " + nums.delMax());
        System.out.println(nums);
        System.out.println("Removed: " + nums.delMax());
        System.out.println(nums);
        System.out.println("Removed: " + nums.delMax());
        System.out.println(nums);
        System.out.println("Removed: " + nums.delMax());
        System.out.println(nums);

    }
}



/**
    - Max Heap with Array implementation
    - Array is auto-resized such that elements occupy at least 1/4 of array of lenght 2^n with nMin = 3
        - Resize down when below 1/4 full
        - Resize up when half full
*/
class MaxHeap<T> {

    private Object[] nodes;
    private Class type;

    private final int MIN_SIZE = 4;

    /**
     * Number of nodes in the heap
     * Also index of the last node, because index 0 is left null to simplify binary tree navigability
    */
    private int count;

    public MaxHeap() {
        this.nodes = new Object[MIN_SIZE];
        this.count = 0;
    }

    /** Add a node to the max heap*/
    public void insert(Object newNode) {

        if (this.type == null) {
            this.type = newNode.getClass();
            this.nodes[++this.count] = newNode;
            return;
        }

        if (!(newNode.getClass().equals(this.type)))
            throw new IllegalArgumentException("Input must be of type: " + this.type);

        this.nodes[++this.count] = newNode;
        this.resize();
    }

    @SuppressWarnings("unchecked")
    public T delMax() {

        T maxNode = null;

        try{
            maxNode = (T) this.nodes[this.count];
        }
        catch(Exception e){
            e.printStackTrace();
        }

        if (!(maxNode == null)) {

            this.nodes[this.count--] = null;
            this.resize();
        }

        return maxNode;
    }

    /** Resizes array of nodes when necessary */
    public void resize() {
        
        if (this.count > (this.nodes.length / 2))
            this.nodes = Arrays.copyOf(this.nodes, this.nodes.length * 2);

        if ((this.nodes.length > this.MIN_SIZE) && (this.count < (this.nodes.length / 4)))
            this.nodes = Arrays.copyOf(this.nodes, this.nodes.length / 2);
    }


    @Override
    public String toString() {
        return Arrays.toString(this.nodes);
    }
}