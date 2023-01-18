/*----------------------------------------------------
CLASS : List
AUTHOR : Jaitun Patel (7920394)
PURPOSE : HOLDS THE VARIOUS KIND OF DATA. CREATES A DATA STRUCTURE. MANAGES THE DATA.
-------------------------------------------------------*/
public class List
{
    //variable representing top node of list
    private Node top;
    private int size;
    //initialise through the entire list
    loopThrough l = new loopThrough();
    
    //constructor
    //initializing the head pointer to null
    public List(){
        top = null; 
        size = 0;
    }

    //get the top node of the list
    public Node getTop(){
        return top;
    }

    //method to to check if we had the data in particular list
    public Parent search(String str){
        Parent found = null;
        Node temp = top;
        while(temp != null){
            if(temp.getData().equals(str)){
                found = temp.getData();
            }
            temp = temp.getNextPointer();
        } 
        return found;
    }

    //this method will add data in the list
    public boolean insert(Parent data){
        //check if the data is not null
        if(data != null){
            Node newNode = new Node(data, null);
            newNode.setNextPointer(top);
            top = newNode;
            size++;
            return true; 
        }
        else{
            System.out.println("You are trying to insert data that is NULL!");
            return false;
        }
    }
    //iterate through the list
    public loopThrough loop() {
        return new loopThrough();
    } 

    //helps to iterate through the list.
    public class loopThrough{
        private Node temp; 
        //constructor
        public loopThrough() {
            temp = top;
        }

        //set the loop to top of the node in the list
        public void returnTop(){
            temp = top;
        }

        //check if the loop reaches at the end
        public boolean hasNext(){
            return (temp != null);
        }

        //returns the data at the pointer and increments the pointer
        public Parent next() {
            Parent data = temp.getData();
            temp = temp.getNextPointer();
            return data;
        } 
    }
}

