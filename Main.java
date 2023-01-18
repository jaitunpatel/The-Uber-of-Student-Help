/*----------------------------------------------------
    CLASS : Main
    AUTHOR : Jaitun Patel (7920394)

    PURPOSE : Student can make request for tutoring and the 
              program will execute to assign hours avaiable.
 -------------------------------------------------------*/
//java library
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;

// this class will contains method for filereading and produce output  accordingly
public class Main {
    public static void main(String[] args){
        //create manager object to read file and process input commands
        Manager manage= new Manager();
        manage.ReadFile(); 
    } 
}
 