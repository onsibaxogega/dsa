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

        // nums.insert("Hello");
        // nums.insert("World");


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
class MaxHeap<T extends Comparable> {

    private Comparable[] nodes;
    private Class type;

    private final int MIN_SIZE = 4;

    /**
     * Number of nodes in the heap
     * Also index of the last node, because index 0 is left null to simplify binary tree navigability
    */
    private int count;

    public MaxHeap() {
        this.nodes = new Comparable[MIN_SIZE];
        this.count = 0;
    }

    /** Add a node to the max heap*/
    public void insert(Comparable newNode) {

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
            maxNode = (T) this.nodes[1];
        }
        catch(Exception e){
            e.printStackTrace();
        }

        if (!(maxNode == null)) {

            this.nodes[1] = this.nodes[count];
            this.nodes[this.count--] = null;
            this.sink(1);
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

    
    /** Iteratively swap max node with largest child larger than it */
    @SuppressWarnings("unchecked")
    private void sink(int target) {

        int lc, rc, candidate;

        while (target * 2 <= this.count) {

            lc = target * 2;
            rc = target * 2 + 1;

            if ((this.nodes[lc] == null) && (this.nodes[rc] == null)) break;

            if (this.nodes[rc] == null) candidate = lc;
            else candidate = ((this.nodes[lc] == null) || (this.nodes[rc].compareTo(this.nodes[lc]) > 0)) ? rc : lc;

            if(!(this.nodes[candidate].compareTo(this.nodes[target]) > 0)) break;

            Comparable temp = this.nodes[target];
            this.nodes[target] = this.nodes[candidate];
            this.nodes[candidate] = temp;
            target = candidate;

        }
    }


    @Override
    public String toString() {
        return Arrays.toString(this.nodes);
    }
}