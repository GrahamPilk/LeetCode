

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> ans = new ArrayList<String>();
        for (String f : folder) {
            if (ans.isEmpty()) {
                ans.add(f);
            } else {
                String prev = ans.get(ans.size() - 1);
                if(f.startsWith(prev) && f.length() > prev.length() && f.charAt(prev.length()) == '/') {
                    continue;
                } else {
                    ans.add(f);
                }
            }
        }
        return ans;
    }
}


/*
 * Leetcode Problem 1233
 * 
 * Goal is to return the folders after removing all sub-folders. Basically getting a shortest version of every file path. 
 * Cheat: Yes :(, in car to Michigan rn
 * 
 * It sorts lexocgraphically which is basically numbers first in order given then alphabetically. so Arrays.sort
 * Then is goes through folder, if it is empty you add the first one everytime. 
 * It gets the prev parent folder for comparison. 
 * If f starts with prev, f length > prev length, f.charAt(prev.length()) == '/', we dont add anything, else we add f
 * The f.charAt checker checks if the character immediately following the parent folder path in the current folder string is a slash 
 */