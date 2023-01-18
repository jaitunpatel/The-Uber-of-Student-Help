/*----------------------------------------------------
CLASS : PrintReport
AUTHOR : Jaitun Patel (7920394)

PURPOSE : This class will will print the full report of both student and tutor
          including number of hours and price per hour
-------------------------------------------------------*/
public class PrintReport extends Parent {
    //instance variables
    private  int totalHours;
    private Tutor tutor;
    private Student student;
    private int cost;
    private Topic topic;

    //constructor
    public PrintReport(Tutor tutor,Student student, Topic topic, int hours){
        this.tutor=tutor;
        this.student=student;
        this.topic=topic;
        totalHours=hours;
    }

    //get the available tutor
    public Tutor getTutor() {
        return tutor;
    } 

    //get the total number of hours offered
    public int getTotalHours() {
        return totalHours;
    }

    @Override
    public String getUserId(){
        return "";
    }

    @Override
    public boolean equals(String obj){
        return false;
    }

    //this method will calculate the total cost of providing tutoring
    public int calculateCost(){
        cost=(topic.getPrice() * totalHours);
        return cost;
    }

    //this method will print the full report of student
    public String printStudentReport(){
        return "Appointment: Tutor: "+tutor.getUserId()+", topic: "+topic.getUserId()+", hours: "
        +totalHours+", total cost: "+calculateCost()+"\n";
    }

    //this method will print the full report of tutor
    public String printTutorReport(){
        return "Appointment: Student: "+student.getUserId()+", topic: "+topic.getUserId()+", hours: "
        +totalHours+", total Revenue: "+calculateCost()+"\n";
    }
}
