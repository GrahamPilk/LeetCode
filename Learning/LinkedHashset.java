package Learning;
import java.util.LinkedHashSet;

public class LinkedHashset {
    public static void main(String[] args) {
        /*
         * A LinkedHashSet is a collection that stores unique elements and remembers the order they were added. 
         * It is apart of the java.util package and implements the Set interface
         * Tip: Use LinkedHashSet when you want a set that does not allow duplicates and keeps the original insertion order.
         * The only difference between HashSet and LinkedHashSet, LinkedHashSet keeps insertion order preserved which also means it is slightly slower
         * 
         * 
         */

        LinkedHashSet<String> cars = new LinkedHashSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");  // Duplicate
        cars.add("Mazda");

        System.out.println(cars);
    }
}
