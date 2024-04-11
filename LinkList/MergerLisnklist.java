package LinkList;


class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class MergerLisnklist {
    
    static Node MergerTwoLinklist(Node root1, Node root2){
        Node newLinklist = new Node(-1);
        Node current = newLinklist;
        while (root1 != null  && root2 != null) {
            if(root1.data <= root2.data){
                current.next = root1;
                root1 = root1.next;
            }else{
                current.next = root2;
                root2 = root2.next;
            }
            
            current = current.next;
        }

        if(root1 != null){
            current.next = root1;
        }
        if(root2 != null){
            current.next =root2;
        }

        return newLinklist.next;
    }

   


    static  void printLinkList(Node root){
        Node current = root;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print("NULL");
    }


    public static void main(String[] args) {
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        Node mergedList = MergerTwoLinklist(l1, l2);

     
        System.out.println("Merged List:");
        printLinkList(mergedList);
      
    }
}
