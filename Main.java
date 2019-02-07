
//Brian Goldenberg
//bgolde2
// bgolde2@uic.edu
//The purpose of this project is to implement a stack and Queue. It uses both abstract and normal
// classes. add and delete can be done to both the stack and Queue.


public class Main {

    public static void main(String[] args) {

       int hold =1;
        GenericStack test = new GenericStack(hold);
        test.pop();
        test.push(21);
        test.push(43);
        test.print();

        //---------------

        System.out.println("Starting tests for que");
        GenericQueue bob = new GenericQueue(1);
        bob.dequeue();
        bob.enqueue(64);
        //bob.print();
        bob.enqueue(1272);
        bob.print();

        //bob.pop();
        //test.push(2);
        //test.push(3);
        //system.out store = test.pop();
      //  test.print();
        //System.out.println("Did this work " + test.pop());


    }
}
//Begininng of abstract class
abstract class GenericList<I>
{
    //subclass for Node
    public class Node<T>
    {
        //Data memmebrs within theNode
        public T data;
        public Node<T> next;
        //Contructors
        public Node(T temp)
        {
            data = temp;
            next = null;
        }
        public Node(T temp, Node temp1)
        {
            data = temp;
            next = temp1;
        }
    }
    //Data members of GenericList
    public Node<I> head;
    private int length;
    //Methods to increase and decrease length
    public void increaseLength()
    {
        length++;
        return;
    }
    public void decreaseLength()
    {
        length--;
        return;
    }
    //Method to attain length
    public int giveLength()
    {
        return length;
    }
    //Method to print out list
    public void print()
    {
        if(head == null) //Checks of list is empty
        {
            System.out.println("The list is empty.");
            return;
        }
        Node<I> temp = head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
        return;
    }
    //abstract method to add changes depending on list type
    public abstract void add(I hold);
    //method to delete node
    public I delete()
    {
        if(head == null)    //Checks of list is empty
        {
            System.out.println("The list is empty.");
            return null;
        }
        Node<I> oldHead = head;
        I oldData = oldHead.data;

        head = head.next; //Reasigns head
        length--;
        return oldData; //returns data of old head

    }
    //public add(l data);

}

//GenericQuiue class
class GenericQueue<I> extends GenericList<I>
{
    public GenericQueue(I temp) //Contructor
    {
        Node newHead = new Node(temp,null);
       // head.data = temp;
        //head.next = null;
        head = newHead;
        increaseLength();
    }

    //Implementation of add method
    @Override
    public void add(I temp2)
    {

        Node newNode = new Node(temp2);
        if(head==null)
        {
            newNode.next = null;
            head = newNode;
            increaseLength();
            return;
        }
        //newNode.data = temp2;
        //newNode.next = null;
        Node temp1 = head;
        while(temp1.next!=null) //while loop to get to the end of the list
        {
            temp1 = temp1.next;
        }
        temp1.next = newNode;
        increaseLength();
        return;
    }
    //Method to add to the end of the list
public void enqueue(I data)
{
    add(data);
    return;
}
//Method to delete from the list
public I dequeue()
{
    return delete();
}


}

//GenericStack class
class GenericStack<I> extends GenericList<I>
{
    //Constructor for class
    public GenericStack(I temp)
    {
        Node newHead = new Node(temp,null);
        head = newHead;
        //head.data = temp;
        //head.next = null;
        increaseLength();
    }

    //Implementation of the add method
    @Override
    public void add(I temp1)
    {
       Node newHead = new Node(temp1, head);
       //newHead.data = temp1;
        //newHead.next = head;
        head = newHead;
        increaseLength();
        return;
    }
    //method to add to stack
    public void push(I data)
    {
        add(data);
        return;
    }
    //mothod to delete from stack
    public I pop()
    {
        return delete();
    }
}

