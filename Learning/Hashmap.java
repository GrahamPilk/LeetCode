package Learning;
import java.util.HashMap;
import java.util.Map;

public class Hashmap {
    public static void main(String[] args) {
        /*
         * A HashMap stores items in key/value pairs, where each key maps to a specific value. It is apart of the java.util package an dimplemnts the Map interface.
         * Instead of accessing elements by an index (like an ArrayList), you use a key to retrieve its associated value. 
         * A HashMap can store many diferent combinations. 
         * 
         * put() - add items
         * get() - to access a value in the HashMap, use the get() method and refer to its key
         * remove() - remove an item
         * clear()  - clear all items in HashMap
         * size() - returns size of HashMap
         * keySet() - gets only the keys
         * values() - gets only the values 
         * getOrDefault() - returns value associated with key, if key does not exist, it returns a provided default value in second posiiton in call. 
         */

         Map<String, String> capitalCities = new HashMap<>();
         capitalCities.put("Endgland", "London");
         capitalCities.put("Indie", "New Dehli");
         System.out.println(capitalCities);
         capitalCities.get("England");
         capitalCities.remove("England");
         capitalCities.clear();
         capitalCities.size();
        for(String i : capitalCities.keySet()) {
            System.out.println(i);
        }
        for(String i : capitalCities.values()) {
            System.out.println(i);
        }


    }
}
