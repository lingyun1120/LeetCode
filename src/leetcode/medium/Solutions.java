package leetcode.medium;

import data.ListNode;

public class Solutions {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1, n2 = l2;
        ListNode result = new ListNode(0);
        ListNode current = result;
        int carry = 0;
        while (n1 != null || n2 != null || carry != 0) {
            if (n1 != null) {
                carry += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                carry += n2.val;
                n2 = n2.next;
            }
            current.next = new ListNode(carry % 10);
            current = current.next;
            carry = carry / 10;
        }
        return result.next;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int start = 0, res = 0;
        int[] map = new int[128];

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            start = Math.max(start, map[c]);
            res = Math.max(res, i - start + 1);
            map[c] = i + 1;
        }

        return res;
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;
        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public static String zConvert(String s, int numRows) {
        if (numRows <= 1) return s;
        int len = s.length();
        if (len <= 1) return s;
        char[] chars = s.toCharArray();
        int cycle = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        //第一行
        for(int index = 0; index < len; index += cycle) {
            sb.append(chars[index]);
        }
        //中间行
        for (int row = 1; row < numRows - 1; row ++) {
            if (row >= len) {
                break;
            }
            sb.append(chars[row]);
            int index = row;
            while (true) {
                index = index + cycle - 2 * row;
                if (index >= len) break;
                sb.append(chars[index]);

                index += 2 * row;
                if (index >= len) break;
                sb.append(chars[index]);
            }
        }
        //最后一行
        for (int j = numRows - 1; j < len; j += cycle) {
            sb.append(chars[j]);
        }

        return sb.toString();
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int area = 0;
        int l = 0, r = len - 1;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            area = Math.max(area, (r - l) * h);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return area;
    }

    public static String intToRoman(int num) {
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num - nums[i] >= 0) {
                sb.append(romans[i]);
                num = num - nums[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
