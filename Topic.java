/*----------------------------------------------------
    CLASS : Topic
    AUTHOR : Jaitun Patel (7920394)
    
    PURPOSE : Holds all the data of Topic
 -------------------------------------------------------*/
public class Topic extends Parent {
    //instance variables
    private String name;
    private int price;

    //constructor
    public Topic(String name, int price){
        this.name=name;
        this.price=price;
    } 
    
    //get the user id
    public String getUserId(){
        return name;
    }

    //get the price per hour
    public int getPrice(){
        return price;
    }

    public boolean equals(String str){
        boolean found=false;
        if(name.equals(str)){
            found=true;
        }
        return found;
    }
}
