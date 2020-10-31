package other;

import common.ListNode;

public class Solutions {
    private static char c = 'A';
    private static int i = 0;

    /**
     * 用三个线程，顺序打印字母A-Z，输出结果是1A、2B、3C、1D 2E...
     */
    public static void threadPrint() {
        Runnable runnable = new Runnable() {
            public void run() {
                synchronized (this) {//加锁
                    try {
                        int threadId = Integer.parseInt(Thread.currentThread().getName());
                        while (i < 26) {
                            if (i % 3 == threadId - 1) {
                                System.out.println(threadId +""+ (char) c++);
                                i++;
                                notifyAll();// 唤醒处于等待状态的线程
                            } else {
                                wait();// 释放当前锁并进入等待状态
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }//执行结束释放当前锁
            }
        };
        Thread t1 = new Thread(runnable, "1");
        Thread t2 = new Thread(runnable, "2");
        Thread t3 = new Thread(runnable, "3");
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 如何判断一个链有环，请找出该链表的环的入口结点，否则输出null
     */
    public static ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead == null || pHead.next == null) return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                p2 = pHead;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if(p1 == p2){
                    return p1;//p1和p2相遇点正好是环的入口点
                }
            }
        }
        return null;
    }
}
