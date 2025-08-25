import java.util.*;

public class StringPermutations 
{
    public static List<String> permute(String s) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        
        char[] chars = s.toCharArray();
        Arrays.sort(chars); 
        backtrack(result, new StringBuilder(), chars, used);
        return result;
    }
    
    private static void backtrack(List<String> result, StringBuilder current, char[] chars, boolean[] used) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;
            
            used[i] = true;
            current.append(chars[i]);
            
            backtrack(result, current, chars, used);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
    
    public static void main(String[] args) {
        String s = "abc";
        List<String> permutations = permute(s);
        System.out.println(permutations);
    }
}
