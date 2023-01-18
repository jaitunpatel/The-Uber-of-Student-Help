/*----------------------------------------------------
CLASS : Student
AUTHOR : Jaitun Patel (7920394)

PURPOSE : Holds all the data of student (studentId and studentReport)
-------------------------------------------------------*/
public class Student extends Parent {
    //request executed by student
    List tAppointment=new List();
    List allReport=new List(); 

    //instance variables
    private String userId;
    private String request;

    //constructor
    public Student(String id){
        userId = id; 
    }

    //get the user id
    public String getUserId() {
        return userId;
    } 

    public boolean equals(String str){
        boolean bool = false;
        if (userId.equals(str)){
            bool = true;
        }
        return bool;
    }

    //prints the report of student
    public void print(){
        int count = 0;
        int counter = 0;
        String str = "";
        List.loopThrough l = allReport.loop();
        String first = "Report for Student "+userId+"\n-------------------------------------\n";
        while(l.hasNext()){
            PrintReport currReport=(PrintReport)l.next();
            count = count + currReport.getTotalHours();
            counter = counter + currReport.calculateCost();
            str = str + currReport.printStudentReport();
        }
        String last = "Total number of hours of tutoring: "+count+"\n"+"Total cost of tutoring: "+counter+"\n"
            +"-------------------------------------\n";
        System.out.println(first+str+last);
    }
}
