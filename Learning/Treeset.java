package Learning;
import java.util.TreeSet;

public class Treeset {
    public static void main(String[] args) {
        /*
         * A TreeSet is a collection that stores unique elements in sorted order.
         * It is part of the java.util.package and implements th eSet interface.
         * Tip: Unlike HashSet, which has no order, TreeSet keeps its elements sorted Automatically
         * Tip: Use HashSet when you care about speed, and a treeSet when you need sorte elements 
         * 
         * Methods
         *      add() 
         *      addAll(Collection)
         *      clear()
         *      clone()
         *      contains()
         *      first()
         *      isEmpty()
         *      last()
         *      size()
         *      remove()
         */

        TreeSet<String> cars = new TreeSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("BMW");  // Duplicate
        cars.add("Mazda");
        System.out.println(cars.contains("Mazda")); //boolean
        System.out.println(cars.size());


    }
}
