
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2273 {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        for(String w : words) {
            if(!res.isEmpty()) {
                String prev = res.get(res.size() - 1);
                char[] a = prev.toCharArray(), b = w.toCharArray();
                Arrays.sort(a);
                Arrays.sort(b);
                if(Arrays.equals(a, b)) continue;
            }
            res.add(w);
        }
        return res;
    }
}

/*
 * Goal: Find resulatant array after removing anagrams
 * 
 */