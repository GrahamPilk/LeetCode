
import java.util.HashSet;

class Solution1733 {
     // helper function to check if two users can already talk
    public boolean canTalk(HashSet<Integer> a, HashSet<Integer> b) {
        for (Integer val : a) {
            if (b.contains(val)) return true;
        }
        return false;
    }
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;
        //step 1 is to build the user and their set of known languages. using a HashSet
        HashSet<Integer>[] users = new HashSet[m];
        for(int i = 0; i < m; i++) {
            users[i] = new HashSet<>();
            for(int lang : languages[i]) {
                users[i].add(lang);
            }
        }

        //step 2 is to consider teaching each possible languages
        int minTeachings = Integer.MAX_VALUE;
        for(int lang = 1; lang <= n; lang++) {
            int count = 0;
            boolean[] learnt = new boolean[m]; // avoids double couynting same user

            //step 3 is to check each friendship
            for(int[] friends : friendships) {
                int a = friends[0] -1; 
                int b = friends[1] - 1;
                //if they can alr talk, skip
                if (canTalk(users[a], users[b])) continue;
                //otherwise teach chosen language to both (if not known)
                if (!users[a].contains(lang) && !learnt[a]) {
                    learnt[a] = true;
                    count++;
                }
                if (!users[b].contains(lang) && !learnt[b]) {
                    learnt[b] = true;
                    count++;
                }
            }
            minTeachings = Math.min(minTeachings, count);
        }
        return minTeachings;
    }
}