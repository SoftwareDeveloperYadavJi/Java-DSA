package LinkList;

class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class mergePoint {

    public static Node findMergePoint(Node list1 ,Node list2){
        if(list1 == null || list2 == null){
            return null;
        }

        Node current1 = list1;
        Node current2 = list2;


        while (current1 != current2) {
            if(current1 == null) current1 = list2;
            else current1 = current1.next;

            if(current2 == null)  current2 = list1;
            else current2 = current2.next;

        }

        return current1;

    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(6);
        head1.next.next.next.next = new Node(9);

        Node head2 = new Node(4);
        head2.next = head1.next.next.next; // Connecting head2 to node 6 in head1

        // Find the merge point
        Node mergePoint = findMergePoint(head1, head2);

        if (mergePoint != null)
            System.out.println("Merge point value: " + mergePoint.data);
        else
            System.out.println("No merge point found");


    }
}
