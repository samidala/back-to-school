package arrays;

public class LongestPalindromeSubStrRepresentedLinLinkedList {

    static Node newNode(int key)
    {
        Node temp = new Node();
        temp.data = key;
        return temp;
    }

    public static void main(String[] args) {
      //  findLongestPalidromeTest();
        findLoopTest();
    }

    static void findLoopTest(){

        Node head = newNode(50);
        head.next = newNode(20);
        head.next.next = newNode(15);
        head.next.next.next = newNode(120);
        head.next.next.next.next = head.next.next;
        findLoop(head);

    }
    static void findLongestPalidromeTest(){
               /* Let us create a linked lists to test
    the functions
    Created list is a: 2->4->3->4->2->15 */

        Node head = newNode(2);
        head.next = newNode(4);
        head.next.next = newNode(3);
        head.next.next.next = newNode(4);
        head.next.next.next.next = newNode(2);
        head.next.next.next.next.next = newNode(15);
        findLongestPalindrome(head);
    }
    private static class Node{
        Node next;
        int data;

    }

    static void findLoop(Node head){

        Node slow = head;
        Node fast = head.next;
        Node prev = null;
        while (fast != null && fast.next != null && fast != slow){
            prev = fast;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == slow){
            System.out.println("YES");
            System.out.println(fast.data);
            System.out.println("prev "+prev.data);
        }else {
            System.out.println("NO");
        }


    }



    static void findLongestPalindrome(Node head){

        Node current = head;
        Node prev = null;
        int result = 0;
        /**
         *  2->4->3->4->2->15
         */

        while (current != null){
            Node next = current.next;
            current.next = prev;
            result = Math.max(result, 2 * countCommon(prev,next) + 1);
            result = Math.max(result, 2 * countCommon(current,next));

            prev = current;
            current = next;
        }

        /**
         * 1.
         * current  = 2
         * next = 4
         * prev = null
         * result = 1
         * prev = 2
         * current = 4
         *
         * 2.
         * current = 4
         * next = 3
         * prev = 2
         *
         *
         *
         */
        System.out.println("maxLen "+result);

    }
    static int countCommon(Node a, Node b){
        int count = 0;
        while (a != null && b != null && a.data == b.data) {
            count++;
            a = a.next;
            b = b.next;
        }
        return count;

    }
}
