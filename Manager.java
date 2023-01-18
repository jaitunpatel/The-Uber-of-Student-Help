/*----------------------------------------------------
CLASS : Manager
AUTHOR : Jaitun Patel (7920394)

PURPOSE : This class will implement the file reading and
          process commands from the input file
-------------------------------------------------------*/
//java library
import java.io.*;
import java.util.*;

public class Manager {
    //create student and tutor lists
    private  List tutorList;
    private  List studentList;
    //constructor that initiates the lists
    public Manager(){
        tutorList=new List();
        studentList=new List();
    } 

    //this method will tells about the request made by student for tutoring
    private void createRequest(String[] str){
        //only process this request if the student exists
        if(studentList.search(str[1]) != null){
            //create a request for tutoring
            Request newReq = new Request(str[2],Integer.parseInt(str[3]));
            Parent sList = studentList.search(str[1]);
            //check if it is the reference of that tutor object
            if(sList instanceof Student){ 
                boolean bool = newReq.doRequest((Student)sList,studentList,tutorList); 
            } 
        }
        else{
            System.out.println("Student "+str[1] + " not found.");
        }
    }

    //this method will create tutor with user id 
    private void createTutor(String[] arr){
        boolean check = tutorList.insert(new Tutor(arr[1],Integer.parseInt(arr[2])));
        //if condition will check so that duplicate entries are avoided
        if(check){
            System.out.println("Tutor with userID "+arr[1]+" successfully created.");
        }
        else{
            System.out.println("Duplicate Tutor with userID "+ arr[1]+".");
        }
    }

    //this method will specifies that a tutor can tutor in a specified topic
    private void createTopic(String[] arr){
        //if condition will check so that duplicate entries are avoided
        if(tutorList.search(arr[2])!=null){
            Parent refId = tutorList.search(arr[2]);
            //check if it is the reference of that tutor object
            if(refId instanceof Tutor){
                ((Tutor) refId).add(new Topic(arr[1],Integer.parseInt(arr[3])));
            }
        }
        else{
            System.out.println("Tutor "+arr[2] +" not found.");
        }
    }

    //this method will create student with user id 
    private void createStudent(String[] arr){
        boolean bool = studentList.insert(new Student(arr[1]));
        //if condition will check so that duplicate entries are avoided
        if(bool){
            System.out.println("Student with userID "+arr[1]+" successfully created.");
        }
        else{
            System.out.println("Duplicate Student with userid "+ arr[1]+".");
        }
    }

    //this method will print the entire report of student including appointments, total cost and hours assigned
    private void printStudentReport(String[] str){
        //only process this request if the student exists
        if(studentList.search(str[1])!=null){
            Parent refStudent = studentList.search(str[1]);
            //check if it is the reference of that tutor object
            if(refStudent instanceof Student){
                ((Student) refStudent).print();
            }
        }
        else{
            System.out.println("Student "+str[1] +" not found.");
        }
    }

    //this method will print the entire report of tutor including appointments, total cost and hours assigned
    private void printTutorReport(String[] arr){
        //only process this request if the tutor exists
        if(tutorList.search(arr[1])!=null){
            Parent refTutor = tutorList.search(arr[1]);
            //check if it is the reference of that tutor object
            if(refTutor instanceof Tutor){ 
                ((Tutor) refTutor).print();
            }
        } 
        else{
            System.out.println("Tutor "+arr[1] +" not found.");
        }
    }
    
    //this method will read the input file line by line and throws exception if anything goes wrong with it
    public void ReadFile() { 
        // scanner class for user input
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the input file name with extension (.txt files only):");
        String str = scan.next();
        //create a file
        File inputFile = new File(str);
        try{
            //initialise the objects for fileReading
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                if(!line.startsWith("#")){
                    String[] arr = line.split(" +",10);
                    callCommand(arr);
                }
                //read next line
                line = br.readLine();
            }   
            fr.close();
        }
        catch (Exception e){
            System.out.println("SOMETHING GOES WEIRD !");
            e.printStackTrace();
        } 
    }

    //this method will call diffrent commands from the input file
    private void callCommand(String[] str){
        if(str[0].equals("TUTOR")){
            createTutor(str);//create tutor with user id
        }
        else if(str[0].equals("STUDENT")){
            createStudent(str);//create tutor with user id
        }
        else if(str[0].equals("TOPIC")){
            createTopic(str);//create topic with tutor id and price
        }
        else if(str[0].equals("REQUEST")){
            createRequest(str);//create request for tutoring made by student
        }
        else if(str[0].equals("STUDENTREPORT")){
            printStudentReport(str);//print the full report for student
        }
        else if(str[0].equals("TUTORREPORT")){
            printTutorReport(str);//print the full report for tutor
        }
        else if(str[0].equals("QUIT")){
            System.out.println("BYE");
            System.exit(0);
        }
    }
}
