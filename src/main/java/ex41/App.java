package ex41;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Caitlin Fabian
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    // This method is void. It scans in the file and counts to see how many lines are present
    static void readFile(){
        int count = 0;
        List<String> names = new ArrayList<String>();
    // A try and catch statement to account for exceptions. It reads in the data from the file into a list
        try{
            File myObj = new File("c:/users/caitl/desktop/exercise41_input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String name = myReader.nextLine();
                names.add(name);
                count++;
            }
        myReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Calling the functions to sort and write the list into a file
        List<String> sorted = sorting(names);
        writingToFile(sorted, count);

    }
    // This method sorts the names by last name
    static List<String> sorting(List<String> names){
        Collections.sort(names);
        return names;
    }
    static void writingToFile(List<String> names, int count) {

        // Creates a new file, writes the new data in it.
        try {
            File output = new File("exercise41_output.txt");

            output.createNewFile();
            PrintWriter writer = new PrintWriter("exercise41_output.txt");
            writer.printf("Total of %d workers\n", count);
            writer.println("-------------------");
            for(String str: names) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        }
        // Checks for exceptions/ errors
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Calls the first function.
    public static void main(String[] args) {
        readFile();

    }
}
