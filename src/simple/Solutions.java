package simple;

import java.util.HashMap;
import java.util.Map;

public class Solutions {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value != null) {
                return new int[]{value, i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int sum = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; --i) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        if (strs.length == 1) return strs[0];
        if (strs.length == 2) return findCommonPre(strs[0], strs[1]);
        String prefix = findCommonPre(strs[0], strs[1]);
        int i = 2;
        while (i < strs.length) {
            prefix = findCommonPre(prefix, strs[i]);
            if (prefix.equals("")) {
                break;
            }
            i++;
        }
        return prefix;
    }

    private static String findCommonPre(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(str1.length(), str2.length());
        for (int i = 0; i < min; i ++) {
            if(str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

}
