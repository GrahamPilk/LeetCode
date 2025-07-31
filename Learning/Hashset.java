package Learning;
import java.util.HashSet;

public class Hashset {
    public static void main(String[] args) {
        /*
         * A HashSet is a part of the Java Collections Framework and implements the Set interface. It is a colection that stores unique elements in an unordered manner. This means: 
         * No Duplicates: You cannot add the same element more than once to a HashSet.
         * Unordered: The order in which u addd elements is not preserved. 
         * 
         * How it works: 
         * A HashSet internally uses a hash table to store its elements. When you add an element, it calculates a "Hash Code" for that element (a numerical representation).
         * THis hash code helps determine where the element should be stored in the internal data structure, allowing for very efficient oerations like adding, checking for existince. and removing elements. (O(1))
         * 
         * Idk why the import thing is being weird but It says it is working now. Oh Cause I cannot name the file 'HashSet'
         */

        HashSet<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // This will not be added as it's a duplicate
        System.out.println("Contains Apple: " + fruits.contains("Apple")); // true
        System.out.println("Contains Grape: " + fruits.contains("Grape")); // false
        System.out.println("Fruits in the set: " + fruits);
        fruits.remove("Banana");
        System.out.println("Fruits after removing Banana: " + fruits);

    }
}
