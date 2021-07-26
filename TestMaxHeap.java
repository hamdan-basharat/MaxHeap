/*******************************************************************************
* Hamdan Basharat / basham1 / 400124515
* TestMaxHeap Class 
*******************************************************************************/
package Lab5;

public class TestMaxHeap {
    public static void main(String[] args) {
        // Test Cases
        
        System.out.println("****************************************************");
        MaxHeap test1 = new MaxHeap(5);
        System.out.println("Size: " + test1.getSize() + " | Items: " + test1.getItems());
        System.out.println("Inserted Value: 1");
        test1.insert(1);
        System.out.println(test1.toString());
        System.out.println("Inserted Value: 3");
        test1.insert(3);
        System.out.println(test1.toString());
        System.out.println("Inserted Value: 5");
        test1.insert(5);
        System.out.println(test1.toString());
        System.out.println("Removed Root: " + test1.deleteMax());
        System.out.println(test1.toString());
        System.out.println("Size: " + test1.getSize() + " | Items: " + test1.getItems());
        System.out.println("****************************************************\n");
        
        System.out.println("****************************************************");
        Integer[] arr = {2,5,3,8,4,9,6};
        MaxHeap test2 = new MaxHeap(arr);
        System.out.println("Size: " + test2.getSize() + " | Items: " + test2.getItems());
        System.out.println("Inserted Value: 6");
        test2.insert(6);
        System.out.println(test2.toString());
        test2.heapsort(test2.getHeap());
        System.out.println("Size: " + test2.getSize() + " | Items: " + test2.getItems());
        System.out.println("****************************************************\n");
        
        System.out.println("****************************************************");
        Integer[] arr2 = {2,5,3,8,4,9,6};
        MaxHeap test3 = new MaxHeap(arr2);
        System.out.println("Size: " + test3.getSize() + " | Items: " + test3.getItems());
        System.out.println("Inserted Value: 6");
        test3.insert(6);
        System.out.println(test3.toString());
        System.out.println("Removed Root: " + test3.deleteMax());
        System.out.println(test3.toString());
        System.out.println("Inserted Value: 1");
        test3.insert(1);
        System.out.println(test3.toString());
        System.out.println("Inserted Value: 3");
        test3.insert(3);
        System.out.println(test3.toString());
        System.out.println("Removed Root: " + test3.deleteMax());
        System.out.println(test3.toString());
        test3.heapsort(test3.getHeap());
        System.out.println("Size: " + test3.getSize() + " | Items: " + test3.getItems());
        System.out.println("****************************************************\n");
    }   
}
