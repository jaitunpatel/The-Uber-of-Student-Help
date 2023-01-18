/*----------------------------------------------------
CLASS : Request
AUTHOR : Jaitun Patel (7920394)
PURPOSE : Contains method so that student can make request for tutoring
-------------------------------------------------------*/
public class Request {
    //request madde by student
    private List reqTutor=new List();
    //instance variables
    private String topicReq;
    private  int hourReq;

    //constructor
    public Request(String req, int hours){
        topicReq = req;
        hourReq = hours;
    }

    //this method will create a request and will assign tutor based on avilability and low price
    public boolean doRequest(Student refStudent,List stuList,List tList){
        boolean bool = false; 
        if (stuList.search(refStudent.getUserId()) != null){
            List checkTutor = getATutor(tList);
            System.out.println("Attempting to fulfil request for " + refStudent.getUserId() + " to receive " + hourReq 
                + " hours of tutoring" +" in topic " + topicReq + ".");
            boolean check = false;
            if (!edgeCase(checkTutor)){
                while (!check){
                    Tutor get = getCheapTutor(checkTutor);
                    if (get != null){
                        check = update(get, refStudent);
                        reqTutor.insert(get);
                        checkTutor = getATutor(tList);
                        bool = true;
                    }
                    System.out.println("Tutor " + get.getUserId() + " will tutor " + refStudent.getUserId()
                        + " for " + get.getOfferHours() + " hours in " + topicReq +
                        " at a rate of " + ((Topic) get.getTopicTaught().search(topicReq)).getPrice());
                }
            }
            else{ 
                System.out.println("No tutors available for Student " + refStudent.getUserId() + " for " + hourReq 
                    + " hours in topic " + topicReq + ".");
            }
        }
        else{ 
            System.out.println("Student " + refStudent.getUserId() + " not found.");
        }
        return bool;  
    }
    
    //this method will find the cheapest tutor
    public Tutor getCheapTutor(List newTutor){
        List.loopThrough l = newTutor.loop();
        int price = 1000;
        Tutor cheap = null;
        while(l.hasNext()){
            Tutor available= (Tutor)l.next();
            Topic request = (Topic) available.getTopicTaught().search(topicReq);
            if(price > request.getPrice()){
                price=request.getPrice();
                cheap = available;
            }
            else if(price == request.getPrice()){
                if(available.getHours() > cheap.getHours()){
                    cheap=available;
                }
                else if(cheap.getHours() == available.getHours()){
                    //the if condition will check user id if tutor have same hours
                    if(cheap.getUserId().compareTo(available.getUserId()) > 0 ){
                        cheap=available;
                    }
                }
            }
        }
        return cheap;
    }

    //this method will process the tutor info and update the method
    public boolean update(Tutor select, Student newStudent){
        boolean bool = false; 
        int offer = 0;
        //the if condition will check when the hours are more than student requested
        if(hourReq < select.getHours()){
            select.calculateHours(hourReq);
            offer= hourReq;
            hourReq = 0;
            bool=true;
        }
        //the if condition will check when the hours are less than student requested
        else if(hourReq > select.getHours()){
            hourReq = hourReq - select.getHours();
            offer=select.getHours();
            if(hourReq ==0){
                bool=true;
            }
            select.calculateHours(offer);
        }
        else{
            hourReq = hourReq - select.getHours();
            offer = select.getHours();
            select.calculateHours(offer);
            bool=true;
        }
        select.setOfferHours(offer);
        Topic refTopic = (Topic)select.getTopicTaught().search(topicReq);
        PrintReport report = new PrintReport(select,newStudent,refTopic,offer);
        //add into tutor 
        select.sAppointment.insert(newStudent);
        select.allReport.insert(report);
        //add into student
        newStudent.tAppointment.insert(select);
        newStudent.allReport.insert(report);
        return bool;
    }

    //this method will get the available tutor
    public List getATutor(List tList){
        List.loopThrough l = tList.loop();
        //create a new list
        List refTutor = new List();
        while(l.hasNext()){
            Tutor tutor = (Tutor)l.next();
            if(tutor.checkTopic(topicReq) && tutor.getHours()!=0){
                refTutor.insert(tutor);
            }
        }
        return  refTutor;
    }

    //this method will check the edge case for request to fail
    public boolean edgeCase(List accesible){
        List.loopThrough l = accesible.loop();
        boolean bool = false;
        int count = 0;
        while(l.hasNext()){
            Tutor temp = (Tutor)l.next();
            count = count + temp.getHours();
        }
        if(hourReq > count){
            bool=true;
        }
        return bool;
    }
}
