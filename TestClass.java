/*----------------------------------------------------
Class: Test
Name: Jaitun Patel(7920394)
Purpose: Test the project using Junit Testing libraries
------------------------------------------------------*/
//import JUnit testing libraries
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//this class will contains the methods to test data structure and classes
public class TestClass
{
    //test inserting tutor in the list
    @Test
    public void testData(){
        //create a list
        List newList = new List();
        //create data of different datatypes
        Tutor tutor = new Tutor("Ali", 35);
        Tutor newTutor = new Tutor("Olivier", 45);
        //insert tutor in the list
        newList.insert(tutor);
        newList.insert(newTutor);
        //test different data methods
        assertEquals(tutor.getUserId(), "Ali");
        assertEquals(newTutor.getUserId(), "Olivier");
        assertNotEquals(newList.getTop(), "Ali");
    }

    //check the edge cases of list
    @Test
    public void testEdgeReq(){
        //create a list
        List newList = new List();
        //create a tutor
        Tutor tutor1 = new Tutor("Ali", 50);
        Tutor tutor2 = new Tutor("Olivier", 40);
        //create a student
        Student s1 = new Student("Jaitun");
        Topic topic1=new Topic("OO is very hard",25);
        //add and insert in the tutor and list respectively
        tutor1.add(topic1);
        newList.insert(tutor1);
        //make sure that the list is created
        assertEquals(0, tutor1.getOfferHours());
        assertNotEquals(50, tutor1.getOfferHours());
    }

    //test topic price method from the list
    @Test
    public void testSearchStudent(){
        //create a topic
        Topic t1 = new Topic("CS", 10);
        Topic t2 = new Topic("CS is load", 30);
        //test to topic price method
        assertEquals(10, t1.getPrice());
        assertEquals(30, t2.getPrice());
        assertNotEquals(10, t2.getPrice());
    }

    //test check tutor from the list
    @Test
    public void testcheckTutor(){
        //create data and insert them
        Tutor data1 = new Tutor("Ali", 25);
        Topic t1 = new Topic("CS", 10);
        data1.add(t1); 
        Tutor data2 = new Tutor("Olivier", 25);
        Topic t2 = new Topic("Segmentation Fault", 10);
        data2.add(t2); 
        //test to search student that are created
        assertTrue(data1.equals("Ali"));
        assertFalse(data1.equals("Olivier"));
        assertTrue(data2.equals("Olivier"));
    }

    //test refData method for tutor from the list

    @Test
    public void testRefDataTutor(){
        Tutor obj1 = new Tutor("Ali", 25);
        Tutor obj2 = new Tutor("Neshati", 25);
        Topic t1 = new Topic("CS",25);
        Topic t2 = new Topic("Segmentation Fault",25);
        //insert topic in the list
        obj1.add(t1);
        obj2.add(t2);
        assertEquals(t1, obj1.getTopicTaught().search("CS"));  
        assertEquals(t2, obj2.getTopicTaught().search("Segmentation Fault")); 
        assertNotEquals(t2, obj2.getTopicTaught().search("CS")); 
    }

    @Test 
    public void testTopicMethod(){
        //create a new topic
        Topic topic = new Topic("name", 20);
        Topic newTopic = new Topic("OO", 150);
        //test if method works
        assertEquals("name", topic.getUserId());
        assertEquals(20, topic.getPrice());
        assertNotEquals("USERID", topic.getUserId());
        assertNotEquals("tutor1", newTopic.getUserId());
        assertNotEquals("OO", topic.getUserId());
    }

    //test calculate hours method for student from the list
    @Test 
    public void testRefDataStudent(){
        //create tutor and topic
        Tutor data1 = new Tutor("Ali", 25);
        Topic t1 = new Topic("CS", 10);
        //calculate hour method
        data1.calculateHours(25);
        assertEquals(0, data1.getHours());
        assertNotEquals(25, data1.getHours());
    }

    //test student methods specifically
    @Test
    public void testStudentMethod(){
        //create new student
        Student newStudent = new Student("Hello");

        //test if the method works
        assertEquals("Hello", newStudent.getUserId());
        assertNotEquals("World", newStudent.getUserId());
        assertNotEquals("new data", newStudent.getUserId());
    }

    //test all data in general
    @Test
    public void testAll(){
        //create a list
        List newList = new List(); 
        Student newStudent = new Student("given id");
        Tutor newTutor = new Tutor("user id", 25);
        //insert in the list
        newList.insert(newStudent);
        newList.insert(newTutor);

        assertNotEquals(newStudent, newStudent.getUserId());
        assertEquals("given id", newStudent.getUserId());
    }

    @Test
    public void testSearch(){
        //create a list
        List newList = new List();
        Tutor obj1 = new Tutor("Ali", 25);
        Tutor obj2 = new Tutor("Olivier", 25);
        //insert in the list
        newList.insert(obj1);
        newList.insert(obj2);
        assertEquals(obj1, newList.search("Ali"));
        assertEquals(obj2, newList.search("Olivier"));
    }
}
