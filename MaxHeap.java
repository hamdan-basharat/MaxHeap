/*******************************************************************************
* Hamdan Basharat / basham1 / 400124515
* MaxHeap Class 
*******************************************************************************/
package Lab5;

public class MaxHeap {
    private Integer[] heap; //reference to the array which stores the items
    private int size; //size of the array
    private int items; //number of items stored
    /***************************************************************************
    * Constructor: Creates an empty heap. 
    * @param: type Integer, type double
    * Time Complexity: constant(1)
    ***************************************************************************/
    public MaxHeap(int size){
        this.heap = new Integer[size + 1]; //empty heap with passed size
        this.size = size; //updates variables
        this.items = 0;
    }
    /***************************************************************************
    * Constructor: Creates a MaxHeap which stores the items from the input array.
    * @param: type Integer, type double
    * Time Complexity: n
    ***************************************************************************/
    public MaxHeap(Integer[] someArray){
        this.heap = new Integer[someArray.length + 1]; //empty heap with passed size
        this.size = someArray.length; //updates variables 
        this.items = 0;
        for(int i=0;i<someArray.length;i++){
            insert(someArray[i]); //inserts every index of the array into the heap
        }
    }
    
    /***************************************************************************
    * Accessors & Mutators: Allow access to the fields through encapsulation
    ***************************************************************************/
    public Integer[] getHeap(){return this.heap;}
    public int getSize(){return this.size;}
    public int getItems(){return this.items;}
    public void setHeap(Integer[] heap){this.heap = heap;}
    public void setSize(int size){this.size = size;}
    public void setItems(int items){this.items = items;}
    
    /***************************************************************************
    * Method: Inserts the value n in this max heap. Duplicates are allowed. If 
    * there is no room for the insertion in the current array storing the items,
    * then an array of double size has to be allocated and all items are copied 
    * into the new array, followed by insertion.
    * @param: type Integer @return: none
    * Time Complexity: log(n)
    ***************************************************************************/
    public void insert(int n){
        if(this.getItems()+1 > this.getSize()){ //if there is no room for insertion, size is doubled
            MaxHeap larger = new MaxHeap(this.getSize()*2); //creates empty heap
            for(int i=1;i<=this.getSize();i++)
                larger.insert(this.getHeap()[i]); //inserts every index of the old heap into the new heap
            this.setHeap(larger.getHeap()); //updates variables
            this.setSize(larger.getSize());
            this.setItems(larger.getItems());
        }
        this.setItems(this.getItems()+1); //increases number of items stores
        this.heap[this.getItems()] = n;
        int pos = this.getItems(); //variable for current position
        if(pos!=1){
            while(this.getHeap()[pos]>this.getHeap()[pos/2]){ //runs if child is larger than parent
                int temp = this.getHeap()[pos]; //swaps values of child and parent
                this.getHeap()[pos] = this.getHeap()[pos/2];
                this.getHeap()[pos/2] = temp;
                pos = pos/2; //child position is set as parent position for next iteration
                if(pos==1){break;}
            }
       }
    }
    /***************************************************************************
    * Method: Removes the item with the largest value and returns its value.
    * @param: void @return: type 
    * Time Complexity: n
    ***************************************************************************/
    public int deleteMax(){
        int root = this.getHeap()[1];
        MaxHeap deleted = new MaxHeap(this.getSize()); //creates empty heap
        for(int i=2;i<=this.getItems();i++)
            deleted.insert(this.getHeap()[i]); //inserts every index of the old heap into the new heap except the root
        this.setHeap(deleted.getHeap()); //updates variables
        this.setSize(deleted.getSize());
        this.setItems(deleted.getItems());
        return root; //returns the max value that was removed
    }
    /***************************************************************************
    * Method: Returns string representing the sequence of integer values stored
    * in the heap, in the order they are stored in the array (in level order).
    * @param: void @return: type String
    * Time Complexity:  n
    ***************************************************************************/
    public String toString(){
        String output = "Heap: "; //string variable to be returned
        for(int i=0;i<this.getItems();i++){
            for(int j=0;j<Math.pow(2,i) && j+Math.pow(2,i)<=this.getItems();j++) //in level order, runs while j is less than 2^index and j plus 2^index is less than the size
                output += this.getHeap()[j+(int)Math.pow(2,i)] + " "; //adds the index to the string 
        }
        return output;
    }
    /***************************************************************************
    * Method: Applies heap sort algorithm to sort the input array. 
    * @param: type Integer[] @return: void
    * Time Complexity: n^2*log(n)
    * Space Complexity: constant(1)
    ***************************************************************************/
    public static void heapsort(Integer[] arrayToSort){
        int count = 1;
        while(arrayToSort[count+1]!=null){ //counts the items in the array
            count++;
        }
        Integer[] copy = new Integer[count]; //creates new array and copies non null indexes over
        for(int i=0;i<count;i++){
            copy[i] = arrayToSort[i+1];
        }
        MaxHeap sort = new MaxHeap(copy); //creates new max heap
        int n = copy.length;
        Integer[] sorted = new Integer[sort.getSize()+1]; //makes array to hold sorted list
        for(int i=0;i<sorted.length-1;i++){
            sorted[n] = sort.deleteMax(); //calls remove max and assigns the removed root to the index
            n--; //decrements the index
        }
        System.out.println("Sorted Array: ");
        for(int i=1;i<sorted.length;i++){ //prints the sorted list
            System.out.print(sorted[i] + " ");
        }
        System.out.println("");
    }
}

