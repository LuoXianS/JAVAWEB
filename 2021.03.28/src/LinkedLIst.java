class Node {
    public int val;
    public Node next;
    public Node(int val){
        this.val = val;
    }
        }
public class LinkedLIst {
    public Node head;
    //删除重复节点
    public Node removeSameNode(){
        Node newHead = new Node(-1);
        Node tmp = newHead;
        Node cur = this.head;
        if (this.head == null){
            return null;
        }
        while(cur != null){
            if (cur.next != null&& cur.val == cur.next.val){
                while(cur.next != null&& cur.val == cur.next.val){
                    cur = cur.next;
                }
            }else{
                tmp.next = cur;
                tmp = tmp.next;
            }
            cur = cur .next;
        }
        tmp.next = null;
        return newHead;
    }
    //链表分割
    public Node partition(int x){
        if (this.head == null){
            return null;
        }
        Node cur = this.head;
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        while(cur != null){
            if (cur.val < x){
                if (bs == null){
                    bs = cur;
                    be = cur;
                }else{
                    be.next = cur;
                }
            }else{
                if (as == null){
                    as = cur;
                    ae = cur;
                }else{
                    ae.next = cur;
                }
            }
            cur = cur.next;
        }
        if (bs == null){
            return as;
        }
        if (as != null){
            ae.next = null;
        }
        be.next = as;
        return as;

    }
    //合并两个有序链表
    public Node mergeList(Node headA,Node headB){
        Node newHead = new Node(-10);
        Node tmp = newHead;
        while(headA !=null && headB != null);{
            if (headA.val < headB.val){
                tmp.next = headA;
                headA = headA.next;
                tmp = tmp.next;
            }else{
                tmp.next = headB;
                headB = headB.next;
                tmp = tmp.next;
            }
        }
        if (headA != null){
            tmp.next = headA;
        }else{
            tmp.next = headB;
        }
        return newHead;
    }
    //输出倒数第N个节点
    public Node searchNode(int N){
        Node fast = this.head;
        Node slow = this.head;
        if (this.head == null){
            return null;
        }
        if (N <= 0){
            return null;
        }
        int count = 0;
        while(count != N-1){
            if (fast.next == null) {
                return null;
            }else{
                fast = fast.next;
                count++;
            }
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    //返回中间节点
    public Node middle(){
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //翻转单链表
    public Node reserveList(){
        Node prev = null;
        Node cur = this.head;
        Node curNext = this.head.next;
        while(cur != null){
            cur.next = prev;
            prev =cur;
            cur = curNext;
            curNext = curNext.next;
        }
        return prev;
    }
    //删除出现过的N
    public Node removeAllNode(int val){
        if (this.head == null){
            return null;
        }
        Node prev = this.head;
        Node cur  = this.head.next;
        while(cur != null){
            if (cur.val == val){
                prev.next = cur.next;
            }else{
                prev = cur;
            }
            cur = cur.next;
        }
        if (this.head.val == val){
            this.head = this.head.next;
        }
        return this.head;

    }
}
