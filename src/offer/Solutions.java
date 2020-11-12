package offer;

import common.ListNode;
import common.TreeNode;
import common.Util;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指offer
 */
public class Solutions {
    //剑指offer 03
    public static int findRepeatNumber(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    //剑指offer 05
    public static String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        return new String(array, 0, size);
    }

    //剑指offer 06
    public static int[] reversePrint(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        int size = 0;
        //反转链表，其实是从第二个开始依次把箭头反过去指向前一个
        while (cur != null) {
            size++;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //反转之后，顺序遍历，存储结果就可以
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = pre.val;
            pre = pre.next;
        }
        return ans;
    }

    /**
     * //剑指offer 07
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//        List<Integer> pre = new ArrayList();
//        for (int i : preorder) pre.add(i);
//        List<Integer> in = new ArrayList();
//        for (int i : inorder) in.add(i);
//        return buildTreeHelper(pre, in);
        return buildTreeHelper2(preorder, inorder, Integer.MAX_VALUE);
    }

    private static TreeNode buildTreeHelper(List pre, List in) {
        if (pre.size() == 0) return null;

        int val = (int) pre.get(0);
        TreeNode root = new TreeNode(val);
        int index = in.indexOf(val);
        root.left = buildTreeHelper(pre.subList(1, 1 + index), in.subList(0, index));
        root.right = buildTreeHelper(pre.subList(1 + index, pre.size()), in.subList(1 + index, in.size()));
        return root;
    }

    private static int in = 0;
    private static int pre = 0;

    private static TreeNode buildTreeHelper2(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length)
            return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = buildTreeHelper2(preorder, inorder, node.val);
        node.right = buildTreeHelper2(preorder, inorder, stop);
        return node;
    }

    /**
     * //剑指offer 10
     * 斐波那契数列
     */
    public int fib(int n) {
        if (n <= 1) return n;
        int f0 = 0, f1 = 1, temp = 0;
        for (int i = 1; i < n; i++) {
            temp = f0 + f1;
            temp = temp % 1000000007;
            f0 = f1;
            f1 = temp;
        }
        return temp;
    }

    //剑指offer 10
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        int f1 = 1, f2 = 2, temp = 0;
        for (int i = 2; i < n; i++) {
            temp = f1 + f2;
            temp = temp % 1000000007;
            f1 = f2;
            f2 = temp;
        }
        return temp;
    }

    //剑指offer 011
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            //找出left和right中间值的索引
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                //如果中间值大于最右边的值，说明旋转之后最小的
                //数字肯定在mid的右边，比如[3, 4, 5, 6, 7, 1, 2]
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                //如果中间值小于最右边的值，说明旋转之后最小的
                //数字肯定在mid的前面，比如[6, 7, 1, 2, 3, 4, 5],
                //注意这里mid是不能减1的，比如[3，1，3]，我们这里只是
                //证明了numbers[mid]比numbers[right]小，但有可能
                //numbers[mid]是最小的，所以我们不能把它给排除掉
                right = mid;
            } else {
                //如果中间值等于最后一个元素的值，我们是没法确定最小值是
                // 在mid的前面还是后面，但我们可以缩小查找范围，让right
                // 减1，因为即使right指向的是最小值，但因为他的值和mid
                // 指向的一样，我们这里并没有排除mid，所以结果是不会有影响的。
                //比如[3，1，3，3，3，3，3]和[3，3，3，3，3，1，3],中间的值
                //等于最右边的值，但我们没法确定最小值是在左边还是右边
                right--;
            }
        }
        return numbers[left];
    }

    /**
     * //剑指offer 14
     * 数论
     * 任何大于1的数都可由2和3相加组成（根据奇偶证明）
     * 因为2*2=1*4，2*3>1*5, 所以将数字拆成2和3，能得到的积最大
     * 因为2*2*2<3*3, 所以3越多积越大 时间复杂度O(n/3)，用幂函数可以达到O(log(n/3)), 因为n不大，所以提升意义不大
     * 空间复杂度常数复杂度O(1)
     */
    public static int cuttingRope(int n) {
        if (n == 1 || n == 2)
            return 1;
        if (n == 3)
            return 2;
        int sum = 1;
        while (n > 4) {
            sum *= 3;
            n -= 3;
        }
        return sum * n;
    }

    //剑指offer 14
    public static int cuttingRope2(int n) {
        if (n == 1 || n == 2)
            return 1;
        if (n == 3)
            return 2;
        long sum = 1;
        while (n > 4) {
            sum *= 3;
            sum = sum % 1000000007;
            n -= 3;
            sum = sum % 1000000007;
        }

        return (int) (sum * n % 1000000007);
    }

    //剑指offer 15
    public static int hammingWeight(long n) {
//        Integer.bitCount(n);
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1; //>>> 不考虑符号位的右移
        }
        return count;
    }

    /**
     * //剑指offer 16
     * （1）当n为偶数，即求两个指数为n/2的快速幂的积；
     * （2）当n为奇数，即求两个指数为n/2的快速幂的积再乘1个底数。
     */
    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        long N = n;
        if (N < 0) {
            return 1 / power(x, -N);
        }
        return power(x, N);
    }

    private static double power(double x, long n) {
        System.out.println("----> " + x + "; " + n);
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        double r = power(x, n / 2);
        if (n % 2 == 1) {
            System.out.println("----> " + x + "; " + n + "; return " + r * r * x);
            return r * r * x;
        } else {
            System.out.println("----> " + x + "; " + n + "; return " + r * r);
            return r * r;
        }
    }

    //剑指offer 18
    public static ListNode deleteNode(ListNode head, int val) {
        Util.printList(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) cur.next = cur.next.next;
            else cur = cur.next;
        }
        return dummy.next;
    }

    public static int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 0) return nums;
        int left = 0, right = nums.length - 1;
        while(left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 != 1) {
                right--;
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }

    //剑指offer 22
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while(k > 0) {
            fast = fast.next;
            k--;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //剑指offer 24
    public static ListNode reverseListNodes(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    //剑指offer 25 递归
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //剑指 Offer 26. 树的子结构
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        System.out.println("-> isSubStructure A " + (A == null ? "null" : A.val));
        System.out.println("-> isSubStructure B " + (B == null ? "null" : B.val));
        if (A == null || B == null) {
            return false;
        }
        return subTreeHelper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private static boolean subTreeHelper(TreeNode a, TreeNode b) {
        System.out.println("---> helper A " + (a == null ? "null" : a.val));
        System.out.println("---> helper B " + (b == null ? "null" : b.val));
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        return a.val == b.val && subTreeHelper(a.left, b.left) && subTreeHelper(a.right, b.right);
    }
}
