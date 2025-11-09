class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null ;

        Node current = head;
        while(current != null){
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        } 
        current = head ;
        while (current != null){
            if (current.random != null){
                current.next.random = current.random.next ;
            }
            current = current.next.next;
        }
        current = head;
        Node dummy = new Node(0);
        Node copy = dummy ;

        while (current != null) {
            copy.next = current.next;
            current.next = current.next.next;
            current = current.next;
            copy = copy.next;
        }
        return dummy.next ;
    }
}
