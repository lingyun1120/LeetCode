package offer;

import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指offer
 */
public class Solutions {
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
     * 斐波那契数列
     */
    public int fib(int n) {
        if (n <= 1) return n;
        int f0 = 0, f1 = 1, temp = 0;
        for(int i = 1; i < n; i++) {
            temp = f0 + f1;
            temp = temp % 1000000007;
            f0 = f1;
            f1 = temp;
        }
        return temp;
    }

    public int numWays(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        int f1 = 1, f2 = 2, temp = 0;
        for(int i = 2; i < n; i++) {
            temp = f1 + f2;
            temp = temp % 1000000007;
            f1 = f2;
            f2 = temp;
        }
        return temp;
    }

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
}
