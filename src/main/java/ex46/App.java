package ex46;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Caitlin Fabian
 */

class Content{
    private String text;

    public Content(String text){
        this.text = text;
    }
    public String[] splitString(){
        String[] array = text.split(" ");
        return array;
    }
}

public class App {

    // Reads in the file and appends all the lines together
    public static String readFile() throws IOException {

        StringBuilder sb = new StringBuilder();

        File myobj = new File("C:/users/caitl/desktop/exercise46_input.txt");
        Scanner reader = new Scanner(myobj);

        while (reader.hasNextLine()) {

            String line = reader.nextLine();
            sb.append(line);
        }

        return sb.toString();
    }
   // Counts the words in the array
    public static int wordCounter(String[] array, String word){
        int count = 0;
        for(int i = 0; i< array.length; i++){
            if(word.equals(array[i])){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) throws IOException {

        String content = readFile();
        Content text = new Content(content);
        String[] array = text.splitString();
        // String array that contains the names in the text
        String counter[] = {"badger", "mushroom", "snake"};
        int[] numbers= new int[3];
        // wordCounter returns the amount of time a word is said.
        // It is assigned to am array.
       for(int i = 0; i<3;i++) {
           int count = wordCounter(array, counter[i]);
           numbers[i] = count;
       }
       // Prints out the String in a table format
       for(int i= 0; i< 3; i++){
           System.out.printf("%s:", counter[i]);
           for(int j = numbers[i]; j>0; j--) {
               System.out.print("*");
           }
           System.out.print("\n");
       }

    }

}
