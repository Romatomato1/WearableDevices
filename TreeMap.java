import java.util.ArrayList;
/**
 * TreeMap is a Binary Tree of object type K.
 *
 * @author Roman Gofman
 * @version 6/2/2020
 */
public class TreeMap<K extends Comparable<K>>{
    //----------------------------------------------------------------------------------------
    //Instance Variables
    //----------------------------------------------------------------------------------------

    /** The root of the tree map. */
    private TreeNode<K> root;

    /** size of the TreeMap */
    private int size;

    /**
     * Constructor for objects of class TreeMap
     */
    public TreeMap() {
        size = 0;
        root = null;
    }

    /**
     * Method add public interaction starter.
     *
     * @param key; data of tree node
     */
    public void add(K key) {
        root = add(key, this.root);
        size += 1;
    }

    /**
     * Method add private recursion
     *
     * @param key; data of tree node
     * @param root; next node to be considered root
     * @return newly created node
     */
    private TreeNode<K> add(K key, TreeNode<K> root) {
        if (root == null) {
            root = new TreeNode<K>(this.size, key);
        } else if (key.compareTo(root.getKey()) == 0){
            root.addDuplicate(new DuplicateNode(this.size));
        } else if (key.compareTo(root.getKey()) < 0) {
            root.left = add(key, root.left);
        } else if (key.compareTo(root.getKey()) > 0) {
            root.right = add(key, root.right);
        }
        return root;
    }

    /**
     * Method contains public interactive method.
     *
     * @param key; data of tree node.
     * @return whether the tree has a value.
     */
    public boolean contains(K key) {
        return contains(key, this.root);
    }

    /**
     * Method contains private recursive method.
     *
     * @param key; data of tree node
     * @param root; next node to be considered root
     * @return whether the tree has a value.
     */
    public boolean contains(K key, TreeNode<K> root) {
        boolean result;
        int keyComparison = key.compareTo(root.getKey());
        if (root.getKey() == null){
            result = false;
        } else if (keyComparison == 0){
            result =  true;
        } else if (keyComparison > 0){
            result = contains(key, root.right);
        } else{
            result = contains(key, root.left);
        }
        return result;
    }

    /**
     * Method getPositionData   public method returns indexes.
     *
     * @return array of indexes
     */
    public int[] getPositionData(){
        int[] positionData = new int[size];
        Index index = new Index();
        getPositionData(root, positionData, index);
        return positionData;
    }

    /**
     * Method getPositionData   private recursive adapts given array and gets information.
     *
     * @param root; next node to be considered root
     * @param positionData array of indexs
     */
    private void getPositionData(TreeNode<K> root, int[] positionData, Index index){
        if (root != null) {
            getPositionData(root.left, positionData, index);
            positionData[index.getIndex()] = root.getIndex();
            index.setIndex(index.getIndex() + 1);
            addDuplicates(root, positionData, index);
            getPositionData(root.right, positionData, index);
        }
    }

    /**
     * Method getPositionData public method returns indexes between range1 and range2.
     *
     * @param range1; minimum range
     * @param range2; maximum range
     * @return array of indexes between range1 and range2.
     */
    public int[] getPositionData(K range1, K range2){
        ArrayList<Integer> positionData = new ArrayList<Integer>();
        getPositionData(root, positionData, range1, range2);
        int[] result =  new int[positionData.size()];
        for (int i = 0; i < positionData.size(); i++){
            result[i] = Integer.parseInt(positionData.get(i).toString());
        }
        return result;
    }

    /**
     * Method getPositionData private recursive method traverses TreeMap.
     *
     * @param root; next node to be considered root.
     * @param positionData; array of indexes between range1 and range2.
     * @param range1; minimum range
     * @param range2; maximum range
     */
    private void getPositionData(TreeNode<K> root, ArrayList<Integer> positionData, K range1, K range2){
        if (root != null) {
            getPositionData(root.left, positionData, range1, range2);
            if (range1.compareTo(root.getKey()) == -1 && range2.compareTo(root.getKey()) == 1 
            || range1.compareTo(root.getKey()) == 0 || range2.compareTo(root.getKey()) == 0){
                positionData.add(root.getIndex());
                addDuplicates(root, positionData);
            }
            getPositionData(root.right, positionData, range1, range2);
        }
    }

    /**
     * Method addDuplicates adds duplicates to array.
     *
     * @param root; to get duplicates from
     * @param positionData; array of indexes
     */
    private void addDuplicates(TreeNode<K> root, int[] positionData, Index index){
        DuplicateNode first = root.duplicate;
        while (first != null){
            positionData[index.getIndex()] = first.getIndex();
            index.setIndex(index.getIndex() + 1);
            first = first.next;
        }
    }

    /**
     * Method addDuplicates adds duplicates to array.
     *
     * @param root; to get duplicates from
     * @param positionData; ArrayList of indexes
     */
    private void addDuplicates(TreeNode<K> root, ArrayList<Integer> positionData){
        DuplicateNode first = root.duplicate;
        while (first != null){
            positionData.add(first.getIndex());
            first = first.next;
        }
    }

    /**
     * Method getAtIndex finds node data from index
     *
     * @param idx; index at which node is found
     * @return key of index
     */
    public K getAtIndex(int idx){
        return getAtIndex(root, idx).getKey();
    }

    /**
     * Method getAtIndex finds node from index
     *
     * @param root; used to raverse the list recursively
     * @param idx; index at which the node is to be found
     * @return TreeNode at the given index
     */
    private TreeNode<K> getAtIndex(TreeNode<K> root, int idx){
        TreeNode<K> result = null;
        if (root != null){
            getAtIndex(root.left, idx);
            if (root.getIndex() == idx){
                result = root;
            }
            getAtIndex(root.right, idx);
        }
        return result;
    }

