package offer;

import common.ListNode;

import javax.swing.tree.TreeNode;

public class Solutions {
    public static int findRepeatNumber(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }
}
