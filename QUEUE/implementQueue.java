package QUEUE;


class CircularQueue{
    private int [] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int k){
        queue = new int[k];
        front = 0;
        rear = -1;
        size = 0;
        capacity = k;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public void enqueue(int value){
        if(!isFull()){
            rear = (rear + 1) % capacity;
            queue[rear] = value;
            size++;
        }else{
            System.out.println("Queue is full. Unable to insert");
        }

    }

    public int dequeue(){
        if(!isEmpty()){
            int value = queue[front];
            front = (front + 1) % capacity;
            size--;
            return value;
        }else{
            System.out.println("Queue is empty. Cannot dequeue");
            return -1;
        }
    }

    public int front(){
        if(!isEmpty()){
            return queue[front];
        }else{
            System.out.println("Queue is Empty. Nofrount element");
            return -1;
        }

    }


    public int rear(){
        if(!isEmpty()){
            return queue[rear];
        }else{
            System.out.println("Queue is empty. No rear element");
            return -1;
        }
    }


}



public class implementQueue {

    public static void main(String[] args) {
        
        CircularQueue cq = new CircularQueue(5);

        // Enqueue elements
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);

        // Display front and rear elements
        System.out.println("Front element: " + cq.front()); // Output: 1
        System.out.println("Rear element: " + cq.rear());   // Output: 3

        // Dequeue an element
        System.out.println("Dequeued element: " + cq.dequeue()); // Output: 1

        // Enqueue more elements
        cq.enqueue(4);
        cq.enqueue(5);

        // Try to enqueue when queue is full
        cq.enqueue(6); // Output: Queue is full. Cannot enqueue 6

        // Display front and rear elements after dequeue and enqueue
        System.out.println("Front element: " + cq.front()); // Output: 2
        System.out.println("Rear element: " + cq.rear());   // Output: 6
    }
    
}