    /**
     * Method getSize returns the size of the TreeMap.
     *
     * @return size of TreeMap
     */
    public int getSize(){
        return this.size;
    }

    //rebalancing

    /**
     * Method rebalance rebalances a binary tree
     *
     * @return a rebalanced TreeMap
     */
    public TreeMap<K> rebalance(){
        ArrayList<TreeNode<K>> nodeArray = new ArrayList<TreeNode<K>>();
        fillArrayList(nodeArray, root);
        TreeMap<K> rebalanced = new TreeMap<K>();
        while(rebalanced.getSize() != nodeArray.size()){
            rebalanced.add(nodeArray.get(getMiddle(nodeArray)).getKey());
        }
        return rebalanced;
    }

    /**
     * Method fillArrayList traverses the Treemap inOrder.
     *
     * @param nodeArray; arrayList to be filled
     * @param root; to be used for recursive traversal
     * @return a filled ArrayList
     */
    private ArrayList<TreeNode<K>> fillArrayList(ArrayList<TreeNode<K>> nodeArray, TreeNode<K> root){
        if (root != null){
            fillArrayList(nodeArray, root.left);
            nodeArray.add(root);
            fillArrayList(nodeArray, root.right);
        }
        return nodeArray;
    }

    /**
     * Method getMiddle gets the middle value in a array list.
     *
     * @param nodeArray; arrayList to be searched
     * @return the middle index.
     */
    private int getMiddle(ArrayList<TreeNode<K>> nodeArray){
        return nodeArray.size() / 2;
    }

    /**
     * TreeNode is a node for TreeMap.
     *
     * @author Roman Gofman
     * @version 6/2/2020
     */
    private class TreeNode<K extends Comparable<K>> {
        //----------------------------------------------------------------------------------------
        //Instance Variables
        //----------------------------------------------------------------------------------------

        /** The data contained in the node. */
        public K key;

        /** The left node attached to this one. */
        public TreeNode<K> left;

        /** The right node attached to this one. */
        public TreeNode<K> right;

        /** The duplicate node attached to this one. */
        public DuplicateNode duplicate;

        /** The index of this node. */
        public int index;

        /** The size of the tree below this. */
        public int size;

        /** The total duplicates of this exist. */
        public int numDups;

        /**
         * TreeNode Constructor
         *
         * @param position; the node's index
         * @param key; the node's data.
         */
        public TreeNode(int position, K key){
            if (position < 0){
                throw new IllegalArgumentException("Position can not be less than zero.");
            }
            this.index = position;
            this.key = key;
            size = 1;
            numDups = 0;
        }

        /**
         * Method getSize calculates and returns size.
         *
         * @return size; the number of nodes below this.
         */
        public int getSize(){
            if(left != null){
                size += left.getSize();
            }
            if(right != null){
                size += right.getSize();
            }
            size += numDups;
            return size;
        }

        /**
         * Method addDuplicate adds a duplicate.
         *
         * @param newDuplicate; duplicate to be added.
         */
        public void addDuplicate(DuplicateNode newDuplicate){
            if (duplicate == null){
                this.duplicate = newDuplicate;
            } else {
                this.duplicate.addDuplicate(newDuplicate);
            }
            numDups += 1;
        }

        /**
         * Method getDuplicate gets the duplicate attached to this node.
         *
         * @return the duplicate attached to this.
         */
        public DuplicateNode getDuplicate(){
            return this.duplicate;
        }

        /**
         * Method getKey returns the data attached to this node.
         *
         * @return the data.
         */
        public K getKey(){
            return this.key;
        }

        /**
         * Method getIndex returns the index attached to this node.
         *
         * @return the nodes index.
         */
        public int getIndex(){
            return this.index;
        }
    }

    /**
     * Duplicate node is a node attached to a node or a duplicate node.
     *
     * @author Roman Gofman
     * @version 6/2/2020
     */
    private class DuplicateNode{
        //----------------------------------------------------------------------------------------
        //Instance Variables
        //----------------------------------------------------------------------------------------

        /** The index of this node. */
        public int index;

        /** The duplicate node attached to this one. */
        public DuplicateNode next;

        /** The number of duplicates after this duplicate. */
        public int size;

        /**
         * DuplicateNode Constructor
         *
         * @param position; the node's index
         */
        public DuplicateNode(int position){
            if (position < 0){
                throw new IllegalArgumentException("Position can not be less than zero.");
            }
            this.index = position;
            size = 1;
            next = null;
        }

        /**
         * Method addDuplicate adds a duplicate.
         *
         * @param newDuplicate; duplicate to be added.
         */
        public void addDuplicate(DuplicateNode newDuplicate){
            if (next == null){
                this.next = newDuplicate;
            } else {
                this.next.addDuplicate(newDuplicate);
            }
        }

        /**
         * Method getIndex returns the index attached to this node.
         *
         * @return the nodes index.
         */
        public int getIndex(){
            return this.index;
        }

        /**
         * Method getDuplicate gets the duplicate attached to this node.
         *
         * @return the duplicate attached to this.
         */
        public DuplicateNode getDuplicate(){
            return this.next;
        }

        /**
         * Method getSize calculates and returns size.
         *
         * @return size; the number of nodes below this.
         */
        public int getSize(){
            if(getDuplicate() != null){
                size += next.getSize();
            }
            return size;
        }
    }
}
