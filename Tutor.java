/*----------------------------------------------------
CLASS : Tutor
AUTHOR : Jaitun Patel (7920394)
PURPOSE : Holds all the data of Tutor
-------------------------------------------------------*/
public class Tutor extends Parent {
    //instance variables
    private int numHours;
    private String id;
    //requests executed by tutor
    private List tutorReport=new List();
    List sAppointment=new List();
    List allReport=new List();
    private int offerHours=0;
    //Constructor
    public Tutor(String id, int hours){
        this.id=id;
        this.numHours=hours;
    }

    //set number of hours offered to student
    public void setOfferHours(int hoursOffered){
        this.offerHours = hoursOffered;
    }

    //get the user id
    public String getUserId(){
        return id;
    }

    //get number of hours offered to students
    public int getOfferHours(){
        return offerHours;
    }

    //this method will return the topic that are taught
    public List getTopicTaught() {
        return tutorReport;
    }

    //get the number of hours
    public int getHours(){
        return numHours;
    }

    //this method will check if the topic already exist in the tutor topiclist
    public boolean checkTopic(String name){
        boolean bool = false;
        if(tutorReport.search(name)!=null){
            bool=true;
        }
        return bool;
    }

    //this method will add topics in the topiclist of tutor
    public void add(Topic refTopic){
        if(tutorReport.search(refTopic.getUserId())==null){
            tutorReport.insert(refTopic);
            System.out.println("Topic "+ refTopic.getUserId()+ " added to Tutor "+ this.getUserId()+ " with price "
                + refTopic.getPrice());
        }else{
            System.out.println("Duplicate topic "+ refTopic.getUserId()+" for Tutor "+ id);
        }
    }

    //this method will make sure that the number of hours are offered within desire range
    public void calculateHours(int hours){
        if(numHours >= hours){
            numHours = numHours-hours;
        } 
    } 

    @Override 
    public boolean equals(String str){
        boolean bool = false;
        if(id.equals(str)){
            bool=true;
        }
        return bool;
    }

    //this method will print the complete report for tutor
    public void print(){
        int count = 0;
        int counter = 0;
        String str = "";
        List.loopThrough l = allReport.loop();
        String first = "Report for Student "+id+"\n-------------------------------------\n";
        while(l.hasNext()){
            PrintReport currReport=(PrintReport)l.next();
            count = count + currReport.getTotalHours();
            counter = counter + currReport.calculateCost();
            str = str + currReport.printStudentReport();
        }
        String last = "Total number of hours of tutoring: "+count+"\n"+"Total cost of tutoring: "+counter+"\n"
            +"-------------------------------------\n";
        System.out.println(first+str+last);    }
}

