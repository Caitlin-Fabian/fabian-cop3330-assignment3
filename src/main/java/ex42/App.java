package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Caitlin Fabian
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

// This class holds the variables and the methods of those variables
class Person{
    private String last;
    private String first;
    private int salary;

    public Person(String last, String first, int salary){
        this.last= last;
        this.first = first;
        this.salary = salary;
    }
    public String getlast()
    {
        return (last);
    }
    public String getfirst(){
        return first;
    }
    public int getSalary(){
        return salary;
    }

}
public class App {
    // Reads in the file and organizes the data into last name, first name and salary.
    static List<Person> readFile() {
        // Holds the list of people
        List<Person> list = new ArrayList<>();
        try {
            // Reads in the file with BufferReader
            BufferedReader br = new BufferedReader(new FileReader("c:/users/caitl/desktop/exercise42_input.txt"));
            String fileRead = br.readLine();

            // While there is still more lines in the file, the file is split into last name,
            // first name and salary. It is then stored as an object Person.
            while (fileRead != null) {
                String[] names = fileRead.split(",");
                String tempLast = names[0];
                String tempFirst = names[1];
                int tempSalary = Integer.parseInt(names[2]);
                // Creates a new person with the data
                Person tempPerson = new Person(tempLast, tempFirst, tempSalary);
                // Adds the person to a list
                list.add(tempPerson);
                fileRead = br.readLine();
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void main(String[] args) {
        // Calling the readFile
        List<Person> list = readFile();
        String heading = "Last      First     Salary";
        System.out.println(heading);
        System.out.println("-------------------------");
        // For loop that prints out the table of people in correct order
        for (Person var : list) {
            System.out.printf("%-10s%-10s%d\n", var.getlast(), var.getfirst(), var.getSalary());
        }
    }
}

