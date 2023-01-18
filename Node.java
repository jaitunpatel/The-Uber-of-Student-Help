/*----------------------------------------------------
    CLASS : Node
    AUTHOR : Jaitun Patel (7920394)
    PURPOSE : CONTAINS THE DATA WITH THE POINTER TO THE NEXT OBJECT
 -------------------------------------------------------*/
public class Node {
    //instance variables
    private Parent data;
    private Node next;

    //constructor
    public Node(Parent newData, Node newNext){
        data = newData;
        next = newNext;
    }

    //retrieve the data
    public Parent getData(){
        return data;
    }

    //get the next pointer of Node
    public Node getNextPointer(){
        return next;
    }

    //get the next pointer of Node
    public void setNextPointer(Node newNext){
        next = newNext;
    }
}

